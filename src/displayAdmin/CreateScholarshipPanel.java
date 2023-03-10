package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myJStuff.*;

public class CreateScholarshipPanel extends MyPanel{
	
	private JTextField fldName;
	private JTextField fldGpa;
	private JTextField fldDepartment;
	private JTextField fldNumAllowed;
	private JTextField fldDescription;
	private JTextField fldAmount;

	private JLabel lblEditName;
	private JLabel lblEditGpa;
	private JLabel lblEditFaculty;
	private JLabel lblEditYearOfStudy;
	private JLabel lblEditTypeOfStudy;
	private JLabel lblEditDepartment;
	private JLabel lblEditNumAllowed;
	private JLabel lblEditDescription;
	private JLabel lblEditAmount;
	
	private JComboBox<Object> yosList;
	private JComboBox<Object> facList;
	private JComboBox<Object> tosList;
	
	private JLabel lblHeader;
	
	private JButton btnBack;
	
	private JButton btnSave;
	
	public CreateScholarshipPanel(ActionListener packageListener){
		this.packageListener = packageListener;
		contentPane.setName("Create Scholarship Panel");
		displayNorth();
		displayCenter();
		displaySouth();
	}
	
	private void displayNorth() {
		lblHeader = new MyLabel("Create Scholarship", Size.defaultLblSubTitleFontSize);
		north.add(lblHeader, "cell 0 0,center");
	}
	
	private void displayCenter() {
		
		String[] diffFaculties = {"Arts","Science","Commerce","University"};
		String[] diffYOS = {"1","2","3","4","5","6","7","8","9","10"};
		String[] diffTOS = {"Bachelor", "Master's","PhD","Continuing Education"};
		
		lblEditName = new MyLabel("Scholarship Name:", Size.defaultLblFontSize);
		center.add(lblEditName, "cell 0 0");
		
		fldName = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldName,"cell 0 1");
		
		lblEditGpa = new MyLabel("CGPA:", Size.defaultLblFontSize);
		center.add(lblEditGpa, "cell 0 2");
		
		fldGpa = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldGpa,"cell 0 3");
		
		lblEditFaculty = new MyLabel("Faculty:", Size.defaultLblFontSize);
		center.add(lblEditFaculty, "cell 0 6");
		
		facList = new MyComboBox(diffFaculties);
		
		facList.setSelectedIndex(0);
		center.add(facList, "cell 0 7");
		
		lblEditYearOfStudy = new MyLabel("Year of Study:", Size.defaultLblFontSize);
		center.add(lblEditYearOfStudy, "cell 0 8");
		
		
		yosList = new MyComboBox(diffYOS);		
		yosList.setSelectedIndex(0);
		center.add(yosList, "cell 0 9");
		
		
		
		lblEditTypeOfStudy = new MyLabel("Type of Study:", Size.defaultLblFontSize);
		center.add(lblEditTypeOfStudy, "cell 2 6");
		
		tosList = new MyComboBox(diffTOS);		
		tosList.setSelectedIndex(0);
		center.add(tosList, "cell 2 7");
		
		lblEditDepartment = new MyLabel("Department:", Size.defaultLblFontSize);
		center.add(lblEditDepartment, "cell 2 0");
		

		fldDepartment = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldDepartment, "cell 2 1");		
		
		lblEditNumAllowed = new MyLabel("Max Number of Scholarships Avaliable:", Size.defaultLblFontSize);
		center.add(lblEditNumAllowed, "cell 2 2");
		
		fldNumAllowed = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldNumAllowed, "cell 2 3");
		
		lblEditDescription = new MyLabel("Description:", Size.defaultLblFontSize);
		center.add(lblEditDescription, "cell 0 4");
		
		fldDescription = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldDescription,"cell 0 5");
		
		lblEditAmount = new MyLabel("Amount:", Size.defaultLblFontSize);
		center.add(lblEditAmount, "cell 2 4");
		
		fldAmount = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldAmount,"cell 2 5");
		
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_CreateScholarshipPanel");
		
		btnSave = new MyButton("Create", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnSave, "cell 1 0 , right");
		btnSave.addActionListener(packageListener);
		btnSave.setName("Create_CreateScholarshipPanel");
		
	}
	
	
	public String getName() {
		if(fldName.getText().contains(",")) {
			return "";
		}else {
			return fldName.getText();
		}
	}
	
	public double getGpa() {
		try{
			return Double.parseDouble(fldGpa.getText());
		}catch(Exception e){
			return -1.0;
		}
		
	}
	
	public String getFaculty() {
		return String.valueOf(facList.getSelectedItem());
		
	
	}
	
	public int getYearOfStudy() {
		try {
			return Integer.parseInt(String.valueOf(yosList.getSelectedItem()));
		}catch(Exception e) {
			return -1;
		}
	}
	
	public String getTypeOfStudy() {
		return String.valueOf(tosList.getSelectedItem());
	}
	
	public String getDepartment() {
		if(fldDepartment.getText().contains(",")) {
			return "";
		}else {
			return fldDepartment.getText();
		}
	}
	
	public int getNumAllowed() {
		try {
			return Integer.parseInt(fldNumAllowed.getText());
		}catch(Exception e ) {
			return -1;
		}
		
	}

	public String getDescription() {
		if (fldDescription.getText().contains(",")) {
			return "";
		}else {
			return fldDescription.getText();
		}
	}
	

	public double getMoney() {
		try {
			return Double.parseDouble(fldAmount.getText());
		}
		catch(Exception e) {
			return -1.0;
		}
		
	}
	
	public void clearAll() {
		fldName.setText("");
		fldGpa.setText("");
		fldDepartment.setText("");
		fldNumAllowed.setText("");
		fldDescription.setText("");
		fldAmount.setText("");
	}
	
}