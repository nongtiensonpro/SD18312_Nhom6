/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Nong_Tien_Son
 */
public class SanPhamNew {
    private String ma_SanPhamChiTiet;
    private String maSize;
    private String ten;
    private String maSanXuat;
    private String maMauSac;
    private String maHang;
    private byte[] anhSanPham;
    private String maChatLieu;
    private Double giaNhap;
    private Double giaBan;
    private int soLuong;
    private boolean trangThai;
    private Date ngayTao;
    private Date ngaySua;
    private String moTa;

    public SanPhamNew() {
    }

    public SanPhamNew(String ma_SanPhamChiTiet, String maSize, String ten, String maSanXuat, String maMauSac, String maHang, byte[] anhSanPham, String maChatLieu, Double giaNhap, Double giaBan, int soLuong, boolean trangThai, Date ngayTao, Date ngaySua, String moTa) {
        this.ma_SanPhamChiTiet = ma_SanPhamChiTiet;
        this.maSize = maSize;
        this.ten = ten;
        this.maSanXuat = maSanXuat;
        this.maMauSac = maMauSac;
        this.maHang = maHang;
        this.anhSanPham = anhSanPham;
        this.maChatLieu = maChatLieu;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.moTa = moTa;
    }

    public String getMa_SanPhamChiTiet() {
        return ma_SanPhamChiTiet;
    }

    public void setMa_SanPhamChiTiet(String ma_SanPhamChiTiet) {
        this.ma_SanPhamChiTiet = ma_SanPhamChiTiet;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaSanXuat() {
        return maSanXuat;
    }

    public void setMaSanXuat(String maSanXuat) {
        this.maSanXuat = maSanXuat;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public byte[] getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(byte[] anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
}
