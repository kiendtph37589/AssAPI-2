package com.kiendtph37589.assigmentapi.Model;

public class ProductsModel {
    private String _id;
    private String anhsp,tensp,khoiluongsp,giasp,mota;


    public ProductsModel() {
    }

    public ProductsModel(String _id, String anhsp, String tensp, String khoiluongsp, String giasp, String mota) {
        this._id = _id;
        this.anhsp = anhsp;
        this.tensp = tensp;
        this.khoiluongsp = khoiluongsp;
        this.giasp = giasp;
        this.mota = mota;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAnhsp() {
        return anhsp;
    }

    public void setAnhsp(String anhsp) {
        this.anhsp = anhsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getKhoiluongsp() {
        return khoiluongsp;
    }

    public void setKhoiluongsp(String khoiluongsp) {
        this.khoiluongsp = khoiluongsp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
