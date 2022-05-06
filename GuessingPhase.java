import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComponent;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
        guessingFrame.setResizable(true);
        guessingFrame.setLocationRelativeTo(null);

    }

    private JComponent inputs() {
        JPanel inputs = new JPanel();
        inputs.setPreferredSize(new Dimension(0, 150));
        inputs.setBackground(Color.decode("#ABCDEF"));

        GridLayout gridLay = new GridLayout(1, 0);
        gridLay.setHgap(50);
        inputs.setLayout(gridLay);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            System.out.println("[Submitted]");
        });

        inputTxt = new JTextField(5);

        inputs.add(inputTxt);
        inputs.add(submitBtn);

        return inputs;
    }

    public static void main(String[] args) {
        new GuessingPhase().show();
    }
}