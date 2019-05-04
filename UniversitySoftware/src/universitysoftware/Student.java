package universitysoftware;
import java.util.ArrayList;

public class Student extends Person{
	protected int id;
	protected String rDate;
	protected boolean tuitionStatus;
        protected boolean isRegistered;
	protected String major;
	protected ArrayList<Course>courseList;
	protected ArrayList<String>grades;
	
	public Student() {
		
	}
	
	public void setid(int id){
		this.id = id;
	}
	
	public int getid() {
		return id;
	}
	
	public void setrDate(String regis) {
		rDate = regis;
	}
	
	public String getrDate() {
		return rDate;
	}
	
	public void settuitionStatus(boolean status) {
		tuitionStatus = status;
	}
	
	public boolean gettuitionStatus() {
		return tuitionStatus;
	}
	
	public void setmajor(String major) {
		this.major = major;
	}
	
	public String getmajor() {
		return major;
	}
	
	public void addCourse(Course course) {
		courseList.add(course);		
	}
	
	public void removeCourse(int index) {
		courseList.remove(index);
	}
	
	//Function for retrieving grades from course object
	public String getGrades() {
		String result = "";
		for(int i = 0; i < courseList.size(); i++) {
			result = result + courseList.get(i).getCourse();
			result = result + " = " + courseList.get(i).getGrade() + "\n";			
		}
		
		return result;
	}
        
        public void setIsRegistered(boolean status)
        {
            isRegistered = status;
        }
        
        public boolean isRegistered()
        {
            return isRegistered;
        }
	
	//Function for calculating GPA using grades from course object
	public double getGPA() {
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
	public String printSchedule() {
		String schedule = "";
		
		for(int i = 0; i < courseList.size(); i++) {
			schedule = schedule + courseList.get(i).getCourse() + " ";
			schedule = schedule + courseList.get(i).getDescr() + "\n";
		}
		
		return schedule;
	}
}
