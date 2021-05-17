/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhGiamGiaDAO;
import DTO.ChuongTrinhGiamGiaDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class ChuongTrinhGiamGiaBUS {
    public static ArrayList<ChuongTrinhGiamGiaDTO> dsChuongTrinh;

    public ChuongTrinhGiamGiaBUS() {
    }
    
    public void docDSChuongTrinh(){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        if (dsChuongTrinh == null)
            dsChuongTrinh = data.docDSCT();
    }
    
    public void them(ChuongTrinhGiamGiaDTO cTrinh){
        System.out.println("BUS.ChuongTrinhGiamGiaBUS.them()");
        boolean isOk = true;
        for(ChuongTrinhGiamGiaDTO ct : dsChuongTrinh){
            if(ct.getId().equals(cTrinh.getId())){
                isOk = false;
                JOptionPane.showMessageDialog(null, "Mã KH bị trùng, xin hãy nhập lại");
                break;
            }
        }
        if(isOk){
            ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
            data.them(cTrinh);
            dsChuongTrinh.add(cTrinh);
        }
    }
    
    public void sua(ChuongTrinhGiamGiaDTO cTrinh){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        data.sua(cTrinh);
        dsChuongTrinh = data.docDSCT();
    }
    
    public void xoa(ChuongTrinhGiamGiaDTO cTrinh){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        data.xoa(cTrinh);
        int i = 0;
        for(ChuongTrinhGiamGiaDTO ct : dsChuongTrinh){
            if(ct.getId().equals(cTrinh.getId())){
                dsChuongTrinh.remove(i);
                break;
            }
            i++;
        }
    }
    public ArrayList<ChuongTrinhGiamGiaDTO> timkiem (Date ngayBD, Date ngayKT){
        ArrayList<ChuongTrinhGiamGiaDTO> dsTimThay = new ArrayList<>();
        
        for(ChuongTrinhGiamGiaDTO ct : dsChuongTrinh){
            Date ctBD = ct.getNgayBD();
            Date ctKT = ct.getNgayKT();
            
            if(ngayBD.compareTo(ctBD) <= 0 && ngayKT.compareTo(ctKT) >= 0){
                dsTimThay.add(ct);
                System.out.println("found");
            }
        }
        return dsTimThay;
    }
}
