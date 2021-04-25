package DTO;

import java.sql.Date;

public class NhanVienDTO {

	private String MaNV;
	private String Ho;
	private String Ten;
	private String SDT;
	private String Email;
	private String ChucVu;
	private double Luong;
	private boolean Phai;
	private String ngaysinh;
	
	
	
	



	public NhanVienDTO(String maNV, String ho, String ten, String sDT, String email, String ChucVu, double luong) {
		
		MaNV = maNV;
		Ho = ho;
		Ten = ten;
		SDT = sDT;
		Email = email;
		this.ChucVu = ChucVu;
		Luong = luong;
	}



	public NhanVienDTO() {
		MaNV = "";
		Ho = "";
		Ten = "";
		SDT = "";
		Email = "";
		ChucVu = "";
		Luong = 0;
	}



	public String getMaNV() {
		return MaNV;
	}



	public void setMaNV(String maNV) {
		MaNV = maNV;
	}



	public String getHo() {
		return Ho;
	}



	public void setHo(String ho) {
		Ho = ho;
	}



	public String getTen() {
		return Ten;
	}



	public void setTen(String ten) {
		Ten = ten;
	}



	public String getSDT() {
		return SDT;
	}



	public void setSDT(String sDT) {
		SDT = sDT;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getChucVu() {
		return ChucVu;
	}



	public void setChucVu(String ChucVu) {
		this.ChucVu = ChucVu;
	}



	public double getLuong() {
		return Luong;
	}



	public void setLuong(double luong) {
		Luong = luong;
	}



	public int isPhai() {
		if(this.Phai == true) return 1;
		else return 0;
	}
        public String getPhai(){
            return (Phai)?"Nam":"Nữ";
        }



	public void setPhai(boolean phai) {
		Phai = phai;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}



	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	
	
	
	
	
	
	
}
