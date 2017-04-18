package com.zgf;
import java.io.*;
import java.net.*;
import java.util.*;
public class talkserver {
	static Vector clients=new Vector(20);//设置最大客户端数目
	static ServerSocket server=null;
	static Socket sock=null;

public talkserver()
{
    	try
		{
			System.out.println("Start Server...");
			server=new ServerSocket(2008);
			while(true)
			{
				sock=server.accept();
				System.out.println(sock.getInetAddress()+"cennection...");
				socketin st=new socketin(sock);
				clients.addElement(st);
				st.start();
				updateList();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
 }
public static void updateList()
	{
		StringBuffer newUser=new StringBuffer("newUser");
		for(int i=0;i<clients.size();i++){
			socketin s=(socketin)clients.elementAt(i);
			newUser.append(":"+s.name);
		}
		sendClients(newUser);
	}
	public static void sendClients(StringBuffer msg)
	{
		for(int i=0;i<clients.size();i++)
		{
			socketin ss=(socketin)clients.elementAt(i);
			ss.sendMessage(msg);
		}
	}
	public static void CloseTalk(socketin ss)
	{
		try
		{
			System.out.println(ss.ip+"Leave...");
			ss.sendMessage(new StringBuffer("EIXT"));
			ss.sock=null;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		clients.removeElement(ss);
	}
	public static void main(String args[])
	{
		talkserver s=new talkserver();		
}
}
//输入线程（从服务器接收数据显示）
class socketin extends Thread {
	String name;
	String ip;
	Socket sock;
	BufferedReader read;
	PrintWriter  ps;
	public socketin(Socket s) 
	{
		sock=s;
		try
		{
			read= new BufferedReader(new InputStreamReader(s.getInputStream()));
			ps=new PrintWriter(s.getOutputStream());
			String info=read.readLine();
			StringTokenizer stinfo=new StringTokenizer(info,":");
			String head=stinfo.nextToken();
			if(stinfo.hasMoreTokens())
			name=stinfo.nextToken();
			ip=stinfo.nextToken();
			}
			catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void sendMessage(StringBuffer message)
	{
		ps.println(message);
		ps.flush();
	}
	public void run() {
		while(true)
		{
			String message=null;
			try
			{
				message=read.readLine();
			}catch(IOException e)
			{
				talkserver. CloseTalk(this);
				talkserver.updateList();
				e.printStackTrace();
				return;
			}
			if(message==null)
			{
				talkserver.CloseTalk(this);
				talkserver.updateList();
				return;
			}
			StringTokenizer st=new StringTokenizer(message,":");
			String keyword=st.nextToken();
			if(keyword.equals("MSG"))
			{
				StringBuffer msg=new StringBuffer("MSG:");
				msg.append(name);
				msg.append(st.nextToken("\0"));
				talkserver.sendClients(msg);
			}
			else if(keyword.equals("EXIT"))
			{
				talkserver.CloseTalk(this);
				talkserver.updateList();
			}
		}
	
	}
}