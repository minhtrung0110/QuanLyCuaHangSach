/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class TacGiaDTO {
    String MaTG,TenTG,DiaChi,SDT;

    public TacGiaDTO() {
    }

    public TacGiaDTO(String MaTG, String TenTG, String DiaChi, String SDT) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    @Override
    public String toString() {
        return MaTG;
    }
    
    
}
