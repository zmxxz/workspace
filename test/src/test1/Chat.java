package test1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import test1.ClientFrame.ClientThread;

class Chat extends JFrame {
	 JTextArea log = new JTextArea();
	 JTextArea input = new JTextArea();
	 JLabel l1 = new JLabel("�����¼��",JLabel.LEFT);
	JLabel l2 = new JLabel("�����",JLabel.LEFT);
	JButton send = new JButton("����");
	public Chat(){
		super("MyQQ");
		
		this.setLayout(null);

		this.setSize(420, 480);
		
		l1.setBounds(10, 0, 400, 20);
		this.add(l1);
		
		
		log.setEditable(false);
		log.setBounds(0, 20, 400, 205);
		this.add(log);

		
		l2.setBounds(0, 225, 400, 20);
		this.add(l2);

		
		input.setEditable(true);
		input.setBounds(0,245,400,155);
		this.add(input);

		
		send.setBounds(170, 400, 60, 40);
		
		this.add(send);
		

		this.setVisible(true);
		this.setResizable(false);
	}
}
