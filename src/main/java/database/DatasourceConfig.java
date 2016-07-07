package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DatasourceConfig {
	private List<DatasourceConfigBean> datasourceConfigBeanList;
	
	public DatasourceConfig() throws FileNotFoundException{
		datasourceConfigBeanList = readDatasourceConfig();
	}
	
	public List<DatasourceConfigBean> getDatasourceConfigBeanList(){
		return datasourceConfigBeanList;
	}
	
	/**
	 * 向list中添加一个数据库配置
	 * 如果不存在进行添加，并写回配置文件
	 */
	public void addDatasourceConfigBean(DatasourceConfigBean datasourceConfigBean) throws IOException{
		boolean flag = true;
		for(DatasourceConfigBean temp : datasourceConfigBeanList){
			if(temp.getDatabasePoolName().equals(datasourceConfigBean.getDatabasePoolName())){
				flag = false;
				break;
			}
		}
		if(flag){
			datasourceConfigBeanList.add(datasourceConfigBean);
			writeDatasourceConfig(datasourceConfigBeanList);
		}
		else{
			System.out.println("same databasePoolName in the DatasourceConfigBeanList");
		}
	}
	
	/**
	 * 根据删除list中的一个配置
	 * 如果查到则进行删除，并进行写回配置文件
	 */
	public void removeDatasourceConfigBean(String databasePoolName) throws IOException{
		boolean flag = false;
		for(DatasourceConfigBean temp : datasourceConfigBeanList){
			if(temp.getDatabasePoolName().equals(databasePoolName)){
				datasourceConfigBeanList.remove(temp);
				flag = true;
				break;
			}
		}
		if(flag){
			writeDatasourceConfig(datasourceConfigBeanList);
		}
		else{
			System.out.println("databasePoolName is not in DatasourceConfigBeanList");
		}
	}
	
	private List<DatasourceConfigBean> readDatasourceConfig() throws FileNotFoundException{
		File file = new File(DatasourceConfig.class.getResource("/datasourceConfig.xml").getPath());
		Scanner sc = new Scanner(file);
		String dataSourceConfigBeanListXmlString = "";
		while(sc.hasNextLine()){
			dataSourceConfigBeanListXmlString += sc.nextLine();
		}
		sc.close();
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("List", List.class);
		return (List<DatasourceConfigBean>) xStream.fromXML(dataSourceConfigBeanListXmlString);
	}
	
	private void writeDatasourceConfig(List<DatasourceConfigBean> datasourceConfigBeanList) throws IOException{
		File file = new File(DatasourceConfig.class.getResource("/datasourceConfig.xml").getPath());
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("List", List.class);
		String datasourceConfigBeanListXmlStream = xStream.toXML(datasourceConfigBeanList);
		
		FileOutputStream out = new FileOutputStream(file);
		out.write(datasourceConfigBeanListXmlStream.getBytes(), 0, datasourceConfigBeanListXmlStream.length());
		out.close();
	}
}