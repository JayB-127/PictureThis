import javax.swing.JFrame;

public class GuessingPhase{
    
    JFrame guessingFrame = new JFrame("Picture This! - Guessing Phase");
    
    public void show() {
        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(true);
        guessingFrame.setLocationRelativeTo(null);
    }
}