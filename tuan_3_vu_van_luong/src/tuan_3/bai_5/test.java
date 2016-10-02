/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan_3.bai_5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLC
 */
public class test {

    public static void main(String[] args) throws Exception {
        //tao nhan vien
        String url = "E:\\thuvienlaptrinh\\test\\nhanvien.dat";
        thaoTac a = new thaoTac();

        nhanVien[] nhanvien = null, nhanvien2 = null;
        nhanvien=a.create();
        a.writer(nhanvien, url);
        nhanvien2=a.read(url);
        a.show(nhanvien2);
        a.tinhToan(nhanvien2);
    
    }
}
