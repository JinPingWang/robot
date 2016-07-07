package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestProperty {
	
	@Test
	public void Test() throws IOException {
		// TODO Auto-generated method stub
		/**
		 * Properties是继承Hashtable的，所以是线程安全的
		 * 第一类方法是继承而来的put与get方法，参数与返回值是Object类型
		 * 第二类是类中实现的setProperty与getproperty(本质上也是调用put与get方法)，参数与返回值是String
		 */
		Properties propertiesOut = new Properties();
		propertiesOut.put("jdbc.drivers", "com.mysql.jdbc.Driver");
		propertiesOut.put("jdbc.url", "jdbc:mysql://192.168.91.201:3306/robot");
		propertiesOut.put("jdbc.username", "robot");
		propertiesOut.put("jdbc.password", "robot");
		FileOutputStream out = new FileOutputStream(TestProperty.class.getResource("/mysql.properties").getPath());
		propertiesOut.store(out, "mysql.properties");
		
		Properties propertiesIn = new Properties();
		FileInputStream in = new FileInputStream(TestProperty.class.getResource("/mysql.properties").getPath());
		propertiesIn.load(in);
		System.out.println(propertiesIn.get("jdbc.drivers"));
		System.out.println(propertiesIn.get("jdbc.url"));
		System.out.println(propertiesIn.get("jdbc.username"));
		System.out.println(propertiesIn.get("jdbc.password"));
	}
}
