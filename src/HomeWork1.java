import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HomeWork1 extends JFrame implements ActionListener {
	private JComboBox<String> comboBox;

	public HomeWork1() {
		super("Homework One!");
		setLayout(new FlowLayout());
		add(new JLabel("Choose the Shape"));

		String[] shapes = { "None", "Shape 1", "Shape 2", "Shape 3", "Shape 4", "Shape 5" };
		comboBox = new JComboBox<>(shapes);
		comboBox.addActionListener(this);
		add(comboBox);

		setSize(500, 500);
		setLocation(500, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void drawShape1(Graphics g) {
		super.paint(g);

		int xc = 250, yc = 250, r = 100;
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];

		for (int i = 0; i < 6; i++) {
			double angle = i * 60 * Math.PI / 180.0;
			xPoints[i] = (int) (xc + r * Math.cos(angle));
			yPoints[i] = (int) (yc + r * Math.sin(angle));
		}

		g.setColor(new Color(255, 0, 255));
		for (int i = 0; i < 6; i++) {
			int nextIndex = (i + 1) % 6;
			g.drawLine(xPoints[i], yPoints[i], xPoints[nextIndex], yPoints[nextIndex]);
		}

		g.setColor(new Color(0, 255, 255));
		g.drawPolygon(xPoints, yPoints, 6);

		g.setColor(Color.black);
		for (int i = 0; i < 3; i++) {
			int startIndex = i * 2;
			int endIndex = (i * 2 + 3) % 6;
			g.drawLine(xPoints[startIndex], yPoints[startIndex], xPoints[endIndex], yPoints[endIndex]);
		}
		g.setColor(new Color(255, 0, 0));
		for (int i = 0; i < 6; i++) {
			g.fillOval(xPoints[i] - 5, yPoints[i] - 5, 10, 10);
		}
	}

	void drawShape2(Graphics g) {
		super.paint(g);

		g.setColor(Color.black);

		g.drawLine(244, 184, 319, 184);
		g.drawLine(319, 184, 319, 214);
		g.drawLine(274, 214, 319, 214);
		g.drawLine(274, 214, 274, 244);
		g.drawLine(274, 244, 304, 244);
		g.drawLine(304, 244, 304, 274);
		g.drawLine(274, 274, 304, 274);
		g.drawLine(274, 274, 274, 334);
		g.drawLine(244, 334, 274, 334);
		g.drawLine(244, 184, 244, 334);
	}

	void drawShape3(Graphics g) {
		super.paint(g);

		g.setColor(new Color(139, 69, 19));
		g.fillRect(241, 240, 18, 155);

		g.setColor(Color.green);
		g.fillOval(210, 110, 80, 170);
	}

	void drawShape4(Graphics g) {
		super.paint(g);
		// Draw outer rectangle
		g.drawRect(114, 114, 272, 272);

		// Draw blue oval
		g.setColor(Color.blue);
		g.fillOval(182, 182, 136, 136);

		// Draw red circles
		g.setColor(Color.red);
		int circleSize = 68;
		int circleOffset = 34; // Half of the circle size
		g.fillOval(114, 216, circleSize, circleSize);
		g.fillOval(216, 114, circleSize, circleSize);
		g.fillOval(318, 216, circleSize, circleSize);
		g.fillOval(216, 318, circleSize, circleSize);
	}

	void drawShape(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLUE);
		g.drawRect(100, 150, 300, 200);

		g.setColor(Color.RED);

		for (int horizontalPosition = 0; horizontalPosition < 50; horizontalPosition += 10) {
			g.drawOval(250, 150 + horizontalPosition, 150 - 2 * horizontalPosition, 200 - 2 * horizontalPosition);
			g.drawOval(100 + 2 * horizontalPosition, 150 + horizontalPosition, 150 - 2 * horizontalPosition,
					200 - 2 * horizontalPosition);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		switch (comboBox.getSelectedIndex()) {
			case 1:
				drawShape1(g);
				break;
			case 2:
				drawShape2(g);
				break;
			case 3:
				drawShape3(g);
				break;
			case 4:
				drawShape4(g);
				break;
			case 5:
				drawShape(g);
				break;
		}
	}

	public void actionPerformed(ActionEvent event) {
		repaint();
	}

	public static void main(String args[]) {
		new HomeWork1();
	}
}
