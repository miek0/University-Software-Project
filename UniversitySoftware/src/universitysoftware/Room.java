package universitysoftware;

public class Room {
	protected int rmNum;		//room number
	protected int rmCap;		//room capacity
	protected boolean rmFull;	//is room full
	protected String building;		//building number
	
	public Room() {
		rmNum = 0;
		rmCap = 0;
		rmFull = false;
		building = "empty";
	}
	
	public Room(int rn, int rc, String bn) {
		rmNum = rn;
		rmCap = rc;
		rmFull = false;
		building = bn;
	}
	
	public void setRmNum(int newRN) { rmNum = newRN; }
	public int getRmNum() {return rmNum;}
	public void setRmCap(int newRC) { rmCap = newRC; }
	public int getRmCap() {return rmCap;}
	public void setBLD(String newBLD) { building = newBLD; }
	public String getBLD() {return building;}
}
