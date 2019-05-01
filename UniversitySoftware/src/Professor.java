import java.util.ArrayList;

import universitysoftware.Course;

public class Professor {
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
