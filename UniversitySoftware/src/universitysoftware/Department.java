package universitysoftware;
import java.util.*;

public class Department {
	private String name;
	private int chairID;
	private ArrayList<Major> majors;
	
	public Department(String departmentName){ //contructor
		name = departmentName;
	}
	
	public void setDepartmentName(String departmentName){ //setter
		name = departmentName;
	}
	
	public String getDepartmentName(){ //getter
		return name;
	}
	
	public void setChair(int cID){
		chairID = cID;
	}
	
	public int getChair(){
		return chairID;
	}
	
	public void addMajor(Major major){
		majors.add(major);
	}
	
	public List<Major> getMajors(){
		return majors;
	}
	
	public void removeDepartment(Major major){
		if (majors.contains(major)){
			majors.remove(major);
		}
	}
}
