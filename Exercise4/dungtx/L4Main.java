package Lesson04;

import java.io.*;
import java.util.Date;

/**
 * Created by Dzung on 9/28/2016.
 */
public class L4Main {
    public static void main(String[] args){
        L4Main main = new L4Main();
        try{
            main.writeNhanVien();
            main.readNhanVien();
            main.handleNhanVien();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Bai 1
    private void writeRandomNumbers() throws IOException{
        FileOutputStream file = new FileOutputStream("bai1.dat");
        DataOutputStream stream = new DataOutputStream(file);
        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random()*100);
            stream.writeBytes(num+"\n");
        }
        stream.close();
        file.close();
    }

    //Bai 2


    //Bai 3
    private void writeMultipleType() throws IOException{
        int[] arr = {1,2,3,4,5};
        Date date = new Date();
        float f = (float) 5.5;
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("bai3.txt"))){
            System.out.printf("write array.....");
            for (int i = 0; i < arr.length; i++) {
                stream.writeInt(arr[i]);
            }
            stream.writeChar('\n');
            System.out.printf("done\n");
            System.out.printf("write date......");
            stream.writeObject(date);
            stream.writeChar('\n');
            System.out.printf("done\n");
            System.out.printf("write float.....");
            stream.writeObject(f);
            System.out.printf("done\n");
        }catch (FileNotFoundException e){
            System.err.println("File not found:" + e.getMessage());
        }catch (IOException e) {
            System.err.println("Can't write: " + e.getMessage());
        }
    }

    //Bai4
    private void ghiNhanVien() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("nhanvien.txt");
        int i = 0;
        while(i<3) {
            System.out.println("Nhap thong tin cua nhan vien: ");
            System.out.printf("Nhap ma cua nhan vien: ");
            int maNhanVien = Integer.parseInt(reader.readLine());
            System.out.printf("Nhap ho ten cua nhan vien: ");
            String hoTen = reader.readLine();
            System.out.printf("Nhap tuoi cua nhan vien: ");
            int tuoi = Integer.parseInt(reader.readLine());
            System.out.printf("Nhap luong cua nhan vien: ");
            double luong = Double.parseDouble(reader.readLine());
            NhanVien nv = new NhanVien(maNhanVien, hoTen, tuoi, luong);
            writer.write(nv.toString()+"\n");
            i++;
        }
        writer.close();
    }

    private void docNhanVien() throws IOException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nhanvien.txt"));
            while(reader.ready()) {
                System.out.println(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }


    //Bai 5
    private int len = 3;
    private void writeNhanVien()throws IOException{
        NhanVien nv[] = new NhanVien[len];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < nv.length; i++) {
            System.out.println("Nhap thong tin cua nhan vien: ");
            System.out.printf("Nhap ma cua nhan vien: ");
            int maNhanVien = Integer.parseInt(reader.readLine());
            System.out.printf("Nhap ho ten cua nhan vien: ");
            String hoTen = reader.readLine();
            System.out.print("Nhap tuoi cua nhan vien: ");
            int tuoi = Integer.parseInt(reader.readLine());
            System.out.printf("Nhap luong cua nhan vien: ");
            double luong = Double.parseDouble(reader.readLine());
            nv[i] = new NhanVien(maNhanVien, hoTen, tuoi, luong);
        }

        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("nhanvien.dat"));
        for (int i = 0; i < nv.length; i++) {
            stream.writeObject(nv[i]);
        }
        stream.close();
    }

    private void readNhanVien() throws IOException{
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("nhanvien.dat"));
        NhanVien nv[] = new NhanVien[len];
        for (int i = 0; i < nv.length; i++) {
            try {
                nv[i] = (NhanVien) stream.readObject();
                System.out.println(nv[i].toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        stream.close();
    }

    private void handleNhanVien() throws IOException{
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("nhanvien.dat"));
        NhanVien nv[] = new NhanVien[len];
        for (int i = 0; i < nv.length; i++) {
            try {
                nv[i] = (NhanVien) stream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        stream.close();
        int maxMaNhanVien = 0;
        double sumLuong = 0;
        for (int i = 0; i < nv.length; i++) {
            if (maxMaNhanVien < nv[i].getMaNhanVien())
                maxMaNhanVien = nv[i].getMaNhanVien();
            sumLuong += nv[i].getLuong();
        }

        System.out.println("Ma nhan vien lon nhat la: " +maxMaNhanVien);
        System.out.println("Tong luong cua nhan vien la: "+sumLuong);
    }
}
