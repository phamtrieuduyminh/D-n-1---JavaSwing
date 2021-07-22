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
public class TaiXeDAO {
    public String MaTX;
    public String TenTX;
    public String SDT;
    public boolean GioiTinh;
    public String HinhAnh;
    public String MaXe;
   
   public TaiXeDAO(){
       super();
   }
   
   public TaiXeDAO(String MaTX, String TenTX, String SDT, boolean GioiTinh, String HinhAnh, String MaXe){
        super();
       this.MaTX=MaTX;
       this.TenTX=TenTX;
       this.SDT=SDT;
       this.GioiTinh=GioiTinh;
       this.HinhAnh=HinhAnh;
       this.MaXe=MaXe;
   }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getMaTX() {
        return MaTX;
    }

    public void setMaTX(String MaTX) {
        this.MaTX = MaTX;
    }

    public String getTenTX() {
        return TenTX;
    }

    public void setTenTX(String TenTX) {
        this.TenTX = TenTX;
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

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
}
