import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
///////////////////////////////////////////////////////////
class Pendulum extends JFrame implements ActionListener {
 	Timer t;
 	int xc =150, yc =150,x,y;
 	double a = 0;
 	int r = 100;
 	boolean flag = true;
 	public Pendulum(){
 		t = new Timer (100,this);
 		t.start();
 		setSize(300,300);
 		setVisible(true);
 		setResizable(false);
 		setLocation(200,200);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}
	public void paint(Graphics g) {
    	super.paint(g);
    	x = (int)(r*Math.cos(a*Math.PI/180));
    	y = (int)(r*Math.sin(a*Math.PI/180));
    	g.setColor(Color.blue);
    	g.drawLine(xc, yc, xc+x, yc+y);
    	g.setColor(Color.black);
    	g.fillRect(xc - 3, yc - 3, 9, 9);
    	g.setColor(Color.red);
    	g.fillOval(xc+x-10, yc+y - 10, 20, 20);
  	}
 	public void actionPerformed(ActionEvent event) {
 		if (a==180)
	   		flag = false;
	   else if(a==0)
	   		flag =true;
	   if (!flag)
	   	  a-=5;
	   	else if(flag)
	   		a+=5;	
	   repaint();
  }
  public static void main(String[] args) {
    new Pendulum();
  }
}