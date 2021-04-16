
package DTO;

/**
 *
 * @author Admin
 */
public class TheLoaiDTO {
    String TenTL,MaTL;

    public TheLoaiDTO() {
    }

    public TheLoaiDTO(String TenTL, String MaTL) {
        this.TenTL = TenTL;
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }
     
    
    
}
