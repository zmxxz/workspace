package test1;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;public class Tongxunlu extends JFrame {
  JPanel cp=new JPanel();
  JTabbedPane jtp=new JTabbedPane();   //定义分页面板对象
  JPanel jp1=new JPanel();             //定义面板对象，做为分页使用
  JPanel jp2=new JPanel();
  JPanel jp3=new JPanel();
  
  JButton jb2=new JButton("请您点击这里查看信息!!!");
  Label l2=new Label(" 输入姓名: ");
    Label l3=new Label(" 输入电话:");
    Label l4=new Label(" 输入EMAIL:");
    Label l5=new Label(" 输入其他:");
    TextField tf2=new TextField(50);
    TextField tf3=new TextField(50);
    TextField tf4=new TextField(50);
    TextField tf5=new TextField(50);
    JButton b3=new JButton("录入",new ImageIcon("14.gif"));
     JButton b4=new JButton("清除",new ImageIcon("39.gif"));
    TextArea ta1=new TextArea("姓名            电话              EMAIL                          其他 \n栗晓政          0791-7124055      eceagle8086@yahoo.com.cn     相信自己！去做事吧！一切都会有改变!!!?\n \n雪落无声        029-85863658      xueluowusheng@yahoo.com.cn     雪见证了你的执著！！！\n",18,40);
  public Tongxunlu() {               //窗口Tongxunlu的构造函数
  setTitle("华东交通大学通讯系统欢迎欢迎您的光临！！！");
  setSize(500,400);
  this.addWindowListener(new WindowAdapter()
  {
   public void  windowClosing(WindowEvent e)
   {
    System.exit(0);
    }
  
  });  cp=(JPanel)this.getContentPane();     //取得Tongxunlu类的容器框架
  ImageIcon icon=new ImageIcon("middle.gif");   //定义图标  jp1.setLayout(new FlowLayout());   //设计jp1的布局
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
   b4.addActionListener(new kv());     //添加相应的监听者
   jb2.addActionListener(new mm());
jp2.setLayout(new BorderLayout());     //设计jp2的布局
jp2.add("North",jb2);
jp2.add("Center",ta1);
  jtp.add(jp1,0);
  jtp.setTitleAt(0,"输入信息");  jtp.addTab("查看信息",icon,jp2,"落霞与孤鹜齐飞，秋水共长天一色");
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
class kv implements ActionListener{             //类kv用来实现“清除”功能
public void actionPerformed(ActionEvent e){
Object source=e.getSource();
if(source==b4)
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
  }
}class qq implements ActionListener{          //类 qq用来实现将用户输入的数据写如到文件中
public void actionPerformed(ActionEvent e){Object source=e.getSource();
if(source==b3)
try 
{ File fw=new File("java123.doc");
RandomAccessFile out=new RandomAccessFile(fw,"rw"); 
if(fw.exists()) 
{ 
long length=fw.length(); 
out.seek(length);//定位文件读写指针到文件末尾，以免覆盖原来的数据； 
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
  }class mm implements ActionListener{         //类mm用来实现将数据从文件读如到文本区域中
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
  
  }  void jtpState(  ChangeEvent e)        //处理ChangeEvent 事件的方法
  {
   String s=new String();
   jp3=(JPanel)jtp.getSelectedComponent();   //取得被选分页   
  }}
