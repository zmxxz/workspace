package com.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Resultset {
	@Test
	public void testresultset() throws Exception{
		//ͨ��resultset��ѯ���ݿ�
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "select deptno,dname,loc "
					+ "from dept";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int num = rs.getInt("deptno");
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				System.out.println(num+"-"+dname+"-"+loc);
			}
			
		
	}
	
		public Connection getConnection() throws Exception{
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
