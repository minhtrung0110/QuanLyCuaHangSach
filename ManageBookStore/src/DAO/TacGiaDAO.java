/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class TacGiaDAO {
    MyConnectUnit connect  =new MyConnectUnit("localhost","root","","bookstore");

    public TacGiaDAO() {
    }
     public ArrayList<TacGiaDTO> loadDatabase() throws Exception
    {
        ArrayList<TacGiaDTO> dssach = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("sach");
            while(rs.next())
            {
                TacGiaDTO nxb = new  TacGiaDTO(rs.getString("MaTG"),rs.getString("TenTG"),rs.getString("DiaChi"),rs.getString("SDT"));     
                dssach.add(nxb);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database TacGia");
        }

        return dssach;
    }
     public void addTacGia(TacGiaDTO nxb) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaTG",nxb.getMaTG());
        Insertvalues.put("TenTG",nxb.getTenTG());
        Insertvalues.put("DiaChi",nxb.getDiaChi());
        Insertvalues.put("SDT",nxb.getSDT());
        
         try {
             connect.Insert("tacgia", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them TacGia vao database !!!");
        }
    }
      public void updateTacGia(TacGiaDTO nxb) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
         Updatevalues.put("MaTG",nxb.getMaTG());
         Updatevalues.put("TenTG",nxb.getTenTG());
         Updatevalues.put("DiaChi",nxb.getDiaChi());
         Updatevalues.put("SDT",nxb.getSDT());
         try {
           connect.Update("tacgia", Updatevalues," MaTG ='"+nxb.getMaTG()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat TacGia vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("tacgia","MaTG ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
