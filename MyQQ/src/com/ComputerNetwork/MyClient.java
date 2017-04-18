package com.ComputerNetwork;

import java.awt.*; 

import javax.swing.*; 
import javax.swing.tree.*; 

import java.awt.event.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.event.*;



@SuppressWarnings("serial")
public class MyClient extends JFrame { 
	final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    final int width  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	JPanel cp=new JPanel(); 
	JTree jtree; 
	static DefaultMutableTreeNode root; 
	static String s;
	String tfdUserName;
	private  String HOST = "192.168.65.1";
	private  int PORT = 9090;
	private Socket clientSocket;
	private PrintWriter pw ;
	Map<String,Chat> chatwindow = new HashMap<String,Chat>();
	public MyClient(String userName){ 
		this.setTitle("MyQQ"); 
	    cp=(JPanel)this.getContentPane(); 
	    cp.setLayout(new BorderLayout()); 
	    tfdUserName = userName;
	    root=new DefaultMutableTreeNode("ͨѶ¼"); 
	    createTree(root); 
	    jtree=new JTree(root); 
	    cp.add(jtree,BorderLayout.CENTER); 
	    System.out.println("root     "+root.getUserObject()); 
	    this.setBounds(width/3, height/3, 200, 500);; 
	    setVisible(true);
	    connecting();
	    jtree.addTreeSelectionListener(new TreeSelectionListener(){
		    public void valueChanged(TreeSelectionEvent e) {
		    	DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
		    	jtree.getLastSelectedPathComponent();
		    	if (node == null)
		    		return;
		    	if(node.isLeaf()){
		    		s = node.toString();
		    		Chat t = new Chat(s);
		    		chatwindow.put(s, t);
		    	}
	
		    }
	    });
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            if(clientSocket==null){
	                System.exit(0);
	            }
	            sendExitMsg();
	            System.exit(0);
	        }
	    });
	} 

	private  void createTree (DefaultMutableTreeNode root){ 
	   DefaultMutableTreeNode classroom=null; 	   
	   DefaultMutableTreeNode somebody =null; 
	   DefaultMutableTreeNode relatives=null; 
	   DefaultMutableTreeNode friend=null;	  
	   DefaultMutableTreeNode node=null; 
	   classroom=new DefaultMutableTreeNode("1614302"); 
	   somebody=new DefaultMutableTreeNode("qq����"); 
	   relatives=new DefaultMutableTreeNode("����"); 
	   friend=new DefaultMutableTreeNode("����"); 
	   
	   root.add(classroom); 
	   root.add(somebody); 
	   root.add(relatives); 
	   root.add(friend); 
   
	   File file = new File("doc/"+tfdUserName+".txt");
	   try {
		   BufferedReader reader = new BufferedReader(new FileReader(file));
		   String fname = null;
		   while((fname = reader.readLine())!= null){
			   String str[] = fname.split(":");
			   if(relatives.getUserObject().toString().equals(str[0])){
				   node=new DefaultMutableTreeNode(str[1]); 
				   relatives.add(node);	
			   	   }
			   if(friend.getUserObject().toString().equals(str[0])){
				   node=new DefaultMutableTreeNode(str[1]); 
				   friend.add(node);	
				   }
			   if(somebody.getUserObject().toString().equals(str[0])){
				   node=new DefaultMutableTreeNode(str[1]); 
				   somebody.add(node);	
				   }
		   }
		   reader.close();
	       }catch(IOException e){
	    		e.printStackTrace();
		}
	
	} 

	protected void processWindowEvent(WindowEvent e){ 
		   if(e.getID()==WindowEvent.WINDOW_CLOSING){ 
		    System.exit(0); 
		   } 
	} 

	private void sendExitMsg() {
	    try {
	        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
	        //������������˳���Ϣ
	        String msg = "exit@#"+"ȫ��"+"@#"+tfdUserName;
	        pw.println(msg);       
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	}
	public void connecting() {
	    try {
	        clientSocket = new Socket(HOST,PORT);
	        String userName = tfdUserName;
	        pw= new PrintWriter(clientSocket.getOutputStream(),true);
	       pw.println(userName); 
	        this.setTitle("�û�["+userName+"]����...");
	        new ClientThread().start();//ר�Ÿ���ͨѶ���߳�
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
class ClientThread extends Thread{
    @Override
    public void run() {
        try {
            //���ܷ���������������Ϣ
            Scanner sc = new Scanner(clientSocket.getInputStream());
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                String msgs[]= str.split("@#");
                if("msg".equals(msgs[0])){//��Ϣ
                    if("server".equals(msgs[1])){//����������Ϣ
                        str="[֪ͨ]:"+msgs[2];
                        Iterator<Chat> it = chatwindow.values().iterator();
                        if(it.hasNext()){
                        	Chat cwindow = it.next();
                        	cwindow.log.append("\r\n"+str);
                        }
                        
                    }else{//�û�������Ϣ
                        str = "["+msgs[1]+"]˵:"+msgs[2];
                        Chat cwindow = chatwindow.get(msgs[1]);
                        cwindow.log.append("\r\n"+str);
                    }
                    
                    //allMsg.append("\r\n"+str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Chat extends JFrame implements ActionListener{
  	 JTextArea log = new JTextArea();
  	 JTextArea input = new JTextArea();
  	 JLabel l1 = new JLabel("�����¼��",JLabel.LEFT);
  	JLabel l2 = new JLabel("�����",JLabel.LEFT);
  	JButton send = new JButton("����");
  	String fname;
  	public Chat(String friendname){
  		super("MyQQ");
  		fname = friendname;
  		this.setLayout(null);

  		this.setBounds(width/3, height/3, 420, 480);;
  		
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
  		send.setActionCommand("send");
  		this.add(send);
  		send.addActionListener(this);

  		this.setVisible(true);
  		this.setResizable(false);
  	}
  	public void actionPerformed(ActionEvent e){
  		if(e.getActionCommand().equals("send")){
           try {
               PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
               //�Ҷ�˭˵��ʲô��Ϣ
               if(input.getText()==null || input.getText().trim().length()==0){
                   JOptionPane.showMessageDialog(this, "�������Ϣ");
                   return ;
               }
               String msg = "on@#"+fname+"@#"+input.getText()+"@#"+tfdUserName;
               pw.println(msg);
               //���ӵ��Լ������ ��Ϊ��¼
               log.append("\r\n[��]˵��"+input.getText());
               input.setText("");

           } catch (IOException e1) {
               e1.printStackTrace();
           }
       }
  	}
  }
}