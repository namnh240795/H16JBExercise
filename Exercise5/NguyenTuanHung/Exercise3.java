/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiAwt;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Exercise3 extends JFrame{
    public static void main(String[] args) {
        Exercise3 ex3 = new Exercise3();
    }
    public Exercise3(){
        JFrame frame = new JFrame();
        for (int i = 15; i > 0; i--) {
            JButton jbt = new JButton(String.valueOf(i));
            frame.add(jbt);
        }
        frame.setLayout(new GridLayout(4, 4));
        
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
   }
}
