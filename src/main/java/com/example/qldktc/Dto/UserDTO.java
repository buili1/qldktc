package com.example.qldktc.Dto;

import java.time.LocalDate;

public class UserDTO {
    private String masv;
    private String hoten;
    private boolean gioitinh;
    private String diachi;
    private LocalDate ngaysinh;
    private String malop;
    private boolean danghihoc;
    private String password;
    private String cccd;
    private String chuyennganh;
    private int role;

    public UserDTO() {
    }

    public UserDTO(String masv, String hoten, boolean gioitinh, String diachi, LocalDate ngaysinh, String malop, boolean danghihoc, String password, String cccd, String chuyennganh, int role) {
        this.masv = masv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.malop = malop;
        this.danghihoc = danghihoc;
        this.password = password;
        this.cccd = cccd;
        this.chuyennganh = chuyennganh;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public boolean isDanghihoc() {
        return danghihoc;
    }

    public void setDanghihoc(boolean danghihoc) {
        this.danghihoc = danghihoc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "masv='" + masv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", gioitinh=" + gioitinh +
                ", diachi='" + diachi + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", malop='" + malop + '\'' +
                ", danghihoc=" + danghihoc +
                ", password='" + password + '\'' +
                ", cccd='" + cccd + '\'' +
                ", chuyennganh='" + chuyennganh + '\'' +
                '}';
    }
}
