package test1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClientFrame extends JFrame {
    private JTextField tfdUserName;
   
    private JList list;
    private DefaultListModel lm;
   
   
    Map<String,Chat> chatwindow = new HashMap<String,Chat>();
    public ClientFrame(String t) {
        //��һ�������
        setBounds(400, 400, 500, 400);
        //�˵�
        addMenu();

        //�ϲ����
        JPanel topP = new JPanel();
        getContentPane().add(topP,BorderLayout.NORTH);
        topP.add(new JLabel("�û���ʶ:"));
        tfdUserName = new JTextField(10);
        tfdUserName.setText(t);
        topP.add(tfdUserName);

        //�м����
        JPanel centerP = new JPanel();
        centerP.setLayout(new BorderLayout());
        getContentPane().add(centerP,BorderLayout.CENTER);

        //�м������û��б�
        lm = new DefaultListModel();
        list= new JList(lm);
        lm.addElement("ȫ��");
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(2);
        list.addListSelectionListener(new ListSelectionListener(){
        	public void valueChanged(ListSelectionEvent e){
        		if(list.getValueIsAdjusting()==true){
        			Chat t = new Chat(list.getSelectedValue().toString());
        			chatwindow.put(list.getSelectedValue().toString(), t);
        		}
        	}
        });
        JScrollPane jc = new JScrollPane(list);
        jc.setBorder(new TitledBorder("����"));
        jc.setPreferredSize(new Dimension(100,centerP.getHeight()));
        centerP.add(jc,BorderLayout.CENTER);
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
        connecting();
        tfdUserName.setEditable(false);
        setVisible(true);
    }
    
    private void addMenu() {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu menu = new JMenu("ѡ��");
        menubar.add(menu);
        JMenuItem setMenuItem= new JMenuItem("����");
        JMenuItem helpMenuItem= new JMenuItem("����");
        menu.add(setMenuItem);
        menu.addSeparator();
        menu.add(helpMenuItem);
        setMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog dlg = new JDialog();
                dlg.setLayout(new FlowLayout());
                dlg.add(new JLabel("������:"));
                final JTextField tfdIp = new JTextField(10);
                tfdIp.setText(HOST);
                dlg.add(tfdIp);
                dlg.add(new JLabel(":"));
                final JTextField tfdPort = new JTextField(5);
                tfdPort.setText(""+PORT);
                dlg.add(tfdPort);
                dlg.setBounds(ClientFrame.this.getX(), ClientFrame.this.getY(), 400, 100);
                JButton setBtn = new JButton("����");
                dlg.add(setBtn);
                setBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ip = tfdIp.getText();
                        String port = tfdPort.getText();
                        HOST = ip ;
                        PORT = Integer.parseInt(port);
                        dlg.dispose();
                    }
                });
                dlg.setVisible(true);



            }
        });

        helpMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dlg = new JDialog();
                dlg.setLayout(new FlowLayout());
                dlg.setBounds(ClientFrame.this.getX(), ClientFrame.this.getY(), 300, 100);
                dlg.add(new JLabel("��Ȩ����@zgf.2017.4.17,qq:1465567276"));
                dlg.setVisible(true);
            }
        });


    }

    private void sendExitMsg() {
        try {
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
            //������������˳���Ϣ
            String msg = "exit@#"+"ȫ��"+"@#@#"+tfdUserName.getText();
            pw.println(msg);

            tfdUserName.setEditable(true);
            lm.removeAllElements();//�����˳�Ҫ��lmȫ���Ƴ�  ��Ȼ�ٵ����ӻᵼ��֮ǰ�б��Ļ���
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    private  String HOST = "192.168.65.1";
    private  int PORT = 9090;
    private Socket clientSocket;
    private PrintWriter pw ;



    public void connecting() {
        try {
            clientSocket = new Socket(HOST,PORT);
            String userName = tfdUserName.getText();
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
                    }else if("cmdAdd".equals(msgs[0])){//�б�������Ϣ
                        lm.addElement(msgs[2]);
                    }else if("cmdRed".equals(msgs[0])){//�б�ɾ����Ϣ
                        lm.removeElement(msgs[2]);
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
                String msg = "on@#"+fname+"@#"+input.getText()+"@#"+tfdUserName.getText();
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