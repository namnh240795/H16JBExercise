package excercise9.phamTuanNgoc.bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by panda on 17/10/2016.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while ((str =bufferedReader.readLine())!=null)
                System.out.println(str);
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
