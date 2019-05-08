package universitysoftware;

import java.util.ArrayList;

public class Course {
	//protected int id;
	protected String courseName;
	protected String descr;
	protected String prereq; //course name attr.
	protected ArrayList<String> sections;//section name attr.
	protected String semester;
	protected char grade;
        protected int units;

	public Course() {
		//id = 0;
		courseName = "empty";
		descr = "empty";
		semester = "empty";
		grade = '0';
	}
	
	public Course(String cn, String d, String pr, ArrayList<String> sec, String sem, char g) {
		//id = cid;
		courseName = cn;
		descr = d;
		prereq = pr;
		sections = sec;
		semester = sem;
		grade = g;
	}
        
        public void setUnits(int units)
        {
            this.units = units;
        }
        
        public int getUnits()
        {
            return units;
        }
	
	//public int getID() {return id;}
	//public void setID(int newID) {id = newID;}
	public String getCourse() {return courseName;}
	public void setcourse(String newC) {courseName = newC;}
	public String getDescr() {return descr;}
	public void setDescr(String newDes) {descr = newDes;}
	public String getSem() {return semester;}
	public void setSem(String newSem) {semester = newSem;}
	public char getGrade() {return grade;}
	public void setPreReq(String newPR) { prereq = newPR; }
	public String getPreReq() { return prereq;}
	
	public void addSection(int index, String s) {
		if(index >= 0 && index < sections.size())
			sections.add(index,s);
		else
			sections.add(s);
	}
	
	public void removeSection(int index) {
		sections.remove(index);
	}
        
        public String getSection(String sect){
            for(String section: sections){
                if(section.equals(sect))
                    return section;
            }
            return null;
        }
}