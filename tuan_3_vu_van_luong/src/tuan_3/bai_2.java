/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class bai_2 {
  //doc cac dong ky tu tu 1 file text
    //ma hoa UTF? file nhi phan?
    public static void main(String[] args) {
        String url="E:\\thuvienlaptrinh\\test\\bai2.txt";
//        String url2="E:\\thuvienlaptrinh\\test\\bai2.dat";
        File file = new File("E:\\thuvienlaptrinh\\test\\bai2.txt");//tao file
        
        File file2 = new File("E:\\thuvienlaptrinh\\test\\bai2_utf.txt");
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            OutputStream out = new FileOutputStream(file2);
            DataOutputStream data = new DataOutputStream(out);
            try {
                while((line=br.readLine())!=null){
                    System.out.println(line);
                    data.writeUTF(line);
                    data.writeUTF("\n");
                }
                    br.close();
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(bai_2.class.getName()).log(Level.SEVERE, null, ex);
            }
//            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bai_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileReader fr = new FileReader(file2);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            try {
                while((line=br.readLine())!=null){
                    System.out.println(line);
//                    System.out.println("\n");
                }
                    br.close();
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(bai_2.class.getName()).log(Level.SEVERE, null, ex);
            }
//            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bai_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
