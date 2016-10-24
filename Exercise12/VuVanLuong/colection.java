/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colection_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class colection {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>();

        docFile(map);
        System.out.println("tu dien trong file " + map);
        
        
        
        while (true) {
            Scanner nhap = new Scanner(System.in);
            System.out.println("nhap tu de tra: ");
            String tu = nhap.nextLine();

            if (map.containsKey(tu)) {
                System.out.println(tu+": " + map.get(tu));
            } else {
                System.out.println("khong tim thay tu");
                System.out.println("ban co muon them tu khong?(yes/no)");
                String str = nhap.nextLine();
                switch (str) {
                    case "yes":
                        String a = nhapTuThem();
                        themTu(tu, a);
                        docFile(map);
                        break;
                    case "no":
                        System.out.println("hen gap lai ban! ");
                        break;
                    default:
                        System.out.println("nhap sai dinh dang");
                }
            }
        }

    }

    

    public static String nhapTuThem() {
        String str;
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap tu can them: ");
        str = nhap.nextLine();
        return str;
    }

    public static void themTu(String s1, String s2) {
        File file = new File("E:\\thuvienlaptrinh\\dictionary.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.append(s1 + ",");
            bw.append(s2 + "\n");
            System.out.println("them thanh cong!");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(colection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    public static void ghifile(HashMap<String, String> map) {
        File file = new File("E:\\thuvienlaptrinh\\dictionary.txt");
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String d : map.keySet()) {
                bw.write(d + ",");
                bw.write(map.get(d) + "\n");
            }

            bw.close();
            fw.close();
//            bw.write(map);
        } catch (IOException ex) {
            Logger.getLogger(colection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void docFile(HashMap<String, String> map) {
        File file = new File("E:\\thuvienlaptrinh\\dictionary.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String data[];
            try {
                while ((line = br.readLine()) != null) {
                    System.out.println("line: " + line);
                    data = line.split(",");
                    map.put(data[0], data[1]);

                }
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(colection.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(colection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
