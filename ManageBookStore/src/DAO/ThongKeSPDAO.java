/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKeSPDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tungk
 */
public class ThongKeSPDAO {
    TungSqlConnect conn = new TungSqlConnect("localhost", "root", "", "bookstore");
    String year;
    public ThongKeSPDAO(String year){
        this.year = year;
    }
    
    public ArrayList<ThongKeSPDTO> xuatThongKe() throws Exception{
        ArrayList<ThongKeSPDTO> dsThongKe = new ArrayList();
        String sql = "select MaSach, sum( if(Quarter(hoadon.NgayLapHD) = 1, chitiethoadon.ThanhTien, 0)) as QUY1, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 2, chitiethoadon.ThanhTien, 0)) as QUY2, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 3, chitiethoadon.ThanhTien, 0)) as QUY3, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 4, chitiethoadon.ThanhTien, 0)) as QUY4\n"
                + "from hoadon, chitiethoadon where hoadon.MaHD = chitiethoadon.MaHD and year(NgayLapHD) = " + year 
                +"\ngroup by MaSach" ;
        System.out.println(sql);
        ResultSet rs = conn.executeQuery(sql);
        
        while(rs.next()){
            ThongKeSPDTO thongke = new ThongKeSPDTO();
            thongke.setMaSach(rs.getString(1));
            thongke.setQuy1(Double.parseDouble(rs.getString(2)));
            thongke.setQuy2(Double.parseDouble(rs.getString(3)));
            thongke.setQuy3(Double.parseDouble(rs.getString(4)));
            thongke.setQuy4(Double.parseDouble(rs.getString(5)));
            
            dsThongKe.add(thongke);
        }
        System.out.println("DAO.ThongKeSPDAO.xuatThongKe()");
        return dsThongKe;
    }
}
