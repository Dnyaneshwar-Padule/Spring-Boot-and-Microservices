package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context =   SpringApplication.run(Application.class, args);

        DataSource dataSource =  context.getBean(DataSource.class);
        Connection con = dataSource.getConnection();
        PreparedStatement ps =  con.prepareStatement("SELECT 'Query Executed' as rs;");
        ResultSet rs =  ps.executeQuery();
        rs.next();
        System.out.println(rs.getString(1));
        System.out.println(con);



    }

    /*
        Repository classes uses JdbcTemplate to perform JDBC operations
        JdbcTemplate provides boilerplate code such as registering Driver class, Closing Connection, Creating connection
        Preparing statements etc....

        JdbcTemplate internally uses DataSource to create connections, datasource has database configuration info....

        RepositoryClass -----> JdbcTemplate -------> DataSource

     */

}
