package excercise9.phamTuanNgoc.bai1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by panda on 17/10/2016.
 */
public class TCPServer {
    public static void main(String[] args) {
        Date date = new Date();
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("sent :"+ date);
            printWriter.print(date);
            printWriter.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
