package test1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddressBookUGI extends JFrame implements ActionListener {
	// ���
	JPanel panel = new JPanel();
	//
	JTextField SeekTextField = new JTextField("");
	// �ı�������
	JTextField[] textField = new JTextField[] {
	new JTextField(""), new JTextField(""), new JTextField(""),
			new JTextField(""), new JTextField("")
	};
	// ��ť
	JButton SeekButton = new JButton("����");
	JButton AlterButton = new JButton("�޸�");
	JButton AddButton = new JButton("���");
	JButton DeleteButton = new JButton("ɾ��");
	JButton OKButton = new JButton("ȷ��");
	JButton FindButton = new JButton("����");
	// ��ǩ
	/* JLabel SeekLabel=new JLabel("���ң�"); */
	JLabel RecordCountLabel = new JLabel("���ҽ����");
	// ��ǩ����
	JLabel[] messageLabel = new JLabel[] {
	new JLabel("*Name��"), new JLabel("*PhoneNumber��"),
	new JLabel("*QQ��"), new JLabel("E-Mail��"), new JLabel("Address��")
	};
	public AddressBookUGI() {
		//
		panel.setLayout(null);
		// ��һ�����
		FindButton.setBounds(38, 20, 80, 40);
		panel.add(FindButton);
		FindButton.addActionListener(this);
		FindButton.setHorizontalAlignment(JLabel.CENTER);
		SeekTextField.setBounds(120, 20, 160, 40);
		panel.add(SeekTextField);
		SeekButton.setBounds(280, 20, 100, 40);
		panel.add(SeekButton);
		SeekButton.addActionListener(this);
		// �ڶ��а�ť
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
		// ���ҽ����ǩ
		RecordCountLabel.setBounds(20, 140, 160, 40);
		// RecordCountLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(RecordCountLabel);
		// ѭ�������ǩ����
		for (int i = 0; i < messageLabel.length; i++) {
			messageLabel[i].setBounds(20, 200 + 60 * i, 140, 40);
			messageLabel[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(messageLabel[i]);
		}
		// ѭ�������ı�������
		for (int i = 0; i < textField.length; i++) {
			textField[i].setBounds(160, 200 + 60 * i, 220, 40);
			panel.add(textField[i]);
		}
		//
		this.add(panel);
		this.setBounds(400, 150, 400, 550);
		this.setTitle("ͨѶ¼��ѯ");
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
	// ����
	/*
	* public static void main(String []args){
	* 
	* AddressBookUGI frame=new AddressBookUGI();
	* 
	* }
	*/
}

