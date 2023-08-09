import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/////////////////////////////////////////////////////////////////////////////////
class Cycles1 extends JFrame implements ActionListener{
	double a1=0, a2=0;
	Timer t1;
	JComboBox comboBox;
	public Cycles1(){
        super("Simple Shapes");
        t1 = new Timer(2 , this);
        t1.start();
        setLayout(new FlowLayout());
		add(new JLabel("Choose the Shape"));
		
		String [] shapes ={"None", "Shape 1", "Shape 2" ,"Shape 3", "Shape 4", "Shape 5"};
		comboBox = new JComboBox (shapes);
		comboBox.addActionListener(this);
		add(comboBox);
		setSize(600,600);
		setVisible(true);
		this.setLocation(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
/**************************************************************************************/
	// Drawing the first shape for example Line
	void drawShape1(Graphics gr){
		int x1, x2, x3, y1, y2, y3, xc=300, yc=300;
		int r1=75; 
		int r2=225;
		gr.setColor(Color.black);
		gr.drawOval(225, 225, 150, 150);
		gr.drawOval(75, 75, 450, 450);
		gr.setColor(Color.red);
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
//		a=0;
//		for(; a<337.5; a+=22.5) {
			x1=(int)Math.round(r1*Math.cos(a1*Math.PI/180));
			y1=(int)Math.round(r1*Math.sin(a1*Math.PI/180));
			x2=(int)Math.round(r1*Math.cos((a1+15)*Math.PI/180));
			y2=(int)Math.round(r1*Math.sin((a1+15)*Math.PI/180));
			x3=(int)Math.round(r2*Math.cos((a1+7.5)*Math.PI/180));
			y3=(int)Math.round(r2*Math.sin((a1+7.5)*Math.PI/180));
			gr.drawLine(xc+x1, yc+y1, xc+x3, yc+y3);
			gr.drawLine(xc+x2, yc+y2, xc+x3, yc+y3);
			gr.setColor(Color.blue);
			gr.fillOval(xc+x3-6, yc+y3-6, 12, 12);
//		}
	}	
/**************************************************************************************/
	// Drawing the second shape for example Square
	void drawShape2(Graphics gr){
		t1.setDelay(3);
		int x1, x2, x3, y1, y2, y3, xc=275, yc=275;
		int tx1, tx2, ty1, ty2, cx1, cy1, cx2, cy2, cx11, cy12, cx21, cy22, cx31, cy31, cx32, cy32, cx41, cy41, cx42, cy42;
		int r1=75; 
		int r2=200;
		
		super.paint(gr);
		gr.setColor(Color.black);
		gr.drawOval(200, 200, 150, 150);
		gr.drawOval(75, 75, 400, 400);
		gr.setColor(Color.blue);

//		x1=(int)Math.round(r1*Math.cos(a*Math.PI/180));
//		y1=(int)Math.round(r1*Math.sin(a*Math.PI/180));
//		x2=(int)Math.round(r1*Math.cos((a+15)*Math.PI/180));
//		y2=(int)Math.round(r1*Math.sin((a+15)*Math.PI/180));
//		x3=(int)Math.round(r2*Math.cos((a+7.5)*Math.PI/180));
//		y3=(int)Math.round(r2*Math.sin((a+7.5)*Math.PI/180));
//		g.drawLine(xc+x1, yc+y1, xc+x3, yc+y3);
//		g.drawLine(xc+x2, yc+y2, xc+x3, yc+y3);
//		g.setColor(Color.blue);
//		g.fillOval(xc+x3-6, yc+y3-6, 12, 12);
		
		
		tx1=(int)Math.round(r2*Math.cos(a2-10*Math.PI/180));
		ty1=(int)Math.round(r2*Math.sin(a2-10*Math.PI/180));
		tx2=(int)Math.round(r2*Math.cos(a2+10*Math.PI/180));
		ty2=(int)Math.round(r2*Math.sin(a2+10*Math.PI/180));
		
		gr.fillOval(xc+tx1-7, yc+ty1-7, 14, 14);
		gr.fillOval(xc+tx2-7, yc+ty2-7, 14, 14);
		
		
		cx1=(int)Math.round((r2+11)*Math.cos(a2-15*Math.PI/180));
		cy1=(int)Math.round((r2+11)*Math.sin(a2-15*Math.PI/180));
		cx2=(int)Math.round((r2+11)*Math.cos(a2+15*Math.PI/180));
		cy2=(int)Math.round((r2+11)*Math.sin(a2+15*Math.PI/180));
		
		gr.drawLine(xc+cx1, yc+cy1, xc+cx2, yc+cy2);
		
		
		cx11=(int)Math.round((r2+28)*Math.cos(a2-14*Math.PI/180));
		cy12=(int)Math.round((r2+28)*Math.sin(a2-14*Math.PI/180));
		cx21=(int)Math.round((r2+28)*Math.cos(a2+14*Math.PI/180));
		cy22=(int)Math.round((r2+28)*Math.sin(a2+14*Math.PI/180));
		
		gr.drawLine(xc+cx11, yc+cy12, xc+cx21, yc+cy22);
		gr.drawLine(xc+cx1, yc+cy1, xc+cx11, yc+cy12);
		gr.drawLine(xc+cx2, yc+cy2, xc+cx21, yc+cy22);
		
		cx31=(int)Math.round((r2+24)*Math.cos(a2-9*Math.PI/180));
		cy31=(int)Math.round((r2+24)*Math.sin(a2-9*Math.PI/180));
		cx32=(int)Math.round((r2+24)*Math.cos(a2+9*Math.PI/180));
		cy32=(int)Math.round((r2+24)*Math.sin(a2+9*Math.PI/180));
		
		
		cx41=(int)Math.round((r2+42)*Math.cos(a2-5*Math.PI/180));
		cy41=(int)Math.round((r2+42)*Math.sin(a2-5*Math.PI/180));
		cx42=(int)Math.round((r2+42)*Math.cos(a2+5*Math.PI/180));
		cy42=(int)Math.round((r2+42)*Math.sin(a2+5*Math.PI/180));
		
		gr.drawLine(xc+cx41, yc+cy41, xc+cx42, yc+cy42);
		gr.drawLine(xc+cx31, yc+cy31, xc+cx41, yc+cy41);
		gr.drawLine(xc+cx32, yc+cy32, xc+cx42, yc+cy42);
	}
/**************************************************************************************/	
	// Drawing the third  shape for example  Rectangle
	void drawShape3(Graphics gr){
		gr.setColor(Color.red);
		gr.fillRect(200,100,100,200);
	}	
/**************************************************************************************/
	// Drawing the fourth shape for example  Circle
	void drawShape4(Graphics gr){
		gr.setColor(Color.magenta);
		gr.drawOval(100,250,200,200);
	}	
/**************************************************************************************/
	// Drawing the fifth shape for example  Ellpise
	void drawShape5(Graphics gr){
		gr.setColor(Color.magenta);
		gr.fillOval(200,100,80,200);
	}	
	
/**************************************************************************************/	
	public void paint(Graphics g){
		super.paint(g);	 
		if (comboBox.getSelectedIndex() ==1)
		 	drawShape1(g);
		else if (comboBox.getSelectedIndex()==2)
			drawShape2(g);
		else if (comboBox.getSelectedIndex()==3)
			drawShape3(g);
		else if (comboBox.getSelectedIndex()==4)
			drawShape4(g);
		else if (comboBox.getSelectedIndex()==5)
			drawShape5(g);
	}
	public void contingShape1() {
		//		a+=15;
		a1-=1;
	}
	public void contingShape2() {
		a2-=.01;
		//		a+=.1;
	}
	public void actionPerformed(ActionEvent event){
		repaint();
		contingShape1();
		contingShape2();
	} 
	public static void main(String args[]){
		new Cycles1();
		
	}
}