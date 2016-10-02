/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3.bai_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class thaoTac {

    public static String nhapTen() {
        Scanner nhap = new Scanner(System.in);
        String s;
        do {
            System.out.print("nhap ten: ");
            s = nhap.nextLine();
        } while (!s.matches("[a-z A-Z]{5,40}"));
//kiem tra ten chua cac ky tu tu a-z hoac A-Z co tu 5-40 ky tu
        return s;
    }

    public static int nhapTuoi() {
        Scanner nhap = new Scanner(System.in);
        int a = 0;
        boolean check = false;
        while (check == false) {
//            System.out.print(" ");
            try {
                a = nhap.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("nhap tuoi ");
                nhap.nextLine();
            }
        }

        return a;
    }

    public static int nhapMa() {
        Scanner nhap = new Scanner(System.in);
        int a = 0;
        boolean check = false;
        while (check == false) {
//            System.out.print(" ");
            try {
                a = nhap.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("nhap ma: ");
                nhap.nextLine();
            }
        }

        return a;
    }

    public static double nhapLuong() {
        Scanner nhap = new Scanner(System.in);
        double a = 0;
        boolean check = false;
        while (check == false) {
//            System.out.print("nhap luong: ");
            try {
                a = nhap.nextDouble();
                check = true;
            } catch (Exception e) {
                System.out.print("nhap luong: ");
                nhap.nextLine();
            }
        }

        return a;
    }

    public  nhanVien[] create() {
        //phuong thuc tao mang 3 nhan vien

        nhanVien nhanvien[] = new nhanVien[3];

        System.out.println("nhap ho va ten nhan vien: ");
        Scanner nhap = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String ten;
            int tuoi, maNhanVien;
            double luong;
            System.out.println("nhap thong tin nhan vien thu " + (i + 1) + " ");

            ten = thaoTac.nhapTen();
            System.out.print("nhap tuoi: ");
            tuoi = thaoTac.nhapTuoi();
            System.out.print("nhap ma: ");
            maNhanVien = thaoTac.nhapMa();
            System.out.print("nhap luong: ");
            luong = thaoTac.nhapLuong();

            nhanvien[i] = new nhanVien(maNhanVien, tuoi, luong, ten);

        }
        nhap.close();
        return nhanvien;
    }

    public  void writer(nhanVien[] nhanvien, String url) {
        try {
            FileOutputStream out = new FileOutputStream(url);
            try {
                ObjectOutputStream oStream = new ObjectOutputStream(out);
                oStream.writeObject(nhanvien);
                oStream.close();
                out.close();
                System.out.println("ghi thanh cong");
            } catch (IOException ex) {
                System.out.println("khong ghi dc");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("khong tim thay file");
        }

    }

    public  nhanVien[] read(String url) {
        nhanVien[] nhanvien = null;
        try {
            FileInputStream in = new FileInputStream(url);
            try {
                ObjectInputStream iStream = new ObjectInputStream(in);
                try {
                    nhanvien = (nhanVien[]) iStream.readObject();
                    
                    iStream.close();
                    System.out.println("file ok");
                } catch (ClassNotFoundException ex) {
                    System.out.println("class not found");
                }
            } catch (IOException ex) {
                System.out.println("khong the doc file");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("khong tim thay file");
        }
        return nhanvien;
    }

    public  void show(nhanVien[] nhanvien) throws Exception {
        try {

            for (int i = 0; i < nhanvien.length; i++) {
                System.out.println("nhan vien " + (i + 1) + ":     ten : " + nhanvien[i].getHoTen() + "     tuoi: "
                        + nhanvien[i].getTuoi() + "      ma nhan vien: " + nhanvien[i].getMaNV() + "     luong: " + nhanvien[i].getLuong());
            }
        } catch (NullPointerException e) {
            System.out.println("file rong ");
        }
    }

    public  void tinhToan(nhanVien[] nhanvien) {

        int max = 0;
        double tong = 0;
        int k;
        for (int i = 0; i < nhanvien.length; i++) {
            if (max <= nhanvien[i].getMaNV()) {
                max = nhanvien[i].getMaNV();
            }
            tong = tong + nhanvien[i].getLuong();
        }
        System.out.println("nhan vien co ma nhan vien lon nhat: " +max);
        System.out.println("tong luong cua cac nhan vien trong tap tin la:  " +tong);
    }

}
