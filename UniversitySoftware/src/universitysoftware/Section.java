package universitysoftware;

import java.util.ArrayList;

public class Section {
	protected int idNum;
	protected String courseName;
	protected Room room;
	protected Building building;
	protected int profId;
	protected String startTime;
	protected String endTime;
	protected ArrayList<Integer> studentIDs;
	
	public Section() {
		idNum = 0;
		courseName = "empty";
		profId = 0;
		startTime = "none";
		endTime = "none";
	}
	
	public Section(int id, String cn, Room r, Building b, int pId, String st, String et) {
		idNum = id;
		courseName = cn;
		room = r;
		building = b;
		profId = pId;
		startTime = st;
		endTime = et;
	}
	
	public int getID() {return idNum;}
	public void setID(int newID) {idNum = newID;}
	public String getCourse() {return courseName;}
	public void setcourse(String newC) {courseName = newC;}
	public int getRoomNum() {return room.getRmNum();}
	public String getBld() {return building.getBldName();}
	public int getProfID() {return profId;}
	public void setProfID(int newPID) {profId = newPID;}
	public String getStartTime() {return startTime;}
	public void setStartTime(String newST) {startTime = newST;}
	public String getEndTime() {return endTime;}
	public void setEndTime(String newET) {endTime = newET;}
}