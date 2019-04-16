/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitysoftware;
import java.sql.*;
import java.util.ArrayList;
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
            System.out.println("getData query failed!");
            return null;
        }
    }
    
}
