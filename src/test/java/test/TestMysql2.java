package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class TestMysql2 {
	@Test
	public void test() throws IOException {
		Properties mysqlProperties = new Properties();
		FileInputStream in = new FileInputStream(TestProperty.class.getResource("/mysql.properties").getPath());
		mysqlProperties.load(in);
		
		String drivers = mysqlProperties.getProperty("jdbc.drivers");

		System.setProperty("jdbc.drivers", drivers);
		
		String url = mysqlProperties.getProperty("jdbc.url");
		String username = mysqlProperties.getProperty("jdbc.username");
		String password = mysqlProperties.getProperty("jdbc.password");
		System.out.println(url+"\n"+username+"\n"+password);
		
		try(Connection conn = DriverManager.getConnection(url, username, password);){			
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("select * from robot");
			while(result.next()){
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			}
			
			Statement stat2 = conn.createStatement();
			
			ResultSet result2 = stat.executeQuery("select * from robot");
			while(result2.next()){
				System.out.println(result2.getInt(1)+"\t"+result2.getString(2)+"\t"+result2.getString(3));
			}
			result2.close();
			stat2.close();
			
			result.close();
			stat.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
