import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class OvalDrawing extends JFrame implements ActionListener{
//	int xc=250, yc=250, r=100, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6;
	int xc=250, yc=250, r=150, x, y;
	Timer t;
	double a=0;
	public OvalDrawing() {
		super("Oval Drawing");
		t = new Timer(1, this);
		t.start();
		setSize(500,500);
		setVisible(true);
//		getGraphics().drawLine(0, 250, 499, 250);
//		getGraphics().drawLine(250, 0, 250, 499);
	}
	public void paint(Graphics g) {
//		super.paint(g);
		
//		g.drawLine(0, yc, 499, yc);
//		g.drawLine(xc, 0, xc, 499);
//		for(double a=0; a<=360; a+=1) {
//			x = (int)(Math.round(r*Math.cos(a * Math.PI / 180)));
//			y = (int)(Math.round(r*Math.sin(a * Math.PI / 180)));
//			g.drawLine(xc+x, yc+y,xc+x, yc+y);
//		}
//		g.setColor(Color.BLUE);
//		g.drawRect(100,150,300,200);
//		g.setColor(Color.RED);
//		for(int x=0; x<50; x+=10) {
//			g.drawOval(250, 150+x, 150-2*x, 200-2*x);
//			g.drawOval(100+2*x, 150+x, 150-2*x, 200-2*x);
//		}
//		g.drawOval(250, 150, 150, 200);
//		g.drawOval(250, 160, 130, 180);
//		g.drawOval(250, 170, 110, 160);
		x = (int)Math.round(r*Math.cos(a*Math.PI/180));
		y = (int)Math.round(r*Math.sin(a*Math.PI/180));
		g.drawLine(0, 249, 499, 249);
		g.drawLine(249, 0, 249, 499);
		g.setColor(Color.red);
		g.drawLine(xc+x, yc+y, xc+x, yc+y);
		g.setColor(Color.blue);
		g.drawLine(xc+x, yc-y, xc+x, yc-y);
		g.setColor(Color.cyan);
		g.drawLine(xc+y, yc-x, xc+y, yc-x);
		g.setColor(Color.green);
		g.drawLine(xc-y, yc-x, xc-y, yc-x);
		g.setColor(Color.darkGray);
		g.drawLine(xc-x, yc-y, xc-x, yc-y);
		g.setColor(Color.magenta);
		g.drawLine(xc-x, yc+y, xc-x, yc+y);
		g.setColor(Color.orange);
		g.drawLine(xc-y, yc+x, xc-y, yc+x);
		g.setColor(Color.pink);
		g.drawLine(xc+y, yc+x, xc+y, yc+x);
//		g.drawOval(175, 175, 150, 150);
//		g.drawOval(100, 100, 300, 300);
		
	}
	public void actionPerformed(ActionEvent even) {
		if(a<=45) {
			repaint();
		}
		else{
			t.stop();
		}
		a+=.1;
	}
	public static void main(String [] args) {
		new OvalDrawing();
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
////		x = (int)(Math.round(r*Math.cos(a * Math.PI / 180)));
////		y = (int)(Math.round(r*Math.sin(a * Math.PI / 180)));
//		if(a<=360) {
////			getGraphics().drawLine(xc+x, yc+y,xc+x, yc+y);
//			repaint();
//		}
//		else {
//			t.stop();
//		}
//		a++;
//	}
}
