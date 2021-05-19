/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.swing.JOptionPane;
import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tungk
 */
public class KhachHangDAO {
    MySQLConnect conn = new MySQLConnect("localhost", "root", "", "bookstore");
    MyConnectUnit connect;
    public KhachHangDAO(){
        try{
            //conn.testDriver();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database");
        }
    }
    
    public ArrayList docDSKH(){
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        try {
            String query = "select * from khachhang";
            ResultSet rs = conn.excuteQuery(query);
            
            while(rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                int i = 1;
                kh.setId(rs.getString(i++));
                kh.setHo(rs.getString(i++));
                kh.setTen(rs.getString(i++));
                kh.setSdt(rs.getString(i++));
                kh.setEmail(rs.getString(i++));
                kh.setPhai(rs.getBoolean(i++));
                kh.setTct(rs.getInt(i++));
                kh.setNgaySinh(rs.getString(i++));
                dskh.add(kh);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ database");
        }
        
        return dskh;
    }
    
    public void them(KhachHangDTO kh){
        String query = String.format("insert into khachhang values('%s', '%s', '%s', '%s', '%s', %b, %d, '%s')", 
                kh.getId(), kh.getHo(), kh.getTen(), kh.getSdt(), kh.getEmail(), kh.isPhai(), kh.getTct(), kh.getNgaySinh());
        try{
            conn.excuteUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu");
        }
    }
    
    public void xoa(KhachHangDTO kh){
        String query = String.format("delete from khachhang where MaKH = '%s'", kh.getId());
        
        try {
            conn.excuteUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa dữ liệu");
        }
    }
    
    public void sua(KhachHangDTO kh){
        String query = String.format("update khachhang set Ho='%s', Ten='%s', SDT='%s', Email='%s', Phai=%b, TCT=%d where MaKH = '%s'", 
                kh.getHo(), kh.getTen(), kh.getSdt(), kh.getEmail(), kh.isPhai(), kh.getTct(), kh.getId());
        try{
            conn.excuteUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể sửa dữ liệu");
        }
    }
    
}
