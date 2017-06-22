package test1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddressBookUGI extends JFrame implements ActionListener {
	// 面板
	JPanel panel = new JPanel();
	//
	JTextField SeekTextField = new JTextField("");
	// 文本框数组
	JTextField[] textField = new JTextField[] {
	new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField("")
	};
	// 按钮
	JButton SeekButton = new JButton("搜索");
	JButton AlterButton = new JButton("修改");
	JButton AddButton = new JButton("添加");
	JButton DeleteButton = new JButton("删除");
	JButton OKButton = new JButton("确定");
	JButton FindButton = new JButton("查找");
	// 标签
	/* JLabel SeekLabel=new JLabel("查找："); */
	JLabel RecordCountLabel = new JLabel("查找结果：");
	// 标签数组
	JLabel[] messageLabel = new JLabel[] {
	new JLabel("*Name："), new JLabel("*PhoneNumber："),
	new JLabel("*QQ："), new JLabel("E-Mail："), new JLabel("Address：")
	};
	public AddressBookUGI() {
		//
		panel.setLayout(null);
		// 第一行组件
		FindButton.setBounds(38, 20, 80, 40);
		panel.add(FindButton);
		FindButton.addActionListener(this);
		FindButton.setHorizontalAlignment(JLabel.CENTER);
		SeekTextField.setBounds(120, 20, 160, 40);
		panel.add(SeekTextField);
		SeekButton.setBounds(280, 20, 100, 40);
		panel.add(SeekButton);
		SeekButton.addActionListener(this);
		// 第二行按钮
		AlterButton.setBounds(40, 80, 80, 40);
		panel.add(AlterButton);
		AlterButton.setEnabled(false);
		AlterButton.addActionListener(this);
		AddButton.setBounds(120, 80, 80, 40);
		panel.add(AddButton);
		AddButton.addActionListener(this);
		DeleteButton.setBounds(200, 80, 80, 40);
		panel.add(DeleteButton);
		DeleteButton.setEnabled(false);
		DeleteButton.addActionListener(this);
		OKButton.setBounds(280, 80, 80, 40);
		OKButton.setEnabled(false);
		panel.add(OKButton);
		// 查找结果标签
		RecordCountLabel.setBounds(20, 140, 160, 40);
		// RecordCountLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(RecordCountLabel);
		// 循环处理标签数组
		for (int i = 0; i < messageLabel.length; i++) {
			messageLabel[i].setBounds(20, 200 + 60 * i, 140, 40);
			messageLabel[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(messageLabel[i]);
		}
		// 循环处理文本框数组
		for (int i = 0; i < textField.length; i++) {
			textField[i].setBounds(160, 200 + 60 * i, 220, 40);
			panel.add(textField[i]);
		}
		//
		this.add(panel);
		this.setBounds(400, 150, 400, 550);
		this.setTitle("通讯录查询");
		this.setVisible(true);
		this.setResizable(false);
	}
	//
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == FindButton) {
			makeFind();
		} else if (e.getSource() == SeekButton) {
			makeSeek();
		} else if (e.getSource() == AlterButton) {
			makeAlter();
		} else if (e.getSource() == AddButton) {
			makeAdd();
		} else if (e.getSource() == DeleteButton) {
			makeDelete();
		}
	}
	public void makeFind() {
	}
	public void makeSeek() {
	}
	public void makeAlter() {
	}
	public void makeAdd() {
	}
	public void makeDelete() {
	}
	// 测试
	/*
	* public static void main(String []args){
	* 
	* AddressBookUGI frame=new AddressBookUGI();
	* 
	* }
	*/
}

