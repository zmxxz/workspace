
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class test {
	public static void main(String args[]){
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object rows[][]={
				{"����","�й�",41},
				{"��2","����",42},
				{"��3","��κ",43},
				{"��4","�й�",44},
				{"��5","�й�",45},
				{"��6","�й�",46}
		};
		String columns[]={
				"����","����","����"
		};
		TableModel model  = new DefaultTableModel(rows,columns);
		JTable table = new JTable(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		JScrollPane pane = new JScrollPane(table);
		frame.add(pane,BorderLayout.CENTER);
		frame.setSize(300,150);
		frame.setVisible(true);
	}
}
