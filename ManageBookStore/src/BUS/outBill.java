/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.PageRanges;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 *
 * @author Shadow
 */
public class outBill {
    private String file = "./report/test.pdf";
    private ArrayList<ChiTietHoaDonDTO> cthd = new ArrayList<ChiTietHoaDonDTO>();
    private HoaDonDTO hd;
    private BaseFont bf;
    public outBill()
    {
                
    }

    public outBill(HoaDonDTO hd,ArrayList<ChiTietHoaDonDTO> cthd) 
    {
        this.hd = hd;
        file = "./report/bill"+hd.getMaHD()+".pdf";
        this.cthd = cthd;
    }
    public void print()
    {
        String uderline = "*";
        try {
            //Tạo Font
            bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            
            // Tạo tài liệu
            Document bill = new Document(PageSize.A4, 15, 15, 10, 10);
            
            String line = "";
            for(int i = 0 ; i < bill.getPageSize().getWidth()/5; i++)
            {
                line += uderline;
            }
            //Tạo đối tượng writter
            PdfWriter.getInstance(bill, new FileOutputStream(file));
            
            //Mở document
            bill.open();
            
            Paragraph header = new Paragraph("HÓA ĐƠN",new Font(bf,35));
            header.setAlignment(1);
            bill.add(header);
            
            Paragraph info = new Paragraph("Hóa dơn : "+hd.getMaHD()+"       Ngày : "+hd.getNgayLap()+"     Mã NV:"+hd.getMaNV()+"      Mã KH:"+hd.getMaKH()+"      Mã GG:"+hd.getMaGG(),new Font(bf,15));
            bill.add(info);
            
            Paragraph l = new Paragraph(line);
            l.setAlignment(1);
            bill.add(l);
            
            String[] cellHeader = {"Mã Sách","Tên Sách","SL","Đơn Giá (VNĐ)"};
            System.out.println(cellHeader.length);
            PdfPTable t = new PdfPTable(cellHeader.length);
            t.setSpacingAfter(10);
            t.setSpacingBefore(10);
            int[] relativeWidths = {20,50,10,40};
            t.setWidths(relativeWidths);
            
            for(String s : cellHeader)
            {
                t.addCell(createCell(s, new Font(bf,13)));
            }    
            for(ChiTietHoaDonDTO ct : cthd)
            {
                t.addCell( createCell(ct.getMaSach()) );
                t.addCell( createCell(ct.getTenSach()) );
                t.addCell( createCell(String.valueOf(ct.getSoLuong())) );
                t.addCell( createCell(String.valueOf(ct.getDonGia())) );
              //  t.addCell( createCell(String.valueOf(ct.getGiamGia())) );
              //  t.addCell( createCell(String.valueOf(ct.getThanhTien())) );
            }
            bill.add(t);
            
            bill.add(l);
            
            Paragraph sum = new Paragraph("Thành Tiền: "+ hd.getTongTien()+"đ    Giảm Giá:"+hd.getGiamGia()+"đ   Tổng Tiền:"+hd.getThanhTien()+"đ",new Font(bf,20));
            sum.setAlignment(Element.ALIGN_RIGHT);
            bill.add(sum);
            
            
            bill.close();
     
            JOptionPane.showMessageDialog(null, "In Hoàn Tất");
          
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(outBill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(outBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    public PdfPCell createCell(String s)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,new Font(bf,13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        
        return cell;
    }
    public PdfPCell createCell(String s,Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
    
}
