package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

public class ChiTietHoaDonBUS {
    private static ArrayList<ChiTietHoaDonDTO> CTHD;
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
    public ArrayList<ChiTietHoaDonDTO> getList(){
        return CTHD;
    }
    
}
