package com.postgres.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class PostgreSQLJDBC {
	String  name;
	public String getData() {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://10.8.100.30:5432/feedbackdb",
            "root", "root");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM feedback_schema.feedback;" );
         while ( rs.next() ) {
            name = rs.getString("username");
            
            System.out.println( "Name = " + name );
            
            System.out.println();
            System.out.println("Operation done successfully");
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
         return e.getClass().getName();
      }
      
	return name;
   }
}
