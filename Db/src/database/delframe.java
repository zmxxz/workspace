package database;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class delframe {
	JFrame df = new JFrame("del");
	Container c = df.getContentPane();
	JLabel option = new JLabel("ɾ��������",JLabel.CENTER);
	JComboBox op = new JComboBox();
	JTextField delop = new JTextField();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton submit = new JButton("�ύ");
	public delframe(){
		c.setLayout(new GridLayout(2,1));
		c.add(p1);
		c.add(p2);
		p1.setLayout(null);
		option.setBounds(1, 0, 114, 41);
		p1.add(option);
		op.setBounds(117, 5, 114, 31);
		op.addItem("����");
		op.addItem("ѧ��");
		op.addItem("�绰");
		op.addItem("e-mail");
		p2.add(submit,JButton.CENTER);
		p1.add(op);
		delop.setBounds(230, 5, 114, 31);
		p1.add(delop);
		df.setVisible(true);
		df.setResizable(false);
		df.setBounds(745,300,360,120);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int res = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����","ɾ����",JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION){
					try {
						sub();
						df.setVisible(false);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					df.dispose();
				}
				
			}
		});
	}
	
	public void sub() throws Exception{
		Connection conn = addframe.getConnection();
		String sql = null;
		if(op.getSelectedItem()=="����"){
			 sql = "delete from tongxun where sname = "+"'"+delop.getText()+"'";
			
		}else if(op.getSelectedItem()=="ѧ��"){
			 sql = "delete from tongxun where sno = "+"'"+delop.getText()+"'";
			
		}else if(op.getSelectedItem()=="�绰"){
			 sql = "delete from tongxun where phone = "+"'"+delop.getText()+"'";
			
		}else{
			 sql = "delete from tongxun where email = "+"'"+delop.getText()+"'";
			
		}
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
}