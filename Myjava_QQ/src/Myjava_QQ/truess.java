package Myjava_QQ;

import java.awt.*; 
import javax.swing.*; 
import javax.swing.tree.*; 
import java.awt.event.*; 
import javax.swing.event.*;

import Load_QQ.AboutQQ;
//import My_make_QQ.tree;

public class truess extends JFrame 
{ 
JPanel cp=new JPanel(); 
JTree jtree; 
static DefaultMutableTreeNode root; 

public truess() 
{ 
   this.setTitle("QQ2010"); 
    cp=(JPanel)this.getContentPane(); 
    cp.setLayout(new BorderLayout()); 
   
    root=new DefaultMutableTreeNode("通讯录"); 
    createTree(root); 
    jtree=new JTree(root); 
    cp.add(jtree,BorderLayout.CENTER); 
    System.out.println("root     "+root.getUserObject());
    jtree.addTreeSelectionListener(new TreeSelectionListener() {
    public void valueChanged(TreeSelectionEvent e) {
     DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
     jtree.getLastSelectedPathComponent();
     if (node == null)
      return;
     if (node.isLeaf()) {
    
      //Client s=new Client();
     new AboutQQ();
     } else {
     
    }}
   });

   this.setSize(200,500); 
   setVisible(true); 

} 

private static void createTree (DefaultMutableTreeNode root) 
{ 
   DefaultMutableTreeNode classroom=null; 
   DefaultMutableTreeNode number=null; 
   DefaultMutableTreeNode frieds =null; 
   DefaultMutableTreeNode zhiji=null; 
   DefaultMutableTreeNode network=null;
   DefaultMutableTreeNode frinode =null; 
   DefaultMutableTreeNode zhijinode=null; 
   DefaultMutableTreeNode networknode=null;
   classroom=new DefaultMutableTreeNode("08计算机班"); 
   frieds=new DefaultMutableTreeNode("我的好友"); 
   zhiji=new DefaultMutableTreeNode("知己"); 
   network=new DefaultMutableTreeNode("网络友人"); 
   
   root.add(classroom); 
   root.add(frieds); 
   root.add(zhiji); 
   root.add(network); 
   String res[]={"兰志杰"," 张瑞","赵杰","冶志锋"};
   for(int i=1;i<=4;i++){
    frinode=new DefaultMutableTreeNode("NO"+String.valueOf(i));
    frieds.add(frinode);
   }
   for(int i=1;i<=4;i++){
    zhijinode=new DefaultMutableTreeNode("No."+String.valueOf(i)); 
    zhiji.add(zhijinode);
   }
   for(int i=1;i<=4;i++){
    networknode=new DefaultMutableTreeNode("No."+String.valueOf(i));
    network.add(networknode);
   }
   for(int i=1;i<3;i++) 
   { 
    number=new DefaultMutableTreeNode("No."+String.valueOf(i)); 

    if(i==4) 
    
   classroom.add(number); 
   } 
} 

protected void processWindowEvent(WindowEvent e) 
{ 
   if(e.getID()==WindowEvent.WINDOW_CLOSING) 
   { 
    System.exit(0); 
   } 
} 
}
