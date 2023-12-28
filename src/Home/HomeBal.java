/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;

import DBP.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author NSR.I
 */
public class HomeBal {
    
    public List<HomeBean> loadData(){
    List<HomeBean> list = new ArrayList<HomeBean> ();
    
    try{
        String query = "SELECT * FROM packages_tbl";
        
        PreparedStatement pst = DB.con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("id");
            String Pname = rs.getString("name");
            int price = Integer.parseInt(rs.getString("price"));
            int qty   = Integer.parseInt(rs.getString("qty"));
            
            HomeBean bean = new HomeBean(id ,Pname,price,qty);
            
            list.add(bean);
            
        
        }        
    }catch(Exception e){
    
    JOptionPane.showMessageDialog(null, "Erorr: "+e);
    }
        
        
    
        
    
        return list;
    }
    
    
    public static void add(HomeBean homebean){
        
        try{
            
            String query = "INSERT INTO packages_tbl VALUES (null , ?,?,?)";
            
            PreparedStatement pst = DB.con.prepareStatement(query);
            pst.setString(1, homebean.getPname());
            pst.setInt(2, homebean.getPrice());
            pst.setInt(3,homebean.getQty());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Record added Successfuly");
            
        
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error :"+e);
        
        }
    }
        
        public HomeBean ReturnAllDataToTable(int id){
        
            HomeBean bean = null;
            
            try{
            
                String query = "SELECT * FROM packages_tbl WHERE id ="+id+"";
                PreparedStatement ps = DB.con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    
                     int ids = rs.getInt("id");
                     String Pname = rs.getString("name");
                     int price = Integer.parseInt(rs.getString("price"));
                     int qty   = Integer.parseInt(rs.getString("qty"));
                     
             bean = new HomeBean(ids ,Pname,price,qty);
             
                    
                }
                
            }catch(Exception e){
            
                JOptionPane.showMessageDialog(null, ""+e);
            }
            
        
            return bean;
        }
        
        public HomeBean edit (HomeBean bean){
            
            try{
                
                String query = "UPDATE packages_tbl SET name = ? , price = ? , qty=? WHERE id=?";
                PreparedStatement ps = DB.con.prepareStatement(query);
                ps.setString(1, bean.getPname());
                ps.setInt(2,bean.getPrice());
                ps.setInt(3,bean.getQty());
                ps.setInt(4, bean.getId());
                ps.executeUpdate();
                
                JOptionPane.showConfirmDialog(null,"Do You Want to Update Record ?");
                
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null, "ERROR : "+e);
            }
            
        
            return bean ;
        }
        public void Delete(int id){
        
            try{
            String query = "DELETE FROM packages_tbl WHERE id = ?";
            PreparedStatement ps= DB.con.prepareStatement(query) ;
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null, "Do You Want TO Delete Record ?");
            }
            catch(Exception e){
            
                JOptionPane.showMessageDialog(null, "ERROR: "+e);
            }
            
            
        }
        
        
    }
    
    
    

