import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Draw1 extends JFrame implements ActionListener{
	int x1, x2, x3, y1, y2, y3, xc=275, yc=275;
	int x12, y12, x22, y22, x32, y32, x13, y13, x23, y23, x33, y33, x14, y14, x24, y24, x34, y34;
	int r1=75; 
	int r2=225;
	int a=0;
	int a2=180, a3=90, a4=270;
	
	Timer t;
	public Draw1() {
		super("Draw 1");
		t=new Timer(100 , this);
		t.start();
		setSize(550,550);
		setVisible(true);
		setLocation(500, 150);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.drawOval(200, 200, 150, 150);
		g.drawOval(50, 50, 450, 450);
		g.setColor(Color.red);
//		for(; a<=360; a+=45) {
//			x1=(int)Math.round(r1*Math.cos(a*Math.PI/180));
//			y1=(int)Math.round(r1*Math.sin(a*Math.PI/180));
//			x2=(int)Math.round(r1*Math.cos((a+45)*Math.PI/180));
//			y2=(int)Math.round(r1*Math.sin((a+45)*Math.PI/180));
//			x3=(int)Math.round(r2*Math.cos((a+22.5)*Math.PI/180));
//			y3=(int)Math.round(r2*Math.sin((a+22.5)*Math.PI/180));
//			g.drawLine(xc+x1, yc+y1, xc+x3, yc+y3);
//			g.drawLine(xc+x2, yc+y2, xc+x3, yc+y3);
//		}
		a=0;
		for(; a<360; a+=18) {
			g.setColor(Color.red);
			x1=(int)Math.round(r1*Math.cos(a*Math.PI/180));
			y1=(int)Math.round(r1*Math.sin(a*Math.PI/180));
			x2=(int)Math.round(r1*Math.cos((a+18)*Math.PI/180));
			y2=(int)Math.round(r1*Math.sin((a+18)*Math.PI/180));
			x3=(int)Math.round(r2*Math.cos((a+9)*Math.PI/180));
			y3=(int)Math.round(r2*Math.sin((a+9)*Math.PI/180));
			g.drawLine(xc+x1, yc+y1, xc+x3, yc+y3);
			g.drawLine(xc+x2, yc+y2, xc+x3, yc+y3);
			g.setColor(Color.blue);
			g.fillOval(xc+x3-6, yc+y3-6, 12, 12);
		}
		
//		x1=(int)Math.round(r1*Math.cos((a+7)*Math.PI/180));
//		y1=(int)Math.round(r1*Math.sin((a+7)*Math.PI/180));
//		x2=(int)Math.round(r1*Math.cos((a-7)*Math.PI/180));
//		y2=(int)Math.round(r1*Math.sin((a-7)*Math.PI/180));
//		x3=(int)Math.round(r2*Math.cos((a)*Math.PI/180));
//		y3=(int)Math.round(r2*Math.sin((a)*Math.PI/180));
//		
//		x12=(int)Math.round(r1*Math.cos((a2+7)*Math.PI/180));
//		y12=(int)Math.round(r1*Math.sin((a2+7)*Math.PI/180));
//		x22=(int)Math.round(r1*Math.cos((a2-7)*Math.PI/180));
//		y22=(int)Math.round(r1*Math.sin((a2-7)*Math.PI/180));
//		x32=(int)Math.round(r2*Math.cos((a2)*Math.PI/180));
//		y32=(int)Math.round(r2*Math.sin((a2)*Math.PI/180));
//		g.drawLine(xc+x1, yc+y1, xc+x3, yc+y3);
//		g.drawLine(xc+x2, yc+y2, xc+x3, yc+y3);
//		g.drawLine(xc+x12, yc+y12, xc+x32, yc+y32);
//		g.drawLine(xc+x22, yc+y22, xc+x32, yc+y32);
//		
//		x13=(int)Math.round(r1*Math.cos((a3+7)*Math.PI/180));
//		y13=(int)Math.round(r1*Math.sin((a3+7)*Math.PI/180));
//		x23=(int)Math.round(r1*Math.cos((a3-7)*Math.PI/180));
//		y23=(int)Math.round(r1*Math.sin((a3-7)*Math.PI/180));
//		x33=(int)Math.round(r2*Math.cos((a3)*Math.PI/180));
//		y33=(int)Math.round(r2*Math.sin((a3)*Math.PI/180));
//		
//		x14=(int)Math.round(r1*Math.cos((a4+7)*Math.PI/180));
//		y14=(int)Math.round(r1*Math.sin((a4+7)*Math.PI/180));
//		x24=(int)Math.round(r1*Math.cos((a4-7)*Math.PI/180));
//		y24=(int)Math.round(r1*Math.sin((a4-7)*Math.PI/180));
//		x34=(int)Math.round(r2*Math.cos((a4)*Math.PI/180));
//		y34=(int)Math.round(r2*Math.sin((a4)*Math.PI/180));
//		g.drawLine(xc+x13, yc+y13, xc+x33, yc+y33);
//		g.drawLine(xc+x23, yc+y23, xc+x33, yc+y33);
//		g.drawLine(xc+x14, yc+y14, xc+x34, yc+y34);
//		g.drawLine(xc+x24, yc+y24, xc+x34, yc+y34);
	}
	public void actionPerformed(ActionEvent event) {
		if(true) {
//			repaint();
		}
//		else {
//			t.stop();
//		}
//		a+=15;
//		a-=15;
//		a2-=15;
//		a3-=15;
//		a4-=15;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Draw1();

	}

}
