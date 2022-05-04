import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;

import javax.swing.Timer;

import java.awt.Container;
import java.awt.Component;

import javax.swing.JComponent;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class DrawingPhase {
    
    JButton clearBtn, blackBtn, brownBtn, redBtn, orangeBtn, yellowBtn, greenBtn, lightBlueBtn, darkBlueBtn, pinkBtn, purpleBtn, quitBtn, eraserBtn;
    JLabel wordLbl, breakLbl, timerLbl;
    Canvas canvas;
    JFrame drawingFrame = new JFrame("Picture This! - Drawing Phase");

    Timer timer;
    int counter = 61; //set to half of round length chosen by creator + 1

    static JSpinner thicknessSpin;

    public static void main(String[] args) {
        new DrawingPhase().show();
    }

    public void show() {

        Container content = drawingFrame.getContentPane();
        content.setLayout(new BorderLayout());

        canvas = new Canvas();
        content.add(canvas, BorderLayout.CENTER);

        JComponent tools = tools();
        content.add(tools, BorderLayout.LINE_START);

        wordLbl = new JLabel("[draw this word]", JLabel.CENTER);
        wordLbl.setFont(wordLbl.getFont().deriveFont(35.0f));
        content.add(wordLbl, BorderLayout.SOUTH);

        timerLbl = new JLabel("", JLabel.CENTER);
        timerLbl.setFont(timerLbl.getFont().deriveFont(20.0f));
        content.add(timerLbl, BorderLayout.NORTH);


        drawingFrame.setSize(1280, 720);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setVisible(true);
        drawingFrame.setResizable(false);

        countDown();    

    }

    private JComponent tools() {
        JPanel tools = new JPanel();
        tools.setPreferredSize(new Dimension(150, 0)); //Height value is negligable since since the panel will take the height of the interface

        GridLayout gridLay = new GridLayout(0, 1);
        gridLay.setVgap(10);
        tools.setLayout(gridLay);

        clearBtn = new JButton("Clear");
        clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearBtn.addActionListener(e -> {
            canvas.clear();
        });

        blackBtn = new JButton("");
        blackBtn.setBackground(Color.decode("#000"));
        blackBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackBtn.addActionListener(e -> {
            canvas.black();
        });

        brownBtn = new JButton("");
        brownBtn.setBackground(Color.decode("#8c4420"));
        brownBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        brownBtn.addActionListener(e -> {
            canvas.brown();
        });

        redBtn = new JButton("");
        redBtn.setBackground(Color.decode("#eb3434"));
        redBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        redBtn.addActionListener(e -> {
            canvas.red();
        });

        orangeBtn = new JButton("");
        orangeBtn.setBackground(Color.decode("#ff7912"));
        orangeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        orangeBtn.addActionListener(e -> {
            canvas.orange();
        });

        yellowBtn = new JButton("");
        yellowBtn.setBackground(Color.decode("#ffde38"));
        yellowBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        yellowBtn.addActionListener(e -> {
            canvas.yellow();
        });

        greenBtn = new JButton("");
        greenBtn.setBackground(Color.decode("#17e658"));
        greenBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        greenBtn.addActionListener(e -> {
            canvas.green();
        });

        lightBlueBtn = new JButton("");
        lightBlueBtn.setBackground(Color.decode("#0fcfff"));
        lightBlueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        lightBlueBtn.addActionListener(e -> {
            canvas.lightBlue();
        });

        darkBlueBtn = new JButton("");
        darkBlueBtn.setBackground(Color.decode("#1f1bf7"));
        darkBlueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        darkBlueBtn.addActionListener(e -> {
            canvas.darkBlue();
        });

        pinkBtn = new JButton("");
        pinkBtn.setBackground(Color.decode("#fc65f7"));
        pinkBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pinkBtn.addActionListener(e -> {
            canvas.pink();
        });

        purpleBtn = new JButton("");
        purpleBtn.setBackground(Color.decode("#b005ff"));
        purpleBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpleBtn.addActionListener(e -> {
            canvas.purple();
        });


        eraserBtn = new JButton("Eraser");
        eraserBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        eraserBtn.addActionListener(e -> {
            canvas.erase();
        });

        SpinnerModel model = new SpinnerNumberModel(5, 1, 35, 2);
        thicknessSpin = new JSpinner(model);
        thicknessSpin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JFormattedTextField textField = ((JSpinner.DefaultEditor) thicknessSpin.getEditor()).getTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(textField.getFont().deriveFont(20.0f));

        tools.add(thicknessSpin);
        tools.add(blackBtn);
        tools.add(brownBtn);
        tools.add(redBtn);
        tools.add(orangeBtn);
        tools.add(yellowBtn);
        tools.add(greenBtn);
        tools.add(lightBlueBtn);
        tools.add(darkBlueBtn);
        tools.add(pinkBtn);
        tools.add(purpleBtn);
        tools.add(eraserBtn);
        tools.add(clearBtn);

        return tools;
    }

    private void countDown() {

        timer = new Timer(1000, e -> {
            if (counter > 0) {
                counter--;
                String output = String.format("Time Left To Draw: %s", counter);
                timerLbl.setText(output);
            } else {
                //TODO: load guessing phase, server side stuff etc
                drawingFrame.dispose();
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

}
