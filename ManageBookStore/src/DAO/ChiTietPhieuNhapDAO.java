/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
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


/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapDAO {

   MyConnectUnit connect ;

    public ChiTietPhieuNhapDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<ChiTietPhieuNhapDTO> loadDatabase() throws Exception
    {
        ArrayList<ChiTietPhieuNhapDTO> dspn = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("chitietphieunhap");
            while(rs.next())
            {
                ChiTietPhieuNhapDTO pn = new  ChiTietPhieuNhapDTO(rs.getString("MaCTPN"),rs.getString("MaPN"),
                        rs.getString("MaSach"),rs.getInt("DonGia")
                        ,rs.getInt("SoLuong"),rs.getFloat("ThanhTien"));       
                dspn.add(pn);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database ChiTietPhieuNhap");
        }

        return dspn;
    }
     public ArrayList<ChiTietPhieuNhapDTO> loadDatabasewithCondition(String condition) throws Exception
    {
        ArrayList<ChiTietPhieuNhapDTO> dspn = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("chitietphieunhap", condition);
            while(rs.next())
            {
                ChiTietPhieuNhapDTO pn = new  ChiTietPhieuNhapDTO(rs.getString("MaCTPN"),rs.getString("MaPN"),
                        rs.getString("MaSach"),rs.getInt("DonGia")
                        ,rs.getInt("SoLuong"),rs.getFloat("ThanhTien"));       
                dspn.add(pn);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database ChiTietPhieuNhap");
        }

        return dspn;
    }
     public void addChiTietPhieuNhap(ChiTietPhieuNhapDTO pn) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
        Insertvalues.put("MaCTPN",pn.getID());
        Insertvalues.put("MaPN",pn.getMaPN());
        Insertvalues.put("MaSach", pn.getMaSach());
        Insertvalues.put("DonGia", pn.getDonGia());
        Insertvalues.put("SoLuong", pn.getSoLuong());
        Insertvalues.put("ThanhTien", pn.getThanhTien());       
         try {
             connect.Insert("chitietphieunhap", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them ChiTietPhieuNhap vao database !!!");
        }
    }
      public void updateChiTietPhieuNhap(ChiTietPhieuNhapDTO pn) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
        Updatevalues.put("MaCTPN",pn.getID());
        Updatevalues.put("MaPN",pn.getMaPN());
        Updatevalues.put("MaSach", pn.getMaSach());
        Updatevalues.put("DonGia", pn.getDonGia());
        Updatevalues.put("SoLuong", pn.getSoLuong());
        Updatevalues.put("ThanhTien", pn.getThanhTien());
         try {
           connect.Update("chitietphieunhap", Updatevalues," MaCTPN='"+pn.getID()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat ChiTietPhieuNhap vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("chitietphieunhap","MaCTPN ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
    public void deletebyMaSach(String idSach)
    {
        try {
                    this.connect.Delete("chitietphieunhap","MaSach ='"+idSach+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
    public void deletebyMaPN(String idPN)
    {
        try {
                    this.connect.Delete("chitietphieunhap","MaPN ='"+idPN+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}


