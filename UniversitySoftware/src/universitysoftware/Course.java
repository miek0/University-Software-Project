package universitysoftware;

import java.util.ArrayList;

public class Course {
	protected int id;
	protected String courseName;
	protected String descr;
	protected ArrayList<Course> prereqs;
	protected ArrayList<Section> sections;
	protected String semester;
	protected char grade;

	public Course() {
		id = 0;
		courseName = "empty";
		descr = "empty";
		semester = "empty";
		grade = '0';
	}
	
	public Course(int cid, String cn, String d, ArrayList<Course> pr, ArrayList<Section> sec, String sem, char g) {
		id = cid;
		courseName = cn;
		descr = d;
		prereqs = pr;
		sections = sec;
		semester = sem;
		grade = g;
	}
	
	public int getID() {return id;}
	public void setID(int newID) {id = newID;}
	public String getCourse() {return courseName;}
	public void setcourse(String newC) {courseName = newC;}
	public String getDescr() {return descr;}
	public void setDescr(String newDes) {descr = newDes;}
	public String getSem() {return semester;}
	public void setSem(String newSem) {semester = newSem;}
	public char getGrade() {return grade;}
	
	public void addPrereq(int index, Course c) {
		if(index >= 0 && index < prereqs.size())
			prereqs.add(index,c);
		else
			prereqs.add(c);
	}
	
	public void removePrereq(int index) {
		prereqs.remove(index);
	}
	
	public void addSection(int index, Section s) {
		if(index >= 0 && index < sections.size())
			sections.add(index,s);
		else
			sections.add(s);
	}
	
	public void removeSecction(int index) {
		sections.remove(index);
	}
}