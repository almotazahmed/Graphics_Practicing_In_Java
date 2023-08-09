import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Carrr extends JPanel implements ActionListener {
    Timer timer = new Timer(30, this);
    int centerX = 300;
    int centerY = 300;
    int horizontalPosition = 0;
    int verticalPosition = 0;

    public Carrr() {
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.drawLine(0, centerY, 2 * centerX, centerY);

        g.drawOval(horizontalPosition, centerY - 2 * 10, 2 * 10, 2 * 10);
        g.drawOval(horizontalPosition + 50, centerY - 2 * 10, 2 * 10, 2 * 10);

        int[] xBody = {horizontalPosition - 20, horizontalPosition - 20, horizontalPosition + 90, horizontalPosition + 90};
        int[] yBody = {centerY - 13 - verticalPosition, centerY - 33 - verticalPosition, centerY - 33 - verticalPosition, centerY - 13 - verticalPosition};
        g.drawPolygon(xBody, yBody, 4);

        int[] xRoof = {horizontalPosition, horizontalPosition + 18, horizontalPosition + 52, horizontalPosition + 70};
        int[] yRoof = {centerY - 33 - verticalPosition, centerY - 50 - verticalPosition, centerY - 50 - verticalPosition, centerY - 33 - verticalPosition};

        g.fillPolygon(xRoof, yRoof, 4);

        // Move the car horizontally
        horizontalPosition += 5;

        // If the car has reached the end of the screen, reset its position
        if (horizontalPosition > 2 * centerX) {
            horizontalPosition = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}