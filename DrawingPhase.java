import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;

import javax.swing.Timer;

import java.awt.Container;
import java.awt.Component;

import javax.swing.JComponent;

import java.awt.GridLayout;

public class DrawingPhase {
    
    JButton clearBtn, blackBtn, blueBtn, redBtn, greenBtn, magentaBtn, quitBtn, eraserBtn;
    JLabel wordLbl, breakLbl, timerLbl;
    Canvas canvas;
    JFrame drawingFrame = new JFrame("Drawing Phase");

    Timer timer;
    int counter = 20; //set to half of round length chosen by creator

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
        wordLbl.setFont(wordLbl.getFont().deriveFont(25.0f));
        content.add(wordLbl, BorderLayout.NORTH);

        timerLbl = new JLabel("", JLabel.CENTER);
        timerLbl.setFont(timerLbl.getFont().deriveFont(25.0f));;
        content.add(timerLbl, BorderLayout.SOUTH);


        drawingFrame.setSize(1280, 720);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setVisible(true);
        drawingFrame.setResizable(false);

        countDown();

    }

    private JComponent tools() {
        JPanel tools = new JPanel();
        tools.setLayout(new GridLayout(0, 0));

        clearBtn = new JButton("Clear");
        clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearBtn.addActionListener(e -> {
            canvas.clear();
        });

        blackBtn = new JButton("Black");
        blackBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackBtn.addActionListener(e -> {
            canvas.black();
        });

        blueBtn = new JButton("Blue");
        blueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        blueBtn.addActionListener(e -> {
            canvas.blue();
        });

        redBtn = new JButton("Red");
        redBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        redBtn.addActionListener(e -> {
            canvas.red();
        });

        greenBtn = new JButton("Green");
        greenBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        greenBtn.addActionListener(e -> {
            canvas.green();
        });

        magentaBtn = new JButton("Magenta");
        magentaBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        magentaBtn.addActionListener(e -> {
            canvas.magenta();
        });

        eraserBtn = new JButton("Eraser");
        eraserBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        eraserBtn.addActionListener(e -> {
            canvas.erase();
        });

        SpinnerModel model = new SpinnerNumberModel(1, 1, 35, 2);
        thicknessSpin = new JSpinner(model);
        thicknessSpin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JFormattedTextField textField = ((JSpinner.DefaultEditor) thicknessSpin.getEditor()).getTextField();
        textField.setEditable(false);

        breakLbl = new JLabel("---");
        breakLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        tools.add(thicknessSpin);
        tools.add(blackBtn);
        tools.add(blueBtn);
        tools.add(redBtn);
        tools.add(greenBtn);
        tools.add(magentaBtn);
        tools.add(breakLbl);
        tools.add(eraserBtn);   
        tools.add(clearBtn);

        return tools;
    }

    private void countDown() {

        timer = new Timer(1000, e -> {
            if (counter > 0) {
                counter--;
                System.out.println(counter);
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
