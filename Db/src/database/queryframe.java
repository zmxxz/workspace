package database;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class queryframe {
	JFrame qf = new JFrame("query");
	Container c = qf.getContentPane();
	DefaultTableModel model;
	JScrollPane scrollPane;
	ResultSet rs;
	private JTextField textField;
	private JTable table;
	JComboBox comboBox ;
	public queryframe(){
		qf.getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 584, 97);
		qf.getContentPane().add(p1);
		p1.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(28, 26, 98, 26);
		comboBox.addItem("姓名");
		comboBox.addItem("学号");
		comboBox.addItem("电话");
		comboBox.addItem("e-mail");
		p1.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(140, 26, 114, 26);
		p1.add(textField);
		textField.setColumns(10);
		
		JButton qsub = new JButton("查询");
		qsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					query1();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		qsub.setBounds(264, 28, 93, 26);
		p1.add(qsub);
		
		JButton qsub2 = new JButton("模糊查询");
		qsub2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					query2();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		qsub2.setBounds(367, 28, 93, 26);
		p1.add(qsub2);
		
		JButton all = new JButton("\u5168\u90E8");
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					queryall();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		all.setBounds(470, 28, 93, 26);
		p1.add(all);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 96, 584, 186);
		qf.getContentPane().add(p2);
		p2.setLayout(null);
		
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"姓名","性别","学号","电话","email","院系"});
		table = new JTable(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 583, 185);
		p2.add(scrollPane);
		
		qf.setVisible(true);
		qf.setResizable(false);
		qf.setBounds(745,300,600,340);
	}
	public void query2() throws Exception{
		Connection conn = addframe.getConnection();
		String sql = null;
		if(comboBox.getSelectedItem()=="姓名"){
			sql = "select * from tongxun where sname like '%"+textField.getText()+"%'";
		}else if(comboBox.getSelectedItem()=="学号"){
			sql = "select * from tongxun where sno like '%"+textField.getText()+"%'";
		}else if(comboBox.getSelectedItem()=="电话"){
			sql = "select * from tongxun where phone like '%"+textField.getText()+"%'";
		}else if(comboBox.getSelectedItem()=="email"){
			sql = "select * from tongxun where email like '%"+textField.getText()+"%'";
		}
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		model.setRowCount(0);
		while(rs.next()){
			String name = rs.getString("sname");
			String gender = rs.getString("sgender");
			String no = rs.getString("sno");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String dept = rs.getString("dept");
			model.addRow(new Object[]{name,gender,no,phone,email,dept});
		}
		
		stmt.close();
	}
	public void query1() throws Exception{
		Connection conn = addframe.getConnection();
		String sql = null;
		if(comboBox.getSelectedItem()=="姓名"){
			sql = "select * from tongxun where sname = '"+textField.getText()+"'";
		}else if(comboBox.getSelectedItem()=="学号"){
			sql = "select * from tongxun where sno = '"+textField.getText()+"'";
		}else if(comboBox.getSelectedItem()=="电话"){
			sql = "select * from tongxun where phone = '"+textField.getText()+"'";
		}else if(comboBox.getSelectedItem()=="email"){
			sql = "select * from tongxun where email = '"+textField.getText()+"'";
		}
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		model.setRowCount(0);
		while(rs.next()){
			String name = rs.getString("sname");
			String gender = rs.getString("sgender");
			String no = rs.getString("sno");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String dept = rs.getString("dept");
			model.addRow(new Object[]{name,gender,no,phone,email,dept});
		}
		
		stmt.close();
	}
	public void queryall() throws Exception{
		Connection conn = addframe.getConnection();
		String sql = "select * from tongxun";
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		model.setRowCount(0);
		while(rs.next()){
			String name = rs.getString("sname");
			String gender = rs.getString("sgender");
			String no = rs.getString("sno");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String dept = rs.getString("dept");
			model.addRow(new Object[]{name,gender,no,phone,email,dept});
		}
		
		stmt.close();
	}
}
