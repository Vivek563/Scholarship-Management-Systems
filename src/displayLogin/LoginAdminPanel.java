package displayLogin;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginAdminPanel extends MyPanel{

	private JLabel lblLogin;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblUser;
	
	private JButton btnBack;
	private JButton btnLogin;

	private JTextField fldUsername;
	private JPasswordField fldPassword;
	
	private ActionListener globalListener;
	
	
	public LoginAdminPanel (ActionListener actionListener, ActionListener globalListener) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;

		contentPane.setName("Login Admin Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	private void displayNorth(){
		lblLogin = new MyLabel("Login", Size.defaultLblTitleFontSize);
		north.add(lblLogin, "cell 0 0, center");
		
		lblUser = new MyLabel("Admin", Size.defaultLblSubTitleFontSize);
		north.add(lblUser, "cell 0 1, center");
	}
	
	
	private void displaySouth(){
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_LoginAdminPanel");
		
		btnLogin = new MyButton("Login", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnLogin, "cell 1 0, right");
		btnLogin.addActionListener(globalListener);
		btnLogin.setName("Login_LoginAdminPanel");

	}
	
	
	private void displayCenter(){
		lblEmail = new MyLabel("Your Email", Size.defaultBtnFontSize);
		center.add(lblEmail, "cell 0 0, center");
		
		fldUsername = new MyTextField("", Size.defaultBtnFontSize);
		center.add(fldUsername, "cell 0 1, center");
		
		lblPassword = new MyLabel("Your Password", Size.defaultBtnFontSize);
		center.add(lblPassword, "cell 0 2, center");
		
		fldPassword = new MyPasswordField("", Size.defaultBtnFontSize);
		center.add(fldPassword, "cell 0 3, center");
		
	}
	public void resetFields() {
		fldUsername.setText("");
		fldPassword.setText("");
	}
	
	
	public String getEmail() {
		return fldUsername.getText();
	}
	//same thing for searching
	
	
	
	@SuppressWarnings("deprecation")
		public String getPassword() {
		return fldPassword.getText();
	}
}
