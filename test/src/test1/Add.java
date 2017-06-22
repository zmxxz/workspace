package test1;
import javax.swing.JOptionPane;
public class Add extends javax.swing.JFrame {
public Add() {
initComponents();
}
private void initComponents() {
super.setTitle(" 添加联系人");
jLabel2 = new javax.swing.JLabel();
jTextField2 = new javax.swing.JTextField();
jLabel1 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
jLabel2.setText("\u7535\u8bdd");
jLabel1.setText("\u59d3\u540d");
jButton1.setText("\u589e\u52a0");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
getContentPane());
getContentPane().setLayout(layout);
layout
.setHorizontalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGap(0, 401, Short.MAX_VALUE)
.addGroup(
javax.swing.GroupLayout.Alignment.TRAILING,
layout
.createSequentialGroup()
.addContainerGap(40, Short.MAX_VALUE)
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
.addGap(32, 32, 32).addComponent(
jButton1).addGap(84, 84, 84)));
layout
.setVerticalGroup(layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGap(0, 89, Short.MAX_VALUE)
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
javax.swing.GroupLayout.PREFERRED_SIZE))
.addContainerGap(20, Short.MAX_VALUE)));
pack();
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
String name = jTextField1.getText();
String phone = jTextField2.getText();
Person person = new Person();
person.setName(name);
person.setPhone(phone);
DBdao db = new DBdao();
db.addPerson(person);
JOptionPane.showMessageDialog(null, " 添加成功");
}
/*public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
Add add = new Add();
add.setVisible(true);
add.setLocationRelativeTo(null);
}
});
}*/
private javax.swing.JButton jButton1;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
}
