package GUI;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Choice;
import java.lang.Object;
import java.security.Timestamp;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends javax.swing.JPanel {
    private int DEFALUT_WIDTH;
    DefaultTableModel modelct=new DefaultTableModel();
    DefaultTableModel model=new DefaultTableModel();
    private HoaDonBUS hd=new HoaDonBUS();
    private ChiTietHoaDonBUS CTBUS=new ChiTietHoaDonBUS();
    public HoaDonGUI() {
        initComponents();
    }
    public HoaDonGUI(int width){
         DEFALUT_WIDTH = width;
         initComponents();
         this.setSize(width - 210, 750);
         LoadDB();
         Sum();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txMaHD = new javax.swing.JTextField();
        txMaKH = new javax.swing.JTextField();
        txMaNV = new javax.swing.JTextField();
        txMaGG = new javax.swing.JTextField();
        txGiamGia = new javax.swing.JTextField();
        txThanhTien = new javax.swing.JTextField();
        txTongTien = new javax.swing.JTextField();
        txNgayLap = new javax.swing.JTextField();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        txTimMAHD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btTim = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txDau = new javax.swing.JTextField();
        txCuoi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietHD = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txTongTienHD = new javax.swing.JTextField();
        txSoLuongHD = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txMaHDCT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txTimMAKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txTimMANV = new javax.swing.JTextField();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        btXuat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã HĐ:");
        jLabel2.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel2.setMinimumSize(new java.awt.Dimension(62, 15));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã GG:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã NV:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mã KH:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ngày lập:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Thành tiền:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Giảm giá:");

        txMaHD.setEditable(false);
        txMaHD.setBackground(new java.awt.Color(255, 255, 255));

        btSua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btSua.setText("SỬA");
        btSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btXoa.setText("XÓA");
        btXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Mã GG", "Ngày lập", "Tổng tiền", "Giảm giá", "Thành tiền"
            }
        ));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHD);
        if (tbHD.getColumnModel().getColumnCount() > 0) {
            tbHD.getColumnModel().getColumn(4).setMinWidth(150);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Thời gian từ:");

        btTim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btTim.setIcon(new javax.swing.ImageIcon("D:\\Leanring\\Universe\\SecondYear\\HK2\\Java\\QuanLyCuaHangSach\\ManageBookStore\\src\\img\\search_25px.png")); // NOI18N
        btTim.setText("TÌM");
        btTim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTimMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giá tiền từ:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("----------------------------------------------------------------------Tìm Kiếm---------------------------------------------------------------");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("đến");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setText("-----------------------------------------------------------------Chi Tiết Hóa Đơn-------------------------------------------------------------");

        tbChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã sách", "Tên sách", "Đơn giá", "Số lượng", "Giảm giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tbChiTietHD);
        if (tbChiTietHD.getColumnModel().getColumnCount() > 0) {
            tbChiTietHD.getColumnModel().getColumn(2).setMinWidth(150);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Số lượng hóa đơn:");
        jLabel12.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel12.setMinimumSize(new java.awt.Dimension(62, 15));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tổng tiền các hóa đơn:");
        jLabel17.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(62, 15));

        txTongTienHD.setEditable(false);

        txSoLuongHD.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("MÃ HĐ");
        jLabel18.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel18.setMinimumSize(new java.awt.Dimension(62, 15));

        txMaHDCT.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Mã HĐ:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Mã KH:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Mã NV:");

        cbbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm", "2021", "2020", "2019", "2018", "2017", "2016", "2015" }));

        btXuat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btXuat.setText("XUẤT");
        btXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(407, 407, 407))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMaGG))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(txGiamGia))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(txNgayLap)))
                            .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txTimMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txTimMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTimMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTimMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(txTimMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txTimMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        Click();
        LoadDBCT();
    }//GEN-LAST:event_tbHDMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
        Xoa();
        Sum();
    }//GEN-LAST:event_btXoaMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
      Sua();
      Sum();
    }//GEN-LAST:event_btSuaMouseClicked

    private void btTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTimMouseClicked
      TimKiem();
      Sum();
    }//GEN-LAST:event_btTimMouseClicked

    private void btXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXuatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btXuatMouseClicked
/* **************************************Hóa đơn****************************** */
//load DB
    public void LoadDB(){
        HoaDonBUS HDBUS=new HoaDonBUS();
        Vector header=new Vector();
        header.add("Mã HĐ");
        header.add("Mã KH");
        header.add("Mã NV");
        header.add("Mã GG");
        header.add("Ngày lập");
        header.add("Tổng tiền");
        header.add("Giảm giá");
        header.add("Thành tiền");
        if(model.getRowCount()==0){
            model=new DefaultTableModel(header,0);
        }
        if(HDBUS.getList()==null) HDBUS.List();
        ArrayList<HoaDonDTO> HDDTO=HDBUS.getList();
        model.setRowCount(0);
        outModel(model,HDDTO);
    }
    public void outModel(DefaultTableModel model , ArrayList<HoaDonDTO> hd) // Xuất ra Table từ ArrayList
    {
        Vector row;
        model.setRowCount(0);
        for(HoaDonDTO h:hd)
        {
            row = new Vector();
            row.add(h.getMaHD());
            row.add(h.getMaKH());
            row.add(h.getMaNV());
            row.add(h.getMaGG());
            row.add(h.getNgayLap());
            row.add(h.getTongTien());
            row.add(h.getGiamGia());
            row.add(h.getThanhTien());
            model.addRow(row);
        }
        tbHD.setModel(model);
    }
//Click lên table
    public void Click(){
        int i=tbHD.getSelectedRow();
        txMaHD.setText(tbHD.getModel().getValueAt(i,0).toString());
        txMaKH.setText(tbHD.getModel().getValueAt(i,1).toString());
        txMaNV.setText(tbHD.getModel().getValueAt(i,2).toString());
        txMaGG.setText(tbHD.getModel().getValueAt(i,3).toString());
        txNgayLap.setText(tbHD.getModel().getValueAt(i,4).toString());
        txTongTien.setText(tbHD.getModel().getValueAt(i,5).toString());
        txGiamGia.setText(tbHD.getModel().getValueAt(i,6).toString());
        txThanhTien.setText(tbHD.getModel().getValueAt(i,7).toString());
    }
//Sửa
    public void Sua(){
                String MaHD = txMaHD.getText();
                String MaKH = txMaKH.getText();
                String MaNV = txMaNV.getText();
                String NgayLap=txNgayLap.getText();
                String MaGG=txMaGG.getText();
                float TongTien=Float.parseFloat(txTongTien.getText());
                float GiamGia=Float.parseFloat(txTongTien.getText());
                float ThanhTien=Float.parseFloat(txThanhTien.getText());
                HoaDonDTO hd1=new HoaDonDTO(MaHD,MaKH,MaNV,MaGG,NgayLap,TongTien,GiamGia,ThanhTien);
                int i = hd.set(hd1);
                outModel(model, hd.getList());
                tbHD.setRowSelectionInterval(i, i);
                
    }
//Xóa
    public void Clean(){
        txMaHD.setText("");
        txMaKH.setText("");
        txMaNV.setText("");
        txMaGG.setText("");
        txNgayLap.setText("");
        txTongTien.setText("");
        txGiamGia.setText("");
        txThanhTien.setText("");
    }
    public void Xoa(){
        if(txMaHD.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null, 
                    "Vui lòng chọn hóa đơn", 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
        ChiTietHoaDonBUS chitiet=new ChiTietHoaDonBUS(1);
        HoaDonBUS hoadon=new HoaDonBUS();
           int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    chitiet.Xoa(txMaHD.getText());
                    hoadon.Xoa(txMaHD.getText());
                    Clean();
                    tbHD.clearSelection();
                    outModel(model, hoadon.getList());
                    JOptionPane.showMessageDialog(
                    null, 
                    "Xóa thành công", 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
/* *******************************Chi tiết hóa đơn***************** */
//Load DB CTHD
        public void LoadDBCT(){
            Vector header=new Vector();
            header.add("Mã HĐ");
            header.add("Mã sách");
            header.add("Tên sách");
            header.add("Số lượng");
            header.add("Đơn giá");
            header.add("Giảm Giá");
            header.add("Thành tiền");
           if(modelct.getRowCount()==0){
            modelct=new DefaultTableModel(header,0);
        }
           txMaHDCT.setText(txMaHD.getText());
           if(CTBUS.getList()==null) CTBUS.List();
           ArrayList<ChiTietHoaDonDTO> ct=CTBUS.getListHD(txMaHD.getText());
           modelct.setRowCount(0);
           outModelCT(modelct,ct);
        }
        public void outModelCT(DefaultTableModel model1,ArrayList<ChiTietHoaDonDTO> ct){
            Vector row;
            modelct.setRowCount(0);
            for(ChiTietHoaDonDTO c:ct){
                row=new Vector();
                row.add(c.getMaHD());
                row.add(c.getMaSach());
                row.add(c.getTenSach());
                row.add(c.getSoLuong());
                row.add(c.getDonGia());
                row.add(c.getGiamGia());
                row.add(c.getThanhTien());
                model1.addRow(row);
            }
            tbChiTietHD.setModel(model1);
        }
//Đếm số hóa đơn và tiền
        public void Sum(){
            float Sum=0;
            float j=0;
            int n=model.getRowCount();
            for(int i=0;i<n;i++){
                j=Float.parseFloat(tbHD.getModel().getValueAt(i,7).toString());
                Sum=Sum+j;
            }
            txSoLuongHD.setText(String.valueOf(model.getRowCount()));
            txTongTienHD.setText(String.valueOf(Sum));
        }
//Tìm kiếm
        public void TimKiem(){
        int m = cbbThang.getSelectedIndex()-1;
        int y ;
        
        try{
            y = Integer.parseInt(cbbNam.getSelectedItem().toString());
        }catch(NumberFormatException ex)
        {
            y = 0;
        }
        float max = txCuoi.getText().equals("") ? 9999999 : Float.parseFloat(txCuoi.getText());
        float min = txDau.getText().equals("") ? 0      : Float.parseFloat(txDau.getText());
            outModel(model,hd.TimKiem(m,y,max,min,txTimMAHD.getText(),txTimMAKH.getText(),txTimMANV.getText()));
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTim;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXuat;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbChiTietHD;
    private javax.swing.JTable tbHD;
    private javax.swing.JTextField txCuoi;
    private javax.swing.JTextField txDau;
    private javax.swing.JTextField txGiamGia;
    private javax.swing.JTextField txMaGG;
    private javax.swing.JTextField txMaHD;
    private javax.swing.JTextField txMaHDCT;
    private javax.swing.JTextField txMaKH;
    private javax.swing.JTextField txMaNV;
    private javax.swing.JTextField txNgayLap;
    private javax.swing.JTextField txSoLuongHD;
    private javax.swing.JTextField txThanhTien;
    private javax.swing.JTextField txTimMAHD;
    private javax.swing.JTextField txTimMAKH;
    private javax.swing.JTextField txTimMANV;
    private javax.swing.JTextField txTongTien;
    private javax.swing.JTextField txTongTienHD;
    // End of variables declaration//GEN-END:variables
}
