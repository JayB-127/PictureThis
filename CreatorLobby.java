import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

import java.awt.Dimension;

public class CreatorLobby {
    
    private JFrame creatorLobbyFrame = new JFrame("Picture This! - Creator  Lobby");
    private JButton button;



    public void show() {

        Container content = creatorLobbyFrame.getContentPane();
        content.setLayout(new BorderLayout());

        button = new JButton("start game");
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(e -> {
            System.out.println("btn clicked");
        });
        content.add(button, BorderLayout.SOUTH);

        creatorLobbyFrame.setSize(640, 360);
        creatorLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creatorLobbyFrame.setVisible(true);
        creatorLobbyFrame.setResizable(false);
        creatorLobbyFrame.setLocationRelativeTo(null);
    }

}
