import java.util.ArrayList;
import universitysoftware.Course;

public class Student {
	protected String fName;
	protected String lName;
	protected String mName;
	protected int id;
	protected String rDate;
	protected boolean tuitionStatus;
	protected String major;
	protected ArrayList<Course>courseList;
	protected ArrayList<String>grades;
	
	public Student() {
		
	}
	
	void setfName(String name){
		fName = name;
	}
	
	String getfName() {
		return fName;
	}
	
	void setlName(String name){
		fName = name;
	}
	
	String getlName() {
		return fName;
	}
	
	void setmName(String name){
		fName = name;
	}
	
	String getmName() {
		return fName;
	}
	
	void setid(int id){
		this.id = id;
	}
	
	int getid() {
		return id;
	}
	
	void setrDate(String regis) {
		rDate = regis;
	}
	
	String getrDate() {
		return rDate;
	}
	
	void settuitionStatus(boolean status) {
		tuitionStatus = status;
	}
	
	boolean gettuitionStatus() {
		return tuitionStatus;
	}
	
	void setmajor(String major) {
		this.major = major;
	}
	
	String getmajor() {
		return major;
	}
	
	void addCourse(Course course) {
		courseList.add(course);		
	}
	
	void removeCourse(int index) {
		courseList.remove(index);
	}
	
	//Function for retrieving grades from course object
	String getGrades() {
		String result = "";
		for(int i = 0; i < courseList.size(); i++) {
			result = result + courseList.get(i).getCourse();
			result = result + " = " + courseList.get(i).getGrade() + "\n";			
		}
		
		return result;
	}
	
	//Function for calculating GPA using grades from course object
	double getGPA() {
		double total = 0;
		int count = 0;
		
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getGrade() == 'A')
				total = total + 4;
			else if(courseList.get(i).getGrade() == 'B')
				total = total + 3;
			else if(courseList.get(i).getGrade() == 'C')
				total = total + 2;
			else if(courseList.get(i).getGrade() == 'D')
				total = total + 1;
			else
				total = total + 0;
			
			count++;
		}
		
		total = total / count;
		
		return total;
	}
	//Function to print all courses and times
	String printSchedule() {
		String schedule = "";
		
		for(int i = 0; i < courseList.size(); i++) {
			schedule = schedule + courseList.get(i).getCourse() + " ";
			schedule = schedule + courseList.get(i).getDescr() + "\n";
		}
		
		return schedule;
	}
}
