/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ELECTIONS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Anusha
 */
public class polling extends javax.swing.JFrame {

    public polling() {
        initComponents();
        GetElections();
        DisplayVoters();
    }
 Connection myCon = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;
    private void GetElections()
    {
         try {
           myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/electiondb", "root", "nush2830"); 
           St = myCon.createStatement();
           Rs = St.executeQuery("Select * from electiontb");
            while(Rs.next())
            {
                String ElectId = Rs.getString("Eid");
                VElectionCb.addItem(ElectId);
            }
         } catch (SQLException e){
             
         }
    }
    public void Displaypolling()
       {
            try {
           myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/electiondb", "root", "nush2830"); 
           St = myCon.createStatement();
           Rs = St.executeQuery("Select * from votertb");
           VotersTable.setModel(DbUtils.resultSetToTableModel(Rs));
}catch(SQLException e){
   System.out.print(e);
}
       }
    int VId;
    Statement St1 = null;
    ResultSet Rs1 = null;
    private void VoterCount()
     {
       try {
         St1 = myCon.createStatement();
         Rs1 = St1.executeQuery("select MAx(VId) from votertb");
         Rs1.next();
         VId = Rs1.getInt(1)+1;
            } catch(Exception Ex)
              {
                System.out.print(Ex);
              }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        VNameTb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VotersTable = new javax.swing.JTable();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        VAgeTb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        VGenderCb = new javax.swing.JComboBox<>();
        VElectionCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        VPassTb = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 255));
        jLabel1.setText("                                 CAST YOUR VOTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(204, 204, 204)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
                    .addGap(204, 204, 204)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel1)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 255));
        jLabel2.setText("           Manage Voters");

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 255));
        jLabel3.setText("Name");

        VNameTb.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        VNameTb.setForeground(new java.awt.Color(102, 102, 255));
        VNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VNameTbActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 255));
        jLabel4.setText("Age");

        VotersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "VId", "VName", "VAge", "VElection", "VGen", "VPass"
            }
        ));
        VotersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VotersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(VotersTable);
        if (VotersTable.getColumnModel().getColumnCount() > 0) {
            VotersTable.getColumnModel().getColumn(4).setResizable(false);
            VotersTable.getColumnModel().getColumn(5).setResizable(false);
        }

        AddBtn.setBackground(new java.awt.Color(255, 255, 255));
        AddBtn.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(153, 102, 255));
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        EditBtn.setBackground(new java.awt.Color(255, 255, 255));
        EditBtn.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(153, 102, 255));
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(153, 102, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        BackBtn.setBackground(new java.awt.Color(255, 255, 255));
        BackBtn.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(153, 102, 255));
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        VAgeTb.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        VAgeTb.setForeground(new java.awt.Color(102, 102, 255));
        VAgeTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VAgeTbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 102, 255));
        jLabel5.setText("Gender");

        VGenderCb.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        VGenderCb.setForeground(new java.awt.Color(153, 102, 255));
        VGenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " ", " " }));
        VGenderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VGenderCbActionPerformed(evt);
            }
        });

        VElectionCb.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        VElectionCb.setForeground(new java.awt.Color(102, 102, 255));
        VElectionCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        VElectionCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VElectionCbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 255));
        jLabel6.setText("Elections");

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 102, 255));
        jLabel7.setText("Password");

        VPassTb.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        VPassTb.setForeground(new java.awt.Color(102, 102, 255));
        VPassTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPassTbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VElectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(VNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(VAgeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(VGenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VPassTb, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddBtn)
                        .addGap(63, 63, 63)
                        .addComponent(EditBtn)
                        .addGap(52, 52, 52)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VAgeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(VNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(VGenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VElectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(VPassTb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn)
                            .addComponent(EditBtn)
                            .addComponent(DeleteBtn))
                        .addGap(37, 37, 37)
                        .addComponent(BackBtn)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 136, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VNameTbActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
          if(VAgeTb.getText().isEmpty() || VNameTb.getText().isEmpty() || VElectionCb.getSelectedIndex()==-1 || VGenderCb.getSelectedIndex()==-1)
        {
           JOptionPane.showMessageDialog(this, "Missing Information");
        } else 
        {
           
          try{
          VoterCount();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/electiondb", "root", "nush2830"); 
            PreparedStatement Add = myCon.prepareStatement("insert into votertb values(?,?,?,?,?,?)");
            Add.setInt(1,VId);
            Add.setString(2,VNameTb.getText());
            Add.setInt(3,Integer.valueOf(VAgeTb.getText()));
            Add.setString(4,VPassTb.getText());
            Add.setString(5, VGenderCb.getSelectedItem().toString());
            Add.setInt(6, Integer.valueOf(VElectionCb.getSelectedItem().toString()));
            int row = Add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Voter Registered");
            myCon.close();
            Displaypolling();
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        if(VAgeTb.getText().isEmpty() || VNameTb.getText().isEmpty() || VElectionCb.getSelectedIndex()==-1 || VGenderCb.getSelectedIndex()==-1)
       {
           JOptionPane.showMessageDialog(this, "Missing Information");
       } else {
          try {
              
          
              myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/electiondb", "root", "nush2830");  
              String Query = "Update votertb set VName=?,VAge=?, VPass=?,VGender=?,VElection=? where VId=?";
              
             PreparedStatement UpdateQuery = myCon.prepareStatement(Query);
             UpdateQuery.setString(1, VNameTb.getText());
             UpdateQuery.setInt(2,Integer.valueOf(VAgeTb.getText()));
             UpdateQuery.setString(3, VPassTb.getText());
             UpdateQuery.setString(4, VGenderCb.getSelectedItem().toString());
             UpdateQuery.setInt(5, Integer.valueOf(VElectionCb.getSelectedItem().toString()));
             UpdateQuery.setInt(6, Key);
             UpdateQuery.executeUpdate();
              //UpdateQuery.executeUpdate(Query);
              JOptionPane.showMessageDialog(this, "Voter Updated Succesfully");
              Displaypolling();
           } catch (Exception e){
               JOptionPane.showMessageDialog(this, e);
           }
          }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
if(Key == -1 )
       {
           JOptionPane.showMessageDialog(this, "Select The Voter To Be Deleted");
       } else 
           {
           try {
              myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/electiondb", "root", "nush2830");  
              String Query = "Delete from votertb where VId ="+Key;
              Statement Del = myCon.createStatement();
              Del.executeUpdate(Query);
              JOptionPane.showMessageDialog(this, "Voter Deleted Succesfully");
              Displaypolling();
           } catch (Exception e)
           {
                JOptionPane.showMessageDialog(this, e);
           }
           }

    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
     new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void VAgeTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VAgeTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VAgeTbActionPerformed

    private void VGenderCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VGenderCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VGenderCbActionPerformed

    private void VElectionCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VElectionCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VElectionCbActionPerformed

    private void VPassTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VPassTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VPassTbActionPerformed
    int Key = -1;
    private void VotersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VotersTableMouseClicked
         DefaultTableModel model = (DefaultTableModel)VotersTable.getModel();  
      int MyIndex = VotersTable.getSelectedRow();
       Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
       VNameTb.setText(model.getValueAt(MyIndex, 1).toString());
       VAgeTb.setText(model.getValueAt(MyIndex, 2).toString());
       VPassTb.setText(model.getValueAt(MyIndex, 3).toString());
       VGenderCb.setSelectedItem(model.getValueAt(MyIndex, 4).toString());
       VElectionCb.setSelectedItem(model.getValueAt(MyIndex, 5).toString());
    
    }//GEN-LAST:event_VotersTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(polling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(polling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(polling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(polling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new polling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField VAgeTb;
    private javax.swing.JComboBox<String> VElectionCb;
    private javax.swing.JComboBox<String> VGenderCb;
    private javax.swing.JTextField VNameTb;
    private javax.swing.JTextField VPassTb;
    private javax.swing.JTable VotersTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void DisplayVoters() {
       
    }
}
