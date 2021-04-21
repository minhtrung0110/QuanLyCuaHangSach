package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonBUS {
    private static ArrayList<HoaDonDTO> DSHoaDon;
    public HoaDonBUS(){
        
    }
    public void List(){
        HoaDonDAO HDDAO=new HoaDonDAO();
        DSHoaDon=new ArrayList<>();
        DSHoaDon=HDDAO.List();
    }
    public void Them(HoaDonDTO hd){
        DSHoaDon.add(hd);
        HoaDonDAO HDDAO=new HoaDonDAO();
        HDDAO.Them(hd);
    }
    public void Xoa(String MaHD){
        for(HoaDonDTO hd:DSHoaDon){
            if(hd.getMaHD().equals(MaHD)){
                DSHoaDon.remove(hd);
                HoaDonDAO HDDAO=new HoaDonDAO();
                HDDAO.Xoa(MaHD);
                return;
            }
        }
    }
    public int set(HoaDonDTO hd){
           for(int i=0;i<DSHoaDon.size();i++){
               if(DSHoaDon.get(i).getMaHD().equals(hd.getMaHD())){
                   DSHoaDon.set(i,hd);
                   HoaDonDAO HDDAO=new HoaDonDAO();
                   HDDAO.Sua(hd);
                   return i;
               }
           }
               return -1;
    }
    public ArrayList<HoaDonDTO> TimMAHD(String MaHD){
        ArrayList<HoaDonDTO> mahd=new ArrayList<>();
        if(MaHD.equals("")) return DSHoaDon;
        for(HoaDonDTO hd: DSHoaDon){
            if(hd.getMaHD().toUpperCase().equals(MaHD.toUpperCase())){
                mahd.add(hd);
            }
        }
        return mahd;
    }
    public ArrayList<HoaDonDTO> TimMAHDKH(String MaHD,String MaKH){
        ArrayList<HoaDonDTO> ds=TimMAHD(MaHD);
        ArrayList<HoaDonDTO> makh=new ArrayList<>();
        if(MaKH.equals("")) return ds;
        for(HoaDonDTO hd: ds){
            if(hd.getMaKH().toUpperCase().equals(MaKH.toUpperCase())){
                makh.add(hd);
            }
        }
        return makh;
    }
    public ArrayList<HoaDonDTO> TimMAHDKHNV(String MaHD,String MaKH,String MaNV){
        ArrayList<HoaDonDTO> ds=TimMAHDKH(MaHD,MaKH);
        ArrayList<HoaDonDTO> manv=new ArrayList<>();
        if(MaNV.equals("")) return ds;
        for(HoaDonDTO hd: ds){
            if(hd.getMaNV().toUpperCase().equals(MaNV.toUpperCase())){
                manv.add(hd);
            }
        }
        return manv;
    }
    public ArrayList<HoaDonDTO> TimKiem(int m,int y,float max,float min,String MaHD,String MaKH,String MaNV){
       
        int m1 = 0, m2 = 12;
        int y1 = 0, y2 = Calendar.getInstance().get(Calendar.YEAR);
        
        if(m != -1)
        {
            m1 =m;
            m2 = m;
        }
        if(y != 0)
        {
            y1 = y;
            y2 = y;
        }
        ArrayList<HoaDonDTO> ds=TimMAHDKHNV(MaHD,MaKH,MaNV);
        ArrayList<HoaDonDTO> TimKiem = new ArrayList<>();
        for(HoaDonDTO hd : ds)
        {
           try {
                String date=hd.getNgayLap();
                SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
                Date b=a.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(b);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                
                if( hd.getThanhTien() >= min && hd.getThanhTien() <= max
                        && (month >= m1 && month <= m2)
                        && (year >= y1 && year <= y2))
                {
                    TimKiem.add(hd);
                }
            } catch (ParseException ex) {
               System.out.println("Lỗi tìm kiếm.");
            }
        }
        return TimKiem;
    }
    public ArrayList<HoaDonDTO> getList(){
        return DSHoaDon;
    }
    /*public static void main(String []args){
        System.out.println("Khoi dep trai");
    }*/
}
