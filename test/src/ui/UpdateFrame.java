package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UpdateFrame {

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
	public JButton update;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame window = new UpdateFrame();
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
	public UpdateFrame() {
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
		
		JLabel tip = new JLabel("������ѧ��");
		tip.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(tip);
		JLabel tip1 = new JLabel("��ѯѧ��");
		panel.add(tip1);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		snoText = new JTextField();
		snoText.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(snoText);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);
		
		snameText = new JTextField();
		panel.add(snameText);
		
		JLabel lblNewLabel_3 = new JLabel("�Ա�");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_3);
		
		ssexText = new JTextField();
		panel.add(ssexText);
		
		JLabel lblNewLabel_4 = new JLabel("ѧԺ��");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_4);
		
		deptText = new JTextField();
		panel.add(deptText);
		
		JLabel lblNewLabel_5 = new JLabel("�꼶��");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_5);
		
		gradeText = new JTextField();
		panel.add(gradeText);
		
		JLabel lblNewLabel_6 = new JLabel("���䣺");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_6);
		
		sageText = new JTextField();
		panel.add(sageText);
		
		JLabel lblNewLabel_7 = new JLabel("�绰��");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_7);
		
		phoneText = new JTextField();
		panel.add(phoneText);
		
		JLabel lblNewLabel_8 = new JLabel("��ͥסַ��");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_8);
		
		addressText = new JTextField();
		panel.add(addressText);
		
		OK = new JButton("ȷ��");
		panel.add(OK);
		update = new JButton("�޸�");
		panel.add(update);
		
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
