package universitysoftware;
import java.util.ArrayList;

public class Professor extends Employee{
	protected ArrayList<Course> courseTaught;
	
	public Professor(){
		
	}
	
	void addCourse(Course course){
		courseTaught.add(course);
	}
	
	void removeCourse(int index) {
		courseTaught.remove(index);
	}
	
}
