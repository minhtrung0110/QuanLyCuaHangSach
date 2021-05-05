

package BUS;

import DAO.ThongKeDAO;
import java.io.IOException;
import java.util.HashMap;


public class ThongKeBUS {
    HashMap<String,Object> tbthongke ;
    PhieuNhapBUS pn=new PhieuNhapBUS();

    public HashMap<String, Object> getTbthongke() {
        return tbthongke;
    }
    
    
    public void ThongKeTienTheoMaNCC() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongke==null ) tbthongke = new HashMap<String,Object>();
        tbthongke=dao.TongTienPhieuNhapTheoMaNCC();
        
    }
}
