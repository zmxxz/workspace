package com.qq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class MyServer extends WindowAdapter implements ActionListener,KeyListener {
	JFrame f = new JFrame("Myqq");
	JLabel l1 = new JLabel("聊天记录：",JLabel.LEFT);
	JLabel l2 = new JLabel("输入框：",JLabel.LEFT);
	JButton send = new JButton("发送");
	JTextArea log = new JTextArea();
	JTextArea input = new JTextArea();
	DatagramSocket reSocket,seSocket;
	DatagramPacket rePacket,sePacket;
	String hostname;
public void display(){
		
		f.setLayout(null);

		f.setSize(420, 480);
		
		l1.setBounds(10, 0, 400, 20);
		f.add(l1);
		
		
		log.setEditable(false);
		log.setBounds(0, 20, 400, 205);
		f.add(log);

		
		l2.setBounds(0, 225, 400, 20);
		f.add(l2);

		
		input.setEditable(true);
		input.setBounds(0,245,400,155);
		f.add(input);

		
		send.setBounds(170, 400, 60, 40);
		f.add(send);

		f.setVisible(true);
		f.setResizable(false);
		try{
			seSocket = new DatagramSocket(3000);
		}catch(IOException e){
			log.append(e + "\n");
		}
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				seMessage();
			}
		});
	}
public void reMessage()
{
try
{
reSocket=new DatagramSocket(3333);
while(true)
{
byte[]buf=new byte[500];
rePacket=new DatagramPacket(buf,buf.length);
//receivePacket=newDatagramPacket(buf,buf.length);
reSocket.receive(rePacket);
if(rePacket.getLength()==0)
{
System.out.println("消息为空!");
continue;
}
ByteArrayInputStream bin=new ByteArrayInputStream(rePacket.getData());
////ByteArrayInputStream字节串(或叫字节数组)变成输入流的形式
BufferedReader reader=new BufferedReader(new InputStreamReader(bin));
log.append("客户端："+reader.readLine());
log.append("\n");
reader.close();
bin.close();
}
}
catch(Exception e)
{
log.append(e+"\n");
}
}
public void seMessage()
{
try
{
String s=input.getText();
input.setText("");
log.append("服务器："+s+"\n");
ByteArrayOutputStream out= new ByteArrayOutputStream();
PrintStream pout = new PrintStream(out);
pout.print(s);
byte buf[]=out.toByteArray();
//指定数据抱报道数据包长度、目的地址和端口号
sePacket=new DatagramPacket(buf,buf.length,
InetAddress.getByName(hostname),3001);
seSocket.send(sePacket);//
buf=null;
}
catch(Exception err)
{
log.append(err+"\n");
}
}
//
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==send);
{
seMessage();
}

}
public void windowClosing(WindowEvent e)
{
System.out.println("聊天程序已关闭，再见！\n");
System.exit(0);
}
public void keyPressed(KeyEvent e)
{
if(e.getSource()==input)
{
if(e.getKeyChar()==KeyEvent.VK_ENTER)
{
seMessage();//发送数据抱包
}
}
}
public static void main(String arg[])
{
MyServer app=new MyServer();
app.display();
app.reMessage();
}
public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e){}
}
