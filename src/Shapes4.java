import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
///////////////////////////////////////////////////////////////////////
class DrawingPanel extends JPanel {
	int shape = 0;
	public void paint(Graphics g){
		super.paint(g);
		if (shape==1)
 			g.drawLine(50,50,100,100);
	    else if (shape==2)
			g.drawRect(50,50,100,50);
       else  if (shape==3)
 			g.drawOval(50,10,60,60);
 	}	
}
///////////////////////////////////////////////////////////////////////////
 class Shapes4 extends JFrame  implements ActionListener{
	JPanel p1;
	JRadioButton b1, b2, b3;
	ButtonGroup g;
	DrawingPanel p2;
	public Shapes4(){
		super("Simple Shapes");
		p1 = new JPanel();
		b1 = new JRadioButton("Line");
		b2 = new JRadioButton("Rectangle");
		b3 = new JRadioButton("Circle");
		g = new ButtonGroup();
		g.add(b1); g.add(b2); g.add(b3);
		//b1.setSelected(true);
		p1.add(b1); p1.add(b2);p1.add(b3);
		p1.setBackground(Color.cyan);
		add(p1,BorderLayout.NORTH);
		p2 = new DrawingPanel();
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
   			p2.shape =1;
   		else if (event.getSource()==b2)
   			p2.shape =2;
   		else if (event.getSource()==b3)
   			p2.shape =3;
   		
   		p2.repaint();
   	}
   	public static void main(String args[]){
		new Shapes4();	
	}
}
