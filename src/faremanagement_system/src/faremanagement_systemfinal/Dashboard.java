/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faremanagement_systemfinal;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class Dashboard extends javax.swing.JFrame {

    //init sql
    Connection conn = null; 
    PreparedStatement pst = null; 
  //
    public Dashboard() {
       initComponents();
        DisplayTableAccount();
        DisplayTableTransaction();
        DisplayTableMonthlySales();
        DisplayTableAdmin();
        DisplayTableCurrentPrediction();
        DisplayTableFuturePrediction();
        panel_home.setVisible(true);            
        panel_sales.setVisible(false);      
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
    }
    private void DisplayTableTransaction(){
        try{
            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM `transactiondb`";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_transaction.setModel(DbUtils.resultSetToTableModel(rs));            
            
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
 private void DisplayTableAccount(){
        try{            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM accountdb";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_accounts.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }
  private void DisplayTableAdmin(){
        try{            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM admindb";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_adminaccounts.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }
  private void DisplayTableMonthlySales(){
        try{            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM monthly_sales";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_monthlysales.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }
   private void DisplayTableCurrentPrediction(){
        try{            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM currentprediction";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_currentprediction.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }
    private void DisplayTableFuturePrediction(){
        try{            
             Class.forName("com.mysql.jdbc.Driver");       
             conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");   
             String sql = "SELECT * FROM futureprediction";            
             PreparedStatement pst = conn.prepareStatement(sql);           
             ResultSet rs = pst.executeQuery();          
             table_futurepredictionresult.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }
   void refreshPage(){
            Dashboard main = new Dashboard();    
            main.setVisible(true);
            this.dispose();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        panel_root = new javax.swing.JPanel();
        panel_side = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_sales = new javax.swing.JButton();
        btn_accounts = new javax.swing.JButton();
        btn_settings = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        panel_screen = new javax.swing.JPanel();
        panel_settings = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtfield_adminusername = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtfield_adminpassword = new javax.swing.JTextField();
        btn_addadmin = new javax.swing.JButton();
        btn_removeadmin = new javax.swing.JButton();
        btn_adminclear = new javax.swing.JButton();
        lbl_adminid = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_adminaccounts = new javax.swing.JTable();
        txtfield_settings_searchadmin = new javax.swing.JTextField();
        panel_home = new javax.swing.JPanel();
        home_banner = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panel_sales = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panel_monthlysale_screen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaction = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_prediction = new javax.swing.JButton();
        btn_monthlysales = new javax.swing.JButton();
        btn_futureprediction = new javax.swing.JButton();
        txtfield_searchtransaction = new javax.swing.JTextField();
        btn_transactionsearchclear = new javax.swing.JButton();
        panel_futureprediction = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_futurepredictionresult = new javax.swing.JTable();
        btn_showfutureprediction = new javax.swing.JButton();
        lbl_futureid = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_showfutureprediction = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        panel_monthlysales = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_monthlysales = new javax.swing.JTable();
        txtfield_searchmonthlysales = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtfield_monthlysales_sales = new javax.swing.JTextField();
        datechooser_month = new com.toedter.calendar.JDateChooser();
        btn_clearmonthlysalesfield = new javax.swing.JButton();
        btn_monthlysales_insert = new javax.swing.JButton();
        btn_monthlysales_update = new javax.swing.JButton();
        btn_exportascsv = new javax.swing.JButton();
        lbl_monthlysales_id = new javax.swing.JLabel();
        panel_prediction = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_currentprediction = new javax.swing.JTable();
        btn_showcurrentprediction = new javax.swing.JButton();
        lbl_showcurrentpredictionid = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_showcurrentprediction = new javax.swing.JLabel();
        panel_accounts = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtfield_accounts_username = new javax.swing.JTextField();
        txtfield_accounts_password = new javax.swing.JTextField();
        cbox_accounts_usertype = new javax.swing.JComboBox();
        cbox_accounts_location = new javax.swing.JComboBox();
        btn_adduser = new javax.swing.JButton();
        btn_removeuser = new javax.swing.JButton();
        btn_userupdate = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        lbl_userid = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtfield_accounts_searchuser = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_accounts = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));

        panel_root.setBackground(new java.awt.Color(51, 71, 86));
        panel_root.setMaximumSize(new java.awt.Dimension(1280, 720));
        panel_root.setMinimumSize(new java.awt.Dimension(1280, 720));
        panel_root.setPreferredSize(new java.awt.Dimension(1280, 720));
        panel_root.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_side.setBackground(new java.awt.Color(0, 0, 0));
        panel_side.setPreferredSize(new java.awt.Dimension(300, 720));

        btn_home.setBackground(new java.awt.Color(51, 71, 86));
        btn_home.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_home_30px_3.png"))); // NOI18N
        btn_home.setText("HOME");
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_sales.setBackground(new java.awt.Color(8, 32, 50));
        btn_sales.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btn_sales.setForeground(new java.awt.Color(255, 255, 255));
        btn_sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_total_sales_30px.png"))); // NOI18N
        btn_sales.setText("SALES");
        btn_sales.setBorder(null);
        btn_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salesActionPerformed(evt);
            }
        });

        btn_accounts.setBackground(new java.awt.Color(8, 32, 50));
        btn_accounts.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btn_accounts.setForeground(new java.awt.Color(255, 255, 255));
        btn_accounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_user_30px.png"))); // NOI18N
        btn_accounts.setText("ACCOUNTS");
        btn_accounts.setBorder(null);
        btn_accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accountsActionPerformed(evt);
            }
        });

        btn_settings.setBackground(new java.awt.Color(8, 32, 50));
        btn_settings.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btn_settings.setForeground(new java.awt.Color(255, 255, 255));
        btn_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_admin_settings_male_30px.png"))); // NOI18N
        btn_settings.setText("SETTINGS");
        btn_settings.setBorder(null);
        btn_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_settingsActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(8, 32, 50));
        btn_logout.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_Logout_30px_1.png"))); // NOI18N
        btn_logout.setText("LOG OUT");
        btn_logout.setBorder(null);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_sideLayout = new javax.swing.GroupLayout(panel_side);
        panel_side.setLayout(panel_sideLayout);
        panel_sideLayout.setHorizontalGroup(
            panel_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_sales, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(btn_accounts, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(btn_settings, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        panel_sideLayout.setVerticalGroup(
            panel_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_sideLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_accounts, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_settings, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        panel_root.add(panel_side, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        panel_screen.setBackground(new java.awt.Color(51, 71, 86));

        panel_settings.setBackground(new java.awt.Color(51, 71, 86));
        panel_settings.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_settings.setMinimumSize(new java.awt.Dimension(980, 720));

        jLabel33.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("USER SETTINGS");

        jPanel12.setBackground(new java.awt.Color(8, 32, 50));

        jLabel34.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Username:");

        txtfield_adminusername.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_adminusername.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_adminusername.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_adminusername.setBorder(null);

        jLabel35.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Password:");

        txtfield_adminpassword.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_adminpassword.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_adminpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_adminpassword.setBorder(null);

        btn_addadmin.setBackground(new java.awt.Color(8, 32, 50));
        btn_addadmin.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_addadmin.setForeground(new java.awt.Color(255, 255, 255));
        btn_addadmin.setText("Add Administrator");
        btn_addadmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_addadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadminActionPerformed(evt);
            }
        });

        btn_removeadmin.setBackground(new java.awt.Color(8, 32, 50));
        btn_removeadmin.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_removeadmin.setForeground(new java.awt.Color(255, 255, 255));
        btn_removeadmin.setText("Remove Administrator");
        btn_removeadmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_removeadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeadminActionPerformed(evt);
            }
        });

        btn_adminclear.setBackground(new java.awt.Color(8, 32, 50));
        btn_adminclear.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_adminclear.setForeground(new java.awt.Color(255, 255, 255));
        btn_adminclear.setText("Clear ");
        btn_adminclear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_adminclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_addadmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_removeadmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_adminclear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_adminid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtfield_adminpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtfield_adminusername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_adminid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btn_addadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_removeadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_adminclear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfield_adminusername, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfield_adminpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(439, Short.MAX_VALUE)))
        );

        jPanel13.setBackground(new java.awt.Color(8, 32, 50));

        table_adminaccounts.setBackground(new java.awt.Color(51, 71, 86));
        table_adminaccounts.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        table_adminaccounts.setForeground(new java.awt.Color(255, 255, 255));
        table_adminaccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_adminaccounts.setGridColor(new java.awt.Color(255, 255, 255));
        table_adminaccounts.setSelectionBackground(new java.awt.Color(240, 165, 0));
        table_adminaccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_adminaccountsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_adminaccounts);

        txtfield_settings_searchadmin.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_settings_searchadmin.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_settings_searchadmin.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_settings_searchadmin.setBorder(null);
        txtfield_settings_searchadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_settings_searchadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(txtfield_settings_searchadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtfield_settings_searchadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panel_settingsLayout = new javax.swing.GroupLayout(panel_settings);
        panel_settings.setLayout(panel_settingsLayout);
        panel_settingsLayout.setHorizontalGroup(
            panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_settingsLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel_settingsLayout.setVerticalGroup(
            panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_home.setBackground(new java.awt.Color(51, 71, 86));
        panel_home.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_home.setMinimumSize(new java.awt.Dimension(980, 720));

        home_banner.setBackground(new java.awt.Color(240, 165, 0));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 42)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(8, 32, 50));
        jLabel3.setText("Fare Management System");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("sales prediction of the company with the use of");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("a system where you can manage the Top-up accounts ");

        jLabel5.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("and can outlook the monthly sales as well as the future");

        jLabel6.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seasonal Autoregressive Integrated Moving Average Algorithm");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/banner.png"))); // NOI18N

        javax.swing.GroupLayout home_bannerLayout = new javax.swing.GroupLayout(home_banner);
        home_banner.setLayout(home_bannerLayout);
        home_bannerLayout.setHorizontalGroup(
            home_bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_bannerLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(home_bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        home_bannerLayout.setVerticalGroup(
            home_bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_bannerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_bannerLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD");

        jPanel1.setBackground(new java.awt.Color(8, 32, 50));

        jLabel8.setFont(new java.awt.Font("Serif", 0, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EzPay Contactless Payment");

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EFFICIENT");

        jLabel10.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CONVENIENT");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ACCURATE");

        jLabel12.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CASHLESS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_homeLayout = new javax.swing.GroupLayout(panel_home);
        panel_home.setLayout(panel_homeLayout);
        panel_homeLayout.setHorizontalGroup(
            panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home_banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 93, Short.MAX_VALUE))
        );
        panel_homeLayout.setVerticalGroup(
            panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_homeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home_banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        panel_sales.setBackground(new java.awt.Color(51, 71, 86));
        panel_sales.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_sales.setMinimumSize(new java.awt.Dimension(980, 720));
        panel_sales.setPreferredSize(new java.awt.Dimension(980, 720));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TRANSACTIONS");

        panel_monthlysale_screen.setBackground(new java.awt.Color(8, 32, 50));

        table_transaction.setBackground(new java.awt.Color(51, 71, 86));
        table_transaction.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        table_transaction.setForeground(new java.awt.Color(255, 255, 255));
        table_transaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_transaction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_transaction.setGridColor(new java.awt.Color(255, 255, 255));
        table_transaction.setSelectionBackground(new java.awt.Color(240, 165, 0));
        jScrollPane1.setViewportView(table_transaction);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btn_prediction.setBackground(new java.awt.Color(8, 32, 50));
        btn_prediction.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        btn_prediction.setForeground(new java.awt.Color(255, 255, 255));
        btn_prediction.setText("Prediction");
        btn_prediction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_prediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_predictionActionPerformed(evt);
            }
        });

        btn_monthlysales.setBackground(new java.awt.Color(8, 32, 50));
        btn_monthlysales.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_monthlysales.setForeground(new java.awt.Color(255, 255, 255));
        btn_monthlysales.setText("Monthly Sales");
        btn_monthlysales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_monthlysales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monthlysalesActionPerformed(evt);
            }
        });

        btn_futureprediction.setBackground(new java.awt.Color(8, 32, 50));
        btn_futureprediction.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        btn_futureprediction.setForeground(new java.awt.Color(255, 255, 255));
        btn_futureprediction.setText("Future Prediction");
        btn_futureprediction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_futureprediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_futurepredictionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btn_monthlysales, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btn_futureprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btn_prediction, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_monthlysales, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_futureprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prediction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout panel_monthlysale_screenLayout = new javax.swing.GroupLayout(panel_monthlysale_screen);
        panel_monthlysale_screen.setLayout(panel_monthlysale_screenLayout);
        panel_monthlysale_screenLayout.setHorizontalGroup(
            panel_monthlysale_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_monthlysale_screenLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_monthlysale_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_monthlysale_screenLayout.setVerticalGroup(
            panel_monthlysale_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_monthlysale_screenLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtfield_searchtransaction.setBackground(new java.awt.Color(8, 32, 50));
        txtfield_searchtransaction.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_searchtransaction.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_searchtransaction.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtfield_searchtransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_searchtransactionActionPerformed(evt);
            }
        });

        btn_transactionsearchclear.setBackground(new java.awt.Color(0, 0, 0));
        btn_transactionsearchclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faremanagement_systemfinal/icons/icons8_multiply_50px_1.png"))); // NOI18N
        btn_transactionsearchclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transactionsearchclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_salesLayout = new javax.swing.GroupLayout(panel_sales);
        panel_sales.setLayout(panel_salesLayout);
        panel_salesLayout.setHorizontalGroup(
            panel_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_salesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btn_transactionsearchclear)
                .addGap(6, 6, 6)
                .addComponent(txtfield_searchtransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(panel_salesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_monthlysale_screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_salesLayout.setVerticalGroup(
            panel_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_salesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_salesLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_transactionsearchclear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_salesLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtfield_searchtransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_monthlysale_screen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );

        panel_futureprediction.setBackground(new java.awt.Color(51, 71, 86));
        panel_futureprediction.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_futureprediction.setMinimumSize(new java.awt.Dimension(980, 720));
        panel_futureprediction.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel9.setBackground(new java.awt.Color(8, 32, 50));

        table_futurepredictionresult.setBackground(new java.awt.Color(51, 71, 86));
        table_futurepredictionresult.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        table_futurepredictionresult.setForeground(new java.awt.Color(255, 255, 255));
        table_futurepredictionresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_futurepredictionresult.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        table_futurepredictionresult.setGridColor(new java.awt.Color(255, 255, 255));
        table_futurepredictionresult.setSelectionBackground(new java.awt.Color(240, 165, 0));
        table_futurepredictionresult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_futurepredictionresultMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_futurepredictionresult);

        btn_showfutureprediction.setBackground(new java.awt.Color(8, 32, 50));
        btn_showfutureprediction.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_showfutureprediction.setText("SHOW");
        btn_showfutureprediction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_showfutureprediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showfuturepredictionActionPerformed(evt);
            }
        });

        lbl_futureid.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(btn_showfutureprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_futureid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_showfutureprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_futureid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(8, 32, 50));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showfutureprediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showfutureprediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(8, 32, 50));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("FUTURE PREDICTION");

        jLabel20.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("a visual representation of ");

        jLabel21.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("estimate revenue by predicting");

        jLabel19.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("the amount of sales that");

        jLabel37.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("the company will gain in the");

        jLabel36.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("years ahead");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_futurepredictionLayout = new javax.swing.GroupLayout(panel_futureprediction);
        panel_futureprediction.setLayout(panel_futurepredictionLayout);
        panel_futurepredictionLayout.setHorizontalGroup(
            panel_futurepredictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_futurepredictionLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_futurepredictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_futurepredictionLayout.setVerticalGroup(
            panel_futurepredictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_futurepredictionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_futurepredictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_futurepredictionLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_monthlysales.setBackground(new java.awt.Color(51, 71, 86));
        panel_monthlysales.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_monthlysales.setMinimumSize(new java.awt.Dimension(980, 720));
        panel_monthlysales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("MONTHLY SALES");
        panel_monthlysales.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 195, 343, 71));

        jPanel3.setBackground(new java.awt.Color(8, 32, 50));

        table_monthlysales.setBackground(new java.awt.Color(51, 71, 86));
        table_monthlysales.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        table_monthlysales.setForeground(new java.awt.Color(255, 255, 255));
        table_monthlysales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_monthlysales.setGridColor(new java.awt.Color(255, 255, 255));
        table_monthlysales.setSelectionBackground(new java.awt.Color(240, 165, 0));
        table_monthlysales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_monthlysalesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_monthlysales);

        txtfield_searchmonthlysales.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_searchmonthlysales.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_searchmonthlysales.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_searchmonthlysales.setBorder(null);
        txtfield_searchmonthlysales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_searchmonthlysalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfield_searchmonthlysales, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtfield_searchmonthlysales, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panel_monthlysales.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 29, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel25.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DATE:");

        jLabel26.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("SALES:");

        txtfield_monthlysales_sales.setBackground(new java.awt.Color(8, 32, 50));
        txtfield_monthlysales_sales.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtfield_monthlysales_sales.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_monthlysales_sales.setBorder(null);

        datechooser_month.setBackground(new java.awt.Color(8, 32, 50));

        btn_clearmonthlysalesfield.setBackground(new java.awt.Color(8, 32, 50));
        btn_clearmonthlysalesfield.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_clearmonthlysalesfield.setForeground(new java.awt.Color(255, 255, 255));
        btn_clearmonthlysalesfield.setText("CLEAR");
        btn_clearmonthlysalesfield.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_clearmonthlysalesfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearmonthlysalesfieldActionPerformed(evt);
            }
        });

        btn_monthlysales_insert.setBackground(new java.awt.Color(8, 32, 50));
        btn_monthlysales_insert.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_monthlysales_insert.setForeground(new java.awt.Color(255, 255, 255));
        btn_monthlysales_insert.setText("INSERT");
        btn_monthlysales_insert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_monthlysales_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monthlysales_insertActionPerformed(evt);
            }
        });

        btn_monthlysales_update.setBackground(new java.awt.Color(8, 32, 50));
        btn_monthlysales_update.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_monthlysales_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_monthlysales_update.setText("UPDATE");
        btn_monthlysales_update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_monthlysales_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monthlysales_updateActionPerformed(evt);
            }
        });

        btn_exportascsv.setBackground(new java.awt.Color(8, 32, 50));
        btn_exportascsv.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_exportascsv.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportascsv.setText("EXPORT");
        btn_exportascsv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_exportascsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportascsvActionPerformed(evt);
            }
        });

        lbl_monthlysales_id.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfield_monthlysales_sales, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datechooser_month, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addGap(11, 11, 11))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_monthlysales_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportascsv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_monthlysales_update, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btn_clearmonthlysalesfield, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_monthlysales_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfield_monthlysales_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datechooser_month, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btn_monthlysales_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btn_monthlysales_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exportascsv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clearmonthlysalesfield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_monthlysales_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        panel_monthlysales.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 284, -1, -1));

        panel_prediction.setBackground(new java.awt.Color(51, 71, 86));
        panel_prediction.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_prediction.setMinimumSize(new java.awt.Dimension(980, 720));
        panel_prediction.setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel14.setBackground(new java.awt.Color(8, 32, 50));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SALES PREDICTION");

        jLabel15.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("a visual representation  ");

        jLabel16.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("of how close or accurate");

        jLabel14.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("is the prediction to the");

        jLabel22.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("actual sales");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(8, 32, 50));

        table_currentprediction.setBackground(new java.awt.Color(51, 71, 86));
        table_currentprediction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table_currentprediction.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        table_currentprediction.setForeground(new java.awt.Color(255, 255, 255));
        table_currentprediction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_currentprediction.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        table_currentprediction.setGridColor(new java.awt.Color(255, 255, 255));
        table_currentprediction.setSelectionBackground(new java.awt.Color(240, 165, 0));
        table_currentprediction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_currentpredictionMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_currentprediction);

        btn_showcurrentprediction.setBackground(new java.awt.Color(8, 32, 50));
        btn_showcurrentprediction.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_showcurrentprediction.setText("SHOW");
        btn_showcurrentprediction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_showcurrentprediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showcurrentpredictionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btn_showcurrentprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_showcurrentpredictionid, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_showcurrentprediction, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_showcurrentpredictionid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(8, 32, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showcurrentprediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showcurrentprediction, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_predictionLayout = new javax.swing.GroupLayout(panel_prediction);
        panel_prediction.setLayout(panel_predictionLayout);
        panel_predictionLayout.setHorizontalGroup(
            panel_predictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel_predictionLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_predictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_predictionLayout.setVerticalGroup(
            panel_predictionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_predictionLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_accounts.setBackground(new java.awt.Color(51, 71, 86));
        panel_accounts.setMaximumSize(new java.awt.Dimension(980, 720));
        panel_accounts.setMinimumSize(new java.awt.Dimension(980, 720));
        panel_accounts.setPreferredSize(new java.awt.Dimension(980, 720));

        jLabel27.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("TOP-UP ACCOUNTS");

        jPanel10.setBackground(new java.awt.Color(8, 32, 50));

        jLabel28.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Account Details:");

        jLabel29.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Password:");

        jLabel30.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Location:");

        jLabel31.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Username:");

        jLabel32.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Usertype:");

        txtfield_accounts_username.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_accounts_username.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_accounts_username.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_accounts_username.setBorder(null);

        txtfield_accounts_password.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_accounts_password.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_accounts_password.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_accounts_password.setBorder(null);

        cbox_accounts_usertype.setBackground(new java.awt.Color(51, 71, 86));
        cbox_accounts_usertype.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        cbox_accounts_usertype.setForeground(new java.awt.Color(255, 255, 255));
        cbox_accounts_usertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cashier", "Manager" }));
        cbox_accounts_usertype.setBorder(null);

        cbox_accounts_location.setBackground(new java.awt.Color(51, 71, 86));
        cbox_accounts_location.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        cbox_accounts_location.setForeground(new java.awt.Color(255, 255, 255));
        cbox_accounts_location.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tagbac", "Passi", "Molo", "Mohon" }));
        cbox_accounts_location.setBorder(null);

        btn_adduser.setBackground(new java.awt.Color(8, 32, 50));
        btn_adduser.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_adduser.setForeground(new java.awt.Color(255, 255, 255));
        btn_adduser.setText("Add User");
        btn_adduser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adduserActionPerformed(evt);
            }
        });

        btn_removeuser.setBackground(new java.awt.Color(8, 32, 50));
        btn_removeuser.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_removeuser.setForeground(new java.awt.Color(255, 255, 255));
        btn_removeuser.setText("Remove User");
        btn_removeuser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_removeuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeuserActionPerformed(evt);
            }
        });

        btn_userupdate.setBackground(new java.awt.Color(8, 32, 50));
        btn_userupdate.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_userupdate.setForeground(new java.awt.Color(255, 255, 255));
        btn_userupdate.setText("Update User");
        btn_userupdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_userupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userupdateActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(8, 32, 50));
        btn_clear.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear ");
        btn_clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbox_accounts_usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_userupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_removeuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_adduser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbox_accounts_location, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfield_accounts_password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfield_accounts_username, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfield_accounts_username, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfield_accounts_password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(cbox_accounts_usertype))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_accounts_location, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btn_adduser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_removeuser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btn_userupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(8, 32, 50));

        txtfield_accounts_searchuser.setBackground(new java.awt.Color(51, 71, 86));
        txtfield_accounts_searchuser.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        txtfield_accounts_searchuser.setForeground(new java.awt.Color(255, 255, 255));
        txtfield_accounts_searchuser.setBorder(null);
        txtfield_accounts_searchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_accounts_searchuserActionPerformed(evt);
            }
        });

        table_accounts.setBackground(new java.awt.Color(51, 71, 86));
        table_accounts.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table_accounts.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        table_accounts.setForeground(new java.awt.Color(255, 255, 255));
        table_accounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_accounts.setGridColor(new java.awt.Color(255, 255, 255));
        table_accounts.setSelectionBackground(new java.awt.Color(240, 165, 0));
        table_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_accountsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_accounts);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfield_accounts_searchuser)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtfield_accounts_searchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_accountsLayout = new javax.swing.GroupLayout(panel_accounts);
        panel_accounts.setLayout(panel_accountsLayout);
        panel_accountsLayout.setHorizontalGroup(
            panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_accountsLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_accountsLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_accountsLayout.setVerticalGroup(
            panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_screenLayout = new javax.swing.GroupLayout(panel_screen);
        panel_screen.setLayout(panel_screenLayout);
        panel_screenLayout.setHorizontalGroup(
            panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_prediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_monthlysales, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_futureprediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_accounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_screenLayout.createSequentialGroup()
                    .addComponent(panel_settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_screenLayout.setVerticalGroup(
            panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_prediction, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_screenLayout.createSequentialGroup()
                    .addComponent(panel_monthlysales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE)))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_futureprediction, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_accounts, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_sales, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_screenLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panel_root.add(panel_screen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        panel_home.setVisible(true);            
        panel_sales.setVisible(false);      
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
        btn_home.setBackground(new Color(51,71,86));
        btn_sales.setBackground(new Color(8,32,50));
        btn_monthlysales.setBackground(new Color(8,32,50));
        btn_prediction.setBackground(new Color(8,32,50));
        btn_futureprediction.setBackground(new Color(8,32,50));
        btn_accounts.setBackground(new Color(8,32,50));
        btn_settings.setBackground(new Color(8,32,50));
        
        
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_addadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadminActionPerformed
         //SHA-256 algorithm
        //password
            MessageDigest messageDigest = null;
           try {
               messageDigest = MessageDigest.getInstance("SHA-256");
           } catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
           }
            messageDigest.update(txtfield_adminpassword.getText().getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder user = new StringBuilder();
            for(byte b: resultByteArray){
                user.append(String.format("%02x", b));
            }    
           String hashedpw = user.toString();

      //check if button is enabled and show comfirmation
      if(btn_adduser.isEnabled()){
            int n = JOptionPane.showConfirmDialog(null, "Confirm?", "", JOptionPane.YES_NO_OPTION);       
            //check choices
                if(n == JOptionPane.YES_OPTION){ 
                    //insert to monthlysales db in cloud
                        try{
                         Class.forName("com.mysql.jdbc.Driver"); 
                          String sql = "insert into admindb(username, password) values(?, ?)"; 
                          Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");    
                          PreparedStatement pst = conn.prepareStatement(sql);  
                          //query
                          pst.setString(1, txtfield_adminusername.getText());
                          pst.setString(2, hashedpw);                         
                          JOptionPane.showMessageDialog(this, "Administrator Added Successfuly");
                          pst.executeUpdate();
                          conn.close();
                          DisplayTableAdmin();                          
                          txtfield_adminusername.setText(""); 
                          txtfield_accounts_password.setText("");
                          
                          }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                          }
                }//check choice
                }   
    }//GEN-LAST:event_btn_addadminActionPerformed

    private void btn_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salesActionPerformed
       panel_home.setVisible(false);            
        panel_sales.setVisible(true);      
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
        
        btn_home.setBackground(new Color(8,32,50));
        btn_sales.setBackground(new Color(51,71,86));
        btn_monthlysales.setBackground(new Color(8,32,50));
        btn_prediction.setBackground(new Color(8,32,50));
        btn_futureprediction.setBackground(new Color(8,32,50));
        btn_accounts.setBackground(new Color(8,32,50));
        btn_settings.setBackground(new Color(8,32,50));
    }//GEN-LAST:event_btn_salesActionPerformed

    private void btn_accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accountsActionPerformed
       panel_home.setVisible(false);            
        panel_sales.setVisible(false);      
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(true);
        panel_settings.setVisible(false);
        
        btn_home.setBackground(new Color(8,32,50));
        btn_sales.setBackground(new Color(8,32,50));
        btn_monthlysales.setBackground(new Color(8,32,50));
        btn_prediction.setBackground(new Color(8,32,50));
        btn_futureprediction.setBackground(new Color(8,32,50));
        btn_accounts.setBackground(new Color(51,71,86));
        btn_settings.setBackground(new Color(8,32,50));
    }//GEN-LAST:event_btn_accountsActionPerformed

    private void btn_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_settingsActionPerformed
         panel_home.setVisible(false);            
        panel_sales.setVisible(false);      
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(true);
        
        btn_home.setBackground(new Color(8,32,50));
        btn_sales.setBackground(new Color(8,32,50));
        btn_monthlysales.setBackground(new Color(8,32,50));
        btn_prediction.setBackground(new Color(8,32,50));
        btn_futureprediction.setBackground(new Color(8,32,50));
        btn_accounts.setBackground(new Color(8,32,50));
        btn_settings.setBackground(new Color(51,71,86));
    }//GEN-LAST:event_btn_settingsActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        if(btn_logout.isEnabled()){
        int n = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "", JOptionPane.YES_NO_OPTION);           
       if(n == JOptionPane.YES_OPTION){
            Login jump = new Login();
            jump.setVisible(true);
              dispose();
       }else{
           Dashboard jump = new Dashboard();
           jump.setVisible(true);
          
       }        
    }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_transactionsearchclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transactionsearchclearActionPerformed
       DisplayTableTransaction();
        txtfield_searchtransaction.setText("");
    }//GEN-LAST:event_btn_transactionsearchclearActionPerformed

    private void txtfield_searchtransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_searchtransactionActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select transaction_id, mobile_num, value, date, cashier, terminal_name from transactiondb where mobile_num=?";
            Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtfield_searchtransaction.getText());
            ResultSet rs = pst.executeQuery();
            table_transaction.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }     
    }//GEN-LAST:event_txtfield_searchtransactionActionPerformed

    private void btn_monthlysalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monthlysalesActionPerformed
        panel_home.setVisible(false);
        panel_sales.setVisible(false);
        panel_monthlysales.setVisible(true);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
    }//GEN-LAST:event_btn_monthlysalesActionPerformed

    private void btn_futurepredictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_futurepredictionActionPerformed
        panel_home.setVisible(false);
        panel_sales.setVisible(false);
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(false);
        panel_futureprediction.setVisible(true);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
    }//GEN-LAST:event_btn_futurepredictionActionPerformed

    private void btn_predictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_predictionActionPerformed
        panel_home.setVisible(false);
        panel_sales.setVisible(false);
        panel_monthlysales.setVisible(false);
        panel_prediction.setVisible(true);
        panel_futureprediction.setVisible(false);
        panel_accounts.setVisible(false);
        panel_settings.setVisible(false);
    }//GEN-LAST:event_btn_predictionActionPerformed

    private void txtfield_searchmonthlysalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_searchmonthlysalesActionPerformed
       try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select id, date, sales  from monthly_sales where date=?";
            Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtfield_searchmonthlysales.getText());
            ResultSet rs = pst.executeQuery();
            table_monthlysales.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }     
    }//GEN-LAST:event_txtfield_searchmonthlysalesActionPerformed

    private void btn_monthlysales_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monthlysales_insertActionPerformed
         //check if button is enabled and show comfirmation
      if(btn_monthlysales_insert.isEnabled()){
            int n = JOptionPane.showConfirmDialog(null, "Confirm?", "", JOptionPane.YES_NO_OPTION);       
            //check choices
                if(n == JOptionPane.YES_OPTION){ 
                    //insert to monthlysales db in cloud
                        try{
                         Class.forName("com.mysql.jdbc.Driver"); 
                          String sql = "insert into monthly_sales(date,sales) values(?, ?)"; 
                          Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");    
                          PreparedStatement pst = conn.prepareStatement(sql);  
                          //format date
                          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                          String date = formatter.format(datechooser_month.getDate());                          
                          pst.setString(1, date);                             
                          pst.setFloat(2, Float.parseFloat(txtfield_monthlysales_sales.getText()));
                          JOptionPane.showMessageDialog(this, "Inserted Successfuly");
                          pst.executeUpdate();
                          conn.close();
                          DisplayTableMonthlySales();
                          datechooser_month.setCalendar(null);
                          txtfield_monthlysales_sales.setText("");                          
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                }//check choice
                }   
    }//GEN-LAST:event_btn_monthlysales_insertActionPerformed

    private void btn_monthlysales_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monthlysales_updateActionPerformed
         if(btn_monthlysales_update.isEnabled()){
            int n = JOptionPane.showConfirmDialog(null, "Confirm Update?", "", JOptionPane.YES_NO_OPTION);       
            //check choices
                if(n == JOptionPane.YES_OPTION){ 
                    //update record to monthlysales db in cloud
                        try{
                         Class.forName("com.mysql.jdbc.Driver"); 
                      
                          String sql = "UPDATE monthly_sales SET date=?, sales=? where id=?"; 
                          Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");    
                          PreparedStatement pst = conn.prepareStatement(sql);   
                          //format date
                           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                          String date = formatter.format(datechooser_month.getDate()); 
                          pst.setString(1, date);                            
                          pst.setFloat(2, Float.parseFloat(txtfield_monthlysales_sales.getText()));
                          pst.setInt(3, Integer.parseInt(lbl_monthlysales_id.getText()));
                          JOptionPane.showMessageDialog(this, "Updated Successfuly");
                          pst.executeUpdate();
                          conn.close();
                          //reset table automatically
                          DefaultTableModel model = (DefaultTableModel)table_monthlysales.getModel();
                          model.setRowCount(0);
                          DisplayTableMonthlySales();
                          //clear fields after input
                          lbl_monthlysales_id.setText("");
                          datechooser_month.setCalendar(null);
                          txtfield_monthlysales_sales.setText("");                          
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                }//check choice
                }   
    }//GEN-LAST:event_btn_monthlysales_updateActionPerformed

    private void btn_exportascsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportascsvActionPerformed
        JFileChooser filechooser = new JFileChooser();
       filechooser.setDialogTitle("Specify a file save");
       int userselect = filechooser.showSaveDialog(this);
       if(userselect == JFileChooser.APPROVE_OPTION){
           File savefile = filechooser.getSelectedFile();            
           try {
               FileWriter fw = new FileWriter(savefile);
               BufferedWriter bw = new BufferedWriter(fw);
               for(int i = 0; i < table_monthlysales.getRowCount();i++){
                   for(int j = 0; j<table_monthlysales.getColumnCount();j++){
                       //write file
                       bw.write(table_monthlysales.getValueAt(i, j).toString()+ ",");
                   }
                   bw.newLine();//record per line
                   
                   }
                       JOptionPane.showMessageDialog(this,"SUCCESS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                       bw.close();
                       fw.close();
               
           } catch (IOException ex) {
              JOptionPane.showMessageDialog(this,"ERROR", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
           }
           
           
               
        
    }
    }//GEN-LAST:event_btn_exportascsvActionPerformed

    private void btn_clearmonthlysalesfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearmonthlysalesfieldActionPerformed
        DisplayTableMonthlySales();      
        lbl_monthlysales_id.setText("");
        datechooser_month.setCalendar(null);
        txtfield_monthlysales_sales.setText("");   
        txtfield_searchmonthlysales.setText("");
    }//GEN-LAST:event_btn_clearmonthlysalesfieldActionPerformed

    private void btn_removeadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeadminActionPerformed
       if(btn_removeadmin.isEnabled()){ 
       int n = JOptionPane.showConfirmDialog(null, "Delete Administrator?", "", JOptionPane.YES_NO_OPTION);           
       if(n == JOptionPane.YES_OPTION){
           try{                    
            Class.forName("com.mysql.jdbc.Driver");         
            String query = "delete from admindb where username=?";           
            conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(query);  
            pst.setString(1, txtfield_adminusername.getText());
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Deleted");
            DisplayTableAdmin();                          
            txtfield_adminusername.setText(""); 
            txtfield_accounts_password.setText("");
            
            pst.close();       
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       }
       }    
    }//GEN-LAST:event_btn_removeadminActionPerformed

    private void btn_adminclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminclearActionPerformed
       DisplayTableAdmin();                          
       txtfield_adminusername.setText(""); 
       txtfield_accounts_password.setText("");
       txtfield_settings_searchadmin.setText("");
    }//GEN-LAST:event_btn_adminclearActionPerformed

    private void txtfield_settings_searchadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_settings_searchadminActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select id, username, password  from admindb where username=?";
            Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtfield_settings_searchadmin.getText());
            ResultSet rs = pst.executeQuery();
            table_adminaccounts.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }      
    }//GEN-LAST:event_txtfield_settings_searchadminActionPerformed

    private void btn_showfuturepredictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showfuturepredictionActionPerformed
        Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;            
            InputStream input = null;
            FileOutputStream output = null;
            String id = lbl_futureid.getText();
        try {  
            //dbconnection
            conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            //statement
            stmt = conn.createStatement();
            String sql = "SELECT * from futureprediction where id="+id;
            rs = stmt.executeQuery(sql);
            
            //handle the file
            File getfile = new File("futureprediction"+id+".jpeg");
            output= new FileOutputStream(getfile);
            if(rs.next()){
                input = rs.getBinaryStream("image");
                
                byte[] buffer = new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
                System.out.println("Saved to file: " + getfile.getAbsolutePath());
                System.out.println("save successfully");
                lbl_showfutureprediction.setIcon(new ImageIcon(getfile.getAbsolutePath()));
            }
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(output !=null){
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_showfuturepredictionActionPerformed

    private void table_futurepredictionresultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_futurepredictionresultMouseClicked
 int i = table_futurepredictionresult.getSelectedRow();
        TableModel model = table_futurepredictionresult.getModel();
        String id = model.getValueAt(i, 0).toString();
        lbl_futureid.setText(id);
        
    
    }//GEN-LAST:event_table_futurepredictionresultMouseClicked

    private void table_currentpredictionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_currentpredictionMouseClicked
       int i = table_currentprediction.getSelectedRow();
        TableModel model = table_currentprediction.getModel();
        String id = model.getValueAt(i, 0).toString();
        lbl_showcurrentpredictionid.setText(id);
        
    }//GEN-LAST:event_table_currentpredictionMouseClicked

    private void btn_showcurrentpredictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showcurrentpredictionActionPerformed
           Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;            
            InputStream input = null;
            FileOutputStream output = null;
            String id = lbl_showcurrentpredictionid.getText();
        try {  
            //dbconnection
            conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151:3306/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            //statement
            stmt = conn.createStatement();
            String sql = "SELECT * from currentprediction where id="+id;
            rs = stmt.executeQuery(sql);
            
            //handle the file
            File getfile = new File("currentprediction"+id+".jpeg");
            output= new FileOutputStream(getfile);
            if(rs.next()){
                input = rs.getBinaryStream("image");
                
                byte[] buffer = new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
                System.out.println("Saved to file: " + getfile.getAbsolutePath());
                System.out.println("save successfully");
               lbl_showcurrentprediction.setIcon(new ImageIcon(getfile.getAbsolutePath()));
            }
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(output !=null){
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }//GEN-LAST:event_btn_showcurrentpredictionActionPerformed

    private void table_monthlysalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_monthlysalesMouseClicked
       //once row is selected set text to the fields for crud
       
        try {
             int i = table_monthlysales.getSelectedRow();    
             TableModel model = table_monthlysales.getModel();     
             lbl_monthlysales_id.setText(model.getValueAt(i, 0).toString());
             Date date;
            date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 1).toString());
            datechooser_month.setDate(date);
            txtfield_monthlysales_sales.setText(model.getValueAt(i, 2).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_monthlysalesMouseClicked

    private void table_accountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_accountsMouseClicked
        //once row is selected set text to the fields for crud
        int i = table_accounts.getSelectedRow();
        TableModel model = table_accounts.getModel();
        lbl_userid.setText(model.getValueAt(i, 0).toString());
        txtfield_accounts_username.setText(model.getValueAt(i, 1).toString());
        txtfield_accounts_password.setText(model.getValueAt(i, 2).toString());
        String location = model.getValueAt(i, 3).toString();
        switch(location){
            case "Tagbac":
                cbox_accounts_location.setSelectedIndex(0);
                break;
            case "Passi":
                cbox_accounts_location.setSelectedIndex(1);
                break;
            case "Molo":
               cbox_accounts_location.setSelectedIndex(2);
                break;
            case "Mohon":
               cbox_accounts_location.setSelectedIndex(3);
                break;
        }
        String user_type = model.getValueAt(i, 4).toString();
        switch(user_type){
            case "Cashier":
                cbox_accounts_usertype.setSelectedIndex(0);
                break;
            case "Manager":
                cbox_accounts_usertype.setSelectedIndex(1);
                break;
        }
    }//GEN-LAST:event_table_accountsMouseClicked

    private void txtfield_accounts_searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_accounts_searchuserActionPerformed
    try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select user_id, user, password, location, usertype from accountdb where user=?";
            Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtfield_accounts_searchuser.getText());
            ResultSet rs = pst.executeQuery();
            table_accounts.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }   
    }//GEN-LAST:event_txtfield_accounts_searchuserActionPerformed

    private void btn_removeuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeuserActionPerformed
       if(btn_removeuser.isEnabled()){ 
       int n = JOptionPane.showConfirmDialog(null, "Delete User?", "", JOptionPane.YES_NO_OPTION);           
       if(n == JOptionPane.YES_OPTION){
           try{                    
            Class.forName("com.mysql.jdbc.Driver");         
            String query = "delete from accountdb where user=?";           
            conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");
            PreparedStatement pst = conn.prepareStatement(query);  
            pst.setString(1, txtfield_accounts_username.getText());
            pst.execute(); 
            JOptionPane.showMessageDialog(null,"Deleted");
            DisplayTableAccount();                          
            txtfield_accounts_username.setText(""); 
            txtfield_accounts_password.setText("");            
            pst.close();       
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       }
       }  
    }//GEN-LAST:event_btn_removeuserActionPerformed

    private void table_adminaccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_adminaccountsMouseClicked
         int i = table_adminaccounts.getSelectedRow();
        TableModel model = table_adminaccounts.getModel();
        String id = model.getValueAt(i, 0).toString();
        String adminusername = model.getValueAt(i, 1).toString();
        String adminpass = model.getValueAt(i, 2).toString();
        lbl_adminid.setText(id);
        txtfield_adminusername.setText(adminusername);
        txtfield_adminpassword.setText(adminpass);
        
    }//GEN-LAST:event_table_adminaccountsMouseClicked

    private void btn_adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adduserActionPerformed
           //SHA-256 algorithm
        //password
            MessageDigest messageDigest = null;
           try {
               messageDigest = MessageDigest.getInstance("SHA-256");
           } catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
           }
            messageDigest.update(txtfield_accounts_password.getText().getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder user = new StringBuilder();
            for(byte b: resultByteArray){
                user.append(String.format("%02x", b));
            }    
           String hashedpw = user.toString();

      //check if button is enabled and show comfirmation
      if(btn_adduser.isEnabled()){
            int n = JOptionPane.showConfirmDialog(null, "Confirm?", "", JOptionPane.YES_NO_OPTION);       
            //check choices
                if(n == JOptionPane.YES_OPTION){ 
                    //insert to monthlysales db in cloud
                        try{
                         Class.forName("com.mysql.jdbc.Driver"); 
                          String sql = "insert into accountdb(user, password, location, usertype) values(?, ? ,? ,?)"; 
                          Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");    
                          PreparedStatement pst = conn.prepareStatement(sql);  
                          //query
                          pst.setString(1, txtfield_accounts_username.getText());
                          pst.setString(2, hashedpw);    
                          String userlocation = (String)cbox_accounts_location.getSelectedItem();
                          String usertype = (String)cbox_accounts_usertype.getSelectedItem();
                          pst.setString(3, userlocation);
                          pst.setString(4, usertype);
                          JOptionPane.showMessageDialog(this, "Account Added Successfuly");
                          pst.executeUpdate();
                          conn.close();
                          DisplayTableAccount();                          
                          txtfield_adminusername.setText(""); 
                          txtfield_accounts_password.setText("");
                          
                          }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                          }
                }//check choice
                }   
    }//GEN-LAST:event_btn_adduserActionPerformed

    private void btn_userupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userupdateActionPerformed
          //SHA-256 algorithm
        //password
            MessageDigest messageDigest = null;
           try {
               messageDigest = MessageDigest.getInstance("SHA-256");
           } catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
           }
            messageDigest.update(txtfield_accounts_password.getText().getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder user = new StringBuilder();
            for(byte b: resultByteArray){
                user.append(String.format("%02x", b));
            }    
           String hashedpw = user.toString();

      //check if button is enabled and show comfirmation
      if(btn_adduser.isEnabled()){
            int n = JOptionPane.showConfirmDialog(null, "Confirm?", "", JOptionPane.YES_NO_OPTION);       
            //check choices
                if(n == JOptionPane.YES_OPTION){ 
                    //insert to monthlysales db in cloud
                        try{
                         Class.forName("com.mysql.jdbc.Driver"); 
                          String sql = "update accountdb set user=?, password=?, location=?, usertype=? where user_id=?"; 
                          Connection conn = DriverManager.getConnection("jdbc:mysql://184.168.102.151/ezpaydb","ezpaydbadmin","WvsuCictThesis2020");    
                          PreparedStatement pst = conn.prepareStatement(sql);  
                          //query
                          pst.setString(1, txtfield_accounts_username.getText());
                          pst.setString(2, hashedpw);    
                          String userlocation = (String)cbox_accounts_location.getSelectedItem();
                          String usertype = (String)cbox_accounts_usertype.getSelectedItem();
                          pst.setString(3, userlocation);
                          pst.setString(4, usertype);
                          int userid = Integer.parseInt(lbl_userid.getText().toString());
                          pst.setInt(5, userid);
                          JOptionPane.showMessageDialog(this, "Account Updated Successfuly");
                          pst.executeUpdate();
                          conn.close();
                          DisplayTableAccount();                          
                          txtfield_accounts_username.setText(""); 
                          txtfield_accounts_password.setText("");
                          
                          }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                          }
                }//check choice
                }   
    }//GEN-LAST:event_btn_userupdateActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accounts;
    private javax.swing.JButton btn_addadmin;
    private javax.swing.JButton btn_adduser;
    private javax.swing.JButton btn_adminclear;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clearmonthlysalesfield;
    private javax.swing.JButton btn_exportascsv;
    private javax.swing.JButton btn_futureprediction;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_monthlysales;
    private javax.swing.JButton btn_monthlysales_insert;
    private javax.swing.JButton btn_monthlysales_update;
    private javax.swing.JButton btn_prediction;
    private javax.swing.JButton btn_removeadmin;
    private javax.swing.JButton btn_removeuser;
    private javax.swing.JButton btn_sales;
    private javax.swing.JButton btn_settings;
    private javax.swing.JButton btn_showcurrentprediction;
    private javax.swing.JButton btn_showfutureprediction;
    private javax.swing.JButton btn_transactionsearchclear;
    private javax.swing.JButton btn_userupdate;
    private javax.swing.JComboBox cbox_accounts_location;
    private javax.swing.JComboBox cbox_accounts_usertype;
    private com.toedter.calendar.JDateChooser datechooser_month;
    private javax.swing.JPanel home_banner;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbl_adminid;
    private javax.swing.JLabel lbl_futureid;
    private javax.swing.JLabel lbl_monthlysales_id;
    private javax.swing.JLabel lbl_showcurrentprediction;
    private javax.swing.JLabel lbl_showcurrentpredictionid;
    private javax.swing.JLabel lbl_showfutureprediction;
    private javax.swing.JLabel lbl_userid;
    private javax.swing.JPanel panel_accounts;
    private javax.swing.JPanel panel_futureprediction;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_monthlysale_screen;
    private javax.swing.JPanel panel_monthlysales;
    private javax.swing.JPanel panel_prediction;
    private javax.swing.JPanel panel_root;
    private javax.swing.JPanel panel_sales;
    private javax.swing.JPanel panel_screen;
    private javax.swing.JPanel panel_settings;
    private javax.swing.JPanel panel_side;
    private javax.swing.JTable table_accounts;
    private javax.swing.JTable table_adminaccounts;
    private javax.swing.JTable table_currentprediction;
    private javax.swing.JTable table_futurepredictionresult;
    private javax.swing.JTable table_monthlysales;
    private javax.swing.JTable table_transaction;
    private javax.swing.JTextField txtfield_accounts_password;
    private javax.swing.JTextField txtfield_accounts_searchuser;
    private javax.swing.JTextField txtfield_accounts_username;
    private javax.swing.JTextField txtfield_adminpassword;
    private javax.swing.JTextField txtfield_adminusername;
    private javax.swing.JTextField txtfield_monthlysales_sales;
    private javax.swing.JTextField txtfield_searchmonthlysales;
    private javax.swing.JTextField txtfield_searchtransaction;
    private javax.swing.JTextField txtfield_settings_searchadmin;
    // End of variables declaration//GEN-END:variables
}
