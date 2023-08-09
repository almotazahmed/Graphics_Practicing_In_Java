import javax.swing.*; //JFrame
import java.awt.event.*;
import java.awt.*;  //Graphics, Colors
import java.util.Random;
public class FirstProject extends JFrame  implements ActionListener{
	
	Timer t;
////	JTextArea textArea;
	int i=5;
	int x=50, y=50;
	int xx=250, xy=250;
	public FirstProject() {
		super("Line Drawing");
//		add(textArea = new JTextArea());
		t = new Timer(5, this);
		t.start();
		setSize(1000,800);
		setVisible(true);
//		setLocation(100,100);
		setBackground(Color.white);
	}
	//Paint method is in jframe and we override it, whitout it we can not drow anything; everything we want to drow we but it 
	//in this method;
	// By default do this paint, so i should not call it;
	// the essential point in jfame is 0,0 the top left point;
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(randomColor());
		//g.drawLine(X1,Y1,X2,Y2);
		/////////// star///////////
//		g.drawLine(300,50, 400, 550);
//		g.drawLine(300,50, 200, 550);
//		g.drawLine(550,200, 200, 550);
//		g.drawLine(50,200, 400, 550);
//		g.drawLine(50,200, 550, 200);
		//////////متوازي مستطيلات  ////////////////
//		g.drawLine(50,50, 50, 300);
//		g.drawLine(50,50, 550, 50);
//		g.drawLine(550,50, 550, 300);
//		g.drawLine(50,300, 550, 300);
//		g.drawLine(300,175, 800, 175);
//		g.drawLine(800,175, 800, 425);
//		g.drawLine(300,425, 800, 425);
//		g.drawLine(300,175, 300, 425);
//		g.drawLine(550,50, 800, 175);
//		g.drawLine(50,50, 300, 175);
//		g.drawLine(50,300, 300, 425);
//		g.drawLine(550,300, 800, 425);
		
//		g.drawRect(50, 50, 500, 250);
//		g.fillRect(100, 100, 500, 250);
//		g.drawLine(300,50, 300, 50);
		
		
//		g.drawRect(50, 50, 120, 120);
//		g.drawOval(50, 50, 40, 40);
//		g.drawOval(130, 50, 40, 40);
//		g.drawOval(90, 90, 40, 40);
//		g.drawOval(50, 130, 40, 40);
//		g.drawOval(130, 130, 40, 40);

//		for(; x<=250; i+=5) {
//			g.drawOval(xx-i, xy-i, 2*i, 2*i);
//			g.drawLine(100, 100, 200, 100);
//		}
//		for(;i<=xy ; i+=5) {
			g.drawOval(xy-i, xy-i, 2*i, 2*i);
//		}
	}
	public Color randomColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		System.out.println(Integer.toString(red)+ " "+ Integer.toString(green)+ " "+Integer.toString(blue));
		return new Color(red, green, blue);
	}
	public void actionPerformed(ActionEvent event) {
//		System.out.println("Hello World!\n");
		
		if(i<=200)
			repaint();
//			getGraphics().drawOval(xx-i, xy-i, 2*i, 2*i);
		else
			t.stop();
		i+=5;
		
		
		
//		if(x<=450)
//			getGraphics().drawOval(x, y, x-49, x-49);
//		else t.stop();
//		 x+=4; 
//		 y+=2;
		 
	}
}
