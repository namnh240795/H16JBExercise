/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

/**
 *
 * @author TLC
 */
public class bai_1 {
    //kiem tr file ton tai hay khong

    public static DataOutputStream dataOut;
    public static DataInputStream dataIn;

    
    public static void main(String[] args) {
        //tao moi file
        String url="E:\\thuvienlaptrinh\\test\\bai1.dat";
        try {
            dataOut = new DataOutputStream(new FileOutputStream(url,true));
            System.out.println("tao file thanh cong");
        } catch (Exception e) {
            System.out.println("toa file khong thanh cong");
            return;
        }
        
        Random a= new Random();
        //ghi 100 so ngau nhien vao file da tao:
          try {
        for (int i=0;i<100;i++){
            dataOut.write(a.nextInt());
              System.out.println("");
        }  
        } catch (Exception e) {
              System.out.println("ghi file khoong thanh cong");
        }
        
        try {
            dataIn = new DataInputStream(new FileInputStream(url));
        } catch (Exception e) {
            System.out.println("mo file khong thanh con");
        }
        
        //doc du lieu duoc ghi vao file
        try {
            for(int i=0;i<100;i++){
            System.out.println("so thu "+i+": "+dataIn.readInt());
            }
        } catch (Exception e) {
            System.out.println("doc file khong thanh cong");
        }
        
    }
}
