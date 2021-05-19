
package DAO;
import DTO.SachDTO;
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

public class SachDAO {
   MyConnectUnit connect ;

    public SachDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<SachDTO> loadDatabase() throws Exception
    {
        ArrayList<SachDTO> dssach = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("sach");
            while(rs.next())
            {
                SachDTO sach = new  SachDTO(rs.getString("MaSach"),
                        rs.getString("MaNXB"),rs.getString("MaTG"),
                        rs.getString("MaTL"),rs.getString("TenSach"),rs.getInt("NamXuatBan"),
                        rs.getInt("SoLuong"),rs.getFloat("DonGia"),rs.getString("imgName"));       
                dssach.add(sach);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database Sach");
        }

        return dssach;
    }
     public void addSach(SachDTO sach) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaSach",sach.getMaSach());
        Insertvalues.put("MaNXB", sach.getMaNXB());
        Insertvalues.put("MaTG", sach.getMaTG());
        Insertvalues.put("MaTL", sach.getMaTL());
        Insertvalues.put("TenSach", sach.getTenSach());
        Insertvalues.put("NamXuatBan", sach.getNamXuatBan());
        Insertvalues.put("SoLuong", sach.getSoluong());
        Insertvalues.put("DonGia", sach.getDongia());
        Insertvalues.put("imgName", sach.getImgName());
         try {
             connect.Insert("sach", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them Sach vao database !!!");
        }
    }
      public void updateSach(SachDTO sach) throws Exception
    {
        HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
        Updatevalues.put("MaSach",sach.getMaSach());
        Updatevalues.put("MaNXB", sach.getMaNXB());
        Updatevalues.put("MaTG", sach.getMaTG());
        Updatevalues.put("MaTL", sach.getMaTL());
        Updatevalues.put("TenSach", sach.getTenSach());
        Updatevalues.put("NamXuatBan", sach.getNamXuatBan());
        Updatevalues.put("SoLuong", sach.getSoluong());
        Updatevalues.put("DonGia", sach.getDongia());
        Updatevalues.put("imgName", sach.getImgName());
         try {
           connect.Update("sach", Updatevalues," MaSach ='"+sach.getMaSach()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat Sach vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("sach","MaSach ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
    
    public void ExportExcelDatabase() throws Exception{
        try{          
            ResultSet rs = connect.Select("sach");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("SachDB");
            
                    
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
            cell.setCellValue(rs.getString("MaSach"));
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(rs.getString("MaNXB"));
            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(rs.getString("MaTG"));
            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(rs.getString("MaTL"));
            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(rs.getString("TenSach"));
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
         
        FileOutputStream out = new FileOutputStream(new File("./report/SachDB.xlsx"));
        workbook.write(out);
        out.close();
        JOptionPane.showMessageDialog(null, "Xuất file excel thành công");
        
        } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Xuất file excel thất bại");
        }
    }
    
    public void ImportExcelDatabase(File file) throws Exception{
        try{
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
       
            SachDTO sach=new SachDTO(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),
                row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue(),
                (int) row.getCell(5).getNumericCellValue(),(int) row.getCell(6).getNumericCellValue(),
                (float) row.getCell(7).getNumericCellValue(),row.getCell(8).getStringCellValue()
                );
            
            String sql_check = "MaSach='"+sach.getMaSach()+"'";
            ResultSet rs = connect.Select("sach",sql_check);
            if(!rs.next())
             this.addSach(sach);
            else 
               this.updateSach(sach);
      
            }
        }
        catch(Exception ex){
          System.out.println("Không Thể Import Sach Từ file Excel");
        }
    }
}
