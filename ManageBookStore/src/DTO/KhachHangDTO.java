/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author tungk
 */
public class KhachHangDTO {
    class ngaysinh{
        int ngay;
        int thang;
        int nam;

        public ngaysinh(int ngay, int thang, int nam) {
            this.ngay = ngay;
            this.thang = thang;
            this.nam = nam;
        }

        public ngaysinh(String date) {
            String[] arr = date.split("-", 3);
            nam = Integer.parseInt(arr[0]);
            thang = Integer.parseInt(arr[1]);
            ngay = Integer.parseInt(arr[2]);
        }
        
        public int getNgay() {
            return ngay;
        }

        public void setNgay(int ngay) {
            this.ngay = ngay;
        }

        public int getThang() {
            return thang;
        }

        public void setThang(int thang) {
            this.thang = thang;
        }

        public int getNam() {
            return nam;
        }

        public void setNam(int nam) {
            this.nam = nam;
        }

        @Override
        public String toString() {
            return String.format("%d-%d-%d", nam, thang, ngay);
        }
        
        
    }
    
    private String id;
    private String ho;
    private String ten;
    private String sdt;
    private String email;
    private boolean phai;
    private int tct;
    private ngaysinh ns;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHangDTO other = (KhachHangDTO) obj;
        if (this.phai != other.phai) {
            return false;
        }
        if (this.tct != other.tct) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ho, other.ho)) {
            return false;
        }
        if (!Objects.equals(this.ten, other.ten)) {
            return false;
        }
        if (!Objects.equals(this.sdt, other.sdt)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public KhachHangDTO() {
    }

    public KhachHangDTO(String id, String ho, String ten, String sdt, String email, boolean phai, int tct) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.phai = phai;
        this.tct = tct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public int getTct() {
        return tct;
    }

    public void setTct(int tct) {
        this.tct = tct;
    }

    public void setNgaySinh(int ngay, int thang, int nam){
        ns = new ngaysinh(ngay, thang, nam);
    }
    
    public void setNgaySinh(String date){
        ns = new ngaysinh(date);
    }
    
    public String getNgaySinh(){
        return ns.toString();
    }
}
