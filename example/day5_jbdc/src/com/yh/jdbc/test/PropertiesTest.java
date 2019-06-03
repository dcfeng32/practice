package com.yh.jdbc.test;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		//读取配置文件
		Properties p = new Properties();
		FileInputStream in = new FileInputStream("resource/db.properties");
		p.load(in);
	
		//在计算机磁盘中读取文件，输出
		System.out.println(p.getProperty("url")+"+++"+p.getProperty("user"));
		

	}

}
