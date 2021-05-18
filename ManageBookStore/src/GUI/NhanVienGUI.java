/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import com.sun.jdi.connect.spi.Connection;


import DAO.MyConnectUnit;

import DTO.NhanVienDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.CellBase;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.*;
import java.awt.print.*;

import com.itextpdf.text.FontFactory;
import java.util.Date;

/**
 *
 * @author Vu
 */
public class NhanVienGUI extends javax.swing.JPanel {
   
    /**
     * Creates new form NhanVien
     */
    
     public NhanVienGUI(int width) throws Exception {
        initComponents();
        
        setSize(1050, 680);
        init();
    }
    
    private NhanVienBUS BNV = new NhanVienBUS();
    
    DefaultTableModel  model = new DefaultTableModel();
    DefaultTableModel  temp = new DefaultTableModel();
    
    
    
     private void Them(java.awt.event.ActionEvent evt) throws Exception {
	
         
            if(txID.getText().trim().compareTo("") != 0 
               &&	txHo.getText().trim().compareTo("") != 0
               &&	txTen.getText().trim().compareTo("") != 0
               &&	txDT.getText().trim().compareTo("") != 0
               &&	txEmail.getText().trim().compareTo("") != 0
               &&	txLuong.getText().trim().compareTo("") != 0
               &&	txChucVu.getText().trim().compareTo("") != 0) {
                boolean id_check = true;
                for(NhanVienDTO n : BNV.list() )
                {
                    if(n.getMaNV().compareTo(txID.getText().toString()) == 0)
                    {
                        id_check = false;
                        break;
                    }
                }
                if(id_check == true)
                {
                    NhanVienDTO nv=new NhanVienDTO();
                    nv.setMaNV(txID.getText());
                    nv.setHo(txHo.getText());
                    nv.setTen(txTen.getText());
                    nv.setSDT(txDT.getText());
                    nv.setEmail(txEmail.getText());
                    
                    nv.setPhai(rbNam.isSelected());
                    
                    nv.setChucVu(txChucVu.getText());
                    nv.setLuong(Double.parseDouble(txLuong.getText()));
                    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
                    String date  = sdf.format(txNgaySinh.getDate());
                    nv.setngaysinh(date);
                    BNV.Insert(nv);

                    model.addRow(addNV(nv));
                    tbNV.setModel(model);
                } else JOptionPane.showMessageDialog(null, "Mã nhân viên đã được sử dụng");
          }
	 else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông tin!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
         
}
         
         
    public void Xoa(int x) throws Exception{
	if(tbNV.getModel() == model)
            {
              if (x>=0)
		{
                    NhanVienDTO nv =new NhanVienDTO();
                    nv = BNV.list().get(x);
                    String Condition = "MaNV = '" + nv.getMaNV().toString() + "'";
                    BNV.Delete(nv);               
                    model.removeRow(x);
                    tbNV.setModel(model);              
		 }
             }
        if(tbNV.getModel() == temp)
            {
              if (x>=0)
		{
                    NhanVienDTO nv =new NhanVienDTO();
                    for(NhanVienDTO n : BNV.list())
                    {
                        if(n.getMaNV() == temp.getValueAt(x, 0))
                        {
                            nv = n;
                            break;
                        }
                    }
                    String Condition = "MaNV = '" + nv.getMaNV().toString() + "'";
                    BNV.Delete(nv);               
                    temp.removeRow(x);
                    
                    for(int i =0;i<model.getRowCount();i++)
                    {
                        if(model.getValueAt(i, 0) == nv.getMaNV())
                        {
                            model.removeRow(i);
                            break;
                        }
                    }
                    
                    
                    tbNV.setModel(temp);              
		 }
             }
}
	
    private void Sua(java.awt.event.ActionEvent evt) throws Exception {
		        
        int  i=tbNV.getSelectedRow();        
        if(txID.getText().trim().compareTo("") != 0 
            &&	txHo.getText().trim().compareTo("") != 0
            &&	txTen.getText().trim().compareTo("") != 0
            &&	txDT.getText().trim().compareTo("") != 0
            &&	txEmail.getText().trim().compareTo("") != 0
            &&	txLuong.getText().trim().compareTo("") != 0
            &&	txChucVu.getText().trim().compareTo("") != 0) {
                if(tbNV.getModel() == model)
                    {
                        if (i>=0)
                        {
                            NhanVienDTO nv=new NhanVienDTO();
                            nv.setMaNV(BNV.list().get(i).getMaNV());
                            nv.setHo(txHo.getText());
                            nv.setTen(txTen.getText());
                            nv.setSDT(txDT.getText());
                            nv.setPhai(rbNam.isSelected());
                            nv.setEmail(txEmail.getText());
                            nv.setLuong( Double.parseDouble(txLuong.getText()));
                            nv.setChucVu(txChucVu.getText());
                            
                            if(txNgaySinh.getDate() == null)
                            {
                             nv.setngaysinh(BNV.list().get(i).getngaysinh());
                             txTimKiem.setText("122");
                            } else{
                                SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
                                String date  = sdf.format(txNgaySinh.getDate());
                                nv.setngaysinh(date);
                            }
                            BNV.Update(nv,i);
                            init();        
                        }
                    }
         
    }
    else JOptionPane.showMessageDialog(null,"Chưa điền đầy đủ thông tin!!!!", "thông báo",JOptionPane.INFORMATION_MESSAGE);
        
}
                
                
    private void show(java.awt.event.MouseEvent evt) throws Exception {
        int  i=tbNV.getSelectedRow();
        
       if(tbNV.getModel() == model)
       {
	       if(i>=0)
	       {
	           txID.setText(model.getValueAt(i, 0).toString());
                   txHo.setText(model.getValueAt(i, 1).toString());
                   txTen.setText(model.getValueAt(i, 2).toString());
                   txDT.setText(model.getValueAt(i, 3).toString());
                   txEmail.setText(model.getValueAt(i, 4).toString());
                   txLuong.setText(model.getValueAt(i, 7).toString());
                   txChucVu.setText(model.getValueAt(i, 6).toString());
                   String[] date = model.getValueAt(i, 8).toString().split("-", 3);
                   Date selected = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2]));
                   txNgaySinh.setDate(selected);
                    if(model.getValueAt(i, 5).toString().compareTo("Nam") == 0)
                    {
                        rbNam.setSelected(true);
                    } else rbNu.setSelected(true);
	       }
       }
       else
       {
    	   txID.setText(temp.getValueAt(i, 0).toString());
           txHo.setText(temp.getValueAt(i, 1).toString());
           txTen.setText(temp.getValueAt(i, 2).toString());
           txDT.setText(temp.getValueAt(i, 3).toString());
           txEmail.setText(temp.getValueAt(i, 4).toString());
           txLuong.setText(temp.getValueAt(i, 7).toString());
           txChucVu.setText(temp.getValueAt(i, 6).toString());
           String[] date = temp.getValueAt(i, 8).toString().split("-", 3);
           Date selected = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2]));
           txNgaySinh.setDate(selected);
           
       }
       
   }
    
    private Vector addNV(NhanVienDTO nv)
    {
    		Vector row=new Vector();
	        row.add(nv.getMaNV());
	        row.add(nv.getHo());
	        row.add(nv.getTen());
	        row.add(nv.getSDT());
	        row.add(nv.getEmail());
	        if(nv.isPhai() == 1)
	        {
	        	row.add("Nam");
	        }else row.add("Nữ");
	        row.add(nv.getChucVu());
	        row.add(nv.getLuong());
                row.add(nv.getngaysinh());
	        return row;

    }
    
    private void search() throws Exception
    {
    	   
    	    while(temp.getRowCount()>0)
    	    {
    	    	temp.removeRow(0);
    	    }
            Vector header = new Vector();
	        header.add("Mã NV");
	        header.add("Họ");
	        header.add("Tên");
	        header.add("Số điện thoại");
	        header.add("Email");
	        header.add("Phái");
	        header.add("Chức vụ");
	        header.add("Lương");
                header.add("ngày sinh");
	        if (temp.getRowCount()==0)
	                    { temp=new DefaultTableModel(header,0);} 
	       
	        int n =0;
	        if(cbTimKiem.getSelectedItem() == "MaNV" )
    		{
	        	NhanVienDTO nv = BNV.timkiem_MaNV(txTimKiem.getText());			    			
                        temp.addRow(addNV(nv));
                        n++;	
    		}		 
	    		
	    	if(cbTimKiem.getSelectedItem() == "Họ" )
                {
                        for(NhanVienDTO nv : BNV.timkiem_Ho(txTimKiem.getText()))
                        {
                                temp.addRow(addNV(nv));
                                n++;
                        }
                }
	    	if(cbTimKiem.getSelectedItem() == "Tên" )
                {
                        for(NhanVienDTO nv : BNV.timkiem_Ten(txTimKiem.getText()))
                        {

                                temp.addRow(addNV(nv));
                                n++;
                        }
                }
	    	if(cbTimKiem.getSelectedItem() == "SĐT" )
                {
                        for(NhanVienDTO nv : BNV.timkiem_SDT(txTimKiem.getText()))
                        {

                                temp.addRow(addNV(nv));
                                n++;
                        }
                }
	    		
	    	if(cbTimKiem.getSelectedItem() == "Email" )
                {
                        for(NhanVienDTO nv : BNV.timkiem_Email(txTimKiem.getText()))
                        {

                                temp.addRow(addNV(nv));
                                n++;
                        }
                }
	    	if(cbTimKiem.getSelectedItem() == "Lương" )
	    		{
                            for(NhanVienDTO nv : BNV.timkiem_Luong(Double.parseDouble(txTimKiem.getText())))
                            {
                                    temp.addRow(addNV(nv));
                                    n++;
                            }
	    		}
	    		
	    	if(cbTimKiem.getSelectedItem() == "Giới tính" )
                {
                    if(txTimKiem.getText().compareTo("Nam") == 0)
                    {
                        for(NhanVienDTO nv : BNV.timkiem_Nam())
                        {
                                temp.addRow(addNV(nv));
                                n++;
                        }
                    }
                    else if(txTimKiem.getText().compareTo("Nữ") == 0)
                    {
                       for(NhanVienDTO nv : BNV.timkiem_Nu())
                        {
                                temp.addRow(addNV(nv));
                                n++;
                        }
                    }
                }
                
                if(cbTimKiem.getSelectedItem() == "Chức vụ" )
                {  
                    for(NhanVienDTO nv : BNV.timkiem_ChucVu(txTimKiem.getText()))
                        {

                                temp.addRow(addNV(nv));
                                n++;
                        }  
                }
                if(cbTimKiem.getSelectedItem() == "Ngày sinh" )
                {  
                    for(NhanVienDTO nv : BNV.timkiem_Ngaysinh(txTimKiem.getText()))
                        {

                                temp.addRow(addNV(nv));
                                n++;
                        }  
                }            
    lbKQ.setText(Integer.toString(n) + " nhân viên");   		
    if(tbNV.getModel() == model)
     tbNV.removeAll();
    tbNV.setModel(temp);   	
    }      
    
    
    private void TimKiemNC() throws Exception
    {
    	   
    	    while(temp.getRowCount()>0)
    	    {
    	    	temp.removeRow(0);
    	    }
            Vector header = new Vector();
	        header.add("Mã NV");
	        header.add("Họ");
	        header.add("Tên");
	        header.add("Số điện thoại");
	        header.add("Email");
	        header.add("Phái");
	        header.add("Chức vụ");
	        header.add("Lương");
                header.add("ngày sinh");
	        if (temp.getRowCount()==0)
	                    { temp=new DefaultTableModel(header,0);} 
	       
	        int n =0;
	        
	    	if(cbTimKiemNC.getSelectedItem() == "Lương" )
	    		{
                            String begin = txBegin.getText();
                            String end = txEnd.getText();
                            for(NhanVienDTO nv : BNV.timkiemNC_Luong(begin,end))
                            {
                                    temp.addRow(addNV(nv));
                                    n++;
                            }
	    		}
	    		
	    	if(cbTimKiemNC.getSelectedItem() == "Ngày sinh" )
	    		{
                            String begin = txBegin.getText();
                            String end = txEnd.getText();
                            for(NhanVienDTO nv : BNV.timkiemNC_Ngaysinh(begin,end))
                            {
                                    temp.addRow(addNV(nv));
                                    n++;
                            }
		    	}	    	
        lbKetQua.setText("Kết Quả: " +Integer.toString(n)+  " nhân viên");   		
        if(tbNV.getModel() == model)
        tbNV.removeAll();
        tbNV.setModel(temp); 	
    }      
    
    
    
     public void init() throws Exception
    {
    	while(model.getRowCount()>0)
    	{
    		model.removeRow(0);
    	}
        
    	tbNV.removeAll();
    	 Vector header = new Vector();
	        header.add("Mã NV");
	        header.add("Họ");
	        header.add("Tên");
	        header.add("Số điện thoại");
	        header.add("Email");
	        header.add("Phái");
	        header.add("Chức vụ");
	        header.add("Lương");
                header.add("Ngày sinh");
	        if (model.getRowCount()==0)
	                    { model=new DefaultTableModel(header,0);} 
	        
			 for (NhanVienDTO nv: BNV.list()) {
				 	
			        
			        model.addRow(addNV(nv));
	            }
                 tbNV.setModel(model);
               
    }
    
    
    
    
    TableCellRenderer renderer = new TableCellRenderer() {

        JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
        	
            label.setOpaque(true);
            label.setText("" + value);
           
           
            if(isSelected)
            {
            	 label.setBackground(Color.decode("#002aff"));
            	 label.setForeground(Color.WHITE);
            }
            
            if (row % 2 == 1 && !isSelected ) {
                label.setBackground(Color.decode("#c1c9c4"));
                label.setForeground(Color.BLACK);
                
            } else if(!isSelected){
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
            }
       
            return label;
        }
        
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        lbID = new javax.swing.JLabel();
        lbHo = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbDT = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbLuong = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNV = new javax.swing.JTable();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        cbTimKiem = new javax.swing.JComboBox<>();
        txTimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbNV = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        txHo = new javax.swing.JTextField();
        txTen = new javax.swing.JTextField();
        txDT = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txChucVu = new javax.swing.JTextField();
        txLuong = new javax.swing.JTextField();
        btThem = new java.awt.Button();
        btXoa = new java.awt.Button();
        btSua = new java.awt.Button();
        txNgaySinh = new com.toedter.calendar.JDateChooser();
        lbGioiTinh = new javax.swing.JLabel();
        lbNgaySinh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbTimKiemNC = new javax.swing.JComboBox<>();
        txBegin = new javax.swing.JTextField();
        txEnd = new javax.swing.JTextField();
        lbKetQua = new javax.swing.JLabel();
        btTimKiemNC = new java.awt.Button();
        btImportExcel = new java.awt.Button();
        btInit = new java.awt.Button();
        btExportExcel = new java.awt.Button();
        btPDF = new java.awt.Button();
        btTimKiem = new java.awt.Button();
        btALL = new java.awt.Button();
        lbKQ = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbID.setText("Mã NV:");

        lbHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbHo.setText("Họ:");

        lbTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTen.setText("Tên:");

        lbDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDT.setText("SDT:");

        lbEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbEmail.setText("Email:");

        lbLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbLuong.setText("Lương:");

        lbChucVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbChucVu.setText("Chức vụ:");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tbNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNV);

        rbNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNam);
        rbNam.setText("Nam");
        rbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNamActionPerformed(evt);
            }
        });

        rbNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNu);
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaNV", "Họ", "Tên", "SĐT", "Email", "Giới tính", "Lương", "Chức vụ", "Ngày sinh" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lbNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNV.setForeground(new java.awt.Color(0, 51, 51));
        lbNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNV.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txIDKeyPressed(evt);
            }
        });

        txHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txHoKeyPressed(evt);
            }
        });

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

        txDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDTActionPerformed(evt);
            }
        });
        txDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDTKeyPressed(evt);
            }
        });

        txEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txEmailKeyPressed(evt);
            }
        });

        txLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txLuongActionPerformed(evt);
            }
        });
        txLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txLuongKeyPressed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(153, 153, 153));
        btThem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThem.setForeground(new java.awt.Color(255, 255, 255));
        btThem.setLabel("Thêm");
        btThem.setName(""); // NOI18N
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(153, 153, 153));
        btXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setLabel("Xóa");
        btXoa.setName(""); // NOI18N
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(153, 153, 153));
        btSua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSua.setForeground(new java.awt.Color(255, 255, 255));
        btSua.setLabel("Sửa");
        btSua.setName(""); // NOI18N
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        lbGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        lbNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNgaySinh.setText("Ngày sinh:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm nâng cao");

        cbTimKiemNC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lương", "Ngày sinh" }));

        txEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEndActionPerformed(evt);
            }
        });

        lbKetQua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKetQua.setForeground(new java.awt.Color(255, 0, 0));
        lbKetQua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btTimKiemNC.setBackground(new java.awt.Color(153, 153, 153));
        btTimKiemNC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btTimKiemNC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTimKiemNC.setForeground(new java.awt.Color(255, 255, 255));
        btTimKiemNC.setLabel("Tìm kiếm");
        btTimKiemNC.setName(""); // NOI18N
        btTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemNCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbTimKiemNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTimKiemNC, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTimKiemNC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btTimKiemNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btImportExcel.setBackground(new java.awt.Color(153, 153, 153));
        btImportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btImportExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btImportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btImportExcel.setLabel("Import Excel");
        btImportExcel.setName(""); // NOI18N
        btImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportExcelActionPerformed(evt);
            }
        });

        btInit.setBackground(new java.awt.Color(153, 153, 153));
        btInit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btInit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInit.setForeground(new java.awt.Color(255, 255, 255));
        btInit.setLabel("load DB");
        btInit.setName(""); // NOI18N
        btInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInitActionPerformed(evt);
            }
        });

        btExportExcel.setBackground(new java.awt.Color(153, 153, 153));
        btExportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btExportExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btExportExcel.setLabel("Export Excel");
        btExportExcel.setName(""); // NOI18N
        btExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportExcelActionPerformed(evt);
            }
        });

        btPDF.setBackground(new java.awt.Color(153, 153, 153));
        btPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btPDF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btPDF.setForeground(new java.awt.Color(255, 255, 255));
        btPDF.setLabel("Report PDF");
        btPDF.setName(""); // NOI18N
        btPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDFActionPerformed(evt);
            }
        });

        btTimKiem.setBackground(new java.awt.Color(153, 153, 153));
        btTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btTimKiem.setLabel("Tìm kiếm");
        btTimKiem.setName(""); // NOI18N
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        btALL.setBackground(new java.awt.Color(153, 153, 153));
        btALL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btALL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btALL.setForeground(new java.awt.Color(255, 255, 255));
        btALL.setLabel("ALL");
        btALL.setName(""); // NOI18N
        btALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btALLActionPerformed(evt);
            }
        });

        lbKQ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKQ.setForeground(new java.awt.Color(255, 0, 0));
        lbKQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbEmail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txEmail))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbTen)
                                                    .addComponent(lbID))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txID, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                                    .addComponent(txTen)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbGioiTinh)
                                                .addGap(30, 30, 30)
                                                .addComponent(rbNam)
                                                .addGap(41, 41, 41)
                                                .addComponent(rbNu))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbChucVu)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbNgaySinh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbDT)
                                            .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbLuong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txHo)
                                    .addComponent(txDT)
                                    .addComponent(txLuong)
                                    .addComponent(txNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(29, 29, 29)
                                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btALL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(lbKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHo))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDT))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLuong))
                        .addGap(11, 11, 11)
                        .addComponent(txNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbID)
                                            .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbTen)
                                            .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbEmail)
                                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbChucVu)
                                    .addComponent(txChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNgaySinh))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(txTimKiem)
                                    .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lbKQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbNu)
                                    .addComponent(rbNam)
                                    .addComponent(lbGioiTinh))
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNamActionPerformed
       
    }//GEN-LAST:event_rbNamActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        try {
            show(evt);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        try {
            Them(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể thêm nhân viên này");
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int x = tbNV.getSelectedRow();
        try {
            Xoa(x);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Không Thể Xóa Nhân Viên Này Vì Dữ Liệu Của Nhân Viên Tác Động Đến Các Chức Năng Khác Của Hệ Thống!");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        try {
            Sua(evt);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Không thể sửa nhân viên này");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void tbNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNVMouseClicked
        try {
            show(evt);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbNVMouseClicked

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
      
    }//GEN-LAST:event_rbNuActionPerformed

    private void txLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txLuongActionPerformed

    private void txTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTenActionPerformed

    private void txDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDTActionPerformed

    private void txEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEndActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        lbKetQua.setText("");
        lbKQ.setText("");
    }//GEN-LAST:event_formMouseClicked

    private void btImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportExcelActionPerformed
        
        
        while(temp.getRowCount()>0)
        {
            temp.removeRow(0);
        }
        Vector header = new Vector();
	        header.add("Mã NV");
	        header.add("Họ");
	        header.add("Tên");
	        header.add("Số điện thoại");
	        header.add("Email");
	        header.add("Phái");
	        header.add("Chức vụ");
	        header.add("Lương");
                header.add("Ngày sinh");
	        if (temp.getRowCount()==0)
	                    { temp =new DefaultTableModel(header,0);} 
        
        ArrayList<NhanVienDTO> l = new ArrayList<NhanVienDTO>();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        String path = "C:";
        XSSFWorkbook excelJTableImport = null;
        JFileChooser excelFileChooser = new JFileChooser(path);
        
        int excelchooser = excelFileChooser.showOpenDialog(null);
        if(excelchooser == JFileChooser.APPROVE_OPTION){
            excelFile = excelFileChooser.getSelectedFile();
            try { 
                excelFIS =  new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
            XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
            for(int row = 0 ; row <= excelSheet.getLastRowNum() ; row++)
            {
                Vector  result= new Vector();
                NhanVienDTO nv = new NhanVienDTO();
                XSSFRow excelRow = excelSheet.getRow(row);
                for(int column = 0 ; column <= excelRow.getLastCellNum(); column++)
                {
                    
                    XSSFCell excelCell = excelRow.getCell(column);
                    
                    
                    if(column == 0)
                    {
                        nv.setMaNV(excelCell.toString());
                    }
                    
                    if(column == 1)
                    {
                        nv.setHo(excelCell.toString());
                    }
                    if(column == 2)
                    {
                        nv.setTen(excelCell.toString());
                    }
                    if(column == 4)
                    {
                        nv.setEmail(excelCell.toString());
                    }
                    if(column == 3)
                    {
                        nv.setSDT(excelCell.toString());
                    }
                    if(column == 5)
                    {
                        if(excelCell.toString().indexOf("Nam")!= -1)
                        {
                            nv.setPhai(true);
                        }else nv.setPhai(false);
                    }
                    if(column == 6)
                    {
                        nv.setChucVu(excelCell.toString());
                    }
                    if(column == 7)
                    {
                        nv.setLuong(Double.parseDouble(excelCell.toString()));
                    }
                    if(column == 8)
                    {
                        nv.setngaysinh(excelCell.toString());
                    }
                    
                    System.out.println(excelCell);
                    result.add(excelCell);
                    
                    
                }
                
                
                    try {
                       
                        BNV.Insert(nv);
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                l.add(nv);
                 temp.addRow(result);
            }
        }catch (FileNotFoundException ex)
                {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            }
        for(NhanVienDTO ns : l)
        {
            System.out.println(ns.toString());
        }
        
        tbNV.removeAll();
        tbNV.setModel(temp);
    }//GEN-LAST:event_btImportExcelActionPerformed

    private void btInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInitActionPerformed
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btInitActionPerformed

    private void btExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportExcelActionPerformed
       
        String path = "C:";
        FileOutputStream excelFOU = null ;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExport =null;
        
        JFileChooser excelFileChooser = new JFileChooser(path);
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE","xls","xlsx","xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelchooser = excelFileChooser.showOpenDialog(null);
        if(excelchooser == JFileChooser.APPROVE_OPTION){
            
            try {
                
                excelJTableExport = new XSSFWorkbook() ;
                XSSFSheet excelSheet = excelJTableExport.createSheet("JTable Sheet");
                for(int i =0; i < model.getRowCount();i++)
                {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for(int j =0 ; j < model.getColumnCount() ; j++)
                    {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                        
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                
                excelJTableExport.write(excelBOU);
                JOptionPane.showMessageDialog(null,"success");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
               ex.printStackTrace();
            } finally {
                try {
                    if(excelBOU != null)
                    {
                        excelBOU.close();
                    }
                    if(excelFOU != null)
                    {
                        excelFOU.close();
                    }
                    if(excelJTableExport != null)
                    {
                        excelJTableExport.close();
                    }
                } catch (IOException ex) {
                   ex.printStackTrace(); 
                }
            }
                    
               
                
            }

    }//GEN-LAST:event_btExportExcelActionPerformed

    private void btPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDFActionPerformed
           
     try 
     {
         tbNV.print(JTable.PrintMode.FIT_WIDTH);
     }catch (java.awt.print.PrinterException e){
         e.printStackTrace();
     }
        
    }//GEN-LAST:event_btPDFActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
         try {
             search();
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Không thể tìm kiếm");
         }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btALLActionPerformed
        tbNV.setModel(model);
    }//GEN-LAST:event_btALLActionPerformed

    private void btTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemNCActionPerformed
         try {
             TimKiemNC();
         } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Không thể tìm kiếm");
         }
    }//GEN-LAST:event_btTimKiemNCActionPerformed

    private void txIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIDKeyPressed
        if(evt.getKeyCode() == 10)
        {
            txHo.requestFocus();
        }
    }//GEN-LAST:event_txIDKeyPressed

    private void txHoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txHoKeyPressed
        if(evt.getKeyCode() == 10)
        {
            txTen.requestFocus();
        }
    }//GEN-LAST:event_txHoKeyPressed

    private void txTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTenKeyPressed
         if(evt.getKeyCode() == 10)
        {
            txDT.requestFocus();
        }
    }//GEN-LAST:event_txTenKeyPressed

    private void txDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDTKeyPressed
         if(evt.getKeyCode() == 10)
        {
            txEmail.requestFocus();
        }
    }//GEN-LAST:event_txDTKeyPressed

    private void txEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEmailKeyPressed
        if(evt.getKeyCode() == 10)
        {
            txLuong.requestFocus();
        }
    }//GEN-LAST:event_txEmailKeyPressed

    private void txLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txLuongKeyPressed
         if(evt.getKeyCode() == 10)
        {
            txChucVu.requestFocus();
        }
    }//GEN-LAST:event_txLuongKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btALL;
    private java.awt.Button btExportExcel;
    private java.awt.Button btImportExcel;
    private java.awt.Button btInit;
    private java.awt.Button btPDF;
    private java.awt.Button btSua;
    private java.awt.Button btThem;
    private java.awt.Button btTimKiem;
    private java.awt.Button btTimKiemNC;
    private java.awt.Button btXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JComboBox<String> cbTimKiemNC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDT;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbKQ;
    private javax.swing.JLabel lbKetQua;
    private javax.swing.JLabel lbLuong;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbTen;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable tbNV;
    private javax.swing.JTextField txBegin;
    private javax.swing.JTextField txChucVu;
    private javax.swing.JTextField txDT;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEnd;
    private javax.swing.JTextField txHo;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txLuong;
    private com.toedter.calendar.JDateChooser txNgaySinh;
    private javax.swing.JTextField txTen;
    private javax.swing.JTextField txTimKiem;
    // End of variables declaration//GEN-END:variables
}
