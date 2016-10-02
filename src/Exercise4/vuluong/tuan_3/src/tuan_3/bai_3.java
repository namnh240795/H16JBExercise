/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class bai_3 {

    public static DataInputStream dataIn;
    public static DataOutputStream dataOut;


    public static void main(String[] args) {

        String url = "E:\\thuvienlaptrinh\\test\\bai3.dat";
        //tao file
        try {
            dataOut = new DataOutputStream(new FileOutputStream(url));
            System.out.println("tao file khong thanh cong");
        } catch (Exception ex) {
            Logger.getLogger(bai_3.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("tao file thanh cong");
            return;
        }

//        //ghi file
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : hh:mm:ss");
        String ngay = dateFormat.format(date);
        date.getTime();
        System.out.println(ngay);
        try {
            dataOut.writeInt(1);
            dataOut.writeInt(2);
            dataOut.writeInt(3);
            dataOut.writeInt(4);
            dataOut.writeInt(5);
            dataOut.writeDouble(5.5);
            dataOut.writeChars(ngay);
        } catch (Exception e) {
            System.out.println("ghi file khong thanh cong");
        }
        

    }

}
