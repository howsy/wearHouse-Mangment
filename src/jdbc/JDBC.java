/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;


import DBP.DB;
import Login.LoginForm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Login.LoginForm;

public class JDBC {

   Connection con;
     void Connect() {
    
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/javacrudapp","root","");
    
    }
    catch(ClassNotFoundException ex){
    
     System.out.println(ex);
    }  catch (SQLException ex) {
           Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    public static void main(String[] args) {

        LoginForm S = new LoginForm();
        
        S.show();
        
        DB.LoadConnector();
        

    }
    
}
