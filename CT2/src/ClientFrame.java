
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

public class ClientFrame extends JFrame implements ActionListener{
    private JTextField tfdUserName;
    private JTextArea allMsg;
    private JList list;
    private DefaultListModel lm;
    private JTextField tfdMsg;
    private JButton btnCon;
    private JButton btnExit;
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
        //�м�������Ϣ�ı���
        allMsg= new JTextArea();
        allMsg.setEditable(false);
        centerP.add(new JScrollPane(allMsg),BorderLayout.CENTER);
        //�м������û��б�
        lm = new DefaultListModel();
        list= new JList(lm);
        lm.addElement("ȫ��");
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(2);
        JScrollPane jc = new JScrollPane(list);
        jc.setBorder(new TitledBorder("����"));
        jc.setPreferredSize(new Dimension(100,centerP.getHeight()));
        centerP.add(jc,BorderLayout.EAST);

        //�²����
        JPanel sendP = new JPanel();
        getContentPane().add(sendP,BorderLayout.SOUTH);
        sendP.add(new JLabel("��Ϣ��"));
        tfdMsg = new JTextField(20);
        sendP.add(tfdMsg);
        JButton btnSend = new JButton("����");
        btnSend.setActionCommand("send");
        btnSend.addActionListener(this);
        sendP.add(btnSend);

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
                dlg.add(new JLabel("��Ȩ����@����.2016.05.15,qq:469547258"));
                dlg.setVisible(true);
            }
        });


    }
//    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        new ClientFrame();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("c")){
            System.out.println("���ӷ�����...");
            tfdUserName.setEditable(false);
            btnCon.setEnabled(false);
            connecting();
            btnExit.setEnabled(true);
            btnCon.setEnabled(false);

        }else if(e.getActionCommand().equals("send")){
            try {
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
                //�Ҷ�˭˵��ʲô��Ϣ
                if(tfdMsg.getText()==null || tfdMsg.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(this, "�������Ϣ");
                    return ;
                }
                String msg = "on@#"+list.getSelectedValue()+"@#"+tfdMsg.getText()+"@#"+tfdUserName.getText();
                pw.println(msg);
                //���ӵ��Լ������ ��Ϊ��¼
                allMsg.append("\r\n[��]˵��"+tfdMsg.getText());
                tfdMsg.setText("");

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else if(e.getActionCommand().equals("exit")){
            sendExitMsg();
        }


    }
    private void sendExitMsg() {
        try {
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
            //������������˳���Ϣ
            String msg = "exit@#"+"ȫ��"+"@#@#"+tfdUserName.getText();
            pw.println(msg);
//            btnCon.setEnabled(true);
//            btnExit.setEnabled(false);
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
                        }else{//�û�������Ϣ
                            str = "["+msgs[1]+"]˵:"+msgs[2];
                        }
                        allMsg.append("\r\n"+str);
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

}