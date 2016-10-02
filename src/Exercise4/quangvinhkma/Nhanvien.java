/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

import java.io.Serializable;

/**
 *
 * @author quang
 */
public class Nhanvien implements Serializable{
    private int maNV, tuoi, luong;
    private String hoten;

    public Nhanvien() {
    }

    public Nhanvien(int maNV, int tuoi, int luong, String hoten) {
        this.maNV = maNV;
        this.tuoi = tuoi;
        this.luong = luong;
        this.hoten = hoten;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
