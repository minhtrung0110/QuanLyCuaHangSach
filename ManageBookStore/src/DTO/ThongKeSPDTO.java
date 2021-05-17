/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tungk
 */
public class ThongKeSPDTO {
    String MaSach;
    double quy1, quy2, quy3, quy4;

    public ThongKeSPDTO() {
    }

    
    
    public ThongKeSPDTO(String MaSach, int quy1, int quy2, int quy3, int quy4) {
        this.MaSach = MaSach;
        this.quy1 = quy1;
        this.quy2 = quy2;
        this.quy3 = quy3;
        this.quy4 = quy4;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public double getQuy1() {
        return quy1;
    }

    public void setQuy1(double quy1) {
        this.quy1 = quy1;
    }

    public double getQuy2() {
        return quy2;
    }

    public void setQuy2(double quy2) {
        this.quy2 = quy2;
    }

    public double getQuy3() {
        return quy3;
    }

    public void setQuy3(double quy3) {
        this.quy3 = quy3;
    }

    public double getQuy4() {
        return quy4;
    }

    public void setQuy4(double quy4) {
        this.quy4 = quy4;
    }

}