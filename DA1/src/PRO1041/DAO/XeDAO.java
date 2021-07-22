/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRO1041.DAO;

/**
 *
 * @author tienp
 */
public class XeDAO {
    public String MaXe;
    public String BienSo;
    public String TrangThai;
    public String HinhAnh;
    
    public XeDAO(){
        super();
    }
    
    public XeDAO(String MaXe, String BienSo, String TrangThai, String HinhAnh){
        this.MaXe=MaXe;
        this.BienSo= BienSo;
        this.TrangThai=this.TrangThai;
        this.HinhAnh=HinhAnh;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
}
