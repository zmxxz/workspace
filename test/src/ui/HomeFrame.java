package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class HomeFrame {

	private JFrame frame;
	public JTable table;
	public DefaultTableModel model;
	
	public JButton btQuery;
	public JButton btUpdate;
	public JButton btAdd;
	public JButton btDelete;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeFrame window = new HomeFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public HomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u901A\u8BAF\u5F55\u7CFB\u7EDF");
		frame.setBounds(100, 100, 750, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(30);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		btQuery = new JButton("\u67E5\u8BE2");
		panel.add(btQuery);
		
		btUpdate = new JButton("\u4FEE\u6539");
		panel.add(btUpdate);
		
	    btAdd = new JButton("\u6DFB\u52A0");
		panel.add(btAdd);
		
		btDelete = new JButton("\u5220\u9664");
		panel.add(btDelete);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane sPane = new JScrollPane(table);
		panel_1.add(sPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("powered by litao");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		this.frame.setVisible(true);
	}

}
