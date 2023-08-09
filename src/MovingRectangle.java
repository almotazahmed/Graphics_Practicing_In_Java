import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MovingRectangle extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int RECT_WIDTH = 50;
    private static final int RECT_HEIGHT = 50;
    private static final int POINTS = 100;
    private static final double ROTATION_ANGLE = Math.toRadians(5);

    private double[] xPoints;
    private double[] yPoints;
    private int currentPointIndex = 0;
    private Rectangle2D rectangle;

    public MovingRectangle() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // generate the points for the smooth crooked line
        xPoints = new double[POINTS];
        yPoints = new double[POINTS];
        for (int i = 0; i < POINTS; i++) {
            double x = i * ((double) WIDTH / POINTS);
            double y = HEIGHT / 2 + Math.sin(Math.toRadians(x * 10)) * HEIGHT / 4;
            xPoints[i] = x;
            yPoints[i] = y;
        }

        // set the initial position of the rectangle to the first point on the line
        rectangle = new Rectangle2D.Double(xPoints[currentPointIndex], yPoints[currentPointIndex], RECT_WIDTH, RECT_HEIGHT);

        // set up a timer to move the rectangle
        Timer timer = new Timer(20, e -> {
            // move the rectangle to the next point on the line
            currentPointIndex = (currentPointIndex + 1) % POINTS;
            double newX = xPoints[currentPointIndex];
            double newY = yPoints[currentPointIndex];
            // translate the rectangle so that its top-left corner is at the origin
            AffineTransform transform1 = AffineTransform.getTranslateInstance(-rectangle.getX(), -rectangle.getY());
            // rotate the rectangle by ROTATION_ANGLE around the origin
            AffineTransform transform2 = AffineTransform.getRotateInstance(ROTATION_ANGLE);
            // translate the rectangle back to its original position
            AffineTransform transform3 = AffineTransform.getTranslateInstance(newX, newY);
            // apply the transformations to the rectangle
            transform1.concatenate(transform2);
            transform1.concatenate(transform3);
            rectangle = transform1.createTransformedShape(rectangle).getBounds2D();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // draw the line
        g2d.drawPolyline(toIntArray(xPoints), toIntArray(yPoints), POINTS);
        // draw the rectangle
        g2d.fill(rectangle);
    }

    private int[] toIntArray(double[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (int) array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MovingRectangle());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

