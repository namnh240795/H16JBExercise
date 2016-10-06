/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author quang
 */
public class readFile {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("nhanvien.dat");
        FileInputStream fis;
        ObjectInputStream ois;
        ArrayList<Nhanvien> list;
        if(!file.exists()){
            System.out.println("File not found");
        }else{
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Nhanvien>) ois.readObject();
            int min = list.get(0).getMaNV();
            int sum = list.get(0).getLuong();
            for(int i = 1; i < list.size(); i++){
                if(list.get(i).getMaNV() < min) {
                    min = list.get(i).getMaNV();
                }
                sum += list.get(i).getLuong();
            }
            for (Iterator<Nhanvien> it = list.iterator(); it.hasNext();) {
                Nhanvien nv = it.next();
                if(nv.getMaNV() == min){
                    System.out.println("Thong tin nhan vien can tim.");
                    System.out.println("Ma nv: "+nv.getMaNV());
                    System.out.println("Ho ten: "+nv.getHoten());
                    System.out.println("Tuoi: "+nv.getTuoi());
                    System.out.println("Luong: "+nv.getLuong());
                }
            }
            
            System.out.println("Tong luong cua nhan vien: "+sum);
        }
    }
}
