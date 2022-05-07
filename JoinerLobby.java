import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Container;
import java.awt.BorderLayout;

public class JoinerLobby {

    private JFrame joinerLobbyFrame = new JFrame("Picture This! - Joiner  Lobby");
    private JLabel welcomeLbl, msgLbl, timeLbl;
    private Timer timer;
    private int counter = -1;
    
    public void show() {

        Container content = joinerLobbyFrame.getContentPane();
        content.setLayout(new BorderLayout());

        welcomeLbl = new JLabel(String.format("Welcome %s", Menu.username), JLabel.CENTER);
        welcomeLbl.setFont(welcomeLbl.getFont().deriveFont(20.0f));
        content.add(welcomeLbl, BorderLayout.NORTH);

        msgLbl = new JLabel("Please wait until the creator starts the game. Thank you :)", JLabel.CENTER);
        msgLbl.setFont(msgLbl.getFont().deriveFont(14.0f));
        content.add(msgLbl, BorderLayout.CENTER);

        timeLbl = new JLabel("", JLabel.CENTER);
        content.add(timeLbl, BorderLayout.SOUTH);

        joinerLobbyFrame.setSize(640, 360);
        joinerLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        joinerLobbyFrame.setVisible(true);
        joinerLobbyFrame.setResizable(false);
        joinerLobbyFrame.setLocationRelativeTo(null);

        elapsedTime();

    }

    public void elapsedTime() {
        timer = new Timer(1000, e -> {
            counter++;
            String output = String.format("[Time Elapsed: %S]", String.valueOf(counter));
            timeLbl.setText(output);
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    public void startGame() {
        DrawingPhase dp = new DrawingPhase();
        dp.show();
        joinerLobbyFrame.dispose();
    }

    //creator selects start game, sends game-start msg to server
    //server sends game-start msg to all players
    //joiner lobby socket listens for msg and starts drawing phase once recieved

}
