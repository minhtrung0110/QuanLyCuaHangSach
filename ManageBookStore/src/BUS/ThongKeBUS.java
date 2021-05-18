

package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKeDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ThongKeBUS {
    /*Phiếu Nhập*/
    HashMap<String,Object> tbthongkePNNCC ;
    public ArrayList<ThongKeDTO> tbthongkePNNCCtheoQuy;
    /*Hoa Don*/
     HashMap<String,Object> tbthongkeHDKH ;
    public ArrayList<ThongKeDTO> tbthongkeHDSPtheoQuy;
    public ArrayList<ThongKeDTO> tbthongkeHDNVtheoQuy;

    public void setTbthongkeHDKH(HashMap<String, Object> tbthongkeHDKH) {
        this.tbthongkeHDKH = tbthongkeHDKH;
    }

    public HashMap<String, Object> getTbthongkeHDKH() {
        return tbthongkeHDKH;
    }

    public HashMap<String, Object> getTbthongkePNNCC() {
        return tbthongkePNNCC;
    }

    public void setTbthongkePNNCC(HashMap<String, Object> tbthongkePNNCC) {
        this.tbthongkePNNCC = tbthongkePNNCC;
    }
    
     
    public ArrayList<ThongKeDTO> getTbthongkePNNCCtheoQuy() {
        return tbthongkePNNCCtheoQuy;
    }

    public void setTbthongkePNNCCtheoQuy(ArrayList<ThongKeDTO> tbthongkePNNCCtheoQuy) {
        this.tbthongkePNNCCtheoQuy = tbthongkePNNCCtheoQuy;
    }

    public ArrayList<ThongKeDTO> getTbthongkeHDSPtheoQuy() {
        return tbthongkeHDSPtheoQuy;
    }

    public void setTbthongkeHDSPtheoQuy(ArrayList<ThongKeDTO> tbthongkeHDSPtheoQuy) {
        this.tbthongkeHDSPtheoQuy = tbthongkeHDSPtheoQuy;
    }

    public ArrayList<ThongKeDTO> getTbthongkeHDNVtheoQuy() {
        return tbthongkeHDNVtheoQuy;
    }
    public void setTbthongkeHDNVtheoQuy(ArrayList<ThongKeDTO> tbthongkeHDNVtheoQuy) {
        this.tbthongkeHDNVtheoQuy = tbthongkeHDNVtheoQuy;
    }

   
    
     /*Các hàm tra ve gia tri thong ke cho phieu nhap*/
    public float TongTienPNTheoTG(String ngaymin,String ngaymax) throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienPhieuNhapTheoNgayNhap(ngaymin, ngaymax);
    }
    public long TongTienPN() throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienPhieuNhap();
    }
    public void ThongKeTienPNTheoMaNCC() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongkePNNCC==null ) tbthongkePNNCC = new HashMap<String,Object>();
        tbthongkePNNCC=dao.TongTienPhieuNhapTheoMaNCC();
        
    }
    public void ThongKePNTheoQuyVaMaNCC(String year) throws IOException, Exception{
        ThongKeDAO dao =new ThongKeDAO();
       tbthongkePNNCCtheoQuy=dao.xuatThongKePNNCCtheoQuy(year);
        
    }
    /*Các hàm tra ve gia tri thong ke cho hoa don*/
    public float TongTienHDTheoTG(String ngaymin,String ngaymax) throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienHoaDonTheoNgayNhap(ngaymin, ngaymax);
    }
    public long TongTienHD() throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienHoaDon();
    }
    public void ThongKeHDSPTheoQuy(String year) throws Exception{ 
        ThongKeDAO dao = new ThongKeDAO();
        tbthongkeHDSPtheoQuy = dao.xuatThongKeHDSPtheoQuy(year);
    }
    public void ThongKeHDNVTheoQuy(String year) throws Exception{ 
        ThongKeDAO dao = new ThongKeDAO();
        tbthongkeHDNVtheoQuy = dao.xuatThongKeHDNVtheoQuy(year);
    }
    public void ThongKeTienHDTheoMaKH() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongkeHDKH==null ) tbthongkeHDKH = new HashMap<String,Object>();
        tbthongkeHDKH=dao.TongTienHoaDonTheoKH();
        
    }
}
