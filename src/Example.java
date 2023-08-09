import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Example extends JFrame implements ActionListener {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int TIMER_DELAY_MS = 20;
    private static final int MAX_DEGREE = 90;

    private Timer timer;
    private int degree;
    private int x;
    private int y;
    private int xc;
    private int yc;

    public Example(){
        timer = new Timer(TIMER_DELAY_MS, this);
        degree = 9;
        x = 0;
        y = 0;
        xc = 10;
        yc = 250;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        timer.start();
    }

    @Override
    public void paint(Graphics g){
//        super.paint(g);
        updateCoordinates();
        drawLines(g);
    }

    private void updateCoordinates() {
        y = (int)(Math.round(90*Math.sin(degree*x*Math.PI/180)));
        x++;
    }

    private void drawLines(Graphics g) {
        g.setColor(getRandomColor());
        drawLine(g, xc + x, yc - y, xc + x, yc - y);
        drawLine(g, xc + 180 - x, yc - y, xc + 180 - x, yc - y);
        drawLine(g, xc + 180 + x, yc + y, xc + 180 + x, yc + y);
        drawLine(g, xc + 360 - x, yc + y, xc + 360 - x, yc + y);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    private Color getRandomColor() {
        return new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(x <= MAX_DEGREE) {
            repaint();
        } else {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
    }
}
