import java.awt.*;
import javax.swing.*;
/////////////////////////////////////////////////////////////////////////////////
class LineDrawing extends JPanel{
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.drawLine(50,50,100,100);
	}
}
class SquareDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.red);
		g.drawRect(50,50,200,200);
  	}
}
class RectangleDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.red);
		g.fillRect(200,100,100,200);
  	}
} 
class CircleDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.magenta);
		g.drawOval(100,100,200,200);	
  	}
 }
class EllipseDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.magenta);
		g.fillOval(200,100,80,200);
  	} 
}
/////////////////////////////////////////////////////////////////////////////////////////
class Shapes2 extends JFrame {
	JTabbedPane pane;
	public  Shapes2(){
		super("Simple Shapes");
		add(pane  = new  JTabbedPane());
		pane.addTab("Line" ,new LineDrawing());
		pane.addTab("Square" ,new SquareDrawing());
		pane.addTab("Rectangle" ,new RectangleDrawing());
		pane.addTab("Circle" ,new CircleDrawing());
		pane.addTab("Ellipse" ,new EllipseDrawing());
		setSize(400,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public static void main(String args[]){
		new Shapes2();
		
	}
}