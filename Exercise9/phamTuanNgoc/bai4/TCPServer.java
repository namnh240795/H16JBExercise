package excercise9.phamTuanNgoc.bai4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 19/10/2016.
 */
public class TCPServer {
    Socket socket;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;

    public void send(String str) {
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        String str = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void close() {
        try {
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TCPServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            int i = 1;
            String str = receive();
            boolean boo = (str == null || str.trim().isEmpty());
            while (!boo) {
                this.send(Double.toString(caculator(str)));
                str = receive();
                boo = (str == null);
            }
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double caculator(String str){
        String[] strArr = str.split(" ");
        List<String> strLst = new ArrayList<>();
        for (String string: strArr) {
            if(!string.equals(""))
                strLst.add(string);
        }
        strArr = strLst.toArray(new String[3]);
        switch (strArr[0]){
            case "+": return Double.parseDouble(strArr[1]) + Double.parseDouble(strArr[2]);
            case "-": return Double.parseDouble(strArr[1]) - Double.parseDouble(strArr[2]);
            case "*": return Double.parseDouble(strArr[1]) * Double.parseDouble(strArr[2]);
            case "/": return Double.parseDouble(strArr[1]) / Double.parseDouble(strArr[2]);
            default: return 0;
        }
    }

    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer();
    }
}
