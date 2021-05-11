/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ThongKeDTO {
    String Ma;
    Float Tien;
    String Quy;

    public ThongKeDTO() {
    }

    public ThongKeDTO(String Ma, Float Tien, String Quy) {
        this.Ma = Ma;
        this.Tien = Tien;
        this.Quy = Quy;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public Float getTien() {
        return Tien;
    }

    public void setTien(Float Tien) {
        this.Tien = Tien;
    }

    public String getQuy() {
        return Quy;
    }

    public void setQuy(String Quy) {
        this.Quy = Quy;
    }
    
    
}
