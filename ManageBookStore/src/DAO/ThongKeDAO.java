

package DAO;

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
    public float  TongTienPhieuNhap(){
        //SELECT  SUM(TongTien) AS TongTienPhieuNhap FROM phieunhap 
        float Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("phieunhap", "SUM(TongTien) AS TongTienPhieuNhap");
          Sum=rs.getFloat("TongTienPhieuNhap");
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
          ResultSet rs = connect.SelectCustomGroupBy("phieunhap", " MANCC , SUM(TongTien) AS TongTienPhieuNhap ", " MaNCC");
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
          Sum=rs.getFloat("TongTienPhieuNhap");
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập Theo Ngày Nhập ");
        }
        return Sum;
    }
    public float  TongTienPhieuNhapTheoQuyvaNCC(String IDNCC,String ngaymin,String ngaymax){
        //SELECT MANCC,SUM(TongTien) AS TongTienPhieuNhap ,QUARTER(NgayNhap) AS QUY FROM `phieunhap` GROUP BY QUY        float Sum=0;
        try {
          ResultSet rs = connect.SelectCustom("phieunhap", "SUM(TongTien) AS TongTienPhieuNhap","MaNV='"+IDNCC+"' AND NgayNhap BETWEEN '"+ngaymin+"' AND '"+ngaymax+"'");
          Sum=rs.getFloat("TongTienPhieuNhap");
          rs.close();
            connect.Close();//dong ket noi;

        } catch (Exception e) {
            System.out.println("Khong the lay Tổng Tiền Tất Cả Phiếu Nhập Theo Ngày Nhập ");
        }
        return Sum;
    }
   
    public void ExportExcelDatabase() throws Exception{
        try{          
            ResultSet rs = connect.Select("sach");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ThongKeDB");
            
                    
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
        
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;
            
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue("Mã Sách");
            cell.setCellStyle(style);
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue("Mã NXB");
            cell.setCellStyle(style);
            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue("Mã Tác Giả");
            cell.setCellStyle(style);
            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue("Mã Thể Loại");
            cell.setCellStyle(style);
            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue("Tên Sách");
            cell.setCellStyle(style);
            cell = row.createCell(5,CellType.NUMERIC);
            cell.setCellValue("Năm Xuất Bản");
            cell.setCellStyle(style);
            cell = row.createCell(6,CellType.NUMERIC);
            cell.setCellValue("Số Lượng");
            cell.setCellStyle(style);
            cell = row.createCell(7,CellType.NUMERIC);
            cell.setCellValue("Đơn Giá");
            cell.setCellStyle(style);
            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue("Hình Ảnh");
            cell.setCellStyle(style);
            int i = 1;
       
        while(rs.next()){
            row = sheet.createRow(i);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(rs.getString("MaThongKe"));
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(rs.getString("MaNXB"));
            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(rs.getString("MaTG"));
            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(rs.getString("MaTL"));
            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(rs.getString("TenThongKe"));
            cell = row.createCell(5,CellType.NUMERIC);
            cell.setCellValue(rs.getInt("NamXuatBan"));
            cell = row.createCell(6,CellType.NUMERIC);
            cell.setCellValue(rs.getInt("SoLuong"));
            cell = row.createCell(7,CellType.NUMERIC);
            cell.setCellValue(rs.getFloat("DonGia"));
            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(rs.getString("imgName"));
            i++;
        }
        
        for(int colNum = 0;colNum < row.getLastCellNum();colNum++) {
            sheet.autoSizeColumn((short) (colNum));
        }
         
        FileOutputStream out = new FileOutputStream(new File("./report/ThongKeDB.xlsx"));
        workbook.write(out);
        out.close();
        JOptionPane.showMessageDialog(null, "Xuất file excel thành công");
        
        } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Xuất file excel thất bại");
        }
    }
    public static void main(String[] args) {
        
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