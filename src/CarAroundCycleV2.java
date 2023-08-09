import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CarAroundCycleV2 extends JFrame implements ActionListener {
int x = 0, y = 70;
Timer timer;
public CarAroundCycleV2(){
super("Simple Car Animation");
timer = new Timer(10,this);
timer.start();
setSize(500,200);
setVisible(true);}
@Override
public void paint(Graphics g){
super.paint(g);
g.drawRect(x, y, 60, 10);
g.drawLine(x+10, y, x+20, y-10);//Line bi
g.drawLine(x+20, y-10, x+40, y-10);//line ij
g.drawLine(x+40, y-10, x+50, y);//line jc
g.drawOval(x+10, y+10, 10, 10);//Oval to point f
g.drawOval(x+40, y+10, 10, 10);//Oval to point h
 }
@Override
public void actionPerformed(ActionEvent event){
x += 1;
if (x > getWidth())
 x=0;
repaint();} 
public static void main(String[] args) {
	CarAroundCycleV2 example=new CarAroundCycleV2(); }}