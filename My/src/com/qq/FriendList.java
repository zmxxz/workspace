package com.qq;

import java.awt.*; 
import javax.swing.*; 
import javax.swing.tree.*; 
import java.awt.event.*; 
import javax.swing.event.*;

public class FriendList extends JFrame { 
JPanel cp=new JPanel(); 
JTree jtree; 
static DefaultMutableTreeNode root; 
static String s;

public FriendList(){ 
	this.setTitle("MyQQ"); 
    cp=(JPanel)this.getContentPane(); 
    cp.setLayout(new BorderLayout()); 
   
    root=new DefaultMutableTreeNode("通讯录"); 
    createTree(root); 
    jtree=new JTree(root); 
    cp.add(jtree,BorderLayout.CENTER); 
    System.out.println("root     "+root.getUserObject()); 
    this.setSize(200,500); 
    setVisible(true);
    
	jtree.addTreeSelectionListener(new TreeSelectionListener(){
	    public void valueChanged(TreeSelectionEvent e) {
	    	DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
	    	jtree.getLastSelectedPathComponent();
	    	if (node == null)
	    		return;
	    	if(s!=null){
	    		if(node.isLeaf()&&!node.toString().equals(s)){
	    			s = node.toString();
	    			new Thread(new ChatRoom(s)).start();
			    	System.out.println("in jtree:"+s);
	    			System.out.println("================");
	    		}
	    	}else {
		    	s = node.toString();
		    	System.out.println("in jtree:"+s);
		    	new Thread(new ChatRoom(s)).start();	
	    	}
	    }
    });

} 

private static void createTree (DefaultMutableTreeNode root){ 
   DefaultMutableTreeNode classroom=null; 
   DefaultMutableTreeNode number=null; 
   DefaultMutableTreeNode somebody =null; 
   DefaultMutableTreeNode relatives=null; 
   DefaultMutableTreeNode friend=null;
   DefaultMutableTreeNode frinode =null; 
   DefaultMutableTreeNode relativesnode=null; 
   DefaultMutableTreeNode friendnode=null;
   classroom=new DefaultMutableTreeNode("1614302"); 
   somebody=new DefaultMutableTreeNode("qq好友"); 
   relatives=new DefaultMutableTreeNode("家人"); 
   friend=new DefaultMutableTreeNode("朋友"); 
   
   root.add(classroom); 
   root.add(somebody); 
   root.add(relatives); 
   root.add(friend); 

   for(int i = 1;i <= 4;i++){
	   frinode=new DefaultMutableTreeNode("No."+String.valueOf(i));
	   somebody.add(frinode);
   }
   
//   for(int i = 1;i <= 4;i++){
	    relativesnode=new DefaultMutableTreeNode("192.168.191.1"); 
	    relatives.add(relativesnode);
	    relativesnode=new DefaultMutableTreeNode("192.168.191.2"); 
	    relatives.add(relativesnode);
//   }
   
   for(int i = 1;i <= 4;i++){
	    friendnode=new DefaultMutableTreeNode("No."+String.valueOf(i));
	    friend.add(friendnode);
   }
   
   for(int i = 1;i < 3;i++){ 
	   number=new DefaultMutableTreeNode("No."+String.valueOf(i)); 

	   if(i==4) 
    
		   classroom.add(number); 
   } 
} 

protected void processWindowEvent(WindowEvent e){ 
   if(e.getID()==WindowEvent.WINDOW_CLOSING){ 
    System.exit(0); 
   } 
} 
}
