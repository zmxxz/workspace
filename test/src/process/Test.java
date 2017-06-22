package process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import ui.AddFrame;
import ui.DeleteFrame;
import ui.HomeFrame;
import ui.SelectFrame;
import ui.UpdateFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeFrame homeFrame = new HomeFrame();
		StudentManager studentManager = new StudentManager();
		
		homeFrame.btAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddFrame addFrame = new AddFrame();
				addFrame.OK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Student student = new Student();
						student.setSno(addFrame.snoText.getText());
						student.setSname(addFrame.snameText.getText());
						student.setSsex(addFrame.ssexText.getText());
						student.setSage(addFrame.sageText.getText());
						student.setAddress(addFrame.addressText.getText());
						student.setDept(addFrame.deptText.getText());
						student.setGrade(addFrame.gradeText.getText());
						student.setPhone(addFrame.phoneText.getText());
						int num = studentManager.addStudent(student);
						if(num > 0){
							JOptionPane.showMessageDialog(null, "添加记录成功！", "添加记录", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "添加记录失败！！", "添加记录", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				addFrame.redo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						addFrame.snoText.setText("");
						addFrame.snameText.setText("");
						addFrame.ssexText.setText("");
						addFrame.sageText.setText("");
						addFrame.deptText.setText("");
						addFrame.phoneText.setText("");
						addFrame.gradeText.setText("");
						addFrame.addressText.setText("");
					}
				});
			}
		});
		
		homeFrame.btQuery.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//studentManager.getStudent(homeFrame.model);
				SelectFrame selectFrame = new SelectFrame();
				selectFrame.btOK.addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String sqlselect = "";
						String sqlwhere = "";
										
						if(selectFrame.jcsno.isSelected()){
							sqlwhere += "sno like '" + selectFrame.tfsno.getText() + "%'";
							selectFrame.jcsnos.setSelected(true);
						}
						if(selectFrame.jcsname.isSelected()){
							sqlwhere += " and sname like '" + selectFrame.tfsname.getText() + "'";
							selectFrame.jcsnames.setSelected(true);
						}
						if(selectFrame.jcssex.isSelected()){
							sqlwhere += " and ssex = '" + selectFrame.tfssex.getText() + "'";
							selectFrame.jcssexs.setSelected(true);
						}
						if(selectFrame.jcsage.isSelected()){
							sqlwhere += " and sage between " + selectFrame.tfsages.getText() + " and " + selectFrame.tfsageb.getText();
							selectFrame.jcsages.setSelected(true);
						}
						if(selectFrame.jcdept.isSelected()){
							sqlwhere += " and dept like '%" + selectFrame.tfdept.getText() + "%'";
							selectFrame.jcdepts.setSelected(true);
						}
						if(selectFrame.jcgrade.isSelected()){
							selectFrame.jcgrades.setSelected(true);
							String grade = "(''";
							if(selectFrame.grade1.isSelected()){
								grade += ",'大一'";
							}
							if(selectFrame.grade2.isSelected()){
								grade += ",'大二'";
							}
							if(selectFrame.grade3.isSelected()){
								grade += ",'大三'";
							}
							if(selectFrame.grade4.isSelected()){
								grade += ",'大四'";
							}
							grade += ")";
							if(grade.length()>4){
								sqlwhere += " and grade in " + grade;
							}
						}
						if(selectFrame.jcaddress.isSelected()){
							sqlwhere += " and address like '%" + selectFrame.tfaddress.getText() + "%'";
							selectFrame.jcaddresss.setSelected(true);
						}
						
						if(selectFrame.jcsnos.isSelected()){
							sqlselect += ",sno";
						}
						if(selectFrame.jcsnames.isSelected()){
							sqlselect += ",sname";
						}
						if(selectFrame.jcssexs.isSelected()){
							sqlselect += ",ssex";
						}
						if(selectFrame.jcsages.isSelected()){
							sqlselect += ",sage";
						}
						if(selectFrame.jcdepts.isSelected()){
							sqlselect += ",dept";
						}
						if(selectFrame.jcgrades.isSelected()){
							sqlselect += ",grade";
						}
						if(selectFrame.jcaddresss.isSelected()){
							sqlselect += ",address";
						}
						if(selectFrame.jcphones.isSelected()){
							sqlselect += ",phone";
						}
						if(sqlselect.startsWith(",")){
							sqlselect = sqlselect.substring(1);
						}
						if(sqlselect.isEmpty()){
							sqlselect = "select * from student ";
						}else{
							sqlselect = "select " + sqlselect + " from student ";
						}
						if(sqlwhere.startsWith(" and")){
							sqlwhere = sqlwhere.substring(5);
						}
						if(!sqlwhere.isEmpty()){
							sqlselect += "where " + sqlwhere;
						}
						
						String sqlorder = " order by ";
						int snoselect = selectFrame.snoorder.getSelectedIndex();
						int sageselect = selectFrame.sageorder.getSelectedIndex();
						if(snoselect>0 && sageselect>0){
							if(snoselect == 1){
								sqlorder += "sno asc";
							}else {
								sqlorder += "sno desc";
							}
							if(sageselect==1){
								sqlselect += ",sage asc";
							}else{
								sqlselect += ",sage desc";
							}
							sqlselect += sqlorder;
						}else{
							if(snoselect==1){
								sqlorder += "sno asc";
							}
							if(snoselect==2){
								sqlorder += "sno desc";
							}
							if(sageselect==1){
								sqlorder += "sage asc";
							}
							if(sageselect==2){
								sqlorder += "sage desc";
							}
							if(sqlorder.length()>10){
								sqlselect += sqlorder;
							}
						}
				
						System.out.println(snoselect + " " + sageselect);
						System.out.println(sqlselect);
						studentManager.getStudent(homeFrame.model, sqlselect);	
					}
				});
				
				selectFrame.btredo.addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						selectFrame.tfsno.setText("");
						selectFrame.tfsname.setText("");
						selectFrame.tfssex.setText("");
						selectFrame.tfsages.setText("");
						selectFrame.tfsageb.setText("");
						selectFrame.tfdept.setText("");
						selectFrame.tfaddress.setText("");
						selectFrame.grade1.setSelected(false);
						selectFrame.grade2.setSelected(false);
						selectFrame.grade3.setSelected(false);
						selectFrame.grade4.setSelected(false);
						selectFrame.jcsno.setSelected(false);
						selectFrame.jcsname.setSelected(false);
						selectFrame.jcssex.setSelected(false);
						selectFrame.jcsage.setSelected(false);
						selectFrame.jcdept.setSelected(false);
						selectFrame.jcgrade.setSelected(false);
						selectFrame.jcaddress.setSelected(false);
						selectFrame.jcsnos.setSelected(true);
						selectFrame.jcsnames.setSelected(true);
						selectFrame.jcssexs.setSelected(true);
						selectFrame.jcsages.setSelected(true);
						selectFrame.jcdepts.setSelected(true);
						selectFrame.jcgrades.setSelected(true);
						selectFrame.jcphones.setSelected(true);
						selectFrame.jcaddresss.setSelected(true);
					}
				});
			}
		});
		
		homeFrame.btDelete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteFrame deleteFrame = new DeleteFrame();
				deleteFrame.OK.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String sno=deleteFrame.snoText.getText();
						int num = studentManager.deleteStudent(sno);
						if(num > 0){
							JOptionPane.showMessageDialog(null, "删除记录成功！", "删除记录", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "删除记录失败！！", "删除记录", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			}
		});
		
		homeFrame.btUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateFrame updateFrame = new UpdateFrame();
				updateFrame.OK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String tempsno = updateFrame.snoText.getText();
						studentManager.queryStudent(tempsno, updateFrame);
					}
				});
				updateFrame.update.addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String tempsno = updateFrame.snoText.getText();
						int num = studentManager.updateStudent(tempsno, updateFrame);
						if(num > 0){
							JOptionPane.showMessageDialog(null, "更新记录成功！", "更新记录", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "更新记录失败！！", "更新记录", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			}
		});
	}

}
