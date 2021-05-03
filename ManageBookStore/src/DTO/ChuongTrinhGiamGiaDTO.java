/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tungk
 */
public class ChuongTrinhGiamGiaDTO {
    String id;
    String tenChuongTrinh;
    String Loai;
    Date NgayBD;
    Date NgayKT;

    public ChuongTrinhGiamGiaDTO(String id, String tenChuongTrinh, String Loai, Date NgayBD, Date NgayKT) {
        this.id = id;
        this.tenChuongTrinh = tenChuongTrinh;
        this.Loai = Loai;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }
    
    public ChuongTrinhGiamGiaDTO(String id, String tenChuongTrinh, String Loai, String NgayBD, String NgayKT) {
        this.id = id;
        this.tenChuongTrinh = tenChuongTrinh;
        this.Loai = Loai;
        
        String[] arrayBD = NgayBD.split("-");
        this.NgayBD = new Date(Integer.parseInt(arrayBD[0]) - 1900, 
                Integer.parseInt(arrayBD[1]) - 1, 
                Integer.parseInt(arrayBD[2]));
        String[] arrayKT = NgayKT.split("-");
        this.NgayKT = new Date(Integer.parseInt(arrayKT[0]) - 1900, 
                Integer.parseInt(arrayKT[1]) - 1, 
                Integer.parseInt(arrayKT[2]));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }
    
    public String sqlNgayBD(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(getNgayBD());
    }
    
    public String sqlNgayKT(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(getNgayKT());
    }
}
