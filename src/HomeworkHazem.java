import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Carr extends JPanel implements ActionListener {
    Timer timer = new Timer(30, this);
    int centerX = 300;
    int centerY = 300;
    int horizontalPosition = 0;
    int verticalPosition = 0;

    public Carr() {
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
class RandomBalls extends JPanel implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label;
    JTextField textField;
    int numberOfBalls = 0;

    public RandomBalls() {
        setLayout(new BorderLayout());
        panel.setLayout(null);

        textField = new JTextField(10);
        textField.setBounds(355, 10, 100, 30);

        label = new JLabel("Enter Number Of Balls: ");
        label.setBounds(135, 10, 210, 30);

        panel.setBackground(Color.RED);
        panel.setPreferredSize(new Dimension(600, 50));

        panel.add(label);
        panel.add(textField);
        add(panel, BorderLayout.NORTH);

        textField.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int randomX, randomY;
        for (int i = 0; i < numberOfBalls; i++) {
            g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            randomX = (int) (Math.random() * 600);
            randomY = (int) (Math.random() * 600);
            g.fillOval(randomX - 20, randomY + 50, 40, 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (e.getSource() == textField) {
            String text = textField.getText();
            try {
                numberOfBalls = Integer.parseInt(text);
                label.setText("Number entered:         " + numberOfBalls);
            } catch (NumberFormatException ex) {
                label.setText("Invalid input:          " + text);
            }
        }
    }
}
class HexagonExample extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] xPoints = {100, 150, 200, 200, 150, 100};
        int[] yPoints = {150, 100, 150, 200, 250, 200};

        g.drawPolygon(xPoints, yPoints, 6);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hexagon Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.getContentPane().add(new HexagonExample());
            frame.setVisible(true);
        });
    }
}

public class HomeworkHazem extends JFrame {
    int cx = 300, cy = 300;
    JTabbedPane pane;

    public HomeworkHazem() {
        super("Homework Hazem");
        setSize(2 * cx, 2 * cy);
        setVisible(true);
        setLocationRelativeTo(null);
        add(pane = new JTabbedPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.addTab("Carr", new Carr());
        pane.addTab("RandomBalls", new RandomBalls());
        pane.addTab("HexagonExample", new HexagonExample());
    }

    public static void main(String[] args) {
        new HomeworkHazem();
    }
}
