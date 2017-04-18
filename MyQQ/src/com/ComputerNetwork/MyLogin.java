package com.ComputerNetwork;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyLogin {
	final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    final int width  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	JFrame loginF = new JFrame("��¼");
	Container loginC = loginF.getContentPane();
	JPanel loginP = new JPanel();
	JPanel btnP = new JPanel();
	JLabel userName = new JLabel("�û�����",JLabel.CENTER);
	JLabel passWord = new JLabel("���룺",JLabel.CENTER);
	JTextField user = new JTextField();
	JPasswordField pw = new JPasswordField();
	JButton yesbtn = new JButton("ȷ��");
	public MyLogin(){
		loginC.setLayout(new GridLayout(2,1));
		loginC.add(loginP);
		loginC.add(btnP);
		loginP.setLayout(new GridLayout(2,2));
		loginP.add(userName);
		loginP.add(user);
		loginP.add(passWord);
		loginP.add(pw);
		btnP.add(yesbtn);
		yesbtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					login(loginF);
				}
			});
		loginF.setVisible(true);
		loginF.setBounds(width/3,height/3 , 400, 175);
		loginF.setResizable(false);
		loginF.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		}
	public void login(JFrame f){
		String nm = user.getText().toString().trim();
		String p = pw.getText().toString().trim();
		if(checkup(user.getText(),pw.getText())){
			System.out.println("��¼�ɹ���");
			new MyClient(user.getText());
			f.setVisible(false);
		}else{
			System.out.println("��¼ʧ�ܣ�");
			
		}
	}
	public boolean checkup(String nm,String pwd) {
        File file = new File("doc/user.txt");
        BufferedReader reader = null;
        try {
            
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
               String str[] = tempString.split(":");
               if(nm.equals(str[0])&&pwd.equals(str[1]))            	   
            	   return true;
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return false;
    }
	public static void main(String[] args){
		MyLogin l = new MyLogin();
	}

}