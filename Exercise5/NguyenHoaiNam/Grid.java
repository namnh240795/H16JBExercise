package Exercise5.NguyenHoaiNam;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nam on 10/5/2016.
 */
public class Grid {
    public static void main(String[] args) {
        JFrame frame = new JFrame("123");
        frame.setLayout(new GridLayout(4,4));
        for (int i = 0; i<=15 ; i++){
            JButton button = new JButton(""+i);
            frame.add(button);
        }
        frame.setSize(400,400);
        frame.pack();
        frame.setVisible(true);


    }
}
