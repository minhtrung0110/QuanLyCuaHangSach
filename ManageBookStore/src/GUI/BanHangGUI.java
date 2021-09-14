package GUI;

import BUS.ChiTietChuongTrinhGiamGiaBUS;
import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.SachBUS;
import DTO.ChiTietChuongTrinhGiamGiaDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SachDTO;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 
import com.toedter.calendar.JDateChooser;
import javax.swing.table.DefaultTableModel;

public class BanHangGUI extends javax.swing.JPanel {
    private int DEFALUT_WIDTH;
    private String userID;
     DefaultTableModel model=new DefaultTableModel();
    private HoaDonBUS hdBUS=new HoaDonBUS();
    private ChiTietHoaDonBUS ctBUS=new ChiTietHoaDonBUS(1);
    private SachBUS sachBUS=new SachBUS();
    private KhachHangBUS khBUS=new KhachHangBUS();
    private NhanVienBUS nvBUS= new NhanVienBUS();
    private ArrayList<ChiTietHoaDonDTO> DSCT=new ArrayList<>();
    public BanHangGUI() {
        initComponents();
    }
    public BanHangGUI(int width,String userID)
    {
        this.userID = userID;
        DEFALUT_WIDTH = width;
        //spBUS.listSP();
        initComponents();
        hdBUS.List();
        txMaHD.setText(hdBUS.AutoMaHD());
        panelCTHD.setVisible(false);
        this.setSize(this.DEFALUT_WIDTH - 220, 800);
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
        txMaHD = new javax.swing.JTextField();
        txMaKH = new javax.swing.JTextField();
        txMaNV = new javax.swing.JTextField();
        txMaGG = new javax.swing.JTextField();
        btMaNV = new javax.swing.JButton();
        btMaKH = new javax.swing.JButton();
        txNgayLap = new javax.swing.JTextField();
        btTaoHD = new javax.swing.JButton();
        panelCTHD = new javax.swing.JPanel();
        lbAnh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txMaSach = new javax.swing.JTextField();
        txTenSach = new javax.swing.JTextField();
        txSoLuong = new javax.swing.JTextField();
        txDonGia = new javax.swing.JTextField();
        btMaSach = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        btXacNhan = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txTongTien = new javax.swing.JTextField();
        txGiamGia = new javax.swing.JTextField();
        txThanhTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btMaGG = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(248, 248, 248), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("TẠO HÓA HƠN BÁN HÀNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã NV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã KH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã HĐ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã GG:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ngày lập:");

        txMaHD.setEditable(false);
        txMaHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txMaKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txMaKH.setText("K01");

        txMaNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txMaNV.setText("PK");

        txMaGG.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMaNV.setText("...");
        btMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMaNVMouseClicked(evt);
            }
        });

        btMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMaKH.setText("...");
        btMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMaKHMouseClicked(evt);
            }
        });

        txNgayLap.setEditable(false);
        txNgayLap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btTaoHD.setBackground(new java.awt.Color(0, 153, 51));
        btTaoHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btTaoHD.setForeground(new java.awt.Color(255, 255, 255));
        btTaoHD.setText("TẠO HÓA ĐƠN");
        btTaoHD.setBorder(null);
        btTaoHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTaoHDMouseClicked(evt);
            }
        });

        panelCTHD.setBackground(new java.awt.Color(255, 255, 255));
        panelCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "THÔNG TIN HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 51))); // NOI18N

        lbAnh.setBackground(new java.awt.Color(51, 255, 51));
        lbAnh.setForeground(new java.awt.Color(204, 204, 204));
        lbAnh.setText("Ảnh");
        lbAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MÃ SÁCH:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("TÊN SÁCH:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SỐ LƯỢNG:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ĐƠN GIÁ:");

        txMaSach.setText("KD01");
        txMaSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMaSachKeyPressed(evt);
            }
        });

        txTenSach.setEditable(false);

        txDonGia.setEditable(false);

        btMaSach.setBackground(new java.awt.Color(255, 153, 0));
        btMaSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btMaSach.setText("...");
        btMaSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMaSachMouseClicked(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(255, 255, 255));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnAdd_150px.png"))); // NOI18N
        btThem.setBorder(null);
        btThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThemMouseClicked(evt);
            }
        });

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Giảm giá", "Thành tiền"
            }
        ));
        tbCTHD.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jScrollPane1.setViewportView(tbCTHD);
        if (tbCTHD.getColumnModel().getColumnCount() > 0) {
            tbCTHD.getColumnModel().getColumn(1).setMinWidth(150);
        }

        btXacNhan.setBackground(new java.awt.Color(255, 255, 255));
        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnConfirm_150px.png"))); // NOI18N
        btXacNhan.setBorder(null);
        btXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXacNhanMouseClicked(evt);
            }
        });

        btHuy.setBackground(new java.awt.Color(0, 102, 255));
        btHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btHuy.setForeground(new java.awt.Color(255, 255, 255));
        btHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_forever_30px_1.png"))); // NOI18N
        btHuy.setText("HỦY");
        btHuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHuyMouseClicked(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(255, 255, 255));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnEdit_150px.png"))); // NOI18N
        btSua.setBorder(null);
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(255, 255, 255));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnDelete_150px.png"))); // NOI18N
        btXoa.setBorder(null);
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("THÀNH TIỀN:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GIẢM GIÁ:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("TỔNG TIỀN:");

        txTongTien.setEditable(false);

        txGiamGia.setEditable(false);

        txThanhTien.setEditable(false);

        javax.swing.GroupLayout panelCTHDLayout = new javax.swing.GroupLayout(panelCTHD);
        panelCTHD.setLayout(panelCTHDLayout);
        panelCTHDLayout.setHorizontalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 61, Short.MAX_VALUE))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTenSach)
                        .addGap(6, 6, 6))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(0, 60, Short.MAX_VALUE)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCTHDLayout.setVerticalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btMaSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSua)
                            .addComponent(btXoa))))
                .addGap(102, 102, 102))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("----------------------------------------------------------------------------------------------------------------");

        btMaGG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btMaGG.setText("...");
        btMaGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMaGGMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1)
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMaNV)
                    .addComponent(btMaKH)
                    .addComponent(btMaGG))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btTaoHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTaoHDMouseClicked
     TaoHD();
    }//GEN-LAST:event_btTaoHDMouseClicked

    private void btHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHuyMouseClicked
     HuyHD(true);
    }//GEN-LAST:event_btHuyMouseClicked

    private void btThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThemMouseClicked
     Them();
    }//GEN-LAST:event_btThemMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
     Xoa();
    }//GEN-LAST:event_btXoaMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
     Sua();
    }//GEN-LAST:event_btSuaMouseClicked

    private void btXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXacNhanMouseClicked
      XacNhan();
    }//GEN-LAST:event_btXacNhanMouseClicked

    private void btMaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMaKHMouseClicked
      JDKH kh=new JDKH();
      String s=kh.maKH();
      txMaKH.setText(s);
    }//GEN-LAST:event_btMaKHMouseClicked

    private void btMaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMaNVMouseClicked
      JDNV nv=new JDNV();
      String s=nv.MaNV();
      txMaNV.setText(s);
    }//GEN-LAST:event_btMaNVMouseClicked

    private void btMaSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMaSachMouseClicked
      JDSP sp = null;
        try {
            sp = new JDSP();
        } catch (Exception ex) {
            Logger.getLogger(BanHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      String []s=sp.MaSP().split("%");
      if(s.length==0){
          txMaSach.setText("");
      txTenSach.setText("");
      txDonGia.setText("");
      Image newImage ;
            try{
                newImage = new ImageIcon("./src/img/SanPham/"+"").getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT);
            }catch(NullPointerException E)
            {
                newImage = new ImageIcon("./src/img/SanPham/NoImage.jpg").getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT); 
            }
            lbAnh.setText("");
            lbAnh.setIcon(new ImageIcon(newImage));
      }else{
      txMaSach.setText(s[0]);
      txTenSach.setText(s[1]);
      txDonGia.setText(s[2]);
      Image newImage ;
            try{
                newImage = new ImageIcon("./src/img/SanPham/"+s[3]).getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT);
            }catch(NullPointerException E)
            {
                newImage = new ImageIcon("./src/img/SanPham/NoImage.jpg").getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT); 
            }
            lbAnh.setText("");
            lbAnh.setIcon(new ImageIcon(newImage));}
    }//GEN-LAST:event_btMaSachMouseClicked

    private void btMaGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMaGGMouseClicked
       JDGG gg=new JDGG();
       String s=gg.LayMaGG();
       txMaGG.setText(s);
    }//GEN-LAST:event_btMaGGMouseClicked

    private void txMaSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaSachKeyPressed
       Object a=evt.getSource();
       SachBUS sach=new SachBUS();
       ArrayList<SachDTO> sa=new ArrayList<>();
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
       if(a.equals(txMaSach)){
       try{
               int dem=0;
               if(sach.getListSach()==null) sach.loadDSSach();
               sa=sach.getListSach();
                   for(SachDTO s:sa){
                   if(txMaSach.getText().toUpperCase().equals(s.getMaSach().toUpperCase())){
                       dem++;
                      txTenSach.setText(s.getTenSach());
                      txDonGia.setText(String.valueOf(s.getDongia()));
                      Image newImage ;
            try{
                newImage = new ImageIcon("./src/img/SanPham/"+s.getImgName()).getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT);
            }catch(NullPointerException E)
            {
                newImage = new ImageIcon("./src/img/SanPham/NoImage.jpg").getImage().getScaledInstance(205, 230, Image.SCALE_DEFAULT); 
            }
            lbAnh.setText("");
            lbAnh.setIcon(new ImageIcon(newImage));
                      }
                   }
                   if(dem==0){
                       JOptionPane.showMessageDialog(null,"Không tìm thấy mã sách.");
                       return ;
                   }
        }catch(Exception ex){
            System.out.println("Lỗi bấm enter.");
        }
    }
       }
    }//GEN-LAST:event_txMaSachKeyPressed
//header
    public void Header(){
        Vector header=new Vector();
        header.add("Mã sách");
        header.add("Tên sách");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Giảm giá");
        header.add("Thành tiền");
        if(model.getRowCount()==0){
            model=new DefaultTableModel(header,0);
        }
    }
//bt Tạo hóa đơn*******************************************************************
    public void TaoHD(){
        NhanVienBUS nvBUS=new NhanVienBUS();
        ArrayList<NhanVienDTO> nvDTO=new ArrayList<>();
        if(nvBUS.getDsnv()==null) 
           try {
            nvBUS.getNhanVien();
        } catch (Exception ex) {
           System.out.print("Không thể load dsnv banhang.");
        }
        nvDTO=nvBUS.getDsnv();
        if(txMaNV.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Chưa nhập mã nhân viên !!");
             return;
         }
        int dem=0;
        for(NhanVienDTO nv:nvDTO){
            if(nv.getMaNV().equals(txMaNV.getText()))
                dem++;
        }
        if(dem==0){
            JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại !!");
             return;
        }
        
        KhachHangBUS khBUS=new KhachHangBUS();
        ArrayList<KhachHangDTO> khDTO=new ArrayList<>();
        if(khBUS.dskh==null) khBUS.docDSKH();
        khDTO=khBUS.dskh;
         if(txMaKH.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Chưa nhập mã khách hàng !!");
             return;
         }
         int dem1=0;
         for(KhachHangDTO kh:khDTO){
             if(kh.getId().equals(txMaKH.getText()))
                 dem1++;
         }
         if(dem1==0){
             JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại !!");
             return;
         }   
         panelCTHD.setVisible(true);
         String date=LocalDate.now().toString();
         txNgayLap.setText(date.toString());
         Block();
    }
//block hóa đơn
    public void Block(){
        txMaKH.setEnabled(false);
        txMaNV.setEnabled(false);
        txMaGG.setEnabled(false);
    }
//bt Hủy hóa đơn********************************************************************
    public void HuyHD(boolean flag){
        Clear(flag);
        panelCTHD.setVisible(false);
        UnBlock();
    }
//unblock hóa đơn
    public void UnBlock(){
        txMaKH.setEnabled(true);
        txMaNV.setEnabled(true);
        txMaGG.setEnabled(true);
    }
//clear HĐ CTHĐ
    public void Clear(boolean flag){
        if(flag)
        //HĐ
        txMaNV.setText("");
        txMaKH.setText("");
        txMaGG.setText("");
        txNgayLap.setText("");
        //CTHD
        DSCT.removeAll(DSCT);
        txMaSach.setText("");
        txTenSach.setText("");
        txSoLuong.setText("");
        txDonGia.setText("");
        txTongTien.setText("");
        txGiamGia.setText("");
        txThanhTien.setText("");
        lbAnh.setIcon(null);
        model.getDataVector().removeAllElements(); //Xóa trằng table
    }
 //Xuất model ra table
    public void outModel(DefaultTableModel model,ArrayList<ChiTietHoaDonDTO> dsct){
        Vector row;
        model.setRowCount(0);
        for(ChiTietHoaDonDTO ct: dsct){
            row=new Vector();
            row.add(ct.getMaSach());
            row.add(ct.getTenSach());
            row.add(ct.getSoLuong());
            row.add(ct.getDonGia());
            row.add(ct.getGiamGia());
            row.add(ct.getThanhTien());
            model.addRow(row);
        }
        tbCTHD.setModel(model);
    }
//bt Thêm ***************************************************************************************
    public void Them(){
        Vector header=new Vector();
        header.add("Mã sách");
        header.add("Tên sách");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Giảm giá");
        header.add("Thành tiền");
        if(model.getRowCount()==0){
            model=new DefaultTableModel(header,0);
        }
        //số lượng
        int s=0;
        try{
            s=Integer.parseInt(txSoLuong.getText());
        }catch(NumberFormatException E)
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
                return;
         }
        if(s<=0){
            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0 !!");
             return;
        }
        // giá
        float gia=Float.parseFloat(txDonGia.getText());
        // giảm giá
        float giamgia;
        float giam = 0;
        if(txMaGG.getText().equals("")){
         giamgia=0;
        }else{
            
            ChiTietChuongTrinhGiamGiaBUS ctct=new ChiTietChuongTrinhGiamGiaBUS();
            if(ctct.dsChiTiet==null) ctct.docDSCTGG(txMaGG.getText());
            ArrayList<ChiTietChuongTrinhGiamGiaDTO> ct=new ArrayList<>();
            ct=ctct.dsChiTiet;
            for(ChiTietChuongTrinhGiamGiaDTO a:ct){
                if(a.getMaSach().equals(txMaSach.getText()))
                    giam=(float)a.getPercent();
            }
            giamgia=s*gia*giam/100;
        }
        // thành tiền
         float thanhtien=s*gia-giamgia;
        // kt tồn tại
        boolean flag=true;
        for(ChiTietHoaDonDTO ct: DSCT){
            if(txMaSach.getText().equals(ct.getMaSach())){
                JOptionPane.showMessageDialog(null, "Mặt hàng đã tồn tại");
                flag=false;
                break;
            }
        }
        for(ChiTietHoaDonDTO ct : DSCT )
            {
                System.out.println(ct.getMaSach()+" "+txMaSach.getText());
                if(ct.getMaSach().equals(txMaSach.getText()))
                {
                    int old = ct.getSoLuong();
                    if(!sachBUS.CheckSL(txMaSach.getText(), s + old))
                    {
                        return;
                    }
                    ct.setSoLuong(s + old);
                    flag = false ;
                    break;
                }
            }
        if(flag){
            if(!sachBUS.CheckSL(txMaSach.getText(), s)){
                return;
            }
            DSCT.add(new ChiTietHoaDonDTO(txMaHD.getText(),txMaSach.getText(),txTenSach.getText(),s,gia,giamgia,thanhtien));
        }
        outModel(model,DSCT);
        TongTienGiamGiaThanhTien();
        txSoLuong.setText("");
    }
// tổng tiền
    public void TongTienGiamGiaThanhTien(){
        int tongtien=0,giamgia=0,thanhtien=0,dongia;
        for(ChiTietHoaDonDTO ct: DSCT){
           giamgia=giamgia+(int)ct.getGiamGia();
           thanhtien=thanhtien+(int)ct.getThanhTien();
           tongtien=tongtien+(ct.getSoLuong()*(int)ct.getDonGia());
        }
        txTongTien.setText(String.valueOf(tongtien));
        txGiamGia.setText(String.valueOf(giamgia));
        txThanhTien.setText(String.valueOf(thanhtien));
    }
// bt xóa****************************************************************************
    public void Xoa(){
        int i=tbCTHD.getSelectedRow();
        System.out.println(i);
        if(i==-1){
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm cần xóa");
        }
        else{
        DSCT.remove(i);
        model.removeRow(i);
        }
        TongTienGiamGiaThanhTien();
    }
//bt sửa******************************************************************************
    public void Sua(){
        try{
        int i=tbCTHD.getSelectedRow();
        String masp=tbCTHD.getModel().getValueAt(i,0).toString();
        int sl=Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm :"));
        while(!sachBUS.CheckSL(masp,sl)){
        sl=Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm :"));
        }
        
         for(ChiTietHoaDonDTO ct : DSCT)
                {
                    if(ct.getMaSach().equals(masp))
                    {
                        
                        float giamgia;
                        float giam = 0;
                        float gia=ct.getDonGia();
                        if(txMaGG.getText().equals("")){
                             giamgia=0;
                        }else{
            
                          ChiTietChuongTrinhGiamGiaBUS ctct=new ChiTietChuongTrinhGiamGiaBUS();
                          if(ctct.dsChiTiet==null) ctct.docDSCTGG(txMaGG.getText());
                          ArrayList<ChiTietChuongTrinhGiamGiaDTO> ct1=new ArrayList<>();
                          ct1=ctct.dsChiTiet;
                          for(ChiTietChuongTrinhGiamGiaDTO a:ct1){
                          if(a.getMaSach().equals(txMaSach.getText())){
                                 giam=(float)a.getPercent();
                              }
                          }
                          giamgia=sl*gia*giam/100;
                          }
        // thành tiền
                        float thanhtien=sl*gia-giamgia;
                        ct.setThanhTien(thanhtien);
                        ct.setGiamGia(giamgia);
                        ct.setSoLuong(sl);
                    }
                }
                outModel(model,DSCT);
            }catch(IndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(null, "Chưa chọn SP cần sửa");
            }
        TongTienGiamGiaThanhTien();
    }
//bt xác nhận hóa đơn *****************************************************************
    public void XacNhan(){
        if(DSCT.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập sản phẩm");
                return;
        }
        String MaHD=txMaHD.getText();
        String MaKH=txMaKH.getText();
        String MaNV=txMaNV.getText();
        String MaGG=txMaGG.getText();
        String NgayLap=txNgayLap.getText();
        float TongTien=Float.parseFloat(txTongTien.getText());
        float GiamGia=Float.parseFloat(txGiamGia.getText());
        float ThanhTien=Float.parseFloat(txThanhTien.getText());
            HoaDonDTO hd=new HoaDonDTO(MaHD,MaKH,MaNV,MaGG,NgayLap,TongTien,GiamGia,ThanhTien);
            hdBUS.Them(hd);
       
        for(ChiTietHoaDonDTO ct:DSCT){
            sachBUS.updateSL(ct.getMaSach(),ct.getSoLuong());
            ctBUS.Them(ct);
        }
        txMaHD.setText(hdBUS.AutoMaHD());
        HuyHD(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btMaGG;
    private javax.swing.JButton btMaKH;
    private javax.swing.JButton btMaNV;
    private javax.swing.JButton btMaSach;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTaoHD;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JPanel panelCTHD;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTextField txDonGia;
    private javax.swing.JTextField txGiamGia;
    private javax.swing.JTextField txMaGG;
    private javax.swing.JTextField txMaHD;
    private javax.swing.JTextField txMaKH;
    private javax.swing.JTextField txMaNV;
    private javax.swing.JTextField txMaSach;
    private javax.swing.JTextField txNgayLap;
    private javax.swing.JTextField txSoLuong;
    private javax.swing.JTextField txTenSach;
    private javax.swing.JTextField txThanhTien;
    private javax.swing.JTextField txTongTien;
    // End of variables declaration//GEN-END:variables

    /*private void txMaSachKeyPressed(java.awt.event.KeyEvent e) {
     
 }*/
}
