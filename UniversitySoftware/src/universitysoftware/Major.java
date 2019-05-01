package universitysoftware;
import java.util.*;

public class Major {
	private String name;
	private int ID;
	private ArrayList<Course> courses;
	
	public Major(String majorName){ //contructor
		name = majorName;
	}
	
	public void setMajorName(String majorName){ //setter
		name = majorName;
	}
	
	public String getMajorName(){ //getter
		return name;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getChair(){
		return ID;
	}
	
	public void addCourse(Course course){
		courses.add(course);
	}
	
	public List<Course> getCourses(){
		return courses;
	}
	
	public void removeDepartment(Course course){
		if (courses.contains(course)){
			courses.remove(course);
		}
	}
}
