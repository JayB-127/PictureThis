import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.BadLocationException;
import javax.swing.JComponent;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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


        guessingFrame.setSize(1280, 720);
        guessingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessingFrame.setVisible(true);
        guessingFrame.setResizable(false);
        guessingFrame.setLocationRelativeTo(null);

    }

    private JComponent inputs() {
        JPanel inputs = new JPanel();
        inputs.setBackground(Color.decode("#ABCDEF"));
        inputs.setPreferredSize(new Dimension(0, 300));

        inputs.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridwidth = 3;
        c.ipady = 200;
        c.gridy = 0;
        inputs.add(chatArea, c);


        inputTxt = new JTextField(5);
        inputTxt.setFont(inputTxt.getFont().deriveFont(20.0f));
        inputTxt.setHorizontalAlignment(JTextField.CENTER);
        c.weightx = 0.5;
        c.ipady = 20;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 1;
        inputs.add(inputTxt, c);

        submitBtn = new JButton("Submit");
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        inputs.add(submitBtn, c);
    
        submitBtn.addActionListener(e -> {
            System.out.println("[Submitted]");
            //check if text area has a certain amount of lines, if too many, remove top line
            chatArea.append(inputTxt.getText() + "\n");
        });




        return inputs;
    }

    public static void main(String[] args) {
        new GuessingPhase().show();
    }
}