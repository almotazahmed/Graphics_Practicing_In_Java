import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
////////////////////////////////////////////////////////////////////
class CirclePanel extends JPanel {
	int xc =250,yc=250,r=100;
	public void paint(Graphics g){
		super.paint(g);
		g.drawOval(xc-r,yc-r,2*r,2*r);
	}
}
//////////////////////////////////////////////////////////////////////////
class Shapes7 extends JFrame implements ChangeListener{
	CirclePanel p;
	JSlider j;
	public Shapes7(){
	     j= new JSlider(JSlider.HORIZONTAL,0, 200, 100);
		add(j, BorderLayout.NORTH);
		p = new CirclePanel();
		add(p);
		j.setMajorTickSpacing(20);
		j.setMinorTickSpacing(10);
		j.setPaintTicks(true);	
		j.setPaintLabels(true);
    	j.addChangeListener(this);
		setSize(500,550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void stateChanged(ChangeEvent event) {
    	p.r = ((JSlider)event.getSource()).getValue();
		p.repaint();
	}
	public static void main(String args[]){
		new Shapes7();
		
	}
}