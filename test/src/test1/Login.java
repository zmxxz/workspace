package test1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
	JFrame loginF = new JFrame("��¼");
	Container loginC = loginF.getContentPane();
	JPanel loginP = new JPanel();
	JPanel btnP = new JPanel();
	JLabel userName = new JLabel("�û�����",JLabel.CENTER);
	JLabel passWord = new JLabel("���룺",JLabel.CENTER);
	JTextField user = new JTextField();
	JPasswordField pw = new JPasswordField();
	JButton yesbtn = new JButton("ȷ��");
	public Login(){
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
		loginF.setSize(400,	175);
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
		if(nm.equals("zgf")&&p.equals("123")||nm.equals("zq")&&p.equals("123")||nm.equals("zy")&&p.equals("123")){
			System.out.println("��¼�ɹ���");
			JFrame.setDefaultLookAndFeelDecorated(true);
	        new ClientFrame(user.getText());
	      
			f.setVisible(false);
		}else{
			System.out.println("��¼ʧ�ܣ�");	
		}
	}
	public static void main(String[] args){
		Login l = new Login();
	}

}

