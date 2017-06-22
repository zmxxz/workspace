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
		//1.׼���������ݿ���ĸ��ַ���
		//1).����Properties����
		Properties properties = new Properties();  
		//2).��ȡjdbc.properties��Ӧ��������
		InputStream in = 
				this.getClass().getClassLoader().getResourceAsStream("info.properties");
		//3).����2����Ӧ��������
		properties.load(in);
		//4).�������user���ĸ��ַ���
		String user  = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");
		//2.�������ݿ���������
		Class.forName(driver);
		//3.ͨ��driverManager��getconnection()������ȡ���ݿ�����
		return DriverManager.getConnection(jdbcUrl,user,password);
	}
}
