package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class TestConnection {
	@Test
	public void test() throws IOException{
		Properties mysqlProperties = new Properties();
		FileInputStream in = new FileInputStream(TestProperty.class.getResource("/mysql.properties").getPath());
		mysqlProperties.load(in);
		
		String drivers = mysqlProperties.getProperty("jdbc.drivers");

		System.setProperty("jdbc.drivers", drivers);
		
		String url = mysqlProperties.getProperty("jdbc.url");
		String username = mysqlProperties.getProperty("jdbc.username");
		String password = mysqlProperties.getProperty("jdbc.password");		
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			conn.close();
			System.out.println(conn);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
