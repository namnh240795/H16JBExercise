/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3.bai_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void nhap(ArrayList<nhanVien> danhSachNV) {//phuong thuc nhap 3 nhan vien tu ban phim: luu vao file nhanvien.txt
        //co kiem tra dieu kien nhap:
        System.out.println("nhap ho va ten nhan vien: ");
        Scanner nhap = new Scanner(System.in);
//        ArrayList<nhanVien> danhSachNV = new ArrayList<nhanVien>();
        for (int i = 0; i < 3; i++) {
            String ten;
            int tuoi , maNhanVien ;
            double luong;
            System.out.println("nhap thong tin nhan vien thu " + (i + 1) + " ");

            ten = thaoTac.nhapTen();
            System.out.print("nhap tuoi: ");
            tuoi = thaoTac.nhapTuoi();
            System.out.print("nhap ma: ");
            maNhanVien = thaoTac.nhapMa();
            System.out.print("nhap luong: ");
            luong = thaoTac.nhapLuong();

            nhanVien a = new nhanVien(maNhanVien, tuoi, luong, ten);
            danhSachNV.add(a);
            
            
        }
    }
    
    public static void luuFile(ArrayList<nhanVien> a,String s){
        //tao file
        File file = new File(s);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            for(int i=0;i<3;i++){
            bw.write(a.get(i).toString()+"\n");
            }
            bw.close();
            fw.close();
            System.out.println("ghi file thanh cong");
        } catch (IOException ex) {
            System.out.println("khong ghi dc");
        }
        
        
    }
    
    public static void docFile(String s){
        File file = new File(s);
        try {
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String line;
            try {
                while((line = br.readLine())!=null){
                    System.out.println(line);   
                }
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(thaoTac.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(thaoTac.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
