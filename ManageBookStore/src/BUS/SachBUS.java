
package BUS;

import DAO.SachDAO;
import DTO.SachDTO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SachBUS {
    static ArrayList<SachDTO> listSach;

    public static void setListSach(ArrayList<SachDTO> listSach) {
        SachBUS.listSach = listSach;
    }

    public static ArrayList<SachDTO> getListSach() {
        return listSach;
    }
    public  void setlistSach(ArrayList<SachDTO> listSach) {
        SachBUS.listSach = listSach;
    }

    public  ArrayList<SachDTO> getlistSach() {
        return listSach;
    }
    public SachBUS() {
    }
    public void  loadDSSach() throws Exception{
        SachDAO data =new SachDAO();
        if(listSach==null) listSach = new ArrayList<SachDTO>();
        listSach=data.loadDatabase();
    }
    public void addSach(SachDTO sach) throws Exception{
        // validate data
        SachDAO data =new SachDAO();
        data.addSach(sach);
        listSach.add(sach);
        
    }
    public void deleteSach(String idSach) throws Exception{
        
        for(SachDTO sach : listSach )
        {
            if(sach.getMaSach().equalsIgnoreCase(idSach))
            {   
                try {
                   listSach.remove(sach);
                    SachDAO data =new SachDAO();
                    data.delete(idSach);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa Sach vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateSach(SachDTO sach) throws Exception{
         for(int i = 0 ; i < listSach.size() ; i++)
        {
            if(listSach.get(i).getMaSach().equals(sach.getMaSach()))
            {
                try {
                    listSach.set(i, sach);
                SachDAO data =new SachDAO();
                data.updateSach(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat Sach vao database !!!");
                   
                }
                
                return;
            }
        }
    }
   
    public boolean updateTangSLNhap(String MaSP,int SoLuong){
        for(SachDTO sach : listSach)
         {
             if(sach.getMaSach().equals(MaSP))
             {
                int temp=sach.getSoluong();
                sach.setSoluong(temp + SoLuong);
                
                 try {
                    SachDAO sachDAO = new SachDAO();
                    sachDAO.updateSach(sach);
                 } catch (IOException ex) {
                    System.out.println("Không thể cập nhật số lượng.");
                 } catch (Exception ex) {
                    System.out.println("Không thể cập nhật số Lượng.");
                 }
                
                return true;
             }
         }
         return false;
    }
    public boolean updateGiamSLNhap(String MaSP,int SoLuong){
        for(SachDTO sach : listSach)
         {
             if(sach.getMaSach().equals(MaSP))
             {
                int temp=sach.getSoluong();
                sach.setSoluong(temp - SoLuong);
                
                 try {
                    SachDAO sachDAO = new SachDAO();
                    sachDAO.updateSach(sach);
                 } catch (IOException ex) {
                    System.out.println("Không thể cập nhật số lượng.");
                 } catch (Exception ex) {
                    System.out.println("Không thể cập nhật số Lượng.");
                 }
                
                return true;
             }
         }
         return false;
    }
    public boolean updateSL(String MaSP,int SoLuong){
        for(SachDTO sach : listSach)
         {
             if(sach.getMaSach().equals(MaSP))
             {
                
                int old = sach.getSoluong();
                if(SoLuong > old)
                {
                    JOptionPane.showMessageDialog(null, "Không đủ hàng");
                    return false;
                }
                old -= SoLuong;
                sach.setSoluong(old);
                
                 try {
                    SachDAO sachDAO = new SachDAO();
                    sachDAO.updateSach(sach);
                 } catch (IOException ex) {
                    System.out.println("Không thể cập nhật số lượng.");
                 } catch (Exception ex) {
                    System.out.println("Không thể cập nhật số Lượng.");
                 }
                
                return true;
             }
         }
         return false;
    }
    public boolean CheckSL(String masp , int sl)
    {
        for(SachDTO sp : listSach)
         {
             if(sp.getMaSach().equals(masp))
             {
                if(sl > sp.getSoluong())
                {
                    JOptionPane.showMessageDialog(null, "Không đủ hàng");
                    return false;
                }
             }
         }
         return true;
    }
   public SachDTO searchMaSach (String masach)
    {
        for(SachDTO s : listSach)
        {
            if(s.getMaSach().equalsIgnoreCase(masach) )
            {
                return s;
            }
        }
        return null;
    }
    public ArrayList<SachDTO> searchSach(String masach,String manxb,String matg,String matl,String tensach,int namxbmin,int namxbmax,float min,float max)
    {
        ArrayList<SachDTO> search = new ArrayList<>();
        masach = masach.equalsIgnoreCase("Không")?masach = "": masach;
        manxb = manxb.equalsIgnoreCase("Không")?manxb = "": manxb;
        matg = matg.equalsIgnoreCase("Không")?matg = "": matg;
        matl = matl.equalsIgnoreCase("Không")?matl = "": matl;
        tensach = tensach.isEmpty()?tensach = "": tensach;
        
        for(SachDTO sach : listSach)
        {
            /* System.out.println(sach.getMaSach().contains(masach) );

            System.out.println( sach.getMaNXB().contains(manxb));
            System.out.println( sach.getMaTG().contains(matg)  );
            System.out.println( sach.getMaTL().contains(matl) );
            System.out.println( sach.getTenSach().contains(tensach));
            System.out.println( sach.getNamXuatBan()>= namxbmin && sach.getNamXuatBan()<= namxbmax );
            System.out.println(sach.getDongia() >= min && sach.getDongia() <= max );*/
            
             if( sach.getMaSach().contains(masach) &&
                sach.getMaNXB().contains(manxb) &&
                sach.getMaTG().contains(matg) &&
                sach.getMaTL().contains(matl) &&
                sach.getTenSach().contains(tensach) &&
                sach.getNamXuatBan()>= namxbmin && sach.getNamXuatBan()<= namxbmax &&
                sach.getDongia() >= min && sach.getDongia() <= max
               )
            {
                
                search.add(sach);
            }
        }
        return search;
    }
    public int TongDonGia(){
        int sum=0;
        for(SachDTO sach : listSach){
            sum+=sach.getDongia();
        } 
        return sum;
    }
    public float  DonGiaMax(){
        float max=Float.MIN_VALUE;
        for(SachDTO sach : listSach){
            if( max<sach.getDongia()) max=sach.getDongia();
        } 
        return max;
    }
    public float  DonGiaMin(){
        float min=Float.MAX_VALUE;
        for(SachDTO sach : listSach){
            if( min>sach.getDongia()) min=sach.getDongia();
        } 
        return min;
    }
    public int TongSoSach(){
         int sum=0;
        for(SachDTO sach : listSach){
            sum+=sach.getSoluong();
        } 
        return sum;
    }
    public int getLengthListSach(){
        return listSach.size();
    }
    public void ExportExcelDatabase() throws IOException, Exception{
        SachDAO data = new SachDAO();
        data.ExportExcelDatabase();
    }
    
    public void ImportExcelDatabase(File file) throws IOException, Exception{
        SachDAO data = new SachDAO();
        data.ImportExcelDatabase(file);
    }

    
}
