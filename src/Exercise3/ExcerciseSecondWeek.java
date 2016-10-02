

/**
 * Created by panda on 25/09/2016.
 */
public class ExcerciseSecondWeek {
    public static void bai1(String string1, String string2) {
        //Viết chương trình nhập vào một xâu ký tự và một ký tự ch. Đếm và in ra màn hình số lần xuất hiện của ký tự ch trong xâu ký tự đó.
        System.out.println("count string: " + string2 + " in string: " + string1 + "\ncount = " + (string1.length() - string1.replaceAll(string2, "").length()) / string2.length());
    }

    public static void bai2(String string) {
        //Nhập và họ tên một người. Cho biết người đó có phải họ Tran không?
        System.out.println("last name of " + string + " is: " + string.split(" ")[0]);
    }

    public static void bai3(String string) {
        //Nhập vào một xâu. Tạo ra xâu đảo ngược với xâu đã nhập.
        System.out.println(new StringBuilder(string).reverse().toString());
    }

    public static void bai4(String string) {
        //Cho biết đường dẫn đầy đủ của một tập tin trên mạng là một xâu có dạng: “/home/user/filename.php”. Hãy viết chương trình hiển thị ra màn hình tên, phần mở rộng và đường dẫn tập tin.
        System.out.println("locate: " + string.replace(string.split("/")[string.split("/").length - 1], "") + "\nfile name: " + string.split("/")[string.split("/").length - 1].split("\\.")[0] + "\nfile extension: " + string.split("/")[string.split("/").length - 1].split("\\.")[1]);
    }

    public static void bai5(String string) {
        //Viết chương trình lấy ký tự đầu của mỗi từ trong họ tên (được nhập từ bàn phím) và in chuỗi tìm được ra màn hình.
        for (int i = 0; i < string.split(" ").length; i++) {
            System.out.print(string.split(" ")[i].charAt(0) + " ");
        }
    }

    public static void bai6(String string) {
        //Nhập vào một xâu. Đếm xem trong xâu có bao nhiêu ký tự chữ cái, bao nhiêu ký tự chữ số và bao nhiêu từ (các từ ngăn cách với nhau bởi khoảng trắng).
        System.out.println("count numbers= " + string.replaceAll("\\D", "").length() + "\ncount letters=" + (string.replace(" ", "").length() - string.replaceAll("\\D", "").length()) + "\ncount words= " + string.split(" ").length);
    }

    public static void bai7(String string) {
        //Nhập vào một xâu. Loại bỏ tất cả các khoảng trắng dư thừa trong xâu.
        while (!string.replace("  ", " ").equals(string)) {
            string = string.replace("  ", " ");
        }
        System.out.println(string);
    }

    public static void bai8(String string) {
        //Nhập một xâu từ bàn phím. Hãy xóa tất cả các nguyên âm trong xâu.
        System.out.println(string.replace("-"," "));

    }

    public static void bai9(String string) {
        //Nhập vào một số điện thoại theo định dạng (091) 022-6758080. In ra màn hình mã Quốc gia (091), mã vùng (022) và số điện thoại (6758080)
        System.out.println("country code: " + string.split(" ")[0] + "\nprovince code: (" + string.split(" ")[1].split("-")[0] + ") \nphone: (" + string.split(" ")[1].split("-")[1] + ")");
    }

    public static void bai10(String string) {
        //Nhập một xâu từ bàn phím. Hãy tạo ra một xâu có các từ đối xứng với xâu vừa nhập. Ví dụ: Nhập: “ Nha Trang Khanh Hoa”. In ra: “Hoa Khanh Trang Nha”
        for (int i = string.split(" ").length - 1; i > -1; i--) {
            System.out.print(string.split(" ")[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("\nbai1 :");;
        ExcerciseSecondWeek.bai1("Viet Nam Cong Hoa To Quoc Danh Du Trach Nhiem", "ie");
        System.out.println("\nbai2 :");;
        ExcerciseSecondWeek.bai2("Tran Nhu Nhong");
        System.out.println("\nbai3 :");;
        ExcerciseSecondWeek.bai3("Viet Nam Cong Hoa To Quoc Danh Du Trach Nhiem");
        System.out.println("\nbai4 :");;
        ExcerciseSecondWeek.bai4("/home/user/filename.php");
        System.out.println("\nbai5 :");;
        ExcerciseSecondWeek.bai5("Viet Nam Cong Hoa To Quoc Danh Du Trach Nhiem");
        System.out.println("\nbai6 :");;
        ExcerciseSecondWeek.bai6("Viet Nam Cong Hoa To Quoc Danh Du Trach Nhiem");
        System.out.println("\nbai7 :");;
        ExcerciseSecondWeek.bai7("   Viet   Nam   Cong  Hoa    To Quoc    Danh    Du Trach    Nhiem");
        System.out.println("\nbai8 :");;
        ExcerciseSecondWeek.bai8("-1 2 ac a -2 -s-2-3-40");
        System.out.println("\nbai9 :");;
        ExcerciseSecondWeek.bai9("(091) 022-6758080");
        System.out.println("\nbai10 :");;
        ExcerciseSecondWeek.bai10("Viet Nam Cong Hoa To Quoc Danh Du Trach Nhiem");
    }
}
