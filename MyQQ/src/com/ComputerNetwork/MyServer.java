package com.ComputerNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

public class MyServer extends JFrame{
    private static final int PORT=9090;
    private JTextArea area;
    private DefaultListModel lm ;
    private Map<String, Socket> usersMap = new HashMap<String, Socket>();

    public MyServer() {
        //�����
        super("���Ƿ�����");
        final int hight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        final int width  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds(width/3,hight/4, width/3,hight/2);
        //�˵�
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menu = new JMenu("����(c)");
        bar.add(menu);
        menu.setMnemonic('c');//�������Ƿ�
        final JMenuItem itemRun = new JMenuItem("����");
        itemRun.setActionCommand("run");
        menu.add(itemRun);
        menu.addSeparator();
        itemRun.setAccelerator(KeyStroke.getKeyStroke('R',KeyEvent.CTRL_MASK));//���ÿ�ݼ�
        JMenuItem itemExit = new JMenuItem("�˳�");
        itemExit.setAccelerator(KeyStroke.getKeyStroke('E',KeyEvent.CTRL_MASK));//���ÿ�ݼ�
        itemExit.setActionCommand("exit");
        menu.add(itemExit);

        //��Ϣ���
        area = new JTextArea();
        area.setEditable(false);
        getContentPane().add(area,BorderLayout.CENTER);
        //�û��б�
        lm= new DefaultListModel();
        JList list = new JList(lm);
        JScrollPane jc = new JScrollPane(list);
        jc.setBorder(new TitledBorder("����"));
        jc.setPreferredSize(new Dimension(100, this.getHeight()));
        getContentPane().add(jc,BorderLayout.EAST);

        //����
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("run")){
                    startServer();
                    itemRun.setEnabled(false);
                }
                if(e.getActionCommand().equals("exit")){
                    System.exit(0);
                }
            }
        };
        itemRun.addActionListener(al);
        itemExit.addActionListener(al);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        setVisible(true);
   }
    //����������
    private void startServer() {
        try {
            ServerSocket server = new ServerSocket(PORT);
           area.append("��������:"+server);
           // System.out.println("������������"+server);
            new ServerThread(server).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //�������߳���
    class ServerThread extends Thread{
        private ServerSocket server;
        public ServerThread(ServerSocket server) {
            this.server= server;
        }
        @Override
        public void run() {
            //����
            while(true){
                try {
                    Socket clientSocket = server.accept();
                    Scanner sc = new Scanner(clientSocket.getInputStream());
                    if(sc.hasNextLine()){
                        String userName = sc.nextLine();
                        area.append("\r\n�û���["+userName+"]��¼,"+clientSocket);
                       // System.out.println("\r\n�û���["+userName+"]��¼,"+clientSocket);
                        lm.addElement(userName);
                        new ClientThread(clientSocket).start();
                        //֪ͨ�������ߵ��û�
                        msgAll(userName);
                        msgSelf(clientSocket);

                        usersMap.put(userName, clientSocket);//����ʱ��¼���û������
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    private void msgSelf(Socket clientSocket) {
        try {
            Iterator<String> it = usersMap.keySet().iterator();
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            while(it.hasNext()){
                String userName = it.next();
                String msg = "cmdAdd@#server@#"+userName;
                pw.println(msg);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //֪ͨ�������ߵ��û�����ʱ��¼���û���½��
    private void msgAll(String userName) {
        Iterator<Socket> it = usersMap.values().iterator();
        while(it.hasNext()){
            try {
                PrintWriter pw = new PrintWriter(it.next().getOutputStream(), true);
                pw.println("msg@#server@#�û�["+userName+"]��½��.");
                pw.flush();
                pw.println("cmdAdd@#server@#"+userName);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //�ͻ����߳�
    class ClientThread extends Thread{
        private Socket clientSocket;
        public ClientThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            receiveAndSendMsg(clientSocket);
        }
    }
  //�Խ��յ�socket�еı��Ľ��з���
    private void receiveAndSendMsg(Socket clientSocketReceive) {
        try {
            Scanner sc = new Scanner(clientSocketReceive.getInputStream());
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                String msgs[]=str.split("@#");
                if("on".equals(msgs[0])){
                    if("ȫ��".equals(msgs[1])){//֪ͨ�����û�����������Ϣ��
                        String msg = "msg@#"+msgs[3]+"@#"+msgs[2];

                        Iterator<Socket> it= usersMap.values().iterator();
                        while(it.hasNext()){
                            Socket clientSocketSend = it.next();
                            PrintWriter pw = new PrintWriter(clientSocketSend.getOutputStream(), true);
                            pw.println(msg);
                            pw.flush();
                        }
                    }else{//ת�������û�����Ϣ
                        Socket clientSocketSend = usersMap.get(msgs[1]);
                        String msg = "msg@#"+msgs[3]+"@#"+msgs[2];
                        PrintWriter pw = new PrintWriter(clientSocketSend.getOutputStream(), true);
                        pw.println(msg);
                        pw.flush();
                    }
                }else if("exit".equals(msgs[0])){//�û��˳���¼����
                    usersMap.remove(msgs[3]);
                    Socket removeSocket = usersMap.get(msgs[3]);
                    area.append("\r\n�û�:["+msgs[3]+"]�˳���¼");
                    System.out.println("\r\n�û�:["+msgs[3]+"]�˳���¼");
                    lm.removeElement(msgs[3]);

                    Iterator<Socket> it= usersMap.values().iterator();
                    String msg = "msg@#server@#�û�["+msgs[3]+"]�˳���¼";
                    String msg2 ="cmdRed@#server@#"+msgs[3];
                    while(it.hasNext()){
                        Socket clientSocketSend = it.next();
                        PrintWriter pw = new PrintWriter(clientSocketSend.getOutputStream(), true);
                        pw.println(msg);
                        pw.flush();
                        pw.println(msg2);
                        pw.flush();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
   
        new MyServer();

    }

}