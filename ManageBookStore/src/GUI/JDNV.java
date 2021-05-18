/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khôi
 */
public class JDNV extends javax.swing.JDialog {

    DefaultTableModel model=new DefaultTableModel();
    
    public JDNV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JDNV(){
        setModal(true);
        initComponents();
        txTim.requestFocus();
        LoadDSNV();
        setVisible(true);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNV = new javax.swing.JTable();
        btXacNhan = new javax.swing.JButton();
        btDong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btTim = new javax.swing.JButton();
        cbbTim = new javax.swing.JComboBox<>();
        txTim = new javax.swing.JTextField();
        txMaNV1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(480, 150, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ", "Tên", "SĐT", "Email", "Chức vụ"
            }
        ));
        tbNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNV);
        if (tbNV.getColumnModel().getColumnCount() > 0) {
            tbNV.getColumnModel().getColumn(1).setMinWidth(130);
            tbNV.getColumnModel().getColumn(2).setMinWidth(50);
            tbNV.getColumnModel().getColumn(3).setMinWidth(100);
            tbNV.getColumnModel().getColumn(4).setMinWidth(170);
        }

        btXacNhan.setBackground(new java.awt.Color(0, 102, 0));
        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btXacNhan.setText("XÁC NHẬN");
        btXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXacNhanMouseClicked(evt);
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        btTim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTim.setText("TÌM");
        btTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTimMouseClicked(evt);
            }
        });

        cbbTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Họ", "Tên" }));

        txTim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(cbbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTim, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        txMaNV1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã NV:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNVMouseClicked
        Click();
    }//GEN-LAST:event_tbNVMouseClicked

    private void btXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXacNhanMouseClicked
       dispose();
    }//GEN-LAST:event_btXacNhanMouseClicked

    private void btTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTimMouseClicked
       Tim();
    }//GEN-LAST:event_btTimMouseClicked

    private void btDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDongMouseClicked
         txTim.setText("");
        setVisible(false);
    }//GEN-LAST:event_btDongMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDNV dialog = new JDNV();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
    }
/*************************************Đọc DSNV*******************************/
    public void outModel(DefaultTableModel model,ArrayList<NhanVienDTO> nv){
        Vector row;
        model.setRowCount(0);
        for(NhanVienDTO n: nv){
            row=new Vector();
            row.add(n.getMaNV());
            row.add(n.getHo());
            row.add(n.getTen());
            row.add(n.getSDT());
            row.add(n.getEmail());
            row.add(n.getChucVu());
            model.addRow(row);
        }
        tbNV.setModel(model);
    }
    public void LoadDSNV(){
        NhanVienBUS nvBUS=new NhanVienBUS();
        Vector header=new Vector();
        header.add("Mã NV");
        header.add("Họ");
        header.add("Tên");
        header.add("SĐT");
        header.add("Email");
        header.add("Chức vụ");
        if(model.getRowCount()==0)
            model=new DefaultTableModel(header,0);
         try {
            if(nvBUS.getDsnv()==null)
            nvBUS.getNhanVien();
            ArrayList<NhanVienDTO> dsnv =new ArrayList<>();
            dsnv=nvBUS.getDsnv();
            outModel(model,dsnv);
        } catch (Exception ex) {
            System.out.println("Khong tai duoc danh sach nv");
        }
    }
/**************************lấy mã nv**************************************/
    public void Click(){
        int i=tbNV.getSelectedRow();
        txMaNV1.setText(tbNV.getModel().getValueAt(i,0).toString());
    }
    public String MaNV(){
        String MaNV=txMaNV1.getText();
        return MaNV;
    }
// tìm *****************************************************************
    public void Tim(){
        String a=cbbTim.getSelectedItem().toString();
        NhanVienBUS nvBUS=new NhanVienBUS();
        ArrayList<NhanVienDTO> dsnv=new ArrayList<>();
        ArrayList<NhanVienDTO> nv1=new ArrayList<>();
        dsnv=nvBUS.getDsnv();
        try{
        if((a.equals("Mã NV") || a.equals("Họ") || a.equals("Tên")) && txTim.getText().isEmpty())
            outModel(model,dsnv);
        else if(a.equals("Mã NV")){
                NhanVienDTO nv2=new NhanVienDTO();
                nv2=nvBUS.timkiem_MaNV(txTim.getText());
                nv1.add(nv2);
                outModel(model,nv1);
        }
        else if(a.equals("Họ")){
            for(NhanVienDTO nv4:dsnv){
                if(nv4.getHo().toUpperCase().indexOf(txTim.getText().toUpperCase()) > -1)
                    nv1.add(nv4);
            }
            outModel(model,nv1);
        }
        else if(a.equals("Tên")){
            for(NhanVienDTO nv5:dsnv){
                if(nv5.getTen().toUpperCase().indexOf(txTim.getText().toUpperCase()) > -1)
                    nv1.add(nv5);
            }
            outModel(model,nv1);
        }
        }catch(Exception ex) {
            System.out.println("Khong tai duoc danh sach nv");
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDong;
    private javax.swing.JButton btTim;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JComboBox<String> cbbTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbNV;
    private javax.swing.JTextField txMaNV1;
    private javax.swing.JTextField txTim;
    // End of variables declaration//GEN-END:variables
}
