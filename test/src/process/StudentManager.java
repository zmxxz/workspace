package process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import ui.UpdateFrame;

public class StudentManager {
	public int updateStudent(String sno, UpdateFrame updateFrame){
		Connection conn=null;
		PreparedStatement pStatement=null;
		String sqlUpdate="update student set sno=?,sname=?,ssex=?,dept=?,grade=?,sage=?,phone=?,address=? "+
				"where sno=?";
		int num=0;
		conn=ConnectionManager.getConnection();
		try {
			pStatement=conn.prepareStatement(sqlUpdate);
			pStatement.setString(1, updateFrame.snoText.getText());
			pStatement.setString(2, updateFrame.snameText.getText());
			pStatement.setString(3, updateFrame.ssexText.getText());
			pStatement.setString(4, updateFrame.deptText.getText());
			pStatement.setString(5, updateFrame.gradeText.getText());
			String ageTemp = updateFrame.sageText.getText();
			int age;
			if(ageTemp.equals("")){
				age=0;
			}else{
				age=Integer.parseInt(ageTemp);
			}
			pStatement.setInt(6, age);
			pStatement.setString(7, updateFrame.phoneText.getText());
			pStatement.setString(8, updateFrame.addressText.getText());
			pStatement.setString(9, updateFrame.snoText.getText());
			num=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public void queryStudent(String sno, UpdateFrame updateFrame){
		Connection conn=null;
		PreparedStatement pStatement=null;
		ResultSet rs=null;
		String sqlQuery="select * from student where sno=?";
		
		conn=ConnectionManager.getConnection();
		try {
			pStatement=conn.prepareStatement(sqlQuery);
			pStatement.setString(1, sno);
			rs=pStatement.executeQuery();
			while(rs.next()){
				updateFrame.snoText.setText(rs.getString("sno"));
				updateFrame.snameText.setText(rs.getString("sname"));
				updateFrame.ssexText.setText(rs.getString("ssex"));
				updateFrame.sageText.setText(rs.getString("sage"));
				updateFrame.deptText.setText(rs.getString("dept"));
				updateFrame.phoneText.setText(rs.getString("phone"));
				updateFrame.addressText.setText(rs.getString("address"));
				updateFrame.gradeText.setText(rs.getString("grade"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.close(conn, rs, pStatement);
		}
	}
	
	public int deleteStudent(String sno){
		Connection conn=null;
		PreparedStatement pStatement=null;
		String sql="delete from student where sno=?";
		int num=0;
		conn=ConnectionManager.getConnection();
		try {
			pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, sno);
			num=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.close(conn, null, pStatement);
		}
		return num;
	}
	
	public int addStudent(Student student){
		Connection conn=null;
		PreparedStatement pStatement=null;
		String sql="insert into student(sno,sname,ssex,dept,grade,sage,phone,address)" +
					" values(?,?,?,?,?,?,?,?)";
		int num=0;
		conn=ConnectionManager.getConnection();
		try {
			pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, student.getSno());
			pStatement.setString(2, student.getSname());
			pStatement.setString(3, student.getSsex());
			pStatement.setString(4, student.getDept());
			pStatement.setString(5, student.getGrade());
			pStatement.setInt(6, student.getSage());
			pStatement.setString(7, student.getPhone());
			pStatement.setString(8, student.getAddress());
			num=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.close(conn, null, pStatement);
		}
		return num;
	}
	
	public void getStudent(DefaultTableModel model, String sql){
		Connection conn=null;
		PreparedStatement pStatement=null;
		ResultSet rs=null;
		Vector<String> title = new Vector<>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		conn = ConnectionManager.getConnection();
		try {
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			ResultSetMetaData rSetMetaData = rs.getMetaData();
			int colCount = rSetMetaData.getColumnCount();
			for(int i=1; i<=colCount; i++){
				switch(rSetMetaData.getColumnName(i)){
				case "SNO" :
					title.add("学号"); break;
				case "SNAME" :
					title.add("姓名"); break;
				case "SSEX" :
					title.add("性别"); break;
				case "SAGE" :
					title.add("年龄"); break;
				case "DEPT" :
					title.add("学院"); break;
				case "GRADE" :
					title.add("年级"); break;
				case "ADDRESS" :
					title.add("家庭住址"); break;
				case "PHONE" :
					title.add("联系电话"); break;
				}
			}
			int rowCount=0;
			while(rs.next()){
				rowCount++;
				Vector<String> rowdata = new Vector<>();
				for(int i=1; i<=colCount; i++){
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if(rowCount==0){
				model.setDataVector(null, title);
			}else{
				model.setDataVector(data, title);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.close(conn, rs, pStatement);
		}
	}
}
