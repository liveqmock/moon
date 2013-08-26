package org.antstudio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.antstudio.moon.test.PropertiesFileTest;

/**
 * 配置文件读取
 * @author Gavin
 * @date 2013-8-21 上午12:00:42
 */
public class PropertiesUtils {

	public static Properties loadPropertiesFile(String filePath) throws FileNotFoundException, IOException{
		Properties p = new Properties();
		if(!filePath.startsWith("/")){
			filePath="/"+filePath;
		}
		URL url = PropertiesFileTest.class.getResource(filePath);
		if(url == null){
			throw new FileNotFoundException(url+" can not found.");
		}
		p.load(new FileInputStream(url.getFile()));
		return p;
	}
	
	public static Properties loadPropertiesFileIfExist(String filePath){
		try {
			return loadPropertiesFile(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("文件"+filePath+"不存在,不进行加载.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Properties();
	}
}
