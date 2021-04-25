package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import DTO.NhanVienDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class NhanVienDAO {
	
    MyConnectUnit connect;
	
	
	public NhanVienDAO() throws IOException 
	{
		  this.connect = new MyConnectUnit();
	}
	
	
	
	public ArrayList<NhanVienDTO> getNhanVien(String Condition,String OrderBy) throws Exception
	{
		
		ResultSet rs = connect.Select("nhanvien", Condition, OrderBy);
		
		ArrayList<NhanVienDTO> dsnv = new ArrayList<NhanVienDTO>();
		
		while(rs.next())
		{
			NhanVienDTO nv = new NhanVienDTO();
			nv.setMaNV(rs.getString("MaNV"));
			nv.setHo(rs.getString("Ho"));
			nv.setTen(rs.getString("Ten"));
                        nv.setSDT(rs.getString("SDT"));
			nv.setEmail(rs.getString("Email"));
			if(rs.getInt("Phai") ==1)
				nv.setPhai(true);
			else nv.setPhai(false);			
			nv.setNgaysinh(rs.getDate("NgaySinh").toString());
			nv.setChucVu(rs.getString("ChucVu"));
			nv.setLuong(rs.getDouble("Luong"));
			
			dsnv.add(nv);
		}
		return dsnv;
	}
	
	public ArrayList<NhanVienDTO> getNhanVien(String Condition) throws Exception
	{
		
		return getNhanVien(Condition,null); 
		
	}
	
	public ArrayList<NhanVienDTO> getNhanVien() throws Exception
	{
		
		return getNhanVien(null,null); 
		
	}
	
	
	public void Insert(NhanVienDTO nv) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 
		
		map.put("MaNV",nv.getMaNV());
                map.put("Ho",nv.getHo());
		map.put("Ten", nv.getTen());
		map.put("SDT",nv.getSDT());
		map.put("Email", nv.getEmail());
		map.put("Phai", nv.isPhai());
                map.put("NgaySinh", nv.getNgaysinh());
                map.put("ChucVu",nv.getChucVu());
		map.put("Luong", nv.getLuong());		
		
		this.connect.Insert("nhanvien", map);
	}
	
	public void Delete(String Condition) throws Exception
	{
		connect.Delete("nhanvien", Condition);
	}
	public void Update(NhanVienDTO nv) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 
		
		map.put("MaNV",nv.getMaNV());
                map.put("Ho",nv.getHo());
		map.put("Ten", nv.getTen());
		map.put("SDT",nv.getSDT());
		map.put("Email", nv.getEmail());
		map.put("Phai", nv.isPhai());
                map.put("NgaySinh", nv.getNgaysinh());
                map.put("ChucVu",nv.getChucVu());
		map.put("Luong", nv.getLuong());
		this.connect.Update("nhanvien", map, "MaNV = '" + nv.getMaNV() + "'");		
	}
	
	
	
}
