
package DTO;

/**
 *
 * @author Admin
 */
public class TheLoaiDTO {
    String MaTL,TenTL;

    public TheLoaiDTO() {
    }

    public TheLoaiDTO(String MaTL, String TenTL) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;       
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
     @Override
    public String toString() {
        return MaTL;
    }
    
    
    
}
