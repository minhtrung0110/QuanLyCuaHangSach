/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DangNhapDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author tungk
 */
public class DangNhapBUS {
    public static ArrayList<TaiKhoanDTO> taikhoan;
    public static TaiKhoanDTO taiKhoanDaDangNhap;
    public DangNhapBUS(){
        //nothing happens
    }
    
    public void docTK(){
        DangNhapDAO dao = new DangNhapDAO();
        if(taikhoan == null){
            taikhoan = new ArrayList();
        }
        taikhoan = dao.docTK();
    }
    
    public boolean isExisted(String username, String password){
        boolean flag = false;
        for(TaiKhoanDTO tk : taikhoan){
            if( (tk.getTenTK().equals( username ) && tk.getMk().equals( password )) ){
                flag = true;
                taiKhoanDaDangNhap = tk;
            }
        }
        return flag;
    }
}
