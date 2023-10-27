import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.Color;

public class Leaderboard {
    
    private JFrame leaderboardFrame = new JFrame("Picture This! - Leaderboard");
    private JTextArea leaderboard;
    private JButton menuBtn;
    private JLabel lbl;
    
    public void show() {

        Container content = leaderboardFrame.getContentPane();
        content.setLayout(new BorderLayout());

        JComponent leaderboardPane = displayBoard();
        content.add(leaderboardPane, BorderLayout.CENTER);

        JComponent button = menuBtn();
        content.add(button, BorderLayout.SOUTH);

        lbl = new JLabel("Thank you for playing :)\n");
        lbl.setFont(lbl.getFont().deriveFont(20.0f));
        lbl.setHorizontalAlignment(JLabel.CENTER);
        content.add(lbl, BorderLayout.NORTH);

        leaderboardFrame.setSize(640, 360);
        leaderboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leaderboardFrame.setVisible(true);
        leaderboardFrame.setResizable(false);
        leaderboardFrame.setLocationRelativeTo(null);
    }

    public JComponent displayBoard() {
        JPanel leaderboardPane = new JPanel();

        leaderboard = new JTextArea(5, 20);
        leaderboard.setEditable(false);
        leaderboard.setFont(leaderboard.getFont().deriveFont(20.0f));

        leaderboard.append("Player - Score\n");

        try{
            BufferedReader in = new BufferedReader(new FileReader("./scores.txt"));
            String str;
            List<String[]> scores = new ArrayList<String[]>();
            while((str = in.readLine()) != null) {
                scores.add(str.split(" "));
            }
            String[][] array = new String[scores.size()][0];
            scores.toArray(array);
            Arrays.sort(array, (b, a) -> Integer.parseInt(a[2]) - Integer.parseInt(b[2]));
            for (String[] x : array) {
                StringBuffer sb = new StringBuffer();
                for(int i = 0; i < x.length; i++) {
                    sb.append(x[i] + " ");
                }
                String output = sb.toString();
                leaderboard.append(output + "\n");
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        leaderboardPane.add(leaderboard);

        return leaderboardPane;
    }

    public JComponent menuBtn() {
        JPanel btnPane = new JPanel();
        btnPane.setPreferredSize(new Dimension(0, 100));

        menuBtn = new JButton("Quit to Main Menu");
        menuBtn.setBackground(Color.decode("#a3a3a3"));
        menuBtn.setFont(menuBtn.getFont().deriveFont(14.0f));
        menuBtn.setPreferredSize(new Dimension(200, 40));
        menuBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        menuBtn.addActionListener(e -> {
            Menu menu = new Menu();
            menu.show();
            leaderboardFrame.dispose();
        });

        btnPane.add(menuBtn);

        return btnPane;
        
    }

}