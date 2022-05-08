import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.Insets;

import java.awt.Font;

public class CreatorLobby {
    
    private JFrame creatorLobbyFrame = new JFrame("Picture This! - Creator  Lobby");
    private JButton startGame;
    private JLabel roundLenLbl, roundNumLbl;
    private JTextField roundLenTxt, roundNumTxt;
    static Integer roundLen, roundNum;


    public void show() {

        Container content = creatorLobbyFrame.getContentPane();
        content.setLayout(null);

        Insets insets = content.getInsets();

        roundLenLbl = new JLabel("Round Length", JLabel.CENTER);
        roundLenLbl.setSize(200, 20);
        roundLenLbl.setFont(roundLenLbl.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundLenLbl);

        roundLenLbl.setBounds(
            fromLeft(roundLenLbl) + insets.left,
            40 + insets.top,
            roundLenLbl.getWidth(),
            roundLenLbl.getHeight()
        );

        roundLenTxt = new JTextField(5);
        roundLenTxt.setSize(50, 20);
        roundLenTxt.setHorizontalAlignment(JTextField.CENTER);
        roundLenTxt.setFont(roundLenTxt.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundLenTxt);

        roundLenTxt.setBounds(
            fromLeft(roundLenTxt) + insets.left,
            70 + insets.top,
            roundLenTxt.getWidth(),
            roundLenTxt.getHeight()
        );

        roundNumLbl = new JLabel("Number of Rounds", JLabel.CENTER);
        roundNumLbl.setSize(200, 20);
        roundNumLbl.setFont(roundNumLbl.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundNumLbl);

        roundNumLbl.setBounds(
            fromLeft(roundNumLbl) + insets.left,
            100 + insets.top,
            roundNumLbl.getWidth(),
            roundNumLbl.getHeight()
        );

        roundNumTxt = new JTextField(5);
        roundNumTxt.setSize(50, 20);
        roundNumTxt.setHorizontalAlignment(JTextField.CENTER);
        roundNumTxt.setFont(roundNumTxt.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundNumTxt);

        roundNumTxt.setBounds(
            fromLeft(roundNumTxt) + insets.left,
            130 + insets.top,
            roundNumTxt.getWidth(),
            roundNumTxt.getHeight()
        );


        startGame = new JButton("Start Game");
        startGame.setSize(new Dimension(150, 40));
        startGame.setFont(startGame.getFont().deriveFont(Font.BOLD, 14.0f));
        startGame.addActionListener(e -> {
            
            try {
                Integer.parseInt(roundLenTxt.getText());
                Integer.parseInt(roundNumTxt.getText());

                if (Integer.parseInt(roundLenTxt.getText()) >= 30 && Integer.parseInt(roundLenTxt.getText()) <= 360) {
                    if (Integer.parseInt(roundNumTxt.getText()) > 0 && Integer.parseInt(roundNumTxt.getText()) < 11) {
                        roundLen = Integer.parseInt(roundLenTxt.getText());
                        roundNum = Integer.parseInt(roundNumTxt.getText());
                    } else {
                        JOptionPane.showMessageDialog(
                            creatorLobbyFrame,
                            "The value entered for the number of rounds is not within the valid range.\nPlease enter an integer in the range 1 - 10.",
                            "ERROR: Invalid Range",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        creatorLobbyFrame,
                        "The value entered for the length of rounds is not within the valid range.\nPlease enter an integer in the range 30 - 360.",
                        "ERROR: Invalid Range",
                        JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (Exception excep) {
                JOptionPane.showMessageDialog(
                    creatorLobbyFrame,
                    "The input(s) given are not in the correct format.\nPlease only enter integers.",
                    "ERROR: Invalid Input",
                    JOptionPane.ERROR_MESSAGE
                );
            }

            DrawingPhase dp = new DrawingPhase();
            dp.show();
            creatorLobbyFrame.dispose();
            //players in joiner lobby sent to drawing phase
        });
        content.add(startGame);

        startGame.setBounds(
            fromLeft(startGame) + insets.left,
            200 + insets.top,
            startGame.getWidth(),
            startGame.getHeight()
        );

        creatorLobbyFrame.setSize(640, 360);
        creatorLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creatorLobbyFrame.setVisible(true);
        creatorLobbyFrame.setResizable(false);
        creatorLobbyFrame.setLocationRelativeTo(null);
    }

    public Integer fromLeft(JComponent component) {
        //length to middle
        Integer fromLeft = 320 - component.getWidth() / 2;
        return fromLeft;
    }

}
