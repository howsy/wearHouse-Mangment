package DBP;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.JDBC;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NSR.I
 */
public class DB {
    
    public static Connection con = null ;
    
    public static void LoadConnector() {
    
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/javacrudapp","root","");
        
        if(con !=null){
        JOptionPane.showMessageDialog(null,"DataBaseConnected Sucssesfuly");
        }
    
    }
    catch(ClassNotFoundException ex){
    
     System.out.println(ex);
    }  catch (Exception ex) {   
        
        JOptionPane.showMessageDialog(null, "Error : "+ex);
    
    }
        
    }
    
    }
    

