
package DAO;

import DTO.PhieuNhapDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class PhieuNhapDAO {
  
                Calendar date = Calendar.getInstance();


   MyConnectUnit connect ;

    public PhieuNhapDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
    public PhieuNhapDTO getPhieuNhap(String MaPN) throws IOException, Exception{
         ResultSet rs=connect.Select("phieunhap","MaPN = "+"'"+MaPN+"'");
         PhieuNhapDTO pn =new PhieuNhapDTO();
         pn.setMaPN(rs.getString("MaPN"));
         pn.setMaNV(rs.getString("MaNV"));              
         pn.setMaNV(rs.getString("MaNCC"));
         pn.setTrangThai(rs.getInt("TrangThai"));               
         pn.setTongTien(rs.getLong("TongTien"));                      
         pn.setNgayNhap(rs.getString("NgayNhap"));   
         return pn;        
    } 
     public ArrayList<PhieuNhapDTO> loadDatabase() throws Exception
    {
        ArrayList<PhieuNhapDTO> dsd = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("phieunhap");
            while(rs.next())
            {
                PhieuNhapDTO d = new  PhieuNhapDTO(rs.getString("MaPN"),
                        rs.getString("MaNV"),rs.getString("MaNCC"),
                        rs.getInt("TrangThai"),rs.getLong("TongTien"),rs.getString("NgayNhap") );       
                dsd.add(d);
            }
            
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database PhieuNhap");
        }

        return dsd;
    }
     public void addPhieuNhap(PhieuNhapDTO d) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaPN",d.getMaPN());
        Insertvalues.put("MaNV", d.getMaNV());
        Insertvalues.put("MaNCC", d.getMaNCC());
        Insertvalues.put("TrangThai", d.isTrangThai());
        Insertvalues.put("TongTien", d.getTongTien());
        Insertvalues.put("NgayNhap", d.getNgayNhap());
        
         try {
             connect.Insert("phieunhap", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them PhieuNhap vao database !!!");
        }
    }
      public void updatePhieuNhap(PhieuNhapDTO d) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
        Updatevalues.put("MaPN",d.getMaPN());
        Updatevalues.put("MaNV", d.getMaNV());
        Updatevalues.put("MaNCC", d.getMaNCC());
        Updatevalues.put("TrangThai", d.isTrangThai());
        Updatevalues.put("TongTien", d.getTongTien());
        Updatevalues.put("NgayNhap", d.getNgayNhap());

         try {
           connect.Update("phieunhap", Updatevalues," MaPN='"+d.getMaPN()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat PhieuNhap vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("phieunhap","MaPN ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
   
}

