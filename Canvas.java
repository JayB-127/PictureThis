import javax.swing.JComponent;
import javax.swing.JOptionPane;

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
                } catch ( java.text.ParseException excep ) {
                    //error should not be reached due to disabling of keybaord input on JSpinner
                    JOptionPane.showMessageDialog(null, "Thickness entered is not in the valid range! Enter a thickness within 1 - 50.", "ERROR: Invalid Input", JOptionPane.ERROR_MESSAGE);
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
        graphics2d.setPaint(Color.BLACK);
    }

    public void blue() {
        graphics2d.setPaint(Color.BLUE);
    }

    public void red() {
        graphics2d.setPaint(Color.RED);
    }

    public void green() {
        graphics2d.setPaint(Color.GREEN);
    }

    public void magenta() {
        graphics2d.setPaint(Color.MAGENTA);
    }

    public void setThickness(Integer thickness) {
        graphics2d.setStroke(new BasicStroke(thickness));
    }

}
