package Exercise5.NguyenHoaiNam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nam on 10/3/2016.
 */
public class ColorChange {
    private JRadioButton red;
    private JRadioButton blue;
    private JRadioButton green;
    private JRadioButton yellow;
    private JPanel panelTo;
    private JPanel panelNho;
    private JLabel label;

    public ColorChange() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blue){
                    label.setText("Màu xanh dương");
                    panelNho.setBackground(Color.blue);
                }
                if (e.getSource() == green){
                    label.setText("Màu xanh lá");
                    panelNho.setBackground(Color.green);
                }
                if (e.getSource() == yellow){
                    label.setText("Màu vàng");
                    panelNho.setBackground(Color.yellow);
                }
                if (e.getSource() == red){
                    label.setText("Màu đỏ");
                    panelNho.setBackground(Color.red);
                }
            }
        };
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(red);
        buttonGroup.add(blue);
        buttonGroup.add(green);
        buttonGroup.add(yellow);
        red.addActionListener(listener);
        blue.addActionListener(listener);
        green.addActionListener(listener);
        yellow.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("12345");
        frame.setContentPane(new ColorChange().panelTo);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
