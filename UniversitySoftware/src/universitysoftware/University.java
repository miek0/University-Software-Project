package universitysoftware;

import java.util.*;

public class University {
	private String name;
	private ArrayList<College> colleges;
	
	public University(String uniName){ //contructor
		name = uniName;
	}
	
	public String getUniversityName(){ //getter
		return name;
	}
	
	public void addCollege(College college){
		colleges.add(college);
	}
	
	public List<College> getColleges(){
		return colleges;
	}
	
	public void removeCollege(College college){
		if (colleges.contains(college)){
			colleges.remove(college);
		}
	}
}
