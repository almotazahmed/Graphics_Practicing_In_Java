import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/////////////////////////////////////////////////////////////////////////////////
class Shapes1 extends JFrame implements ActionListener{
	  
	JComboBox comboBox;
	public Shapes1(){
        super("Simple Shapes");
        setLayout(new FlowLayout());
		add(new JLabel("Choose the Shape"));
		
		String [] shapes ={"None", "Shape 1", "Shape 2" ,"Shape 3", "Shape 4", "Shape 5"};
		comboBox = new JComboBox (shapes);
		comboBox.addActionListener(this);
		add(comboBox);
		setSize(500,500);
		this.setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
/**************************************************************************************/
	// Drawing the first shape for example Line
	void drawShape1(Graphics gr){
		gr.setColor(Color.blue);
		gr.drawLine(100,100,200,200);
	}	
/**************************************************************************************/
	// Drawing the second shape for example Square
	void drawShape2(Graphics gr){
		Graphics2D g2d = (Graphics2D)gr;
	    g2d.setColor(Color.green);
	    Rectangle rect2 = new Rectangle(300, 200, 20, 20);

	    g2d.rotate(Math.toRadians(45));
	    g2d.draw(rect2);
	    g2d.fill(rect2);
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
	public void actionPerformed(ActionEvent event){
		repaint();
	} 
	public static void main(String args[]){
		new Shapes1();
		
	}
}