package test1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Delete extends javax.swing.JFrame {
public Delete() {
initComponents();
}
private void initComponents() {
super.setTitle(" 删除联系人");
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
jButton2.setText("\u5220\u9664");
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
.addContainerGap(23, Short.MAX_VALUE)
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
.addContainerGap(21, Short.MAX_VALUE)));
pack();
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
DBdao db = new DBdao();
db.delPerson(person);
JOptionPane.showMessageDialog(this, " 删除成功");
}
Person person;
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
String name = jTextField1.getText();
String phone = jTextField2.getText();
person = new Person();
person.setName(name);
person.setPhone(phone);
QueryDAO qdb = new QueryDAO();
ArrayList<Person> alist = qdb.queryPerson(person);
if(alist.size()>0){
jTextField1.setText(alist.get(0).getName());
jTextField2.setText(alist.get(0).getPhone());
}else{
JOptionPane.showMessageDialog(this, " 无此联系人");
}
}
/*public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Delete de = new Delete();
de.setVisible(true);
de.setLocationRelativeTo(null);
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
