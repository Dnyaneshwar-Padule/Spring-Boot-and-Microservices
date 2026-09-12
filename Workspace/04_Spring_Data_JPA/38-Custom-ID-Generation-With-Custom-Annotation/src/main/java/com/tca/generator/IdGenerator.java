package com.tca.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGenerator implements IdentifierGenerator {
    private final String prefix;

    public IdGenerator(TcaId tcaId){
        prefix = tcaId.name();
    }

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Connection con = null;
        try{
            con = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();

            try(Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nextval(student_seq)"); /* mariaDB syntax */
            ){
                long val = 0;
                if(rs.next()){
                    val = rs.getLong(1);
                    return prefix + "-" + val;
                }
            }
        }
        catch (SQLException se){
            throw new RuntimeException("Unable to form database connection: " + se.getMessage() );
        }
        finally{
            if (con != null) {
                try{
                    sharedSessionContractImplementor.getJdbcConnectionAccess().releaseConnection(con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return null;
    }
}
