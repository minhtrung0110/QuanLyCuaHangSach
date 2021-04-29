
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
   
    /*public ArrayList<ChiTietPhieuNhapDTO> searchChiTietPhieuNhap(String mapn,String manv,String mancc,float tienmin,float tienmax,String min,String max) throws ParseException
    {
        ArrayList<ChiTietPhieuNhapDTO> search = new ArrayList<>();
        mapn = mapn.isEmpty()?mapn = "": mapn;
        manv = manv.equalsIgnoreCase("Không")?manv = "": manv;
        mancc = mancc.equalsIgnoreCase("Không")?mancc = "": mancc; 
        DateCustom daymin=new DateCustom();
        DateCustom daymax=new DateCustom();
        setDate(daymin,min);
        setDate(daymax,max);   
        DateCustom ngaynhap;
        for(ChiTietPhieuNhapDTO sach : listChiTietPhieuNhap)
        {
            ngaynhap =new DateCustom(); setDate(ngaynhap,sach.getMaPN();
            if( sach.getMaPN().contains(mapn) &&
                sach.getMaNV().contains(manv) &&
                sach.getMaNCC().contains(mancc) &&
                sach.getTongTien()>= tienmin && sach.getTongTien()<= tienmax &&
                 daymin.CompareTo(ngaynhap) <= 0 && daymax.CompareTo(ngaynhap) >= 0
               ) 
            {
                
                search.add(sach);
            }
        }
        return search;
    }*/
  
    
}
//SELECT * FROM phieunhap WHERE NgayNhap BETWEEN '2020-01-12' AND '2021-12-01'