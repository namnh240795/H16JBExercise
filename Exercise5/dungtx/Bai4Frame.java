package Lesson05;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Dzung on 10/9/2016.
 */
public class Bai4Frame extends Frame {
    public Bai4Frame(){
        init();
    }

    public void init(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pnlScroll = new ScrollPane();
        pnlScroll.setSize(400,400);
        MyCanvas canvas = new MyCanvas();
        canvas.setSize(700,700);
        pnlScroll.add(canvas);

        this.add(pnlScroll);
        this.setVisible(true);
    }
    

    private ScrollPane pnlScroll;

    private class MyCanvas extends Canvas{
        public MyCanvas() {
        }

        @Override
        public void paint(Graphics g){
            g.setColor(Color.red);
            g.drawOval(5, 10, 200, 200);

            g.setColor(Color.green);
            g.fillOval(20, 200, 100, 100);

            g.setColor(Color.black);
            g.drawOval(450,500,50,50);

            g.setColor(Color.blue);
            g.fillOval(450,100,300,300);
        }
    }
}
