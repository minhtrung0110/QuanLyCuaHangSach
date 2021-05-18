package DAO;

import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDonDAO {
   private MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
   public ChiTietHoaDonDAO(){
   }
   public ArrayList<ChiTietHoaDonDTO> List(){
       ArrayList<ChiTietHoaDonDTO> CTHD=new ArrayList<>();
       try{
           String sql="SELECT * FROM chitiethoadon";
           ResultSet rs=MySQL.excuteQuery(sql);
           while(rs.next()){
               String MaHD=rs.getString("MaHD");
               String MaSach=rs.getString("MaSach");
               String TenSach=rs.getString("TenSach");
               int SoLuong=Integer.parseInt(rs.getString("SoLuong"));
               float DonGia=Float.parseFloat(rs.getString("DonGia"));
               float GiamGia=Float.parseFloat(rs.getString("GiamGia"));
               float ThanhTien=Float.parseFloat(rs.getString("ThanhTien"));
               ChiTietHoaDonDTO ct=new ChiTietHoaDonDTO(MaHD,MaSach,TenSach,SoLuong,DonGia,GiamGia,ThanhTien);
               CTHD.add(ct);
           }
           rs.close();
           MySQL.Close();
       }catch(Exception e){
         System.out.print("ChiTietHoaDonDAO khong tai duoc.");  
       }
      
       return CTHD;
   }
   public void Them(ChiTietHoaDonDTO ct){
       MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
       String sql="INSERT INTO chitiethoadon VALUES ('"
               + ct.getMaHD()+"','"
               + ct.getMaSach()+"','"
               + ct.getTenSach()+"','"
               + ct.getSoLuong()+"','"
               + ct.getDonGia()+"','"
               + ct.getGiamGia()+"','"
               + ct.getThanhTien()+"')";
       try {
           MySQL.excuteUpdate(sql);
       } catch (Exception ex) {
           System.out.print("CTHDDAO khong them duoc.");
       }
       System.out.println(sql);
       
   }
   public void deletebyMaSach(String idSach)
    {
        try {
            String query="DELETE FROM chitietphieunhap WHERE  MaSach ='"+idSach+"'";
                    MySQL.excuteUpdate(query); 
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
   public void Sua(ChiTietHoaDonDTO ct){
       try{
       MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
       String sql="UPDATE chitiethoadon SET ";
       sql+="MaHD='"+ct.getMaHD()+"',";
       sql+="MaSach='"+ct.getMaSach()+"',";
       sql+="TenSach='"+ct.getTenSach()+"',";
       sql+="SoLuong='"+ct.getSoLuong()+"',";
       sql+="DonGia='"+ct.getDonGia()+"',";
       sql+="GiamGia='"+ct.getGiamGia()+"',";
       sql+="ThanhTien='"+ct.getThanhTien()+"'";
       sql+=" WHERE MaHD='"+ct.getMaHD()+"' AND MaSach='"+ct.getMaSach()+"'";
       System.out.println(sql);
       MySQL.excuteUpdate(sql);
       MySQL.Close();
       }catch(Exception ex){
           System.out.println("Không update được cthd.");
       }
   }
   public void Xoa(String MaHD){
       MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
       String sql="DELETE FROM chitiethoadon WHERE MaHD='"+MaHD+"'";
       try {
           MySQL.excuteUpdate(sql);
       } catch (Exception ex) {
          System.out.print("Chi tiet HD khong xoa duoc.");
       }
       System.out.println(sql);
   }
    public void XoaMS(String MaSach,String MaHD){
       MySQLConnect MySQL=new MySQLConnect("localhost","root","","bookstore");
       String sql="DELETE FROM chitiethoadon WHERE MaSach='"+MaSach+"' AND MaHD='"+MaHD+"'";
       try {
           MySQL.excuteUpdate(sql);
       } catch (Exception ex) {
          System.out.print("Chi tiet HD khong xoa duoc.");
       }
       System.out.println(sql);
   }
}
