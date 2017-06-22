package com.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Teststmt {
	@Test
	public void testStatement() throws Exception{
//		Connection conn = getConnection2();
//		int num = 80;
//		//String sql = "delete from dept where deptno = 70";
//		String sql = "insert into dept values("+num+','+"'tech'"+','+"'shanghai')";
//		Statement stmt = conn.createStatement();
//		stmt.executeUpdate(sql);
//		stmt.close();
		Connection conn = getConnection2();
		String sql = "insert into tongxun values(12,12,12,12,12)";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public Connection getConnection2() throws Exception{
		//1.准备连接数据库的四个字符串
		//1).创建Properties对象
		Properties properties = new Properties();  
		//2).获取jdbc.properties对应的输入流
		InputStream in = 
				this.getClass().getClassLoader().getResourceAsStream("info.properties");
		//3).加载2）对应的输入流
		properties.load(in);
		//4).具体决定user等四个字符串
		String user  = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");
		//2.加载数据库驱动程序
		Class.forName(driver);
		//3.通过driverManager的getconnection()方法获取数据库连接
		return DriverManager.getConnection(jdbcUrl,user,password);
	}
}
