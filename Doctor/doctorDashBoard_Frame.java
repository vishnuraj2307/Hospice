/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import ConnectionProvider.ConnectionProvider;
import Home.contactUs_Frame;
import Home.aboutUs_Frame;
import java.awt.Color;
import javax.swing.JFrame;
import Doctor.doctorLogin_Frame;
import com.mysql.cj.xdevapi.Table;
import com.placeholder.PlaceHolder;
import java.awt.HeadlessException;

import java.text.MessageFormat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Image;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Packiyaraj
 */
public class doctorDashBoard_Frame extends javax.swing.JFrame {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pt=null; 
    String dn,dp,na,la;
    String u,p,f,l,h,m,ss,g,d,mm,daaa;
    public int flag=0;
    /**
     * Creates new form doctorDashBoard_Frame
     * @param dashname
     * @param dashpass
     */
//    public doctorDashBoard_Frame() {
//        initComponents();        
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        doctortName.setText(dname);
//    }
    PlaceHolder holder;
     public doctorDashBoard_Frame(String dashname,String dashpass) {
         dn=dashname;dp=dashpass;
        initComponents();
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      
       holder=new PlaceHolder(firstname1, "FIRST NAME");
        holder=new PlaceHolder(lastname1, "LAST NAME");
        holder=new PlaceHolder(address1, "ADDRESS");
        holder=new PlaceHolder(mobile1, "MOBILE");
      
       
        // NAME-------------------------------------------------
        con=ConnectionProvider.getCon();
         String sql="select * from doctor where D_UserName=? and D_Password=? ";
        try{
        pt=con.prepareStatement(sql);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            doctortName.setText(fname+"  "+lname);
            na=fname;la=lname;
        }else {JOptionPane.showMessageDialog(null,"Invalid data");}
//                        String sql1="select img FROM doc WHERE uname=? and pwd=? ";
//                        try{ pt=con.prepareStatement(sql);
//                        pt=con.prepareStatement(sql1);
//                        pt.setString(1, dn);
//                        pt.setString(2, dp);
//                        rs=pt.executeQuery();
//                         if(rs.next()){
//                                 byte[] img=rs.getBytes("img");
//                                 ImageIcon image=new ImageIcon(img);
//                                 Image im=image.getImage();
//                                   Image imk=im.getScaledInstance(doctortPic.getWidth(),doctortPic.getHeight(),Image.SCALE_SMOOTH);
//                             }}catch(SQLException e){JOptionPane.showConfirmDialog(null, e);}
        
    }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            }img();docDashB();
        
        
    }
    public void docDashB(){
              try{
            String sql22="select count(Ap_UserName) from appointment ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(Ap_UserName)");
            totDoc_Icon.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Something is Wrong");}
        }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}
          try{
            String sql22="select count(H_UserName) from historypatient ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(H_UserName)");
            totDoc_Icon1.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Something is Wrong");}
        }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}      
           try{
            String sql22="select count(uname) from  dr_"+dn+"_patients ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(uname)");
            totDoc_Icon2.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Something is Wrong");}
        }catch(HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "You Don't have Patients yet");}
    }
    public void img(){
         try {
             String sql333="select * from doctor where D_UserName=? and D_Password=? ";
        pt=con.prepareStatement(sql333);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){String imgg=rs.getString("D_Gender");
                    if("Male".equals(imgg)){doctortPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/MaleDoctor.png")));}
                    else  if("Female".equals(imgg)){doctortPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/FemaleDoctor.png")));}
                  else {doctortPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/OthersDoctor.png")));}
        
        } } catch (SQLException e) {}
     }
    public void dischargeDate(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now=LocalDateTime.now();
        jLabel71.setText(dtf.format(now));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doctorDashBoardHeader = new javax.swing.JPanel();
        hospital = new javax.swing.JLabel();
        hospitalIcon = new javax.swing.JLabel();
        aboutUs_Label = new javax.swing.JLabel();
        contactUs_Label = new javax.swing.JLabel();
        minimize_Label = new javax.swing.JLabel();
        close_Label = new javax.swing.JLabel();
        goBack_Label = new javax.swing.JLabel();
        doctorProfile = new javax.swing.JPanel();
        appionment_Label = new javax.swing.JLabel();
        PatientDoctor_Label = new javax.swing.JLabel();
        dashboardDoctor_Label = new javax.swing.JLabel();
        doctorProfilePic_Panel = new javax.swing.JPanel();
        doctortPic = new javax.swing.JLabel();
        doctortName = new javax.swing.JLabel();
        doctor = new javax.swing.JLabel();
        appionment_Label1 = new javax.swing.JLabel();
        appionment_Label2 = new javax.swing.JLabel();
        dasBoardDoctor_Tabbed = new javax.swing.JTabbedPane();
        dashBoardDoctor_Panel = new javax.swing.JPanel();
        appoinmentsForYou_Panel = new javax.swing.JPanel();
        totDOC = new javax.swing.JLabel();
        doc1 = new javax.swing.JLabel();
        totDoc_Icon = new javax.swing.JLabel();
        patientUnderYou_Panel = new javax.swing.JPanel();
        totDOC1 = new javax.swing.JLabel();
        doc2 = new javax.swing.JLabel();
        totDoc_Icon1 = new javax.swing.JLabel();
        yourPatientDischarged_Panel = new javax.swing.JPanel();
        totDOC2 = new javax.swing.JLabel();
        doc3 = new javax.swing.JLabel();
        totDoc_Icon2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        totDOC3 = new javax.swing.JLabel();
        patientDoctor_Panel = new javax.swing.JPanel();
        PatientRecord_Panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dischargedPatient_Panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yourPatientRecord_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        yourDischargedPatientRecord = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        appoinmentsDoctor_Panel = new javax.swing.JPanel();
        viewappoinment_Panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deleteAppoinment_Panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        YourAppoinments_Panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        deleteYourAppoinments_Panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        registerForm_Label1 = new javax.swing.JLabel();
        firstname1 = new javax.swing.JTextField();
        lastname1 = new javax.swing.JTextField();
        department2 = new javax.swing.JComboBox<>();
        address1 = new javax.swing.JTextField();
        registerPatient_Button1 = new javax.swing.JButton();
        mobile1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        registerPatient_Button2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtsid5 = new javax.swing.JTextField();
        btnsearch1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        dischargePanel = new javax.swing.JPanel();
        printdis = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton14 = new javax.swing.JButton();
        doctorDashBoardFooter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        doctorDashBoardHeader.setBackground(new java.awt.Color(0, 0, 204));

        hospital.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        hospital.setForeground(new java.awt.Color(255, 255, 255));
        hospital.setText("HOSPITAL");

        hospitalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/HospitalIcon.png"))); // NOI18N

        aboutUs_Label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        aboutUs_Label.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/AboutUs.png"))); // NOI18N
        aboutUs_Label.setText("About Us");
        aboutUs_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUs_LabelMouseClicked(evt);
            }
        });

        contactUs_Label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        contactUs_Label.setForeground(new java.awt.Color(255, 255, 255));
        contactUs_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/ContactUs.png"))); // NOI18N
        contactUs_Label.setText("Contact Us");
        contactUs_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactUs_LabelMouseClicked(evt);
            }
        });

        minimize_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/MinimizeWindow.png"))); // NOI18N
        minimize_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize_LabelMouseClicked(evt);
            }
        });

        close_Label.setBackground(new java.awt.Color(0, 0, 204));
        close_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        close_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/Close.png"))); // NOI18N
        close_Label.setOpaque(true);
        close_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_LabelMouseExited(evt);
            }
        });

        goBack_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/Go Back.png"))); // NOI18N
        goBack_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack_LabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout doctorDashBoardHeaderLayout = new javax.swing.GroupLayout(doctorDashBoardHeader);
        doctorDashBoardHeader.setLayout(doctorDashBoardHeaderLayout);
        doctorDashBoardHeaderLayout.setHorizontalGroup(
            doctorDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorDashBoardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(670, 670, 670)
                .addComponent(aboutUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(contactUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimize_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        doctorDashBoardHeaderLayout.setVerticalGroup(
            doctorDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospitalIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(hospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aboutUs_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(contactUs_Label))
            .addGroup(doctorDashBoardHeaderLayout.createSequentialGroup()
                .addGroup(doctorDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimize_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(close_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorDashBoardHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        doctorProfile.setBackground(new java.awt.Color(0, 0, 255));

        appionment_Label.setBackground(new java.awt.Color(0, 0, 255));
        appionment_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appionment_Label.setForeground(new java.awt.Color(255, 255, 255));
        appionment_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Doctors.png"))); // NOI18N
        appionment_Label.setText("Doctors and Discharged");
        appionment_Label.setOpaque(true);
        appionment_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseExited(evt);
            }
        });

        PatientDoctor_Label.setBackground(new java.awt.Color(0, 0, 255));
        PatientDoctor_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PatientDoctor_Label.setForeground(new java.awt.Color(255, 255, 255));
        PatientDoctor_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Appoinment.png"))); // NOI18N
        PatientDoctor_Label.setText("     Appoinments and Records");
        PatientDoctor_Label.setToolTipText("");
        PatientDoctor_Label.setOpaque(true);
        PatientDoctor_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientDoctor_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PatientDoctor_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PatientDoctor_LabelMouseExited(evt);
            }
        });

        dashboardDoctor_Label.setBackground(new java.awt.Color(0, 0, 255));
        dashboardDoctor_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dashboardDoctor_Label.setForeground(new java.awt.Color(255, 255, 255));
        dashboardDoctor_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/DashBoard.png"))); // NOI18N
        dashboardDoctor_Label.setText("     Dashboard");
        dashboardDoctor_Label.setOpaque(true);
        dashboardDoctor_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardDoctor_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardDoctor_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardDoctor_LabelMouseExited(evt);
            }
        });

        doctorProfilePic_Panel.setBackground(new java.awt.Color(0, 0, 204));

        doctortPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        doctortName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        doctortName.setForeground(new java.awt.Color(255, 255, 255));
        doctortName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        doctor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doctor.setForeground(new java.awt.Color(255, 255, 255));
        doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctor.setText("Doctor");

        javax.swing.GroupLayout doctorProfilePic_PanelLayout = new javax.swing.GroupLayout(doctorProfilePic_Panel);
        doctorProfilePic_Panel.setLayout(doctorProfilePic_PanelLayout);
        doctorProfilePic_PanelLayout.setHorizontalGroup(
            doctorProfilePic_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doctortName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(doctorProfilePic_PanelLayout.createSequentialGroup()
                .addGroup(doctorProfilePic_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorProfilePic_PanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(doctorProfilePic_PanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(doctortPic, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        doctorProfilePic_PanelLayout.setVerticalGroup(
            doctorProfilePic_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorProfilePic_PanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(doctortPic, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doctortName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(doctor)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        appionment_Label1.setBackground(new java.awt.Color(0, 0, 255));
        appionment_Label1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appionment_Label1.setForeground(new java.awt.Color(255, 255, 255));
        appionment_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/DoctorProfile.png"))); // NOI18N
        appionment_Label1.setText("      Profile");
        appionment_Label1.setOpaque(true);
        appionment_Label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appionment_Label1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appionment_Label1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appionment_Label1MouseExited(evt);
            }
        });

        appionment_Label2.setBackground(new java.awt.Color(0, 0, 255));
        appionment_Label2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appionment_Label2.setForeground(new java.awt.Color(255, 255, 255));
        appionment_Label2.setText("Profile");
        appionment_Label2.setOpaque(true);
        appionment_Label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appionment_Label2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appionment_Label2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appionment_Label2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout doctorProfileLayout = new javax.swing.GroupLayout(doctorProfile);
        doctorProfile.setLayout(doctorProfileLayout);
        doctorProfileLayout.setHorizontalGroup(
            doctorProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appionment_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PatientDoctor_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
            .addComponent(dashboardDoctor_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(doctorProfilePic_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(appionment_Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(doctorProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(doctorProfileLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(appionment_Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        doctorProfileLayout.setVerticalGroup(
            doctorProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorProfileLayout.createSequentialGroup()
                .addComponent(doctorProfilePic_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboardDoctor_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PatientDoctor_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appionment_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appionment_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(doctorProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorProfileLayout.createSequentialGroup()
                    .addContainerGap(487, Short.MAX_VALUE)
                    .addComponent(appionment_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(112, 112, 112)))
        );

        dasBoardDoctor_Tabbed.setEnabled(false);
        dasBoardDoctor_Tabbed.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        dashBoardDoctor_Panel.setBackground(new java.awt.Color(255, 255, 255));

        appoinmentsForYou_Panel.setBackground(new java.awt.Color(255, 0, 0));
        appoinmentsForYou_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        totDOC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totDOC.setForeground(new java.awt.Color(255, 255, 255));
        totDOC.setText("Hospital Appoinments");

        doc1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        doc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/TotalAppoinment.png"))); // NOI18N

        totDoc_Icon.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totDoc_Icon.setForeground(new java.awt.Color(255, 255, 255));
        totDoc_Icon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout appoinmentsForYou_PanelLayout = new javax.swing.GroupLayout(appoinmentsForYou_Panel);
        appoinmentsForYou_Panel.setLayout(appoinmentsForYou_PanelLayout);
        appoinmentsForYou_PanelLayout.setHorizontalGroup(
            appoinmentsForYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentsForYou_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(appoinmentsForYou_PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(doc1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totDoc_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        appoinmentsForYou_PanelLayout.setVerticalGroup(
            appoinmentsForYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentsForYou_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(appoinmentsForYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totDoc_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doc1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        patientUnderYou_Panel.setBackground(new java.awt.Color(153, 153, 0));
        patientUnderYou_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));

        totDOC1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totDOC1.setForeground(new java.awt.Color(255, 255, 255));
        totDOC1.setText("Total Patients");

        doc2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        doc2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/PatientsTotali.png"))); // NOI18N

        totDoc_Icon1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totDoc_Icon1.setForeground(new java.awt.Color(255, 255, 255));
        totDoc_Icon1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout patientUnderYou_PanelLayout = new javax.swing.GroupLayout(patientUnderYou_Panel);
        patientUnderYou_Panel.setLayout(patientUnderYou_PanelLayout);
        patientUnderYou_PanelLayout.setHorizontalGroup(
            patientUnderYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientUnderYou_PanelLayout.createSequentialGroup()
                .addGroup(patientUnderYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientUnderYou_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(doc2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totDoc_Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(patientUnderYou_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totDOC1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        patientUnderYou_PanelLayout.setVerticalGroup(
            patientUnderYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientUnderYou_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientUnderYou_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totDoc_Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doc2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totDOC1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        yourPatientDischarged_Panel.setBackground(new java.awt.Color(0, 0, 153));
        yourPatientDischarged_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));

        totDOC2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totDOC2.setForeground(new java.awt.Color(255, 255, 255));
        totDOC2.setText("Your Discharged Patient");

        doc3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        doc3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Discharged.png"))); // NOI18N

        totDoc_Icon2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totDoc_Icon2.setForeground(new java.awt.Color(255, 255, 255));
        totDoc_Icon2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout yourPatientDischarged_PanelLayout = new javax.swing.GroupLayout(yourPatientDischarged_Panel);
        yourPatientDischarged_Panel.setLayout(yourPatientDischarged_PanelLayout);
        yourPatientDischarged_PanelLayout.setHorizontalGroup(
            yourPatientDischarged_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourPatientDischarged_PanelLayout.createSequentialGroup()
                .addGroup(yourPatientDischarged_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourPatientDischarged_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(doc3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totDoc_Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourPatientDischarged_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totDOC2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        yourPatientDischarged_PanelLayout.setVerticalGroup(
            yourPatientDischarged_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourPatientDischarged_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yourPatientDischarged_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totDoc_Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doc3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totDOC2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 0));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        totDOC3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totDOC3.setForeground(new java.awt.Color(255, 255, 255));
        totDOC3.setText("Laboratory Reports");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(totDOC3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(totDOC3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout dashBoardDoctor_PanelLayout = new javax.swing.GroupLayout(dashBoardDoctor_Panel);
        dashBoardDoctor_Panel.setLayout(dashBoardDoctor_PanelLayout);
        dashBoardDoctor_PanelLayout.setHorizontalGroup(
            dashBoardDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardDoctor_PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(dashBoardDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appoinmentsForYou_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(patientUnderYou_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(yourPatientDischarged_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        dashBoardDoctor_PanelLayout.setVerticalGroup(
            dashBoardDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardDoctor_PanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(dashBoardDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(appoinmentsForYou_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientUnderYou_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yourPatientDischarged_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("   DashBoard   ", dashBoardDoctor_Panel);

        patientDoctor_Panel.setBackground(new java.awt.Color(255, 255, 255));

        PatientRecord_Panel.setBackground(new java.awt.Color(0, 153, 0));
        PatientRecord_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        PatientRecord_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientRecord_PanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PatientRecord_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PatientRecord_PanelMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Doctor Appoinments.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("View Appoinments");

        javax.swing.GroupLayout PatientRecord_PanelLayout = new javax.swing.GroupLayout(PatientRecord_Panel);
        PatientRecord_Panel.setLayout(PatientRecord_PanelLayout);
        PatientRecord_PanelLayout.setHorizontalGroup(
            PatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientRecord_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientRecord_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        PatientRecord_PanelLayout.setVerticalGroup(
            PatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientRecord_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        dischargedPatient_Panel.setBackground(new java.awt.Color(255, 0, 0));
        dischargedPatient_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        dischargedPatient_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dischargedPatient_PanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dischargedPatient_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dischargedPatient_PanelMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/TotalPatient.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Old Patient Records");

        javax.swing.GroupLayout dischargedPatient_PanelLayout = new javax.swing.GroupLayout(dischargedPatient_Panel);
        dischargedPatient_Panel.setLayout(dischargedPatient_PanelLayout);
        dischargedPatient_PanelLayout.setHorizontalGroup(
            dischargedPatient_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargedPatient_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dischargedPatient_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        dischargedPatient_PanelLayout.setVerticalGroup(
            dischargedPatient_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargedPatient_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout patientDoctor_PanelLayout = new javax.swing.GroupLayout(patientDoctor_Panel);
        patientDoctor_Panel.setLayout(patientDoctor_PanelLayout);
        patientDoctor_PanelLayout.setHorizontalGroup(
            patientDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientDoctor_PanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(PatientRecord_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(dischargedPatient_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        patientDoctor_PanelLayout.setVerticalGroup(
            patientDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientDoctor_PanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(patientDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PatientRecord_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dischargedPatient_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(408, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("       Patient       ", patientDoctor_Panel);

        yourPatientRecord_Panel.setBackground(new java.awt.Color(255, 255, 255));
        yourPatientRecord_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yourPatientRecord_PanelMouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "First Name", "Last Name", "Symptoms", "Diagnosis", "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Medicines");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Diagnosis");

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Details");

        javax.swing.GroupLayout yourPatientRecord_PanelLayout = new javax.swing.GroupLayout(yourPatientRecord_Panel);
        yourPatientRecord_Panel.setLayout(yourPatientRecord_PanelLayout);
        yourPatientRecord_PanelLayout.setHorizontalGroup(
            yourPatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourPatientRecord_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yourPatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(yourPatientRecord_PanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        yourPatientRecord_PanelLayout.setVerticalGroup(
            yourPatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourPatientRecord_PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(yourPatientRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dasBoardDoctor_Tabbed.addTab("Appoinments", yourPatientRecord_Panel);

        yourDischargedPatientRecord.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Nmae", "First Name", "Last Name", "Address", "Mobile", "Symptoms", "Gender", "Diagnosis", "Medicine"
            }
        ));
        jTable3.setRowHeight(25);
        jScrollPane3.setViewportView(jTable3);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Details");

        javax.swing.GroupLayout yourDischargedPatientRecordLayout = new javax.swing.GroupLayout(yourDischargedPatientRecord);
        yourDischargedPatientRecord.setLayout(yourDischargedPatientRecordLayout);
        yourDischargedPatientRecordLayout.setHorizontalGroup(
            yourDischargedPatientRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourDischargedPatientRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yourDischargedPatientRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(yourDischargedPatientRecordLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        yourDischargedPatientRecordLayout.setVerticalGroup(
            yourDischargedPatientRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourDischargedPatientRecordLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(yourDischargedPatientRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("       Records      ", yourDischargedPatientRecord);

        appoinmentsDoctor_Panel.setBackground(new java.awt.Color(255, 255, 255));

        viewappoinment_Panel.setBackground(new java.awt.Color(153, 0, 153));
        viewappoinment_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        viewappoinment_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewappoinment_PanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewappoinment_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewappoinment_PanelMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/YourDischarge.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your Discharged Patients");

        javax.swing.GroupLayout viewappoinment_PanelLayout = new javax.swing.GroupLayout(viewappoinment_Panel);
        viewappoinment_Panel.setLayout(viewappoinment_PanelLayout);
        viewappoinment_PanelLayout.setHorizontalGroup(
            viewappoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewappoinment_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewappoinment_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        viewappoinment_PanelLayout.setVerticalGroup(
            viewappoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewappoinment_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        deleteAppoinment_Panel.setBackground(new java.awt.Color(0, 153, 51));
        deleteAppoinment_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        deleteAppoinment_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAppoinment_PanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteAppoinment_PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteAppoinment_PanelMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/OtherDoctors.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hospital Doctor Records");

        javax.swing.GroupLayout deleteAppoinment_PanelLayout = new javax.swing.GroupLayout(deleteAppoinment_Panel);
        deleteAppoinment_Panel.setLayout(deleteAppoinment_PanelLayout);
        deleteAppoinment_PanelLayout.setHorizontalGroup(
            deleteAppoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAppoinment_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteAppoinment_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(22, 22, 22))
        );
        deleteAppoinment_PanelLayout.setVerticalGroup(
            deleteAppoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAppoinment_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout appoinmentsDoctor_PanelLayout = new javax.swing.GroupLayout(appoinmentsDoctor_Panel);
        appoinmentsDoctor_Panel.setLayout(appoinmentsDoctor_PanelLayout);
        appoinmentsDoctor_PanelLayout.setHorizontalGroup(
            appoinmentsDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentsDoctor_PanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(viewappoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(deleteAppoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        appoinmentsDoctor_PanelLayout.setVerticalGroup(
            appoinmentsDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentsDoctor_PanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(appoinmentsDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAppoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewappoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(405, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("       Doctor       ", appoinmentsDoctor_Panel);

        YourAppoinments_Panel.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.setRowHeight(25);
        jScrollPane4.setViewportView(jTable4);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Details");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout YourAppoinments_PanelLayout = new javax.swing.GroupLayout(YourAppoinments_Panel);
        YourAppoinments_Panel.setLayout(YourAppoinments_PanelLayout);
        YourAppoinments_PanelLayout.setHorizontalGroup(
            YourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YourAppoinments_PanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(YourAppoinments_PanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
                .addContainerGap())
        );
        YourAppoinments_PanelLayout.setVerticalGroup(
            YourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YourAppoinments_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(YourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("      Discharged     ", YourAppoinments_Panel);

        deleteYourAppoinments_Panel.setBackground(new java.awt.Color(255, 255, 255));

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "First Name", "Last Name", "Address", "Mobile", "Department", "Gender", "Image"
            }
        ));
        jTable5.setRowHeight(25);
        jScrollPane5.setViewportView(jTable5);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Details");

        javax.swing.GroupLayout deleteYourAppoinments_PanelLayout = new javax.swing.GroupLayout(deleteYourAppoinments_Panel);
        deleteYourAppoinments_Panel.setLayout(deleteYourAppoinments_PanelLayout);
        deleteYourAppoinments_PanelLayout.setHorizontalGroup(
            deleteYourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteYourAppoinments_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(deleteYourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deleteYourAppoinments_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteYourAppoinments_PanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        deleteYourAppoinments_PanelLayout.setVerticalGroup(
            deleteYourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteYourAppoinments_PanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(deleteYourAppoinments_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("Other Doctors", deleteYourAppoinments_Panel);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 51, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        registerForm_Label1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label1.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label1.setText("Update Your Profile");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(registerForm_Label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerForm_Label1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        firstname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstname1FocusLost(evt);
            }
        });
        firstname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname1ActionPerformed(evt);
            }
        });

        lastname1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname1ActionPerformed(evt);
            }
        });

        department2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Cardiologist", "Neurologist", "Orthopaedic", "Psychiatrists", "Pulmonologist", "Radiologist", "Oncologist", "Paediatrician", "Gynaecologist", "Endocrinologist", " ", " " }));

        address1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });

        registerPatient_Button1.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button1.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button1.setText("Update");
        registerPatient_Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button1MouseEntered(evt);
            }
        });
        registerPatient_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button1ActionPerformed(evt);
            }
        });

        mobile1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile1ActionPerformed(evt);
            }
        });

        registerPatient_Button2.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button2.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button2.setText("Go Back");
        registerPatient_Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button2MouseEntered(evt);
            }
        });
        registerPatient_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(registerPatient_Button1)
                        .addGap(66, 66, 66)
                        .addComponent(registerPatient_Button2))
                    .addComponent(firstname1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(address1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mobile1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(lastname1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(firstname1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(lastname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(mobile1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button1)
                    .addComponent(registerPatient_Button2))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1061, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(230, 230, 230)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(238, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        dasBoardDoctor_Tabbed.addTab("Update  Profile", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(0, 204, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/ViewProfile.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("View Profile");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel9.setBackground(new java.awt.Color(153, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Update.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Update Profile");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("    Profile    ", jPanel3);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Last Name");

        jLabel14.setText("Address");

        jLabel15.setText("First Name");

        jLabel24.setText("User Name");

        jLabel25.setText("Gender");

        jLabel26.setText("Mobile");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setOpaque(true);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setOpaque(true);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setOpaque(true);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setOpaque(true);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setOpaque(true);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setOpaque(true);

        jLabel34.setText("Specialization");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setOpaque(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(482, Short.MAX_VALUE)))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(474, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(457, Short.MAX_VALUE)))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(179, 179, 179)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        dasBoardDoctor_Tabbed.addTab("    Details    ", jPanel4);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Patient ID");

        txtsid5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnsearch1.setBackground(new java.awt.Color(255, 153, 0));
        btnsearch1.setText("Search");
        btnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearch1ActionPerformed(evt);
            }
        });

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "First Name", "Last Name", "Address", "Mobile", "Department", "Gender", "Image"
            }
        ));
        jTable6.setRowHeight(25);
        jScrollPane6.setViewportView(jTable6);

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "First Name", "Last Name", "Address", "Mobile", "Department", "Gender", "Image"
            }
        ));
        jTable7.setRowHeight(25);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setText("Check for Previous Record of Selected Test Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel54.setBackground(new java.awt.Color(51, 0, 255));
        jLabel54.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 51, 51));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jButton3.setBackground(new java.awt.Color(102, 255, 0));
        jButton3.setText("Summary");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsid5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsearch1)
                        .addGap(360, 360, 360)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(910, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsid5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsearch1)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(10, 10, 10))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(561, Short.MAX_VALUE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
        );

        dasBoardDoctor_Tabbed.addTab("         Lab          ", jPanel5);

        printdis.setBackground(new java.awt.Color(255, 255, 255));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel67.setText("HOSPITAL ");

        jLabel68.setText("Admit Date       :");

        jLabel70.setText("Discharge Date :");

        jLabel72.setText("221B, Baker Street,Tirunelveli - 627001");
        jLabel72.setOpaque(true);

        jLabel73.setText("Patient Name      : ");

        jLabel75.setText("Patient Mobile     :");

        jLabel76.setText("Patient Address  :");

        jLabel77.setText("Patient ID           :");

        jLabel82.setText("Symptoms");
        jLabel82.setOpaque(true);

        jLabel84.setText("Invoice");
        jLabel84.setOpaque(true);

        jLabel90.setText("Summary");
        jLabel90.setOpaque(true);

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel91.setText("Report Summary");

        jLabel85.setText("Test Name          : ");

        jLabel87.setText("Range                 :");

        jLabel89.setText("Result                 :");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("-");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout printdisLayout = new javax.swing.GroupLayout(printdis);
        printdis.setLayout(printdisLayout);
        printdisLayout.setHorizontalGroup(
            printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printdisLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(printdisLayout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)))
                        .addGap(43, 43, 43))
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                                    .addGroup(printdisLayout.createSequentialGroup()
                                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel87)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                .addComponent(jLabel90, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        printdisLayout.setVerticalGroup(
            printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printdisLayout.createSequentialGroup()
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel73)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel75)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel77)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jButton14.setBackground(new java.awt.Color(0, 0, 204));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Printer.png"))); // NOI18N
        jButton14.setText("Print");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dischargePanelLayout = new javax.swing.GroupLayout(dischargePanel);
        dischargePanel.setLayout(dischargePanelLayout);
        dischargePanelLayout.setHorizontalGroup(
            dischargePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargePanelLayout.createSequentialGroup()
                .addComponent(jButton14)
                .addGap(229, 229, 229)
                .addComponent(printdis, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        dischargePanelLayout.setVerticalGroup(
            dischargePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dischargePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printdis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dischargePanelLayout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(dischargePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(dischargePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        dasBoardDoctor_Tabbed.addTab("        Summary       ", jPanel12);

        doctorDashBoardFooter.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout doctorDashBoardFooterLayout = new javax.swing.GroupLayout(doctorDashBoardFooter);
        doctorDashBoardFooter.setLayout(doctorDashBoardFooterLayout);
        doctorDashBoardFooterLayout.setHorizontalGroup(
            doctorDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        doctorDashBoardFooterLayout.setVerticalGroup(
            doctorDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dasBoardDoctor_Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(doctorDashBoardFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(doctorDashBoardHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(doctorDashBoardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dasBoardDoctor_Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(doctorDashBoardFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactUs_LabelMouseClicked
        // TODO add your handling code here:
        new contactUs_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_contactUs_LabelMouseClicked

    private void aboutUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs_LabelMouseClicked
        // TODO add your handling code here:
        new aboutUs_Frame().setVisible(true);    dispose();
    }//GEN-LAST:event_aboutUs_LabelMouseClicked

    private void dashboardDoctor_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardDoctor_LabelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(0);docDashB();
    }//GEN-LAST:event_dashboardDoctor_LabelMouseClicked

    private void goBack_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_LabelMouseClicked
        // TODO add your handling code here:
        new doctorLogin_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_goBack_LabelMouseClicked

    private void PatientDoctor_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientDoctor_LabelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(1);
    }//GEN-LAST:event_PatientDoctor_LabelMouseClicked

    private void appionment_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(4);
    }//GEN-LAST:event_appionment_LabelMouseClicked

    private void PatientRecord_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRecord_PanelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(2);
         String sql1="select Ap_UserName as 'User Name',Ap_FirstName as 'First Name',Ap_LastName as 'Last Name',Ap_Symptoms as 'Symptoms',Ap_Diagnosis as 'Diagnosis',Ap_Medications as 'Medicine' from appointment ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_PatientRecord_PanelMouseClicked

    private void dischargedPatient_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dischargedPatient_PanelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(3);
         String sql2="select H_UserName as 'User Name',H_FirstName as 'First Name',H_LastName as 'Last Name',H_Address as 'Address',H_Mobile as 'Mobile',H_Symptoms as 'Symptoms',H_Gender as 'Gender',H_Diagnosis as 'Diagnosis',H_Medications as 'Medicine' from historypatient ";
        try {
            pt=con.prepareStatement(sql2);
             rs=pt.executeQuery();
             jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_dischargedPatient_PanelMouseClicked

    private void viewappoinment_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewappoinment_PanelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(5);
       //  String sql1="select * from ";
        try {
            pt=con.prepareStatement("select fname as 'First Name',lname as 'Last Name',hom as 'Address',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine' from dr_"+dn+"_patients ");
            
             rs=pt.executeQuery();
             jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "You Don't have Patients yet!");} 
    }//GEN-LAST:event_viewappoinment_PanelMouseClicked

    private void dashboardDoctor_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardDoctor_LabelMouseEntered
        // TODO add your handling code here:
        dashboardDoctor_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_dashboardDoctor_LabelMouseEntered

    private void PatientDoctor_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientDoctor_LabelMouseEntered
        // TODO add your handling code here:
        PatientDoctor_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_PatientDoctor_LabelMouseEntered

    private void appionment_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseEntered
        // TODO add your handling code here:
        appionment_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_appionment_LabelMouseEntered

    private void dashboardDoctor_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardDoctor_LabelMouseExited
        // TODO add your handling code here:
        dashboardDoctor_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_dashboardDoctor_LabelMouseExited

    private void PatientDoctor_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientDoctor_LabelMouseExited
        // TODO add your handling code here:
        PatientDoctor_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_PatientDoctor_LabelMouseExited

    private void appionment_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseExited
        // TODO add your handling code here:
        appionment_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_appionment_LabelMouseExited

    private void PatientRecord_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRecord_PanelMouseExited
        // TODO add your handling code here:
        PatientRecord_Panel.setBackground(new Color(0,153,0));       
    }//GEN-LAST:event_PatientRecord_PanelMouseExited

    private void PatientRecord_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRecord_PanelMouseEntered
        // TODO add your handling code here:
        PatientRecord_Panel.setBackground(new Color(0,204,0));
    }//GEN-LAST:event_PatientRecord_PanelMouseEntered

    private void dischargedPatient_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dischargedPatient_PanelMouseExited
        // TODO add your handling code here:
        dischargedPatient_Panel.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_dischargedPatient_PanelMouseExited

    private void dischargedPatient_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dischargedPatient_PanelMouseEntered
        // TODO add your handling code here:
        dischargedPatient_Panel.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_dischargedPatient_PanelMouseEntered

    private void viewappoinment_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewappoinment_PanelMouseExited
        // TODO add your handling code here:
        viewappoinment_Panel.setBackground(new Color(153,0,153));
    }//GEN-LAST:event_viewappoinment_PanelMouseExited

    private void deleteAppoinment_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAppoinment_PanelMouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(6);
         String sql1="select D_UserName as 'User Name',D_FirstName as 'First Name',D_LastName as 'Last Name',D_Address as 'Address',D_Mobile as 'Mobile',D_Department as 'Department',D_Gender as 'Gender' from doctor ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_deleteAppoinment_PanelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();String i;
        String cell=jTable1.getModel().getValueAt(row, 0).toString();
        String sql="update appointment set Ap_Diagnosis=?,Ap_Medications=? where Ap_UserName=?";
        try {
            pt=con.prepareStatement(sql);
           pt.setString(1,jTextField1.getText());
           pt.setString(2, jTextField2.getText());
           pt.setString(3, cell);
            pt.executeUpdate();
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
          
        String sqlll="select Ap_UserName,Ap_Password,Ap_FirstName,Ap_LastName,Ap_Address,Ap_Mobile,Ap_Symptoms,Ap_Gender,Ap_Diagnosis,Ap_Medications,Ap_date from appointment where Ap_UserName=?";
        
         try {
            pt=con.prepareStatement(sqlll);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){u=rs.getString(1);p=rs.getString(2);
        f=rs.getString(3);
       l=rs.getString(4);h=rs.getString(5);m=rs.getString(6);
        ss=rs.getString(7);g=rs.getString(8);d=rs.getString(9); mm=rs.getString(10);daaa=rs.getString(11); 
        }
                
        pt=con.prepareStatement("insert into dr_"+dn+"_patients(uname,pwd,fname,lname,hom,mob,sym,gen,diag,med,dateAdmit) values(?,?,?,?,?,?,?,?,?,?,?)");
            pt.setString(1,u ); 
            pt.setString(2,p);
            pt.setString(3,f );
            pt.setString(4,l );
            pt.setString(5,h );
            pt.setString(6,m );
            pt.setString(7,ss);
            pt.setString(8,g );
            pt.setString(9,d );
            pt.setString(10,mm );
            pt.setString(11,daaa );
            pt.executeUpdate();
         }
         catch(HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        
        
         String sql1="select Ap_UserName as 'User Name',Ap_FirstName as 'First Name',Ap_LastName as 'Last Name',Ap_Symptoms as 'Symptoms',Ap_Diagnosis as 'Diagnosis',Ap_Medications as 'Medicine' from appointment ";

        
        try {jTextField1.setText("");jTextField2.setText("");
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void yourPatientRecord_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yourPatientRecord_PanelMouseClicked
//        // TODO add your handling code here:
//        String sql1="select * from appoinment ";
//        try {
//            pt=con.prepareStatement(sql1);
//             rs=pt.executeQuery();
//             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);}  
    }//GEN-LAST:event_yourPatientRecord_PanelMouseClicked

    private void appionment_Label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label1MouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(8);
    }//GEN-LAST:event_appionment_Label1MouseClicked

    private void appionment_Label1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label1MouseEntered
        // TODO add your handling code here:
         appionment_Label1.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_appionment_Label1MouseEntered

    private void appionment_Label1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label1MouseExited
        // TODO add your handling code here:
       appionment_Label1.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_appionment_Label1MouseExited

    private void firstname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname1FocusLost

    }//GEN-LAST:event_firstname1FocusLost

    private void firstname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname1ActionPerformed

    private void lastname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname1ActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void registerPatient_Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button1MouseEntered

    private void registerPatient_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button1ActionPerformed
        // TODO add your handling code here:

        String sql="update doctor set D_FirstName=?,D_LastName=?,D_Address=?,D_Mobile=?,D_Department=? where D_UserName=?";
        try {
            pt=con.prepareStatement(sql);
            pt.setString(1,firstname1.getText());
            pt.setString(2, lastname1.getText());
            pt.setString(3,address1.getText());
            pt.setString(4, mobile1.getText());
            pt.setString(5,(String)department2.getSelectedItem());
            pt.setString(6, dn);
            pt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");}
        catch (HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
             String sql33="select * from doctor where D_UserName=? and D_Password=? ";
        try{
        pt=con.prepareStatement(sql33);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            doctortName.setText(fname+"  "+lname);
        }
        dasBoardDoctor_Tabbed.setSelectedIndex(0);}
        catch(HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_registerPatient_Button1ActionPerformed

    private void mobile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile1ActionPerformed

    private void registerPatient_Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button2MouseEntered

    private void registerPatient_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button2ActionPerformed
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(0);
    }//GEN-LAST:event_registerPatient_Button2ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        String search=jTextField3.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
         DefaultTableModel table=(DefaultTableModel)jTable3.getModel();
        String search=jTextField4.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable3.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table=(DefaultTableModel)jTable5.getModel();
        String search=jTextField5.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable5.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
         DefaultTableModel table=(DefaultTableModel)jTable4.getModel();
        String search=jTextField6.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable4.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(9);
        String fll,lll,ull,hll,mll,gll,gnn;
        String sql="select D_FirstName,D_LastName,D_UserName,D_Address,D_Mobile,D_Gender,D_Department from doctor where D_UserName=?";
        try {
            pt=con.prepareStatement(sql);
            pt.setString(1, dn);
            rs=pt.executeQuery();
            if(rs.next()){
                fll=rs.getString(1);jLabel27.setText(fll);
                lll=rs.getString(2);jLabel28.setText(lll);
                ull=rs.getString(3);jLabel31.setText(ull);
                hll=rs.getString(4);jLabel35.setText(hll);
                mll=rs.getString(5);jLabel32.setText(mll);
                gll=rs.getString(6);jLabel29.setText(gll);
                gnn=rs.getString(7);jLabel33.setText(gnn);
            }

        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
     
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(7);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void minimize_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_LabelMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);

    }//GEN-LAST:event_minimize_LabelMouseClicked

    private void close_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close_LabelMouseClicked

    private void close_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseEntered
        // TODO add your handling code here:
        close_Label.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_close_LabelMouseEntered

    private void close_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseExited
        // TODO add your handling code here:
        close_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_close_LabelMouseExited

    private void viewappoinment_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewappoinment_PanelMouseEntered
        // TODO add your handling code here:
        viewappoinment_Panel.setBackground(new Color(102,0,102));
    }//GEN-LAST:event_viewappoinment_PanelMouseEntered

    private void deleteAppoinment_PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAppoinment_PanelMouseExited
        // TODO add your handling code here:
      deleteAppoinment_Panel.setBackground(new Color(0,153,51));
    }//GEN-LAST:event_deleteAppoinment_PanelMouseExited

    private void deleteAppoinment_PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAppoinment_PanelMouseEntered
        // TODO add your handling code here:
        deleteAppoinment_Panel.setBackground(new Color(0,102,51));
    }//GEN-LAST:event_deleteAppoinment_PanelMouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(0,153,51));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        // TODO add your handling code here:
         jPanel9.setBackground(new Color(202,0,0));
    }//GEN-LAST:event_jPanel9MouseEntered

    private void appionment_Label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_appionment_Label2MouseClicked

    private void appionment_Label2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_appionment_Label2MouseEntered

    private void appionment_Label2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_Label2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_appionment_Label2MouseExited

    private void btnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearch1ActionPerformed
        // TODO add your handling code here:
        String sql12 = "select name as 'Test',results as 'Result',min as 'Minimum',max as 'Maximum',units as 'Unit',date as 'Date' from result where patient_id=?";
        try {
            pt = con.prepareStatement(sql12);
            pt.setString(1, txtsid5.getText());
            rs = pt.executeQuery();
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));

           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
//         try {String dq="select name as 'Test',results as 'Result',min as 'Minimum',max as 'Maximum',units as 'Unit',date as 'Date' from lab_records where patient_id=?";
//            pt = con.prepareStatement(dq);
//            pt.setString(1, txtsid5.getText());
//            rs = pt.executeQuery();
//            jTable6.setModel(DbUtils.resultSetToTableModel(rs));
//
//           
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
        finally {
            try {
                rs.close();
                pt.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnsearch1ActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        dasBoardDoctor_Tabbed.setSelectedIndex(10);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:



    }//GEN-LAST:event_jTable7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int row=jTable6.getSelectedRow();
        String cell=jTable6.getModel().getValueAt(row, 0).toString();
        jLabel38.setText("Test Selected");
        jLabel39.setText(cell);
        //String na=jLabel39.getText();
        
       try {String dq="select name as 'Test',results as 'Result',min as 'Minimum',max as 'Maximum',units as 'Unit',date as 'Date' from lab_records where id=( SELECT max(id) FROM lab_records where patient_id=? and name=? ) and patient_id=? and name=?";
            pt = con.prepareStatement(dq);
            pt.setString(1, txtsid5.getText());
            pt.setString(2, jLabel39.getText());
            pt.setString(3, txtsid5.getText());
            pt.setString(4, jLabel39.getText());
            rs = pt.executeQuery();
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
            jLabel54.setText("Click here to COMPARE Data");
        ///
        int s=jTable7.getRowCount();
        if(s==0){JOptionPane.showMessageDialog(null, "Patient Dont have previous record for this Test");dasBoardDoctor_Tabbed.setSelectedIndex(0);}
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
        jLabel65.setText("COMPARISION Identifier");
        
        int row1=jTable7.getSelectedRow();
        String cell1=jTable7.getModel().getValueAt(row1, 1).toString();
        jLabel50.setText(cell1);
        int row11=jTable7.getSelectedRow();
        String cell11=jTable7.getModel().getValueAt(row11, 4).toString();
        jLabel52.setText(cell11);
        int row12=jTable7.getSelectedRow();
        String cell12=jTable7.getModel().getValueAt(row12, 5).toString();
        jLabel48.setText(cell12+":");
        
        int row2=jTable6.getSelectedRow();
        String cell2=jTable6.getModel().getValueAt(row2, 1).toString();
        jLabel51.setText(cell2);
        int row21=jTable6.getSelectedRow();
        String cell21=jTable6.getModel().getValueAt(row21, 4).toString();
        jLabel53.setText(cell21);
        int row22=jTable6.getSelectedRow();
        String cell22=jTable6.getModel().getValueAt(row22, 5).toString();
        jLabel49.setText(cell22+":");
        
        jLabel40.setText("Name : ");jLabel41.setText(jLabel39.getText());
        jLabel42.setText("Range : ");jLabel44.setText(" - ");jLabel46.setText(jLabel52.getText()+" Units");
        
        int row31=jTable7.getSelectedRow();
        String cell31=jTable7.getModel().getValueAt(row31, 2).toString();
        jLabel43.setText(cell31);
        int row32=jTable7.getSelectedRow();
        String cell32=jTable7.getModel().getValueAt(row32, 3).toString();
        jLabel45.setText(cell32);
        
        
        
        String mi = jLabel50.getText();String ma = jLabel51.getText();
        int foo1 = Integer.parseInt(mi);int foo3 = Integer.parseInt(ma);
        if(foo3<foo1){int a=foo1-foo3;jLabel55.setText("Decreased by ");String aa=String.valueOf(a);jLabel56.setText(aa); jLabel57.setText("-"); jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Down.gif")));jLabel62.setText("There is ");jLabel63.setText("Decrement with ");jLabel64.setText("last report"); }
        else if(foo3>foo1){int b=foo3-foo1;jLabel55.setText("Increased by ");String bb=String.valueOf(b);jLabel56.setText(bb); jLabel57.setText("+");jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Up.gif")));jLabel62.setText("There is ");jLabel63.setText("Increment with ");jLabel64.setText("last report"); }
        else{jLabel55.setText("No Change");jLabel56.setText("0"); jLabel57.setText("0");jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Nil2.png")));jLabel62.setText("There report");jLabel63.setText("is same as ");jLabel64.setText("last report"); }
        
        
        
        String mi1 = jLabel43.getText();String ma1 = jLabel45.getText();String re = jLabel51.getText();
        int foo11 = Integer.parseInt(mi1);int foo22 = Integer.parseInt(ma1);int foo33 = Integer.parseInt(re);
        if(foo33<foo11){jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Down.gif")));jLabel59.setText("Patient shows low");jLabel58.setText(""+jLabel41.getText()+"");jLabel60.setText( " level as ");jLabel61.setText("'"+jLabel51.getText()+"'");}
        else if(foo33>foo22){jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Down.gif")));jLabel59.setText("Patient shows High");jLabel58.setText(""+jLabel41.getText()+"");jLabel60.setText( " level as ");jLabel61.setText("'"+jLabel51.getText()+"'");}
        else{jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Lab/Nil.gif")));jLabel59.setText("Patient shows High");jLabel58.setText(""+jLabel41.getText()+"");jLabel60.setText( " level as ");jLabel61.setText("'"+jLabel51.getText()+"'");}
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String sid=txtsid5.getText();
        String sql="select P_UserName,P_FirstName,P_LastName,P_Address,P_Mobile,P_Symptoms,P_dateAdmit from patient where P_UserName=?";
        try {String ue,fe,le,hm,mi,dg,dm;
            pt=con.prepareStatement(sql);
        pt.setString(1, sid);
        rs=pt.executeQuery();
        if(rs.next()){ue=rs.getString(1);fe=rs.getString(2);
        le=rs.getString(3);
       hm=rs.getString(4);mi=rs.getString(5);dg=rs.getString(6);
        dm=rs.getString(7);
         jLabel81.setText(ue);jLabel78.setText(fe+" "+le);jLabel80.setText(hm);jLabel79.setText(mi);jLabel83.setText(dg);jLabel69.setText(dm);
         jLabel86.setText(jLabel39.getText());
         jLabel88.setText(jLabel43.getText());
         jLabel97.setText(jLabel45.getText());
         jLabel96.setText(jLabel46.getText());
         jLabel92.setText(jLabel51.getText());
         
         jTextArea1.setText("\t\tPatient suffered from "+dg+". The lab reports shows,\n that is  "+jLabel39.getText()+ " result as "+jLabel92.getText()+". The Patient is diagnosed and treated well \nby "+na+" "+la+",  of the hospital. The medications are prescribed for the patient.");
        }
         }catch (SQLException e)  {JOptionPane.showMessageDialog(null, e);}
       dasBoardDoctor_Tabbed.setSelectedIndex(11);
        dischargeDate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(1.109,1.53);

                printdis.print(g2);

                return Printable.PAGE_EXISTS;

            }
        });
        boolean ok = job.printDialog();
        if(ok){
            try{

                job.print();
            }
            catch (PrinterException ex){
                ex.printStackTrace();
            }
        }

       
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(doctorDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(doctorDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(doctorDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(doctorDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new doctorDashBoard_Frame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PatientDoctor_Label;
    private javax.swing.JPanel PatientRecord_Panel;
    private javax.swing.JPanel YourAppoinments_Panel;
    private javax.swing.JLabel aboutUs_Label;
    private javax.swing.JTextField address1;
    private javax.swing.JLabel appionment_Label;
    private javax.swing.JLabel appionment_Label1;
    private javax.swing.JLabel appionment_Label2;
    private javax.swing.JPanel appoinmentsDoctor_Panel;
    private javax.swing.JPanel appoinmentsForYou_Panel;
    private javax.swing.JButton btnsearch1;
    private javax.swing.JLabel close_Label;
    private javax.swing.JLabel contactUs_Label;
    private javax.swing.JTabbedPane dasBoardDoctor_Tabbed;
    private javax.swing.JPanel dashBoardDoctor_Panel;
    private javax.swing.JLabel dashboardDoctor_Label;
    private javax.swing.JPanel deleteAppoinment_Panel;
    private javax.swing.JPanel deleteYourAppoinments_Panel;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JPanel dischargePanel;
    private javax.swing.JPanel dischargedPatient_Panel;
    private javax.swing.JLabel doc1;
    private javax.swing.JLabel doc2;
    private javax.swing.JLabel doc3;
    private javax.swing.JLabel doctor;
    private javax.swing.JPanel doctorDashBoardFooter;
    private javax.swing.JPanel doctorDashBoardHeader;
    private javax.swing.JPanel doctorProfile;
    private javax.swing.JPanel doctorProfilePic_Panel;
    private javax.swing.JLabel doctortName;
    private javax.swing.JLabel doctortPic;
    private javax.swing.JTextField firstname1;
    private javax.swing.JLabel goBack_Label;
    private javax.swing.JLabel hospital;
    private javax.swing.JLabel hospitalIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField lastname1;
    private javax.swing.JLabel minimize_Label;
    private javax.swing.JTextField mobile1;
    private javax.swing.JPanel patientDoctor_Panel;
    private javax.swing.JPanel patientUnderYou_Panel;
    private javax.swing.JPanel printdis;
    private javax.swing.JLabel registerForm_Label1;
    private javax.swing.JButton registerPatient_Button1;
    private javax.swing.JButton registerPatient_Button2;
    private javax.swing.JLabel totDOC;
    private javax.swing.JLabel totDOC1;
    private javax.swing.JLabel totDOC2;
    private javax.swing.JLabel totDOC3;
    private javax.swing.JLabel totDoc_Icon;
    private javax.swing.JLabel totDoc_Icon1;
    private javax.swing.JLabel totDoc_Icon2;
    private javax.swing.JTextField txtsid5;
    private javax.swing.JPanel viewappoinment_Panel;
    private javax.swing.JPanel yourDischargedPatientRecord;
    private javax.swing.JPanel yourPatientDischarged_Panel;
    private javax.swing.JPanel yourPatientRecord_Panel;
    // End of variables declaration//GEN-END:variables
}
