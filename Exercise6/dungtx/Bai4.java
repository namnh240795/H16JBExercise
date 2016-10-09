package Lesson06;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Dzung on 10/9/2016.
 */
public class Bai4 {

    public Bai4() {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(520, 350);
        frame.setContentPane($$$getRootComponent$$$());
        frame.setTitle("Thao tác trên JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        handler();
    }

    private void handler() {
        DefaultListModel defaultListModel = new DefaultListModel();
        lsInput.setModel(defaultListModel);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int input = Integer.parseInt(txtInput.getText());
                    if (!ckbNegative.isSelected()) {
                        input = Math.abs(input);
                    }
                    DefaultListModel model = (DefaultListModel) lsInput.getModel();
                    model.addElement(input);
                    txtInput.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pnlContent, "Xin nhập số", "Nhập sai kiểu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) lsInput.getModel();
                ArrayList<Integer> selectIndex = new ArrayList<Integer>();
                for (int i = 0; i < model.size(); i++) {
                    int element = (int) model.get(i);
                    if (element % 2 == 0) {
                        selectIndex.add(i);
                    }
                }
                int[] indices = selectIndex.stream().mapToInt(i -> i).toArray();
                lsInput.setSelectedIndices(indices);
            }
        });

        btnOdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) lsInput.getModel();
                ArrayList<Integer> selectIndex = new ArrayList<Integer>();
                for (int i = 0; i < model.size(); i++) {
                    int element = (int) model.get(i);
                    if (element % 2 != 0) {
                        selectIndex.add(i);
                    }
                }
                int[] indices = selectIndex.stream().mapToInt(i -> i).toArray();
                lsInput.setSelectedIndices(indices);
            }
        });

        btnPrime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) lsInput.getModel();
                ArrayList<Integer> selectIndex = new ArrayList<Integer>();
                for (int i = 0; i < model.size(); i++) {
                    int element = (int) model.get(i);
                    if (isPrime(element)) {
                        selectIndex.add(i);
                    }
                }
                int[] indices = selectIndex.stream().mapToInt(i -> i).toArray();
                lsInput.setSelectedIndices(indices);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lsInput.clearSelection();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) lsInput.getModel();
                while (!lsInput.isSelectionEmpty()) {
                    int index = lsInput.getSelectedIndex();
                    model.remove(index);
                }
            }
        });

        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) lsInput.getModel();
                int sum = 0;
                for (int i = 0; i < model.size(); i++) {
                    sum += (int) model.get(i);
                }
                JOptionPane.showMessageDialog(pnlContent, "Tổng giá trị trong JList là: " + sum, "Tổng JList", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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

    private JPanel pnlContent;
    private JPanel pnlHeader;
    private JLabel lblHeader;
    private JPanel pnlOptions;
    private JButton btnEven;
    private JButton btnOdd;
    private JButton btnPrime;
    private JButton btnReset;
    private JButton btnDel;
    private JButton btnSum;
    private JButton btnEnter;
    private JTextField txtInput;
    private JCheckBox ckbNegative;
    private JScrollPane pnlScroll;
    private JList lsInput;
    private JPanel pnlInput;
    private JPanel pnlExit;
    private JButton btnExit;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnlContent = new JPanel();
        pnlContent.setLayout(new BorderLayout(0, 0));
        pnlContent.setPreferredSize(new Dimension(500, 320));
        pnlHeader = new JPanel();
        pnlHeader.setLayout(new BorderLayout(0, 0));
        pnlHeader.setForeground(new Color(-15791429));
        pnlHeader.setMaximumSize(new Dimension(258, 57));
        pnlHeader.setMinimumSize(new Dimension(258, 57));
        pnlHeader.setPreferredSize(new Dimension(268, 37));
        pnlContent.add(pnlHeader, BorderLayout.NORTH);
        lblHeader = new JLabel();
        lblHeader.setFocusable(false);
        lblHeader.setFont(new Font(lblHeader.getFont().getName(), lblHeader.getFont().getStyle(), 20));
        lblHeader.setForeground(new Color(-15791429));
        lblHeader.setHorizontalAlignment(0);
        lblHeader.setHorizontalTextPosition(0);
        lblHeader.setMaximumSize(new Dimension(258, 27));
        lblHeader.setOpaque(false);
        lblHeader.setPreferredSize(new Dimension(200, 40));
        lblHeader.setText("Thao tác trên JList - Checkbox");
        pnlHeader.add(lblHeader, BorderLayout.CENTER);
        pnlOptions = new JPanel();
        pnlOptions.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnlOptions.setFocusable(false);
        pnlOptions.setMinimumSize(new Dimension(200, 100));
        pnlOptions.setOpaque(false);
        pnlOptions.setPreferredSize(new Dimension(200, 80));
        pnlOptions.setRequestFocusEnabled(false);
        pnlContent.add(pnlOptions, BorderLayout.WEST);
        pnlOptions.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-1433600)), "Chọn tác vụ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        btnEven = new JButton();
        btnEven.setText("Tô đen số chẵn");
        pnlOptions.add(btnEven);
        btnOdd = new JButton();
        btnOdd.setText("Tô đen số lẻ");
        pnlOptions.add(btnOdd);
        btnPrime = new JButton();
        btnPrime.setText("Tô đen số nguyên tố");
        pnlOptions.add(btnPrime);
        btnReset = new JButton();
        btnReset.setText("Bỏ tô đen");
        pnlOptions.add(btnReset);
        btnDel = new JButton();
        btnDel.setText("Xoá các giá trị đang tô đen");
        pnlOptions.add(btnDel);
        btnSum = new JButton();
        btnSum.setText("Tổng giá trị trong JList");
        pnlOptions.add(btnSum);
        pnlInput = new JPanel();
        pnlInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlInput.setPreferredSize(new Dimension(300, 138));
        pnlContent.add(pnlInput, BorderLayout.CENTER);
        pnlInput.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-1433600)), "Nhập thông tin"));
        btnEnter = new JButton();
        btnEnter.setText("Nhập");
        pnlInput.add(btnEnter);
        txtInput = new JTextField();
        txtInput.setPreferredSize(new Dimension(100, 20));
        pnlInput.add(txtInput);
        ckbNegative = new JCheckBox();
        ckbNegative.setText("Cho nhập số âm");
        pnlInput.add(ckbNegative);
        pnlScroll = new JScrollPane();
        pnlScroll.setPreferredSize(new Dimension(280, 158));
        pnlScroll.setRequestFocusEnabled(true);
        pnlInput.add(pnlScroll);
        lsInput = new JList();
        pnlScroll.setViewportView(lsInput);
        pnlExit = new JPanel();
        pnlExit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlContent.add(pnlExit, BorderLayout.SOUTH);
        pnlExit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-1433600)), null));
        btnExit = new JButton();
        btnExit.setText("Đóng chương trình");
        pnlExit.add(btnExit);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlContent;
    }
}
