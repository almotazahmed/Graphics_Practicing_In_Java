import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;
public class DrawHexagonal extends JFrame{

	int xc=400, yc=400;
	int xIndeces1[];
	int yIndeces1[];
	int l=200;
	int r=15;
	public DrawHexagonal() {
		super("Hexagonal");
		setSize(2*xc,2*yc);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		drawHexagonal(g, l, xc, yc, r);

		int xIndeces1[] = {xc-l, (int)Math.round(xc-0.5*l), (int)Math.round(xc+0.5*l), xc+l, (int)Math.round(xc+0.5*l), (int)Math.round(xc-0.5*l)};
		int yIndeces1[] = {yc,(int)Math.round(yc-Math.sqrt(3)/2*l), (int)Math.round(yc-Math.sqrt(3)/2*l), yc, (int)Math.round(yc+Math.sqrt(3)/2*l), (int)Math.round(yc+Math.sqrt(3)/2*l)};

		for(int i=0; i<6; i++)drawHexagonal(g, (int)Math.round(.25*l), xIndeces1[i], yIndeces1[i], (int)Math.round(.5*r));
		drawHexagonal(g, (int)Math.round(.25*l), xc, yc, (int)Math.round(.5*r));
	}
	public void drawHexagonal(Graphics g, int l, int x, int y, int r) {
		int xIndeces[] = {x-l, (int)Math.round(x-0.5*l), (int)Math.round(x+0.5*l), x+l, (int)Math.round(x+0.5*l), (int)Math.round(x-0.5*l)};
		int yIndeces[] = {y,(int)Math.round(y-Math.sqrt(3)/2*l), (int)Math.round(y-Math.sqrt(3)/2*l), y, (int)Math.round(y+Math.sqrt(3)/2*l), (int)Math.round(y+Math.sqrt(3)/2*l)};
//		z

		g.setColor(randomColor());
		g.fillPolygon(xIndeces, yIndeces, 6);
		
		for(int i=0; i<3; i++) {
			g.setColor(randomColor());
			g.drawLine(xIndeces[i], yIndeces[i], xIndeces[i+3], yIndeces[i+3]);
		}
		
		
		for(int i=0; i<6; i++) {
			g.setColor(randomColor());
			g.fillOval(xIndeces[i]-(int)Math.round(.5*r), yIndeces[i]-(int)Math.round(.5*r), r, r);
		}
		g.setColor(randomColor());
		g.fillOval(x-(int)Math.round(.5*r), y-(int)Math.round(.5*r), r, r);
	}
	
	public Color randomColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		return new Color(red, green, blue);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawHexagonal();
	}

}
