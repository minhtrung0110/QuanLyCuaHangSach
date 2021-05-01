/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChuongTrinhGiamGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class ChuongTrinhGiamGiaDAO {
    TungSqlConnect conn = new TungSqlConnect("localhost", "root", "", "bookstore");
    
    public ChuongTrinhGiamGiaDAO(){
        try{
            conn.testDriver();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database");
        }
    }
    
    public ArrayList<ChuongTrinhGiamGiaDTO> docDSCT(){
        ArrayList<ChuongTrinhGiamGiaDTO> dsCT = new ArrayList<>();
        try{
            String sql = "select * from chuongtrinhgiamgia";
            ResultSet rs = conn.executeQuery(sql);
            while(rs.next()){
                ChuongTrinhGiamGiaDTO cTrinh = new ChuongTrinhGiamGiaDTO(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5));
                dsCT.add(cTrinh);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ database");
        }
        return dsCT;
    }
    
    public void them(ChuongTrinhGiamGiaDTO cTrinh){
        String sql = String.format("insert into chuongtrinhgiamgia values('%s', '%s', '%s', '%s', '%s')",
                cTrinh.getId(), cTrinh.getTenChuongTrinh(), cTrinh.getLoai(), cTrinh.sqlNgayBD(), cTrinh.sqlNgayKT());
        try{
            conn.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("DAO.ChuongTrinhGiamGiaDAO.them()");
        }
    }
    
    public void sua(ChuongTrinhGiamGiaDTO cTrinh){
        String sql = String.format("update chuongtrinhgiamgia set TenChuongTrinh = '%s', LoaiChuongTrinh = '%s', NgayBD = '%s', NgayKT = '%s' where MaGG = '%s'",
                cTrinh.getTenChuongTrinh(), cTrinh.getLoai(), cTrinh.sqlNgayBD(), cTrinh.sqlNgayKT(), cTrinh.getId());
        try{
            conn.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("DAO.ChuongTrinhGiamGiaDAO.them()");
        }
    }
    
    public void xoa(ChuongTrinhGiamGiaDTO cTrinh){
        String query1 = String.format("delete from chuongtrinhgiamgia where MaGG = '%s'", cTrinh.getId());
        String query2 = String.format("delete from chitietchuongtrinhgiamgia where MaGG = '%s'", cTrinh.getId());
        try {
            conn.executeUpdate(query1);
            conn.executeUpdate(query2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa dữ liệu");
        }
    }
}
