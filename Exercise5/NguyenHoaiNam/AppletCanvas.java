package Exercise5.NguyenHoaiNam;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Nam on 10/4/2016.
 */
public class AppletCanvas extends JApplet{

    ScrollPane scrollPane;
    mycanvas mycanvas;

    public AppletCanvas() {

        scrollPane = new ScrollPane();
        mycanvas = new mycanvas();
        scrollPane.add(mycanvas);
        scrollPane.setSize(600,600);
       add(scrollPane);
       setSize(400,400);
    }
    public class mycanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.red);
            g.drawOval(5, 10, 200, 200);

            g.setColor(Color.green);
            g.fillOval(20, 200, 100, 100);
        }
    }
}
