package BUS;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import DAO.MyConnectUnit;
import DAO.NhanVienDAO;
import DTO.*;
import java.io.IOException;
public class NhanVienBUS {

	 
	
	
	private static ArrayList<NhanVienDTO> dsnv;
	
	
	
	public ArrayList<NhanVienDTO> getNhanVien(String Condition,String OrderBy) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien(Condition, OrderBy);
		return dsnv;
	}
	
	public ArrayList<NhanVienDTO> getNhanVien(String Condition) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien(Condition);
		return dsnv;
	}
	public ArrayList<NhanVienDTO> getNhanVien() throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien();
		return dsnv;
	}
	public void loadDatabase() throws IOException, Exception{
            NhanVienDAO conn = new NhanVienDAO();
                if(dsnv==null) dsnv = new ArrayList<NhanVienDTO>();
                dsnv = conn.getNhanVien();
        }
	
	
	
	public NhanVienDTO getMaNV(String mnv) throws Exception
	{
		
		ArrayList<NhanVienDTO> nv = this.getNhanVien("MaNV ='" + mnv + "'" );
		if(dsnv.size()>0)
		{
			return dsnv.toArray(new NhanVienDTO[dsnv.size()]) [0];
			
		}
		return null;
		
	}
	public void Insert(NhanVienDTO nv) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		conn.Insert(nv);
		dsnv.add(nv);
	}
	public void Insert(HashSet<NhanVienDTO> nv) throws Exception
	{
		for(NhanVienDTO n : nv)
		{
			this.Insert(n);
		}
	}

    public static ArrayList<NhanVienDTO> getDsnv() {
        return dsnv;
    }

    public static void setDsnv(ArrayList<NhanVienDTO> dsnv) {
        NhanVienBUS.dsnv = dsnv;
    }
	
	public void Delete(NhanVienDTO nv) throws Exception
	{
		String Condition = "`MaNV` ='" + nv.getMaNV().toString() + "'";
		NhanVienDAO conn = new NhanVienDAO();
		conn.Delete(Condition);
		dsnv.remove(nv);
	}
	public void Update(NhanVienDTO nv,int i) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		conn.Update(nv);
		dsnv.set(i, nv);
	}
	public NhanVienDTO timkiem_MaNV(String id) throws Exception
	{
		NhanVienDTO n=new NhanVienDTO();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getMaNV().compareTo(id)==0)
			{
				n=nv;
			}
		}
		return n;
	}
	
	public ArrayList<NhanVienDTO> timkiem_Ho(String ho) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getHo().indexOf(ho)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}

	public ArrayList<NhanVienDTO> timkiem_Ten(String ten) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getTen().indexOf(ten)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}

	public ArrayList<NhanVienDTO> timkiem_SDT(String SDT) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getSDT().indexOf(SDT)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
	
	
	
	public ArrayList<NhanVienDTO> timkiem_Email(String Email) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getEmail().indexOf(Email)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
	public ArrayList<NhanVienDTO> timkiem_Luong(double luong) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getLuong() == luong)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
	public ArrayList<NhanVienDTO> timkiem_ChucVu(String cv) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.getChucVu().indexOf(cv)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        
	
	
	
	
	
	
	
	
	
	
}
