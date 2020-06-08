/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro1041_qltc;

import KetNoiNhanh.Faster;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Pham Thanh
 */
public class FormThongKe extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormThongKe
     */
    Connection cn = null;
    String ngaydau,ngaycuoi;
    SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
    public FormThongKe(Connection cn) {
        initComponents();
        this.cn = cn;
        if(cn==null){
            JOptionPane.showMessageDialog(this, "Lỗi kết nối");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        pnBieuDoChi = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnBieuDoThu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        tbpChon = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pngd2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        dcsNgayCuoi = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dcsNgayDau = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        pngd3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        ycsNam = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        pngd4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        ycsNam1 = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Thống kê");

        pnBieuDoChi.setPreferredSize(new java.awt.Dimension(400, 320));

        javax.swing.GroupLayout pnBieuDoChiLayout = new javax.swing.GroupLayout(pnBieuDoChi);
        pnBieuDoChi.setLayout(pnBieuDoChiLayout);
        pnBieuDoChiLayout.setHorizontalGroup(
            pnBieuDoChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnBieuDoChiLayout.setVerticalGroup(
            pnBieuDoChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Thống kê thu");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Thống kê chi");

        pnBieuDoThu.setPreferredSize(new java.awt.Dimension(400, 320));

        javax.swing.GroupLayout pnBieuDoThuLayout = new javax.swing.GroupLayout(pnBieuDoThu);
        pnBieuDoThu.setLayout(pnBieuDoThuLayout);
        pnBieuDoThuLayout.setHorizontalGroup(
            pnBieuDoThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnBieuDoThuLayout.setVerticalGroup(
            pnBieuDoThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pngd2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Đến");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Từ");

        javax.swing.GroupLayout pngd2Layout = new javax.swing.GroupLayout(pngd2);
        pngd2.setLayout(pngd2Layout);
        pngd2Layout.setHorizontalGroup(
            pngd2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dcsNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcsNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pngd2Layout.setVerticalGroup(
            pngd2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pngd2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pngd2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dcsNgayDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dcsNgayCuoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(pngd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(pngd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tbpChon.addTab("Giai đoạn", jPanel2);

        pngd3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Năm");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Tháng");

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pngd3Layout = new javax.swing.GroupLayout(pngd3);
        pngd3.setLayout(pngd3Layout);
        pngd3Layout.setHorizontalGroup(
            pngd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ycsNam, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pngd3Layout.setVerticalGroup(
            pngd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pngd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pngd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pngd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ycsNam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(pngd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(pngd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tbpChon.addTab("Tháng", jPanel3);

        pngd4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Năm");

        javax.swing.GroupLayout pngd4Layout = new javax.swing.GroupLayout(pngd4);
        pngd4.setLayout(pngd4Layout);
        pngd4Layout.setHorizontalGroup(
            pngd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ycsNam1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        pngd4Layout.setVerticalGroup(
            pngd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngd4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pngd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(ycsNam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(pngd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(pngd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tbpChon.addTab("Năm", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(tbpChon)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel5)
                        .addGap(371, 371, 371)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(pnBieuDoThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(pnBieuDoChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(tbpChon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnBieuDoChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBieuDoThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tbpChon.getSelectedIndex()==0){
            ngaydau = date.format(dcsNgayDau.getDate());
            ngaycuoi = date.format(dcsNgayCuoi.getDate());
            JOptionPane.showMessageDialog(this, "Ngày đầu là : " + ngaydau + " Ngày cuối là : " + ngaycuoi);
        }
        else if(tbpChon.getSelectedIndex()==1){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, Integer.parseInt((String)cboThang.getSelectedItem())-1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt((String)cboThang.getSelectedItem())-1);
            cal.set(Calendar.YEAR, ycsNam.getYear());
            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            ngaydau = cboThang.getSelectedItem()+"/1/"+ycsNam.getYear();
            ngaycuoi = cboThang.getSelectedItem()+"/"+maxDay+"/"+ycsNam.getYear();
            JOptionPane.showMessageDialog(this, "Đang đầu là : " + ngaydau + " Ngày cuối là : " + ngaycuoi);
        }
        else if(tbpChon.getSelectedIndex()==2){
            ngaydau = "1/1/"+ycsNam1.getYear();
            ngaycuoi = "12/31/"+ycsNam1.getYear();
            JOptionPane.showMessageDialog(this, "Đang đầu là : " + ngaydau + " Ngày cuối là : " + ngaycuoi);
        }
        else{
            JOptionPane.showMessageDialog(this, "Đang chọn khác");
        }
        ThongKeThu();
        ThongKeChi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboThang;
    private com.toedter.calendar.JDateChooser dcsNgayCuoi;
    private com.toedter.calendar.JDateChooser dcsNgayDau;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnBieuDoChi;
    private javax.swing.JPanel pnBieuDoThu;
    private javax.swing.JPanel pngd2;
    private javax.swing.JPanel pngd3;
    private javax.swing.JPanel pngd4;
    private javax.swing.JTabbedPane tbpChon;
    private com.toedter.calendar.JYearChooser ycsNam;
    private com.toedter.calendar.JYearChooser ycsNam1;
    // End of variables declaration//GEN-END:variables

    private static JFreeChart createPieChartThu(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ thống kê thu nhập".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }
    private static JFreeChart createPieChartChi(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ thống kê chi tiêu".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }
    private void ThongKeThu() {
        Statement stm = null;
        ResultSet rs = null;
        Vector vt = new Vector();
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            stm = cn.createStatement();
            String sql = "SELECT * FROM NGUONTIEN WHERE loai LIKE '%Thu%'";
            rs = stm.executeQuery(sql);
            int m = 0;
//            JOptionPane.showMessageDialog(this, vt.capacity());
            while(rs.next()){
//                JOptionPane.showMessageDialog(this, "Lỗi ở đây");
                String nguon = rs.getString("tennguon");
                vt.add(nguon);
                m++;
            }
            Enumeration<String> a = vt.elements();
            while(a.hasMoreElements()){
                String b = a.nextElement();
//                JOptionPane.showMessageDialog(this, b);
                String sql1 = "SELECT SUM(sotien) FROM THUCHI WHERE tennguon LIKE '%"+b+"%' AND ngay BETWEEN '"+ngaydau+"' AND '"+ngaycuoi+"'";
                rs = stm.executeQuery(sql1);
                while(rs.next()){
                    dataset.setValue(b, new Double(rs.getInt(1)));
                }
            }
            JFreeChart pieChart = createPieChartThu(dataset);
            ChartPanel chartPanel = new ChartPanel(pieChart);
            pnBieuDoThu.removeAll();
            pnBieuDoThu.add(chartPanel);
            chartPanel.setSize(400, 310);
            chartPanel.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load " + e);
        }
        finally{
            try {
                stm.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi đóng " + e);
            }
        }
    }
    private void ThongKeChi() {
        Statement stm = null;
        ResultSet rs = null;
        Vector vt = new Vector();
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            stm = cn.createStatement();
            String sql = "SELECT * FROM NGUONTIEN WHERE loai LIKE '%Chi%'";
            rs = stm.executeQuery(sql);
            int m = 0;
//            JOptionPane.showMessageDialog(this, vt.capacity());
            while(rs.next()){
//                JOptionPane.showMessageDialog(this, "Lỗi ở đây");
                String nguon = rs.getString("tennguon");
                vt.add(nguon);
                m++;
            }
            Enumeration<String> a = vt.elements();
            while(a.hasMoreElements()){
                String b = a.nextElement();
//                JOptionPane.showMessageDialog(this, b);
                String sql1 = "SELECT SUM(sotien) FROM THUCHI WHERE tennguon LIKE '%"+b+"%' AND ngay BETWEEN '"+ngaydau+"' AND '"+ngaycuoi+"'";
                rs = stm.executeQuery(sql1);
                while(rs.next()){
                    dataset.setValue(b, new Double(rs.getInt(1)));
                }
            }
            JFreeChart pieChart = createPieChartChi(dataset);
            ChartPanel chartPanel = new ChartPanel(pieChart);
            pnBieuDoChi.removeAll();
            pnBieuDoChi.add(chartPanel);
            chartPanel.setSize(400, 310);
            chartPanel.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load " + e);
        }
        finally{
            try {
                stm.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi đóng " + e);
            }
        }
    }
}

