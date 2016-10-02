/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3.bai_4;

/**
 *
 * @author TLC
 */
public class nhanVien {
   private int maNV;
   private int tuoi;
   private double luong;
   private String hoTen;

    public nhanVien(int maNV, int tuoi, double luong, String hoTen) {
        this.maNV = maNV;
        this.tuoi = tuoi;
        this.luong = luong;
        this.hoTen = hoTen;
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

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String toString(){
       return "Nhan vien:  "+hoTen+" , tuoi : " +tuoi+ " ma nhan vien : " +maNV+"  luong : " +luong;
    }
   
}
