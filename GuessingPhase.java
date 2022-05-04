import javax.swing.JFrame;

public class GuessingPhase{
    
    JFrame guessingFrame = new JFrame("Picture This! - Creator  Lobby");
    
    public void show() {

        guessingFrame.setSize(640, 360);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(false);
    }

}