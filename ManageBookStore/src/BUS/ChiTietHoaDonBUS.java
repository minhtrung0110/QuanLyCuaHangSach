package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

public class ChiTietHoaDonBUS {
     static ArrayList<ChiTietHoaDonDTO> CTHD;
    public ChiTietHoaDonBUS(){
        
    }
    public ChiTietHoaDonBUS(int i){
        List();
    }
    public void List(){
        ChiTietHoaDonDAO HDDAO=new ChiTietHoaDonDAO();
        CTHD=new ArrayList<>();
        CTHD=HDDAO.List();
    }
    public ArrayList<ChiTietHoaDonDTO> getListHD(String MaHD){
        ArrayList<ChiTietHoaDonDTO> ds=new ArrayList<>();
        for(ChiTietHoaDonDTO ct: CTHD){
            if(ct.getMaHD().equals(MaHD))
                ds.add(ct);
        }
            
        return ds;
    }
    public void Them(ChiTietHoaDonDTO ct){
        CTHD.add(ct);
        ChiTietHoaDonDAO ctdao=new ChiTietHoaDonDAO();
        ctdao.Them(ct);
    }
    public void Sua(ChiTietHoaDonDTO ct){
        for(int i=0;i<CTHD.size();i++){
            if(CTHD.get(i).getMaHD().equals(ct.getMaHD()) && CTHD.get(i).getMaSach().equals(ct.getMaSach())){

                ChiTietHoaDonDAO ctDAO=new ChiTietHoaDonDAO();
                ctDAO.Sua(ct);
                CTHD.set(i,ct);
            }
        }
    }
    public void Xoa(String MaHD){
        for(ChiTietHoaDonDTO ct: CTHD){
            if(ct.getMaHD().equals(MaHD)){
                CTHD.remove(ct);
                ChiTietHoaDonDAO CTDAO=new ChiTietHoaDonDAO();
                CTDAO.Xoa(MaHD);
                return;
            }
        }
    }
    public void XoaMS(String MaSach,String MaHD){
        for(ChiTietHoaDonDTO ct: CTHD){
            if(ct.getMaSach().equals(MaSach) && ct.getMaHD().equals(MaHD)){
                CTHD.remove(ct);
                ChiTietHoaDonDAO CTDAO=new ChiTietHoaDonDAO();
                CTDAO.XoaMS(MaSach,MaHD);
                return;
            }
        }
    }
    public void deleteChiTietHoaDonByMaSach(String MaSach) throws Exception{
        
        for(ChiTietHoaDonDTO sach : CTHD )
        {
            if(sach.getMaSach().equalsIgnoreCase(MaSach))
            {   
                try {
                   CTHD.remove(sach);
                    ChiTietHoaDonDAO data =new ChiTietHoaDonDAO();
                    data.deletebyMaSach(MaSach);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Sách !!!");
                } 
                return;
            }
        }
        
    }
    public ArrayList<ChiTietHoaDonDTO> getList(){
        return CTHD;
    }
    
}
