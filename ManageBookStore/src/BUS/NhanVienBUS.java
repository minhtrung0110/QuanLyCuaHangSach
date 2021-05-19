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
			if(nv.getTen().equalsIgnoreCase(ten))
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
			if(nv.getSDT().indexOf(SDT)!= -1)
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
        
        public ArrayList<NhanVienDTO> timkiem_Nam() throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.isPhai() == 1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        public ArrayList<NhanVienDTO> timkiem_Nu() throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
		for(NhanVienDTO nv: dsnv)
		{
			if(nv.isPhai() == 0)
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
        public ArrayList<NhanVienDTO> timkiem_Ngaysinh(String day) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
                
                            
                            String a[] = day.split("-");
                          
                            int dd =  Integer.parseInt(a[0]);
                            int mm =  Integer.parseInt(a[1]);
                            int yy =  Integer.parseInt(a[2]);
                                          
                            for(NhanVienDTO nv : dsnv)
                            {
                               if(nv.getngay()==dd && nv.getthang() == mm && nv.getnam() == yy)
                               {
                                   dsnv_tk.add(nv);
                               }
                             
                            }
		
		return dsnv_tk;
	}
        
	
        public ArrayList<NhanVienDTO> timkiemNC_Luong(String a,String b) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
                int begin = Integer.parseInt(a);
                int end = Integer.parseInt(b);	
		for(NhanVienDTO nv: dsnv)
		{
                  if(nv.getLuong() >= begin && nv.getLuong() <= end)
                    {
                        dsnv_tk.add(nv);
                    }
		}
		return dsnv_tk;
	}
        public ArrayList<NhanVienDTO> timkiemNC_Ngaysinh(String a,String b) throws Exception
	{
		ArrayList<NhanVienDTO> dsnv_tk = new ArrayList<NhanVienDTO>();
                
                            
                            String c[] = a.split("-");
                            String d[] = b.split("-");
                            int Dbegin =  Integer.parseInt(c[0]);
                            int Mbegin =  Integer.parseInt(c[1]);
                            int Ybegin =  Integer.parseInt(c[2]);
                            
                            int Dend = Integer.parseInt(d[0]);
                            int Mend = Integer.parseInt(d[1]);
                            int Yend = Integer.parseInt(d[2]);
                            
                          
                            
                            for(NhanVienDTO nv : dsnv)
                            {
                               
                             if(Ybegin < Yend)
                             {
                                if( nv.getnam() >= Ybegin && nv.getnam() <= Yend )
                                {            
                                    
                                    dsnv_tk.add(nv);
                                }
                             }
                             
                             if(Ybegin == Yend && Yend == nv.getnam())
                             {
                                 if(Mbegin < Mend)
                                {
                                    if( nv.getthang() >= Mbegin && nv.getthang() <= Mend)
                                    {                                 
                                         dsnv_tk.add(nv);
                                    }
                                 }else if(Mbegin == Mend)
                                 {
                                    if( nv.getngay() >= Dbegin && nv.getngay() <= Dend  && nv.getthang() == Mend)
                                    {                                 
                                         dsnv_tk.add(nv);
                                    }
                                 }
                             }
                            }
		
		return dsnv_tk;
	}
	
	  public ArrayList<NhanVienDTO> list() throws Exception
            {
                if(this.dsnv == null)
                {
                    this.getNhanVien();
                    return this.dsnv;
                }
                else return this.dsnv;
            }
	
	
	
	
	
	
	
}
