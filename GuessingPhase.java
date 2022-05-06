import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class GuessingPhase{
    
    JFrame guessingFrame = new JFrame("Picture This! - Guessing Phase");
    JButton submitBtn;
    JTextField inputTxt;
    JTextArea chatArea;
    
    public void show() {

        Container content = guessingFrame.getContentPane();
        content.setLayout(new BorderLayout());


        JPanel input = new JPanel();
        input.setLayout(new FlowLayout());

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            System.out.println("[Submitted]");
        });

        //input.add(comp);
        input.add(submitBtn);


        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(true);
        guessingFrame.setLocationRelativeTo(null);

    }
}