package test1;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Query extends javax.swing.JFrame {
public Query() {
initComponents();
}
private void initComponents() {
super.setTitle(" 查询联系人");
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jTextField2 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jScrollPane1 = new javax.swing.JScrollPane();
jTable1 = new javax.swing.JTable();
setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
jLabel1.setText("\u59d3\u540d");
jLabel2.setText("\u7535\u8bdd");
jButton1.setText("\u67e5\u8be2");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
jTable1.setModel(new javax.swing.table.DefaultTableModel(
new Object[][] { { null, null }, { null, null },
{ null, null }, { null, null } }, new String[] { " 姓名",
"电话" }));
jScrollPane1.setViewportView(jTable1);
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
.addContainerGap(26, Short.MAX_VALUE)
.addGroup(
layout
.createParallelGroup(
javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(
layout
.createSequentialGroup()
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
.addGap(
32,
32,
32)
.addComponent(
jButton1)
.addContainerGap())
.addGroup(
javax.swing.GroupLayout.Alignment.TRAILING,
layout
.createSequentialGroup()
.addComponent(
jScrollPane1,
javax.swing.GroupLayout.PREFERRED_SIZE,
375,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap()))));
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
javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(6, 6, 6)
.addComponent(
jScrollPane1,
javax.swing.GroupLayout.PREFERRED_SIZE,
94,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(
javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)));
pack();
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
Person person = new Person();
String name = jTextField1.getText().trim();
String phone = jTextField2.getText().trim();
if (name.equals("")) {
person.setName("-1");
} else {
person.setName(name);
}
if (phone.equals("")) {
person.setPhone("-1");
} else {
person.setPhone(phone);
}
QueryDAO qdao = new QueryDAO();
ArrayList<Person> alist = new ArrayList<Person>();
alist = qdao.queryPerson(person);
Vector<String> vdate = null;
DefaultTableModel dm = new DefaultTableModel();
dm.setColumnCount(2);
if (alist.size() > 0) {
for (int i = 0; i < alist.size(); i++) {
vdate = new Vector<String>();
String Accountmessage1 = alist.get(i).getName();
String Accountmessage2 = alist.get(i).getPhone();
vdate.add(Accountmessage1);
vdate.add(Accountmessage2);
dm.addRow(vdate);
jTable1.setModel(dm);
}
}else{
JOptionPane.showMessageDialog(null, " 无此联系人");
}
}
/*
* public static void main(String args[]) {
* java.awt.EventQueue.invokeLater(new Runnable() { public void run() {
* Query qu = new Query(); qu.setLocationRelativeTo(null);
* qu.setVisible(true); } }); }
*/
private javax.swing.JButton jButton1;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTable jTable1;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
}
