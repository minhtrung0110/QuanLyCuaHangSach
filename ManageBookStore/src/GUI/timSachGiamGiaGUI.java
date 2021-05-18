/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SachBUS;
import DTO.SachDTO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tungk
 */
public class timSachGiamGiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form timSachGiamGiaGUI
     */
    DefaultTableModel model;
    public timSachGiamGiaGUI() {
        initComponents();
        setVisible(true);
        try{
            docDSSach();
        }catch(Exception ex){
            
        }
    }
    
    private void docDSSach(){
        SachBUS bus = new SachBUS();
        try{
            bus.loadDSSach();
            
            Vector header = new Vector();
            header.add("MÃ SÁCH");
            header.add("MÃ NXB");
            header.add("MÃ THỂ LOẠI");
            header.add("MÃ TÁC GIẢ");
            header.add("TÊN SÁCH");
            header.add("NĂM XUẤT BẢN");
            header.add("SỐ LƯỢNG");
            header.add("ĐƠN GIÁ");
            model=new DefaultTableModel(header,0);
            for(SachDTO s : bus.getListSach()){
                Vector data = new Vector<>();
                data = new Vector();
                data.add(s.getMaSach());
                data.add(s.getMaNXB());
                data.add(s.getMaTL());
                data.add(s.getMaTG());
                data.add(s.getTenSach());
                data.add(s.getNamXuatBan());
                data.add(s.getSoluong());
                data.add(s.getDongia());
                
                model.addRow(data);
            }
            table.setModel(model);
        } catch (Exception ex) {
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnDongY = new javax.swing.JButton();
        textTenSach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textTacGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnDongY.setText("Đồng Ý");
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        textTenSach.setEnabled(false);
        textTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTenSachActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên sách:");

        textTacGia.setEnabled(false);

        jLabel2.setText("Đơn giá:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDongY)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTacGia)
                                    .addComponent(textTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
                        .addGap(238, 238, 238))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnDongY)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        // TODO add your handling code here:
        SachDTO sach;
        
        int index = table.getSelectedRow();
        
        sach = new SachDTO(table.getValueAt(index, 0).toString(), 
                table.getValueAt(index, 1).toString(), 
                table.getValueAt(index, 3).toString(), 
                table.getValueAt(index, 2).toString(), 
                table.getValueAt(index, 4).toString(), 
                Integer.parseInt(table.getValueAt(index, 5).toString()), 
                Integer.parseInt(table.getValueAt(index, 6).toString()), 
                Float.parseFloat(table.getValueAt(index, 7).toString() ), 
                "");
        GiamGiaGUI.setKetQuaTimKiem(sach);
        GiamGiaGUI.textTenSachTimKiem.setText(sach.getTenSach());
        dispose();
    }//GEN-LAST:event_btnDongYActionPerformed

    private void textTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTenSachActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int index = table.getSelectedRow();
        textTenSach.setText(model.getValueAt(index, 4).toString());
        textTacGia.setText(model.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(timSachGiamGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(timSachGiamGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(timSachGiamGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(timSachGiamGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new timSachGiamGiaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDongY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField textTacGia;
    private javax.swing.JTextField textTenSach;
    // End of variables declaration//GEN-END:variables
}
