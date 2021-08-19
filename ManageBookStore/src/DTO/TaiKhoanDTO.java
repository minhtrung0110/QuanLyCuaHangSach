/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Vu
 */
public class TaiKhoanDTO {
    
    private String MaTK;
    private String TenTK;
    private String mk;
    private String Quyen;
    private boolean status;
    
    public TaiKhoanDTO() {
        this.MaTK = "";
        this.TenTK = "";
        this.mk = "";
        this.Quyen = "";
        this.status = false;
    }

    public TaiKhoanDTO(String MaTK, String TenTK, String mk, String Quyen, boolean status) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.mk = mk;
        this.Quyen = Quyen;
        this.status = status;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }
    

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
     
    
    
}
