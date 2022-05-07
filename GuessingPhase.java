import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

import java.awt.Color;

public class GuessingPhase {
    
    private JFrame guessingFrame = new JFrame("Picture This! - Guessing Phase");
    private JButton submitBtn;
    static JTextField inputTxt;
    private JTextArea chatArea;
    private JScrollPane scroll;
    
    public void show() {

        Container content = guessingFrame.getContentPane();
        content.setLayout(new BorderLayout());

        JComponent inputs = inputs();
        content.add(inputs, BorderLayout.SOUTH);
        
        JComponent display = display();
        content.add(display, BorderLayout.CENTER);

        JComponent pics = pics();
        content.add(pics, BorderLayout.NORTH);


        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(false);
        guessingFrame.setLocationRelativeTo(null);

        guessingFrame.getRootPane().setDefaultButton(submitBtn);

    }

    private JComponent inputs() {
        JPanel inputs = new JPanel();
        inputs.setLayout(new FlowLayout());
        inputs.setPreferredSize(new Dimension(0, 50));

        inputTxt = new JTextField(30);
        inputTxt.setFont(inputTxt.getFont().deriveFont(20.0f));
        inputTxt.setHorizontalAlignment(JTextField.CENTER);
        inputs.add(inputTxt);
       
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            //TODO: validation
            //send text to server
            chatArea.append(inputTxt.getText() + "\n");
            inputTxt.setText("");
        });
        submitBtn.setPreferredSize(new Dimension(200, 30));
        inputs.add(submitBtn);

        return inputs;
    }

    private JComponent display() {
        JPanel display = new JPanel();

        chatArea = new JTextArea(12, 45);
        chatArea.setFont(chatArea.getFont().deriveFont(20.0f));
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        scroll = new JScrollPane(chatArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        display.add(scroll);

        return display;
    }

    private JComponent pics() {
        JPanel pics = new JPanel();
        pics.setPreferredSize(new Dimension(0, 300));
        pics.setBackground(Color.GRAY);

        //add drawings

        return pics;
    }

    //TIMER
    //end of timer, if statement if num rounds complete, if so, launch leaderboard


    public static void main(String[] args) {
        new GuessingPhase().show();
    }

}