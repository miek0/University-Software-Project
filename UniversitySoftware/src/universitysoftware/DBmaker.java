/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitysoftware;
import java.io.File;
import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author 018639476
 */
public class DBmaker {
    
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL1 = "jdbc:mysql://localhost:3306/university";
    static final String DB_URL2 = "jdbc:mysql://localhost:3306/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";

    
    public void makeDatabase()
    {
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
            System.out.println("Checking if database University exists ...");
            conn = DriverManager.getConnection(DB_URL1, USER, PASS);
            System.out.println("University database found!");
            conn.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            try{
                System.out.println("University database Not found!");
               System.out.println("Creating and populating database University with initial data ...");
               conn = DriverManager.getConnection(DB_URL2, USER, PASS);
    
               stmt = conn.createStatement();
    
               String sql = "CREATE DATABASE UNIVERSITY";
               stmt.executeUpdate(sql);
               System.out.println("Database created successfully...");

                /*Creating tables in database University*/
                conn = DriverManager.getConnection(DB_URL1, USER, PASS);
                stmt = conn.createStatement();
        
                /*making and populating tables by initial data*/
                makeBuildingsTable(stmt,"src/Data/buildings.txt");
                makeRoomsTable(stmt,"src/Data/rooms.txt" );
                makeCollegesTable(stmt, "src/Data/colleges.txt");
                makeDepartmentsTable(stmt,"src/Data/departments.txt" );
                makeMajorsTable(stmt,"src/Data/majors.txt");
                makeCoursesTable(stmt,"src/Data/courses.txt");
                makeSessionsTable(stmt,"src/Data/sessions.txt");

                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e1){
                //Handle errors for Class.forName
                e1.printStackTrace();
            }
        }
    }//end of function

    
    public void makeCollegesTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE colleges " +
                   " (collegeName VARCHAR(60) not NULL, " + 
                   " dean VARCHAR(60), " + 
                   " PRIMARY KEY ( collegeName ))"; 
            stmt.executeUpdate(sql);
            System.out.println("colleges table created");
            /*inserting initial records to the table. MAX = 10*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                sql = "INSERT INTO colleges (`collegeName`) VALUES ('"+fin.nextLine()+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create colleges table");
            e.printStackTrace();
        }
    }
    
    public void makeDepartmentsTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE departments " +
                   " (departmentName VARCHAR(60) not NULL, " +
                   " collegeName VARCHAR(60), FOREIGN KEY (collegeName) REFERENCES colleges(collegeName) On UPDATE CASCADE ON DELETE RESTRICT, " + 
                   " chair VARCHAR(60), " + 
                   " PRIMARY KEY ( departmentName ))";
            stmt.executeUpdate(sql);
            System.out.println("departments table created");
            /*inserting initial records to the table. MAX = 30 dept /per college*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                String[] line = fin.nextLine().split(",");
                sql = "INSERT INTO departments (`departmentName`, `collegeName`) VALUES ('"+line[0]+"', '"+line[1]+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create departments table");
            e.printStackTrace();
        }
    }
    
      public void makeMajorsTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE majors " +
                   " (majorName VARCHAR(60) not NULL, " +
                   " departmentName VARCHAR(60), FOREIGN KEY (departmentName) REFERENCES departments(departmentName) On UPDATE CASCADE ON DELETE RESTRICT, " + 
                   " PRIMARY KEY ( majorName ))";

            stmt.executeUpdate(sql);
            System.out.println("majors table created");
            /*inserting initial records to the table. MAX = 50*/
             File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                String[] line = fin.nextLine().split(",");
                sql = "INSERT INTO majors (`majorName`, `departmentName`) VALUES ('"+line[0]+"', '"+line[1]+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create majors table");
            e.printStackTrace();
        }
    }
    
    
    public void makeCoursesTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE courses " +
                   " (courseName VARCHAR(60) not NULL, " +
                   " majorName VARCHAR(60) not NULL, FOREIGN KEY (majorName) REFERENCES majors(majorName) On UPDATE CASCADE ON DELETE RESTRICT, " + 
                   " description VARCHAR(250),"+
                   " units INT not NULL, " + 
                   " preReqOf VARCHAR(60), " +
                   " PRIMARY KEY ( courseName ))";

            stmt.executeUpdate(sql);
            System.out.println("courses table created");
            /*inserting initial records to the table. MAX = 100*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                String[] line = fin.nextLine().split(",");
                sql = "INSERT INTO courses (`courseName`, `majorName`, `description`, `preReqOf`, `units`) VALUES ('"+line[0]+"', '"+line[1]+"', '"+line[2]+"', '"+line[3]+"', '"+line[4]+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create courses table");
            e.printStackTrace();
        }
    }  
    
    public void makeSessionsTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE sessions " +
                   " (sessionNumber INT not NULL, " +
                   " courseName VARCHAR(60) not NULL, FOREIGN KEY (courseName) REFERENCES courses(courseName) On UPDATE CASCADE ON DELETE RESTRICT, " + 
                   " professorName VARCHAR(60), " +
                   " semester INT not NULL, " + 
                   " startTime VARCHAR(60) not NULL, " + 
                   " endTime VARCHAR(60) not NULL, " + 
                   " buildingName VARCHAR(60), FOREIGN KEY (buildingName) REFERENCES buildings(buildingName) On UPDATE CASCADE ON DELETE RESTRICT," +
                   " roomNumber INT, FOREIGN KEY (roomNumber) REFERENCES rooms(roomNumber) On UPDATE CASCADE ON DELETE RESTRICT," +
                   " PRIMARY KEY ( sessionNumber ))";

            stmt.executeUpdate(sql);
            System.out.println("sessions table created");
            /*inserting initial records to the table. MAX = none*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                String[] line = fin.nextLine().split(",");
                sql = "INSERT INTO sessions (`sessionNumber`, `courseName`, `professorName`, `semester`, `startTime`,`endTime`,`buildingName`,`roomNumber`) VALUES ("+line[0]+", '"+line[1]+"', '"+line[2]+"', "+line[3]+", '"+line[4]+"', '"+line[5]+"', '"+line[6]+"', "+line[7]+")";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create sessions table");
            e.printStackTrace();
        }
    }  
      
    public void makeBuildingsTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE buildings " +
                   " (buildingName VARCHAR(60) not NULL," +
                   " PRIMARY KEY ( buildingName ))";

            stmt.executeUpdate(sql);
            System.out.println("buildings table created");
            /*inserting initial records to the table. MAX = none*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                sql = "INSERT INTO buildings (`buildingName`) VALUES ('"+fin.nextLine()+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create buildings table");
            e.printStackTrace();
        }
    }

        public void makeRoomsTable(Statement stmt, String filePath)
    {
        try{
            /*making table*/
            String sql = "CREATE TABLE rooms " +
                   " (roomNumber INT not NULL," +
                   " buildingName VARCHAR(60) not NULL, FOREIGN KEY (buildingName) REFERENCES buildings(buildingName) On UPDATE CASCADE ON DELETE RESTRICT," +
                   " PRIMARY KEY ( roomNumber, buildingName))";

            stmt.executeUpdate(sql);
            System.out.println("rooms table created");
            /*inserting initial records to the table. MAX = none*/
            File fileIn = new File(filePath);
            Scanner fin = new Scanner(fileIn);
            while(fin.hasNext())
            {
                String[] line = fin.nextLine().split(",");
                sql = "INSERT INTO rooms (`roomNumber`, `buildingName` ) VALUES ("+line[0]+", '"+line[1]+"')";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e)
        {
            System.out.println("Could not create rooms table");
            e.printStackTrace();
        }
    }
}
