package org.antstudio.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 文件工具类
 * @author Gavin
 * @version 1.0
 * @date 2013-2-18
 */
public class FileUtils {

	/**
	 * 保存文件
	 * @param in
	 * @param path
	 */
	public static void save(InputStream in,File file){
		try{
		if(!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		byte[] data = new byte[10240];
		int length = 0;
		while((length=in.read(data))!=-1){
			out.write(data,0,length);
		}
		out.flush();
		out.close();
		in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取文件后缀名
	 * @param file
	 * @return
	 */
	public static String getExtname(File file){
		String name = file.getName();
		int position = name.lastIndexOf(".");
		if(position!=-1){
			return name.substring(position+1);
		}
		return "";
	}
	
	/**
	 * 获取文件前缀名
	 * @param file
	 * @return
	 */
	public static String getPrefixName(File file){
		String name = file.getName();
		int position = name.lastIndexOf(".");
		if(position!=-1){
			return name.substring(0,position);
		}
		return "";
	}
	
	public static void getFileNotExists(File ){
		
	}
}
