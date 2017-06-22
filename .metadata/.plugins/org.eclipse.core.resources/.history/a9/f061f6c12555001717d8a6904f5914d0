package test1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Alter extends javax.swing.JFrame {
public Alter() {
initComponents();
}
private void initComponents() {
super.setTitle(" 修改联系人");
jLabel2 = new javax.swing.JLabel();
jTextField2 = new javax.swing.JTextField();
jLabel1 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
jLabel2.setText("\u7535\u8bdd");
jLabel1.setText("\u59d3\u540d");
jButton1.setText("\u67e5\u8be2");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
jButton2.setText("\u4fee\u6539");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
getContentPane());
getContentPane().setLayout(layout);
layout
.setHorizontalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
javax.swing.GroupLayout.Alignment.TRAILING,
layout
.createSequentialGroup()
.addContainerGap(39, Short.MAX_VALUE)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING,
false)
.addGroup(
layout
.createSequentialGroup()
.addComponent(
jLabel2)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(
jTextField2,
javax.swing.GroupLayout.PREFERRED_SIZE,
160,
javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(
layout
.createSequentialGroup()
.addComponent(
jLabel1)
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(
jTextField1)))
.addGap(32, 32, 32)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jButton1)
.addComponent(jButton2))
.addGap(84, 84, 84)));
layout
.setVerticalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
layout
.createSequentialGroup()
.addGap(19, 19, 19)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(
jTextField1,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jButton1))
.addPreferredGap(
javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel2)
.addComponent(
jTextField2,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jButton2))
.addContainerGap(18, Short.MAX_VALUE)));
pack();
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
DBdao db = new DBdao();
String name = jTextField1.getText();
String phone = jTextField2.getText();
Person person = new Person();
person.setName(name);
person.setPhone(phone);
db.alterPerson(person);
JOptionPane.showMessageDialog(this, " 修改成功!");
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
String name = jTextField1.getText();
String phone = jTextField2.getText();
Person person = new Person();
person.setName(name);
person.setPhone(phone);
QueryDAO qdb = new QueryDAO();
ArrayList<Person> alist = qdb.queryPerson(person);
if(alist.size()>0){
jTextField1.setText(alist.get(0).getName());
jTextField2.setText(alist.get(0).getPhone());
}else{
JOptionPane.showMessageDialog(this, " 无此联系人!");
}
}
/*public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Alter al = new Alter();
al.setVisible(true);
al.setLocationRelativeTo(null);
}
});
}*/
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
}
