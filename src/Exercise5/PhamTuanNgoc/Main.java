package PhamTuanNgoc;


import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

/**
 * Created by panda on 06/10/2016.
 */
public class Main {

    public static void bai1() {
        Frame frame = new Frame("Bai 1");
        frame.setLayout(new FlowLayout());
        Label lbX = new Label("X="), lbY = new Label("Y="), lbResult = new Label("Result Here");
        TextField tfX = new TextField(20), tfY = new TextField(20);
        Button btnaddi = new Button("+"), btnsubtrac = new Button("-"), btnmultiplica = new Button("*"), btnDivi = new Button(":");

        lbResult.setSize(200, 10);
        btnaddi.setPreferredSize(new Dimension(50, 30));
        btnsubtrac.setPreferredSize(new Dimension(50, 30));
        btnmultiplica.setPreferredSize(new Dimension(50, 30));
        btnDivi.setPreferredSize(new Dimension(50, 30));

        frame.add(lbX);
        frame.add(tfX);
        frame.add(lbY);
        frame.add(tfY);
        frame.add(btnaddi);
        frame.add(btnsubtrac);
        frame.add(btnmultiplica);
        frame.add(btnDivi);
        frame.add(lbResult);

        frame.setSize(230, 180);
        frame.setLocationRelativeTo(null);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setVisible(true);


        btnaddi.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    lbResult.setText("X+Y=" + Float.toString(Float.parseFloat(tfX.getText()) + Float.parseFloat(tfY.getText())));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "something wrong!", "Inane warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnsubtrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lbResult.setText("X - Y = " + Float.toString(Float.parseFloat(tfX.getText()) - Float.parseFloat(tfY.getText())));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "something wrong!", "Inane warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnmultiplica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lbResult.setText("X * Y = " + Float.toString(Float.parseFloat(tfX.getText()) * Float.parseFloat(tfY.getText())));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "something wrong!", "Inane warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnDivi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lbResult.setText("X : Y = " + Float.toString(Float.parseFloat(tfX.getText()) / Float.parseFloat(tfY.getText())));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "something wrong!", "Inane warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void bai2() {
        Frame frame = new Frame("bai2");
        frame.setLayout(new FlowLayout());
        CheckboxGroup cbGr = new CheckboxGroup();
        Checkbox cbRed = new Checkbox(" reb ", cbGr, true), cbBlue = new Checkbox(" blue ", cbGr, true), cbGreen = new Checkbox(" green ", cbGr, true), cbBlack = new Checkbox(" black ", cbGr, true);
        Label lbResult = new Label(" Color? ", Label.CENTER);

        frame.add(cbRed);
        frame.add(cbBlue);
        frame.add(cbGreen);
        frame.add(cbBlack);
        frame.add(lbResult);

        frame.setSize(150, 120);
        frame.setLocationRelativeTo(null);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setVisible(true);

        cbRed.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lbResult.setBackground(changeColorEx2(cbRed, cbBlue, cbGreen, cbBlack));
                lbResult.setText(changeTextEx2(cbRed, cbBlue, cbGreen, cbBlack));
            }
        });
        cbBlue.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lbResult.setBackground(changeColorEx2(cbRed, cbBlue, cbGreen, cbBlack));
                lbResult.setText(changeTextEx2(cbRed, cbBlue, cbGreen, cbBlack));
            }
        });
        cbGreen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lbResult.setBackground(changeColorEx2(cbRed, cbBlue, cbGreen, cbBlack));
                lbResult.setText(changeTextEx2(cbRed, cbBlue, cbGreen, cbBlack));
            }
        });
        cbBlack.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lbResult.setBackground(changeColorEx2(cbRed, cbBlue, cbGreen, cbBlack));
                lbResult.setText(changeTextEx2(cbRed, cbBlue, cbGreen, cbBlack));
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private static Color changeColorEx2(Checkbox cbReb, Checkbox cbBlue, Checkbox cbGreen, Checkbox cbBlack) {
        if (cbReb.getState()) {
            return Color.RED;
        }
        if (cbBlue.getState()) {
            return Color.BLUE;
        }
        if (cbGreen.getState()) {
            return Color.GREEN;
        }
        if (cbBlack.getState()) {
            return Color.BLACK;
        }
        return null;
    }

    private static String changeTextEx2(Checkbox cbReb, Checkbox cbBlue, Checkbox cbGreen, Checkbox cbBlack) {
        if (cbReb.getState()) {
            return "red";
        }
        if (cbBlue.getState()) {
            return "blue";
        }
        if (cbGreen.getState()) {
            return "green";
        }
        if (cbBlack.getState()) {
            return "black";
        }
        return null;
    }

    public static void bai3() {
        Frame frame = new Frame("Bai3");
        frame.setLayout(new FlowLayout());
        Button[] btn = new Button[16];
        for (int i = 15; i > -1; i--) {
            btn[i] = new Button(Integer.toString(i));
            btn[i].setPreferredSize(new Dimension(75, 75));
            frame.add(btn[i]);
        }

        frame.setSize(325, 350);
        frame.setLocationRelativeTo(null);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void bai4() {
        JFrame frame = new JFrame("bai4");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setResizable(false);
        Panel panel = new Panel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.GREEN);
                g.fillOval(300, 100, 200, 200);
                g.setColor(Color.RED);
                g.fillOval(100, 200, 150, 200);
                g.setColor(Color.blue);
                g.fillRect(200, 300, 200, 200);
            }
        };
        panel.setSize(600, 600);
        panel.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane,null);
        frame.setVisible(true);
    }


    public static void bai5() {
        JFrame frame = new JFrame("bai5");
        Panel panelMain = new Panel();
        panelMain.setLayout(null);

        Label lbHead = new Label("Giải Phương Trinh Bậc 2");
        lbHead.setAlignment(Label.CENTER);
        lbHead.setBounds(0, 0, 400, 40);
        Font font = new Font("Arial", Font.BOLD, 18);
        lbHead.setFont(font);
        lbHead.setBackground(Color.LIGHT_GRAY);
        panelMain.add(lbHead);

        JPanel panelInput = new JPanel();
        panelInput.setBounds(0, 40, 398, 200);
        panelInput.setLayout(null);
        panelInput.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), " Nhập a,b,c "));
        Label labelA = new Label("a:"), labelB = new Label("b:"), labelC = new Label("c:"), labelResult = new Label("Ket Qua");
        TextField tfA = new TextField("0"), tfB = new TextField("0"), tfC = new TextField("0"), tfResult = new TextField();
        font = new Font("Arial", Font.ITALIC, 15);
        labelA.setBounds(100, 33, 15, 12);
        labelA.setFont(font);
        labelB.setBounds(100, 64, 15, 12);
        labelB.setFont(font);
        labelC.setBounds(100, 95, 15, 12);
        labelC.setFont(font);
        labelResult.setBounds(160, 120, 70, 20);
        labelResult.setFont(font);
        tfA.setBounds(120, 30, 150, 20);
        tfB.setBounds(120, 60, 150, 20);
        tfC.setBounds(120, 90, 150, 20);
        tfResult.setBounds(100, 150, 190, 20);
        panelInput.add(labelA);
        panelInput.add(labelB);
        panelInput.add(labelC);
        panelInput.add(labelResult);
        panelInput.add(tfA);
        panelInput.add(tfB);
        panelInput.add(tfC);
        panelInput.add(tfResult);
        panelMain.add(panelInput);

        JPanel panelOption = new JPanel();
        panelOption.setBounds(0, 240, 398, 65);
        panelOption.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.MAGENTA), " Chọn thao tác "));
        Button btnAns = new Button("Giải"), btnClear = new Button("Xóa trắng"), btnExit = new Button("Thoát");
        font = new Font("Arial", Font.BOLD, 15);
        btnAns.setFont(font);
        btnClear.setFont(font);
        btnExit.setFont(font);

        panelOption.add(btnAns);
        panelOption.add(btnClear);
        panelOption.add(btnExit);
        panelMain.add(panelOption);

        frame.getContentPane().add(panelMain);
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 332);
        frame.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfA.setText("0");
                tfB.setText("0");
                tfC.setText("0");
            }
        });

        btnAns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfResult.setText(ptb2(Double.parseDouble(tfA.getText()), Double.parseDouble(tfB.getText()), Double.parseDouble(tfC.getText())));
            }
        });
    }

    public static String ptb2(double a, double b, double c) {
        double x1, x2;
        double delta;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "Phuong trinh vo so nghiem ";
                } else {
                    return "Phuong trinh vo nghiem ";
                }
            } else {
                x1 = (-c) / b;
                return "Phuong trinh co nghiem duy nhat : " + x1;
            }
        } else {
            delta = (b * b) - (4 * a * c);
            if (delta < 0) {
                return "Phuong trinh vo nghiem";
            }
            if (delta == 0) {
                x1 = -b / (2 * a);
                return "Phuong trinh co nghiem duy nhat: " + x1;
            }
            if (delta > 0) {
                x1 = (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return "Phuong trinh co 2 nghiem X1 = " + x1 + ", X2 =" + x2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        Main.bai1();
//        Main.bai2();
//        Main.bai3();
        Main.bai4();
//        Main.bai5();
    }


}
