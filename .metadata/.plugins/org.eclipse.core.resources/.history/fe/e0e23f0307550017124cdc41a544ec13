package test1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddressBook extends AddressBookUGI {
	// 声明一个String二维数组，存放信息
	static String[][] access = new String[100][5];
	//
	public AddressBook() {
		super();
	}
	//
	public void makeAdd() {
		RecordCountLabel.setText("输入信息：");
		OKButton.setEnabled(true);
		// 清空文本框内容
		for (int i = 0; i < textField.length; i++) {
			textField[i].setText("");
		}
		SeekTextField.setText("");
		// 是不是同时在运行同一个方法makeAdd（）
		// 为OKButton注册一个内部监听类
		OKButton.addActionListener(new ActionListener() {
			// 索引
			int count = 0;
			public void actionPerformed(ActionEvent e) {
				// 确定存储位置
				for (int i = 0; i < access.length; i++) {
					// System.out.println(i);
					if (access[i][0] == null && access[i][1] == null
							&& access[i][2] == null && access[i][3] == null
							&& access[i][4] == null) {
						count = i;
						System.out.println(count);
						// System.out.println(i);
						break;
					}
					if (access[i][0].equals("") && access[i][1].equals("")
							&& access[i][2].equals("")
							&& access[i][3].equals("")
							&& access[i][4].equals("")) {
						count = i;
						System.out.println(count);
						// System.out.println(i);
						break;
					}
				}
				// System.out.println("text");
				// 存入数组中
				String text[] = new String[3];
				for (int i = 0; i < text.length; i++) {
					text[i] = textField[i].getText();
				}
				if (getSeek(text[0]) == Integer.MIN_VALUE
						&& getSeek(text[1]) == Integer.MIN_VALUE
						&& getSeek(text[2]) == Integer.MIN_VALUE) {
					if (textField[0].getText().equals("")
							|| textField[1].getText().equals("")
							|| textField[2].getText().equals("")) {
						JOptionPane.showMessageDialog(null, "带*项不能为空！！");
					}
					else {
						for (int i = 0; i < access[count].length; i++) {
							access[count][i] = textField[i].getText();
							//
							System.out.println(access[count][i]);
						}
						// 确认对话框
						/* JOptionPane.showMessageDialog(null,"添加成功"); */
						int n = JOptionPane.showConfirmDialog(null, "添加成功！！",
								"提示", JOptionPane.DEFAULT_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							for (int i = 0; i < textField.length; i++) {
								textField[i].setText("");
							}
						}
					}
				} else {
					if (getSeek(text[0]) != Integer.MIN_VALUE) {
						System.out.println(text[0] + "已经存在");
					}
					else if (getSeek(text[1]) != Integer.MIN_VALUE) {
						System.out.println(text[1] + "已经存在");
					}
					else if (getSeek(text[2]) != Integer.MIN_VALUE) {
						System.out.println(text[2] + "已经存在");
					}
				}
			}
		});
	}
	// "查找"按钮
	public void makeFind() {
		RecordCountLabel.setText("查找结果：");
		OKButton.setEnabled(false);
	}
	// 查找索引
	int index = Integer.MAX_VALUE;
	// 获取SeekTextField的文本
	String seekText = "";
	public void makeSeek() {
		seekText = SeekTextField.getText();
		if (seekText.equals("")) {
			// 对话框提示：输入查找内容
			// System.out.println("输入查找内容");
			JOptionPane.showMessageDialog(null, "输入查找内容!!");
		}
		else {
			index = getSeek(seekText);
			if (index == Integer.MIN_VALUE) {
				// 对话框提示：查找内容不存在
				// System.out.println("查找内容不存在");
				JOptionPane.showMessageDialog(null, "查找内容不存在!!");
				System.out.println(index);
			}
			else {
				for (int i = 0; i < access[index].length; i++) {
					textField[i].setText(access[index][i]);
				}
				AlterButton.setEnabled(true);
				DeleteButton.setEnabled(true);
			}
		}
		System.out.println(index);
	}
	public void makeAlter() {
		int n = JOptionPane.showConfirmDialog(null, "确定修改吗？", "提示：",
				JOptionPane.OK_CANCEL_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			for (int i = 0; i < access[index].length; i++) {
				access[index][i] = textField[i].getText();
			}
			JOptionPane.showMessageDialog(null, "修改成功！！");
		} else {
			for (int i = 0; i < access[index].length; i++) {
				textField[i].setText(access[index][i]);
			}
		}
	}
	public void makeDelete() {
		int n = JOptionPane.showConfirmDialog(null, "确定要删除吗？", "提示：",
				JOptionPane.OK_CANCEL_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			for (int i = 0; i < access[index].length; i++) {
				access[index][i] = "";
				textField[i].setText("");
			}
			JOptionPane.showMessageDialog(null, "删除成功！！");
		} else {
			for (int i = 0; i < access[index].length; i++) {
				textField[i].setText(access[index][i]);
			}
		}
	}
	// 查找
	public int getSeek(String Text) {
		// 用特殊值为x赋值：Integer.MIN_VALUE
		int x = Integer.MIN_VALUE;
		for (int i = 0; i < access.length; i++) {
			for (int j = 0; j < access[i].length; j++) {
				if (Text.equals(access[i][j])) {
					x = i;
				}
			}
		}
		return x;
	}
	// main
	public static void main(String[] args) {
		AddressBook addbook = new AddressBook();
	}
}
