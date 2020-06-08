/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro1041_qltc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static pro1041_qltc.DuAn1.con;

/**
 *
 * @author ADMIN
 */
public class FormMeoLamGiau extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form NewJFrame
     */
    public FormMeoLamGiau() {
        initComponents();
        
        jTextArea1.setText(meoLamGiau(random()));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            jProgressBar.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormMeoLamGiau.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.setVisible(false);
        new DuAn1().setVisible(true);
    }

    public void tienTrinh() {
            Thread t = new Thread(this);
            t.start();                  
    }

    public String meoLamGiau(int i) {
        String meo[] = {"Giới hạn số tiền chi tiêu mỗi ngày dựa trên thu nhập\n"
            + "\n"
            + "Nếu muốn tiết kiệm tiền, bạn cần tiêu ít hơn 30% số tiền hôm đó kiếm được. \n"
            + "Ví dụ bạn làm ra 100.000 đồng thì chỉ tiêu dưới 30.000 đồng.",
            "Tập trung vào tính thực tế của sản phẩm\n"
            + "\n"
            + "Khi mua sắm, người quản lý tài chính giỏi không nhìn giá mà nhìn vào tính \n"
            + "hữu dụng của sản phẩm hàng ngày. Một số thứ tưởng chừng rẻ tiền nhưng chất \n"
            + "lượng kém, cuối cùng khiến bạn phải chi nhiều tiền hơn để thay thế. \n"
            + "Ngược lại, nếu sản phẩm giá cao đồng nghĩa với chất lượng tốt, có thể sử dụng được lâu dài, thì xét \n"
            + "về bài toán kinh tế: giá cả = số tiền bỏ ra mua/thời gian sử dụng, bạn sẽ có lời hơn.\n"
            + "\n"
            + "Bên cạnh đó, bạn cũng cần suy nghĩ nghiêm túc về nhu cầu thực tế của bản thân. \n"
            + "Hầu hết chúng ta thường lãng phí tiền vào những thứ bản thân không sử dụng đế6n. \n"
            + "Đừng bốc đồng, hãy dành thời gian suy nghĩ thật nghiêm \n"
            + "túc trước khi mua món đồ bạn thích. Nếu bạn không thực sự cần thì không nên mua.",
            "Trao việc \"tay hòm chìa khóa\" cho người giỏi quản lý tài chính\n"
            + "\n"
            + "Trao quyền chi tiêu trong gia đình cho người không biết quản lý \n"
            + "tài chính sẽ vô tình gây ra lãng phí tiền bạc. \n"
            + "Vì thế, người  khôn ngoan biết trao việc \"tay hòm chìa khóa\" cho thành \n"
            + "viên biết quản lý kinh tế trong nhà.",
            "Đừng mua xe hơi mới\n"
            + "\n"
            + "Doanh nhân, chuyên gia tài chính Dave Ramsey từng tổng kết, chỉ 39% người giàu có trên \n"
            + "thế giới mua những chiếc xe mới đắt tiền.Hầu hết mọi người sử dụng xe hơi chọn Toyota, \n"
            + "Honda, Hyundai... cũ, giá thành vừa phải, chất lượng tốt.\n"
            + "\n"
            + "David Bach, triệu phú Mỹ, một cố vấn làm giàu nổi tiếng, đánh giá: 'Mua ôtô mới tinh là quyết \n"
            + "định tài chính tệ nhất', bởi chỉ sau một năm đã hao tới 30% giá trị.\n"
            + "\n"
            + "Thay vì lựa chọn một chiếc xe mới cứng và phải chi trả nhiều loại thuế phí, bạn có thể \n"
            + "mua một chiếc xe cũ, chất lượng còn tốt để sử dụng. \n"
            + "Như thế, bạn tiết kiệm được một khoản tiền đáng kể.",
            "Bán đồ cũ\n"
            + "\n"
            + "Với những sản phẩm chất lượng còn tốt nhưng không sử dụng đến như quần áo, \n"
            + "đồ chơi hay sách báo, bạn có thể trao đổi với người khác hoặc bán đi. \n"
            + "Việc này không chỉ dọn dẹp nhà cửa mà còn giúp bạn có thêm một khoản tiền.",
            "Chọn hình thức vay tiền phù hợp\n"
            + "\n"
            + "Các ngân hàng cung cấp nhiều hình thức cho vay khác nhau. \n"
            + "Đừng ngại tìm hiểu, bạn hãy nghiên cứu kỹ lưỡng để tìm ra hình thức vay phù hợp. \n"
            + "\n"
            + "Trong thời gian vay, căn cứ vào tình hình tài chính thực tế của mình, \n"
            + "bạn có thể xem xét, điều chỉnh khoản \n"
            + "vay thông qua các hình thức tái cấp vốn hoặc cơ cấu lại khoản vay.",
            "Trả nợ nhiều hơn mức tối thiểu\n"
            + "\n"
            + "Khi thanh toán thẻ hoặc thanh toán các khoản vay, bạn không nên \n"
            + "chọn hình thức chỉ thanh toán con số tối \n"
            + "thiểu của khoản vay, ngoại trừ tình huống không có tiền. \n"
            + "Đừng quên rằng nợ càng nhỏ, số tiền lãi suất phải trả càng ít.",
            "Chia sẻ chi phí với người khác\n"
            + "\n"
            + "Có rất nhiều cách khác nhau để có thể chia sẻ chi phí với người khác. \n"
            + "Ví dụ, mua chung đồ trực tuyến để giảm \n"
            + "cước vận chuyển, chia tiền ăn khi đi ăn chung... Nhờ thế, bạn sẽ không phải một mình gánh chi phí.",
            "Tự mình làm kế toán\n"
            + "\n"
            + "Bạn có thể tự mình liệt kê chi phí, lập danh sách thu chi... để biết \n"
            + "tiền của mình được sử dụng thế nào. \n"
            + "Có những khoản mà bạn nghĩ là \"không đáng kể\", nhưng nếu liệt kê ra, \n"
            + "bạn sẽ thấy chúng nhiều hơn là mình nghĩ. \n"
            + "Việc lập danh sách chi tiêu sẽ giúp bạn hiểu tình hình tài chính cũng như \n"
            + "thói quen chi tiêu của chính mình.",
            "Đừng để giới hạn bởi những định kiến tâm lý\n"
            + "\n"
            + "Nếu bạn làm việc chăm chỉ mà vẫn kinh tế vẫn không khá hơn, bạn cần xem xét xem \n"
            + "liệu cuộc sống của mình có bị giới hạn bởi những định kiến tâm lý hay không. \n"
            + "Nếu trong đầu bạn luôn có tư tưởng rằng \"không thể kiếm tiền với công \n"
            + "việc thế này\", hay bạn tin lời người khác rằng \"giàu là do đục khoét đâu đó\"... thì thật \n"
            + "khó thành công.\n"
            + "\n"
            + "Bạn phải suy nghĩ xem làm thế nào để tăng thu nhập từ công việc của mình, hoặc \n"
            + "xem xét công việc từ nghề \"tay trái\" để có thêm tiền. \n"
            + "Người không tin rằng họ có thể thành công và kiếm ra tiền sẽ khó hiện thực hóa giấc\n"
            + " mơ giàu có."
        };
        return meo[i];
    }

    public boolean ktra() {
        boolean abc = true;
        try {
            File file = new File("C:\\QLCT\\cauhinh.txt");
            boolean check = file.exists();
            if (check == true) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                String[] b = (String[]) ois.readObject();
                con = KetNoiNhanh.Faster.ketNoi(b[0], b[1], b[2]);
                fis.close();
                ois.close();
                if (con == null) {
                    new FormCauHinhDTB().setVisible(true);
                    this.setVisible(false);
                    abc = false;
                } else {
                    String nguoiDung = null;
                    PreparedStatement ps = con.prepareStatement("Select * from NGUOIDUNG");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        nguoiDung = rs.getString(1);
                    }
                    if (nguoiDung == null) {
                        new FormNhapThongTin(con).setVisible(true);
                        this.setVisible(false);
                        abc = false;
                    }
                }
            } else {
                new FormCauHinhDTB().setVisible(true);
                this.setVisible(false);
                abc = false;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi không tìm thấy đường dẫn file: " + ex);
            abc = false;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Mời cập nhật lại cấu hình cơ sở dữ liệu!");
            new FormCauHinhDTB().setVisible(true);
            this.setVisible(false);
            abc = false;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + ex);
            abc = false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn cơ sở dữ liệu: " + ex);
            abc = false;
        }
        return abc;
    }

    public int random() {
        int i = (int) Math.round(Math.random() * 9);
        return i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jProgressBar.setStringPainted(true);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Mẹo làm giàu");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/meoLamGiau.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(ktra()){
        tienTrinh();
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(FormMeoLamGiau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMeoLamGiau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMeoLamGiau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMeoLamGiau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMeoLamGiau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
