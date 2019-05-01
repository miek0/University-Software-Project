package universitysoftware;
import java.util.*;

public class College {
	private String name;
	private int deanID;
	private ArrayList<Department> departments;
	public College(String collegeName){ //contructor
		name = collegeName;
	}
	
	public void setCollegeName(String collegeName){ //setter
		name = collegeName;
	}
	
	public String getCollegeName(){ //getter
		return name;
	}
	
	public void setDean(int dID){
		deanID = dID;
	}
	
	public int getDean(){
		return deanID;
	}
	
	public void addDepartment(Department department){
		departments.add(department);
	}
	
	public List<Department> getDepartments(){
		return departments;
	}
	
	public void removeDepartment(Department department){
		if (departments.contains(department)){
			departments.remove(department);
		}
	}
}
