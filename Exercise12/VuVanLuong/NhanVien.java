/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colection_;

import java.util.ArrayList;

/**
 *
 * @author TLC
 */
public class NhanVien {

    private String TenNV;

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getSoSP() {
        return soSP;
    }

    public void setSoSP(int soSP) {
        this.soSP = soSP;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }
    private String MaNV;
    private int soSP;
    private long luong;

    public NhanVien() {
    }

    public NhanVien(String ma, int sp) {
        this.soSP = sp;
        this.MaNV = ma;
    }

    public NhanVien(String ten, String ma, int sp, long luong) {
        this.TenNV = ten;
        this.MaNV = ma;
        this.soSP = sp;
        this.luong = luong;
    }

    @Override
    public String toString() {
        String s = " Mã NV: "+MaNV + " Tên NV: " + TenNV + " Số SP: " + soSP + " Lương: " + luong;
        return s;
    }

    public void equal() {

    }

    public static void main(String[] args) {
        ArrayList<NhanVien> DanhSachNhanVien = new ArrayList<NhanVien>();

        NhanVien n1 = new NhanVien("Vu Luong", "A1", 5, 1);
        NhanVien n2 = new NhanVien("nguyen a", "A2", 99, 1);
        NhanVien n3 = new NhanVien("Nguyen B", "A3", 6, 1);
        NhanVien n4 = new NhanVien("Nguyen C", "A4", 8, 1);

        DanhSachNhanVien.add(n1);
        DanhSachNhanVien.add(n2);
        DanhSachNhanVien.add(n3);
        DanhSachNhanVien.add(n4);
        themNhanVien(DanhSachNhanVien, "Pham Van B", "P1", 3, 4);
        System.err.println("danh sach chua sap xep: " + DanhSachNhanVien +"tong: "+DanhSachNhanVien.size());
        System.out.println("tong luong: " + tongLuong(DanhSachNhanVien));
        System.out.println("thong tin nhan vien co so sp nho nhat: "+InfomationMin(DanhSachNhanVien));
        System.out.println("thong tin nhan vien luong cao nhat: "+NhanVienMaxLuong(DanhSachNhanVien));
        String ketQua = TimKiemMaNV(DanhSachNhanVien, "P1");
        System.out.println("ket qua: "+ketQua);
        sapxep(DanhSachNhanVien);
        System.err.println("danh sach sap xep: "+DanhSachNhanVien +"tong: "+DanhSachNhanVien.size());

    }

    public static void themNhanVien(ArrayList<NhanVien> arr, String ten, String ma, int soSp, long luong) {
        NhanVien n1 = new NhanVien(ten, ma, soSp, luong);
        arr.add(n1);
    }

    public static int SoLuong(ArrayList<NhanVien> arr) {
        int tong = arr.size();
        return tong;
    }

    public static long tongLuong(ArrayList<NhanVien> arr) {
        long tong = 0;
        for (int i = 0; i < arr.size(); i++) {
            tong = tong + arr.get(i).luong;
        }
        return tong;
    }

    public static String InfomationMin(ArrayList<NhanVien> arr) {
        int min = arr.get(0).soSP;
        int giatri = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (min > arr.get(i).soSP) {
                min = arr.get(i).soSP;
                giatri =i;
            }
        }

        if (arr.isEmpty()) {
            return "chuỗi rỗng!";
        } else {
            return arr.get(giatri).toString();
    
        }
    }
    
    public static String NhanVienMaxLuong(ArrayList<NhanVien> arr){
            long max = arr.get(0).luong;
            int giatri=0;
            for(int i= 0 ;i<arr.size();i++){
                if(max<arr.get(i).luong){
                    max=arr.get(i).luong;
                    giatri=i;
                }
            }
            if(arr.isEmpty()) return "chuoi rong";
                    else return arr.get(giatri).toString();
    }
    public static String TimKiemMaNV(ArrayList<NhanVien> arr,String ma){
        String ketQua="khong tim thay";
        for(int i =0; i<arr.size();i++){
            if(ma==arr.get(i).getMaNV()) ketQua = "thong tin: "+ arr.get(i).toString();
        }
        return ketQua;
    }
    public static void sapxep(ArrayList<NhanVien> arr){
        NhanVien a,b;
        int giatri;
        for(int i=0;i<arr.size()-1;i++){
           for(int j=i;j<arr.size();j++)
               if(arr.get(i).soSP>arr.get(j).soSP){
                   a=arr.get(i);
                   b=arr.get(j);
                   
                   
                   arr.remove(i);
                   
                   arr.add(i,b);
                   
                   arr.remove(j);
                   arr.add(j, a);
                   
               }
        }
    }
    public static void xoa(ArrayList<NhanVien> arr,int vitri){
        if(vitri >arr.size()) System.out.println(" khong xoa dc: khong co vi tri "+vitri+"trong List");
        else {
            System.out.println("da xoa thanh cong! ");
            arr.remove(vitri);
        }
    }
}
