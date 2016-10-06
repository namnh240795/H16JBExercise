/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Nhanvien nhapThongtin() throws IOException{
        System.out.print("Nhap maNV: ");
        String ma = br.readLine();
        while(!ma.matches("[0-9]+")){
            System.out.println("Nhap sai kieu du lieu. Nhap lai...");
            System.out.print("Nhap maNV: ");
            br.readLine();
        }
        int maNV = Integer.parseInt(ma);
        System.out.print("Nhap ho ten NV: ");
        String name = br.readLine();
        String hoten = name.trim();
        hoten = hoten.replaceAll(" +", " ");
        System.out.print("Nhap tuoi: ");
        String age = br.readLine();
        while(!age.matches("[1-9]\\d")){
            System.out.println("Nhap sai kieu du lieu. Nhap lai...");
            System.out.print("Nhap tuoi: ");
            br.readLine();
        }
        int tuoi = Integer.parseInt(age);
        System.out.print("Nhap luong: ");
        String luong = br.readLine();
        while(!luong.matches("[1-9]\\d+")){
            System.out.println("Nhap sai kieu du lieu. Nhap lai...");
            System.out.print("Nhap luong: ");
            br.readLine();
        }
        int luongNV = Integer.parseInt(luong);
        Nhanvien nv = new Nhanvien(maNV, tuoi, luongNV, hoten);
        return nv;
    }
    
    public void writeFile(ArrayList<Nhanvien> listNV, File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oot = new ObjectOutputStream(fos);
        oot.writeObject(listNV);
        oot.close();
        fos.close();
    }
    
    public void readFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis;
        ObjectInputStream ois;
        if(!file.exists()){
            System.out.println("File not found");
        }else{
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            ArrayList<Nhanvien> list = (ArrayList<Nhanvien>) ois.readObject();
            for(int i = 0; i < list.size(); i++){
                System.out.println("Thong tin nhan vien thu "+(i+1));
                System.out.println("Ma nhan vien: "+list.get(i).getMaNV());
                System.out.println("Ho ten nhan vien: "+list.get(i).getHoten());
                System.out.println("Tuoi nhan vien: "+list.get(i).getTuoi());
                System.out.println("Luong nhan vien: "+list.get(i).getLuong());
                System.out.println("=================================");
            }
        }
        
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Main bai5 = new Main();
        File file = new File("nhanvien.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println("Nhap thong tin nhan vien.");
        ArrayList<Nhanvien> listNhanvien = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            System.out.println("Nhan vien thu "+(i+1));
            Nhanvien nv = bai5.nhapThongtin();
            listNhanvien.add(nv);
        }
        bai5.writeFile(listNhanvien, file);
        System.out.println("Ban co muon in ra danh sach nhan vien (yes/no):");
        String tl = br.readLine();
        if((tl.toLowerCase()).equals("yes")){
            bai5.readFile(file);
        }else{
            System.exit(0);
        }
    }
}



