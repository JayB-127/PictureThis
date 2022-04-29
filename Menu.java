import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;

import java.awt.Font;

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
        //Code block below determines max size of text in label depending on size of label -----
        Font labelFont = titleLbl.getFont();
        String labelText = titleLbl.getText();
        int stringWidth = titleLbl.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = titleLbl.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = titleLbl.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        titleLbl.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
        //-----
        content.add(titleLbl);

        size = titleLbl.getSize();
        titleLbl.setBounds(fromLeft(titleLbl) + insets.left, 50 + insets.top, size.width, size.height);


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
        JoinerLobby jl = new JoinerLobby();
        jl.show();
        menuFrame.dispose();
    }

    public Integer fromLeft(JComponent component) {
        Integer fromLeft = 640 - component.getWidth() / 2; //calculates how far along the component should be
        return fromLeft;
    }

}