package PhamTuanNgoc;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 08/10/2016.
 */
public class Main {
    public static void bai1() {
        JFrame frame = new JFrame("Bai 1");
        JPanel panel = new JPanel();
        panel.setSize(300, 135);
        panel.setLayout(new FlowLayout());
        JLabel lbCencius = new JLabel("Nhập Vào Độ F: "), lbFahrenheit = new JLabel("Độ C Tương Ứng: ");
        JTextField txtCencius = new JTextField(), txtFahrenheit = new JTextField();
        txtCencius.setPreferredSize(new Dimension(150, 30));
        txtFahrenheit.setPreferredSize(new Dimension(150, 30));
        JButton btnResult = new JButton(" Tính "), btnContinue = new JButton("Tiếp Tục"), btnExit = new JButton(" Thoát ");

        panel.add(lbCencius);
        panel.add(txtCencius);
        panel.add(lbFahrenheit);
        panel.add(txtFahrenheit);
        panel.add(btnResult);
        panel.add(btnContinue);
        panel.add(btnExit);

        frame.setSize(300, 135);
        frame.add(panel);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCencius.setText("");
                txtFahrenheit.setText("");
            }
        });

        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!txtFahrenheit.getText().equals(""))
                        txtCencius.setText(Double.toString((Double.parseDouble(txtFahrenheit.getText()) - 32) / 1.8));
                    else if (!txtCencius.getText().equals(""))
                        txtFahrenheit.setText(Double.toString(Double.parseDouble(txtCencius.getText()) * 1.8 + 32));
                    else
                        JOptionPane.showMessageDialog(frame, "Dữ Liệu Không Hợp Lệ!");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Dữ Liệu Không Hợp Lệ!");
                }
            }
        });
    }

    public static void bai2() {
        JFrame frame = new JFrame("bai2");
        JPanel panel = new JPanel();
        panel.setSize(300, 100);
        JTextField txtText = new JTextField();
        txtText.setPreferredSize(new Dimension(250, 30));
        JCheckBox cbBold = new JCheckBox("Bold"), cbItalic = new JCheckBox("Italic");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(cbBold);
        btnGroup.add(cbItalic);

        panel.setLayout(new FlowLayout());
        panel.add(txtText);
        panel.add(cbBold);
        panel.add(cbItalic);

        frame.setSize(300, 100);
        frame.add(panel);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cbBold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbBold.isSelected()) {
                    Font font = new Font("Arial", Font.BOLD, 12);
                    txtText.setFont(font);
                } else {
                    Font font = new Font("Arial", Font.PLAIN, 12);
                    txtText.setFont(font);
                }
            }
        });

        cbItalic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbItalic.isSelected()) {
                    Font font = new Font("Arial", Font.ITALIC, 12);
                    txtText.setFont(font);
                } else {
                    Font font = new Font("Arial", Font.PLAIN, 12);
                    txtText.setFont(font);
                }
            }
        });
    }

    private JList list1 = null, list2 = null;
    private DefaultListModel listModel1, listModel2;

    public void bai3() {
        JFrame frame = new JFrame("Bai3");
        JPanel panel = new JPanel();
        panel.setSize(400, 300);
        panel.setLayout(new FlowLayout());
        JButton btnCoppy = new JButton("Coppy >>>");

        try {
            String string;
            InputStream inputStream = getClass().getResourceAsStream("/PhamTuanNgoc/lst01.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int i;
            string = "";
            while ((i = inputStreamReader.read()) != -1) {
                string = string + (char) i;
            }
            String[] strArr = string.split("/");
            listModel1 = new DefaultListModel();
            for (String str : strArr)
                listModel1.addElement(str);
            list1 = new JList(listModel1);
            inputStream.close();
            inputStreamReader.close();

            inputStream = getClass().getResourceAsStream("/PhamTuanNgoc/lst02.txt");
            inputStreamReader = new InputStreamReader(inputStream);
            string = "";
            while ((i = inputStreamReader.read()) != -1) {
                string = string + (char) i;
            }
            strArr = string.split("/");
            listModel2 = new DefaultListModel();
            for (String str : strArr)
                listModel2.addElement(str);
            list2 = new JList(listModel2);
            inputStream.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane1 = new JScrollPane(list1);
        JScrollPane scrollPane2 = new JScrollPane(list2);
        scrollPane1.setPreferredSize(new Dimension(150, 265));
        scrollPane2.setPreferredSize(new Dimension(150, 265));
        panel.add(scrollPane1);
        panel.add(btnCoppy);
        panel.add(scrollPane2);

        frame.setSize(450, 300);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

        btnCoppy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = list1.getSelectedIndex();
                listModel2.addElement(listModel1.get(i));
                listModel1.remove(i);
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String string1 = "", string2 = "";
                for (int i = 0; i < listModel1.size(); i++) {
                    string1 = string1 + "/" + listModel1.get(i);
                }
                for (int i = 0; i < listModel2.size(); i++) {
                    string2 = string2 + "/" + listModel2.get(i);
                }

                String url;
                try {
                    url = getClass().getResource("/PhamTuanNgoc/lst01.txt").getFile();
                    PrintWriter writer = new PrintWriter(url);
                    writer.print(string1);
                    writer.close();
                    url = getClass().getResource("/PhamTuanNgoc/lst02.txt").getFile();
                    writer = new PrintWriter(url);
                    writer.print(string2);
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }

        });
    }

    private DefaultListModel listModel;
    private JList jList;
    public void bai4() {
        JFrame frame = new JFrame("Bai 4");
        JPanel panelMain = new JPanel(), panelTool = new JPanel(), panelInfo = new JPanel(), panelBot = new JPanel();
        JLabel labelHead = new JLabel("Thao Tác Trên JList - CheckBox");
        JButton btnEven = new JButton("Tô Đen Số Chẵn"), btnOld = new JButton("Tô Đen Số Lẻ"),
                btnPrime = new JButton("Tô Đen Số Nguyên Tố"), btnUnHighLight = new JButton("Bỏ Tô Đen"),
                btnDelHighLight = new JButton("Xóa Các Giá Trị Đang Tô Đen"), btnSum = new JButton("Tổng Các giá Trị Trong JList"),
                btnInput = new JButton("Nhập"), btnExit = new JButton("Đóng Chương Trình");
        JTextField txtInput = new JTextField();
        JCheckBox cbAlowNegative = new JCheckBox("Cho Nhập Số Âm");

        labelHead.setForeground(Color.BLUE);
        Font font = new Font("Arial", Font.BOLD, 20);
        labelHead.setFont(font);
        labelHead.setPreferredSize(new Dimension(700, 30));
        labelHead.setHorizontalAlignment(SwingConstants.CENTER);

        font = new Font("times new roman", Font.BOLD, 12);
        panelTool.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), " Chọn Tác Vụ ", TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK));
        panelTool.setPreferredSize(new Dimension(290, 300));
        btnEven.setPreferredSize(new Dimension(250, 40));
        btnOld.setPreferredSize(new Dimension(250, 40));
        btnPrime.setPreferredSize(new Dimension(250, 40));
        btnUnHighLight.setPreferredSize(new Dimension(250, 40));
        btnDelHighLight.setPreferredSize(new Dimension(250, 40));
        btnSum.setPreferredSize(new Dimension(250, 40));
        panelTool.add(btnEven);
        panelTool.add(btnOld);
        panelTool.add(btnPrime);
        panelTool.add(btnUnHighLight);
        panelTool.add(btnDelHighLight);
        panelTool.add(btnSum);

        panelInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), " Nhập Thông Tin ", TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK));
        panelInfo.setPreferredSize(new Dimension(390, 300));
        panelInfo.setLayout(new FlowLayout());
        txtInput.setPreferredSize(new Dimension(100, 30));
        panelInfo.add(txtInput);
        panelInfo.add(cbAlowNegative);
        panelInfo.add(btnInput);
        listModel = new DefaultListModel();
        jList = new JList(listModel);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setPreferredSize(new Dimension(381, 240));
        panelInfo.add(scrollPane);

        panelBot.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelBot.setPreferredSize(new Dimension(681, 50));
        btnExit.setPreferredSize(new Dimension(200, 37));
        panelBot.add(btnExit);

        panelMain.setLayout(new FlowLayout());
        panelMain.add(labelHead);
        panelMain.add(panelTool);
        panelMain.add(panelInfo);
        panelMain.add(panelBot);
        panelBot.setBackground(Color.LIGHT_GRAY);

        frame.setSize(700, 425);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(panelMain);
        frame.setVisible(true);

        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                try {

                    i = Integer.parseInt(txtInput.getText());
                    if (!(!cbAlowNegative.isSelected() && i < 0))
                        listModel.addElement(i);
                    else
                        JOptionPane.showMessageDialog(frame, " Lỗi! ");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, " Lỗi! ");
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ressult = JOptionPane.showConfirmDialog(panelMain, "Thoát ?");
                if (ressult == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        btnEven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> lstInt = new ArrayList<>();
                for (int i = 0; i < listModel.size(); i++)
                    if ((Integer) listModel.get(i) % 2 == 0)
                        lstInt.add(i);
                jList.clearSelection();
                jList.setSelectedIndices(lstInt.stream().mapToInt(i -> i).toArray());
            }
        });

        btnOld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> lstInt = new ArrayList<>();
                for (int i = 0; i < listModel.size(); i++)
                    if ((Integer) listModel.get(i) % 2 != 0)
                        lstInt.add(i);
                jList.clearSelection();
                jList.setSelectedIndices(lstInt.stream().mapToInt(i -> i).toArray());
            }
        });

        btnPrime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> lstInt = new ArrayList<>();
                for (int i = 0; i < listModel.size(); i++)
                    if (isPrime((Integer) listModel.get(i)))
                        lstInt.add(i);
                jList.clearSelection();
                jList.setSelectedIndices(lstInt.stream().mapToInt(i -> i).toArray());
            }
        });

        btnUnHighLight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jList.clearSelection();
            }
        });

        btnDelHighLight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] arrInt = jList.getSelectedIndices();
                for (int i = arrInt.length - 1; i > -1; i--)
                    listModel.remove(arrInt[i]);
            }
        });

        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sum = 0;
                for (int i = 0; i < listModel.size(); i++)
                    sum = sum + (int) listModel.get(i);
                JOptionPane.showMessageDialog(frame, "Tổng = " + sum);
            }
        });
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        Main.bai1();
//        Main.bai2();
//        main.bai3();
        main.bai4();

    }
}
