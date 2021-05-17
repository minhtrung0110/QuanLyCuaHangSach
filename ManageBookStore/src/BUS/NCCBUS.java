
package BUS;

import DAO.NCCDAO;
import DTO.NCCDTO;
import java.util.ArrayList;


public class NCCBUS {
    static ArrayList<NCCDTO> listNCC;

    public static void setListNCC(ArrayList<NCCDTO> listNCC) {
        NCCBUS.listNCC = listNCC;
    }

    public static ArrayList<NCCDTO> getListNCC() {
        return listNCC;
    }
    
    public NCCBUS() {
    }
    public void  loadDSNCC() throws Exception{
        NCCDAO data =new NCCDAO();
        if(listNCC==null) listNCC = new ArrayList<NCCDTO>();
        listNCC=data.loadDatabase();
    }
    public void addNCC(NCCDTO ncc) throws Exception{
        // validate data
        NCCDAO data =new NCCDAO();
        data.addNCC(ncc);
        listNCC.add(ncc);
        
    }
    public void deleteNCC(String idNCC) throws Exception{
        
        for(NCCDTO ncc : listNCC )
        {
            if(ncc.getMaNCC().equalsIgnoreCase(idNCC))
            {   
                try {
                   listNCC.remove(ncc);
                    NCCDAO data =new NCCDAO();
                    data.delete(idNCC);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa NCC vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateNCC(NCCDTO ncc) throws Exception{
         for(int i = 0 ; i < listNCC.size() ; i++)
        {
            if(listNCC.get(i).getMaNCC().equals(ncc.getMaNCC()))
            {
                try {
                    listNCC.set(i, ncc);
                NCCDAO data =new NCCDAO();
                data.updateNCC(ncc);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat NCC vao database !!!");
                   
                }
                
                return;
            }
        }
    }
    public NCCDTO SearchMaNCC(String id){
        for(NCCDTO ncc : listNCC){
            if(ncc.getMaNCC().equalsIgnoreCase(id)) return ncc;
        }
        return null;
    }
   
    public ArrayList<NCCDTO> list() throws Exception
    {
        if (this.listNCC == null)
        {
            this.loadDSNCC();
        }
        return listNCC;
    }

    public NCCDTO timkiem_MaNCC(String id)
    {
        NCCDTO n = new NCCDTO();
        for(NCCDTO ncc : listNCC)
        {
            if(ncc.getMaNCC().compareTo(id) == 0)
            {
                n = ncc;
            }
        }
        return n;
    }
    public ArrayList<NCCDTO> timkiem_TenNCC(String ten)
    {
        ArrayList<NCCDTO> n = new ArrayList<NCCDTO>();
        for(NCCDTO ncc : listNCC)
        {
            if(ncc.getTenNCC().indexOf(ten) != -1)
            {
                n.add(ncc);
            }
        }
        return n;
    }
    public ArrayList<NCCDTO> timkiem_DiaChi(String diachi)
    {
        ArrayList<NCCDTO> n = new ArrayList<NCCDTO>();
        for(NCCDTO ncc : listNCC)
        {
            if(ncc.getDiaChi().indexOf(diachi) != -1)
            {
                n.add(ncc);
            }
        }
        return n;
    }
   
    
}
