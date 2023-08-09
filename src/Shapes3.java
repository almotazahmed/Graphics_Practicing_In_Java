import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
//////////////////////////////////////////////////////////////////////////////////////////////
class DrawingPanel extends JPanel {
	int shape = 0;
	public void paint(Graphics g){
		super.paint(g);
		if (shape==1) 
			g.drawLine(50,50,100,100);
		else if (shape==2) 
			g.drawRect(50,50,100,50);
 		else if (shape==3) 
 			g.drawOval(50,10,60,60);
 	}	
}
//////////////////////////////////////////////////////////////////////////////////////////////
class Shapes3 extends JFrame  implements ActionListener{   
	JMenuBar menubar;
	JMenu shapesmenu; 
	JRadioButtonMenuItem line, rectangle,circle;
	ButtonGroup g; 
	DrawingPanel p;
	public Shapes3(){
		super("Simple Shapes");
		menubar = new JMenuBar();
		menubar.add(shapesmenu=new JMenu("Shapes"));
		g = new ButtonGroup();
		shapesmenu.add(line = new JRadioButtonMenuItem("Line"));
		g.add(line);
		shapesmenu.add(rectangle = new JRadioButtonMenuItem("Rectangle"));
		g.add(rectangle);
		shapesmenu.add(circle = new JRadioButtonMenuItem("Circle"));
		g.add(circle);
		add(menubar,BorderLayout.NORTH);
		add(p = new DrawingPanel());
		line.addActionListener(this);
		rectangle.addActionListener(this);
		circle.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   	public void actionPerformed(ActionEvent event){
   		if (event.getSource()==line)
   			p.shape = 1;
   		else if (event.getSource()==rectangle)
   			p.shape = 2;
   		else if (event.getSource()==circle)
   			p.shape = 3;
		p.repaint();
   	}
   	public static void main(String args[]){
		new Shapes3();	
	}
}
