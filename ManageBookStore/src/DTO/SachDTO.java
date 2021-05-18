
package DTO;

public class SachDTO {
    String MaSach, MaNXB,MaTG,MaTL,TenSach,imgName;
    int Soluong,NamXuatBan;
    float Dongia;
    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }
    

    public SachDTO(){
    }

    public SachDTO(String MaSach, String MaNXB, String MaTG, String MaTL, String TenSach,  int NamXuatBan,int Soluong, float Dongia, String imgName) {
        this.MaSach = MaSach;
        this.MaNXB = MaNXB;
        this.MaTG = MaTG;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.imgName = imgName;
        this.Soluong = Soluong;
        this.NamXuatBan = NamXuatBan;
        this.Dongia=Dongia;
    
    }
    
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    

     
    
    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getDongia() {
        return Dongia;
    }

    public void setDongia(float Dongia) {
        this.Dongia = Dongia;
    }
    
    
}
