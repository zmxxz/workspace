package test1;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

public class MainFrame extends javax.swing.JFrame {
public MainFrame() {
initComponents();
}
private void initComponents() {
super.setTitle(" ͨѶ¼");
jLabel1 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jButton3 = new javax.swing.JButton();
jButton4 = new javax.swing.JButton();
jScrollPane1 = new javax.swing.JScrollPane();
jTable1 = new javax.swing.JTable();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jLabel1.setText("My ͨѶ¼");
jLabel1.setFont(new Font(" ����",4,24 ));
jButton1.setText("\u67e5\u8be2");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
jButton2.setText("\u589e\u52a0");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});
jButton3.setText("\u4fee\u6539");
jButton3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton3ActionPerformed(evt);
}
});
jButton4.setText("\u5220\u9664");
jButton4.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton4ActionPerformed(evt);
}
});
jTable1.setModel(new javax.swing.table.DefaultTableModel(
new Object[][] { { null, null }, { null, null },
{ null, null }, { null, null }, { null, null },
{ null, null } }, new String[] { " ����", " �绰" }) {
Class[] types = new Class[] { java.lang.String.class,
java.lang.String.class };
public Class getColumnClass(int columnIndex) {
return types[columnIndex];
}
});
jScrollPane1.setViewportView(jTable1);
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
getContentPane());
getContentPane().setLayout(layout);
layout
.setHorizontalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
layout.createSequentialGroup().addGap(134, 134,
134).addComponent(jLabel1)
.addContainerGap())
.addGroup(
layout
.createSequentialGroup()
.addGap(19, 19, 19)
.addComponent(
jScrollPane1,
javax.swing.GroupLayout.DEFAULT_SIZE,
358, Short.MAX_VALUE)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jButton1)
.addComponent(jButton2)
.addComponent(jButton3)
.addComponent(jButton4))
.addGap(20, 20, 20)));
layout
.setVerticalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
layout
.createSequentialGroup()
.addGap(20, 20, 20)
.addComponent(jLabel1)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
layout
.createSequentialGroup()
.addComponent(
jButton1)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(
jButton2)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(
jButton3)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(
jButton4))
.addComponent(
jScrollPane1,
javax.swing.GroupLayout.DEFAULT_SIZE,
127,
Short.MAX_VALUE))
.addContainerGap()));
pack();
MainFrame.showAccount(jTable1);
}
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Delete de = new Delete();
de.setVisible(true);
de.setLocationRelativeTo(null);
}
});
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Alter al = new Alter();
al.setVisible(true);
al.setLocationRelativeTo(null);
}
});
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Add add = new Add();
add.setVisible(true);
add.setLocationRelativeTo(null);
}
});
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Query qu = new Query();
qu.setLocationRelativeTo(null);
qu.setVisible(true);
}
});
}
@Test
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
MainFrame mf = new MainFrame();
mf.setVisible(true);
mf.setLocationRelativeTo(null);
}
});
}
protected static void showAccount(JTable jt) {
ArrayList<Person> alist = new ArrayList<Person>();
DBdao dbdao = new DBdao();
alist = dbdao.query();
Vector<String> vdate = null;
DefaultTableModel dm = new DefaultTableModel();
dm.setColumnCount(2);
for (int i = 0; i < alist.size(); i++) {
vdate = new Vector<String>();
String Accountmessage1 = alist.get(i).getName();
String Accountmessage2 = alist.get(i).getPhone();
vdate.add(Accountmessage1);
vdate.add(Accountmessage2);
dm.addRow(vdate);
}
jt.setModel(dm);
}
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JLabel jLabel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTable jTable1;
}




