/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitysoftware;
import UI.StudentWin;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    
    /*gets general data for display based on the string query passed to it*/
    public DefaultTableModel getData(String query)
    {
        DefaultTableModel model = new DefaultTableModel();
        try {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            model.setColumnCount(colCount);
            
            //setting labels of model
            Object[] labels = new Object[colCount];
            for(int i =0; i<colCount;i++)
                labels[i] = rsmd.getColumnLabel(i+1);//starts from 1???
            model.setColumnIdentifiers(labels);
            
            //setting rows of model
            Object[] rowData = new Object[colCount];
            while(rs.next())//while has next -> add row
            {
                for(int j = 0; j<colCount; j++)
                    rowData[j] = rs.getObject(j+1);
                model.addRow(rowData);
            }
            return model;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public String update(String query)
    {
        String message;
        try {
            stmt.executeUpdate(query);
            message = "Database is updated successfully.";
        } catch (SQLException ex) {
//            message = "Could not Update database";
            message = "Error: Uspdate failed! "+ ex.getMessage();
            Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    public boolean studentLogin(String id)
    {
        
        try {
            ResultSet results = stmt.executeQuery("SELECT * FROM students WHERE id ="+id);
            if(results.next()){
               System.out.println("Success"); 
               if(id.equals(results.getString(1)) && results.getInt(5)>0)
               {
                    Student student = new Student();
                    student.setid(Integer.parseInt(results.getString(1)));
                    student.setfName(results.getString(2));
                    student.setlName(results.getString(3));
                    student.setmName(results.getString(4));
                    student.setIsRegistered(results.getInt(5)>0);
                    student.settuitionStatus(results.getInt(6)>0);
                    StudentWin studentWin = new StudentWin(student);
                    studentWin.setVisible(true);
                    return true;
               }
            }
            else{
               System.out.println("Failed"); 
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    
    public boolean studentAddCourse(int studentId, int sessionId)
    {
        String sql = "INSERT INTO `schedules` (`studentid`, `sessionId`, `current`) VALUES ('"+studentId+"', '"+sessionId+"', 1);";
        try{
            stmt.executeUpdate(sql);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public Course getCourse(int sessionId)
    {
        Course course = new Course();
        String sql = "Select `units`, `courseName` from courses where courseName = (Select `courseName` FROM sessions WHERE sessionNumber ="+sessionId+");";
        try{
            ResultSet rst = stmt.executeQuery(sql);
            if(rst.next())
            {
                course.setUnits( rst.getInt(1));
                course.setcourse(rst.getString(2));//set courseName
            }
            return course;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public boolean checkPrereq(Course course, int studentId)
    {
        ArrayList<String> prereqs = new ArrayList<>();
        ArrayList<String> coursesTaken = new ArrayList<>();
        String sql1 = "SELECT `courseName` FROM courses WHERE preReqOf = '"+course.getCourse()+"';";
        String sql2 = "Select `courseName` from courses where courseName IN (Select `courseName` FROM sessions WHERE sessionNumber IN ( SELECT `sessionId` FROM schedules WHERE studentid = "+studentId+" AND current = 0));";
        try{
            ResultSet rst1 = stmt.executeQuery(sql1);
            while(rst1.next())
            {
                prereqs.add(rst1.getString(1));
                System.out.println(rst1.getString(1));
            }
            
            ResultSet rst2 = stmt.executeQuery(sql2);
            while(rst2.next())
            {
                coursesTaken.add(rst2.getString(1));
                System.out.println(rst2.getString(1));
            }
            for(String e: prereqs)
            {
                if(!coursesTaken.contains(e))
                    return false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return true;
    }
    
}
