package displayLogin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class HomePanel extends MyPanel {
	
	private JButton btnLoginAdmin;
	private JButton btnLoginStudent;
	private JButton btnSignup;
	private JButton btnAbout;

	// JLabel that contains background image
	private JLabel lblTitle;

	// button for south panel
	private JButton btnTest;

	
	public HomePanel(ActionListener packageListener) {
		this.packageListener = packageListener;

		contentPane.setName("Home Panel");
		// displaying contents of each panels
		displayNorth();
		displaySouth();
		displayCenter();
	}

	
	private void displayNorth() {

		String title = "Scholarship Management System";

		lblTitle = new MyLabel(title, Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0, center");
	}

	
	private void displaySouth() {

	}


	private void displayCenter() {
		btnLoginAdmin = new MyButton("Admin Login");
		center.add(btnLoginAdmin, "cell 0 0, center");
		btnLoginAdmin.addActionListener(packageListener);
		btnLoginAdmin.setName("LoginAdmin_HomePanel");

		btnLoginStudent = new MyButton("Student Login");
		center.add(btnLoginStudent, "cell 0 1, center");
		btnLoginStudent.addActionListener(packageListener);
		btnLoginStudent.setName("LoginStudent_HomePanel");

		btnAbout = new MyButton("About");
		center.add(btnAbout, "cell 0 3, center");
		btnAbout.addActionListener(packageListener);
		btnAbout.setName("About_HomePanel");

	}

	
	public void hideTestButton() {
		btnTest.setVisible(false);
	}
}
