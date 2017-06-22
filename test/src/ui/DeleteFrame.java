package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteFrame {

	private JFrame frame;
	public JTextField snoText;
	public JButton OK;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame window = new DeleteFrame();
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
	public DeleteFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5220\u9664\u5B66\u751F\u8BB0\u5F55");
		frame.setBounds(100, 100, 439, 267);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入学号：");
		lblNewLabel.setBounds(115, 61, 66, 28);
		frame.getContentPane().add(lblNewLabel);
		
		snoText = new JTextField();
		snoText.setBounds(191, 64, 106, 23);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		OK = new JButton("确定");
		OK.setBounds(163, 130, 93, 23);
		frame.getContentPane().add(OK);
		
		frame.setVisible(true);
	}
}
