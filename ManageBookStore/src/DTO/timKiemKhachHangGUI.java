/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import BUS.KhachHangBUS;
import GUI.KhachHangGUI;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tungk
 */
public class timKiemKhachHangGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form timKiemKhachHangGUI
     */
    public timKiemKhachHangGUI() {
        initComponents();
        comboInput.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        lbHeader = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        comboInput = new javax.swing.JComboBox<>();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        textInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbHeader.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbHeader.setForeground(new java.awt.Color(0, 51, 255));
        lbHeader.setText("Tìm kiếm khách hàng");

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        comboInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH", "Họ", "Tên", "SĐT", "Email", "Phai", "Tổng Chi" }));
        comboInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInputActionPerformed(evt);
            }
        });

        radio1.setText("Nam");
        radio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio1ActionPerformed(evt);
            }
        });

        radio2.setText("Nữ");

        textInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInputActionPerformed(evt);
            }
        });
        textInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textInputKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lbHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboInput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio1)
                                .addGap(79, 79, 79)
                                .addComponent(radio2))
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textInput))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio1)
                    .addComponent(radio2))
                .addGap(18, 18, 18)
                .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInputActionPerformed
        // TODO add your handling code here:
        switch(comboInput.getSelectedIndex()){
        case 5:
            radio1.setText("Nam"); radio1.setEnabled(true);
            radio2.setText("Nữ"); radio2.setEnabled(true);
            textInput.setEnabled(false);
            break;
        case 6:
            radio1.setText("Lớn hơn"); radio1.setEnabled(true);
            radio2.setText("Bé hơn"); radio2.setEnabled(true);
            textInput.setEnabled(true);
            break;
        default:
            radio1.setEnabled(false);
            radio2.setEnabled(false);
            
            textInput.setEnabled(true);
        }
        
    }//GEN-LAST:event_comboInputActionPerformed

    private void textInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInputActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textInputActionPerformed

    private void radio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio1ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        KhachHangBUS bus = new KhachHangBUS();
        
        Vector header = new Vector<>();
        header.add("Mã KH"); header.add("Họ"); header.add("Tên");
        header.add("SĐT"); header.add("Email"); header.add("Phái"); 
        header.add("TCT"); 
        model = new DefaultTableModel(header, 0);
        
        String input = textInput.getText();
        switch (comboInput.getSelectedIndex()){
            case 0:
                for(KhachHangDTO kh : bus.timKiemId(input)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                
                break;
            case 1:
                for(KhachHangDTO kh : bus.timKiemHo(input)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                
                break;
            case 2:
                for(KhachHangDTO kh : bus.timKiemTen(input)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                break;
            case 3:
                for(KhachHangDTO kh : bus.timKiemSDT(input)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                break;
            case 4:
                for(KhachHangDTO kh : bus.timKiemEmail(input)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                break;
            case 5:
                for(KhachHangDTO kh : bus.timKiemPhai(radio1.isSelected())){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                break;
            case 6: 
                int tct = Integer.parseInt(input);
                for(KhachHangDTO kh : bus.timKiemTCT(radio1.isSelected(), tct)){
                    Vector row = new Vector();
                    row.add(kh.getId());
                    row.add(kh.getHo());
                    row.add(kh.getTen());
                    row.add(kh.getSdt());
                    row.add(kh.getEmail());
                    row.add(!kh.isPhai()?"nữ":"nam");
                    row.add(kh.getTct());
                    model.addRow(row);
                }
                break;
        }
        
       // KhachHangGUI.setTableModel((model));
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void textInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textInputKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnTimKiem.doClick();
        }
    }//GEN-LAST:event_textInputKeyPressed

    
    
    DefaultTableModel model;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> comboInput;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JTextField textInput;
    // End of variables declaration//GEN-END:variables

}