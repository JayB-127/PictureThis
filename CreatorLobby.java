import javax.swing.JFrame;

public class CreatorLobby {
    
    private JFrame creatorLobbyFrame = new JFrame("Picture This! - Creator  Lobby");
    
    public void show() {

        creatorLobbyFrame.setSize(640, 360);
        creatorLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creatorLobbyFrame.setVisible(true);
        creatorLobbyFrame.setResizable(false);
        creatorLobbyFrame.setLocationRelativeTo(null);
    }

}
