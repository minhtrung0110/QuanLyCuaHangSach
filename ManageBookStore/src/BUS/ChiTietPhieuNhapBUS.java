
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.DateCustom;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class ChiTietPhieuNhapBUS {
    static ArrayList<ChiTietPhieuNhapDTO> listChiTietPhieuNhap;

    public static void setListChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> listChiTietPhieuNhap) {
        ChiTietPhieuNhapBUS.listChiTietPhieuNhap = listChiTietPhieuNhap;
    }

    public static ArrayList<ChiTietPhieuNhapDTO> getListChiTietPhieuNhap() {
        return listChiTietPhieuNhap;
    }
    public void setListChiTietPN(ArrayList<ChiTietPhieuNhapDTO> listChiTietPhieuNhap) {
        ChiTietPhieuNhapBUS.listChiTietPhieuNhap = listChiTietPhieuNhap;
    }

    public  ArrayList<ChiTietPhieuNhapDTO> getListChiTietPN() {
        return listChiTietPhieuNhap;
    }
    public ChiTietPhieuNhapBUS() {
    }
    public void  loadDSChiTietPhieuNhap() throws Exception{
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        if(listChiTietPhieuNhap==null) listChiTietPhieuNhap = new ArrayList<ChiTietPhieuNhapDTO>();
        listChiTietPhieuNhap=data.loadDatabase();
    }
    public void loadDSChiTietPhieuNhapCondition(String condition) throws IOException, Exception{
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        if(listChiTietPhieuNhap==null) listChiTietPhieuNhap = new ArrayList<ChiTietPhieuNhapDTO>();
        listChiTietPhieuNhap=data.loadDatabasewithCondition(condition);
    }
    public void addChiTietPhieuNhap(ChiTietPhieuNhapDTO sach) throws Exception{
        // validate data
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        data.addChiTietPhieuNhap(sach);
        listChiTietPhieuNhap.add(sach);
        
    }
    public void deleteChiTietPhieuNhap(String idChiTietPhieuNhap) throws Exception{
        
        for(ChiTietPhieuNhapDTO sach : listChiTietPhieuNhap )
        {
            if(sach.getID().equalsIgnoreCase(idChiTietPhieuNhap))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.delete(idChiTietPhieuNhap);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void deleteChiTietPhieuNhapByMaPN(String MaPN) throws Exception{
        
        for(ChiTietPhieuNhapDTO sach : listChiTietPhieuNhap )
        {
            if(sach.getMaPN().equalsIgnoreCase(MaPN))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.deletebyMaPN(MaPN);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Phiếu Nhập !!!");
                } 
                return;
            }
        }
        
    }
    public void deleteChiTietPhieuNhapByMaSach(String MaSach) throws Exception{
        
        for(ChiTietPhieuNhapDTO sach : listChiTietPhieuNhap )
        {
            if(sach.getMaSach().equalsIgnoreCase(MaSach))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.deletebyMaSach(MaSach);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Sách !!!");
                } 
                return;
            }
        }
        
    }
    public void updateChiTietPhieuNhap(ChiTietPhieuNhapDTO sach) throws Exception{
         for(int i = 0 ; i < listChiTietPhieuNhap.size() ; i++)
        {
            if(listChiTietPhieuNhap.get(i).getMaPN().equals(sach.getMaPN()))
            {
                try {
                    listChiTietPhieuNhap.set(i, sach);
                ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                data.updateChiTietPhieuNhap(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat ChiTietPhieuNhap vao database !!!");
                   
                }
                
                return;
            }
        }
    }
    public boolean CheckSL(String MaSP,int SoLuong){
        for(ChiTietPhieuNhapDTO ctpn : listChiTietPhieuNhap)
         {
             if(ctpn.getMaSach().equalsIgnoreCase(MaSP))
             {               
                if(SoLuong <= ctpn.getSoLuong())   return true;
             }
         }
         return false;
    }
    public int getSoLuong(String MaSP){
        for(ChiTietPhieuNhapDTO ctpn : listChiTietPhieuNhap)
         {
             if(ctpn.getMaSach().equalsIgnoreCase(MaSP))
             {               
                return ctpn.getSoLuong();
             }
         }
         return 0;
    }
   public ArrayList<ChiTietPhieuNhapDTO> searchMaPN(String idPN ){
       ArrayList<ChiTietPhieuNhapDTO> list =new ArrayList<>();
       for(ChiTietPhieuNhapDTO ct : listChiTietPhieuNhap){
           if( ct.getMaPN().equalsIgnoreCase(idPN)) list.add(ct);
       }
       return list;
   }
   
   public ChiTietPhieuNhapDTO searchMaChiTietPN(String idCTPN ){
       for(ChiTietPhieuNhapDTO ct : listChiTietPhieuNhap){
           if( ct.getID().equalsIgnoreCase(idCTPN)) return ct;
       }
       return null ;
   }
    public ArrayList<ChiTietPhieuNhapDTO> searchChiTietPhieuNhap(String mactpn,String masach,int giamin,int giamax,float tienmin,float tienmax) throws ParseException
    {
        ArrayList<ChiTietPhieuNhapDTO> search = new ArrayList<>();
        mactpn = mactpn.isEmpty()?mactpn = "": mactpn;
        masach = masach.equalsIgnoreCase("Không")?masach = "": masach;
       
        for(ChiTietPhieuNhapDTO ct : listChiTietPhieuNhap)
        {
            if( ct.getID().contains(mactpn) &&
                ct.getMaSach().contains(masach) &&
                ct.getDonGia() >= giamin && ct.getDonGia() <= giamax &&
                    ct.getThanhTien()>= tienmin && ct.getThanhTien() <=tienmax
               ) 
            {
                
                search.add(ct);
            }
        }
        return search;
    }
  public ArrayList<ChiTietPhieuNhapDTO> searchMaSach(String idPN ){
       ArrayList<ChiTietPhieuNhapDTO> list =new ArrayList<>();
       for(ChiTietPhieuNhapDTO ct : listChiTietPhieuNhap){
           if( ct.getMaPN().equalsIgnoreCase(idPN)) list.add(ct);
       }
       return list;
   }
   public ArrayList<String> getListMaSach( ) throws Exception{
       ArrayList<String> list =new ArrayList<String>();
       for(ChiTietPhieuNhapDTO ct : listChiTietPhieuNhap) {
           list.add(ct.getMaSach());
       }
       return list ;
   }
    
}
//SELECT * FROM phieunhap WHERE NgayNhap BETWEEN '2020-01-12' AND '2021-12-01'