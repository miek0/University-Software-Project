package universitysoftware;

import java.util.ArrayList;

public class Section {
	protected int idNum;
	protected String courseName;
	protected int room;
	protected String building;
	protected int profId;
	protected String startTime;
	protected String endTime;
	protected ArrayList<Integer> studentIDs;
	
	public Section() {
		idNum = 0;
		courseName = "empty";
                room = 0;
                building = "empty";
		profId = 0;
		startTime = "none";
		endTime = "none";
	}
	
	public Section(int id, String cn, int r, String b, int pId, String st, String et, ArrayList<Integer> sID) {
		idNum = id;
		courseName = cn;
		room = r;
		building = b;
		profId = pId;
		startTime = st;
		endTime = et;
                studentIDs = sID;
	}
	
	public int getID() {return idNum;}
	public void setID(int newID) {idNum = newID;}
	public String getCourse() {return courseName;}
	public void setcourse(String newC) {courseName = newC;}
	public int getRoomNum() {return room;}
        public void setRoomNum(int newRN) { room = newRN;}
	public String getBld() {return building;}
        public void setBld(String newB) {building = newB;}
	public int getProfID() {return profId;}
	public void setProfID(int newPID) {profId = newPID;}
	public String getStartTime() {return startTime;}
	public void setStartTime(String newST) {startTime = newST;}
	public String getEndTime() {return endTime;}
	public void setEndTime(String newET) {endTime = newET;}
        
        public void addStudentID(int index, int id) {
		if(index >= 0 && index < studentIDs.size())
			studentIDs.add(index,id);
		else
			studentIDs.add(id);
	}
	
	public void removeStudentID(int index) {
		studentIDs.remove(index);
	}
        
        public int getStudentID(int needID){
            for(int ID: studentIDs){
                if(ID == needID)
                    return ID;
            }
            return 0;
        }
}