import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;

import java.awt.Font;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu {
    
    JFrame menuFrame = new JFrame("Main Menu");
    JButton createGameBtn, joinGameBtn, quitGameBtn;
    JLabel titleLbl;

    public static void main(String[] args) {
        new Menu().show();
    }

    public void show() {

        Container content = menuFrame.getContentPane();
        content.setLayout(null);

        Insets insets = content.getInsets();
        Dimension size;


        //TITLE LABEL
        titleLbl = new JLabel("Picture This!", JLabel.CENTER);
        titleLbl.setSize(700, 200);
        titleLbl.setFont(titleLbl.getFont().deriveFont(Font.PLAIN, 110f));
        content.add(titleLbl);

        size = titleLbl.getSize();
        titleLbl.setBounds(fromLeft(titleLbl) + insets.left, 70 + insets.top, size.width, size.height);


        //CREATE GAME BUTTON
        createGameBtn = new JButton("Create New Game");
        createGameBtn.setSize(400, 50);
        createGameBtn.addActionListener(e -> {
            createGame();
        });
        content.add(createGameBtn);

        size = createGameBtn.getSize();
        createGameBtn.setBounds(fromLeft(createGameBtn) + insets.left, 300 + insets.top, size.width, size.height);


        //JOIN GAME BUTTON
        joinGameBtn = new JButton("Join Existing Game");
        joinGameBtn.setSize(400, 50);
        joinGameBtn.addActionListener(e -> {
            joinGame();
        });
        content.add(joinGameBtn);

        size = joinGameBtn.getSize();
        joinGameBtn.setBounds(fromLeft(joinGameBtn) + insets.left, 370 + insets.top, size.width, size.height);


        //QUIT GAME BUTTON
        quitGameBtn = new JButton("Exit To Desktop");
        quitGameBtn.setSize(400, 50);
        quitGameBtn.addActionListener(e -> {
            menuFrame.dispose();
        });
        content.add(quitGameBtn);

        size = quitGameBtn.getSize();
        quitGameBtn.setBounds(fromLeft(quitGameBtn) + insets.left, 440 + insets.top, size.width, size.height);


        menuFrame.setSize(1280, 720);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
        menuFrame.setResizable(false);

    }

    public void createGame() {
        CreatorLobby cl = new CreatorLobby();
        cl.show();
        menuFrame.dispose();
    }

    public void joinGame() {
        String gameCode = (String) JOptionPane.showInputDialog(
            menuFrame,
            "Enter a valid game code to join a game:",
            "Enter A Game Code",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            ""
        );
        
        if (gameCode == null) {
            //'CANCEL' option
        } else {
            //'OK' option

            if (gameCode.length() == 5 && gameCode.matches("^[A-Z0-9]*$")) {
                Boolean found = false;

                try {
                    FileReader freader = new FileReader("D:\\GitHub Repos\\Menu-Interface-Test\\codes.txt");
                    BufferedReader breader = new BufferedReader(freader);

                    String line = null;
                    while ((line = breader.readLine()) != null) {
                        if (line.trim().equals(gameCode.trim())) {
                            found = true;
                        }
                    }

                    breader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (found == true) {
                    JoinerLobby jl = new JoinerLobby();
                    jl.show();
                    menuFrame.dispose();
                    //TODO: player connected to game thread on server
                } else {
                    JOptionPane.showMessageDialog(
                        menuFrame,
                        "The game code entered does not match an existing game code.\nPlease enter a game code of a current game.",
                        "ERROR: Game code does not exist",
                        JOptionPane.ERROR_MESSAGE
                    );
                }

            } else {
                JOptionPane.showMessageDialog(
                    menuFrame,
                    "The game code entered is not in the correct format.\nPlease enter a game code of a valid format.",
                    "ERROR: Invalid game code",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public Integer fromLeft(JComponent component) {
        //Determines where the component should be placed horizontally so that it appears in the middle
        Integer fromLeft = 640 - component.getWidth() / 2;
        return fromLeft;
    }

}