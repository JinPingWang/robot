package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class TestMysql {
//	@Test
//	public void test() throws IOException {
	public static void main(String argv[]) throws IOException {
		Properties mysqlProperties = new Properties();
		FileInputStream in = new FileInputStream(TestProperty.class.getResource("/mysql.properties").getPath());
		mysqlProperties.load(in);
		
		String drivers = mysqlProperties.getProperty("jdbc.drivers");

		System.setProperty("jdbc.drivers", drivers);
		
		String url = mysqlProperties.getProperty("jdbc.url");
		String username = mysqlProperties.getProperty("jdbc.username");
		String password = mysqlProperties.getProperty("jdbc.password");
		System.out.println(url+"\n"+username+"\n"+password);
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			for(int loop=0; loop<1; loop++){
				TestMysqlThread testMysqlThread = new TestMysqlThread(conn);
				Thread t = new Thread(testMysqlThread);
				t.start();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class TestMysqlThread implements Runnable{
	Connection conn;
	
	public TestMysqlThread(Connection conn){
		this.conn = conn;
	}
	public void run(){
		try{
			Statement stat = conn.createStatement();
			String id = "1";
			System.out.println(stat.executeUpdate("update robot set content='哈喽' where id=" + id));
			ResultSet result = stat.executeQuery("select max(id) from robot");
			while(result.next()){
				System.out.println(result.getInt(1));
//				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			}
			result.close();
			stat.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
