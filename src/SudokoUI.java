import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class SudokoUI {
    private JPanel jpanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JComboBox comboBox14;
    private JComboBox comboBox15;
    private JComboBox comboBox16;
    private JComboBox comboBox17;
    private JComboBox comboBox18;
    private JComboBox comboBox19;
    private JComboBox comboBox20;
    private JComboBox comboBox21;
    private JComboBox comboBox22;
    private JComboBox comboBox23;
    private JComboBox comboBox24;
    private JComboBox comboBox25;
    private JComboBox comboBox26;
    private JComboBox comboBox27;
    private JComboBox comboBox28;
    private JComboBox comboBox29;
    private JComboBox comboBox30;
    private JComboBox comboBox31;
    private JComboBox comboBox32;
    private JComboBox comboBox33;
    private JComboBox comboBox34;
    private JComboBox comboBox35;
    private JComboBox comboBox36;
    private JComboBox comboBox37;
    private JComboBox comboBox38;
    private JComboBox comboBox39;
    private JComboBox comboBox40;
    private JComboBox comboBox41;
    private JComboBox comboBox42;
    private JComboBox comboBox43;
    private JComboBox comboBox44;
    private JComboBox comboBox45;
    private JComboBox comboBox46;
    private JComboBox comboBox47;
    private JComboBox comboBox48;
    private JComboBox comboBox49;
    private JComboBox comboBox50;
    private JComboBox comboBox51;
    private JComboBox comboBox52;
    private JComboBox comboBox53;
    private JComboBox comboBox54;
    private JComboBox comboBox55;
    private JComboBox comboBox56;
    private JComboBox comboBox57;
    private JComboBox comboBox58;
    private JComboBox comboBox59;
    private JComboBox comboBox60;
    private JComboBox comboBox61;
    private JComboBox comboBox62;
    private JComboBox comboBox63;
    private JComboBox comboBox64;
    private JComboBox comboBox65;
    private JComboBox comboBox66;
    private JComboBox comboBox67;
    private JComboBox comboBox68;
    private JComboBox comboBox69;
    private JComboBox comboBox70;
    private JComboBox comboBox71;
    private JComboBox comboBox72;
    private JComboBox comboBox73;
    private JComboBox comboBox74;
    private JComboBox comboBox75;
    private JComboBox comboBox76;
    private JComboBox comboBox77;
    private JComboBox comboBox78;
    private JComboBox comboBox79;
    private JComboBox comboBox80;
    private JComboBox comboBox81;
    private JSplitPane splitpane;
    private JButton solveSudokoButton;
    private JProgressBar progressBar1;
    private JPanel col1;
    private JPanel col2;
    private JScrollPane scrollpane;
    private JTextArea textArea1;
    private JButton setDefaultButton;
    private JPanel valuesPanel;
    private JButton resetButton;

    public SudokoUI() {

        solveSudokoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        progressBar1.setVisible(true);

                        for (Component c : splitpane.getComponents()) {
                            c.setEnabled(false);
                        }

                        String[][] model = new String[][] {
                            {getString(comboBox1.getSelectedItem()), getString(comboBox2.getSelectedItem()), getString(comboBox3.getSelectedItem()), getString(comboBox4.getSelectedItem()), getString(comboBox5.getSelectedItem()), getString(comboBox6.getSelectedItem()), getString(comboBox7.getSelectedItem()), getString(comboBox8.getSelectedItem()), getString(comboBox9.getSelectedItem())},
                            {getString(comboBox10.getSelectedItem()), getString(comboBox11.getSelectedItem()), getString(comboBox12.getSelectedItem()), getString(comboBox13.getSelectedItem()), getString(comboBox14.getSelectedItem()), getString(comboBox15.getSelectedItem()), getString(comboBox16.getSelectedItem()), getString(comboBox17.getSelectedItem()), getString(comboBox18.getSelectedItem())},
                            {getString(comboBox19.getSelectedItem()), getString(comboBox20.getSelectedItem()), getString(comboBox21.getSelectedItem()), getString(comboBox22.getSelectedItem()), getString(comboBox23.getSelectedItem()), getString(comboBox24.getSelectedItem()), getString(comboBox25.getSelectedItem()), getString(comboBox26.getSelectedItem()), getString(comboBox27.getSelectedItem())},
                            {getString(comboBox28.getSelectedItem()), getString(comboBox29.getSelectedItem()), getString(comboBox30.getSelectedItem()), getString(comboBox31.getSelectedItem()), getString(comboBox32.getSelectedItem()), getString(comboBox33.getSelectedItem()), getString(comboBox34.getSelectedItem()), getString(comboBox35.getSelectedItem()), getString(comboBox36.getSelectedItem())},
                            {getString(comboBox37.getSelectedItem()), getString(comboBox38.getSelectedItem()), getString(comboBox39.getSelectedItem()), getString(comboBox40.getSelectedItem()), getString(comboBox41.getSelectedItem()), getString(comboBox42.getSelectedItem()), getString(comboBox43.getSelectedItem()), getString(comboBox44.getSelectedItem()), getString(comboBox45.getSelectedItem())},
                            {getString(comboBox46.getSelectedItem()), getString(comboBox47.getSelectedItem()), getString(comboBox48.getSelectedItem()), getString(comboBox49.getSelectedItem()), getString(comboBox50.getSelectedItem()), getString(comboBox51.getSelectedItem()), getString(comboBox52.getSelectedItem()), getString(comboBox53.getSelectedItem()), getString(comboBox54.getSelectedItem())},
                            {getString(comboBox55.getSelectedItem()), getString(comboBox56.getSelectedItem()), getString(comboBox57.getSelectedItem()), getString(comboBox58.getSelectedItem()), getString(comboBox59.getSelectedItem()), getString(comboBox60.getSelectedItem()), getString(comboBox61.getSelectedItem()), getString(comboBox62.getSelectedItem()), getString(comboBox63.getSelectedItem())},
                            {getString(comboBox64.getSelectedItem()), getString(comboBox65.getSelectedItem()), getString(comboBox66.getSelectedItem()), getString(comboBox67.getSelectedItem()), getString(comboBox68.getSelectedItem()), getString(comboBox69.getSelectedItem()), getString(comboBox70.getSelectedItem()), getString(comboBox71.getSelectedItem()), getString(comboBox72.getSelectedItem())},
                            {getString(comboBox73.getSelectedItem()), getString(comboBox74.getSelectedItem()), getString(comboBox75.getSelectedItem()), getString(comboBox76.getSelectedItem()), getString(comboBox77.getSelectedItem()), getString(comboBox78.getSelectedItem()), getString(comboBox79.getSelectedItem()), getString(comboBox80.getSelectedItem()), getString(comboBox81.getSelectedItem())}
                        };
                        List<List<String>> solution = new SudokuSolverOptimizedWithUIMultiThreaded().solve(model, progressBar1);
                        setSolution(comboBox1, solution, 0, 0);
                        setSolution(comboBox2, solution, 0, 1);
                        setSolution(comboBox3, solution, 0, 2);
                        setSolution(comboBox4, solution, 0, 3);
                        setSolution(comboBox5, solution, 0, 4);
                        setSolution(comboBox6, solution, 0, 5);
                        setSolution(comboBox7, solution, 0, 6);
                        setSolution(comboBox8, solution, 0, 7);
                        setSolution(comboBox9, solution, 0, 8);
                        setSolution(comboBox10, solution, 1, 0);
                        setSolution(comboBox11, solution, 1, 1);
                        setSolution(comboBox12, solution, 1, 2);
                        setSolution(comboBox13, solution, 1, 3);
                        setSolution(comboBox14, solution, 1, 4);
                        setSolution(comboBox15, solution, 1, 5);
                        setSolution(comboBox16, solution, 1, 6);
                        setSolution(comboBox17, solution, 1, 7);
                        setSolution(comboBox18, solution, 1, 8);
                        setSolution(comboBox19, solution, 2, 0);
                        setSolution(comboBox20, solution, 2, 1);
                        setSolution(comboBox21, solution, 2, 2);
                        setSolution(comboBox22, solution, 2, 3);
                        setSolution(comboBox23, solution, 2, 4);
                        setSolution(comboBox24, solution, 2, 5);
                        setSolution(comboBox25, solution, 2, 6);
                        setSolution(comboBox26, solution, 2, 7);
                        setSolution(comboBox27, solution, 2, 8);

                        setSolution(comboBox28, solution, 3, 0);
                        setSolution(comboBox29, solution, 3, 1);
                        setSolution(comboBox30, solution, 3, 2);
                        setSolution(comboBox31, solution, 3, 3);
                        setSolution(comboBox32, solution, 3, 4);
                        setSolution(comboBox33, solution, 3, 5);
                        setSolution(comboBox34, solution, 3, 6);
                        setSolution(comboBox35, solution, 3, 7);
                        setSolution(comboBox36, solution, 3, 8);

                        setSolution(comboBox37, solution, 4, 0);
                        setSolution(comboBox38, solution, 4, 1);
                        setSolution(comboBox39, solution, 4, 2);
                        setSolution(comboBox40, solution, 4, 3);
                        setSolution(comboBox41, solution, 4, 4);
                        setSolution(comboBox42, solution, 4, 5);
                        setSolution(comboBox43, solution, 4, 6);
                        setSolution(comboBox44, solution, 4, 7);
                        setSolution(comboBox45, solution, 4, 8);

                        setSolution(comboBox46, solution, 5, 0);
                        setSolution(comboBox47, solution, 5, 1);
                        setSolution(comboBox48, solution, 5, 2);
                        setSolution(comboBox49, solution, 5, 3);
                        setSolution(comboBox50, solution, 5, 4);
                        setSolution(comboBox51, solution, 5, 5);
                        setSolution(comboBox52, solution, 5, 6);
                        setSolution(comboBox53, solution, 5, 7);
                        setSolution(comboBox54, solution, 5, 8);

                        setSolution(comboBox55, solution, 6, 0);
                        setSolution(comboBox56, solution, 6, 1);
                        setSolution(comboBox57, solution, 6, 2);
                        setSolution(comboBox58, solution, 6, 3);
                        setSolution(comboBox59, solution, 6, 4);
                        setSolution(comboBox60, solution, 6, 5);
                        setSolution(comboBox61, solution, 6, 6);
                        setSolution(comboBox62, solution, 6, 7);
                        setSolution(comboBox63, solution, 6, 8);

                        setSolution(comboBox64, solution, 7, 0);
                        setSolution(comboBox65, solution, 7, 1);
                        setSolution(comboBox66, solution, 7, 2);
                        setSolution(comboBox67, solution, 7, 3);
                        setSolution(comboBox68, solution, 7, 4);
                        setSolution(comboBox69, solution, 7, 5);
                        setSolution(comboBox70, solution, 7, 6);
                        setSolution(comboBox71, solution, 7, 7);
                        setSolution(comboBox72, solution, 7, 8);

                        setSolution(comboBox73, solution, 8, 0);
                        setSolution(comboBox74, solution, 8, 1);
                        setSolution(comboBox75, solution, 8, 2);
                        setSolution(comboBox76, solution, 8, 3);
                        setSolution(comboBox77, solution, 8, 4);
                        setSolution(comboBox78, solution, 8, 5);
                        setSolution(comboBox79, solution, 8, 6);
                        setSolution(comboBox80, solution, 8, 7);
                        setSolution(comboBox81, solution, 8, 8);

                        progressBar1.setVisible(false);

                        for (Component c : splitpane.getComponents()) {
                            c.setEnabled(false);
                        }
                    }

                    private void setSolution(JComboBox comboBox, List<List<String>> solution, int index, int index1) {
                        if (!solution.get(index).get(index1).equals(comboBox.getSelectedItem())) {
                            comboBox.setSelectedItem(solution.get(index).get(index1));
                            comboBox.setForeground(Color.MAGENTA);
                        }
                        comboBox.setSelectedItem(solution.get(index).get(index1));
                    }
                }).start();
            }
        });

        setDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] b = new String[][]
                                {{"9", "8", "4", ".", ".", "6", ".", ".", "."},
                                {"2", "5", ".", ".", "1", ".", ".", ".", "9"},
                                {".", "1", ".", ".", "9", ".", ".", "2", "7"},
                                {".", "3", "2", ".", "7", ".", ".", ".", "."},
                                {".", "4", ".", ".", "6", ".", ".", ".", "8"},
                                {".", ".", "6", ".", ".", ".", ".", "5", "3"},
                                {".", "7", ".", ".", ".", "4", "9", ".", "2"},
                                {"4", ".", ".", "6", ".", ".", "1", ".", "5"},
                                {".", ".", ".", ".", ".", "9", ".", ".", "."}};
                int i = 0;
                for (int j = 0; j < b.length; j++) {
                    String[] row = b[j];
                    for (int k = 0; k < row.length; k++) {
                        String val = row[k];
                        JComboBox box = (JComboBox) valuesPanel.getComponent(i);
                        box.setSelectedItem(val);
                        i++;
                    }
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int j = 0; j < 81; j++) {
                    JComboBox box = (JComboBox) valuesPanel.getComponent(j);
                    box.setSelectedItem(null);
                    box.setForeground(null);
                }
            }
        });
    }

    public String getString(Object s) {
        return s == null || "".equals(s) ? "." : (String)s;
    }

    public void setData(SudokoUI data) {
    }

    public void getData(SudokoUI data) {
    }

    public boolean isModified(SudokoUI data) {
        return false;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        JFrame frame = new JFrame("SudokoUI");

        SudokoUI sudokoUI = new SudokoUI();
        frame.setContentPane(sudokoUI.jpanel);
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(SudokoUI.class.getResource("/sudoku.png"))).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        sudokoUI.progressBar1.setVisible(false);
        sudokoUI.progressBar1.setStringPainted(true);
        frame.setVisible(true);
        PrintStream printStream = new PrintStream(new CustomOutputStream(sudokoUI.textArea1));
        System.setOut(printStream);
    }

    static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
