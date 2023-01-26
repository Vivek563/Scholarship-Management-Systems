package objects;

import java.util.Arrays;
import java.util.List;


public class Student extends User{
	
	
	private String faculty;
	private double gpa;
	private int yearOfStudy;
	private String typeOfStudy;
	private String department;
	private List<Integer> scholarshipsAppliedTo;
	private List<Integer> scholarshipsAcceptedTo;
	private int[] scholarshipsWon = new int []{-1,-1};
	

	public Student(int ucid, String email, String password, String name, String faculty,
			double gpa, int yearOfStudy, String typeOfStudy, String department, List<Integer> scholarshipsAppliedTo, List<Integer> scholarshipsAcceptedTo, int[] scholarshipsWon) {
		super(ucid, email, password, name);
		this.faculty = faculty;
		this.gpa = gpa;
		this.yearOfStudy = yearOfStudy;
		this.typeOfStudy= typeOfStudy;
		this.department= department;
		this.scholarshipsAppliedTo=scholarshipsAppliedTo;
		this.scholarshipsAcceptedTo = scholarshipsAcceptedTo;
		this.scholarshipsWon = scholarshipsWon;
	}
	
	
	public String toFile() {
		return getUCID()+":"+getEmail()+":"+getPassword()+":"+getName();
	}
	
	
	public String getFaculty() {
		return faculty;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
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
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Integer> getScholarshipsAppliedTo() {
		return scholarshipsAppliedTo;
	}
	public List<Integer> getScholarshipsAcceptedTo() {
		return scholarshipsAcceptedTo;
	}
	public int[] getScholarshipsWon() {
		return scholarshipsWon;
	}
	
	public boolean addToAccept(int id) {
		if(scholarshipsAcceptedTo.contains(id)) {
			return false;
		}else {
			if(scholarshipsAppliedTo.contains(id)) {
				removeScholarship(id);
				scholarshipsAcceptedTo.add(id);
				return true;
			}
			return false;
		}
	}
	
	public boolean addScholarshipToApplied(int id) {
		if (scholarshipsAppliedTo.contains(id)) {
			return false;
		}
		else {
			scholarshipsAppliedTo.add(id);
			return true;
		}
	}
	
	public boolean addScholarshipByPriority(int id, int index) {
		if (scholarshipsAppliedTo.contains(id)) {
			return false;
		}
		else {
			scholarshipsAppliedTo.add(index,id);
			return true;
		}
	}
	
	public boolean changeScholarshipPriority(int id, int priority) {
		if (scholarshipsAppliedTo.remove((Integer) id)) {
			scholarshipsAppliedTo.add(priority,id);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean removeScholarship(int id){
		return scholarshipsAppliedTo.remove((Integer) id);
	}
	public boolean removeScholarshipFromAccept(int id){
		return scholarshipsAcceptedTo.remove((Integer) id);
	}
	public boolean addToWon(int id) {
		if(Arrays.stream(scholarshipsWon).anyMatch(i -> i == id)) {
			return false;
		}
		if(scholarshipsWon[0]<=0) {
			scholarshipsWon[0] = id;
			scholarshipsAcceptedTo.remove(scholarshipsAcceptedTo.indexOf(id));
			return true;
		}else if(scholarshipsWon[1]<=0){
			scholarshipsWon[1] = id;
			scholarshipsAcceptedTo.remove(scholarshipsAcceptedTo.indexOf(id));
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String appliedToSch = "";
		if(scholarshipsAppliedTo.isEmpty()) {
			appliedToSch = "noneApplied";
		}else {
			for(Integer i : scholarshipsAppliedTo) {
				appliedToSch+=i+":";
				
			}
			appliedToSch = appliedToSch.substring(0, appliedToSch.length()-1);
		}

		String acceptedToSch = "";
		if(scholarshipsAcceptedTo.isEmpty()) {
			acceptedToSch = "noneAccepted";
		}else {
			for(Integer i : scholarshipsAcceptedTo) {
				acceptedToSch+=i+":";
				
			}
			acceptedToSch= acceptedToSch.substring(0, acceptedToSch.length()-1);
		}
		String schWon="";
		if (scholarshipsWon!=null) {
			schWon = scholarshipsWon[0]+":"+scholarshipsWon[1];
		}
		if(scholarshipsWon[0]==0 && scholarshipsWon[1] ==0) {
			schWon="noneWon";
		}
		if(scholarshipsWon[0]>0&& scholarshipsWon[1]>0) {
			acceptedToSch = "noneAccepted";
		}
		
		String returnString = getUCID()+","+getEmail()+","+getPassword()+","+getName()
		+","+faculty+","+gpa+","+yearOfStudy+","+typeOfStudy+","+department+","+appliedToSch+","+acceptedToSch+","+schWon;
		return returnString;
	}
	
}
