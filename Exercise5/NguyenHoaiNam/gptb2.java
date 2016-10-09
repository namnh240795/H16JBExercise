package Exercise5.NguyenHoaiNam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nam on 10/5/2016.
 */
public class gptb2 extends JPanel{
    private JPanel panel1,panel2;
    private JLabel label1,label2,label3,label4,label5;
    private JTextField textField1,textField2,textField3,textField4;
    private JButton giai,xoatrang,thoat;
    public gptb2(){
        setLayout(new GridLayout(3,1));
        label1 = new JLabel("GPTB2");
        panel1= new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder("Nhap a.b.c: "));
        panel1.setLayout(new GridLayout(4,2));

        label2 = new JLabel("a: ");
        label3 = new JLabel("b: ");
        label4 = new JLabel("c: ");
        label5 = new JLabel("Kq: ");

        textField1 = new JTextField(15);
        textField2 = new JTextField(15);
        textField3 = new JTextField(15);
        textField4 = new JTextField(15);
        textField4.setEditable(false);

        panel1.add(label2);
        panel1.add(textField1);
        panel1.add(label3);
        panel1.add(textField2);
        panel1.add(label4);
        panel1.add(textField3);
        panel1.add(label5);
        panel1.add(textField4);

        ButtonListenter buttonListenter = new ButtonListenter();

        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Chon action: "));
        giai = new JButton("Giai");
        giai.addActionListener(buttonListenter);
        xoatrang = new JButton("Xoa trang");
        xoatrang.addActionListener(buttonListenter);
        thoat = new JButton("thoat");
        thoat.addActionListener(buttonListenter);
        panel2.setLayout(new GridLayout(1,3));
        panel2.add(giai);
        panel2.add(xoatrang);
        panel2.add(thoat);
        add(label1);
        add(panel1);
        add(panel2);

        setBackground(Color.gray);
    }

    public static void main(String[] args) {
        gptb2 p = new gptb2();
        JFrame frame = new JFrame("123");
        frame.setContentPane(p);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
    }
    private class ButtonListenter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == giai){
                if(textField1.getText().equals("") ||
                        textField2.getText().equals("") ||
                        textField3.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null,"All field must be filled");
                }else {
                    int a,b,c;
                    a = Integer.parseInt(textField1.getText());
                    b = Integer.parseInt(textField2.getText());
                    c = Integer.parseInt(textField3.getText());

                    double delta;
                    delta = b*b - 4*a*c;
                    if(delta<0){
                        textField4.setText("vo nghiem");
                    }else if(delta == 0){
                        textField4.setText("co 1 nghiem" + (-b/2*a));
                    }else{
                        textField4.setText("x1 = " + (-b+Math.sqrt(delta))/(2*a)
                                + " x2 = " + (-b-Math.sqrt(delta))/(2*a));}

                }
            }
            if(e.getSource() == xoatrang){
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
            if(e.getSource() == thoat){
                System.exit(0);
            }
        }
    }

}
