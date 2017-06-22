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
		//通过resultset查询数据库
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
