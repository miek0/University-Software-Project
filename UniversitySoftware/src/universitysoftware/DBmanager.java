/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitysoftware;
import java.sql.*;
import java.util.ArrayList;
/**
 * 
 * @author 018639476
 */

/* Singleton Class*/
public class DBmanager {

    static final String DB_URL = "jdbc:mysql://localhost:3306/university";
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;
    
    //singleton class object
    private static DBmanager instance = null;
 
    //private constructor
    private DBmanager()
    {
        try {
            System.out.println("Connecting to University database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful!");
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Failed!");
        }
    }
    
    public static DBmanager getInstance()
    {
        if(instance==null)
        {
            instance = new DBmanager();
            return instance;
        }
        else
            return instance;
    }
    
    public ArrayList<String> getColleges()
    {
        ArrayList<String> collegeNames = new ArrayList<>();
        try {
            String sql = "SELECT collegeName FROM colleges";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                collegeNames.add(rs.getString("collegeName"));
            }
            return collegeNames;
        }
        catch (Exception e) {
            System.out.println("getColleges query failed!");
            return null;
        }
    }
}
