package Exercise4.NguyenHoaiNam;


/**
 * Created by Nam on 9/30/2016.
 */
public class NhanVien {
    private String id;
    private String hoten;
    private int tuoi;
    private Double luong;

    public NhanVien() {
    }

    public NhanVien(String id, String hoten, int tuoi, Double luong) {
        this.id = id;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setLuong(Double luong) {
        this.luong = luong;
    }
}
