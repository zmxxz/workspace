package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DBdao {
Connection conn = null;
PreparedStatement state = null;
ResultSet result = null;
// ���һ��connection ����
public Connection getConnection() {
String URL = "jdbc:mysql://localhost:3306/ ��ͥ���ϵͳ?characterEncoding=utf-8";
String USER = "root";
String PASSWORD = "123456";
try {
conn = DriverManager.getConnection(URL, USER, PASSWORD);
} catch (SQLException e) {
e.printStackTrace();
}
return conn;
}
public void freeResource(ResultSet result,PreparedStatement state,Connection conn) {
if (result != null) {
try {
result.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
if (state != null) {
try {
state.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
// ��ѯ
public ArrayList<Person> query(){
ArrayList<Person> arrlist = new ArrayList<Person>();
DBdao db = new DBdao();
Connection conn = null;
PreparedStatement state = null;
ResultSet result = null;
conn = db.getConnection();
String sql = "select * from tongxun";
try {
state = conn.prepareStatement(sql);
result = state.executeQuery();
while(result.next()){
String name = result.getString("name");
String phone = result.getString("phone");
Person person = new Person();
person.setName(name);
person.setPhone(phone);
arrlist.add(person);
}
} catch (SQLException e) {
e.printStackTrace();
}db.freeResource(result, state, conn);
return arrlist;
}
// �����ϵ��
public void addPerson(Person person){
DBdao db = new DBdao();
Connection conn = null;
PreparedStatement state = null;
conn = db.getConnection();
String sql = "insert into tongxun values(?,?)";
try {
state = conn.prepareStatement(sql);
state.setString(1, person.getName());
state.setString(2, person.getPhone());
state.execute();
} catch (SQLException e) {
e.printStackTrace();
}db.freeResource(null, state, conn);
}
// ɾ����ϵ��
public void delPerson(Person person){
DBdao db = new DBdao();
Connection conn = null;
PreparedStatement state = null;
conn = db.getConnection();
String sql = "delete from tongxun where name = '"+person.getName()+"'";
try {
state = conn.prepareStatement(sql);
state.execute();
} catch (SQLException e) {
e.printStackTrace();
}db.freeResource(null, state, conn);
}
// �޸���ϵ��
public void alterPerson(Person person){
DBdao db = new DBdao();
Connection conn = null;
PreparedStatement state = null;
conn = db.getConnection();
String sql = "update tongxun set phone='"+person.getPhone()+"'"+" where name ="+"'"+person.getName()+"'";
try {
state = conn.prepareStatement(sql);
state.execute();
} catch (SQLException e) {
e.printStackTrace();
}db.freeResource(null, state, conn);
}
}

