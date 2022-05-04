import javax.swing.JComponent;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BasicStroke;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Canvas extends JComponent {

    private Image image;
    private Graphics2D graphics2d;

    private int oldx, currentx, oldy, currenty;

    public Canvas() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldx = e.getX();
                oldy = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentx = e.getX();
                currenty = e.getY();

                try {
                    DrawingPhase.thicknessSpin.commitEdit();
                } catch (java.text.ParseException excep) {
                    //error should not be reached due to disabling of keybaord input on JSpinner
                    System.out.println(excep);
                }

                int value = (Integer) DrawingPhase.thicknessSpin.getValue();
                setThickness(value);

                if (graphics2d != null) {
                    graphics2d.drawLine(oldx, oldy, currentx, currenty);
                    repaint();
                    oldx = currentx;
                    oldy = currenty;
                }

            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            image = createImage(getWidth(), getHeight()); //size of canvas component
            graphics2d = (Graphics2D) image.getGraphics();
            graphics2d.setStroke(new BasicStroke(3));
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        Color oldColour = graphics2d.getColor();
        graphics2d.setPaint(Color.WHITE);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
        graphics2d.setPaint(oldColour);
        repaint();
    }

    public void erase() {
        graphics2d.setPaint(Color.WHITE);
    }

    public void black() {
        graphics2d.setPaint(Color.decode("#000"));
    }

    public void grey() {
        graphics2d.setPaint(Color.decode("#757575"));
    }

    public void brown() {
        graphics2d.setPaint(Color.decode("#8c4420"));
    }

    public void red() {
        graphics2d.setPaint(Color.decode("#eb3434"));
    }

    public void orange() {
        graphics2d.setPaint(Color.decode("#ff7912"));
    }

    public void yellow() {
        graphics2d.setPaint(Color.decode("#ffde38"));
    }

    public void green() {
        graphics2d.setPaint(Color.decode("#17e658"));
    }

    public void lightBlue() {
        graphics2d.setPaint(Color.decode("#0fcfff"));
    }

    public void darkBlue() {
        graphics2d.setPaint(Color.decode("#1f1bf7"));
    }

    public void pink() {
        graphics2d.setPaint(Color.decode("#fc65f7"));
    }

    public void purple() {
        graphics2d.setPaint(Color.decode("#b005ff"));
    }

    public void setThickness(Integer thickness) {
        graphics2d.setStroke(new BasicStroke(thickness));
    }

}
