package database;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class manu  {
	JFrame wc = new JFrame("欢迎页");
	Container c = wc.getContentPane();
	JLabel l = new JLabel("欢迎来到通讯录",JLabel.CENTER);
	JPanel p = new JPanel();
	JButton add = new JButton("1.增加");
	JButton del = new JButton("2.删除");
	JButton mod = new JButton("3.修改");
	JButton sle = new JButton("4.查询");
	private final JPanel panel = new JPanel();
	public manu(){
		wc.getContentPane().setLayout(null);
		panel.setBounds(21, 10, 194, 271);
		del.setBounds(62, 102, 90, 39);
		del.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				delsb();
			}
		});
		panel.add(del);
		
		wc.getContentPane().add(panel);
		panel.setLayout(null);
		l.setBounds(51, 10, 114, 25);
		panel.add(l);
		mod.setBounds(62, 151, 90, 39);
		panel.add(mod);
		sle.setBounds(62, 200, 90, 39);
		panel.add(sle);
		add.setBounds(62, 53, 90, 39);
		panel.add(add);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				addsb();
			}
		});
		mod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				modsb();
			}
		});
		sle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				slesb();
			}
		});
		wc.setVisible(true);
		wc.setBounds(470,300,246,312);
		wc.setResizable(false);
	}
	public void addsb(){
		new addframe();
	}
	public void delsb(){
		new delframe();
	}
	public void modsb(){
		new modifyframe();
	}
	public void slesb(){
		new queryframe();
	}
}
