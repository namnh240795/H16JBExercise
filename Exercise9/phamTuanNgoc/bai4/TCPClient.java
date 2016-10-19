package excercise9.phamTuanNgoc.bai4;

import java.io.*;
import java.net.Socket;

/**
 * Created by panda on 19/10/2016.
 */
public class TCPClient {
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    public void sent(String str){
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive(){
        try {
            String str = bufferedReader.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TCPClient() {
        try {
            socket = new Socket("localhost",8080);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPClient tcpClient = new TCPClient();
        tcpClient.sent("+  2  3");
        tcpClient.receive();
        tcpClient.sent("-  2  3");
        tcpClient.receive();
        tcpClient.sent("*  2  3");
        tcpClient.receive();
        tcpClient.sent("/  2  3");
        tcpClient.receive();
        tcpClient.close();
    }
}
