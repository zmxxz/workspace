package test1;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;public class Tongxunlu extends JFrame {
  JPanel cp=new JPanel();
  JTabbedPane jtp=new JTabbedPane();   //�����ҳ������
  JPanel jp1=new JPanel();             //������������Ϊ��ҳʹ��
  JPanel jp2=new JPanel();
  JPanel jp3=new JPanel();
  
  JButton jb2=new JButton("�����������鿴��Ϣ!!!");
  Label l2=new Label(" ��������: ");
    Label l3=new Label(" ����绰:");
    Label l4=new Label(" ����EMAIL:");
    Label l5=new Label(" ��������:");
    TextField tf2=new TextField(50);
    TextField tf3=new TextField(50);
    TextField tf4=new TextField(50);
    TextField tf5=new TextField(50);
    JButton b3=new JButton("¼��",new ImageIcon("14.gif"));
     JButton b4=new JButton("���",new ImageIcon("39.gif"));
    TextArea ta1=new TextArea("����            �绰              EMAIL                          ���� \n������          0791-7124055      eceagle8086@yahoo.com.cn     �����Լ���ȥ���°ɣ�һ�ж����иı�!!!?\n \nѩ������        029-85863658      xueluowusheng@yahoo.com.cn     ѩ��֤�����ִ��������\n",18,40);
  public Tongxunlu() {               //����Tongxunlu�Ĺ��캯��
  setTitle("������ͨ��ѧͨѶϵͳ��ӭ��ӭ���Ĺ��٣�����");
  setSize(500,400);
  this.addWindowListener(new WindowAdapter()
  {
   public void  windowClosing(WindowEvent e)
   {
    System.exit(0);
    }
  
  });  cp=(JPanel)this.getContentPane();     //ȡ��Tongxunlu����������
  ImageIcon icon=new ImageIcon("middle.gif");   //����ͼ��  jp1.setLayout(new FlowLayout());   //���jp1�Ĳ���
  jp1.setBackground(Color.cyan);     
 
  jp1.add(l2);
  jp1.add(tf2);
  jp1.add(l3);
  jp1.add(tf3);
  jp1.add(l4);
  jp1.add(tf4);
  jp1.add(l5);
  jp1.add(tf5); 
  jp1.add(b3);
  jp1.add(b4);
  
   b3.addActionListener(new qq());
   b4.addActionListener(new kv());     //�����Ӧ�ļ�����
   jb2.addActionListener(new mm());
jp2.setLayout(new BorderLayout());     //���jp2�Ĳ���
jp2.add("North",jb2);
jp2.add("Center",ta1);
  jtp.add(jp1,0);
  jtp.setTitleAt(0,"������Ϣ");  jtp.addTab("�鿴��Ϣ",icon,jp2,"��ϼ�������ɣ���ˮ������һɫ");
  jtp.setSelectedIndex(0);
  jtp.addChangeListener(new ChangeListener()
  {
    public void stateChanged(ChangeEvent e)
    {
     jtpState(e);
    }
  });
  cp.add(jtp);
  }
class kv implements ActionListener{             //��kv����ʵ�֡����������
public void actionPerformed(ActionEvent e){
Object source=e.getSource();
if(source==b4)
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
  }
}class qq implements ActionListener{          //�� qq����ʵ�ֽ��û����������д�絽�ļ���
public void actionPerformed(ActionEvent e){Object source=e.getSource();
if(source==b3)
try 
{ File fw=new File("java123.doc");
RandomAccessFile out=new RandomAccessFile(fw,"rw"); 
if(fw.exists()) 
{ 
long length=fw.length(); 
out.seek(length);//��λ�ļ���дָ�뵽�ļ�ĩβ�����⸲��ԭ�������ݣ� 
} if(tf2.getText().equals("")) 
{ 
}
else
{
  out.writeUTF(tf2.getText()+"          "+tf3.getText()+"      "+tf4.getText()+"     "+tf5.getText()); 
  out.close(); 
     }
     }
catch(IOException ee) 
{ 
} 
     }
  }class mm implements ActionListener{         //��mm����ʵ�ֽ����ݴ��ļ����絽�ı�������
public void actionPerformed(ActionEvent e){
String s="";
Object source=e.getSource();
if(source==jb2)
try 
{ int number=1;
      File fw=new File("java123.doc");
   RandomAccessFile in= new RandomAccessFile(fw,"rw");
   String xingming=null; 
ta1.setText(null); 
while((xingming=in.readUTF())!=null) 
{ 
ta1.append("\n"+number+". " +xingming); number++; 
} 
in.close(); 
} 
catch(Exception ee) 
{ 
} 
  
     }
  }
  public static void main(String[] args) {
    Tongxunlu tabpane2 = new Tongxunlu();
   tabpane2.setVisible(true);
  
  }  void jtpState(  ChangeEvent e)        //����ChangeEvent �¼��ķ���
  {
   String s=new String();
   jp3=(JPanel)jtp.getSelectedComponent();   //ȡ�ñ�ѡ��ҳ   
  }}
