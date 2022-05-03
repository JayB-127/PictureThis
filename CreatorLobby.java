import javax.swing.JFrame;

public class CreatorLobby {
    
    JFrame creatorLobbyFrame = new JFrame("Creator  Lobby");
    
    public void show() {

        creatorLobbyFrame.setSize(640, 360);
        creatorLobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creatorLobbyFrame.setVisible(true);
        creatorLobbyFrame.setResizable(false);
    }

}
