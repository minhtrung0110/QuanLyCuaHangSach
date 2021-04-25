
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
   
   
    
}
