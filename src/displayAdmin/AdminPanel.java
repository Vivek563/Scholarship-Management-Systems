package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class AdminPanel extends MyPanel{
	
	
	private ActionListener globalListener;
	
	private JLabel lblLoggedin;
	
	private JLabel lblName;
	private JLabel lblEmail;
	
	private JButton btnBack;
	private JButton btnScholarship;
	private JButton btnAddScholarship;
	private JButton btnStudents;
	private JButton btnAccount;
	
	
	public AdminPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		contentPane.setName("Admin Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in as Admin", Size.defaultLblFontSize);
		north.add(lblLoggedin, "cell 0 0,left");
		
		lblName = new MyLabel("Name", Size.defaultLblFontSize);
		north.add(lblName, "cell 0 1,center");
		
		lblEmail = new MyLabel("Email", Size.defaultLblFontSize);
		north.add(lblEmail, "cell 0 2,center");
	}
	
	
	private void displayCenter() {
		btnStudents = new MyButton("View All Students", Size.defaultBtnFontSize);
		center.add(btnStudents,"cell 0 0, center");
		btnStudents.addActionListener(packageListener);
		btnStudents.setName("AllStudents_AdminPanel");
		
		btnScholarship = new MyButton("View All Scholarships", Size.defaultBtnFontSize, Size.defaultBtnWidth);
		center.add(btnScholarship, "cell 0 1, center");
		btnScholarship.addActionListener(packageListener);
		btnScholarship.setName("AllScholarships_AdminPanel");
		
		btnAddScholarship = new MyButton("Add Scholarship", Size.defaultBtnFontSize);
		center.add(btnAddScholarship,"cell 0 2, center");
		btnAddScholarship.addActionListener(packageListener);
		btnAddScholarship.setName("AddScholarship_AdminPanel");
		
		btnAccount = new MyButton("My Account", Size.defaultBtnFontSize);
		center.add(btnAccount,"cell 0 3, center");
		btnAccount.addActionListener(packageListener);
		btnAccount.setName("Account_AdminPanel");
	}
	
	
	private void displaySouth() {
		btnBack = new MyButton("Log out", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Logout_AdminPanel");
		
	
	}
	
	
	public void setName(String name) {
		lblName.setText(name);
	}

	
	public void setEmail(String email) {
		lblEmail.setText(email);
	}
}
