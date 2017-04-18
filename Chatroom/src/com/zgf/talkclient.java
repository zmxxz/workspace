package com.zgf;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class talkclient extends JFrame implements ActionListener
{
	JTextField jtfName;//����������
	JTextField jtaInput;//������Ϣ
	JTextArea jtaChat;//��ʾ������Ϣ
	JButton jbSend;//������Ϣ��ť
	JButton jbLogon;//��¼��ť
	JButton jbOut;//�˳���¼
	//final JLabel Label;
	java.awt.List listmember;//��ʾ�����û�
	
		Socket sock=null;
	PrintWriter ps=null;
	socketout ct=null;
	
	public talkclient()
	{
		super("������");
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			javax.swing.SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){}
			
		
		
		setSize(500,350);
		Container containers=getContentPane();
		containers.setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,4,4,4));
	//	p1.setBackground(Color.pink);
		p1.add(new JLabel(" �������¼����"));
		jtfName=new JTextField(15);
		p1.add(jtfName);
		jbLogon=new JButton("L_��¼");
		jbLogon.setBackground(Color.PINK);
		jbLogon.addActionListener(this);
		p1.add(jbLogon);
		containers.add(p1,"West");
		/*	jbOut=new JButton("�˳�");
		jbOut.setBackground(Color.PINK);
		jbOut.addActionListener(this);
		p1.add(jbOut);
		*/
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(1,4,1,1));
	//	p.setBackground(Color.pink);
		p.add(new JLabel(""));
		p.add(new JLabel("���ĶԻ�����ʾ�ڴˣ�"));
		p.add(new JLabel(""));
		p.add(new JLabel(" ��ǰ�������ѣ�"));
		containers.add(p,"North");
		
		JPanel p2=new JPanel();
		jtaChat=new JTextArea(13,40);
		jtaChat.setEditable(false);
		p2.add(jtaChat);
		containers.add(p2,"Center");
		
		JPanel p3=new JPanel();
 		listmember=new java.awt.List(17);
		listmember.setBackground(Color.PINK);
		p3.add(listmember);
		containers.add(p3,"East");
		
		JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(1,2,1,1));
		jtaInput=new JTextField(15);
	//	jtaInput.setBackground(Color.PINK);
		p4.add(jtaInput);
		
		jbSend=new JButton("S_����");
		jbSend.setBackground(Color.PINK);
		jbSend.addActionListener(this);
		p4.add(jbSend);
		containers.add(p4,"South");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public static void main(String args[]) {
	
	talkclient talk=new talkclient();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str;
		str=e.getActionCommand();
		try{
			switch(str.charAt(0))
			{
				case 'L':
				if(sock==null)
				{
					String str1;
					str=jtfName.getText();
					sock=new Socket(InetAddress.getLocalHost(),2008);
					ps=new PrintWriter(sock.getOutputStream());
					StringBuffer info=new StringBuffer("INFO: ");
					String userinfo=jtfName.getText()+":"+InetAddress.getLocalHost().toString();
					ps.println(info.append(userinfo));
					ps.flush();
					ct=new socketout(this,jtfName.getText(),sock);
					ct.start();
					}
					break;
					case 'S':
					if(sock!=null){
						StringBuffer msg=new StringBuffer("MSG: ");
						String msgtxt=new String(jtaInput.getText());
						ps.println(msg.append(jtaInput.getText()));
						ps.flush();
					}
					break;
					}
				}catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
	        
	        
}          

//����̣߳��Ӽ��̽������ݷ��͸���������
class socketout extends Thread {
	Socket sock=null;
	String s=null;
	BufferedReader read;
	PrintWriter ps=null;
	talkclient talkclient=null;
	
	
	//String name;
	public socketout(talkclient soc,String sname,Socket socke)
	{
		talkclient=soc;
		sock=socke;
		s=sname;
		try
		{
			read=new BufferedReader(new InputStreamReader(socke.getInputStream()));
			ps=new PrintWriter(socke.getOutputStream());
			}
		catch(IOException e)
		{
			//client.exit();
			e.printStackTrace();
		}
		//this.socket = socket;
	}
	public void run() 
	{
		String message=null;
		while(sock!=null)
		{
		try
		{
			message= read.readLine();
		}
			catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		if (message==null) {
				talkclient.ct=null;
				talkclient.sock=null;
				talkclient.listmember.removeAll();
				return;
			}
		
		StringTokenizer st=new StringTokenizer(message,":");
		String keyword=st.nextToken();
		
			if(keyword.equals("newUser")) {
				talkclient.listmember.removeAll();
				while(st.hasMoreTokens()) {
					String str=st.nextToken();
					talkclient.listmember.add(str);
				}
			}
			else if(keyword.equals("MSG")) {
				String usr=st.nextToken();
				talkclient.jtaChat.append(usr);
				talkclient.jtaChat.append(st.nextToken("\0"));
				talkclient.jtaChat.append("\n");
			}
			else if(keyword.equals("EIXT")) {
				System.out.println("EIXT");
				try{
					talkclient.ct=null;
					talkclient.sock.close();
					talkclient.sock=null;
				}
				catch(IOException e){}
				talkclient.listmember.removeAll();
				return;
			}
			
	}
	}
}

