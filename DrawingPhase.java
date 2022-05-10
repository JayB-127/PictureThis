import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class DrawingPhase {
    
    private JButton clearBtn, blackBtn, greyBtn, brownBtn, redBtn, orangeBtn, yellowBtn, greenBtn, lightBlueBtn, darkBlueBtn, pinkBtn, purpleBtn, eraserBtn;
    private JLabel wordLbl, timerLbl;
    private Canvas canvas;
    private JFrame drawingFrame = new JFrame("Picture This! - Drawing Phase");

    static String finalWord;
    static String difficulty = "m";
    
    static JSpinner thicknessSpin;

    private Timer timer;
    int counter = CreatorLobby.roundLen / 2;

    public void show() {

        Container content = drawingFrame.getContentPane();
        content.setLayout(new BorderLayout());

        canvas = new Canvas();
        content.add(canvas, BorderLayout.CENTER);

        JComponent tools = tools();
        content.add(tools, BorderLayout.LINE_START);

        String[] words = wordSelection("3player.csv");
        finalWord = words[words.length-1].trim();
        //output other words to the other clients

        wordLbl = new JLabel(words[0], JLabel.CENTER);
        wordLbl.setFont(wordLbl.getFont().deriveFont(35.0f));
        content.add(wordLbl, BorderLayout.SOUTH);

        timerLbl = new JLabel("", JLabel.CENTER);
        timerLbl.setFont(timerLbl.getFont().deriveFont(20.0f));
        content.add(timerLbl, BorderLayout.NORTH);


        drawingFrame.setSize(1280, 720);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setVisible(true);
        drawingFrame.setResizable(false);
        drawingFrame.setLocationRelativeTo(null);

        countDown();    

    }

    private String[] wordSelection(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("3player.csv"));
            String str;
            List<String[]> lines = new ArrayList<String[]>();
            while ((str = br.readLine()) != null) {
                String[] words = str.split(",");
                if (words[0].trim().equals(difficulty)) {
                    lines.add(words);
                }
            }
            br.close();

            String[][] array = new String[lines.size()][0];
            lines.toArray(array);

            int randomNum = ThreadLocalRandom.current().nextInt(0, array.length); //min and (max + 1)
            
            int i = 0;
            for (String[] x : array) {
                if (i == randomNum) {
                    String word1 = array[i][1];
                    String word2 = array[i][2];
                    String finalWord = array[i][array.length - 1];
                    if (Menu.numPlayers == 2) {
                        String[] returns = new String[3];
                        returns[0] = word1;
                        returns[1] = word2;
                        returns[2] = finalWord;
                        return returns;
                    } else if (Menu.numPlayers == 3) {
                        String word3 = array[i][3];
                        String[] returns = new String[4];
                        returns[0] = word1;
                        returns[1] = word2;
                        returns[2] = word3;
                        returns[3] = finalWord;
                        return returns;
                    } else if (Menu.numPlayers == 4) {
                        String word3 = array[i][3];
                        String word4 = array[i][4];
                        String[] returns = new String[5];
                        returns[0] = word1;
                        returns[1] = word2;
                        returns[2] = word3;
                        returns[3] = word4;
                        returns[4] = finalWord;
                        return returns;
                    }
                } else {
                    i += 1;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JComponent tools() {
        JPanel tools = new JPanel();
        tools.setPreferredSize(new Dimension(75, 0)); //Height value is negligable since since the panel will take the max height it can in the interface

        GridLayout gridLay = new GridLayout(0, 1);
        gridLay.setVgap(10);
        tools.setLayout(gridLay);

        clearBtn = new JButton("Clear");
        clearBtn.setBackground(Color.decode("#a3a3a3"));
        clearBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearBtn.addActionListener(e -> {
            canvas.clear();
        });

        blackBtn = new JButton("");
        blackBtn.setBackground(Color.decode("#000"));
        blackBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        blackBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackBtn.addActionListener(e -> {
            canvas.black();
        });

        greyBtn = new JButton("");
        greyBtn.setBackground(Color.decode("#757575"));
        greyBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        greyBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        greyBtn.addActionListener(e -> {
            canvas.grey();
        });

        brownBtn = new JButton("");
        brownBtn.setBackground(Color.decode("#8c4420"));
        brownBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        brownBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        brownBtn.addActionListener(e -> {
            canvas.brown();
        });

        redBtn = new JButton("");
        redBtn.setBackground(Color.decode("#eb3434"));
        redBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        redBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        redBtn.addActionListener(e -> {
            canvas.red();
        });

        orangeBtn = new JButton("");
        orangeBtn.setBackground(Color.decode("#ff7912"));
        orangeBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        orangeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        orangeBtn.addActionListener(e -> {
            canvas.orange();
        });

        yellowBtn = new JButton("");
        yellowBtn.setBackground(Color.decode("#ffde38"));
        yellowBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        yellowBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        yellowBtn.addActionListener(e -> {
            canvas.yellow();
        });

        greenBtn = new JButton("");
        greenBtn.setBackground(Color.decode("#17e658"));
        greenBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        greenBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        greenBtn.addActionListener(e -> {
            canvas.green();
        });

        lightBlueBtn = new JButton("");
        lightBlueBtn.setBackground(Color.decode("#0fcfff"));
        lightBlueBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        lightBlueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        lightBlueBtn.addActionListener(e -> {
            canvas.lightBlue();
        });

        darkBlueBtn = new JButton("");
        darkBlueBtn.setBackground(Color.decode("#1f1bf7"));
        darkBlueBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        darkBlueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        darkBlueBtn.addActionListener(e -> {
            canvas.darkBlue();
        });

        pinkBtn = new JButton("");
        pinkBtn.setBackground(Color.decode("#fc65f7"));
        pinkBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        pinkBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pinkBtn.addActionListener(e -> {
            canvas.pink();
        });

        purpleBtn = new JButton("");
        purpleBtn.setBackground(Color.decode("#b005ff"));
        purpleBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
        purpleBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpleBtn.addActionListener(e -> {
            canvas.purple();
        });

        eraserBtn = new JButton("Eraser");
        eraserBtn.setBackground(Color.decode("#FFFFFF"));
        eraserBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#000")));
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
        tools.add(greyBtn);
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
                timer.stop();
                saveCanvasImage();
                GuessingPhase gp = new GuessingPhase();
                gp.show();
                drawingFrame.dispose();
                //send msg to server to take imgs and order
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    public void saveCanvasImage() {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas.paint(image.getGraphics());
        try {
            ImageIO.write(image, "png", new File("word1.png"));
        } catch (IOException excep) {
            System.out.println(excep);
        }
    }

}
