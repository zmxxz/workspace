
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class test {
	public static void main(String args[]){
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object rows[][]={
				{"王明","中国",41},
				{"王2","西蜀",42},
				{"王3","北魏",43},
				{"王4","中国",44},
				{"王5","中国",45},
				{"王6","中国",46}
		};
		String columns[]={
				"姓名","国籍","年龄"
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
