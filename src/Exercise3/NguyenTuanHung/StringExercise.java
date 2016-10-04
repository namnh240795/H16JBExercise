/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author User
 */
public class StringExercise {

    public static void main(String[] args) throws IOException {
        StringExercise se = new StringExercise();
        //se.reverseStr();
        se.phoneNumber();
    }
//7
    private String standardize(String s) {
        s = s.trim();
        while (s.indexOf("  ") != -1) {
            s = s.replace("  ", " ");
        }
        String[] temp = s.split(" ");
        s = "";
        for (int i = 0; i < temp.length; i++) {
            s += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                s += " ";
            }
        }
        return s;
    }
//1
    private void countChar() throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("nhap 1 chuoi: ");
        String s = br.readLine();
        System.out.println("nhap mot ky tu: ");
        char c = (char) br.read();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Trong " + s + " co " + count + " ky tu " + c);
    }
//2
    private void checkFamily() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("ho ten: ");
        String s = br.readLine();
        s = standardize(s);
        System.out.println("ho kiem tra: ");
        String fm = br.readLine();
        String[] temp = s.split(" ");
        if (temp[1].equals(fm)) {
            System.out.println("da dung ho " + fm + " can kiem tra");
        } else {
            System.out.println("khong dung ho "+fm);
        }
    }
//3
    private void reverseString() throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("xau can dao: ");
        String s = br.readLine();
        String re = new String();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            re += s.substring(i, i+1);
        }
        System.out.println("xau da dao: "+re);
    }
//4
    private void pathInfo() throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("duong dan: ");
        String s = br.readLine();
        String fileType = new String();
        int lastSlash = s.lastIndexOf("/");
        if(lastSlash > 0){
            fileType = s.substring(lastSlash);
        }
        String filePath = new String();
        int lastDot = s.lastIndexOf(".");
        if(lastDot > 0){
            filePath = s.substring(lastDot);
        }
        String fileName = s.substring(lastSlash+1,lastDot);
        
        System.out.println("Ten file: "+fileName);
        System.out.println("mo rong: "+filePath);
        System.out.println("duong dan: "+s.substring(0, lastSlash));
    }
//5
    private void firstCharacter () throws IOException{
        String first = new String();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("ho ten: ");
        String name = br.readLine();
        name = standardize(name);
        String[] temp = name.split(" ");
        for (int i = 0; i < temp.length; i++) {
            first += temp[i].substring(0, 1);
        }
        System.out.println("cac ky tu dau: "+first);
    }
//6
    private void checkChar() throws IOException{
        int ch = 0, in = 0;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("xau can kiem tra: ");
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
           if(Character.isAlphabetic(s.codePointAt(i))){
               ch++;
           }
           if(Character.isDigit(s.codePointAt(i))){
               in++;
           }
        }
        System.out.println("có "+in+" chữ số");
        System.out.println("có "+ch+" chữ cái");
    }
//8
    private void removeVowels()throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("xâu cần xóa: ");
        String s = br.readLine();
        String outSt = s.replaceAll("[aiueoAIUEO]", "");
        System.out.println(outSt);
    }
//9
    private void phoneNumber()throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("SĐT mẫu: (091) 022-6758080");
        System.out.print("Số điện thoại là: ");
        String number = br.readLine();
        
        if(number.matches("\\([\\d]{3}\\) [\\d]{3}\\-[\\d]{7}")){
            String[] temp = number.split(" ");
            String ctCode = temp[0];
            temp = temp[1].split("-");
            String areaCode = temp[0];
            String tpNumber = temp[1];
            System.out.println("mã QT: "+ctCode);
            System.out.println("mã vùng: "+areaCode);
            System.out.println("số điện thoại: "+tpNumber);
        }
        else{
            System.out.println("nhập sai cú pháp");
            phoneNumber();
        }
    }
//10
    private void reverseStr()throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("chuỗi cần đảo: ");
        String ipStr = br.readLine();
        ipStr = standardize(ipStr);
        String[] temp = ipStr.split(" ");
        String outStr = "";
        for (int i = temp.length-1; i >= 0; i--) {
            outStr += temp[i];
            if(i > 0){
                outStr += " ";
            }
        }
        System.out.println(outStr);
    }
}
