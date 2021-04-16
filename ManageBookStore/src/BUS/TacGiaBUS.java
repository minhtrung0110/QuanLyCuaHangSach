/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TacGiaDAO;
import DTO.TacGiaDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TacGiaBUS {

    static ArrayList<TacGiaDTO> listTG;

    public static void setListTacGia(ArrayList<TacGiaDTO> listTacGia) {
        TacGiaBUS.listTG = listTacGia;
    }

    public static ArrayList<TacGiaDTO> getListTacGia() {
        return listTG;
    }
    
    public TacGiaBUS() {
    }
    public void  loadDSTacGia() throws Exception{
        TacGiaDAO data =new TacGiaDAO();
        if(listTG==null) listTG = new ArrayList<TacGiaDTO>();
        listTG=data.loadDatabase();
    }
    public void addTacGia(TacGiaDTO sach) throws Exception{
        // validate data
        TacGiaDAO data =new TacGiaDAO();
        data.addTacGia(sach);
        listTG.add(sach);
        
    }
    public void deleteTG(String idTG) throws Exception{
        
        for(TacGiaDTO sach : listTG )
        {
            if(sach.getMaTG().equalsIgnoreCase(idTG))
            {   
                try {
                   listTG.remove(sach);
                    TacGiaDAO data =new TacGiaDAO();
                    data.delete(idTG);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa Tac Gia vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateTacGia(TacGiaDTO sach) throws Exception{
         for(int i = 0 ; i < listTG.size() ; i++)
        {
            if(listTG.get(i).getMaTG().equals(sach.getMaTG()))
            {
                try {
                    listTG.set(i, sach);
                TacGiaDAO data =new TacGiaDAO();
                data.updateTacGia(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat Tac Gia vao database !!!");
                }
                
                return;
            }
        }
    }
    public TacGiaDTO searchMaTG (String maloai)
    {
        for(TacGiaDTO loai : listTG)
        {
            if( loai.getMaTG().equals(maloai))
            {
                return loai;
            }
        }
        return null;
    }
    public ArrayList<TacGiaDTO> searchTacGia(String matg,String tentg,String diachi,String sdt)
    {
        ArrayList<TacGiaDTO> search = new ArrayList<>();
        matg = matg.isEmpty()?matg = "": matg;
        tentg = tentg.isEmpty()?tentg = "": tentg;
        diachi = diachi.isEmpty()?diachi = "": diachi;
       
        
        for(TacGiaDTO tg : listTG)
        {
            if( tg.getMaTG().contains(matg) && 
                tg.getTenTG().contains(tentg) //&&
               // sach.getDiaChi().contains(matg) &&
                //sach.getSDT().contains(matl) 
               )
            {
                search.add(tg);
            }
        }
        return search;
    }
    
}

