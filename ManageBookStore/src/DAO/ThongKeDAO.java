

package DAO;

import DTO.ThongKeDTO;
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
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThongKeDAO {
   MyConnectUnit connect ;

    public ThongKeDAO() throws IOException {
        connect  =new MyConnectUnit();
       
    }
    public long  TongTienPhieuNhap(){
        //SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap 
        long Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("phieunhap", "SUM(TongTien) AS TongTienPhieuNhap");
          while(rs.next()){
          Sum=rs.getLong("TongTienPhieuNhap");}
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập");
        }
        return Sum;
    }
    public  HashMap<String,Object>  TongTienPhieuNhapTheoMaNhanVien(String idNV){
        //SELECT MANCC , SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap GROUP BY MaNCC
        HashMap<String,Object> values =new  HashMap<String,Object>();
        try {
          ResultSet rs = connect.SelectCustom("phieunhap", "MANV ,SUM(TongTien) AS TongTienPhieuNhap","MANV= '"+idNV+"'");
         while(rs.next())
            {
               values.put(rs.getString("MANV"),rs.getFloat("TongTienPhieuNhap"));
            }
            rs.close();
            connect.Close();

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập Theo Ma Nhân Viên");
        }
        return values;
    }
    public HashMap<String,Object>  TongTienPhieuNhapTheoMaNCC(){
          //SELECT MANCC , SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap GROUP BY MaNCC
        HashMap<String,Object> values =new  HashMap<String,Object>();
        try {
          ResultSet rs = connect.SelectCustomGroupByOderby("phieunhap", " MANCC , SUM(TongTien) AS TongTienPhieuNhap ", " MaNCC","TongTienPhieuNhap DESC");
         while(rs.next())
            {
               values.put(rs.getString("MANCC"),rs.getFloat("TongTienPhieuNhap"));
            }
            rs.close();
            connect.Close();

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập Theo Mã NCC");
        }
        return values;
    }
    public float  TongTienPhieuNhapTheoNgayNhap(String ngaymin,String ngaymax){
        //SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap WHERE NgayNhap BETWEEN '2020-12-20' AND '2021-05-02'
        float Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("phieunhap", "SUM(TongTien) AS TongTienPhieuNhap"," NgayNhap BETWEEN '"+ngaymin+"' AND '"+ngaymax+"'");
         while(rs.next()){
          Sum=rs.getFloat("TongTienPhieuNhap");}
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập Theo Ngày Nhập ");
        }
        return Sum;
    }
     public ArrayList<ThongKeDTO> xuatThongKePNNCCtheoQuy(String year) throws Exception{
        ArrayList<ThongKeDTO> dsThongKe = new ArrayList();
        ResultSet rs = connect.SelectCustom(" phieunhap, chitietphieunhap ","MaNCC, sum( if(Quarter(phieunhap.NgayNhap) = 1, chitietphieunhap.ThanhTien, 0)) as QUY1, sum( if(Quarter(phieunhap.NgayNhap) = 2, chitietphieunhap.ThanhTien, 0)) as QUY2, sum( if(Quarter(phieunhap.NgayNhap) = 3, chitietphieunhap.ThanhTien, 0)) as QUY3, sum( if(Quarter(phieunhap.NgayNhap) = 4, chitietphieunhap.ThanhTien, 0)) as QUY4"
                ,"  phieunhap.MaPN= chitietphieunhap.MaPN and year(NgayNhap)="+ year, "  MaNCC");
        
        while(rs.next()){
            ThongKeDTO thongke = new ThongKeDTO();
            thongke.setMa(rs.getString(1));
            thongke.setQuy1(Double.parseDouble(rs.getString(2)));
            thongke.setQuy2(Double.parseDouble(rs.getString(3)));
            thongke.setQuy3(Double.parseDouble(rs.getString(4)));
            thongke.setQuy4(Double.parseDouble(rs.getString(5)));
            
            dsThongKe.add(thongke);
        }
        System.out.println("DAO.ThongKeSPDAO.xuatThongKePNNCCtheoQuy");
        return dsThongKe;
    }
    /*Hóa Đơn*/
     public long  TongTienHoaDon(){
        //SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap 
        long Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("hoadon", "SUM(TongTien) AS TongTienHoaDon");
          while(rs.next()){
          Sum=rs.getLong("TongTienHoaDon");}
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Hóa Đơn");
        }
        return Sum;
    }
     public float  TongTienHoaDonTheoNgayNhap(String ngaymin,String ngaymax){
        //SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap WHERE NgayNhap BETWEEN '2020-12-20' AND '2021-05-02'
        float Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("hoadon", "SUM(TongTien) AS TongTienHoaDon"," NgayLapHD BETWEEN '"+ngaymin+"' AND '"+ngaymax+"'");
         while(rs.next()){
          Sum=rs.getFloat("TongTienHoaDon");}
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Hóa Đơn Theo Ngày Nhập ");
        }
        return Sum;
    }
     public HashMap<String,Object>  TongTienHoaDonTheoKH(){
          //SELECT MANCC , SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap GROUP BY MaNCC
        HashMap<String,Object> values =new  HashMap<String,Object>();
        try {
          ResultSet rs = connect.SelectCustomGroupByOderby("hoadon", " MaKH , SUM(TongTien) AS TongTienHoaDon ", " MaKH","TongTienHoaDon DESC");
         while(rs.next())
            {
               values.put(rs.getString("MaKH"),rs.getFloat("TongTienHoaDon"));
            }
            rs.close();
            connect.Close();

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Hóa Đơn Theo Mã Khách Hàng");
        }
        return values;
    }
     public ArrayList<ThongKeDTO> xuatThongKeHDSPtheoQuy(String year) throws Exception{
        ArrayList<ThongKeDTO> dsThongKe = new ArrayList();
        ResultSet rs = connect.SelectCustom(" hoadon, chitiethoadon ",""
                + "MaSach, sum( if(Quarter(hoadon.NgayLapHD) = 1, chitiethoadon.ThanhTien, 0)) as QUY1, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 2, chitiethoadon.ThanhTien, 0)) as QUY2, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 3, chitiethoadon.ThanhTien, 0)) as QUY3, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 4, chitiethoadon.ThanhTien, 0)) as QUY4"
                ," hoadon.MaHD = chitiethoadon.MaHD and year(NgayLapHD) = " + year, "  MaSach");
        
        while(rs.next()){
            ThongKeDTO thongke = new ThongKeDTO();
            thongke.setMa(rs.getString(1));
            thongke.setQuy1(Double.parseDouble(rs.getString(2)));
            thongke.setQuy2(Double.parseDouble(rs.getString(3)));
            thongke.setQuy3(Double.parseDouble(rs.getString(4)));
            thongke.setQuy4(Double.parseDouble(rs.getString(5)));
            
            dsThongKe.add(thongke);
        }
        System.out.println("DAO.ThongKeSPDAO.xuatThongKeHDSPtheoQuy()");
        return dsThongKe;
    }
    public ArrayList<ThongKeDTO> xuatThongKeHDNVtheoQuy(String year) throws Exception{
        ArrayList<ThongKeDTO> dsThongKe = new ArrayList();
        ResultSet rs = connect.SelectCustom(" hoadon, chitiethoadon ",""
                + "MaNV, sum( if(Quarter(hoadon.NgayLapHD) = 1, chitiethoadon.ThanhTien, 0)) as QUY1, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 2, chitiethoadon.ThanhTien, 0)) as QUY2, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 3, chitiethoadon.ThanhTien, 0)) as QUY3, "
                + "sum( if(Quarter(hoadon.NgayLapHD) = 4, chitiethoadon.ThanhTien, 0)) as QUY4"
                ," hoadon.MaHD = chitiethoadon.MaHD and year(NgayLapHD) = " + year, "  MaNV");
        
        while(rs.next()){
            ThongKeDTO thongke = new ThongKeDTO();
            thongke.setMa(rs.getString(1));
            thongke.setQuy1(Double.parseDouble(rs.getString(2)));
            thongke.setQuy2(Double.parseDouble(rs.getString(3)));
            thongke.setQuy3(Double.parseDouble(rs.getString(4)));
            thongke.setQuy4(Double.parseDouble(rs.getString(5)));
            
            dsThongKe.add(thongke);
        }
        System.out.println("DAO.ThongKeSPDAO.xuatThongKeHDNVtheoQuy()");
        return dsThongKe;
    }
    
    public float  ABC(String daymin,String daymax) throws Exception{
        float sum=0;
        ResultSet rs=connect.SelectCustom("hoadon"," SUM(TongTien) AS TongTienHoaDon ",
                "NgayLapHD BETWEEN '" +daymin +"' AND '"+daymax+"'");
        try {
            while(rs.next()){
                sum=rs.getFloat("TongTienHoaDon");
            }
            rs.close();
            connect.Close();
        } catch (Exception e) {
            System.out.println("Không thể thống kê hóa đơn theo thoi gian");
        }
        return sum;
    }
}


/*PhieuNhap*/
//SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap 
//SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap WHERE MaNV='K02'
//SELECT MANCC , SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap GROUP BY MaNCC
//SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap WHERE NgayNhap BETWEEN '2020-12-20' AND '2021-05-02'
//SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap WHERE MaNV='K02' AND NgayNhap BETWEEN '2020-12-20' AND '2021-05-02'
//SELECT MaPN,MANV,MANCC,SUM(TongTien) AS TongTienPhieuNhap ,QUARTER(NgayNhap) AS QUY   FROM `phieunhap` GROUP BY QUY 
 
/*Hóa Đơn*/
//SELECT  SUM(ThanhTien) AS Tong_Tien_Hoa_Don FROM hoadon 
//SELECT  SUM(ThanhTien) AS Tong_Tien_Hoa_Don FROM hoadon WHERE MaKH='K02'
//SELECT  SUM(ThanhTien) AS Tong_Tien_Hoa_Don FROM hoadon WHERE NgayLapHD BETWEEN '2020-12-20' AND '2021-05-02'
//SELECT  SUM(ThanhTien) AS Tong_Tien_Hoa_Don FROM hoadon WHERE MaKH='K02' AND NgayLapHD BETWEEN '2020-12-20' AND '2021-05-02'
//SELECT MaHD,MaKH,SUM(ThanhTien) AS TongThanhTien,QUARTER(NgayLapHD) AS QUY   FROM `hoadon` GROUP BY QUY 
// Tổng tiền hóa dơn các khách hàng theo các quý