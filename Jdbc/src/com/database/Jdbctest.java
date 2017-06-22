package com.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Jdbctest {
	
//	public void update(String sql){
//		Connection conn = null;
//		Statement stmt = null;
//		try{
//			conn = getConnection2();
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	
//	}
	//通jdbc向指定的数据表中添加数据
	public void testStatement() throws Exception{
		Connection conn = getConnection2();
		String sql = "insert into dept(deptno,dname,loc) "
				+ "values('60','service','shanghai')";
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
	@Test
	public void testgetConnection2() throws Exception{
		System.out.println(getConnection2());
	}
//	private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
//	private static final String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:myorcl";
//	private static final String user = "scott";
//	private static final String password = "1234";
	@Test
	public void testDriverManager() throws Exception{
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:myorcl";
		String user = "scott";
		String password = "1234";
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(jdbcUrl,user,password);
		System.out.println(conn);
	}
//	public static  Connection getConnection(){  
//        Connection connection = null;  
//        try {  
//            Class.forName(driverClass);  
//            connection = DriverManager.getConnection(jdbcUrl, user, password);  
//            connection.close();  
//        } catch (ClassNotFoundException e) {  
//            e.printStackTrace();  
//        } catch (SQLException e) {  
//            e.printStackTrace();  
//        }  
//        return connection;  
//    }  
//      
//    // 测试Oracle连接是否成功  
//    public static void main(String[] args) {  
//        Connection connection = Jdbctest.getConnection();  
//        System.out.println("连接成功："+connection);  
//    }  
}
