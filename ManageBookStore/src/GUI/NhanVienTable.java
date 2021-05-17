/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanVienTable extends javax.swing.JDialog {
     private DefaultTableModel model;
    /**
     * Creates new form NhanVienTable
     */
    
    public NhanVienTable() {
        initComponents();
        setModal(true);
        loadDSNhanVien();
    }

    public NhanVienTable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModal(true);
        loadDSNhanVien();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grbutton1 = new javax.swing.ButtonGroup();
        grbutton2 = new javax.swing.ButtonGroup();
        pHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pInput = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txMaNhanVien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txSoDienThoai = new javax.swing.JTextField();
        TÊN = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txTen = new javax.swing.JTextField();
        txHo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txLuong = new javax.swing.JTextField();
        btXacNhan = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txNgaySinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txChucVu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdNu = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        pSearch = new javax.swing.JPanel();
        txSearchMaNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txSearchHo = new javax.swing.JTextField();
        TÊN1 = new javax.swing.JLabel();
        txSearchTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txSearchLuong = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        rdSearchNam = new javax.swing.JRadioButton();
        rdSearchNu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        txSearchChucVu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txSearchNgaySinhMin = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txSearchNgaySinhMax = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pHeader.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");

        javax.swing.GroupLayout pHeaderLayout = new javax.swing.GroupLayout(pHeader);
        pHeader.setLayout(pHeaderLayout);
        pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(310, 310, 310))
        );
        pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("MÃ NHÂN VIÊN:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("HỌ :");

        TÊN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TÊN.setText("TÊN:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("SỐ ĐIỆN THOẠI:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("LƯƠNG:");

        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setText("XÁC NHẬN");
        btXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXacNhanMouseClicked(evt);
            }
        });
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });

        btThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btThoat.setText("THOÁT");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("EMAIL:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("NGÀY SINH:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CHỨC VỤ:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("PHÁI:");

        grbutton1.add(rdNu);
        rdNu.setText("Nữ");
        rdNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNuActionPerformed(evt);
            }
        });

        grbutton1.add(rdNam);
        rdNam.setText("Nam");
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pInputLayout = new javax.swing.GroupLayout(pInput);
        pInput.setLayout(pInputLayout);
        pInputLayout.setHorizontalGroup(
            pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInputLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(txSoDienThoai))))
                .addGap(18, 18, 18)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TÊN))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txTen, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(txHo)
                    .addComponent(txEmail))
                .addGap(15, 15, 15)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6))
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rdNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdNu)))
                .addGap(50, 50, 50)
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pInputLayout.setVerticalGroup(
            pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInputLayout.createSequentialGroup()
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)))
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pInputLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdNam)
                                    .addComponent(rdNu)))
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addComponent(txHo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pInputLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(TÊN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbNhanVien.setBackground(new java.awt.Color(255, 204, 0));
        tbNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        tbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NHÂN VIÊN", "HỌ", "TÊN", "SỐ ĐIỆN THOẠI", "LƯƠNG", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        pSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2), "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("MÃ NHÂN VIÊN:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("HỌ :");

        TÊN1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TÊN1.setText("TÊN:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("LƯƠNG:");

        btSearch.setIcon(new javax.swing.ImageIcon("D:\\Leanring\\Universe\\SecondYear\\HK2\\Java\\QuanLyCuaHangSach\\ManageBookStore\\src\\img\\search_25px.png")); // NOI18N
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("PHÁI:");

        grbutton2.add(rdSearchNam);
        rdSearchNam.setText("Nam");
        rdSearchNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSearchNamActionPerformed(evt);
            }
        });

        grbutton2.add(rdSearchNu);
        rdSearchNu.setText("Nữ");
        rdSearchNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSearchNuActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("CHỨC VỤ:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("NGÀY SINH TỪ:");

        txSearchNgaySinhMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearchNgaySinhMinActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("NGÀY SINH ĐẾN:");

        txSearchNgaySinhMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearchNgaySinhMaxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSearchLayout = new javax.swing.GroupLayout(pSearch);
        pSearch.setLayout(pSearchLayout);
        pSearchLayout.setHorizontalGroup(
            pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pSearchLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addGap(24, 24, 24)
                        .addComponent(txSearchChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdSearchNam)
                        .addGap(12, 12, 12)
                        .addComponent(rdSearchNu))
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSearchMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSearchHo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addComponent(TÊN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSearchNgaySinhMin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSearchLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSearchLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSearchLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSearchNgaySinhMax, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pSearchLayout.setVerticalGroup(
            pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchLayout.createSequentialGroup()
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txSearchLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TÊN1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearchHo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearchMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSearchLayout.createSequentialGroup()
                        .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pSearchLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txSearchNgaySinhMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pSearchLayout.createSequentialGroup()
                                .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdSearchNam)
                                        .addComponent(rdSearchNu))
                                    .addComponent(txSearchChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSearchLayout.createSequentialGroup()
                        .addComponent(txSearchNgaySinhMax)
                        .addContainerGap())))
            .addGroup(pSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String getMaNhanVien(){
        String manv= txMaNhanVien.getText(); 
        return manv;
    }
    private void loadDSNhanVien(){
         try {
           NhanVienBUS bus =new NhanVienBUS();
        if(NhanVienBUS.getDsnv()==null) bus.loadDatabase();
        insertHeader();
        outModel(model,NhanVienBUS.getDsnv());
        } catch (Exception e) {
             String ex="ass";
             Logger.getLogger(NhanVienTable.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this,"Không Thể Load Database ", "Thông Báo Lỗi",JOptionPane.ERROR_MESSAGE);
        }
       
        
        
    }
    private void insertHeader(){
        Vector header = new Vector();
        header.add("MÃ NHÂN VIÊN");
        header.add("HỌ");
        header.add("TÊN");
        header.add("SĐT");
        header.add("EMAIL");
        header.add("PHÁI");
        header.add("NGÀY SINH");
        header.add("CHỨC VỤ");
        header.add("LƯƠNG");
        //if (model.getRowCount()==0)
        model=new DefaultTableModel(header,0);
              
           
    }
    private void outModel(DefaultTableModel model ,ArrayList<NhanVienDTO> nv) // Xuất ra Table từ ArrayList
    {
         
        model.setRowCount(0);
        for(NhanVienDTO s: nv)
        {
            Vector data = new Vector();
            data.add(s.getMaNV());
            data.add(s.getHo());
            data.add(s.getTen());
            data.add(s.getSDT());
            data.add(s.getEmail());
            data.add(s.getPhai());
            data.add(s.getngaysinh());
            data.add(s.getChucVu());
            data.add(s.getLuong());
            model.addRow(data);
        }
        tbNhanVien.setModel(model);
    }
    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btXacNhanActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btThoatActionPerformed

    private void rdNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNuActionPerformed

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    private void rdSearchNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSearchNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdSearchNamActionPerformed

    private void rdSearchNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSearchNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdSearchNuActionPerformed

    private void txSearchNgaySinhMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearchNgaySinhMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSearchNgaySinhMinActionPerformed

    private void txSearchNgaySinhMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearchNgaySinhMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSearchNgaySinhMaxActionPerformed

    private void btXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXacNhanMouseClicked
         dispose(); //return manv;
    }//GEN-LAST:event_btXacNhanMouseClicked

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        
        int i = tbNhanVien.getSelectedRow();
        if(i>=0)
        {
            txMaNhanVien.setText(tbNhanVien.getModel().getValueAt(i, 0).toString());
            txHo.setText(tbNhanVien.getModel().getValueAt(i, 1).toString());
            txTen.setText(tbNhanVien.getModel().getValueAt(i, 2).toString());
            txSoDienThoai.setText(tbNhanVien.getModel().getValueAt(i, 3).toString());
            txEmail.setText(tbNhanVien.getModel().getValueAt(i, 4).toString());
            if(tbNhanVien.getModel().getValueAt(i, 5).toString().equalsIgnoreCase("1")) rdNam.isSelected(); 
            else if(tbNhanVien.getModel().getValueAt(i, 5).toString().equalsIgnoreCase("0")) rdNu.isSelected();
            txNgaySinh.setText( tbNhanVien.getModel().getValueAt(i, 6).toString());
            txChucVu.setText( tbNhanVien.getModel().getValueAt(i, 7).toString());
            txLuong.setText( tbNhanVien.getModel().getValueAt(i, 8).toString());
           

        }
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        
    }//GEN-LAST:event_btSearchActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienTable dialog = new NhanVienTable(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TÊN;
    private javax.swing.JLabel TÊN1;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btXacNhan;
    private javax.swing.ButtonGroup grbutton1;
    private javax.swing.ButtonGroup grbutton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pHeader;
    private javax.swing.JPanel pInput;
    private javax.swing.JPanel pSearch;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdSearchNam;
    private javax.swing.JRadioButton rdSearchNu;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txChucVu;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txHo;
    private javax.swing.JTextField txLuong;
    private javax.swing.JTextField txMaNhanVien;
    private javax.swing.JTextField txNgaySinh;
    private javax.swing.JTextField txSearchChucVu;
    private javax.swing.JTextField txSearchHo;
    private javax.swing.JTextField txSearchLuong;
    private javax.swing.JTextField txSearchMaNhanVien;
    private javax.swing.JTextField txSearchNgaySinhMax;
    private javax.swing.JTextField txSearchNgaySinhMin;
    private javax.swing.JTextField txSearchTen;
    private javax.swing.JTextField txSoDienThoai;
    private javax.swing.JTextField txTen;
    // End of variables declaration//GEN-END:variables
}
