/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TacGiaDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class TacGiaDAO {
    MyConnectUnit connect;

    public TacGiaDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<TacGiaDTO> loadDatabase() throws Exception
    {
        ArrayList<TacGiaDTO> dstacgia = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("tacgia");
            while(rs.next())
            {
                TacGiaDTO tg = new  TacGiaDTO(rs.getString("MaTG"),rs.getString("TenTG"),rs.getString("DiaChi"),rs.getString("SDT"));     
                dstacgia.add(tg);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database TacGia");
        }

        return dstacgia;
    }
     public void addTacGia(TacGiaDTO tg) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaTG",tg.getMaTG());
        Insertvalues.put("TenTG",tg.getTenTG());
        Insertvalues.put("DiaChi",tg.getDiaChi());
        Insertvalues.put("SDT",tg.getSDT());
        
         try {
             connect.Insert("tacgia", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them TacGia vao database !!!");
        }
    }
      public void updateTacGia(TacGiaDTO tg) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
         Updatevalues.put("MaTG",tg.getMaTG());
         Updatevalues.put("TenTG",tg.getTenTG());
         Updatevalues.put("DiaChi",tg.getDiaChi());
         Updatevalues.put("SDT",tg.getSDT());
         try {
           connect.Update("tacgia", Updatevalues," MaTG ='"+tg.getMaTG()+"'");
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
