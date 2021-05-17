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
public class TaiKhoanDTO {
    private String id;
    private String username;
    private String password;
    private String quyen;
    private int trangtrai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public int getTrangtrai() {
        return trangtrai;
    }

    public void setTrangtrai(int trangtrai) {
        this.trangtrai = trangtrai;
    }
    
    public TaiKhoanDTO(){}
    
    public TaiKhoanDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
