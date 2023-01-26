package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Student;

public class AllStudentsPanel extends MyScrollPanel{
	
	private JLabel lblTitle;
	
	private JButton btnBack;
	
	int studentRow;
	
	
	public AllStudentsPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("All Students Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
		
		studentRow = 1;
	}

	private void displayNorth() {
		lblTitle = new MyLabel("All Students", Size.defaultLblSubTitleFontSize);
		north.add(lblTitle,"cell 0 0, center");
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_AllStudentsPanel");
		btnBack.addActionListener(packageListener);
	}
	
	private void displayCenter() {
		JLabel lblName = new MyLabel("UID", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0,left");
		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Account", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
	}
	
	
	public void addStudent(Student student) {
		
		JLabel lbl = new MyLabel(Integer.toString(student.getUCID())+"           ");
		center.add(lbl,String.format("cell 0 %d, left", studentRow));
		
		lbl = new MyLabel(student.getName()+"        ");
		center.add(lbl,String.format("cell 1 %d, left", studentRow));
		
		JButton btn = new MyButton("View", Size.defaultLblFontSize, Size.defaultBtnEditWidth);
		center.add(btn,String.format("cell 2 %d, left", studentRow));
		btn.setName("ViewStudent_AllStudentsPanel");
		btn.addActionListener(packageListener);
		btn.setActionCommand(Integer.toString(student.getUCID()));
		
		
		studentRow++;
	}

}