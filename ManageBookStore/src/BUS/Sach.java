
package BUS;


public class Sach {
    public String MaSach, MaNXB,MaTG,MaTL,TenSach;
    public int Soluong;
    public float Dongia;

    public Sach() {
    }

    public Sach(String MaSach, String MaNXB, String MaTG, String MaTL, String TenSach, int Soluong, float Dongia) {
        this.MaSach = MaSach;
        this.MaNXB = MaNXB;
        this.MaTG = MaTG;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
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
