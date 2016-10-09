package Lesson04;

import java.io.*;

/**
 * Created by Dzung on 10/2/2016.
 */
public class welcome {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("welcome.utf"));
            while(reader.ready()) {
                String input = reader.readLine();
                if(input.matches("\\A\\p{ASCII}*\\z")){
                    writer.append(input);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
