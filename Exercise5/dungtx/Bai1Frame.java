package Lesson05;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by Dzung on 10/7/2016.
 */
public class Bai1Frame extends Frame {
    private Label lblX;
    private Label lblY;
    private Label lblResult;
    private TextField txtX;
    private TextField txtY;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMulti;
    private Button btnDivi;
    private Panel pnlInput;
    private Panel pnlButtons;
    private Panel pnlResult;

    public Bai1Frame() throws HeadlessException {
        init();
        handle();
    }

    public Bai1Frame(String title) throws HeadlessException {
        super(title);
        init();
    }

    private void init(){
        lblX = new Label("x = ");
        lblX.setAlignment(Label.LEFT);
        lblY = new Label("y = ");
        lblY.setAlignment(Label.LEFT);
        lblResult = new Label("test");
        lblResult.setAlignment(Label.CENTER);
        txtX = new TextField();
        txtY = new TextField();
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("*");
        btnDivi = new Button("/");
        this.setSize(400,200);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        pnlInput = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.ipadx = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlInput.add(lblX,gbc);
        gbc.ipadx = 300;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pnlInput.add(txtX,gbc);
        gbc.ipadx = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlInput.add(lblY,gbc);
        gbc.ipadx = 300;
        gbc.gridx = 1;
        gbc.gridy = 1;
        pnlInput.add(txtY,gbc);

        pnlButtons = new Panel(new GridLayout(1,4));
        pnlButtons.add(btnPlus);
        pnlButtons.add(btnMinus);
        pnlButtons.add(btnMulti);
        pnlButtons.add(btnDivi);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(pnlInput,gbc);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(pnlButtons,gbc);

        gbc.ipadx = 300;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(lblResult,gbc);
    }

    private void handle(){
        Dialog dialog = new Dialog(this,"Wrong format");
        Label lblDialog = new Label("You have input not a number");
        Button btnDialog = new Button("OK");
        btnDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setSize(200,100);
        dialog.setLayout(new GridLayout(2,1));
        dialog.add(lblDialog);
        dialog.add(btnDialog);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        txtX.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Float.parseFloat(txtX.getText().trim());
                }catch(NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });

        txtY.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Float.parseFloat(txtY.getText().trim());
                }catch(NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float x = Float.parseFloat(txtX.getText().trim());
                    float y = Float.parseFloat(txtY.getText().trim());
                    lblResult.setText((x+y) + "");
                }catch (NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });
        
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float x = Float.parseFloat(txtX.getText().trim());
                    float y = Float.parseFloat(txtY.getText().trim());
                    lblResult.setText((x-y) + "");
                }catch (NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });
        
        btnMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float x = Float.parseFloat(txtX.getText().trim());
                    float y = Float.parseFloat(txtY.getText().trim());
                    lblResult.setText((x*y) + "");
                }catch (NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });
        
        btnDivi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float x = Float.parseFloat(txtX.getText().trim());
                    float y = Float.parseFloat(txtY.getText().trim());
                    if(x!= 0 && y != 0) {
                        lblResult.setText((x / y) + "");
                    }else{
                        lblDialog.setText("You tried to division 0");
                        dialog.setVisible(true);
                    }
                }catch (NumberFormatException ex){
                    lblDialog.setText("You have input not a number");
                    dialog.setVisible(true);
                }
            }
        });
    }
}

