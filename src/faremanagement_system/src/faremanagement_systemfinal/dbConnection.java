/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faremanagement;

/**
 *
 * @author gtxnn
 */



import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class dbConnection {
    public static Connection connect(){
        Connection conn= null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            Component rootPane=null;            
            System.out.println("Connected");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            
    }
       return conn;

}
}
