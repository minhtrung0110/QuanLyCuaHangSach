

package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKeDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ThongKeBUS {
    HashMap<String,Object> tbthongke ;
    ArrayList<ThongKeDTO>  tbthongketheoQuy ;
    PhieuNhapBUS pn=new PhieuNhapBUS();

    public HashMap<String, Object> getTbthongke() {
        return tbthongke;
    }

    public ArrayList<ThongKeDTO> getTbthongketheoQuy() {
        return tbthongketheoQuy;
    }
    
    
    
    public void ThongKeTienTheoMaNCC() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongke==null ) tbthongke = new HashMap<String,Object>();
        tbthongke=dao.TongTienPhieuNhapTheoMaNCC();
        
    }
    public void ThongKeTienTheoQuyVaMaNCC() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongketheoQuy==null ) tbthongketheoQuy = new ArrayList<ThongKeDTO>();
        tbthongketheoQuy=dao.TongTienPhieuNhapTheoQuyvaNCC();
        
    }
}
