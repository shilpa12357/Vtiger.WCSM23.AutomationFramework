package Testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseTest {

	public static void main(String[] args) throws SQLException {
    Driver dref=new Driver();
    DriverManager.registerDriver(dref);
    
    
    Connection con = DriverManager.getConnection("jdbc : mysql ://localhost:3306/sonoo","root","root");
    Statement stat = con.createStatement();
    String query="select * from project";
    ResultSet res = stat.executeQuery(query);
    while(res.next()) {
    	System.out.println(res.getString(1));
    }
    con.close();
	}

}
