import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
////////////////////////////////////////////////////////////////////////////
class DrawingPanel_2 extends JPanel {
	boolean line = false, rectangle = false, circle = false;
	public void paint(Graphics g){
		super.paint(g);
		if (line)
 			g.drawLine(100,100,200,200);
	    if (rectangle)
			g.drawRect(100,100,100,50);
       	if (circle)
 			g.drawOval(100,100,100,100);
 		}	
}
/////////////////////////////////////////////////////////////////////////////////
class Shapes6 extends JFrame  implements ActionListener{
	JPanel p1;
	JCheckBox b1, b2, b3;
	DrawingPanel_2 p2;
	public Shapes6(){
		super("Simple Shapes");
		p1 = new JPanel();
		b1 = new JCheckBox("Line");
		b2 = new JCheckBox("Rectangle");
		b3 = new JCheckBox("Circle");
		p1.setBackground(Color.cyan);
		p1.add(b1); p1.add(b2);p1.add(b3);
		add(p1,BorderLayout.NORTH);
		p2 = new DrawingPanel_2();
		add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   	public void actionPerformed(ActionEvent event){
   		if (event.getSource()==b1)
   			p2.line = b1.isSelected();
   		else if (event.getSource()==b2)
   			p2.rectangle = b2.isSelected();
   		else if (event.getSource()==b3)
   			p2.circle = b3.isSelected();
   		p2.repaint();
   	}
   	public static void main(String args[]){
		new Shapes6();	
	}
}
