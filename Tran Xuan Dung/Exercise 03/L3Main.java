package Lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dzung on 9/24/2016.
 */

//Mình tạo mỗi bài là 1 hàm nên nếu muốn chạy thử 1 bài nào bạn có thể gọi nó ở trong main
public class L3Main {
    BufferedReader reader;
    public static void main(String[] args) { //Hàm Main khi complier chạy nó sẽ chỉ vào đây đầu tiên
        L3Main m =  new L3Main(); //Khởi tạo đối tượng Main(class này) vì main là static(được gọi trước) còn các hàm khác thì ko
        m.pathInfo();  //sửa ở đây để chạy các bài
    }

    //Bài 10
    private void reverseWord(){  //Đảo ngược chuỗi cụm từ
        //try catch dùng để bắt lỗi ở đây mình bắt lỗi nhập nếu người dùng ko nhập thì hệ thống sẽ trả lỗi
        try{
            reader = new BufferedReader(new InputStreamReader(System.in)); //Khởi tạo biến nhập vào
            System.out.print("Nhap vao 1 chuoi: ");
            String strInput = reader.readLine(); //Nhận 1 dòng nhập vào
            String[] strings = strInput.split(" "); //Tách chuỗi ra thành mảng cách nhau bởi dấu cách như "Xuan Dung" thành {"Xuan","Dung}
            String strOutput = ""; //Tạo biến lưu kết quả
            //Vòng lặp từ cuối để cho vào chuỗi kết quả từ cuối lên
            for (int i = strings.length-1; i >= 0; i--) {
                strOutput += " " + strings[i];
            }
            System.out.println("Chuoi doi xung la: "+ strOutput);
        }catch (IOException e){ //Bắt lỗi input/output (nhập và xuất) vì reader.readLine() có thể ném
            e.printStackTrace();
        }
    }

    //Bài 9
    private void phoneInfo(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap vao 1 so dien thoai(vd: (091) 022-6758080): ");
            String strPhone = reader.readLine();
            //Kiểm tra xem có đúng mẫu ko
            // \\ = \ ,
            // [\d] là số,
            // {n} là xuất hiện n lần,
            // \( \) \- là để ra bắt ( ) -
            //Ví dụ \\(\\d{3}\\) -> \([\d]{3}\) sẽ bắt (123)
            //Tìm hiểu thêm tại regexr.com
            if (strPhone.matches("\\([\\d]{3}\\) [\\d]{3}\\-[\\d]{7}")){
                String[] strings = strPhone.split(" "); //Tách chuỗi ở dấu cách để lấy mã quốc gia
                String strMaQuocGia = strings[0]; //Mã quốc gia ở vị trí đầu tiên
                strings = strings[1].split("-"); //Tách tiếp ở phần sau để lấy mã vùng và số
                String strMaVung = strings[0];
                String strDienThoai = strings[1];
                System.out.println("Ma quoc gia: " + strMaQuocGia);
                System.out.println("Ma vung: (" + strMaVung + ")");
                System.out.println("So dien thoai: (" + strDienThoai+ ")");
            }else {
                System.out.println("Ban ko nhap dung dinh dang");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 8
    private void removeVowels(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap vao 1 chuoi: ");
            String strInput = reader.readLine();
            //Bắt cứ là "aeiou" hoa hoặc thường sẽ thay thế bởi "" đồng nghĩa vs xoá
            String strOutput = strInput.replaceAll("[AEIOUaeiou]","");
            System.out.println("Chuoi da xoa nguyen am: "+strOutput);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 7
    private void trimString(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap vao 1 chuoi co thua khoang trang: ");
            String strInput = reader.readLine();
            String strProcess = strInput.replaceAll(" +"," ").trim();
            // " +" nghĩa là có nhiều hơn 1 khoảng trắng và trim nghĩa là xoá dấu cách ở 2 đầu
            System.out.println("Chuoi da bo khoang trang la: " + strProcess);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 6
    private void countWordLetterNumber(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap vao 1 chuoi: ");
            String strInput = reader.readLine();
            //Vì chữ cách nhau = cách nên tách ra lấy chiều dài của mảng = số từ
            int wordCounnt = strInput.split(" ").length; //số từ
            int letterCounnt = 0; //số chữ cái
            int numberCounnt = 0;// số chữ số
            char[] chars= strInput.toCharArray(); //tạo mảng các chữ ở trong chuỗi
            for (int i = 0; i < chars.length; i++) {
                if(Character.isAlphabetic(chars[i])){ //Kiểm tra có phải chữ cái ko
                    letterCounnt++;
                }else if(Character.isDigit(chars[i])){ //Kiểm tra có phải chữ số ko
                    numberCounnt++;
                }
            }
            System.out.println("So tu trong chuoi: "+wordCounnt);
            System.out.println("So chu cai trong chuoi: "+letterCounnt);
            System.out.println("So chu so trong chuoi: "+numberCounnt);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 5
    private void getFirstLetter(){
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap ho ten cua ban: ");
            String strInput = reader.readLine();
            strInput = strInput.replaceAll(" +"," ").trim(); //Xoá dấu cách thừa nếu có như ở bài 7
            String[] strings = strInput.split(" ");
            String strInitial =""; //Tạo chuỗi chứa ký tự đầu
            //Vòng lặp lấy ký tự đầu của mỗi chữ
            for (int i = 0; i < strings.length; i++) {
                strInitial += strings[i].charAt(0);
            }
            System.out.println("Cac chu cai dau la: " + strInitial);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 4
    private void pathInfo(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap 1 duong dan cua file: ");
            String strPath = reader.readLine();
            int lastDot = strPath.lastIndexOf('.'); //lấy vị trí của dấu chấm cuối cùng
            String fileType = "";
            if (lastDot > 0){ //nếu có dấu chấm trích đoạn từ dấu chấm đến cuối để lấy đuôi file
                fileType = strPath.substring(lastDot);
            }
            int lastSlash = strPath.lastIndexOf("/"); //lấy vị trí của dấu gạch cuối cùng
            String filePath = "";
            if (lastSlash >0){ //nếu có trích đoạn từ đầu đến đó để lấy đường dẫn
                filePath = strPath.substring(0,lastSlash);
            }
            String fileName = strPath.substring(lastSlash+1,lastDot); // tên file sẽ ở giữa dấu gạch cuối và dấu chấm cuối

            System.out.println("Ten file: "+fileName);
            System.out.println("Duoi file: "+fileType);
            System.out.println("Duong dan: "+filePath);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Bài 3
    private void reverseString(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap 1 chuoi: ");
            String strInput = reader.readLine();
            char[] chars = strInput.toCharArray(); //Tạo mảng ký tự
            String strReverse = new String();
            //Chạy vòng lặp ngược từ cuối để viết ngược cả chuỗi
            for (int i = chars.length-1; i >= 0; i--) {
                strReverse += chars[i];
            }
            System.out.println("Chuoi dao nguoc: " + strReverse);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Bài 2
    private void lastNameDectect(){
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap ten cua ban: ");
            String strName= reader.readLine();
            strName = strName.replaceAll(" +","").trim();
            String[] strings = strName.split(" ");
            // Nếu phần tử đầu (họ) là Tran thì bạn có họ Trần
            if(strings[0].equals("Tran")) {
                System.out.println("Ban co ho Tran");
            }else {
                System.out.println("Ban ko co ho Tran");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Bài 1
    private void countChar(){
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap 1 string: ");
            String strInput = reader.readLine();
            System.out.print("Nhap 1 ky tu: ");
            char charInput = (char) reader.read(); //ép chuyển thành ký tự vì reader.read() chả về số (theo bảng ASCII)
            int count = 0;
            //Vòng lặp qua từng phần tử của chuỗi nếu có chữ xuất hiện thì tăng biến đếm
            for (int i = 0; i < strInput.length(); i++) {
                if (strInput.charAt(i)==charInput){
                    count++;
                }
            }
            System.out.println(charInput + " xuat hien trong " + strInput + ": " + count + " lan");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
