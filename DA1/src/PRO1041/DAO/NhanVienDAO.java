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
public class NhanVienDAO {
    public String MaNV;
    public String TenNV;
    public String SDT;
    public boolean GioiTinh;
    public String Email;
    public String ChucVu;
    public String HinhAnh;
    
    public NhanVienDAO(){
        super();
    }
    public NhanVienDAO(String MaNV, String TenNV, String SDT, boolean GioiTinh, String Email, String ChucVu, String HinhAnh){
        super();
        this.MaNV=MaNV;
        this.TenNV=TenNV;
        this.SDT=SDT;
        this.GioiTinh=GioiTinh;
        this.Email=Email;
        this.ChucVu=ChucVu;
        this.HinhAnh=HinhAnh;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
}
