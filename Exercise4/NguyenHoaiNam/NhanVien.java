package Exercise4.NguyenHoaiNam;


import java.io.Serializable;

/**
 * Created by Nam on 9/30/2016.
 */
public class NhanVien implements Serializable{
    private int id;
    private String hoten;
    private int tuoi;
    private Double luong;

    public NhanVien() {
    }

    public NhanVien(int id, String hoten, int tuoi, Double luong){
        this.id = id;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public Double getLuong() {
        return luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id='" + id + '\'' +
                ", hoten='" + hoten + '\'' +
                ", tuoi=" + tuoi +
                ", luong=" + luong +
                '}';
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }
}
