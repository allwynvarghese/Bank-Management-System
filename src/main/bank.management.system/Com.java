package main.bank.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Com {

    Connection c;
    Statement s;
    public Com(){

        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "****");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
