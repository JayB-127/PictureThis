import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;

public class GuessingPhase {
    
    private JFrame guessingFrame = new JFrame("Picture This! - Guessing Phase");
    private JButton submitBtn;
    private JTextField inputTxt;
    private JTextArea chatArea;
    private JScrollPane scroll;
    private JLabel word1Img, word2Img, word3Img, timerLbl;

    static int timeTaken = CreatorLobby.roundLen / 2; //max time taken, assumes players do not guess
    static int points = 0;
    
    private Timer timer;
    private int counter = CreatorLobby.roundLen / 2;
    
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

        guessingFrame.getRootPane().setDefaultButton(submitBtn); //focuses button allowing enter to be used to submit guesses

        countDown();

    }

    private JComponent inputs() {
        JPanel inputs = new JPanel();
        inputs.setLayout(new FlowLayout());
        inputs.setPreferredSize(new Dimension(0, 50));

        timerLbl = new JLabel("", JLabel.CENTER);
        timerLbl.setFont(timerLbl.getFont().deriveFont(15.0f));
        inputs.add(timerLbl);

        inputTxt = new JTextField(20);
        inputTxt.setFont(inputTxt.getFont().deriveFont(20.0f));
        inputTxt.setHorizontalAlignment(JTextField.CENTER);
        inputs.add(inputTxt);
       
        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.decode("#a3a3a3"));
        submitBtn.addActionListener(e -> {

            String input = inputTxt.getText();
            String output;
            if (input.equals("")) {
                JOptionPane.showMessageDialog(
                    guessingFrame,
                    "The guess entered was blank.\nPlease enter a guess that contains at least one letter character.",
                    "ERROR: Guess given was null",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                if (containsNumbers(input) == true) {
                    JOptionPane.showMessageDialog(
                        guessingFrame,
                        "The guess entered contains invalid characters.\nPlease enter a guess that does not contain numbers.",
                        "ERROR: Invalid characters in inputted guess",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    if (input.toLowerCase().equals(DrawingPhase.finalWord)) {
                        output = Menu.username + " guessed correctly!\n";
                        //output sent to server to be displayed to all other players

                        int timeTaken = (CreatorLobby.roundLen / 2) - counter;
                        double percTimeTaken = ((double) timeTaken) / (CreatorLobby.roundLen / 2);
                        double percTimeLeft = 1 - percTimeTaken;

                        //deletes current line of old score
                        File inputFile = new File("./scores.txt");
                        File tempFile = new File("./tempScores.txt");

                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                            String lineToRemove = Menu.username + " - " + points;
                            String currentLine;

                            while((currentLine = reader.readLine()) != null) {
                                //trim newline when comparing with lineToRemove
                                String trimmedLine = currentLine.trim();
                                if(trimmedLine.equals(lineToRemove)) continue;
                                writer.write(currentLine + System.getProperty("line.separator"));
                            }
                            writer.close();
                            reader.close();
                            inputFile.delete();
                            tempFile.renameTo(new File("./scores.txt"));
                        } catch (Exception excep) {
                            excep.printStackTrace();
                        }

                        //writes new line with new score
                        points += (int) Math.round(percTimeLeft * 1000);
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("./scores.txt", true));
                            bw.write(Menu.username + " - " + points);
                            bw.close();
                        } catch (Exception excep) {
                            excep.printStackTrace();
                        }
                        
                        chatArea.append(output);
                        inputTxt.setEditable(false);
                    } else {
                        output = profanityFilter(input);
                        //output sent to server to be displayed to all other players
                        chatArea.append(output);
                    }
                }
            }
            inputTxt.setText("");

        });

        submitBtn.setPreferredSize(new Dimension(200, 30));
        inputs.add(submitBtn);

        return inputs;
    }

    public Boolean containsNumbers(String input) {
        Boolean isdigit = false;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                isdigit = true;
                break;
            }
        }

        return isdigit;
    }

    public String profanityFilter(String input) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("./censor.txt"));
            String str;
            List<String> lines = new ArrayList<String>();
            while((str = in.readLine()) != null) {
                lines.add(str.trim());
            }
            in.close();

            List<String> words = new ArrayList<String>();
            for (String word : input.split(" ")) {
                words.add(word);
            }

            String[] tempWords = words.toArray(new String[0]);

            for (String x : words) {
                for (String y : lines) {
                    if (x.toLowerCase().contains(y)) {
                        tempWords[words.indexOf(x)] =
                        tempWords[words.indexOf(x)].replace(y, new String(new char[y.length()]).replace("\0", "*"));
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < tempWords.length; i++) {
                sb.append(tempWords[i] + " ");
            }
            String output = sb.toString() + "\n";

            return output;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
        pics.setBorder(new EmptyBorder(40, 10, 10, 10));

        //server orders images according to word and sends to all clients
        //the words are then displayed by the clients, shown below

        ImageIcon word1Icon = new ImageIcon(new ImageIcon("./word1.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
        word1Img = new JLabel();
        word1Img.setIcon(word1Icon);

        pics.add(word1Img);

        ImageIcon word2Icon = new ImageIcon(new ImageIcon("./word2.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
        word2Img = new JLabel();
        word2Img.setIcon(word2Icon);

        pics.add(word2Img);

        ImageIcon word3Icon = new ImageIcon(new ImageIcon("./word3.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
        word3Img = new JLabel();
        word3Img.setIcon(word3Icon);

        pics.add(word3Img);

        return pics;
    }

    private void countDown() {
        timer = new Timer(1000, e -> {
            if (counter > 0) {
                counter--;
                String output = String.format("Time Left To Guess: %s    ", counter);
                timerLbl.setText(output);
            } else {
                if (CreatorLobby.roundNum > 1) {
                    CreatorLobby.roundNum --;
                    DrawingPhase dp = new DrawingPhase();
                    dp.show();
                    guessingFrame.dispose();
                    timer.stop();
                } else {
                    Leaderboard lb = new Leaderboard();
                    lb.show();
                    guessingFrame.dispose();
                    timer.stop();
                }
            }
        });

        timer.setInitialDelay(0);
        timer.start();

    };
}