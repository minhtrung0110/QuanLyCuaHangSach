
package DAO;
import DTO.NCCDTO;
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

public class NCCDAO {
   MyConnectUnit connect ;

    public NCCDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<NCCDTO> loadDatabase() throws Exception
    {
        ArrayList<NCCDTO> dsncc = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("nhacungcap");
            while(rs.next())
            {
                NCCDTO ncc = new  NCCDTO(rs.getString("MaNCC"),
                        rs.getString("TenNCC"),rs.getString("DiaChi"));       
                dsncc.add(ncc);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database NCC");
        }

        return dsncc;
    }
     public void addNCC(NCCDTO ncc) throws Exception
    {
        HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();        
        Insertvalues.put("MaNCC",ncc.getMaNCC());
        Insertvalues.put("TenNCC", ncc.getTenNCC());
        Insertvalues.put("DiaChi", ncc.getDiaChi());
         try {
             connect.Insert("nhacungcap", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them NCC vao database !!!");
        }
    }
      public void updateNCC(NCCDTO ncc) throws Exception
    {
        HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
        Updatevalues.put("MaNCC",ncc.getMaNCC());
        Updatevalues.put("TenNCC", ncc.getTenNCC());
        Updatevalues.put("DiaChi", ncc.getDiaChi());
         try {
           connect.Update("nhacungcap", Updatevalues," MaNCC ='"+ncc.getMaNCC()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat NCC vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("nhacungcap","MaNCC ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
