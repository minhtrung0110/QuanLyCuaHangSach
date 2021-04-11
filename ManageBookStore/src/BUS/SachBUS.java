
package BUS;

import DAO.SachDAO;
import DTO.SachDTO;
import java.util.ArrayList;


public class SachBUS {
    static ArrayList<SachDTO> listSach;

    public static void setListSach(ArrayList<SachDTO> listSach) {
        SachBUS.listSach = listSach;
    }

    public static ArrayList<SachDTO> getListSach() {
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
    public ArrayList<SachDTO> searchSach(String masach,String manxb,String matg,String matl,String tensach,float max,float min)
    {
        ArrayList<SachDTO> search = new ArrayList<>();
        masach = masach.isEmpty()?masach = "": masach;
        manxb = manxb.isEmpty()?manxb = "": manxb;
        matg = matg.isEmpty()?matg = "": matg;
        matl = matl.isEmpty()?matl = "": matl;
        tensach = tensach.isEmpty()?tensach = "": tensach;
        
        for(SachDTO sach : listSach)
        {
            if( sach.getMaSach().contains(masach) || 
                sach.getMaNXB().contains(manxb) ||
                sach.getMaTG().contains(matg) ||
                sach.getMaTL().contains(matl) ||
                sach.getTenSach().contains(tensach) ||
                sach.getDongia() >= min && 
                sach.getDongia() <= max)
            {
                search.add(sach);
            }
        }
        return search;
    }
    
}
