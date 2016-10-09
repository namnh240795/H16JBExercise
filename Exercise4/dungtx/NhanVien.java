package Lesson04;

/**
 * Created by Dzung on 10/2/2016.
 */
public class NhanVien {
    //Variable
    private static int maNhanVien = 0;
    private String hoTen;
    private int tuoi;
    private double luong;

    //Constructor
    public NhanVien(String hoTen, int tuoi, double luong) {
        this.maNhanVien++;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    //Getters & Setters
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String toString(){
        return String.format("nhan vien so %d: $s, %d tuoi, luong: %f",this.maNhanVien,this.hoTen,this.tuoi,this.luong);
    }
}
