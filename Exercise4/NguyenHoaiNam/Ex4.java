package Exercise4.NguyenHoaiNam;

import java.io.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 * Created by Nam on 9/30/2016.
 */
public class Ex4 {
    // Bai 1
    public void bai1(){


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
    public void docbai1(){
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
    // bài 2
    public void bai2(){
        try {
            File file = new File("src\\Exercise4\\NguyenHoaiNam\\text.txt");
            File b = new File("src\\Exercise4\\NguyenHoaiNam\\byte.txt");
            FileOutputStream outputStream = new FileOutputStream(b);
            FileInputStream inputStream = new FileInputStream(file);
            int c;
            while((c=inputStream.read()) != -1){
               outputStream.write(c);
            }
            outputStream.close();
            inputStream.close();
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
            String hoten;
            int tuoi, id;
            double luong;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("nhap vao id");
                id = Integer.parseInt(bufferedReader.readLine());
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
        }

        File file = new File("src\\Exercise4\\NguyenHoaiNam\\bai4.dat");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            for (NhanVien nv : nhanViens) {
                System.out.println(nv.toString());
                fileWriter.write(nv.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void docbai4(){
        File file = new File("src\\Exercise4\\NguyenHoaiNam\\bai4.dat");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // bai 5
    public void bai5(){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\Exercise4\\NguyenHoaiNam\\bai5.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i=0;i<3;i++){
                String hoten;
                int tuoi,id;
                double luong;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                try {
                    System.out.println("nhap vao id");
                    id = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("nhap vao ho ten");
                    hoten = bufferedReader.readLine();
                    System.out.println("nhap vao tuoi");
                    tuoi = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("nhap vao luong");
                    luong = Double.parseDouble(bufferedReader.readLine());
                    NhanVien nhanVien = new NhanVien(id,hoten,tuoi,luong);
                    objectOutputStream.writeObject(nhanVien);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docbai5(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\Exercise4\\NguyenHoaiNam\\bai5.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vector<NhanVien> nhanViens = new Vector<>();
            for (int i = 0; i < 3; i++) {
                NhanVien nhanVien = (NhanVien) objectInputStream.readObject();
                nhanViens.add(nhanVien);
            }

            for (NhanVien n :
                    nhanViens) {
                System.out.println(n.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void idLonNhatVaTongLuong(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\Exercise4\\NguyenHoaiNam\\bai5.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vector<NhanVien> nhanViens = new Vector<>();
            int max=-1;
            double sum = 0;
            for (int i = 0; i < 3; i++) {
                NhanVien nhanVien = (NhanVien) objectInputStream.readObject();
                nhanViens.add(nhanVien);
            }

            for (NhanVien n :
                    nhanViens) {
                if(max < n.getId())
                    max = n.getId();
                sum += n.getLuong();
            }
            System.out.println("max id: "+max);
            System.out.println("tong luong: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();
        ex4.bai2();
    }
}


