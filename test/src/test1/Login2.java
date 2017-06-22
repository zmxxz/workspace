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
		JFrame jf=new JFrame("”√ªßµ«¬Ω");
		jf.setVisible(true);
		jf.setSize(300,260);
		jf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		title=new JLabel("”√ªßµ«¬ΩΩÁ√Ê");
		Usrl=new JLabel("” œ‰’À∫≈");
		Passl=new JLabel("√‹¬Î");
		UserId=new JTextField();
		Password=new JPasswordField();
		login=new JButton("µ«¬Ω");
		Register=new JButton("◊¢≤·");
		GroupLayout layout=new GroupLayout(jf.getContentPane());
		jf.getContentPane().setLayout(layout);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();  
        hGroup.addGap(10);//ÃÌº”º‰∏Ù  
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

