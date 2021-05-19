/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class KhachHangBUS {
    public static ArrayList<KhachHangDTO> dskh;
    public KhachHangBUS(){}
    
    public void docDSKH(){
        KhachHangDAO data = new KhachHangDAO();
        if(dskh == null) dskh = new ArrayList<>();
        dskh = data.docDSKH();
    }
    
    public void them(KhachHangDTO kh){
        boolean isOk = true;
        for(KhachHangDTO KH : dskh){
            if(KH.getId().equals(kh.getId())){
                isOk = false;
                JOptionPane.showMessageDialog(null, "Mã KH bị trùng, xin hãy nhập lại");
                break;
            }
        }
        if(isOk){
            KhachHangDAO data = new KhachHangDAO();
            data.them(kh);
            dskh.add(kh);
        }
    }
    
    public void xoa(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.xoa(kh);
        for(KhachHangDTO KH : dskh){
            if(KH.equals(kh)){
                dskh.remove(KH);
                break;
            }
        }
    }
    
    public void sua(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.sua(kh);
        dskh = data.docDSKH();
    }
    
    public ArrayList<KhachHangDTO> timKiemId(String id){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(kh.getId().equals(id)){
                result.add(kh);
                break;
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemHo(String id){
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        for(KhachHangDTO kh : dskh){
            if(kh.getHo().indexOf(id) > -1){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemTen(String id){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(kh.getTen().equals(id)){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemPhai(boolean g){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(kh.isPhai() == g){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemTCT(boolean g, int tct){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(g == true && kh.getTct() > tct){
                result.add(kh);
            } else if(g == false && kh.getTct() < tct){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemSDT(String sdt){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(kh.getSdt().equals(sdt)){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> timKiemEmail(String email){
        ArrayList result = new ArrayList();
        for(KhachHangDTO kh : dskh){
            if(kh.getEmail().equals(email)){
                result.add(kh);
            }
        }
        return result;
    }
}
