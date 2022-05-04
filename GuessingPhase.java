import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;

public class GuessingPhase{
    
    JFrame guessingFrame = new JFrame("Picture This! - Creator  Lobby");
    DrawingPhase dp;
    
    public void show() {

        dp = new DrawingPhase();
        dp.getBackgroundImage();

        ImageIcon image = dp.getBackgroundImage();
        JLabel imageLabel = new JLabel(image);

        Container content = guessingFrame.getContentPane();
        content.setLayout(new BorderLayout());

        content.add(imageLabel, BorderLayout.CENTER);

        imageLabel.setBounds(10, 10, 400, 400);
        imageLabel.setVisible(true);

        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(false);
    }

}