
package DTO;


public class NXBDTO {
    String MaNXB,TenNXB,DiaChi,SDT;

    public NXBDTO() {
    }

    public NXBDTO(String MaNXB, String TenNXB, String DiaChi, String SDT) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
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
        return MaNXB;
    }
    
    
}
