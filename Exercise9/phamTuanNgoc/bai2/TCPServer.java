package excercise9.phamTuanNgoc.bai2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by panda on 17/10/2016.
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
            System.out.println("server send");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean receive(){
        String str = null;
        try {

             str = bufferedReader.readLine();
            System.out.println(str);
            System.out.println("Server receive");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.isEmpty();
    }

    public void close(){
        try {
            bufferedReader.close();
            bufferedWriter.close();
            serverSocket.close();
            socket.close();
            System.out.println("close server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TCPServer() {
        try {
            System.out.println("cho client ket noi");
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("ket noi thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer();
        if (!tcpServer.receive()) {
            System.out.println("receive server");
            tcpServer.Send("Message From Server!");
        }
        tcpServer.close();
    }
}
