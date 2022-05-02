import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.Timer;

import java.awt.Container;
import java.awt.BorderLayout;

public class JoinerLobby {

    JFrame joinerLobbyFrame = new JFrame("Joiner  Lobby");
    JLabel msgLbl, timeLbl;
    Timer timer;
    int counter = -1;
    
    public void show() {

        Container content = joinerLobbyFrame.getContentPane();
        content.setLayout(new BorderLayout());

        msgLbl = new JLabel("Please wait until the creator starts the game. Thank you :)", JLabel.CENTER);
        msgLbl.setFont(msgLbl.getFont().deriveFont(18.0f));

        content.add(msgLbl, BorderLayout.CENTER);

        timeLbl = new JLabel("", JLabel.CENTER);
        content.add(timeLbl, BorderLayout.NORTH);

        joinerLobbyFrame.setSize(640, 360);
        joinerLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        joinerLobbyFrame.setVisible(true);
        joinerLobbyFrame.setResizable(false);

        ElapsedTime();

    }

    public void ElapsedTime() {
        timer = new Timer(1000, e -> {
            counter++;
            timeLbl.setText(String.format("[Time Elapsed: %S]", String.valueOf(counter)));
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    //creator selects start game, sends game-start msg to server
    //server sends game-start msg to all players
    //joiner lobby socket listens for msg and starts drawing phase once recieved

}
