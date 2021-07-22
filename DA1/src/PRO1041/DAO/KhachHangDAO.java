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
public class KhachHangDAO {
    public String MaKH;
    public String TenKH;
    public String SDT;
    public String NgayDi;
    public String DiemDon;
    public String DiemDen;
    public String ThanhToan;
    public KhachHangDAO(){
        super();
    }
    public KhachHangDAO(String MaKH, String TenKH, String SDT, String NgayDi, String DiemDon, String DiemDen, String ThanhToan){
        this.MaKH=MaKH;
        this.TenKH=TenKH;
        this.SDT=SDT;
        this.NgayDi=NgayDi;
        this.DiemDon=DiemDon;
        this.DiemDen=DiemDen;
        this.ThanhToan=ThanhToan;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(String NgayDi) {
        this.NgayDi = NgayDi;
    }

    public String getDiemDon() {
        return DiemDon;
    }

    public void setDiemDon(String DiemDon) {
        this.DiemDon = DiemDon;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String DiemDen) {
        this.DiemDen = DiemDen;
    }

    public String getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(String ThanhToan) {
        this.ThanhToan = ThanhToan;
    }
}
