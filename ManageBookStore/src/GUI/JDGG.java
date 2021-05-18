/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChuongTrinhGiamGiaBUS;
import DTO.ChuongTrinhGiamGiaDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khôi
 */
public class JDGG extends javax.swing.JDialog {

    DefaultTableModel model=new DefaultTableModel();
    public JDGG(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDGG(){
        setModal(true);
        initComponents();
        LoadDBGG();
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGG = new javax.swing.JTable();
        btXacNhan = new javax.swing.JButton();
        btDong = new javax.swing.JButton();
        txMaGG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(550, 150, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THÔNG TIN GIẢM GIÁ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        tbGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã GG", "Tên CT", "Loại CT", "Ngày BĐ", "Ngày KT"
            }
        ));
        tbGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGG);
        if (tbGG.getColumnModel().getColumnCount() > 0) {
            tbGG.getColumnModel().getColumn(0).setMinWidth(50);
            tbGG.getColumnModel().getColumn(1).setMinWidth(100);
            tbGG.getColumnModel().getColumn(2).setMinWidth(200);
            tbGG.getColumnModel().getColumn(3).setMinWidth(55);
            tbGG.getColumnModel().getColumn(4).setMinWidth(55);
        }

        btXacNhan.setBackground(new java.awt.Color(0, 102, 0));
        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btXacNhan.setText("XÁC NHẬN");
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });

        btDong.setBackground(new java.awt.Color(255, 0, 0));
        btDong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btDong.setForeground(new java.awt.Color(255, 255, 255));
        btDong.setText("ĐÓNG");
        btDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDongMouseClicked(evt);
            }
        });
        btDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDongActionPerformed(evt);
            }
        });

        txMaGG.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã Giảm Giá:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txMaGG, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
       dispose();
    }//GEN-LAST:event_btXacNhanActionPerformed

    private void btDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDongActionPerformed
       
    }//GEN-LAST:event_btDongActionPerformed

    private void tbGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGGMouseClicked
       Click();
    }//GEN-LAST:event_tbGGMouseClicked

    private void btDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDongMouseClicked
        txMaGG.setText("");
        dispose();
    }//GEN-LAST:event_btDongMouseClicked

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
            java.util.logging.Logger.getLogger(JDGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGG dialog = new JDGG();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
// Load DB GG**************************
    public void outModel(DefaultTableModel model,ArrayList<ChuongTrinhGiamGiaDTO> gg){
        Vector row;
        model.setRowCount(0);
        for(ChuongTrinhGiamGiaDTO ctgg: gg){
            row=new Vector();
            row.add(ctgg.getId());
            row.add(ctgg.getTenChuongTrinh());
            row.add(ctgg.getLoai());
            row.add(ctgg.getNgayBD());
            row.add(ctgg.getNgayKT());
            model.addRow(row);
        }
        tbGG.setModel(model);
    }
    public void LoadDBGG(){
        ChuongTrinhGiamGiaBUS ctgg=new ChuongTrinhGiamGiaBUS();
        Vector header=new Vector();
        header.add("Mã GG");
        header.add("Tên CT");
        header.add("Loại CT");
        header.add("Ngày BĐ");
        header.add("Ngày KT");
        if(model.getRowCount()==0)
            model=new DefaultTableModel(header,0);
        if(ctgg.dsChuongTrinh==null) ctgg.docDSChuongTrinh();
        ArrayList<ChuongTrinhGiamGiaDTO> ct=ctgg.dsChuongTrinh;
        outModel(model,ct);
    }
// lấy mã gg*************************************
    public void Click(){
        int i=tbGG.getSelectedRow();
        txMaGG.setText(tbGG.getModel().getValueAt(i,0).toString());
    }
    public String LayMaGG(){
        return txMaGG.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDong;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGG;
    private javax.swing.JTextField txMaGG;
    // End of variables declaration//GEN-END:variables
}
