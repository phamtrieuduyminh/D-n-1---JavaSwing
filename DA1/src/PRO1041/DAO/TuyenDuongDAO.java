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
public class TuyenDuongDAO {
    public String MaTuyen;
    public String TenTuyen;
    public String DiemDi;
    public String DiemDen;
    public TuyenDuongDAO(){
        super();
    }
    public TuyenDuongDAO(String MaTuyen, String TenTuyen, String DiemDi, String DiemDen){
        this.MaTuyen=MaTuyen;
        this.TenTuyen=TenTuyen;
        this.DiemDi=DiemDi;
        this.DiemDen=DiemDen;
    }

    public String getMaTuyen() {
        return MaTuyen;
    }

    public void setMaTuyen(String MaTuyen) {
        this.MaTuyen = MaTuyen;
    }

    public String getTenTuyen() {
        return TenTuyen;
    }

    public void setTenTuyen(String TenTuyen) {
        this.TenTuyen = TenTuyen;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public void setDiemDi(String DiemDi) {
        this.DiemDi = DiemDi;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String DiemDen) {
        this.DiemDen = DiemDen;
    }
}
