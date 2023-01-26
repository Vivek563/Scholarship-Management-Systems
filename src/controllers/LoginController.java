package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayLogin.*;
import myJStuff.MyController;


public class LoginController extends MyController {
	
	
	private HomePanel hp;
	private AboutPanel ap;
	private LoginAdminPanel lap;
	private LoginStudentPanel lsp;
	
	private JPanel panelHome;
	private JPanel panelAbout;	
	private JPanel panelLoginAdmin;
	private JPanel panelLoginStudent;
	
	
	public LoginController(ActionListener globalListener,JFrame frame){
		super(globalListener, frame);
	}
	
	
	public void start(){
		hp = new HomePanel(this);
		ap = new AboutPanel(this);
		lap = new LoginAdminPanel(this, globalListener);
		lsp = new LoginStudentPanel(this, globalListener);
		
		
		panelHome = hp.getContentPane();
		panelAbout = ap.getContentPane();
		panelLoginAdmin = lap.getContentPane();
		panelLoginStudent = lsp.getContentPane();
					
		switchPanel(panelHome);
	}
	
	
	public LoginStudentPanel getLoginStudentPanel() {
		return lsp;
	}
	
	public LoginAdminPanel getLoginAdminPanel() {
		return lap;
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		switch(name){
		case "Back_LoginAdminPanel":
			switchPanel(panelHome); 
			break;
		case "Back_LoginStudentPanel":
			switchPanel(panelHome); 
			break;
		case "LoginAdmin_HomePanel":
			lap.resetFields();
			switchPanel(panelLoginAdmin); 
			break;
		case "Back_AboutPanel":
			switchPanel(panelHome); 
			break;
		case "About_HomePanel":
			switchPanel(panelAbout); 
			break;
		case "LoginStudent_HomePanel":
			lsp.resetFields();
			switchPanel(panelLoginStudent);
			break;
		default:
			switchPanel(panelHome);
			break;
		}
       
	}
    
}
