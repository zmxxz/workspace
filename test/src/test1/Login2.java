package test1;

import javax.swing.*;

public class Login2 {
	private JLabel title;
	private JLabel Usrl;
	private JLabel Passl;
	private javax.swing.JTextField UserId;
	private javax.swing.JPasswordField Password;
	private JButton login;
	private JButton Register;
	public Login2()
	{
		JFrame jf=new JFrame("�û���½");
		jf.setVisible(true);
		jf.setSize(300,260);
		jf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		title=new JLabel("�û���½����");
		Usrl=new JLabel("�����˺�");
		Passl=new JLabel("����");
		UserId=new JTextField();
		Password=new JPasswordField();
		login=new JButton("��½");
		Register=new JButton("ע��");
		GroupLayout layout=new GroupLayout(jf.getContentPane());
		jf.getContentPane().setLayout(layout);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();  
        hGroup.addGap(10);//��Ӽ��  
        hGroup.addGroup(layout.createParallelGroup().addComponent(Usrl).addComponent(Passl));
        hGroup.addGap(10);
        hGroup.addGroup(layout.createParallelGroup().addComponent(title).addComponent(UserId).addComponent(Password).addComponent(login).addComponent(Register));
        hGroup.addGap(10);
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();  
        vGroup.addGap(20);
        vGroup.addGroup(layout.createParallelGroup().addComponent(title));
        vGroup.addGap(20);
        vGroup.addGroup(layout.createParallelGroup().addComponent(Usrl).addComponent(UserId));
        vGroup.addGap(20);
        vGroup.addGroup(layout.createParallelGroup().addComponent(Passl).addComponent(Password));
        vGroup.addGap(20);
        vGroup.addGroup(layout.createParallelGroup().addComponent(login).addComponent(Register));
        vGroup.addGap(20);
        layout.setVerticalGroup(vGroup);
	}
	 public static void main(String args[]) {
		 Login2 login=new Login2();
	 }
}

