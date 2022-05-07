import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.Insets;

import java.awt.Font;

public class CreatorLobby {
    
    private JFrame creatorLobbyFrame = new JFrame("Picture This! - Creator  Lobby");
    private JButton startGame;
    private JLabel roundLen, roundNum;
    private JTextField roundLenTxt, roundNumTxt;



    public void show() {

        Container content = creatorLobbyFrame.getContentPane();
        content.setLayout(null);

        Insets insets = content.getInsets();

        roundLen = new JLabel("Round Length", JLabel.CENTER);
        roundLen.setSize(200, 20);
        roundLen.setFont(roundLen.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundLen);

        roundLen.setBounds(
            fromLeft(roundLen) + insets.left,
            40 + insets.top,
            roundLen.getWidth(),
            roundLen.getHeight()
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

        roundNum = new JLabel("Number of Rounds", JLabel.CENTER);
        roundNum.setSize(200, 20);
        roundNum.setFont(roundNum.getFont().deriveFont(Font.PLAIN, 14.0f));
        content.add(roundNum);

        roundNum.setBounds(
            fromLeft(roundNum) + insets.left,
            100 + insets.top,
            roundNum.getWidth(),
            roundNum.getHeight()
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
            // TODO: validation
            DrawingPhase dp = new DrawingPhase();
            dp.show();
            creatorLobbyFrame.dispose();
            //set round length, num of rounds
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
        //Determines where the component should be placed horizontally so that it appears in the middle
        Integer fromLeft = 320 - component.getWidth() / 2;
        return fromLeft;
    }

}
