import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/////////////////////////////////////////////////////////////////////////////
class LineDrawing extends JPanel{
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.drawLine(20,20,100,100);
	}
}
class SquareDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.red);
		g.drawRect(20,20,100,100);
  	}
}
class RectangleDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.red);
		g.fillRect(20,20,100,200);
  	}
} 
class CircleDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.magenta);
		g.drawOval(20,20,100,100);	
  	}
 }
class EllipseDrawing extends JPanel{
	public void paint(Graphics g){
 		g.setColor(Color.magenta);
		g.fillOval(20,20,80,140);
  	} 
}
/////////////////////////////////////////////////////////////////////////////////
class Shapes10 extends JFrame  implements ActionListener{
	JPanel p1,p2;
	JCheckBox b1, b2, b3,b4,b5;
	JPanel line,square,rectangle,circle,ellipse;
	public Shapes10(){
		super("Simple Shapes");
		p1 = new JPanel();
		b1 = new JCheckBox("Line");
		b2 = new JCheckBox("Square");
		b3 = new JCheckBox("Rectangle");
		b4 = new JCheckBox("Circle");
		b5 = new JCheckBox("Ellipse");	
		
		p1.setBackground(Color.cyan);
		p1.add(b1); p1.add(b2);p1.add(b3);p1.add(b4);p1.add(b5);
		add(p1,BorderLayout.NORTH);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,3));
		add(p2);
		
		p2.add(line=new LineDrawing());
		line.setVisible(false);
		
		p2.add(square= new SquareDrawing());
		square.setVisible(false);
		
		p2.add(rectangle= new RectangleDrawing());
		rectangle.setVisible(false);
		
		p2.add(circle= new CircleDrawing());
		circle.setVisible(false);
		
		p2.add(ellipse= new EllipseDrawing());
		ellipse.setVisible(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   	public void actionPerformed(ActionEvent event){
   		if (event.getSource()==b1)
   			line.setVisible(b1.isSelected());
   	     if (event.getSource()==b2)
   			square.setVisible(b2.isSelected());
   		 if (event.getSource()==b3)
   			rectangle.setVisible(b3.isSelected());
   		 if (event.getSource()==b4)
   			circle.setVisible(b4.isSelected());
   		 if (event.getSource()==b5)
   			ellipse.setVisible(b5.isSelected());
   		repaint();	
   		 
   	}
   	public static void main(String args[]){
		new Shapes10();	
	}
}
