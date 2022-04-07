package TOPUP.View;


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
