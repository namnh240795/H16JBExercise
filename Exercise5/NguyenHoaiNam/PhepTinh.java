package Exercise5.NguyenHoaiNam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nam on 10/3/2016.
 */
public class PhepTinh {
    private JButton buttonPlus;
    private JButton buttonSub;
    private JButton buttonMul;
    private JButton buttonDiv;
    private JTextField xField;
    private JTextField yField;
    private JTextField kqField;
    private JPanel panel;

    public PhepTinh() {

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buttonPlus){
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    int kq = x+y;
                    kqField.setText(String.valueOf(kq));
                }
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buttonSub){
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    int kq = x-y;
                    kqField.setText(String.valueOf(kq));
                }
            }
        });
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buttonMul){
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    int kq = x*y;
                    kqField.setText(String.valueOf(kq));
                }
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buttonDiv){
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    double kq = x/y;
                    kqField.setText(String.valueOf(kq));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("12345");
        frame.setContentPane(new PhepTinh().panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
