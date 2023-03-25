

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Bassant Haider
 */
public class SupplierForm extends javax.swing.JFrame {

    /**
     * Creates new form SupplierForm
     */
    public SupplierForm() {
        initComponents();
       table_show();
    }
    Connection con1;
    PreparedStatement pst;
    int sid; 
    String sfname ;
    String location ;
    int stel;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sidtxt = new javax.swing.JTextField();
        sfnametxt = new javax.swing.JTextField();
        locationtxt = new javax.swing.JTextField();
        steltxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplier = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supplier Manager");

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Meiryo", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Supplier Manager");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -23, 860, 100));

        jLabel1.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Suppliers List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 140, -1));

        jLabel2.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("S.ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 90, -1));

        jLabel7.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("S.TEL :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 79, -1));

        jLabel6.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Full Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Location :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 79, -1));

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 80, 30));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 80, 30));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 80, 30));

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 80, 30));

        jLabel3.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Supplier Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 224, -1));
        jPanel1.add(sidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 170, -1));
        jPanel1.add(sfnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 170, -1));
        jPanel1.add(locationtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 170, -1));

        steltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steltxtActionPerformed(evt);
            }
        });
        jPanel1.add(steltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 170, -1));

        supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.id", "fullname", "location", "S.tel"
            }
        ));
        supplier.setGridColor(new java.awt.Color(51, 153, 255));
        supplier.setShowGrid(true);
        supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(supplier);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 167, -1, 280));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-home-page-30.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Meiryo", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("HOME");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
     private void table_show() {
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory ", "root", "");
            pst = con1.prepareStatement("select * from supplier");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel)supplier.getModel();
            d.setRowCount(0);

            //Vector V2 = new Vector();
            while (rs.next()) {
                Vector V2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    V2.add(rs.getInt("supplier_id"));
                    V2.add(rs.getString("supplier_name"));
                    V2.add(rs.getString("location"));
                    V2.add(rs.getString("telephone"));
                }
                d.addRow(V2);
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CostumerForm.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(CostumerForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel d1 = (DefaultTableModel) supplier.getModel();
        int SelectedIndex = supplier.getSelectedRow();
        sid = Integer.parseInt(d1.getValueAt(SelectedIndex, 0).toString());
        sfname= sfnametxt.getText();
        location=locationtxt.getText();
        stel =Integer.parseInt(steltxt.getText());
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory ", "root", "");
            pst = con1.prepareStatement(" update supplier set supplier_name=?,location=?,telephone=? where supplier_id=?");
            pst.setInt(1, sid);
            pst.setString(2, sfname);
            pst.setString(3, location);
            pst.setInt(4, stel);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "supplier Updated");
            table_show();
            sidtxt.setText("");
            sfnametxt.setText("");
            locationtxt.setText("");
            steltxt.setText("");
            sidtxt.requestFocus();

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        DefaultTableModel d1 = (DefaultTableModel) supplier.getModel();
        int SelectedIndex = supplier.getSelectedRow();
        sid = Integer.parseInt(d1.getValueAt(SelectedIndex, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete item", "warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory ", "root", "");
                pst = con1.prepareStatement("DELETE FROM supplier where supplier_id=? ");
                pst.setInt(1, sid);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "supplier deleted ");
                table_show();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sid=Integer.parseInt(sidtxt.getText());
        sfname= sfnametxt.getText();
        location=locationtxt.getText();
        stel =Integer.parseInt(steltxt.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory ", "root", "");
            pst = con1.prepareStatement("insert into supplier(supplier_id,supplier_name,location,telephone)values(?,?,?,?)");
            pst.setInt(1, sid);
            pst.setString(2, sfname);
            pst.setString(3, location);
            pst.setInt(4, stel);
            pst.executeUpdate();
            //DefaultTableModel tblModel =(DefaultTableModel)supplier.getModel();
            JOptionPane.showMessageDialog(null, "supplier ADDED");
            table_show();
             sidtxt.setText("");
            sfnametxt.setText("");
            locationtxt.setText("");
            steltxt.setText("");
            sidtxt.requestFocus();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        sidtxt.setText("");
        sfnametxt.setText("");
        locationtxt.setText("");
        steltxt.setText("");
        sidtxt.requestFocus();

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void steltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steltxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_steltxtActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseClicked
        DefaultTableModel d1 = (DefaultTableModel)supplier.getModel();
        int selectIndex = supplier.getSelectedRow();
        sidtxt.setText(d1.getValueAt(selectIndex, 0).toString());
        sfnametxt.setText(d1.getValueAt(selectIndex, 1).toString());
        locationtxt.setText(d1.getValueAt(selectIndex, 2).toString());
        steltxt.setText(d1.getValueAt(selectIndex, 3).toString());
    }//GEN-LAST:event_supplierMouseClicked

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
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SupplierForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField locationtxt;
    private javax.swing.JTextField sfnametxt;
    private javax.swing.JTextField sidtxt;
    private javax.swing.JTextField steltxt;
    private javax.swing.JTable supplier;
    // End of variables declaration//GEN-END:variables
}