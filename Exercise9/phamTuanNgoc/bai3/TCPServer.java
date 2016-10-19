package excercise9.phamTuanNgoc.bai3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by panda on 18/10/2016.
 */
public class TCPServer {
    ServerSocket serverSocket;
    Socket socket;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;

    public void Send(String str){
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive(){
        String str = null;
        try {
            str = bufferedReader.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void close(){
        try {
            bufferedReader.close();
            bufferedWriter.close();
            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TCPServer() {
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convert(char i){
        switch (i){
            case '1': return "Một";
            case '2': return "Hai";
            case '3': return "Ba";
            case '4': return "Bốn";
            case '5': return "Năm";
            case '6': return "Sáu";
            case '7': return "Bảy";
            case '8': return "Tám";
            case '9': return "Chín";
            case '0': return "Mười";
            default: return "NAN";
        }
    }

    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer();
        tcpServer.Send(tcpServer.convert(tcpServer.receive().charAt(0)));
    }
}
