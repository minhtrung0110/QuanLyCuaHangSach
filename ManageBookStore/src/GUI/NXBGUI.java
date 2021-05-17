/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NXBBUS;
import DTO.NXBDTO;
import DTO.NhanVienDTO;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vu
 */
public class NXBGUI extends javax.swing.JPanel {

    /**
     * Creates new form NXBGUI
     */
    public NXBGUI(int DEFAULT_WIDTH) throws Exception {
        
        initComponents();
        setSize(DEFAULT_WIDTH - 250, 680);
        init();
    }

   /* public static void main(String[] args) throws Exception
    {
        NXBGUI nxb = new NXBGUI();
        javax.swing.JFrame frame = new javax.swing.JFrame();
	frame.setSize(1000, 700);
        frame.setContentPane(new NXBGUI());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }*/
    
    DefaultTableModel  model = new DefaultTableModel();
    DefaultTableModel  temp = new DefaultTableModel();
    
    NXBBUS BNXB = new NXBBUS();
    
    public void init() throws Exception
    {
        while(model.getRowCount()>0)
    	{
    		model.removeRow(0);
    	}
        
    	tbNXB.removeAll();
        
        
        Vector header = new Vector();
        header.add("Mã NXB");
        header.add("Tên NXB");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        
        
        if (model.getRowCount()==0)
        {
            model=new DefaultTableModel(header,0);
        } 
        for (NXBDTO nxb: BNXB.list()) {
				 	
			        
            model.addRow(addNXB(nxb));
        }
       
        tbNXB.setModel(model);
        
    }
    
    
    private void Them(java.awt.event.ActionEvent evt) throws Exception {
	
         
            if(txMaNXB.getText().trim().compareTo("") != 0
               &&	txDiaChi.getText().trim().compareTo("") != 0
               &&	txTen.getText().trim().compareTo("") != 0
               &&	txSDT.getText().trim().compareTo("") != 0) {
           NXBDTO nxb=new NXBDTO();
           nxb.setMaNXB(txMaNXB.getText());
           nxb.setTenNXB(txTen.getText());
           nxb.setDiaChi(txDiaChi.getText());
           nxb.setSDT(txSDT.getText());
           
           BNXB.addNXB(nxb);
           
           model.addRow(addNXB(nxb));
           tbNXB.setModel(model);
          }
	 else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông kìa bạn ei!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
         
}
    public void Xoa() throws Exception{
	if(tbNXB.getModel() == model)
            {
              int x = tbNXB.getSelectedRow();
              if (x>=0)
		{
		 NXBDTO nxb =new NXBDTO();
		 nxb = BNXB.list().get(x);
		 
		 
		 BNXB.deleteNXB(nxb.getMaNXB());
                
		 model.removeRow(x);
		 tbNXB.setModel(model);
                
		 }
             }
        else if(tbNXB.getModel() == temp)
        {
            int x = tbNXB.getSelectedRow();
              if (x>=0)
		{
		 
		
                 BNXB.deleteNXB(tbNXB.getValueAt(x, 0).toString());
                 temp.removeRow(x);
                 init();
                 tbNXB.setModel(temp);
                }
        }
}
    private void Sua(java.awt.event.ActionEvent evt) throws Exception {
		        
        int  i=tbNXB.getSelectedRow();        
        if(txMaNXB.getText().trim().compareTo("") != 0 
            &&	txTen.getText().trim().compareTo("") != 0
            &&	txDiaChi.getText().trim().compareTo("") != 0
            &&	txSDT.getText().trim().compareTo("") != 0) {
                    if(tbNXB.getModel() == model)
			{
                            if (i>=0)
                            {
                                NXBDTO nxb=new NXBDTO();
				
                                nxb.setMaNXB(BNXB.list().get(i).getMaNXB());
				nxb.setTenNXB(txTen.getText());
				nxb.setDiaChi(txDiaChi.getText());
                                nxb.setSDT(txSDT.getText());
                               
                               
                                BNXB.updateNXB(nxb);
                                init();        
                            }
                        }
                    else if(tbNXB.getModel() == temp)
                    {
                        int x = tbNXB.getSelectedRow();
                          if (x>=0)
                            {
                             NXBDTO nxb=new NXBDTO();
                             nxb.setMaNXB(tbNXB.getValueAt(x, 0).toString());
                             nxb.setTenNXB(txTen.getText());
                             nxb.setDiaChi(txDiaChi.getText());
                             nxb.setSDT(txSDT.getText());
                             
                             BNXB.updateNXB(nxb);
                             temp.setValueAt(nxb.getTenNXB(), x, 1);
                             temp.setValueAt(nxb.getDiaChi(), x, 2);
                             temp.setValueAt(nxb.getSDT(), x, 3);
                             init();
                             tbNXB.setModel(temp);
                            }
                    }
        
    }
    else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông kìa bạn ei!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
        
}
    private void show(java.awt.event.MouseEvent evt) throws Exception {
        int  i=tbNXB.getSelectedRow();
        
       if(tbNXB.getModel() == model)
       {
	       if(i>=0)
	       {
	           NXBDTO nxb =new NXBDTO();
	           nxb=BNXB.list().get(i);
	           txMaNXB.setText(nxb.getMaNXB());
	           txDiaChi.setText(nxb.getDiaChi());
	           txTen.setText(nxb.getTenNXB());
	           txSDT.setText(nxb.getSDT());
	           
                   
	       }
       }
       else if(tbNXB.getModel() == temp)
       {
           txMaNXB.setText(tbNXB.getValueAt(i, 0).toString());
           txTen.setText(tbNXB.getValueAt(i, 1).toString());
           txDiaChi.setText(tbNXB.getValueAt(i, 2).toString());
           txSDT.setText(tbNXB.getValueAt(i, 3).toString());
           
       }
       
   }
    private void search() throws Exception
    {
    	   
    	    while(temp.getRowCount()>0)
    	    {
    	    	temp.removeRow(0);
    	    }
            Vector header = new Vector();
	        header.add("Mã NXB");
	        header.add("Tên NXB");
	        header.add("Địa chỉ");
	        header.add("Số điện thoại");
	        
	        if (temp.getRowCount()==0)
	                    { temp=new DefaultTableModel(header,0);} 
	       
	        
	        if(cbTimKiem.getSelectedItem() == "Mã NXB" )
    		{
	        	NXBDTO nxb = BNXB.timkiem_MaNXB(txTimKiem.getText());			    			
                        temp.addRow(addNXB(nxb));
                       
    		}		 
	    		
	    	if(cbTimKiem.getSelectedItem() == "Tên NXB" )
                {
                        for(NXBDTO nxb : BNXB.timkiem_TenNXB(txTimKiem.getText()))
                        {
                                temp.addRow(addNXB(nxb));
                               
                        }
                }
	    	if(cbTimKiem.getSelectedItem() == "Địa chỉ" )
                {
                        for(NXBDTO nxb : BNXB.timkiem_DiaChiNXB(txTimKiem.getText()))
                        {
                                temp.addRow(addNXB(nxb));
                                
                        }
                }
                
                if(cbTimKiem.getSelectedItem() == "Số điện thoại" )
                {
                        for(NXBDTO nxb : BNXB.timkiem_SDT(txTimKiem.getText()))
                        {
                                temp.addRow(addNXB(nxb));
                                
                        }
                }
      		
            if(tbNXB.getModel() == model)
            tbNXB.removeAll();
            tbNXB.setModel(temp);   	
    }      
    
    private Vector addNXB(NXBDTO nxb)
    {
    		Vector row=new Vector();
	        row.add(nxb.getMaNXB());
	        row.add(nxb.getTenNXB());
	        row.add(nxb.getDiaChi());
	        row.add(nxb.getSDT());
	       
	        return row;

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNXB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txMaNXB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txDiaChi = new javax.swing.JTextField();
        txTen = new javax.swing.JTextField();
        txSDT = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNXB = new javax.swing.JTable();
        lbTimkiem = new javax.swing.JLabel();
        cbTimKiem = new javax.swing.JComboBox<>();
        txTimKiem = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbNXB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNXB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNXB.setText("Nhà xuất bản ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNXB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mã NXB");

        txMaNXB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txMaNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMaNXBActionPerformed(evt);
            }
        });
        txMaNXB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMaNXBKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Địa chỉ:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SDT:");

        txDiaChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDiaChiActionPerformed(evt);
            }
        });
        txDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDiaChiKeyPressed(evt);
            }
        });

        txTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTenActionPerformed(evt);
            }
        });
        txTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTenKeyPressed(evt);
            }
        });

        txSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThem.setBackground(new java.awt.Color(255, 255, 255));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThem.setText("Thêm");
        btThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153), 2));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoa.setText("Xóa");
        btXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSua.setText("Sửa");
        btSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204)));
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        tbNXB.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNXBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNXB);

        lbTimkiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTimkiem.setText("Tìm kiếm:");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NXB", "Tên NXB", "Địa chỉ", "Số điện thoại" }));

        txTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        btTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTimKiem.setText("Tìm kiếm");
        btTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        btLoad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btLoad.setText("ALL");
        btLoad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        btLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txMaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                        .addGap(112, 112, 112)
                        .addComponent(lbTimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(btLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txMaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTimkiem)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btTimKiem)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        try {
            Them(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể thêm NXB này");
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        try {
            Xoa();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Không thể xóa NXB này");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        try {
            Sua(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể sửa NXB này");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void tbNXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNXBMouseClicked
        try {
            show(evt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tbNXBMouseClicked

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        try {
            search();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoadActionPerformed
       if(tbNXB.getModel() == temp)
       {
           tbNXB.removeAll();
           tbNXB.setModel(model);
       }
    }//GEN-LAST:event_btLoadActionPerformed

    private void txMaNXBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaNXBKeyPressed
        if(evt.getKeyCode() == 10)
        {
           txTen.requestFocus();
        }
    }//GEN-LAST:event_txMaNXBKeyPressed

    private void txTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenActionPerformed
        
    }//GEN-LAST:event_txTenActionPerformed

    private void txDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDiaChiActionPerformed
      
    }//GEN-LAST:event_txDiaChiActionPerformed

    private void txMaNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMaNXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMaNXBActionPerformed

    private void txTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTenKeyPressed
       if(evt.getKeyCode() == 10)
        {
           txDiaChi.requestFocus();
        }
    }//GEN-LAST:event_txTenKeyPressed

    private void txDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDiaChiKeyPressed
        if(evt.getKeyCode() == 10)
        {
           txSDT.requestFocus();
        }
    }//GEN-LAST:event_txDiaChiKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNXB;
    private javax.swing.JLabel lbTimkiem;
    private javax.swing.JTable tbNXB;
    private javax.swing.JTextField txDiaChi;
    private javax.swing.JTextField txMaNXB;
    private javax.swing.JTextField txSDT;
    private javax.swing.JTextField txTen;
    private javax.swing.JTextField txTimKiem;
    // End of variables declaration//GEN-END:variables
}
