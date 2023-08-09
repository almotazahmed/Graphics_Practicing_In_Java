import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
////////////////////////////////////////////////////////////////////////
class CirclePanel extends JPanel {
	int xc =250,yc=250,r=100;
	public void paint(Graphics g){
		super.paint(g);
		g.drawOval(xc-r,yc-r,2*r,2*r);
	}
}
/////////////////////////////////////////////////////////////////////
class Shapes8 extends JFrame implements AdjustmentListener{
	CirclePanel p;
	JScrollBar b ;
	public Shapes8(){
		b = new JScrollBar( JScrollBar.HORIZONTAL,100,0,0,200);
		add(b, BorderLayout.NORTH);
		p = new CirclePanel();
		add(p);
		b.addAdjustmentListener(this);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void adjustmentValueChanged(AdjustmentEvent event){
			p.r = b.getValue();
			p.repaint();
	}
	public static void main(String args[]){
		new Shapes8();
		
	}
}