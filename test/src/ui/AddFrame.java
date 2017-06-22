package ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class AddFrame {

	private JFrame frame;
	public JTextField snoText;
	public JTextField snameText;
	public JTextField ssexText;
	public JTextField deptText;
	public JTextField gradeText;
	public JTextField sageText;
	public JTextField phoneText;
	public JTextField addressText;
	public JButton OK;
	public JButton redo;
	private JPanel panel_1;
	private JPanel panel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame window = new AddFrame();
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
	public AddFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		frame.setBounds(100, 100, 450, 368);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel tip = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751F\u4FE1\u606F");
		tip.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(tip);
		JLabel tip1 = new JLabel("\uFF0C\u5E26'*'\u4E3A\u5FC5\u586B\u9879");
		panel.add(tip1);
		
		JLabel lblNewLabel_1 = new JLabel("*\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		snoText = new JTextField();
		snoText.setToolTipText("6\u4F4D\u6570\u5B66\u53F7");
		panel.add(snoText);
		
		JLabel lblNewLabel_2 = new JLabel("*\u59D3\u540D\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);
		
		snameText = new JTextField();
		panel.add(snameText);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_3);
		
		ssexText = new JTextField();
		panel.add(ssexText);
		
		JLabel lblNewLabel_4 = new JLabel("学院：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_4);
		
		deptText = new JTextField();
		panel.add(deptText);
		
		JLabel lblNewLabel_5 = new JLabel("年级：");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_5);
		
		gradeText = new JTextField();
		panel.add(gradeText);
		
		JLabel lblNewLabel_6 = new JLabel("年龄：");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_6);
		
		sageText = new JTextField();
		panel.add(sageText);
		
		JLabel lblNewLabel_7 = new JLabel("电话：");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_7);
		
		phoneText = new JTextField();
		panel.add(phoneText);
		
		JLabel lblNewLabel_8 = new JLabel("家庭住址：");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_8);
		
		addressText = new JTextField();
		panel.add(addressText);
		
		OK = new JButton("确定");
		panel.add(OK);
		redo = new JButton("\u91CD\u7F6E");
		panel.add(redo);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(70);
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		
		frame.setVisible(true);
	}

}
