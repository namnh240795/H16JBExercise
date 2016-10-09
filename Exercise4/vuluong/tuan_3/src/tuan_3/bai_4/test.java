/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3.bai_4;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TLC
 */
public class test {

    public static void main(String[] args) {
        ArrayList<nhanVien> a = new ArrayList<nhanVien>();
        String s = "E:\\thuvienlaptrinh\\test\\nhanvien.txt";
//        thaoTac.nhap(a);
//        thaoTac.luuFile(a, s);

//        hien thi thong tin
        thaoTac.docFile(s);
    }
}
