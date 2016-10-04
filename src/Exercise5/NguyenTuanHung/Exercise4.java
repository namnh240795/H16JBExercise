/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiAwt;

import java.awt.*;
import javafx.geometry.Orientation;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.ScrollBar;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Exercise4 extends JApplet {
    ScorllPaint sp;
  
    @Override
    public void init() {
        sp = new ScorllPaint();
        add(sp);
        
    }
    public Exercise4(){
    }
    
    @Override
    public void paint(Graphics g){
        Exercise4 applets = new Exercise4();
    }

    // TODO overwrite start(), stop() and destroy() methods
}


class myCanva extends Canvas{
    private Orientation VerticalDirection;
    public myCanva(){
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawOval(5, 10, 200, 200);
        g.fillOval(5, 10, 200, 200);
        
        g.setColor(Color.green);
        g.drawOval(20, 200, 100, 100);
        g.fillOval(20, 200, 100, 100);
    }
}
class ScorllPaint extends ScrollPane{
    public ScorllPaint(){
        myCanva mc = new myCanva();
        add(mc);
    }
}

