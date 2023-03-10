package objects;

import java.util.ArrayList;
import java.util.List;


public class Scholarship {

	
	private String name;
	private int scholarshipId;
	private double gpaRequirement;
	private String faculty;
	private int yearOfStudy;
	private String typeOfStudy;
	private String Department;
	private int numAllowed;
	private String description;
	private double money;
	
	private List<Integer> studentsApplied;
	private List<Integer> studentsAccepted;
	private List<Integer> studentsWon = new ArrayList<Integer>();

	
	public Scholarship() {
		this.name = "Sch1";
		this.scholarshipId = 1;
		this.gpaRequirement = 3.00;
		this.faculty = "Science";
		this.yearOfStudy = 3;
		this.typeOfStudy = "Bachelor";
		this.Department = "CPSC";
		this.numAllowed = 100;
		this.description = "This is a generic scholarship";
		this.setMoney(0.00);
		this.studentsApplied = new ArrayList<>();
		this.studentsAccepted = new ArrayList<>();

	}
	
	
	public Scholarship(String name, String sId, String gReq, String faculty, String YOS, String TOS, String Dept,
			String nums, String desc, String money,List<Integer> studentsApplied, List<Integer> studentsAccepted, List<Integer> studentsWon) {
		this.name = name;
		this.scholarshipId = Integer.parseInt(sId);
		this.gpaRequirement = Double.parseDouble(gReq);
		this.faculty = faculty;
		this.yearOfStudy = Integer.parseInt(YOS);
		this.typeOfStudy = TOS;
		this.Department = Dept;
		this.numAllowed = Integer.parseInt(nums);
		this.description = desc;
		this.money = Double.parseDouble(money);
		this.studentsApplied= studentsApplied;
		this.studentsAccepted = studentsAccepted;
		this.studentsWon = studentsWon;

	}
	
	

	public String returnFull() {
		return (name + ":" + scholarshipId + ":" + gpaRequirement + ":" + faculty + ":" + yearOfStudy + ":"
				+ typeOfStudy + ":" + Department + ":" + numAllowed + ":" + description + ":" +money);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return scholarshipId;
	}

	public void setId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public double getGpaRequirement() {
		return gpaRequirement;
	}

	public void setGpaRequirement(double gpaRequirement) {
		this.gpaRequirement = gpaRequirement;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getTypeOfStudy() {
		return typeOfStudy;
	}

	public void setTypeOfStudy(String typeOfStudy) {
		this.typeOfStudy = typeOfStudy;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public int getNumAllowed() {
		return numAllowed;
	}

	public void setNumAllowed(int numAllowed) {
		this.numAllowed = numAllowed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public boolean addStudentToApplied(int id) {
		if (studentsApplied.contains(id)) {
			return false;
		}
		else {
			studentsApplied.add(id);
			return true;
		}
	}
	
	public boolean removeStudentFromApplied(int ucid) {
		return (studentsApplied.remove((Integer)ucid));
	}
	
	
	public boolean addStudentToAccepted(int id) {
		if (studentsAccepted.contains(id)) {
			return false;
		}
		else {
			if(studentsApplied.contains(id)) {
				removeStudentFromApplied(id);
				studentsAccepted.add(id);
				return true;
			}
			
			return false;
		}
	}
	
	public boolean addStudentToWon(int id) {
		if (studentsWon.contains(id)) {
			return false;
		}
		else {
			studentsWon.add(id);
			return true;
		}
	}
	
	public boolean removeStudentFromAccepted(int ucid) {
		return (studentsAccepted.remove((Integer)ucid));
	}
	
	
	public List<Integer> getStudentsApplied() {
		return studentsApplied;
	}
	
	public List<Integer> getStudentsAccepted() {
		return studentsAccepted;
	}
	public List<Integer> getStudentsWon(){
		return studentsWon;
	}
	
	
	@Override
	public String toString() {
		
		String appliedStudents = "";
		if(studentsApplied.isEmpty()) {
			appliedStudents = "noneApplied";
		}else {
			for(Integer i : studentsApplied) {
				appliedStudents+=i+":";
				
			}
			appliedStudents = appliedStudents.substring(0, appliedStudents.length()-1);
		}
		
		String acceptedStudents = "";
		if(studentsAccepted.isEmpty()) {
			acceptedStudents = "noneAccepted";
		}else {
			for(Integer i : studentsAccepted) {
				acceptedStudents+=i+":";
				
			}
			acceptedStudents = acceptedStudents.substring(0, acceptedStudents.length()-1);
		}
		
		String wonStudents = "";
		if(studentsWon.isEmpty()) {
			wonStudents = "noneWon";
		}else {
			for(Integer i : studentsWon) {
				wonStudents+=i+":";
				
			}
			wonStudents = wonStudents.substring(0, wonStudents.length()-1);
		}
		
		
		String returnString = name + "," + scholarshipId + "," + gpaRequirement + "," + faculty + "," + yearOfStudy + ","
				+ typeOfStudy + "," + Department + "," + numAllowed + "," + description + "," + money +","+appliedStudents+","+acceptedStudents+","+wonStudents;
		
		return (returnString);
	}

}
