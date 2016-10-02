/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hackademic.bai4;

import vn.hackademic.bai3.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author haopv
 */
public class bai4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //readBytes();
            
            //writeDemo();
            
            //int re = showFile();
            //System.out.println("Re: "+re);
            
            //copyFile();
            //rWData();
            //randomAccessDemo();
            //readChars();
            //readLines();
            //writeFileStreamChar();
            //readFileStreamChar();
            fileDemo();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void readBytes() throws IOException {
        byte data[] = new byte[100];
        int d = 10;
        String s = "Chuỗi mới";
        System.out.print("Enter some characters: ");
        /*System.out.printf("Số d giá trị %d ok",d);
        System.out.printf("Số d giá trị %s ok",s);
        System.out.format("Số d giá trị %s ok",s);
        */
        System.in.read(data);
        System.out.print("You entered: ");
        for (int i = 0; i < data.length; i++) {
            //System.out.print((char) data[i]);
        }
    }

    public static void writeDemo() {
        int b;
        b = 'X';
        System.out.write(b);
        System.out.write('\n');
    }

    public static int showFile() throws IOException {
        int i;
        FileInputStream fin;
        try {
            fin = new FileInputStream("/Volumes/Data/works/java/edu/file/test.txt");
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
            return 1;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: ShowFile File");
            return 0;
        }
        // read bytes until EOF is encountered
        do {
            i = fin.read();
            if (i != -1) {
                System.out.print((char) i);
            }
        } while (i != -1);
        fin.close();
        return 9;
    }

    //Kết quả, chương trình sẽ copy nội dung của file \source.txt và ghi vào một file mới \dest.txt.
    public static void copyFile() throws IOException {
        int i;
        FileInputStream fin;
        FileOutputStream fout;
        try { // open input file
            try {
                fin = new FileInputStream("/Volumes/Data/works/java/edu/file/word_s.rtf");
            } catch (FileNotFoundException exc) {
                System.out.println("Input File Not Found yes");
                return;
            }
            // open output file
            try {
                fout = new FileOutputStream("/Volumes/Data/works/java/edu/file/word_d.rtf");
            } catch (FileNotFoundException exc) {
                System.out.println("Error Opening Output File");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: CopyFile From To");
            return;
        }
        try {// Copy File
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        System.out.println("OK");
        fin.close();
        fout.close();
    }

    // Doc ghi du lieu nhi phan
    public static void rWData() throws IOException {
        DataOutputStream dataOut;
        DataInputStream dataIn;
        int i = 10;
        double d = 1023.56;
        boolean b = true;
        try {
            dataOut = new DataOutputStream(new FileOutputStream("/Volumes/Data/works/java/edu/file/testdata.dat"));
        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }
        try {
            System.out.println("Writing " + i);
            dataOut.writeInt(i);
            System.out.println("Writing " + d);
            dataOut.writeDouble(d);
            System.out.println("Writing " + b);
            dataOut.writeBoolean(b);
            System.out.println("Writing " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);
        } catch (IOException exc) {
            System.out.println("Write error.");
        }
        dataOut.close();
        System.out.println();
        // Now, read them back.
        try {
            dataIn = new DataInputStream(
                    new FileInputStream("/Volumes/Data/works/java/edu/file/testdata.dat"));
        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }
        try {
            
            
            i = dataIn.readInt();
            System.out.println("Reading " + i);
            d = dataIn.readDouble();
            System.out.println("Reading " + d);
            b = dataIn.readBoolean();
            System.out.println("Reading " + b);
            d = dataIn.readDouble();
            System.out.println("Reading " + d);
        } catch (IOException exc) {
            System.out.println("Read error.");
        }
        dataIn.close();
    }

    public static void randomAccessDemo() throws IOException {
        double data[] = {19.4, 10.1, 123.54, 33.0, 87.9, 74.25};
        double d;
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("/Volumes/Data/works/java/edu/file/random.dat", "rw");
        } catch (FileNotFoundException exc) {
            System.out.println("Cannot open file.");
            return;
        }
        // Write values to the file.
        for (int i = 0; i < data.length; i++) {
            try {
                raf.writeDouble(data[i]);
            } catch (IOException exc) {
                System.out.println("Error writing to file.");
                return;
            }
        }

        try { // Now, read back specific values
            raf.seek(0); // seek to first double
            d = raf.readDouble();
            System.out.println("First value is " + d);
            raf.seek(8); // seek to second double
            d = raf.readDouble();
            System.out.println("Second value is " + d);
            raf.seek(8 * 3); // seek to fourth double
            d = raf.readDouble();
            System.out.println("Fourth value is " + d);
            System.out.println();
            // Now, read every other value.
            System.out.println("Here is every other value: ");
            for (int i = 0; i < data.length; i += 2) {
                raf.seek(8 * i); // seek to ith double
                d = raf.readDouble();
                System.out.print(d + " ");
            }
            System.out.println("\n");
        } catch (IOException exc) {
            System.out.println("Error seeking or reading.");
        }
        raf.close();
    }

    // === luong ky tu ==
    public static void readChars() throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap chuoi ky tu, gioi han dau cham '.': ");
        // read characters
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != '.');
    }

    public static void readLines() throws IOException {
        // create a BufferedReader using System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Nhap chuoi.");
        System.out.println("Nhap 'stop' ket thuc chuong trinh: ");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));
    }

    // == file luong ky tu ==
    public static void writeFileStreamChar() throws IOException {
        String str;
        FileWriter fw;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            fw = new FileWriter("/Volumes/Data/works/java/edu/file/streamchar.txt");
        } catch (IOException exc) {
            System.out.println("Khong the mo file.");
            return;
        }
        System.out.println("Nhap ('stop' de ket thuc chuong trinh).");
        do {
            System.out.print(": ");
            str = br.readLine();
            if (str.compareTo("stop") == 0) {
                break;
            }
            str = str + "\r\n";
            fw.write(str);
        } while (str.compareTo("stop") != 0);
        fw.close();
    }

    public static void readFileStreamChar() throws Exception {
        FileReader fr = new FileReader("/Volumes/Data/works/java/edu/file/streamchar.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        fr.close();
        br.close();
    }

    // == file ==
    public static void fileDemo() {
        Frame fr = new Frame("File Demo");
        fr.setBounds(10, 10, 300, 200);
        fr.setLayout(new BorderLayout());
        Panel p = new Panel(new GridLayout(1, 2));
        List list_C = new List();
        list_C.add("/Volumes/Data/works/java/edu/file/");
        File driver_C = new File("/Volumes/Data/works/java/edu/file/");
        String[] dirs_C = driver_C.list();
        for (int i = 0; i < dirs_C.length; i++) {
            File f = new File("/Volumes/Data/works/java/edu/file/" + dirs_C[i]);
            if (f.isDirectory()) {
                list_C.add("<DIR>" + dirs_C[i]);
            } else {
                list_C.add(" "+f.getName());
            }
        }

        List list_D = new List();
        list_D.add("/Volumes/Data/works/java/edu/");
        File driver_D = new File("/Volumes/Data/works/java/edu/");
        String[] dirs_D = driver_D.list();
        for (int i = 0; i < dirs_D.length; i++) {
            File f = new File("/Volumes/Data/works/java/edu/file/" + dirs_D[i]);
            if (f.isDirectory()) {
                list_D.add("<DIR>" + dirs_D[i]);
            } else {
                list_D.add(" " + dirs_D[i]);
            }
        }
        p.add(list_C);
        p.add(list_D);
        fr.add(p, BorderLayout.CENTER);
        fr.setVisible(true);
    }

}
