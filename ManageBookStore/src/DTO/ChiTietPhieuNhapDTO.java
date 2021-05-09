/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class ChiTietPhieuNhapDTO {
    String ID,MaPN,MaSach;
    int SoLuong,DonGia;
    float ThanhTien;

    public ChiTietPhieuNhapDTO() {
    }

    public ChiTietPhieuNhapDTO(String ID, String MaPN, String MaSach, int DonGia, int SoLuong, float ThanhTien) {
        this.ID = ID;
        this.MaPN = MaPN;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }
     public ChiTietPhieuNhapDTO(String ID, String MaPN, String MaSach, int DonGia, int SoLuong) {
        this.ID = ID;
        this.MaPN = MaPN;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = SoLuong * DonGia;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }
    public float caculateThanhTien(){
        return SoLuong * DonGia;
    }
    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
