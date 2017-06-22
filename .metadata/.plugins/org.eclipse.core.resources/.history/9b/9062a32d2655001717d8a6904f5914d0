package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class QueryDAO {
public ArrayList<Person> queryPerson(Person person){
ArrayList<Person> alist = new ArrayList<Person>();
DBdao db = new DBdao();
Connection conn = null;
PreparedStatement state = null;
ResultSet result = null;
conn = db.getConnection();
String sql = "select * from tongxun where 1=1 ";
if(!person.getName().equals("-1")){
sql+= " and name like '%" + person.getName() + "%'";
}
if(!person.getPhone().equals("-1")){
sql+= " and phone like '%"+person.getPhone()+"%'";
}
try {
state = conn.prepareStatement(sql);
result = state.executeQuery();
while(result.next()){
String name = result.getString("name");
String phone = result.getString("phone");
Person per = new Person();
per.setName(name);
per.setPhone(phone);
alist.add(per);
}
} catch (SQLException e) {
e.printStackTrace();
}db.freeResource(result, state, conn);
return alist;
}
}


