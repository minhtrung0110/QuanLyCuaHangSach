/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TheLoaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class TheLoaiDAO {
    MyConnectUnit connect  =new MyConnectUnit("localhost","root","","bookstore");
    public TheLoaiDAO() {
    }
     public ArrayList<TheLoaiDTO> loadDatabase() throws Exception
    {
        ArrayList<TheLoaiDTO> dssach = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("sach");
            while(rs.next())
            {
                TheLoaiDTO tl = new  TheLoaiDTO(rs.getString("MaTL"),rs.getString("TenTL"));     
                dssach.add(tl);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database TheLoai");
        }

        return dssach;
    }
     public void addNXB(TheLoaiDTO tl) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaTL",tl.getMaTL());
        Insertvalues.put("TenTL",tl.getTenTL());
         try {
             connect.Insert("theloai", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them NXB vao database !!!");
        }
    }
      public void updateTheLoai(TheLoaiDTO tl) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
         Updatevalues.put("MaTL",tl.getMaTL());
         Updatevalues.put("TenTL",tl.getTenTL());
      
         try {
           connect.Update("theloai", Updatevalues," MaTL ='"+tl.getMaTL()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat TheLoai vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("theloai","MaTL ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
