
import java.io.*;  
import java.net.*;  
import javax.swing.*;  
import javax.swing.table.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.geom.*;  
import java.util.*;  
import java.nio.charset.*;  
import java.text.*;  
  
public class Client1   
{  
    //�����ͻ���Socket  
    static Socket s = null;  
    //��Ϣ������uid  
    static StringBuilder uidReceiver = null;  
  
    //public static void main(String[] args)
    public Client1()
    {  
        //�����ͻ��˴��ڶ���  
        ClientFrame cframe = new ClientFrame();  
        //���ڹرռ���Ч������ͨ���˳����˳��ͻ����Ա��ƺ�  
        cframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
        //��ȡ������Ļ����ֱ���  
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;  
        //��ȡ������Ļ����ֱ���  
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;  
        //����������  
        cframe.setLocation((w - cframe.WIDTH)/2, (h - cframe.HEIGHT)/2);  
        //���ÿͻ��˴���Ϊ�ɼ�  
        cframe.setVisible(true);  
          
        try  
        {  
            //���ӷ�����  
            s = new Socket(InetAddress.getLocalHost(), 10000);  
            //��ȡ������  
            InputStream in = s.getInputStream();  
            //��ȡ�����  
            OutputStream out = s.getOutputStream();  
  
            //��ȡ����˻�ӭ��Ϣ  
            byte[] buf = new byte[1024];  
            int len = in.read(buf);  
            //����ӭ��Ϣ��ӡ��������Ϣ����  
            cframe.jtaChat.append(new String(buf, 0, len));  
            cframe.jtaChat.append("\n");  
  
            //�����ȴ����շ�������Ϣֱ���˳�  
            while(true)  
            {  
                in = s.getInputStream();  
                len = in.read(buf);  
                System.out.println(len);  
                //������������������Ϣ  
                String msg = new String(buf, 0, len);  
                //��Ϣ���ͣ���������������������  
                String type = msg.substring(0, msg.indexOf("/"));  
                //��Ϣ���壺���º������������������  
                String content = msg.substring(msg.indexOf("/") + 1);  
                //������Ϣ���ͷֱ���  
                //������������  
                if(type.equals("OnlineListUpdate"))  
                {  
                    //��ȡ�����б�������ģ��  
                    DefaultTableModel tbm = (DefaultTableModel) cframe.jtbOnline.getModel();  
                    //������������б�  
                    tbm.setRowCount(0);  
                    //������������  
                    String[] onlinelist = content.split(",");  
                    //��һ���ӵ�ǰ������  
                    for(String member : onlinelist)  
                    {  
                        String[] tmp = new String[3];  
                        //������Լ�������������ʾ  
                        if(member.equals(InetAddress.getLocalHost().getHostAddress() + ":" + s.getLocalPort()))  
                            continue;  
                        tmp[0] = "";  
                        tmp[1] = member.substring(0, member.indexOf(":"));  
                        tmp[2] = member.substring(member.indexOf(":") + 1);  
                        //���ӵ�ǰ������֮һ  
                        tbm.addRow(tmp);  
                    }  
                    //��ȡ�����б�����Ⱦģ��  
                    DefaultTableCellRenderer tbr = new DefaultTableCellRenderer();  
                    //�������ݾ�����ʾ  
                    tbr.setHorizontalAlignment(JLabel.CENTER);  
                    cframe.jtbOnline.setDefaultRenderer(Object.class, tbr);  
                }  
                //����  
                else if(type.equals("Chat"))  
                {  
                    String sender = content.substring(0, content.indexOf("/"));  
                    String word = content.substring(content.indexOf("/") + 1);  
                    //�����촰��ӡ������Ϣ  
                    cframe.jtaChat.append(cframe.sdf.format(new Date()) + "\n���� " + sender + ":\n" + word + "\n\n");  
                    //��ʾ������Ϣ  
                    cframe.jtaChat.setCaretPosition(cframe.jtaChat.getDocument().getLength());  
                }  
            }  
        }  
        catch(Exception e)  
        {  
            cframe.jtaChat.append("����������.....\n");  
            e.printStackTrace();  
        }  
    }  
}  
  
//�ͻ��˴���  
class ClientFrame extends JFrame  
{  
    //ʱ����ʾ��ʽ  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
  
    //���ڿ���  
    final int WIDTH = 700;  
    //���ڸ߶�  
    final int HEIGHT = 700;  
      
    //�������Ͱ�ť  
    JButton btnSend = new JButton("����");  
    //���������ť  
    JButton btnClear = new JButton("����");  
    //�����˳���ť  
    JButton btnExit = new JButton("�˳�");  
  
    //������Ϣ�����߱�ǩ  
    JLabel lblReceiver = new JLabel("��˭˵��");  
  
    //�����ı������, �����ֱ�Ϊ����������  
    JTextArea jtaSay = new JTextArea();  
  
    //����������Ϣ��  
    JTextArea jtaChat = new JTextArea();  
  
    //��ǰ�����б����б���  
    String[] colTitles = {"����", "IP", "�˿�"};  
    //��ǰ�����б�������  
    String[][] rowData = null;  
    //������ǰ�����б�  
    JTable jtbOnline = new JTable  
                                (  
                                    new DefaultTableModel(rowData, colTitles)  
                                    {  
                                        //���񲻿ɱ༭��ֻ����ʾ  
                                        @Override  
                                        public boolean isCellEditable(int row, int column)  
                                        {  
                                            return false;  
                                        }  
                                    }  
                                );  
      
    //����������Ϣ��Ĺ�����  
    JScrollPane jspChat = new JScrollPane(jtaChat);  
  
    //������ǰ�����б��Ĺ�����  
    JScrollPane jspOnline = new JScrollPane(jtbOnline);  
  
    //����Ĭ�ϴ������ԣ����Ӵ������  
    public ClientFrame()  
    {  
        //����  
        setTitle("������");  
        //��С  
        setSize(WIDTH, HEIGHT);  
        //��������  
        setResizable(false);  
        //���ò���:������Ĭ�ϲ��֣���ȫ�Զ���  
        setLayout(null);  
  
        //���ð�ť��С��λ��  
        btnSend.setBounds(20, 600, 100, 60);  
        btnClear.setBounds(140, 600, 100, 60);  
        btnExit.setBounds(260, 600, 100, 60);  
  
        //���ñ�ǩ��С��λ��  
        lblReceiver.setBounds(20, 420, 300, 30);  
  
        //���ð�ť�ı�������  
        btnSend.setFont(new Font("����", Font.BOLD, 18));  
        btnClear.setFont(new Font("����", Font.BOLD, 18));  
        btnExit.setFont(new Font("����", Font.BOLD, 18));  
  
        //���Ӱ�ť  
        this.add(btnSend);  
        this.add(btnClear);  
        this.add(btnExit);  
  
        //���ӱ�ǩ  
        this.add(lblReceiver);  
  
        //�����ı�������С��λ��  
        jtaSay.setBounds(20, 460, 360, 120);  
        //�����ı����������  
        jtaSay.setFont(new Font("����", Font.BOLD, 16));  
        //�����ı������  
        this.add(jtaSay);  
          
        //������Ϣ���Զ�����  
        jtaChat.setLineWrap(true);  
        //����򲻿ɱ༭��ֻ������ʾ  
        jtaChat.setEditable(false);  
        //�������������  
        jtaChat.setFont(new Font("����", Font.BOLD, 16));  
  
        //���ù�������ˮƽ����������:������  
        jspChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        //���ù������Ĵ�ֱ����������:��Ҫʱ�Զ�����  
        jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        //���ù�������С��λ��  
        jspChat.setBounds(20, 20, 360, 400);  
        //�������촰�ڵĹ�����  
        this.add(jspChat);  
  
        //���ù�������ˮƽ����������:������  
        jspOnline.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        //���ù������Ĵ�ֱ����������:��Ҫʱ�Զ�����  
        jspOnline.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        //���õ�ǰ�����б���������С��λ��  
        jspOnline.setBounds(420, 20, 250, 400);  
        //���ӵ�ǰ�����б�  
        this.add(jspOnline);  
  
        //���ӷ��Ͱ�ť����Ӧ�¼�  
        btnSend.addActionListener  
                                (  
                                     new ActionListener()  
                                     {  
                                        @Override  
                                        public void actionPerformed(ActionEvent event)  
                                        {  
                                            //��ʾ������Ϣ  
                                            jtaChat.setCaretPosition(jtaChat.getDocument().getLength());  
                                            try  
                                            {  
                                                //�������˲ŷ���  
                                                if(Client1.uidReceiver.toString().equals("") == false)  
                                                {  
                                                    //�����촰��ӡ���Ͷ�����Ϣ  
                                                    jtaChat.append(sdf.format(new Date()) + "\n���� " + Client1.uidReceiver.toString() + ":\n");  
                                                    //��ʾ������Ϣ  
                                                    jtaChat.append(jtaSay.getText() + "\n\n");  
                                                    //�����������������Ϣ  
                                                    OutputStream out = Client1.s.getOutputStream();  
                                                    out.write(("Chat/" + Client1.uidReceiver.toString() + "/" + jtaSay.getText()).getBytes());  
                                                }   
                                            }  
                                            catch(Exception e){}  
                                            finally  
                                            {  
                                                //�ı���������  
                                                jtaSay.setText("");  
                                            }  
                                        }  
                                     }  
                                );  
        //����������ť����Ӧ�¼�  
        btnClear.addActionListener  
                                (  
                                     new ActionListener()  
                                     {  
                                        @Override  
                                        public void actionPerformed(ActionEvent event)  
                                        {  
                                            //���������  
                                            jtaChat.setText("");  
                                        }  
                                     }  
                                );  
        //�����˳���ť����Ӧ�¼�  
        btnExit.addActionListener  
                                (  
                                     new ActionListener()  
                                     {  
                                        @Override  
                                        public void actionPerformed(ActionEvent event)  
                                        {  
                                            try  
                                            {  
                                                //������������˳���Ϣ  
                                                OutputStream out = Client1.s.getOutputStream();  
                                                out.write("Exit/".getBytes());  
                                                //�˳�  
                                                System.exit(0);  
                                            }  
                                            catch(Exception e){}  
                                        }  
                                     }  
                                );  
        //���������б�����ѡ�е���Ӧ�¼�  
        jtbOnline.addMouseListener  
                                (  
                                    new MouseListener()  
                                    {  
                                        @Override  
                                        public void mouseClicked(MouseEvent event)  
                                        {  
                                            //ȡ�������б�������ģ��  
                                            DefaultTableModel tbm = (DefaultTableModel) jtbOnline.getModel();  
                                            //��ȡ���ѡ�е�����Ϊ��ϢĿ�꣬����һ���ˣ����ȫ�������߽�����Ϣ  
                                            int[] selectedIndex = jtbOnline.getSelectedRows();  
                                            //��������ϢĿ���uidƴ�ӳ�һ���ַ���, �Զ��ŷָ�  
                                            Client1.uidReceiver = new StringBuilder("");  
                                            for(int i = 0; i < selectedIndex.length; i++)  
                                            {  
                                                Client1.uidReceiver.append((String) tbm.getValueAt(selectedIndex[i], 1));  
                                                Client1.uidReceiver.append(":");  
                                                Client1.uidReceiver.append((String) tbm.getValueAt(selectedIndex[i], 2));  
                                                if(i != selectedIndex.length - 1)  
                                                    Client1.uidReceiver.append(",");  
                                            }  
                                            lblReceiver.setText("������" + Client1.uidReceiver.toString());  
                                        }  
                                        @Override  
                                        public void mousePressed(MouseEvent event){};  
                                        @Override  
                                        public void mouseReleased(MouseEvent event){};  
                                        @Override  
                                        public void mouseEntered(MouseEvent event){};  
                                        @Override  
                                        public void mouseExited(MouseEvent event){};  
                                    }  
                                );  
    }  
}