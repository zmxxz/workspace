package Load_QQ;


import java.net.*; 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class AboutQQ 
extends JFrame 
implements ActionListener,Runnable{ //����qq������������ 
JPanel p1 = new JPanel(), p2 = new JPanel(); 
TextArea output = new TextArea("", 20, 18, TextArea.SCROLLBARS_BOTH), 
input = new TextArea("", 20, 18, TextArea.SCROLLBARS_VERTICAL_ONLY); 
JButton b_biaoqing = new JButton("����"); 
JButton b_zhiti = new JButton("����"); 
JButton b_zhitiys = new JButton("������ɫ"); 
JButton b_jilu = new JButton("�����Ϣ"); 
JButton b_fasong = new JButton("����");

JLabel lb1 = new JLabel(" �Է�IP"); 
JTextField IPAdd = new JTextField("192.168.4.88", 15); 
String s,kongzhi;//���ڿ��ƺ��жϵı��� 
int port = 5858; 
InetAddress group = null; 
MulticastSocket socket = null; 
//Ⱥ�ĺ�˽�ĵ��߳� 
Thread thread1=new Thread(this); 
Thread thread2=new Thread(this);

JButton siliao = new JButton("˽��"); 
JButton qunliao = new JButton("Ⱥ��"); 
Color ys = new Color(157, 242, 173); 
caidan cd = new caidan(); //��ò˵�����

public AboutQQ() { //����qq���� 
super("СС������"); 
setMenuBar(cd); 
setResizable(false); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
b_jilu.addActionListener(this); 
b_fasong.addActionListener(this); 
b_biaoqing.addActionListener(this); 
b_zhiti.addActionListener(this); 
b_zhitiys.addActionListener(this); 
siliao.addActionListener(this); 
qunliao.addActionListener(this);

Container cc = getContentPane(); 
setBounds(150, 150, 600, 510); 
cc.setLayout(new BorderLayout()); 
output.setBackground(Color.white); 
output.setForeground(Color.blue); 
output.setBounds(4, 0, 420, 250); 
output.setFont(new Font("����", Font.PLAIN, 14)); 
output.setEditable(false);

p1.setLayout(null); 
p1.setBackground(new Color(220, 220, 220)); 
p1.add(output); 
b_biaoqing.setBounds(4, 254, 60, 30); 
p1.add(b_biaoqing); 
b_zhiti.setBounds(65, 254, 60, 30); 
p1.add(b_zhiti); 
b_zhitiys.setBounds(126, 254, 90, 30); 
p1.add(b_zhitiys); 
input.setFont(new Font("����", Font.PLAIN, 14)); 
input.setBackground(Color.white); 
input.setForeground(Color.blue); 
input.setBounds(4, 290, 420, 125); 
p1.add(input); 
b_jilu.setBounds(4, 420, 120, 30); 
p1.add(b_jilu); 
b_fasong.setBounds(360, 420, 60, 30); 
p1.add(b_fasong); 
p1.setBackground(ys); 
cc.add(p1, "Center");

lb1.setFont(new Font("����", Font.BOLD, 18)); 
lb1.setBackground(ys); 
IPAdd.setEditable(false); 
p2.setBackground(ys); 
p2.setLayout(new GridLayout(10, 1, 1, 10)); 
p2.add(lb1, "Center"); 
p2.add(IPAdd); 
p2.add(siliao); 
p2.add(qunliao); 
cc.add(p2, "East"); 
setVisible(true); 
}

public void AboutQQ1() {
}

public AboutQQ(AboutQQ aboutQQ) {
// TODO Auto-generated constructor stub
}

//ִ�а�ť�����ķ��� 
public void actionPerformed(ActionEvent e) { 
	if (e.getSource() == b_fasong) { 
		String ss = input.getText(); 
		if (kongzhi == "sl"){ 
			if (ss.equals("")) { 
				AboutQQ test = new AboutQQ(this); 
			}else { 
				sendData1(); 
			}

		}else if (kongzhi == "ql") 
			if (ss.equals("")) { 
				AboutQQ test = new AboutQQ(this); 
			}else { 
				sendData2(); 
			} 
		else { 
			JOptionPane.showMessageDialog(this,"�Բ����㻹ûѡ�����췽ʽ������ѡ�����췽ʽ��","����",JOptionPane.WARNING_MESSAGE); 
		}

	} else if (e.getSource() == b_zhiti) { 
		ziti zt = new ziti(this); 
		input.setFont(zt.f); 
		output.setFont(zt.f); 
	}else if (e.getSource() == b_zhitiys) { 
		Color newcolor = JColorChooser.showDialog(this, "��ɫ��", 
				input.getForeground()); 
		input.setForeground(newcolor); 
		output.setForeground(newcolor); 
	} else if (e.getSource() == b_jilu) { 
		output.setText(""); 
	}else if (e.getSource() == siliao) { 
		String ip = JOptionPane.showInputDialog("������Է���IP��ַ��","192.168.4.13"); 
		if (ip!=null) { 
			IPAdd.setText(ip); 
		} 
		kongzhi="sl"; 
		if(!(thread1.isAlive())){ 
			thread1=new Thread(this); 
		} 
		try{ 
			thread1.start(); 
		}catch(Exception eee){ 
		}

	}else if (e.getSource() == qunliao){ 
		thread1.interrupt(); 
		int n=JOptionPane.showConfirmDialog(null,"��ȷ��ҪȺ���������Ϣ�ᱻ�����˿�������","����",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE); 
		JOptionPane.showMessageDialog(this,"����������ú�����ǳƣ�Ȼ���ٽ������죡","��ܰ����",JOptionPane.WARNING_MESSAGE); 
		if(n==JOptionPane.YES_OPTION) 
			kongzhi="ql"; 
		if(!(thread2.isAlive())){ 
			thread2=new Thread(this); 
		}

		try{ 
			thread2.start(); 
		}catch(Exception eee){} 
	} 
}

//���ͼ��������ݵķ��� 
void sendData1(){ 
try { 
Calendar rightNow = Calendar.getInstance(); //��ȡ��ǰϵͳ���ں�ʱ�� 
int hour = rightNow.get(Calendar.HOUR_OF_DAY); //��ȡ��ǰʱ��������� 
int year = rightNow.get(Calendar.YEAR); 
int month = rightNow.get(Calendar.MONTH) + 1; 
int day = rightNow.get(Calendar.DATE); 
int minute = rightNow.get(Calendar.MINUTE); 
int second = rightNow.get(Calendar.SECOND);

String msg = input.getText(); 
if (msg.equals("")) { 
return; 
} 
input.setText(""); 
String ad = IPAdd.getText(); 
InetAddress tea = InetAddress.getLocalHost(); 
String asd = tea.getHostAddress(); //���ͷ���IP��ַ 
output.append(cd.nicheng1 + "(" + asd + ") " + year 
+ "-" + month + "-" 
+ day + " " 
+ hour + ":" 
+ minute + ":" 
+ second + "\n" + " " + msg 
+ "\n"); 
msg = cd.nicheng2 + "(" + asd + ") " + year 
+ "-" + month + "-" 
+ day + " " 
+ hour + ":" 
+ minute + ":" 
+ second + "\n" + " " + msg + "\n"; 
InetAddress address = InetAddress.getByName(ad); 
byte[] message = msg.getBytes(); 
DatagramPacket packet = new DatagramPacket(message, message.length, 
address, 
9999); 
DatagramSocket socket = new DatagramSocket(); 
socket.send(packet); 
} 
catch (Exception e) { 
	output.append("in send():"+e +"\n");
} 
} 
void sendData2(){ 
Calendar rightNow = Calendar.getInstance(); //��ȡ��ǰϵͳ���ں�ʱ�� 
int hour = rightNow.get(Calendar.HOUR_OF_DAY); //��ȡ��ǰʱ��������� 
int year = rightNow.get(Calendar.YEAR); 
int month = rightNow.get(Calendar.MONTH) + 1; 
int day = rightNow.get(Calendar.DATE); 
int minute = rightNow.get(Calendar.MINUTE); 
int second = rightNow.get(Calendar.SECOND);

try { 
group = InetAddress.getByName("239.255.8.0"); 
socket = new MulticastSocket(port); 
socket.setTimeToLive(1); 
socket.joinGroup(group);

s = input.getText(); 
if (s.equals("")) { 
return; 
} 
String ss=(cd.nicheng1+" " + year 
+ "-" + month + "-" 
+ day + " " 
+ hour + ":" 
+ minute + ":" 
+ second + "\n" + " " + s 
+ "\n");

input.setText(""); 
DatagramPacket packet = null; 
byte date[] = ss.getBytes(); 
packet = new DatagramPacket(date, date.length, group, port); 
socket.send(packet); 
} 
catch (Exception e) { 
System.out.println("Error:" + e); 
} 
} 
//�ȴ��������ݵķ��� 
public void run() { 
if(Thread.currentThread()==thread1){//����˽�ĵ��߳� 
	System.out.println(Thread.currentThread()+":in run()");
try { 
byte[] buffer = new byte[1024]; 
DatagramPacket packet = new DatagramPacket(buffer, buffer.length); 
DatagramSocket socket = new DatagramSocket(9999); 
while (true) { 
socket.receive(packet); 
String s = new String(packet.getData(), 0, packet.getLength()); 
output.append(s + "\n"); 
packet = new DatagramPacket(buffer, buffer.length); 
} 
} 
catch (Exception e) { 
	output.append(e);
} 

} 
if(Thread.currentThread()==thread2){//����Ⱥ�ĵ��߳�

try { 
while (true) { 
group=null; 
group = InetAddress.getByName("239.255.8.0"); 
socket = new MulticastSocket(port); 
socket.joinGroup(group); 
byte[] buffer = new byte[8192]; 
DatagramPacket packet=null; 
packet = new DatagramPacket(buffer, buffer.length, group, port);

socket.receive(packet); 
String message = new String(packet.getData(), 0, packet.getLength()); 
output.append(message); 
packet = new DatagramPacket(buffer, buffer.length); 
} 
} 
catch (Exception e) { 
} 
} 
}
//������ 
/*public static void main(String args[]) { 
new AboutQQ(null); 
}

}*/
//��ʾ�Ի����� 
class LittleQQ 
implements ActionListener { 
private JLabel label; 
private JButton queding; 
private JDialog dialog;

public void AboutQQ(JFrame f) { 
label = new JLabel("���ܷ��Ϳ���Ϣ"); 
queding = new JButton("Yes"); 
dialog = new JDialog(f, "��ʾ", true); 
dialog.setLocation(350, 380); 
dialog.setSize(80, 115); 
dialog.setResizable(false); 
Container dialogPane = dialog.getContentPane(); 
dialogPane.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 15)); 
dialogPane.add(label); 
dialogPane.add(queding); 
queding.addActionListener(this); 
dialog.show(); 
}

public void actionPerformed(ActionEvent e) { 
dialog.show(false); 
} 
}

//qq�˵��� 
class caidan 
extends MenuBar 
implements ActionListener { 
String nicheng1 = "��"; //����Ĭ���ǳ� 
String nicheng2 = "�Է�"; 
private Menu m1, m2, m3, m4, m5,m6; 
private MenuItem m11, m12, m13, m22, m23, m31, m51, m52, m53,m54, m55,m61,m62,m63,m64,m65,m66,m67,m68,m69,mm;

public caidan() { 
m1 = new Menu("����"); 
m2 = new Menu("����"); 
m3 = new Menu("����"); 
m4 = new Menu("����"); 
m5 = new Menu("��Ϸ"); 
m6=new Menu("������ɫ");

m11 = new MenuItem("��������"); 
m12 = new MenuItem("��Ƶ����"); 
m13 = new MenuItem("�ļ�����");

m22 = new MenuItem("����һ��"); 
m23 = new MenuItem("��������"); 
m51 = new MenuItem("̰����"); 
m52 = new MenuItem("ƴͼ"); 
m53 = new MenuItem("Χ�����"); 
m54 = new MenuItem("���ݵ�"); 
m55 = new MenuItem("����˹����");

m31 = new MenuItem("�ҵ��ǳ�"); 
m61=new MenuItem("��ʽ1"); 
m62=new MenuItem("��ʽ2"); 
m63=new MenuItem("��ʽ3"); 
m64=new MenuItem("��ʽ4"); 
m65=new MenuItem("��ʽ5"); 
m66=new MenuItem("��ʽ6"); 
m67=new MenuItem("��ʽ7"); 
m68=new MenuItem("��ʽ8"); 
m69=new MenuItem("��ʽ9"); 
mm=new MenuItem("Ĭ��");

m1.add(m11);m11.addActionListener(this); 
m1.add(m12);m12.addActionListener(this); 
m1.add(m13);m13.addActionListener(this); 
m2.add(m5); 
m2.add(m22);m22.addActionListener(this); 
m2.add(m23);m23.addActionListener(this); 
m5.add(m51);m51.addActionListener(this); 
m5.add(m52);m52.addActionListener(this); 
m5.add(m53);m53.addActionListener(this); 
m5.add(m54);m54.addActionListener(this); 
m5.add(m55);m55.addActionListener(this);

m3.add(m31);m31.addActionListener(this); 
m3.add(m6); 
m6.add(m61);m61.addActionListener(this); 
m6.add(m62);m62.addActionListener(this); 
m6.add(m63);m63.addActionListener(this); 
m6.add(m64);m64.addActionListener(this); 
m6.add(m65);m65.addActionListener(this); 
m6.add(m66);m66.addActionListener(this); 
m6.add(m67);m67.addActionListener(this); 
m6.add(m68);m68.addActionListener(this); 
m6.add(m69);m69.addActionListener(this); 
m6.add(mm);mm.addActionListener(this); 
add(m1); 
add(m2); 
add(m3); 
add(m4);

}

public void actionPerformed(ActionEvent e) { 
if (e.getSource() == m51) {

} 
else if (e.getSource() == m52) {

}

else if (e.getSource() == m53) {

} 
else if (e.getSource() == m54) {} 
else if (e.getSource() == m55) {

} 
else if (e.getSource() == m22) {

} 
else if (e.getSource() == m23) {

} 
else if (e.getSource() == m31){ 
String nicheng = JOptionPane.showInputDialog("����������ǳƣ�"); 
nicheng1 = nicheng; 
nicheng2 = nicheng; 
} 
else if(e.getSource() == m61){ 
Color ys=new Color(77,192,221); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m62){ 
Color ys=new Color(45,168,118); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m63){ 
Color ys=new Color(245,163,238); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys);

} 
else if(e.getSource() == m64){ 
Color ys=new Color(148,157,55); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys);

} 
else if(e.getSource() == m65){ 
Color ys=new Color(240,162,142); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m66){ 
Color ys=new Color(148,190,252); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m67){ 
Color ys=new Color(253,181,196); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m68){ 
Color ys=new Color(182,162,230); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == m69){ 
Color ys=new Color(237,250,116); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
} 
else if(e.getSource() == mm){ 
Color ys=new Color(157,242,173); 
AboutQQ.p1.setBackground(ys); 
AboutQQ.p2.setBackground(ys); 
}

}

}

//����Ի����� 
class ziti 
implements ActionListener, ItemListener { 
private JLabel lb1 = new JLabel("����"), lb2 = new JLabel("����"), 
lb3 = new JLabel("��С"); 
JTextField text1 = new JTextField("����"), text2 = new JTextField("PLAIN"), 
text3 = new JTextField("14", 2); 
java.awt.List list1 = new java.awt.List(6, false), 
list2 = new java.awt.List(6, false), list3 = new java.awt.List(6, false); 
private JButton b_queding = new JButton("ȷ��"), b_quxiao = new JButton("ȡ��"); 
String zixing[] = { 
"����", "б��", "����"}; 
String daxiao[] = { 
"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", 
"28", "34"}; 
private JDialog dialog; 
Font f; 
String aa = "����"; 
int cc = 14; 
//����Ի�����Ĺ��췽�� 
public ziti(JFrame f) { 
dialog = new JDialog(f, "����", true); 
dialog.setLocation(150, 150); 
dialog.setSize(400, 230); 
dialog.setResizable(false); 
Container dd = dialog.getContentPane(); 
dd.setLayout(null); 
lb1.setBounds(4, 2, 30, 20); 
dd.add(lb1); 
lb2.setBounds(150, 2, 30, 20); 
dd.add(lb2); 
lb3.setBounds(250, 2, 30, 20); 
dd.add(lb3); 
text1.setBounds(4, 24, 140, 20); 
dd.add(text1); 
text2.setBounds(150, 24, 95, 20); 
dd.add(text2); 
text3.setBounds(250, 24, 50, 20); 
dd.add(text3);

GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
String fontName[] = ge.getAvailableFontFamilyNames(); 
for (int i = 0; i < fontName.length; i++) { 
list1.add(fontName[i]); 
} 
for (int j = 0; j < zixing.length; j++) { 
list2.add(zixing[j]); 
} 
for (int k = 0; k < daxiao.length; k++) { 
list3.add(daxiao[k]);

}

list1.setBounds(4, 46, 140, 130); 
dd.add(list1); 
list2.setBounds(150, 46, 95, 130); 
dd.add(list2); 
list3.setBounds(250, 46, 50, 130); 
dd.add(list3); 
b_queding.setBounds(315, 60, 60, 20); 
dd.add(b_queding); 
b_quxiao.setBounds(315, 100, 60, 20); 
dd.add(b_quxiao); 
b_queding.addActionListener(this); 
b_quxiao.addActionListener(this); 
list1.addItemListener(this); 
list2.addItemListener(this); 
list3.addItemListener(this); 
dialog.show();

}

//��Ӧ��ť�¼��ķ��� 
public void actionPerformed(ActionEvent e) { 
if (e.getSource() == b_queding) { 
aa = text1.getText(); 
cc = Integer.parseInt(text3.getText()); 
if (list2.getSelectedIndex() == 0) { 
f = new Font(aa, Font.PLAIN, cc); 
} 
else if (list2.getSelectedIndex() == 1) { 
f = new Font(aa, Font.ITALIC, cc); 
} 
else if (list2.getSelectedIndex() == 2) { 
f = new Font(aa, Font.BOLD, cc); 
} 
else { 
f = new Font(aa, Font.PLAIN, cc); 
} 
dialog.show(false);

}

else { 
dialog.show(false); 
} 
}

//��Ӧ�б���¼��ķ��� 
public void itemStateChanged(ItemEvent e) { 
String name1 = list1.getSelectedItem(); 
String name2 = list2.getSelectedItem(); 
String name3 = list3.getSelectedItem(); 
if (name1 != null) { 
text1.setText(name1); 
} 
if (name2 != null) { 
text2.setText(name2); 
} 
if (name3 != null) { 
text3.setText(name3); 
} 
}

}
}
