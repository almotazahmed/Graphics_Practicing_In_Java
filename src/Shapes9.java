import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
class Shapes9 extends JFrame implements ActionListener{
	JPanel p = new JPanel();
	JScrollPane pane =new JScrollPane();	
	JComboBox comboBox;
	
	public  Shapes9(){
		super("Simple Shapes");
	    p.setLayout(new FlowLayout());
		p.add(new JLabel("Choose the Shape"));
		String [] shapes ={"None", "Line", "Square" ,"Rectangle", "Circle", "Ellipse"};
		comboBox = new JComboBox (shapes);
		p.add(comboBox);
		comboBox.addActionListener(this);
	
		add(p,BorderLayout.NORTH);
		add(pane);
		
	
	    setSize(400,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public void actionPerformed(ActionEvent event ){
	   	if (comboBox.getSelectedIndex() ==0)
	   		pane.setViewportView(null);
		if (comboBox.getSelectedIndex() ==1)
	       pane.setViewportView(new  LineDrawing());
		else if (comboBox.getSelectedIndex()==2)
			pane.setViewportView(new SquareDrawing());
		else if (comboBox.getSelectedIndex()==3)
			pane.setViewportView(new RectangleDrawing());
		else if (comboBox.getSelectedIndex()==4)
			pane.setViewportView(new CircleDrawing());
		else if (comboBox.getSelectedIndex()==5)
			pane.setViewportView(new EllipseDrawing());
			
			
	}
	public static void main(String args[]){
		new Shapes9();
		
	}
}