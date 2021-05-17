package DAO;

import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO {
       private MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
       public HoaDonDAO(){}
       public ArrayList<HoaDonDTO> List(){
           ArrayList<HoaDonDTO> DSHoaDon=new ArrayList<>();
               try {
                   String sql="select * from hoadon";
                   ResultSet rs=MySQL.excuteQuery(sql);
                   while(rs.next()){
                       String MaHD=rs.getString("MaHD");
                       String MaKH=rs.getString("MaKH");
                       String MaNV=rs.getString("MaNV");
                       String MaGG=rs.getString("MaGG");
                       String NgayLap=rs.getDate("NgayLapHD").toString();
                       float TongTien=Float.parseFloat(rs.getString("TongTien"));
                       float GiamGia=Float.parseFloat(rs.getString("GiamGia"));
                       float ThanhTien=Float.parseFloat(rs.getString("ThanhTien"));
                       HoaDonDTO hd=new HoaDonDTO(MaHD,MaKH,MaNV,MaGG,NgayLap,TongTien,GiamGia,ThanhTien);
                       DSHoaDon.add(hd);
                   }
                   rs.close();
                   MySQL.Close();
               } catch (Exception ex) {
                   System.out.print("HoaDonDAO khong tai duoc");
               }
               
           return DSHoaDon;
       }
       public void Sua(HoaDonDTO hd){
           
           try {
           MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
           String MaGG=hd.getMaGG().equals("")?null:"'"+hd.getMaGG()+"'";
           String sql="UPDATE hoadon SET ";
           sql+="MaHD='"+hd.getMaHD()+"',";
           sql+="MaKH='"+hd.getMaKH()+"',";
           sql+="MaNV='"+hd.getMaNV()+"',";
           sql+="MaGG="+MaGG+",";
           sql+="NgayLapHD='"+hd.getNgayLap().toString()+"',";
           sql+="TongTien='"+hd.getTongTien()+"',";
           sql+="GiamGia='"+hd.getGiamGia()+"',";
           sql+="ThanhTien='"+hd.getThanhTien()+"' ";
           sql+="WHERE MaHD='"+hd.getMaHD()+"'";
           System.out.println(sql);
               MySQL.excuteUpdate(sql);
               MySQL.Close();
           } catch (Exception ex) {
               System.out.print("HDDAO sua that bai");
           }
       }
       public void Xoa(String MaHD){
           MySQLConnect Mysql=new MySQLConnect("localhost","root","","bookstore");
           String sql="DELETE FROM hoadon WHERE MaHD='"+MaHD+"'";
           try {
               Mysql.excuteUpdate(sql);
               Mysql.Close();
           } catch (Exception ex) {
               System.out.print("HoaDonDAO xoa khong duoc.");
           }
           System.out.println(sql);   
       }
       public void Them(HoaDonDTO hd){
           MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
           String MaGG=hd.getMaGG().equals("")?null:"'"+hd.getMaGG()+"'";
           String sql="INSERT INTO hoadon VALUES (";
           sql+="'"+hd.getMaHD()+"',";
           sql+="'"+hd.getMaKH()+"',";
           sql+="'"+hd.getMaNV()+"',";
           sql+=""+MaGG+",";
           sql+="'"+hd.getNgayLap().toString()+"',";
           sql+="'"+hd.getTongTien()+"',";
           sql+="'"+hd.getGiamGia()+"',";
           sql+="'"+hd.getThanhTien()+"')";
           System.out.println(sql);
           try {
               MySQL.excuteUpdate(sql);
           } catch (Exception ex) {
               System.out.print("HDDAO khong them duoc.");
           }
           
       }
     public static void main(String []args){
           MySQLConnect c=new MySQLConnect("localhost","root","","bookstore");
           String sql="UPDATE hoadon SET MaHD='HD03',MaKH='a11',MaNV='A01',MaGG='GG01',NgayLapHD='2020-04-04',TongTien='12',GiamGia='11',ThanhTien='1' WHERE MaHD='HD03'";
           try {
               c.excuteUpdate(sql);
           } catch (Exception ex) {
               System.out.print("abc");
           }
   }
}
