import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by panda on 28/09/2016.
 */
public class IOExcercise {
    //    Bài 1. Viết chương trình tạo tập tin nhị phân có tên bai1.dat (tạo mới nếu tập tin chưa tồn tại). Ghi
    //    100 số nguyên được tạo ngẫu nhiên vào tập tin trên.
    public static void bai1() {
        Random random = new Random();
        byte[] bytes = new byte[100];
        for (int i = 0; i < 100; i++) {
            bytes[i] = (byte) random.nextInt();
        }
        Path path = Paths.get("bai1.dat");
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Bài 2. Viết chương trình đọc các dòng ký tự từ một file text và ghi mỗi dòng được mã hóa dạng UTF
    //    vào file nhị phân. Hiển thị kích thước của file text và file nhị phân. Sử dụng dòng lệnh để chạy
    //    chương trình theo dạng: java Bai3 Welcome.java Welcome.utf
    public static void bai2() {
        String str, string = "";
        try {
            FileReader fr = new FileReader(new File("nhanvien.txt"));
            BufferedReader br = new BufferedReader(fr);

            while ((str = br.readLine()) != null)
                string = string + str;
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = string.getBytes(Charset.forName("UTF-8"));
        Path path = Paths.get("bai2.txt");
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    Bài 3. Viết chương trình ghi một mảng 5 số nguyên là 1, 2, 3, 4, 5, một đối tượng Date chứa thời gian
    //    hiện tại và một số thực 5.5 vào tập tin bai3.dat.
    public static void bai3() {
        int[] ints = {1, 2, 3, 4, 5};
        Date date = new Date();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("bai3.dat", true));
            objectOutputStream.writeObject(ints);
            objectOutputStream.writeObject(date);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    Bài 4. Tạo lớp NhanVien có các thuộc tính mã nhân viên, họ tên, tuổi và lương.
    //    - Viết setter, getter, constructor và toString.
    //    - Viết phương thức cho phép nhập thông tin cho 3 nhân viên từ bàn phím. Sử dụng FileWriter
    //    để ghi thông tin vào nhanvien.txt.
    //    - Viết phương thức để đọc nội dung file nhanvien.txt và in những gì đọc được từ file ra màn
    //    hình.
    public static void bai4() {
        String str = "";
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("Id of Employee " + i + ": ");
            str = str + " Employee " + i + "\tID: " + sc.nextLine() + "\t";
            System.out.print("Name of Employee " + i + ": ");
            str = str + " Name: " + sc.nextLine() + "\t";
            System.out.print("Age of Employee " + i + ": ");
            str = str + " Age: " + sc.nextLine() + "\t";
            System.out.print("Salary of Employee: " + i + ": ");
            str = str + " Salary: " + sc.nextLine() + "\n";
        }
        try {
            FileWriter fw = new FileWriter(new File("nhanvien.txt"));
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader(new File("nhanvien.txt"));
            BufferedReader br = new BufferedReader(fr);
            String string;
            while ((string = br.readLine()) != null)
                System.out.println(string);
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    Bài 5. NhanVien có các thuộc tính mã nhân viên, họ tên, tuổi và lương và thực hiện các xử lý sau
    //    - Viết phương thức tạo mảng 3 nhân viên, nhập thông tin cho các nhân viên, sử dụng
    //    ObjectOutputStream để ghi mảng đối tượng nhân viên vào file nhanvien.dat
    //    - Viết phương thức để đọc file nhanvien.dat và in mảng nhân viên ra màn hình.
    //    - Viết chương trình đọc tập tin nhanvien.dat và hiển thị ra màn hình các thông tin: nhân viên
    //    có mã NV lớn nhất; tổng lương của các nhân viên trong tập tin.

    public static void bai5() {
        Employee[] employees = {new Employee(1, "Emp1", 21, 21000000), new Employee(2, "Emp3", 22, 22000000), new Employee(3, "Emp3", 23, 23000000)};
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("nhanvien.dat", true));
            objectOutputStream.writeObject(employees);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("nhanvien.dat"));
            Employee[] employees1 = (Employee[]) objectInputStream.readObject();
            Employee employee1 = employees1[0];
            float sum = 0;
            for (Employee employee : employees1) {
                System.out.println(employee.getId() + "  " + employee.getName() + "  " + employee.getAge() + "  " + employee.getSalary());
                if (employee.getId() > employee1.getId())
                    employee1 = employee;
                sum = sum + employee.getSalary();
            }
            System.out.println("highest Id of Employee: " + employee1.getId() + "  Sum of salary: " + sum);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOExcercise.bai1();
        IOExcercise.bai2();
        IOExcercise.bai3();
        IOExcercise.bai4();
        IOExcercise.bai5();

    }

}


class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    private float salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}