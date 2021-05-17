/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NCCBUS;
import DTO.NCCDTO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vu
 */
public class NCCGUI extends javax.swing.JPanel {

    /**
     * Creates new form NCCGUI
     */
    public NCCGUI() {
        initComponents();
    }
    public NCCGUI(int DEFAULT_WIDTH) throws Exception {
        
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
    
    NCCBUS BNCC = new NCCBUS();
    
    public void init() throws Exception
    {
        while(model.getRowCount()>0)
    	{
    		model.removeRow(0);
    	}
        
    	tbNCC.removeAll();
        
        
        Vector header = new Vector();
        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        
        
        
        if (model.getRowCount()==0)
        {
            model=new DefaultTableModel(header,0);
        } 
        for (NCCDTO ncc: BNCC.list()) {
				 	
			        
            model.addRow(addNCC(ncc));
        }
       
        tbNCC.setModel(model);
        
    }
    
    
    private void Them(java.awt.event.ActionEvent evt) throws Exception {
	
         
            if(txMaNCC.getText().trim().compareTo("") != 0
               &&	txDiaChi.getText().trim().compareTo("") != 0
               &&	txTenNCC.getText().trim().compareTo("") != 0) {
                NCCDTO ncc=new NCCDTO();
                ncc.setMaNCC(txMaNCC.getText());
                ncc.setTenNCC(txTenNCC.getText());
                ncc.setDiaChi(txDiaChi.getText());
              
                BNCC.addNCC(ncc);

                model.addRow(addNCC(ncc));
                tbNCC.setModel(model);
          }
	 else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông kìa bạn ei!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
         
}
    public void Xoa() throws Exception{
	if(tbNCC.getModel() == model)
            {
              int x = tbNCC.getSelectedRow();
              if (x>=0)
		{
		 NCCDTO ncc =new NCCDTO();
		 ncc = BNCC.list().get(x);
		 
		 
		 BNCC.deleteNCC(ncc.getMaNCC());
                
		 model.removeRow(x);
		 tbNCC.setModel(model);
                
		 }
             }
        else if(tbNCC.getModel() == temp)
        {
            int x = tbNCC.getSelectedRow();
              if (x>=0)
		{
		 
		
                 BNCC.deleteNCC(tbNCC.getValueAt(x, 0).toString());
                 temp.removeRow(x);
                 init();
                 tbNCC.setModel(temp);
                }
        }
}
    private void Sua(java.awt.event.ActionEvent evt) throws Exception {
		        
        int  i=tbNCC.getSelectedRow();        
        if(txMaNCC.getText().trim().compareTo("") != 0 
            &&	txTenNCC.getText().trim().compareTo("") != 0
            &&	txDiaChi.getText().trim().compareTo("") != 0) {
                    if(tbNCC.getModel() == model)
			{
                            if (i>=0)
                            {
                                NCCDTO ncc=new NCCDTO();
				
                                ncc.setMaNCC(BNCC.list().get(i).getMaNCC());
				ncc.setTenNCC(txTenNCC.getText());
				ncc.setDiaChi(txDiaChi.getText());
                                
                               
                               
                                BNCC.updateNCC(ncc);
                                init();        
                            }
                        }
                    else if(tbNCC.getModel() == temp)
                    {
                        int x = tbNCC.getSelectedRow();
                          if (x>=0)
                            {
                             NCCDTO ncc=new NCCDTO();
                             ncc.setMaNCC(tbNCC.getValueAt(x, 0).toString());
                             ncc.setTenNCC(txTenNCC.getText());
                             ncc.setDiaChi(txDiaChi.getText());
                             
                             
                             BNCC.updateNCC(ncc);
                             temp.setValueAt(ncc.getTenNCC(), x, 1);
                             temp.setValueAt(ncc.getDiaChi(), x, 2);
                            
                             init();
                             tbNCC.setModel(temp);
                            }
                    }
        
    }
    else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông kìa bạn ei!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
        
}
    private void show(java.awt.event.MouseEvent evt) throws Exception {
        int  i=tbNCC.getSelectedRow();
        
       if(tbNCC.getModel() == model)
       {
	       if(i>=0)
	       {
	           NCCDTO ncc =new NCCDTO();
	           ncc=BNCC.list().get(i);
	           txMaNCC.setText(ncc.getMaNCC());
	           txDiaChi.setText(ncc.getDiaChi());
	           txTenNCC.setText(ncc.getTenNCC());
	       }
       }
       else if(tbNCC.getModel() == temp)
       {
           txMaNCC.setText(tbNCC.getValueAt(i, 0).toString());
           txTenNCC.setText(tbNCC.getValueAt(i, 1).toString());
           txDiaChi.setText(tbNCC.getValueAt(i, 2).toString());
       }
       
   }
    private void search() throws Exception
    {
    	   
    	    while(temp.getRowCount()>0)
    	    {
    	    	temp.removeRow(0);
    	    }
            Vector header = new Vector();
	        header.add("Mã NCC");
	        header.add("Tên NCC");
	        header.add("Địa chỉ");
	        

            if (temp.getRowCount()==0)
                        { temp=new DefaultTableModel(header,0);} 


            if(cbTimKiem.getSelectedItem() == "Mã NCC" )
            {
                    NCCDTO ncc = BNCC.timkiem_MaNCC(txTimKiem.getText());			    			
                    temp.addRow(addNCC(ncc));

            }		 

            if(cbTimKiem.getSelectedItem() == "Tên NCC" )
            {
                    for(NCCDTO ncc : BNCC.timkiem_TenNCC(txTimKiem.getText()))
                    {
                            temp.addRow(addNCC(ncc));

                    }
            }
            if(cbTimKiem.getSelectedItem() == "Địa chỉ" )
            {
                    for(NCCDTO ncc : BNCC.timkiem_DiaChi(txTimKiem.getText()))
                    {
                            temp.addRow(addNCC(ncc));

                    }
            }	
            if(tbNCC.getModel() == model)
            tbNCC.removeAll();
            tbNCC.setModel(temp);   	
    }      
    
    private Vector addNCC(NCCDTO ncc)
    {
        Vector row=new Vector();
        row.add(ncc.getMaNCC());
        row.add(ncc.getTenNCC());
        row.add(ncc.getDiaChi());
        return row;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbThongBao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNCC = new javax.swing.JTable();
        btTimKiem = new javax.swing.JButton();
        txTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        btALL = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        lbMaNCC = new javax.swing.JLabel();
        txMaNCC = new javax.swing.JTextField();
        lbTenNCC = new javax.swing.JLabel();
        txTenNCC = new javax.swing.JTextField();
        lbDiachi = new javax.swing.JLabel();
        txDiaChi = new javax.swing.JTextField();

        lbThongBao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThongBao.setText("NHÀ CUNG CẤP");

        tbNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNCC);

        btTimKiem.setBackground(new java.awt.Color(153, 153, 153));
        btTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTimKiem.setText("Tìm");
        btTimKiem.setActionCommand("Tìm ");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NCC", "Tên NCC", "Địa chỉ" }));

        btALL.setBackground(new java.awt.Color(153, 153, 153));
        btALL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btALL.setText("Tất Cả");
        btALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btALLActionPerformed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(153, 153, 153));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(153, 153, 153));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(153, 153, 153));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        lbMaNCC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbMaNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMaNCC.setText("Mã NCC:");

        txMaNCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMaNCCKeyPressed(evt);
            }
        });

        lbTenNCC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTenNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenNCC.setText("Tên NCC:");

        txTenNCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTenNCCKeyPressed(evt);
            }
        });

        lbDiachi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDiachi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiachi.setText("Địa chỉ:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btXoa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txTenNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(txDiaChi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSua)
                    .addComponent(btXoa)
                    .addComponent(btThem))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(btTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btALL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lbThongBao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btALL)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btTimKiem)
                                .addComponent(txTimKiem)))
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        try {
            Them(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        try {
            Xoa();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        try {
            Sua(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể sửa NCC này");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        try {
            search();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");
        }
        
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btALLActionPerformed
        if(tbNCC.getModel() == temp)
        {
            tbNCC.removeAll();
            tbNCC.setModel(model);
        }
    }//GEN-LAST:event_btALLActionPerformed

    private void tbNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNCCMouseClicked
        try {
            show(evt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tbNCCMouseClicked

    private void txMaNCCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaNCCKeyPressed
        if(evt.getKeyCode() == 10)
        {
            txTenNCC.requestFocus();
        }
    }//GEN-LAST:event_txMaNCCKeyPressed

    private void txTenNCCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTenNCCKeyPressed
         if(evt.getKeyCode() == 10)
        {
            txDiaChi.requestFocus();
        }
    }//GEN-LAST:event_txTenNCCKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btALL;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiachi;
    private javax.swing.JLabel lbMaNCC;
    private javax.swing.JLabel lbTenNCC;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tbNCC;
    private javax.swing.JTextField txDiaChi;
    private javax.swing.JTextField txMaNCC;
    private javax.swing.JTextField txTenNCC;
    private javax.swing.JTextField txTimKiem;
    // End of variables declaration//GEN-END:variables
}
