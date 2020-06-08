package pro1041_qltc;

import DAO.nguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class FormTrangChinh extends javax.swing.JInternalFrame {

    Connection con;
    String nguoiDung;

    public FormTrangChinh(Connection con) {
        initComponents();
        this.con = con;
        LoadData();
    }

//    public void LoadLabel(){
//        
//    }
    public void LoadData() {
        try {

            nguoiDung nd = new nguoiDung();
            PreparedStatement ps = con.prepareStatement("Select * from NGUOIDUNG");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nd.setTenNguoiDung(rs.getString(1));
                nd.setSoTien(rs.getInt(2));
            }
            nguoiDung = nd.getTenNguoiDung();
            lblTen.setText(nd.getTenNguoiDung());
            lblSoDu.setText(format(Integer.toString(nd.getSoTien())) + " VNĐ");
            
            PreparedStatement ps1 = con.prepareStatement("Select tenhu, soTien from LUCHU");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                if (rs1.getString("tenhu").equals("Thiet yeu")) {
                    lblThietYeu.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
                if (rs1.getString("tenhu").equals("Giao duc")) {
                    lblGiaoDuc.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
                if (rs1.getString("tenhu").equals("Huong thu")) {
                    lblHuongThu.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
                if (rs1.getString("tenhu").equals("Tiet kiem dai han")) {
                    lblTKDH.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
                if (rs1.getString("tenhu").equals("Tu do tai chinh")) {
                    lblTDTC.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
                if (rs1.getString("tenhu").equals("Tu thien")) {
                    lblTuThien.setText(format(Integer.toString(rs1.getInt("sotien"))) + " VNĐ");
                }
            }

            String cols[] = {"ID", "Tên giao dịch", "Số tiền", "Ngày", "Loại giao dịch", "Tên nguồn", "Tên hũ", "Ghi chú"};
            DefaultTableModel tableModel = new DefaultTableModel(cols, 0);
            PreparedStatement ps2 = con.prepareStatement("Select id, ten, sotien, ngay,loai, Thuchi.tennguon, tenhu, "
                    + "ghichu from THUCHI join NGUONTIEN on THUCHI.tennguon = NGUONTIEN.tennguon");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                Vector v = new Vector();
                v.add(rs2.getInt("id"));
                v.add(rs2.getString("ten"));
                v.add(format(rs2.getString("sotien")) + " VNĐ");
                v.add(rs2.getString("ngay"));
                v.add(rs2.getString("loai"));
                v.add(rs2.getString("tennguon"));
                v.add(rs2.getString("tenhu"));
                v.add(rs2.getString("ghichu"));
                tableModel.addRow(v);
            }
            tblHienThi.setModel(tableModel);
            PreparedStatement ps3 = con.prepareStatement("select sum(sotien)\n"
                    + "from THUCHI join NGUONTIEN on THUCHI.tennguon = NGUONTIEN.tennguon\n"
                    + "where loai= 'thu'");
            ResultSet rs3 = ps3.executeQuery();
            int tongThu = 0;
            while (rs3.next()) {
                tongThu = rs3.getInt(1);
            }

            if(tongThu == 0){
                lblTongThu.setText("0 VNĐ");
            }
            else{
            lblTongThu.setText(format(Integer.toString(tongThu)) + " VNĐ");
            }
            PreparedStatement ps4 = con.prepareStatement("select sum(sotien)\n"
                    + "from THUCHI join NGUONTIEN on THUCHI.tennguon = NGUONTIEN.tennguon\n"
                    + "where loai= 'chi'");
            ResultSet rs4 = ps4.executeQuery();
            int tongChi = 0;
            while (rs4.next()) {
                tongChi = rs4.getInt(1);
            }
            if(tongChi == 0){
                lblTongChi.setText("0 VNĐ");
            }
            else{
            lblTongChi.setText(format(Integer.toString(tongChi)) + " VNĐ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn cơ sở dữ liệu: " + ex);
        }
    }

    public String format(String soTien) {
        String afterFormat = null;
        switch (soTien.length()) {           
            case 4:
                afterFormat = soTien.substring(0, 1)  + "," + soTien.substring(1, 4);break;
            case 5:
                afterFormat = soTien.substring(0, 2) + "," + soTien.substring(2, 5);break;
            case 6:
                afterFormat = soTien.substring(0, 3) + "," + soTien.substring(3, 6);break;
            case 7:
                afterFormat = soTien.substring(0, 1) + "," + soTien.substring(1, 4) + "," + soTien.substring(4, 7);break;
            case 8:
                afterFormat = soTien.substring(0, 2) + "," + soTien.substring(2, 5) + "," + soTien.substring(5, 8);break;
            case 9:
                afterFormat = soTien.substring(0, 3) + "," + soTien.substring(3, 6) + "," + soTien.substring(6, 9);break;
            case 10:
                afterFormat = soTien.substring(0, 1) + "," + soTien.substring(1, 4) + "," + soTien.substring(4, 7) + "," + soTien.substring(7, 10);break;
            case 11:
                afterFormat = soTien.substring(0, 2) + "," + soTien.substring(2, 5) + "," + soTien.substring(5, 8) + "," + soTien.substring(8, 11);break;
            case 12:
                afterFormat = soTien.substring(0, 3) + "," + soTien.substring(3, 6) + "," + soTien.substring(6, 9) + "," + soTien.substring(9, 12);break;
        }
        return afterFormat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTongThu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSoDu = new javax.swing.JLabel();
        lblTongChi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThietYeu = new javax.swing.JButton();
        lblThietYeu = new javax.swing.JLabel();
        btnGiaoDuc = new javax.swing.JButton();
        lblGiaoDuc = new javax.swing.JLabel();
        btnHuongThu = new javax.swing.JButton();
        lblHuongThu = new javax.swing.JLabel();
        btnTKDH = new javax.swing.JButton();
        lblTKDH = new javax.swing.JLabel();
        btnTDTC = new javax.swing.JButton();
        lblTDTC = new javax.swing.JLabel();
        btnTuThien = new javax.swing.JButton();
        lblTuThien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHienThi = new javax.swing.JTable();
        lblTen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Tống thu:");

        lblTongThu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTongThu.setText("0 VNĐ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tống chi:");

        lblSoDu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSoDu.setText("0 VNĐ");

        lblTongChi.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTongChi.setText("0 VNĐ");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Số dư:");

        btnThietYeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/ty.jpg"))); // NOI18N
        btnThietYeu.setText("jButton2");
        btnThietYeu.setAutoscrolls(true);
        btnThietYeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietYeuActionPerformed(evt);
            }
        });

        lblThietYeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThietYeu.setText("0 VNĐ");
        lblThietYeu.setToolTipText("");

        btnGiaoDuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/gd.jpg"))); // NOI18N
        btnGiaoDuc.setText("jButton2");
        btnGiaoDuc.setAutoscrolls(true);
        btnGiaoDuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoDucActionPerformed(evt);
            }
        });

        lblGiaoDuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGiaoDuc.setText("0 VNĐ");

        btnHuongThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/ht.jpg"))); // NOI18N
        btnHuongThu.setText("jButton2");
        btnHuongThu.setAutoscrolls(true);
        btnHuongThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongThuActionPerformed(evt);
            }
        });

        lblHuongThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuongThu.setText("0 VNĐ");

        btnTKDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/tkdh.jpg"))); // NOI18N
        btnTKDH.setText("jButton2");
        btnTKDH.setAutoscrolls(true);
        btnTKDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKDHActionPerformed(evt);
            }
        });

        lblTKDH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTKDH.setText("0 VNĐ");

        btnTDTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/tdtc.jpg"))); // NOI18N
        btnTDTC.setText("jButton2");
        btnTDTC.setAutoscrolls(true);
        btnTDTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTDTCActionPerformed(evt);
            }
        });

        lblTDTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTDTC.setText("0 VNĐ");

        btnTuThien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/tt.jpg"))); // NOI18N
        btnTuThien.setText("jButton2");
        btnTuThien.setAutoscrolls(true);
        btnTuThien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuThienActionPerformed(evt);
            }
        });

        lblTuThien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTuThien.setText("0 VNĐ");

        tblHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên giao dịch", "Số tiền", "Loại", "Nguồn", "Hũ", "Ngày"
            }
        ));
        jScrollPane1.setViewportView(tblHienThi);

        lblTen.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTen.setForeground(new java.awt.Color(255, 0, 51));
        lblTen.setText("abc");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Chào mừng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 150, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnThietYeu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThietYeu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHuongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHuongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTKDH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTKDH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTuThien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTuThien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblTen)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTongThu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(334, 334, 334))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTen)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTongThu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTongChi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSoDu))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThietYeu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblThietYeu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGiaoDuc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHuongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHuongThu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTKDH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTKDH))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTDTC))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTuThien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTuThien)))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThietYeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietYeuActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Thiet yeu");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnThietYeuActionPerformed

    private void btnGiaoDucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoDucActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Giao duc");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnGiaoDucActionPerformed

    private void btnHuongThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongThuActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Huong thu");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnHuongThuActionPerformed

    private void btnTKDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKDHActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Tiet kiem dai han");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnTKDHActionPerformed

    private void btnTDTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTDTCActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Tu do tai chinh");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnTDTCActionPerformed

    private void btnTuThienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuThienActionPerformed
        FormQLCT f = new FormQLCT(nguoiDung, con);
        f.chonHu("Tu thien");
        DuAn1.me.jDesktopPane1.add(f);
        f.show();
    }//GEN-LAST:event_btnTuThienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaoDuc;
    private javax.swing.JButton btnHuongThu;
    private javax.swing.JButton btnTDTC;
    private javax.swing.JButton btnTKDH;
    private javax.swing.JButton btnThietYeu;
    private javax.swing.JButton btnTuThien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGiaoDuc;
    private javax.swing.JLabel lblHuongThu;
    private javax.swing.JLabel lblSoDu;
    private javax.swing.JLabel lblTDTC;
    private javax.swing.JLabel lblTKDH;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThietYeu;
    private javax.swing.JLabel lblTongChi;
    private javax.swing.JLabel lblTongThu;
    private javax.swing.JLabel lblTuThien;
    private javax.swing.JTable tblHienThi;
    // End of variables declaration//GEN-END:variables
}
