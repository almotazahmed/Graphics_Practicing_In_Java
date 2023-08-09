
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
public class CarOnRoad extends JFrame implements ActionListener{
	//The center of the frame..
	int xc=10, yc=150;
	int x=0;
	
	//The radius of the smaller main cycle..
	int r1=75; 
	
	//The radius of the bigger main cycle..
	int r2=200;
	
	// Radius of the small cycle in the Tires..
	int smallCycleRadiusOfTires=3;
	
	// Radius of the big cycle in the Tires..
	int bigCycleRadiusOfTires=10;	
	 
	//The center points to the tires..
	int tireX1=0, tireX2=20, tireY1, tireY2;
	
	// Points to draw the lines in the tires..
    int n11, m11, n31, m31, n12, m12, n32, m32, n13, m13, n33, m33, n14, m14, n34, m34; 
    
    // The angles of the four lines in the two tires..
 	int a1=0, a2=180, a3=90, a4=270;

	// Points to draw the car body..
	int cx11, cy11, cx12, cy12, cx13, cy13, cx14, cy14, cx21, cy21, cx22, cy22, cx23, cy23, cx24, cy24;
	
	//The main angle two move the car around the bigger cycle..
	int mainAngle=0;
	
	// Timer for moving the car..
	Timer t;
	
	// counter to up and down the car body according to this counter..
	int count=0;
	
	// Flags for Move the car forward and backward..
	boolean flag = true, flag2 = true;
	
	// To determine how many we want to up and down the car body..
	int upAndDown=0;
	
	// The starting point of the arrow..
	int arrowAngle=0;
	
	//Points for drawing the arrow..
	int arrowX1, arrowY1, arrowX2, arrowY2, arrowX3, arrowY3;
	
	int aaa = 0;
	int xxx, yyy, xxx2, yyy2;
	int distanceBetween;
	int distance;
	
//	Graphics2D g2d;
	
	public CarOnRoad() {
		super("Car On The Road");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		t = new Timer(1, this);
		t.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		int y=0;
		for(int x=0;x<=getWidth();x++) {
			y = (int)(45*Math.sin(x*Math.PI/180));
			g.drawLine(xc+x, yc-y, xc+x, yc-y);
		}
//		g.drawLine(0,yc,getWidth(),yc);
//		g.drawLine(xc, 0, xc, getHeight());
//		g.setColor(Color.red);
//		g.drawArc(xc-100,yc-60,200,200,20,140);
//		g.setColor(Color.blue);
//		xxx=(int)Math.round((100)*Math.cos((-20)*Math.PI/180));
//		yyy=(int)Math.round((100)*Math.sin((-20)*Math.PI/180));
//
//		xxx2=(int)Math.round((100)*Math.cos((-160)*Math.PI/180));
//		yyy2=(int)Math.round((100)*Math.sin((-160)*Math.PI/180));
//		
//		distanceBetween = (int)(Math.round(Math.sqrt(Math.pow(xxx2-xxx, 2)+Math.pow(yyy-yyy2, 2))));
//		distance = (getWidth()-distanceBetween)/2;
//		System.out.println(distance);
//		g.drawLine(xxx+xc, yyy+yc+40, xxx+xc+distance, yyy+yc+40);
//		g.drawLine(xxx2+xc, yyy2+yc+40, xxx2+xc-distance, yyy2+yc+40);
		
		
		
//		System.out.println(xxx+xc + " " + yyy+yc);
		
		////////////////////////////////////////////////////////////////////
		///////////////////////////  Tires  ////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		g.setColor(Color.blue);
				
		// Determine the X and Y axis to the middle point to the first car tire..
		tireX1=mainAngle;
		tireY1=(int)(45*Math.sin(mainAngle*Math.PI/180))+bigCycleRadiusOfTires;
		
		// Determine the X and Y axis to the middle point to the second car tire..
		tireX2=mainAngle+45;
		tireY2=(int)(45*Math.sin((mainAngle+45)*Math.PI/180))+bigCycleRadiusOfTires;
		
		// Drawing the first tire with two cycles..
		g.drawOval(xc+tireX1-bigCycleRadiusOfTires, yc-tireY1-bigCycleRadiusOfTires, 2*bigCycleRadiusOfTires, 2*bigCycleRadiusOfTires);
		g.drawOval(xc+tireX1-smallCycleRadiusOfTires, yc-tireY1-smallCycleRadiusOfTires, 2*smallCycleRadiusOfTires, 2*smallCycleRadiusOfTires);
		
		// Drawing the second tire with two cycles..
		g.drawOval(xc+tireX2-bigCycleRadiusOfTires, yc-tireY2-bigCycleRadiusOfTires, 2*bigCycleRadiusOfTires, 2*bigCycleRadiusOfTires);
		g.drawOval(xc+tireX2-smallCycleRadiusOfTires, yc-tireY2-smallCycleRadiusOfTires, 2*smallCycleRadiusOfTires, 2*smallCycleRadiusOfTires);
		
		/******************************************************************/
		
		
		////////////////////////////////////////////////////////////////////
		//////////////////   Tires Lines In Red Color   ////////////////////
		////////////////////////////////////////////////////////////////////
		
		g.setColor(Color.red);
				
		// Determine the points to draw the first line in the two tires..
		n11=(int)Math.round(smallCycleRadiusOfTires*Math.cos((a1)*Math.PI/180));
		m11=(int)Math.round(smallCycleRadiusOfTires*Math.sin((a1)*Math.PI/180));
		n31=(int)Math.round(bigCycleRadiusOfTires*Math.cos((a1)*Math.PI/180));
		m31=(int)Math.round(bigCycleRadiusOfTires*Math.sin((a1)*Math.PI/180));
		
		// Draw the first line in tire one..
		g.drawLine(xc+tireX1+n11, yc-tireY1+m11, xc+tireX1+n31, yc-tireY1+m31);
		
		// Draw the first line in tire two..
		g.drawLine(xc+tireX2+n11, yc-tireY2+m11, xc+tireX2+n31, yc-tireY2+m31);
		
		// Determine the points to draw the second line in the two tires..
		n12=(int)Math.round(smallCycleRadiusOfTires*Math.cos((a2)*Math.PI/180));
		m12=(int)Math.round(smallCycleRadiusOfTires*Math.sin((a2)*Math.PI/180));
		n32=(int)Math.round(bigCycleRadiusOfTires*Math.cos((a2)*Math.PI/180));
		m32=(int)Math.round(bigCycleRadiusOfTires*Math.sin((a2)*Math.PI/180));
		
		// Draw the second line in tire one..
		g.drawLine(xc+tireX1+n12, yc-tireY1+m12, xc+tireX1+n32, yc-tireY1+m32);
		
		// Draw the second line in tire two..
		g.drawLine(xc+tireX2+n12, yc-tireY2+m12, xc+tireX2+n32, yc-tireY2+m32);

		
		// Determine the points to draw the third line in the two tires..
		n13=(int)Math.round(smallCycleRadiusOfTires*Math.cos((a3)*Math.PI/180));
		m13=(int)Math.round(smallCycleRadiusOfTires*Math.sin((a3)*Math.PI/180));
		n33=(int)Math.round(bigCycleRadiusOfTires*Math.cos((a3)*Math.PI/180));
		m33=(int)Math.round(bigCycleRadiusOfTires*Math.sin((a3)*Math.PI/180));
		
		// Draw the third line in tire one..
		g.drawLine(xc+tireX1+n13, yc-tireY1+m13, xc+tireX1+n33, yc-tireY1+m33);
		
		// Draw the third line in tire two..
		g.drawLine(xc+tireX2+n13, yc-tireY2+m13, xc+tireX2+n33, yc-tireY2+m33);

		
		// Determine the points to draw the fourth line in the two tires..
		n14=(int)Math.round(smallCycleRadiusOfTires*Math.cos((a4)*Math.PI/180));
		m14=(int)Math.round(smallCycleRadiusOfTires*Math.sin((a4)*Math.PI/180));
		n34=(int)Math.round(bigCycleRadiusOfTires*Math.cos((a4)*Math.PI/180));
		m34=(int)Math.round(bigCycleRadiusOfTires*Math.sin((a4)*Math.PI/180));
		
		// Draw the fourth line in tire one..
		g.drawLine(xc+tireX1+n14, yc-tireY1+m14, xc+tireX1+n34, yc-tireY1+m34);
		
		// Draw the fourth line in tire two..
		g.drawLine(xc+tireX2+n14, yc-tireY2+m14, xc+tireX2+n34, yc-tireY2+m34);
		
		/******************************************************************/

		
		////////////////////////////////////////////////////////////////////
		//////////////////////   Car Body   ////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		g.setColor(Color.blue);
		
		// Points for rectangle body..
		cx11=mainAngle-15;
		cy11=(int)((45)*Math.sin((mainAngle-15)*Math.PI/180))+15;
		
		cx12=mainAngle-15;
		cy12=(int)((45)*Math.sin((mainAngle-15)*Math.PI/180))+40;
		
		cx13=mainAngle+60;
		cy13=(int)((45)*Math.sin((mainAngle+60)*Math.PI/180))+15;

		cx14=mainAngle+60;
		cy14=(int)((45)*Math.sin((mainAngle+60)*Math.PI/180))+40;
		
		
		
//		g2d = (Graphics2D)g;
//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		AffineTransform reset = g2d.getTransform();
//		
//		g2d.setRenderingHints(rh);
//		
//		Rectangle2D.Double r = new Rectangle2D.Double(xc + cx12, yc - cy12, 100, 30);
//		g2d.setColor(Color.green);
//		double angle = 45*Math.cos(mainAngle * Math.PI / 180);
//		g2d.rotate(Math.c(aaa * Math.PI / 180), xc + cx12, yc - cy12);
//		g2d.fill(r);
//		
		
		
		
		// Drawing the rectangle..
		int xxx1[] = {xc+cx12, xc+cx11, xc+cx13, xc+cx14};
		int yyy1[] = {yc-cy12,yc-cy11 , yc-cy13, yc-cy14};
		g.drawPolygon(xxx1, yyy1, 4);
//		
		
//		
		cx21= mainAngle;
		cy21=(int)((45)*Math.sin((mainAngle)*Math.PI/180))+40;
		
		cx22=mainAngle+10;
		cy22=(int)((45)*Math.sin((mainAngle+10)*Math.PI/180))+60;
		
		cx23=mainAngle+35;
		cy23=(int)((45)*Math.sin((mainAngle+35)*Math.PI/180))+60;
		
		cx24=mainAngle+45;
		cy24=(int)((45)*Math.sin((mainAngle+45)*Math.PI/180))+40;
		
		// Drawing the car roof..
		int xxx2[] = {xc+cx21, xc+cx22, xc+cx23, xc+cx24};
		int yyy2[] = {yc-cy21, yc-cy22, yc-cy23, yc-cy24};
		g.fillPolygon(xxx2, yyy2, 4);
		
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(aaa);
		if(mainAngle<=getWidth()) {
			repaint();
		}
		else {
			mainAngle=0;
		}
		mainAngle+=1;
		a1+=5;
		a2+=5;
		a3+=5;
		a4+=5;
		aaa+=1;
		
		if(aaa==45)aaa=-45;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarOnRoad();
	}

}
