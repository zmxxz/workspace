
package Myjava_QQ;

import java.awt.*;
import javax.swing.*;

import Myjava_QQ.truess;

import java.awt.event.*;
import java.applet.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.sql.*;
import java.lang.*;

class Imagecanvas extends Canvas
{ Toolkit tool;
Image myimage;
Imagecanvas()
     {
     setSize(326,47);
     tool=getToolkit();
     myimage=tool.getImage("h.jpg");
     
       }
public void paint(Graphics g)
{
   g.drawImage(myimage,0,0,326,47,this);
   }

}

//class Paii5 extends JFrame implements ActionListener


class Paii5 extends JFrame 
{
Paii5() 
{
   
   setResizable(false);

//Frame fra=new Frame("QQ2010");
   //setSize(330,240);
   setBounds(350, 300, 330,240);
Container c=getContentPane();
//c.setLayout(new FlowLayout(100,100,10));
FlowLayout layout=new FlowLayout(FlowLayout.CENTER);
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
JPanel p4=new JPanel();
ImageIcon image=new ImageIcon(getClass().getResource("/image/0.jpg"));//创建一个未初始化的图像图标
     JLabel jl5=new JLabel(image);//http://benqubo.spaces.live.com/Blog/cns!97A24DA5D4C1908B!322.entry
Imagecanvas canvas1=new Imagecanvas(); 
     //p1.setSize(326,47); 
     //p1.add(canvas1);
    
      final JTextField username=new JTextField(11);
      final TextField paword=new TextField(15);
        paword.setEchoChar('*');
JButton buttonentrystu=new JButton("申请号码");
     JButton buttonentryteacher=new JButton("高级设置");
     JButton buttonentryadmin=new JButton("登 录");
     JButton buttonreset=new JButton("取 消");
     JCheckBox check1=new JCheckBox("自动登陆    ");
     JCheckBox check2=new JCheckBox("隐身登陆");
        
     JPanel p21=new JPanel();
     JPanel p22=new JPanel();
     p21.add(new JLabel("QQ号码:"));
     p21.add(username);
     p21.add(buttonentrystu);
     p21.add(new JLabel("QQ密码:"));
     p21.add(paword);
     p21.add(new JLabel("<html><font color=blue>忘记密码?</font><html>"));
     p21.add(new JLabel("        "));
     
     p22.add(new JLabel("              "));
     p22.add(check1);
     p22.add(check2);
     p22.add(new JLabel("              "));
     p4.add(jl5);
this.add(p4,BorderLayout.NORTH);
     p22.add(buttonentryteacher);
     p22.add(new JLabel("                    "));
     p22.add(buttonentryadmin);
     p22.add(new JLabel("    "));
     p22.add(buttonreset);
     p2.add(p21);
     p2.add(p22);
     p2.setBounds(150,300, 200, 300);
    
     p2.setLayout(new GridLayout(2,1,10,10));
     p3.setSize(400,100);
     p3.add(new JLabel("<html><font color=#006600>建筑学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;兰志杰</font></html>"));//设置字体颜色
     setLayout(new BorderLayout());
     add(BorderLayout.NORTH,p4);
     add(BorderLayout.CENTER,p2);
     add(BorderLayout.SOUTH,p3);
     this.setTitle("腾讯QQ2010");
     buttonentryadmin.addActionListener(new ActionListener(){

   public void actionPerformed(ActionEvent e) {
  
    paword.getText();
    boolean flag =true;
   
    try {
     BufferedReader br=new BufferedReader( new FileReader
       ("e:/Sysresorce.txt"));
          String res=br.readLine();
   
      if(paword.getText().equals(res)){
      
       new truess(); 
       setVisible(false);
     
      }else{
      flag=false;
      }
     }
        catch (FileNotFoundException e1) {
    
     e1.printStackTrace();
    } catch (IOException e1) {
   
     e1.printStackTrace();
    }
   }
  
});
     check1.addActionListener(new ActionListener(){

   public void actionPerformed(ActionEvent e) {
    paword.setText("111");
    new truess(); 
    setVisible(false);
    } 
  
});
     buttonreset.addActionListener(new ActionListener(){

   public void actionPerformed(ActionEvent e) {
   
    username.setText("");
    paword.setText("");
   }
    
     });
     setVisible(true);
    
    addWindowListener(new WindowAdapter()
    {public void windowClosing(WindowEvent e)
         {System.exit(0);}
     });

     }

     
}
public class Mydenglu_interface
{

public static void main(String args[])
{
    Paii5 app=new Paii5(); 
    
  
}

}
