package universitysoftware;
import java.util.ArrayList;

public class Person {
	private String fName;
	private String lName;
	private char mName;
	
	public Person() {

	}
	
	public void setfName(String name){
		fName = name;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setlName(String name){
		lName = name;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setmName(String name){
            if(name!=null)
		mName = name.charAt(0);
	}
	
	public char getmName() {
		return mName;
	}	
}
