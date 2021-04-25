
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;


public class PhieuNhapBUS {
    static ArrayList<PhieuNhapDTO> listPhieuNhap;

    public static void setListPhieuNhap(ArrayList<PhieuNhapDTO> listPhieuNhap) {
        PhieuNhapBUS.listPhieuNhap = listPhieuNhap;
    }

    public static ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        return listPhieuNhap;
    }
    
    public PhieuNhapBUS() {
    }
    public void  loadDSPhieuNhap() throws Exception{
        PhieuNhapDAO data =new PhieuNhapDAO();
        if(listPhieuNhap==null) listPhieuNhap = new ArrayList<PhieuNhapDTO>();
        listPhieuNhap=data.loadDatabase();
    }
    public void addPhieuNhap(PhieuNhapDTO sach) throws Exception{
        // validate data
        PhieuNhapDAO data =new PhieuNhapDAO();
        data.addPhieuNhap(sach);
        listPhieuNhap.add(sach);
        
    }
    public void deletePhieuNhap(String idPhieuNhap) throws Exception{
        
        for(PhieuNhapDTO sach : listPhieuNhap )
        {
            if(sach.getMaPN().equalsIgnoreCase(idPhieuNhap))
            {   
                try {
                   listPhieuNhap.remove(sach);
                    PhieuNhapDAO data =new PhieuNhapDAO();
                    data.delete(idPhieuNhap);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa PhieuNhap vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updatePhieuNhap(PhieuNhapDTO sach) throws Exception{
         for(int i = 0 ; i < listPhieuNhap.size() ; i++)
        {
            if(listPhieuNhap.get(i).getMaPN().equals(sach.getMaPN()))
            {
                try {
                    listPhieuNhap.set(i, sach);
                PhieuNhapDAO data =new PhieuNhapDAO();
                data.updatePhieuNhap(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat PhieuNhap vao database !!!");
                   
                }
                
                return;
            }
        }
    }
   
    public ArrayList<PhieuNhapDTO> searchPhieuNhap(String mapn,String manv,String mancc,float tienmin,float tienmax,int min,int max)
    {
        ArrayList<PhieuNhapDTO> search = new ArrayList<>();
        mapn = mapn.isEmpty()?mapn = "": mapn;
        manv = manv.equalsIgnoreCase("Không")?manv = "": manv;
        mancc = mancc.equalsIgnoreCase("Không")?mancc = "": mancc;
       
     
        for(PhieuNhapDTO sach : listPhieuNhap)
        {
            if( sach.getMaPN().contains(mapn) &&
                sach.getMaNV().contains(manv) &&
                sach.getMaNCC().contains(mancc) &&
                sach.getTongTien()>= tienmin && sach.getTongTien()<= tienmax //&&
               // sach.getNgayNhap() >= min && sach.getNgayNhap() <= max
               )
            {
                search.add(sach);
            }
        }
        return search;
    }
    public int TongTien(){
        int sum=0;
        for(PhieuNhapDTO sach : listPhieuNhap){
            sum+=sach.getTongTien();
        } 
        return sum;
    }
    public int getLengthListPhieuNhap(){
        return listPhieuNhap.size();
    }
    
}
