
package BUS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.*;

public class ValidatorBUS {
    public static boolean checkEmpty(JTextField field, StringBuilder sb,String msg){
        boolean ok=true;
        if(field.getText().equalsIgnoreCase("")){
            sb.append(msg).append("\n");
            field.setBackground(Color.yellow);
            ok=false;
        }else{
            field.setBackground(Color.white);
        }
        return ok;
    }
    public static boolean checkEmpty(JRadioButton rd1,JRadioButton rd2, StringBuilder sb,String msg){
        boolean ok=true;
        if(!rd1.isSelected() && !rd2.isSelected() ){
            sb.append(msg).append("\n");
            rd1.setBackground(Color.yellow);
            rd2.setBackground(Color.yellow);
            ok=false;
        }else{
            rd1.setBackground(Color.white);
            rd2.setBackground(Color.white);
        }
        return ok;
    }
     public static boolean checkNumber(JTextField field, StringBuilder sb,String msg) throws Exception {
        boolean ok=true;
        Pattern p = Pattern.compile(" /^\\d+$/");
        if(!checkEmpty(field,sb,"Chưa Nhập Số Lượng!!!")){
            return false;
        }
        
         try {
             if(p.matcher(field.getText()).find() || Integer.parseInt(field.getText())<0 ){
              sb.append("Số Lượng phải là Số và Lớn hơn 0!!!\n");
              field.setBackground(Color.yellow);
              ok=false;
            }
         } catch (Exception e) {
             sb.append("Số Lượng Không Hợp Lệ!Nhập Lại!\n");
              field.setBackground(Color.yellow);
              ok=false;
         }
         if(ok) field.setBackground(Color.white);
        return ok;
    }
     public static boolean checkDonGia(JTextField field, StringBuilder sb,String msg) throws Exception {
        boolean ok=true;
        Pattern p = Pattern.compile("^[0-9]{1,11}$");
        //String regdongia="/^[0-9]\d{1,5}/";
        if(!checkEmpty(field,sb,"Chưa Nhập Đơn Giá!!")){
            return false;
        }
         try {
             if(!p.matcher(field.getText()).find() || Integer.parseInt(field.getText())<=0){
              sb.append("Đơn Giá phải là Số và Lớn hơn 0!!!\n");
              field.setBackground(Color.yellow);
              ok=false;
            }
         } catch (Exception e) {
             sb.append("Đơn Giá Không Hợp Lệ!Nhập lại!\n");
              field.setBackground(Color.yellow);
              ok=false;
         }
         if(ok) field.setBackground(Color.white);
        return ok;
    }
     public static boolean checkEmpty(JComboBox field, StringBuilder sb,String msg){
        boolean ok=true;
        if(field.getSelectedItem().toString().equalsIgnoreCase("")){// xem lai cho nay xem lay du lieu dung hong
            sb.append(msg).append("\n");
            field.setBorder(BorderFactory.createLineBorder(Color.yellow));
            ok=false;
        }else{
            field.setBorder(BorderFactory.createLineBorder(Color.white));
        }
        return ok;
    }
     public static boolean checkSoLuong(JComboBox field, StringBuilder sb,String msg) throws Exception {
        boolean ok=true;
        Pattern p = Pattern.compile("^[0-9]{1,3}/");
        if(!checkEmpty(field,sb,"Chưa Nhập Số Lượng!!!")){
            return false;
        }
        
         try {
             if(p.matcher(field.getSelectedItem().toString()).find() || Integer.parseInt(field.getSelectedItem().toString())<=0 ){
              sb.append("Số Lượng phải là Số và Lớn hơn 0!!!\n");
              field.setBorder(BorderFactory.createLineBorder(Color.yellow));
              ok=false;
            }
         } catch (Exception e) {
             sb.append("Số Lượng Không Hợp Lệ!Nhập Lại!\n");
             field.setBorder(BorderFactory.createLineBorder(Color.yellow));
              ok=false;
         }
         if(ok) field.setBorder(BorderFactory.createLineBorder(Color.white));
        return ok;
    }
     public static boolean checkDonGia(JComboBox field, StringBuilder sb,String msg) throws Exception {
        boolean ok=true;
        Pattern p = Pattern.compile("^[0-9]{1,11}$");
        //String regdongia="/^[0-9]\d{1,5}/";
        if(!checkEmpty(field,sb,"Chưa Nhập Đơn Giá!!")){
            return false;
        }
         try {
             if(!p.matcher(field.getSelectedItem().toString()).find() || Integer.parseInt(field.getSelectedItem().toString())<=0){
              sb.append("Đơn Giá phải là Số và Lớn hơn 0!!!\n");
              field.setBorder(BorderFactory.createLineBorder(Color.yellow));
              ok=false;
            }
         } catch (Exception e) {
             sb.append("Đơn Giá Không Hợp Lệ!Nhập lại!\n");
              field.setBorder(BorderFactory.createLineBorder(Color.yellow));
              ok=false;
         }
         if(ok) field.setBorder(BorderFactory.createLineBorder(Color.white));
        return ok;
    }
}
// Reges ngày thánh nàm dd/mm/yyyy :^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$
