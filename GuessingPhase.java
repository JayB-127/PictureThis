import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComponent;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Component;

public class GuessingPhase{
    
    JFrame guessingFrame = new JFrame("Picture This! - Guessing Phase");
    JButton submitBtn;
    JTextField inputTxt;
    JTextArea chatArea;
    
    public void show() {

        Container content = guessingFrame.getContentPane();
        content.setLayout(new BorderLayout());

        JComponent inputs = inputs();
        content.add(inputs, BorderLayout.SOUTH);


        chatArea = new JTextArea(11, 30);
        chatArea.setFont(chatArea.getFont().deriveFont(15.0f));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(
            chatArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        content.add(chatArea);



        JPanel display = new JPanel();
        display.setBackground(Color.BLUE);
        display.setLayout(new FlowLayout());
        display.add(chatArea);
        display.add(scroll);

        content.add(display, BorderLayout.CENTER);

        

        JPanel pics = new JPanel();
        pics.setPreferredSize(new Dimension(0, 300));
        pics.setBackground(Color.RED);
        content.add(pics, BorderLayout.NORTH);


        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(false);
        guessingFrame.setLocationRelativeTo(null);

    }

    private JComponent inputs() {
        JPanel inputs = new JPanel();
        inputs.setBackground(Color.decode("#ABCDEF"));
        inputs.setPreferredSize(new Dimension(0, 40));

        GridLayout gridLay = new GridLayout(1, 0);
        gridLay.setHgap(5);

        inputs.setLayout(gridLay);



        inputTxt = new JTextField(5);
        inputTxt.setFont(inputTxt.getFont().deriveFont(20.0f));
        inputTxt.setHorizontalAlignment(JTextField.CENTER);
        inputTxt.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputs.add(inputTxt);
       

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            System.out.println("[Submitted]");
            //check if text area has a certain amount of lines, if too many, remove top line
            chatArea.append(inputTxt.getText() + "\n");
        });
        submitBtn.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputs.add(submitBtn);

        return inputs;
    }

    public static void main(String[] args) {
        new GuessingPhase().show();
    }
}