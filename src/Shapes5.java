import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
///////////////////////////////////////////////////////////
class DrawingPanel_2 extends JPanel {
	boolean circle =false, rectangle =false, line =false;
	public void paint(Graphics g){
		if (line)
 			g.drawLine(50,50,100,100);
	     if (rectangle)
			g.drawRect(50,50,100,50);
         if (circle)
 			g.drawOval(50,10,60,60);
	}	
}
///////////////////////////////////////////////////////////
 class Shapes5 extends JFrame  implements ActionListener{
	JMenuBar menubar;
	JMenu shapesmenu,colormenu;
	JCheckBoxMenuItem line, rectangle,circle;
	DrawingPanel_2 p;
	public Shapes5(){
		super("Simple Shapes");
		menubar = new JMenuBar();
		menubar.add(shapesmenu=new JMenu("Shapes"));
		shapesmenu.add(line = new JCheckBoxMenuItem("Line"));
		shapesmenu.add(rectangle = new JCheckBoxMenuItem("Rectangle"));
		shapesmenu.add(circle = new JCheckBoxMenuItem("Circle"));
		add(menubar,BorderLayout.NORTH);
		add(p = new DrawingPanel_2());
		line.addActionListener(this);
		rectangle.addActionListener(this);
		circle.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   	public void actionPerformed(ActionEvent event){
   		
   		if (event.getSource()==line )
   				p.line =line.isSelected();  
   		else if (event.getSource()==rectangle)
   			p.rectangle =rectangle.isSelected(); 
   	   else if (event.getSource()==circle)
   	    		p.circle = circle.isSelected();
   			
		p.repaint();
   	}
   	public static void main(String args[]){
		new Shapes5();	
	}
}
///////////////////////////////////////////////////////////