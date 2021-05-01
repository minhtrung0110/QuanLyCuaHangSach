/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tungk
 */
public class ChiTietChuongTrinhGiamGiaDTO {
    private String MaGG;
    private double percent;
    private String MaSach;

    public ChiTietChuongTrinhGiamGiaDTO(String MaGG, double percent, String MaSach) {
        this.MaGG = MaGG;
        this.percent = percent;
        this.MaSach = MaSach;
    }

    public ChiTietChuongTrinhGiamGiaDTO() { //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }
    
    
}
