package com.tca.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class IdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        /*
        Random random = new Random();
        return "TCA"
                + random.nextInt(9)
                + random.nextInt(9)
                + random.nextInt(9)
                + random.nextInt(9);
         */

        Connection con = null;
        try{
            String prefix = "TCA-";
            con = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();

            try(Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("SELECT nextval(student_seq)");
            ){
                long val = 0;
                if(rs.next()){
                    val = rs.getLong(1);
                    return prefix + val;
                }
            }
        }
        catch (SQLException se){
            throw new RuntimeException("Unable to form database connection.");
        }
        finally{
            if(con != null){
                try{
                    sharedSessionContractImplementor.getJdbcConnectionAccess().releaseConnection(con);
                }
                catch (Exception e) {
                    throw new RuntimeException("Unable to form database connection.");
                }
            }
        }
        return null;
    }
}
