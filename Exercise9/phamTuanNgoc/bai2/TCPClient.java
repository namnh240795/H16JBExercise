package excercise9.phamTuanNgoc.bai2;

import java.io.*;
import java.net.Socket;

/**
 * Created by panda on 17/10/2016.
 */
public class TCPClient {
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    public TCPClient() {
        try {
            socket = new Socket("localhost",8080);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sent(String str){
        try {

            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Client sent!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive(){
        try {
            String str = bufferedReader.readLine();
            System.out.println(str);
            System.out.println("Client receive!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            System.out.println("close Client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPClient client = new TCPClient();
        client.sent("Message From Client!");
        client.receive();
        client.close();
    }
}
