
package DAO;
import DTO.SachDTO;
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
import java.sql.*;
import java.util.HashMap;

public class SachDAO {
   MyConnectUnit connect ;

    public SachDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<SachDTO> loadDatabase() throws Exception
    {
        ArrayList<SachDTO> dssach = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("sach");
            while(rs.next())
            {
                SachDTO sach = new  SachDTO(rs.getString("MaSach"),
                        rs.getString("MaNXB"),rs.getString("MaTG"),
                        rs.getString("MaTL"),rs.getString("TenSach"),rs.getInt("NamXuatBan"),
                        rs.getInt("SoLuong"),rs.getFloat("DonGia"),rs.getString("imgName"));       
                dssach.add(sach);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Sach");
        }

        return dssach;
    }
     public void addSach(SachDTO sach) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaSach",sach.getMaSach());
        Insertvalues.put("MaNXB", sach.getMaNXB());
        Insertvalues.put("MaTG", sach.getMaTG());
        Insertvalues.put("MaTL", sach.getMaTL());
        Insertvalues.put("TenSach", sach.getTenSach());
        Insertvalues.put("NamXuatBan", sach.getNamXuatBan());
        Insertvalues.put("SoLuong", sach.getSoluong());
        Insertvalues.put("DonGia", sach.getDongia());
        Insertvalues.put("imgName", sach.getImgName());
        
         try {
             connect.Insert("sach", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them Sach vao database !!!");
        }
    }
      public void updateSach(SachDTO sach) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
        Updatevalues.put("MaSach",sach.getMaSach());
        Updatevalues.put("MaNXB", sach.getMaNXB());
        Updatevalues.put("MaTG", sach.getMaTG());
        Updatevalues.put("MaTL", sach.getMaTL());
        Updatevalues.put("TenSach", sach.getTenSach());
        Updatevalues.put("NamXuatBan", sach.getNamXuatBan());
        Updatevalues.put("SoLuong", sach.getSoluong());
        Updatevalues.put("DonGia", sach.getDongia());
        Updatevalues.put("imgName", sach.getImgName());
         try {
           connect.Update("sach", Updatevalues," MaSach ='"+sach.getMaSach()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat Sach vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("sach","MaSach ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
