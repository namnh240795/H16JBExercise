/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exercise;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author User
 */
public class IOExercise {

    public static void main(String[] args) throws IOException {
    //1
        //writeInt();
    //3
        //writeFile();
    //4
        //NhanVien nv = new NhanVien();
        //nv.writerFile();
        //nv.readFile();
    //5    
        //writeObject();
        //readObject();
        readMax();
    }

//bai1
    private static void writeInt() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("D:\\bai1.dat");
            for (int i = 0; i < 100; i++) {
                int a = new Random().nextInt();
                String s = String.valueOf(a);
                s = s + "\n";
                fileOut.write(s.getBytes());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//bai3

    private static void writeFile() {
        int[] intArr = {1, 2, 3, 4, 5};
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\bai3.dat");
            for (int i = 0; i < 5; i++) {
                String s = String.valueOf(intArr[i]);
                s = s + " ";
                fos.write(s.getBytes());
            }
            Date date = new Date();
            fos.write(("\n"+date.toString()+"\n").getBytes());
            double a = 5.5;
            String s = String.valueOf(a);
            fos.write(s.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//bai5

    private static void writeObject() {
        
        NhanVien[] nv = new NhanVien[2];
        ObjectOutputStream oos = null;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("D:\\nhanvien.dat")));
            for (int i = 0; i < 2; i++) {
                NhanVien nhanvien = new NhanVien();
                System.out.println("nhan vien thu " + i);
                System.out.print("Ten nhan vien: ");
                nhanvien.setTen(br.readLine());

                System.out.print("Ma nhan vien: ");
                nhanvien.setMa(Integer.parseInt(br.readLine()));

                System.out.print("Tuoi nhan vien: ");
                nhanvien.setTuoi(Integer.parseInt(br.readLine()));

                System.out.print("Luong nhan vien: ");
                nhanvien.setLuong(Integer.parseInt(br.readLine()));

                nv[i] = nhanvien;
            }
            for (int i = 0; i < 2; i++) {
                oos.writeObject(nv[i]);
            }

        } catch (IOException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void readObject() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("D:\\nhanvien.dat")));
            Object object = new Object();
            for (int i = 0; i < 2; i++) {
                object = ois.readObject();
                NhanVien nv = (NhanVien) object;
                System.out.println(nv);
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private static void readMax(){
        NhanVien[] nhanvien = new NhanVien[2];
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("D:\\nhanvien.dat")));
            Object object = new Object();
            for (int i = 0; i < 2; i++) {
                object = ois.readObject();
                NhanVien nv = (NhanVien) object;
                nhanvien[i] = nv;
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(nhanvien[i]);
            }
            int countL = 0;
            int maxMa = nhanvien[0].getMa();
            for (int i = 0; i < 2; i++) {
                countL += nhanvien[i].getLuong();
                if(maxMa < nhanvien[i].getMa()){
                    maxMa = nhanvien[i].getMa();
                }
            }
            System.out.println("Tong luong: "+countL);
            for (int i = 0; i < 2; i++) {
                if(nhanvien[i].getMa() == maxMa){
                    System.out.println("Nhan vien co ma lon nhat: ");
                    System.out.println(nhanvien[i]);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(IOExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//bai 4

class NhanVien implements Serializable {

    int ma;
    String ten;
    int tuoi;
    int luong;

    NhanVien() {
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMa() {
        return ma;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getLuong() {
        return luong;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return "NhanVien{ ma = " + ma + ", ten = " + ten
                + ", tuoi = " + tuoi + ", luong = " + luong + "}";
    }
    public void writerFile() {
        FileWriter fr = null;
        NhanVien nv = new NhanVien();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            fr = new FileWriter(new File("D:\\nhanvien.txt"), true);
            for (int i = 0; i < 2; i++) {
                System.out.println("ten: ");
                nv.setTen(br.readLine());
                System.out.println("ma: ");
                nv.setMa(Integer.parseInt(br.readLine()));
                System.out.println("tuoi: ");
                nv.setTuoi(Integer.parseInt(br.readLine()));
                System.out.println("luong: ");
                nv.setLuong(Integer.parseInt(br.readLine()));
                fr.write(nv.toString());
                fr.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader("D:\\nhanvien.txt"));
            while (br.read() != -1) {
                System.out.println(br.readLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
