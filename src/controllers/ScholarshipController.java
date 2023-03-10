package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayScholarship.*;
import objects.*;
import myJStuff.MyController;

public class ScholarshipController extends MyController{
	
	
	private JPanel viewScholarshipPanel;
	private JPanel allScholarshipsPanel;
	private JPanel editScholarshipPanel;
	private JPanel viewStudentsAppliedPanel;
	private JPanel viewStudentsAcceptedPanel;
	private JPanel viewStudentsWonPanel;
	
	
	private ViewScholarshipPanel vsp;
	private AllScholarshipsPanel asp;
	private EditScholarshipPanel esp;
	private ViewStudentsAppliedPanel vsapp;
	private ViewStudentsAcceptedPanel vsacp;
	private ViewStudentsWonPanel vswp;
	
	private List<Student> students;
	
	private HashMap<Integer, Scholarship> scMap;
	
	private Scholarship currentScholarship;
	
	private boolean isAdmin = false;
	
	
	public ScholarshipController(ActionListener globalListener,JFrame frame) {
		super(globalListener, frame);
	}
	
	
	public void start(boolean isAdmin, HashMap<Integer, Scholarship> scMap) {
		this.isAdmin = isAdmin;
		this.scMap = scMap;
		
		// Initialize all of the panels
		vsp = new ViewScholarshipPanel(this,globalListener,this.isAdmin);
		asp = new AllScholarshipsPanel(this,globalListener,this.isAdmin);
		esp = new EditScholarshipPanel(this,globalListener);
		vsapp = new ViewStudentsAppliedPanel(this, globalListener);
		vsacp = new ViewStudentsAcceptedPanel(this, globalListener);
		vswp = new ViewStudentsWonPanel(this,globalListener);
		
		// Get the content panes
		viewScholarshipPanel = vsp.getContentPane();
		allScholarshipsPanel = asp.getContentPane();
		editScholarshipPanel = esp.getContentPane();
		viewStudentsAppliedPanel = vsapp.getContentPane();
		viewStudentsAcceptedPanel = vsacp.getContentPane();
		viewStudentsWonPanel = vswp.getContentPane();
		
		// Add all the scholarships to the allScholarshipsPanel
		scholarshipLoop(scMap);
		// Switch the current JPanel
		switchPanel(allScholarshipsPanel);
	}
	
	
	public void setStudents(List<Student> students) {
		this.students=students;
	}
	
	
	public void scholarshipLoop(HashMap<Integer, Scholarship> scMap) {
		for(Integer ID: scMap.keySet()) {
			Scholarship value = scMap.get(ID);
			asp.displayScholarship(value);
		}
	}
	
	

	private void searchForScholarship(String name) {
		HashMap<Integer, Scholarship> filteredMap = new HashMap<Integer, Scholarship>();

		for(Integer ID: scMap.keySet()) {
			//if what the user entered, regardless of case, matches then put it into the filtered map 
			if(scMap.get(ID).getName().toLowerCase().contains(name.toLowerCase())) {
			filteredMap.put(ID,scMap.get(ID));

			}
		}	
		asp.resetScholarships();
		
		//display the filtered matches in a new panel
		scholarshipLoop(filteredMap);
		switchPanel(allScholarshipsPanel);
	}
	
	public void switchToViewScholarshipPanel(Scholarship scholarship) {
		// Display the scholarship
		vsp.displayScholarship(scholarship);
		// IF the current user is an admin display all students that have applied
		switchPanel(viewScholarshipPanel);
	}
	
	private void switchToViewStudentsAppliedPanel(Scholarship scholar) {
		vsapp.resetStudents();
		vsapp.setScholarship(currentScholarship);
		for(Student s: students) {
			if(scholar.getStudentsApplied().contains(s.getUCID())) {
				vsapp.addStudent(s);		
			}
		}	
		switchPanel(viewStudentsAppliedPanel);
	}
	
	private void switchToViewStudentsAcceptedPanel(Scholarship scholar) {
		vsacp.resetStudents();
		vsacp.setScholarship(currentScholarship);
		for(Student s: students) {
			if(scholar.getStudentsAccepted().contains(s.getUCID())) {
				vsacp.addStudent(s);
			}
		}	
		switchPanel(viewStudentsAcceptedPanel);
	}
	
	private void switchToViewStudentsWonPanel(Scholarship scholar) {
		vswp.resetStudents();
		vswp.setScholarship(currentScholarship);
		for(Student s: students) {
			if(scholar.getStudentsWon().contains(s.getUCID())) {
				vswp.addStudent(s);
			}
		}	
		switchPanel(viewStudentsWonPanel);
	}
	
	
	public EditScholarshipPanel getEdits() {
		return esp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the name of the button that was pressed
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		
		switch(name){
		case"ViewScholarship_AllScholarshipsPanel":
			// Get the id of the scholarship to view
			int id = Integer.parseInt(source.getActionCommand());
			// Find the scholarship
			currentScholarship = scMap.get(id);
			switchToViewScholarshipPanel(currentScholarship);
			break;
		case"Back_ViewScholarshipPanel":
			switchPanel(allScholarshipsPanel);
			break;
		case"Back_EditScholarshipPanel":
			switchPanel(allScholarshipsPanel);
			break;
		case "EditScholarship_ViewScholarshipPanel":
			esp.setScholarship(currentScholarship);
			// Switch the panel
			switchPanel(editScholarshipPanel);
			break;
		case "ViewStudentsApplied_ViewScholarshipPanel":
			switchToViewStudentsAppliedPanel(currentScholarship);
			break;
		case "ViewStudentsAccepted_ViewScholarshipPanel":
			switchToViewStudentsAcceptedPanel(currentScholarship);
			break;
		case "ViewStudentsWon_ViewScholarshipPanel":
			switchToViewStudentsWonPanel(currentScholarship);
			break;
		case "Back_ViewStudentsAppliedPanel":
			switchPanel(viewScholarshipPanel);
			break;
		case "Back_ViewStudentsWonPanel":
			switchPanel(viewScholarshipPanel);
			break;
		case "Back_ViewStudentsAcceptedPanel":
			switchPanel(viewScholarshipPanel);
			break;
		case"Search_AllScholarshipsPanel":
			// Get the text of the search bar
			String x = asp.getSearchResult();
			// Search for scholarships with the search string and display only those on the page
			searchForScholarship(x);
			break;
		default:
			break;
		}
	}
}
