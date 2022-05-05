import javax.swing.JFrame;

public class Leaderboard {
    
    JFrame leaderboardFrame = new JFrame("Picture This! - Leaderboard");
    
    public void show() {

        leaderboardFrame.setSize(640, 360);
        leaderboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leaderboardFrame.setVisible(true);
        leaderboardFrame.setResizable(false);
        leaderboardFrame.setLocationRelativeTo(null);
    }

}