/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;


import DBP.DB;
import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author NSR.I
 */


public class Bal {

    public boolean checkLogin(String username , String password){
    boolean b = false;
     try {
            String query = "SELECT * FROM `users_tbl` WHERE `usename` = '"+username+"' AND `password` ='"+password+"'";
            Statement st = DB.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
            
            b = true;
            
            }else{
            
            JOptionPane.showMessageDialog(null, "Email Or Password is incorrect ..");
            }
            
           
            }
            
            
         catch (Exception ex) {
             
             JOptionPane.showMessageDialog(null, "ERORR :"+ex);
             
         }
     return b;
        
        
    
    }
    
    
}
