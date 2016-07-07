package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import database.DatasourceConfig;
import database.DatasourceConfigBean;

public class TestDatasourceConfig {
	@Test
	public void test() throws IOException{
		DatasourceConfig datasourceConfig = new DatasourceConfig();
		DatasourceConfigBean datasourceConfigBeanMysql = new DatasourceConfigBean("Mysql", "MysqlDataSource", 
				"com.mysql.jdbc.Driver", "jdbc:mysql://192.168.91.201:3306/robot", 
				"robot", "robot", 30);
		DatasourceConfigBean datasourceConfigBeanSqlServer =  new DatasourceConfigBean("SqlServer", "SqlServerDataSource", 
				"com.microsoft.sqlserver.jdbc.SQLServerDriver", 
//				"jdbc:sqlserver://192.168.91.201:1433;databaseName=robot;user=robot;password=robot", 
				"jdbc:sqlserver://192.168.91.201:1433;databaseName=robot;",
				"robot", "robot", 30);
		List<DatasourceConfigBean> listBean = new ArrayList<DatasourceConfigBean>();
		listBean.add(datasourceConfigBeanMysql);
		listBean.add(datasourceConfigBeanSqlServer);
//		datasourceConfig.writeDatasourceConfig(listBean);
	}
}
