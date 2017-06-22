package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SelectFrame {

	private JFrame frame;
	public JTextField tfsno;
	public JTextField tfsname;
	public JTextField tfssex;
	public JTextField tfsageb;
	public JTextField tfdept;
	public JTextField tfaddress;
	public JTextField tfsages;
	
	public JCheckBox jcsno;
	public JCheckBox jcsname;
	public JCheckBox jcssex;
	public JCheckBox jcsage;
	public JCheckBox jcdept;
	public JCheckBox jcgrade;
	public JCheckBox jcaddress;
	
	public JButton btOK;
	public JButton btredo;
	public JCheckBox grade1;
	public JCheckBox grade2;
	public JCheckBox grade3;
	public JCheckBox grade4;

	public JCheckBox jcsnos;
	public JCheckBox jcsnames;
	public JCheckBox jcssexs;
	public JCheckBox jcsages;
	public JCheckBox jcdepts;
	public JCheckBox jcgrades;
	public JCheckBox jcaddresss;
	public JCheckBox jcphones;
	public JCheckBox jcselectall;
	
	public JComboBox snoorder;
	public JComboBox sageorder;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFrame window = new SelectFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 432);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("设置查询条件");
		
		jcsno = new JCheckBox("\u5B66\u53F7");
		jcsno.setBounds(51, 48, 60, 23);
		frame.getContentPane().add(jcsno);
		
		jcsname = new JCheckBox("\u59D3\u540D");
		jcsname.setBounds(51, 88, 60, 23);
		frame.getContentPane().add(jcsname);
		
		jcssex = new JCheckBox("\u6027\u522B");
		jcssex.setBounds(51, 129, 60, 23);
		frame.getContentPane().add(jcssex);
		
		jcsage = new JCheckBox("\u5E74\u9F84");
		jcsage.setBounds(51, 169, 60, 23);
		frame.getContentPane().add(jcsage);
		
		jcdept = new JCheckBox("\u5B66\u9662");
		jcdept.setBounds(51, 207, 60, 23);
		frame.getContentPane().add(jcdept);
		
		jcaddress = new JCheckBox("\u5BB6\u5EAD\u4F4F\u5740");
		jcaddress.setBounds(51, 249, 81, 23);
		frame.getContentPane().add(jcaddress);
		
		jcgrade = new JCheckBox("\u5E74\u7EA7");
		jcgrade.setBounds(51, 289, 103, 23);
		frame.getContentPane().add(jcgrade);
		
		tfsno = new JTextField();
		tfsno.setBounds(160, 49, 81, 21);
		frame.getContentPane().add(tfsno);
		tfsno.setColumns(10);
		
		tfsname = new JTextField();
		tfsname.setBounds(158, 89, 83, 21);
		frame.getContentPane().add(tfsname);
		tfsname.setColumns(10);
		
		tfssex = new JTextField();
		tfssex.setBounds(160, 130, 81, 21);
		frame.getContentPane().add(tfssex);
		tfssex.setColumns(10);
		
		tfsages = new JTextField();
		tfsages.setBounds(215, 170, 26, 21);
		frame.getContentPane().add(tfsages);
		tfsages.setColumns(10);
		
		tfdept = new JTextField();
		tfdept.setBounds(158, 208, 83, 21);
		frame.getContentPane().add(tfdept);
		tfdept.setColumns(10);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(160, 250, 81, 21);
		frame.getContentPane().add(tfaddress);
		tfaddress.setColumns(10);
		
		tfsageb = new JTextField();
		tfsageb.setBounds(290, 170, 32, 21);
		frame.getContentPane().add(tfsageb);
		tfsageb.setColumns(10);
		
		JLabel lblBetween = new JLabel("between");
		lblBetween.setFont(new Font("Tunga", Font.BOLD, 14));
		lblBetween.setBounds(157, 171, 54, 19);
		frame.getContentPane().add(lblBetween);
		
		JLabel lblAnd = new JLabel("and");
		lblAnd.setFont(new Font("Tunga", Font.BOLD, 14));
		lblAnd.setBounds(255, 173, 32, 15);
		frame.getContentPane().add(lblAnd);
		
		btOK = new JButton("\u786E\u5B9A");
		btOK.setBounds(101, 346, 93, 23);
		frame.getContentPane().add(btOK);
		
		btredo = new JButton("\u91CD\u7F6E");
		btredo.setBounds(258, 346, 93, 23);
		frame.getContentPane().add(btredo);
		
		grade1 = new JCheckBox("\u5927\u4E00");
		grade1.setBounds(160, 289, 54, 23);
		frame.getContentPane().add(grade1);
		
		grade2 = new JCheckBox("\u5927\u4E8C");
		grade2.setBounds(216, 289, 54, 23);
		frame.getContentPane().add(grade2);
		
		grade3 = new JCheckBox("\u5927\u4E09");
		grade3.setBounds(272, 289, 54, 23);
		frame.getContentPane().add(grade3);
		
		grade4 = new JCheckBox("\u5927\u56DB");
		grade4.setBounds(328, 289, 54, 23);
		frame.getContentPane().add(grade4);
		
		jcsnos = new JCheckBox("\u5B66\u53F7");
		jcsnos.setBounds(496, 48, 103, 23);
		frame.getContentPane().add(jcsnos);
		
		jcsnames = new JCheckBox("\u59D3\u540D");
		jcsnames.setBounds(496, 74, 103, 23);
		frame.getContentPane().add(jcsnames);
		
		jcssexs = new JCheckBox("\u6027\u522B");
		jcssexs.setBounds(496, 99, 103, 23);
		frame.getContentPane().add(jcssexs);
		
		jcsages = new JCheckBox("\u5E74\u9F84");
		jcsages.setBounds(496, 129, 103, 23);
		frame.getContentPane().add(jcsages);
		
		jcdepts = new JCheckBox("\u5B66\u9662");
		jcdepts.setBounds(496, 154, 103, 23);
		frame.getContentPane().add(jcdepts);
		
		jcaddresss = new JCheckBox("\u5BB6\u5EAD\u4F4F\u5740");
		jcaddresss.setBounds(496, 183, 103, 23);
		frame.getContentPane().add(jcaddresss);
		
		jcgrades = new JCheckBox("\u5E74\u7EA7");
		jcgrades.setBounds(496, 207, 103, 23);
		frame.getContentPane().add(jcgrades);
		
		jcphones = new JCheckBox("\u8054\u7CFB\u7535\u8BDD");
		jcphones.setBounds(496, 232, 103, 23);
		frame.getContentPane().add(jcphones);
		
		jcselectall = new JCheckBox("\u5168\u9009");
		jcselectall.setBounds(496, 278, 103, 23);
		frame.getContentPane().add(jcselectall);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u8981\u8F93\u51FA\u7684\u5C5E\u6027\u5217");
		lblNewLabel.setBounds(463, 10, 126, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u67E5\u8BE2\u6761\u4EF6");
		label.setBounds(91, 7, 103, 28);
		frame.getContentPane().add(label);
		
		snoorder = new JComboBox();
		snoorder.setModel(new DefaultComboBoxModel(new String[] {"\u4E0D\u6392\u5E8F", "\u5B66\u53F7\u5347\u5E8F", "\u5B66\u53F7\u964D\u5E8F"}));
		snoorder.setBounds(350, 49, 81, 21);
		frame.getContentPane().add(snoorder);
		
		sageorder = new JComboBox();
		sageorder.setModel(new DefaultComboBoxModel(new String[] {"\u4E0D\u6392\u5E8F", "\u5E74\u9F84\u5347\u5E8F", "\u5E74\u9F84\u964D\u5E8F"}));
		sageorder.setBounds(350, 170, 81, 21);
		frame.getContentPane().add(sageorder);
		
		jcselectall.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jcselectall.isSelected()){
					jcsnos.setSelected(true);
					jcsnames.setSelected(true);
					jcssexs.setSelected(true);
					jcsages.setSelected(true);
					jcdepts.setSelected(true);
					jcgrades.setSelected(true);
					jcphones.setSelected(true);
					jcaddresss.setSelected(true);
				}else{
					jcsnos.setSelected(false);
					jcsnames.setSelected(false);
					jcssexs.setSelected(false);
					jcsages.setSelected(false);
					jcdepts.setSelected(false);
					jcgrades.setSelected(false);
					jcphones.setSelected(false);
					jcaddresss.setSelected(false);
				}
			}
		});
		
		frame.setVisible(true);
	}
}
