package com.example.qldktc.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="sinhvien")
public class SinhVien {


    @Id
    @Column(name = "MASV", length = 45)
    private String masv; // Đúng với tên cột trong database

    @Column(name = "HOTEN", length = 255)
    private String hoten;

    @Column(name = "GIOITINH", length = 1)
    private boolean gioitinh;

    @Column(name = "DIACHI", length = 255)
    private String diachi;

    @Column(name = "NGAYSINH")
    private LocalDate ngaysinh;

    @Column(name = "MALOP", length = 255)
    private String malop;

    @Column(name = "DANGHIHOC")
    private boolean danghihoc;

    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "CCCD", length = 255)
    private String cccd;

    @Column(name = "CHUYENNGANH", length = 255)
    private String chuyennganh;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, boolean gioitinh, String diachi, LocalDate ngaysinh, String malop, boolean danghihoc, String password, String cccd, String chuyennganh) {
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
}
