package Lesson05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Dzung on 10/9/2016.
 */
public class Bai5Frame {
    public Bai5Frame(){
        frame = new JFrame();
        init();
        handle();
    }

    public void init(){
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLayout(new BorderLayout());
        lblHeader = new Label("Giai phuong trinh bac 2");
        lblHeader.setBackground(Color.GRAY);
        frame.add(lblHeader,BorderLayout.NORTH);

        pnlInput = new JPanel();
        pnlInput.setBorder(BorderFactory.createTitledBorder("Nhập a,b,c"));
        pnlInput.setLayout(new BorderLayout());
        lblA = new Label("a: ");
        lblB = new Label("b: ");
        lblC = new Label("c: ");
        txtA = new TextField();
        txtB = new TextField();
        txtC = new TextField();
        lblResult = new Label("Kết quả:");
        txtX1 = new TextField();
        txtX1.setEditable(false);
        txtX2 = new TextField();
        txtX2.setEditable(false);
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel pnlInput = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlInput.add(lblA,gbc);
        gbc.gridx = 1;
        gbc.ipadx = 150;
        pnlInput.add(txtA,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        pnlInput.add(lblB,gbc);
        gbc.gridx = 1;
        gbc.ipadx = 150;
        pnlInput.add(txtB,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        pnlInput.add(lblC,gbc);
        gbc.gridx = 1;
        gbc.ipadx = 150;
        pnlInput.add(txtC,gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.ipadx = 0;
        pnlInput.add(lblResult,gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipadx = 150;
        pnlInput.add(txtX1,gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.ipadx = 150;
        pnlInput.add(txtX2,gbc);

        this.pnlInput.add(pnlInput,BorderLayout.CENTER);
        frame.add(this.pnlInput,BorderLayout.CENTER);

        pnlBtns = new JPanel();
        pnlBtns.setBorder(BorderFactory.createTitledBorder("Chọn thao tác"));
        pnlBtns.setLayout(new BorderLayout());
        JPanel pnl = new JPanel(new GridBagLayout());
        btnCalc = new Button("Giải");
        btnReset = new Button("Xoá trắng");
        btnExit = new Button("Thoát");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnl.add(btnCalc,gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        pnl.add(btnReset,gbc);
        gbc.gridx = 3;
        pnl.add(btnExit,gbc);
        pnlBtns.add(pnl,BorderLayout.CENTER);
        frame.add(pnlBtns,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void handle(){
        
        txtA.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try{
                    Float.parseFloat(txtA.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Xin nhap so","Nhap sai",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtB.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try{
                    Float.parseFloat(txtB.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Xin nhap so","Nhap sai",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtC.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try{
                    Float.parseFloat(txtC.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Xin nhap so","Nhap sai",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float a = Float.parseFloat(txtA.getText());
                    float b = Float.parseFloat(txtB.getText());
                    float c = Float.parseFloat(txtC.getText());
                    calculate(a, b, c);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Xin nhap so","Nhap sai",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtA.setText("");
                txtB.setText("");
                txtC.setText("");
                txtX1.setText("");
                txtX2.setText("");
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculate(float a,float b, float c){
        float delta = (b*b)-(4*a*c);
        float x1, x2;

        if (delta<0){
            txtX1.setText("Phuong trinh vo nghiem");
        }else if(delta == 0){
            x1 =(float) (-b + Math.sqrt(delta))/(2*a);
            txtX1.setText("Phuong trinh co 1 nghiem");
            txtX2.setText(String.valueOf(x1));
        }else{
            x1 = (float) (-b + Math.sqrt(delta))/(2*a);
            x2 = (float) (-b - Math.sqrt(delta))/(2*a);
            txtX1.setText(String.valueOf(x1));
            txtX2.setText(String.valueOf(x2));
        }
    }

    private JFrame frame;
    private JPanel pnlInput;
    private JPanel pnlBtns;
    private Label lblHeader;
    private Label lblA;
    private Label lblB;
    private Label lblC;
    private Label lblResult;
    private TextField txtA;
    private TextField txtB;
    private TextField txtC;
    private TextField txtX1;
    private TextField txtX2;
    private Button btnCalc;
    private Button btnReset;
    private Button btnExit;
}
