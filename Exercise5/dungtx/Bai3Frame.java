package Lesson05;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Dzung on 10/9/2016.
 */
public class Bai3Frame extends Frame {
    public Bai3Frame() {
        init();
    }

    public void init(){
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        Panel pnl =  new Panel(new GridLayout(4,4));
        for (int i = 15; i > 0; i--) {
            pnl.add(new Button(String.valueOf(i)));
        }
        pnl.add(new Label(" "));
        this.add(pnl);
    }


}
