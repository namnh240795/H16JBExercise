package Lesson05;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Dzung on 10/9/2016.
 */
public class Bai2Frame extends Frame {
    public Bai2Frame(){
        init();
        handle();
    }

    public void init(){
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        lblBlack = new Label("Black");
        lblBlue = new Label("Blue");
        lblGreen = new Label("Green");
        lblRed = new Label("Red");
        lblResult = new Label("Red selected");
        ckbgrp = new CheckboxGroup();
        ckbRed = new Checkbox("Red",ckbgrp,true);
        ckbBlue = new Checkbox("Blue",ckbgrp,true);
        ckbGreen = new Checkbox("Green",ckbgrp,true);
        ckbBlack = new Checkbox("Black", ckbgrp,true);

        this.setLayout(new GridLayout(5,1));

        Panel pnlRed = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnlRed.add(ckbRed);
        pnlRed.add(lblRed);

        Panel pnlBlue = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnlBlue.add(ckbBlue);
        pnlBlue.add(lblBlue);

        Panel pnlGreen = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnlGreen.add(ckbGreen);
        pnlGreen.add(lblGreen);

        Panel pnlBlack = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnlBlack.add(ckbBlack);
        pnlBlack.add(lblBlack);

        pnlResult = new Panel(new FlowLayout(FlowLayout.CENTER));
        pnlResult.add(lblResult);
        pnlResult.setBackground(Color.RED);

        this.add(pnlRed);
        this.add(pnlBlue);
        this.add(pnlGreen);
        this.add(pnlBlack);
        this.add(pnlResult);
    }

    public void handle(){
        ckbgrp.setSelectedCheckbox(ckbRed);
        ckbRed.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    lblResult.setText("Red selected");
                    lblResult.setForeground(Color.BLACK);
                    lblResult.setBackground(Color.RED);
                    pnlResult.setBackground(Color.RED);
                }
            }
        });

        ckbBlue.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    lblResult.setText("Blue selected");
                    lblResult.setForeground(Color.WHITE);
                    lblResult.setBackground(Color.BLUE);
                    pnlResult.setBackground(Color.BLUE);
                }
            }
        });

        ckbGreen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    lblResult.setText("Green selected");
                    lblResult.setForeground(Color.BLACK);
                    lblResult.setBackground(Color.GREEN);
                    pnlResult.setBackground(Color.GREEN);
                }
            }
        });

        ckbBlack.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    lblResult.setText("Black selected");
                    lblResult.setForeground(Color.WHITE);
                    lblResult.setBackground(Color.BLACK);
                    pnlResult.setBackground(Color.BLACK);
                }
            }
        });
    }

    private Panel pnlResult;
    private Label lblResult;
    private Label lblRed;
    private Label lblBlue;
    private Label lblGreen;
    private Label lblBlack;
    private CheckboxGroup ckbgrp;
    private Checkbox ckbRed;
    private Checkbox ckbBlue;
    private Checkbox ckbGreen;
    private Checkbox ckbBlack;
}
