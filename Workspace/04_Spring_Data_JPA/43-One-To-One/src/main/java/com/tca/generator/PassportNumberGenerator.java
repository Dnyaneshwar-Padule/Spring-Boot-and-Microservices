package com.tca.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.EntityPersister;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassportNumberGenerator implements IdentifierGenerator {

    private final SecureRandom random = new SecureRandom();
    private static final String LETTERS = "QWERTYUIOPLKJHGFDSAZXCVBNM";

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {

        String entityName = o.getClass().getName();
        EntityPersister entityPersister = sharedSessionContractImplementor.getEntityPersister(entityName, o);
        String tableName = entityPersister.getMappedTableDetails().getTableName();
        String pkColumnName = ((AbstractEntityPersister) entityPersister).getIdentifierColumnNames()[0];
        int maxTries = 5;

        try {
            Connection con = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();

            for(int i = 0; i < maxTries ; i++){
                String generatedPassportNumber = generatePassportNumber();

                if( ! doesPassportNoExists(con, tableName, pkColumnName, generatedPassportNumber) )
                    return generatedPassportNumber;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    private String generatePassportNumber(){
        char seriesLetter = LETTERS.charAt( random.nextInt(LETTERS.length()) );
        int firstDigit = random.nextInt(9) + 1;
        int lastDigit = random.nextInt(9) + 1;
        StringBuilder middleDigits = new StringBuilder();
        for(int i = 0; i < 6; ++i){
            middleDigits.append(random.nextInt(10));
        }
        return String.format("%c%d%s%d", seriesLetter, firstDigit, middleDigits.toString(), lastDigit);
    }

    private boolean doesPassportNoExists(Connection con, String tableName, String pkColumnName, String generatedPassportNo){
        String sql = "SELECT 1 FROM " + tableName + " WHERE " + pkColumnName + " = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, generatedPassportNo);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new HibernateException("Error checking identity availability on " + tableName + "." + pkColumnName, e);
        }
    }
}
