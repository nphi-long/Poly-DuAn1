package pro1041_qltc;


import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DuAn1 extends javax.swing.JFrame {   
    public static DuAn1 me;
    static Connection con = null;
    
    public DuAn1() {
        initComponents();
        me = this;
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("Phần mềm quản lí thu chi");
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTaiKhoan = new javax.swing.JMenu();
        jMenuTrangChinh = new javax.swing.JMenuItem();
        jMenuThongke = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuThoat = new javax.swing.JMenuItem();
        jMenuQuanLi = new javax.swing.JMenu();
        jMenuQLTN = new javax.swing.JMenuItem();
        jMenuQLCT = new javax.swing.JMenuItem();
        jMenuGioiThieu = new javax.swing.JMenu();
        jMenuVCT = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1575, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );

        jMenuTaiKhoan.setText("Tài khoản");

        jMenuTrangChinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Home.png"))); // NOI18N
        jMenuTrangChinh.setText("Trang chính");
        jMenuTrangChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTrangChinhActionPerformed(evt);
            }
        });
        jMenuTaiKhoan.add(jMenuTrangChinh);

        jMenuThongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Bar chart.png"))); // NOI18N
        jMenuThongke.setText("Thống kê");
        jMenuThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuThongkeActionPerformed(evt);
            }
        });
        jMenuTaiKhoan.add(jMenuThongke);
        jMenuTaiKhoan.add(jSeparator1);

        jMenuThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Exit button.png"))); // NOI18N
        jMenuThoat.setText("Thoát");
        jMenuThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuThoatActionPerformed(evt);
            }
        });
        jMenuTaiKhoan.add(jMenuThoat);

        jMenuBar1.add(jMenuTaiKhoan);

        jMenuQuanLi.setText("Quản lí");

        jMenuQLTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Wallet.png"))); // NOI18N
        jMenuQLTN.setText("Quản lí thu nhập");
        jMenuQLTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuQLTNActionPerformed(evt);
            }
        });
        jMenuQuanLi.add(jMenuQLTN);

        jMenuQLCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Payment.png"))); // NOI18N
        jMenuQLCT.setText("Quản lí chi tiêu");
        jMenuQLCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuQLCTActionPerformed(evt);
            }
        });
        jMenuQuanLi.add(jMenuQLCT);

        jMenuBar1.add(jMenuQuanLi);

        jMenuGioiThieu.setText("Giới thiệu");

        jMenuVCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Info.png"))); // NOI18N
        jMenuVCT.setText("Về chúng tôi");
        jMenuGioiThieu.add(jMenuVCT);

        jMenuBar1.add(jMenuGioiThieu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuQLCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuQLCTActionPerformed
        try {
            String nguoidung = null;
            PreparedStatement ps = con.prepareStatement("Select * from NGUOIDUNG");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nguoidung = rs.getString(1);
            }
            FormQLCT fCon = new FormQLCT(nguoidung, con);
            jDesktopPane1.add(fCon);
            fCon.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn cơ sở dữ liệu: "+ex);
        } 

    }//GEN-LAST:event_jMenuQLCTActionPerformed

    private void jMenuThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuThoatActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Thoát chương trình",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            Window[] b = DuAn1.getWindows();
            for (int i = 0; i < b.length; i++) {
                b[i].setVisible(false);
            }
        } else {
        }
    }//GEN-LAST:event_jMenuThoatActionPerformed

    private void jMenuTrangChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTrangChinhActionPerformed
        FormTrangChinh fCon = new FormTrangChinh(con);
        jDesktopPane1.add(fCon);
        fCon.setVisible(true);
    }//GEN-LAST:event_jMenuTrangChinhActionPerformed

    private void jMenuThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuThongkeActionPerformed
        FormThongKe fCon = new FormThongKe(con);
        jDesktopPane1.add(fCon);
        fCon.setVisible(true);
    }//GEN-LAST:event_jMenuThongkeActionPerformed

    private void jMenuQLTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuQLTNActionPerformed
        FormQLTN fCon = new FormQLTN(con);
        jDesktopPane1.add(fCon);
        fCon.setVisible(true);
    }//GEN-LAST:event_jMenuQLTNActionPerformed

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
            java.util.logging.Logger.getLogger(DuAn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DuAn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DuAn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DuAn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DuAn1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGioiThieu;
    private javax.swing.JMenuItem jMenuQLCT;
    private javax.swing.JMenuItem jMenuQLTN;
    private javax.swing.JMenu jMenuQuanLi;
    private javax.swing.JMenu jMenuTaiKhoan;
    private javax.swing.JMenuItem jMenuThoat;
    private javax.swing.JMenuItem jMenuThongke;
    private javax.swing.JMenuItem jMenuTrangChinh;
    private javax.swing.JMenuItem jMenuVCT;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
