
package DAO;

import DTO.TheLoaiDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class TheLoaiDAO {
    MyConnectUnit connect ;
    public TheLoaiDAO() throws IOException {
        connect  =new MyConnectUnit();
    }
     public ArrayList<TheLoaiDTO> loadDatabase() throws Exception
    {
        ArrayList<TheLoaiDTO> dstheloai = new ArrayList<>();
        try {
            ResultSet rs = connect.Select("theloai");
            while(rs.next())
            {
                TheLoaiDTO tl = new  TheLoaiDTO(rs.getString("MaTL"),rs.getString("TenTL"));     
                dstheloai.add(tl);
            }

            rs.close();
            connect.Close();//dong ket noi;

        } catch (SQLException ex) {
            System.out.println("Khong the load database TheLoai");
        }

        return dstheloai;
    }
     public void addNXB(TheLoaiDTO tl) throws Exception
    {
         HashMap<String,Object> Insertvalues =new  HashMap<String,Object>();
         
        Insertvalues.put("MaTL",tl.getMaTL());
        Insertvalues.put("TenTL",tl.getTenTL());
         try {
             connect.Insert("theloai", Insertvalues);
        } catch (SQLException ex) {
            System.out.println("Khong the them NXB vao database !!!");
        }
    }
      public void updateTheLoai(TheLoaiDTO tl) throws Exception
    {
         HashMap<String,Object> Updatevalues =new  HashMap<String,Object>();
         
         Updatevalues.put("MaTL",tl.getMaTL());
         Updatevalues.put("TenTL",tl.getTenTL());
      
         try {
           connect.Update("theloai", Updatevalues," MaTL ='"+tl.getMaTL()+"'");
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat TheLoai vao database !!!");
        }
    }
    public void delete(String idSP)
    {
        try {
                    this.connect.Delete("theloai","MaTL ='"+idSP+"'");
                } catch (Exception e) {
                    System.out.println("Lỗi không thể xóa !!");
                }
        
    }
}
