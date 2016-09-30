package Exercise4.NguyenHoaiNam;

import java.io.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 * Created by Nam on 9/30/2016.
 */
public class Ex4 {
    // Bai 1
    public void createBinaryFileAndAdd100RandomNumber(){


        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("src\\Exercise4\\NguyenHoaiNam\\bai1.dat"));
            for (int i = 0; i<100;i++){
                double d = Math.random();
                dataOutputStream.writeDouble(d);
                System.out.println(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // đọc 100 số ra sau khi ghi vào file
    public void read100Number(){
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream("src\\Exercise4\\NguyenHoaiNam\\bai1.dat"));
            for (int i = 0; i < 100; i++){
                System.out.println(inputStream.readDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // bài 3
    public void bai3(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\Exercise4\\NguyenHoaiNam\\bai3.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            int[] a = {1,2,3,4,5};
            LocalDate date = LocalDate.now();
            double d = 5.5;
            System.out.println(" ghi mảng vào file");
            for (int i = 0; i< a.length; i++)
                objectOutputStream.writeObject(a[i]);
            System.out.println("ghi date vào file");
            objectOutputStream.writeObject(date);
            System.out.println(" ghi double vào file");
            objectOutputStream.writeObject(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // doc file bai 3
    public void docFileBai3(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\Exercise4\\NguyenHoaiNam\\bai3.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("Doc so nguyen ra ra");
            for(int i =0; i< 5;i++)
                System.out.println(objectInputStream.readObject());
            System.out.println("Doc datetime ra");
            System.out.println(objectInputStream.readObject());
            System.out.println("Doc double ra");
            System.out.println(objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // bai 4
    public void bai4(){
        // nhap vao 3 nhan vien
        Vector<NhanVien> nhanViens = new Vector<>();
        for (int i=0;i<3;i++){
            String id, hoten;
            int tuoi;
            double luong;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("nhap vao id");
                id = bufferedReader.readLine();
                System.out.println("nhap vao ho ten");
                hoten = bufferedReader.readLine();
                System.out.println("nhap vao tuoi");
                tuoi = Integer.parseInt(bufferedReader.readLine());
                System.out.println("nhap vao luong");
                luong = Double.parseDouble(bufferedReader.readLine());
                NhanVien nhanVien = new NhanVien(id,hoten,tuoi,luong);
                nhanViens.add(nhanVien);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileWriter 
        }
    }
    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();
        System.out.println("ghi vao");
        ex4.createBinaryFileAndAdd100RandomNumber();
        System.out.println("doc ra");
        ex4.read100Number();
        System.out.println("viet bai 3");
        ex4.bai3();
        System.out.println("doc bai 3");
        ex4.docFileBai3();
    }
}


