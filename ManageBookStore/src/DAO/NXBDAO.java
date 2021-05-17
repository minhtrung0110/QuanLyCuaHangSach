
package DAO;

import DTO.NXBDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class NXBDAO {
    MyConnectUnit connect;

    public NXBDAO() throws IOException {
        this.connect = new MyConnectUnit();
    }
     public ArrayList<NXBDTO> loadDatabase() throws Exception
    {
        ArrayList<NXBDTO> dsnxb = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("nhaxuatban");
            while(rs.next())
            {
                NXBDTO nxb = new  NXBDTO(rs.getString("MaNXB"),rs.getString("TenNXB"),rs.getString("DiaChiNXB"),rs.getString("SDT"));     
                dsnxb.add(nxb);
            }
            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Không thể load database NXB");
        }

        return dsnxb;
    }
     public void addNXB(NXBDTO nxb) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaNXB",nxb.getMaNXB());
        Insertvalues.put("TenNXB",nxb.getTenNXB());
        Insertvalues.put("DiaChiNXB",nxb.getDiaChi());
        Insertvalues.put("SDT",nxb.getSDT());
        
         try {
             connect.Insert("nhaxuatban", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them NXB vao database !!!");
        }
    }
      public void updateNXB(NXBDTO nxb) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
         Updatevalues.put("MaNXB",nxb.getMaNXB());
         Updatevalues.put("TenNXB",nxb.getTenNXB());
         Updatevalues.put("DiaChiNXB",nxb.getDiaChi());
         Updatevalues.put("SDT",nxb.getSDT());
         try {
           connect.Update("nhaxuatban", Updatevalues," MaNXB ='"+nxb.getMaNXB()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat NXB vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("nhaxuatban","MaNXB ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
