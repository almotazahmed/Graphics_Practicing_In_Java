import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExamTesting extends JFrame implements ActionListener{
//    Timer t;
//    int a=0;
//    int xc=300, yc=50, l=250;
    public ExamTesting(){
        super("Testing");
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        t = new Timer(10, this);
//        t.start();
    }
    public void paint(Graphics g){
//        g.setColor(Color.black);
//        g.drawLine(0,getHeight()/2,getWidth(), getHeight()/2);
//        g.drawLine(getWidth()/2,0,getWidth()/2, getHeight());
//        g.setColor(Color.blue);
//        int x = (int)(Math.round(r*Math.cos(a*Math.PI/180)));
//        int y = (int)(Math.round(r*Math.sin(a*Math.PI/180)));
////        g.drawLine(xc+x, yc-y, xc+x, yc-y);
////        g.setColor(Color.GREEN);
//        System.out.println(x+" "+y);
//        g.drawLine(xc+x, yc+y, xc+x, yc+y);
//        int []x = {xc, (int)(xc-0.5*l),(int)(xc+.5*l)};
//        int []y = {yc, (int)(yc+Math.sqrt(3)/2*l), (int)(yc+Math.sqrt(3)/2*l)};
//        g.drawPolygon(x,y,3);
//        int diffY11 = (int)(yc+Math.sqrt(3)/2*l);
////        int diffY22 = yc;
//        l-=20;
//        int diffY1= diffY11 - (int)(yc + Math.sqrt(3) / 2 * l);
////        int diffY2=;
//        x = new int[]{xc, (int) (xc - 0.5 * l), (int) (xc + .5 * l)};
//        y = new int[]{yc+(int).5*l , (int) (yc + Math.sqrt(3) / 2 * l)+diffY1, (int) (yc + Math.sqrt(3) / 2 * l)+diffY1};
//        g.drawPolygon(x,y,3);
        drawShape(260, 210, 150, 70, g);
        drawShape(535, 250, 170, 90, g);
        drawShape(440, 450, 100, 50, g);
    }
    public void drawShape(int x, int y, int width, int height, Graphics graphics) {
        // Draw blue rectangle
        graphics.setColor(Color.BLUE);
        int rectX = x - width;
        graphics.drawRect(rectX, y, width, height);

        // Draw red triangle
        graphics.setColor(Color.RED);
        int x1 = (int)Math.round(x - 0.5 * width);
        int x2 = (int)Math.round(x - (width + height / Math.sqrt(3)));
        int x3 = (int)Math.round(x + height / Math.sqrt(3));
        int y1 = (int)Math.round(y - Math.sqrt(3) / 2 * width);
        int y2 = (int)Math.round(y + height);
        int y3 = y2;
        graphics.drawPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);

        // Draw yellow oval
        graphics.setColor(Color.YELLOW);
        int r = (int)Math.round(Math.sqrt(3) / 6 * width);
        int ovalX = x - (width / 2 + r);
        int ovalY = y - 2 * r;
        graphics.drawOval(ovalX, ovalY, 2 * r, 2 * r);

        // Draw black ovals
        graphics.setColor(Color.BLACK);
        int widthOfUpperOvals = (int)Math.round(0.5 * width + height / Math.sqrt(3));
        int ovalYOffset = 10;
        graphics.fillOval(x1, y1 - ovalYOffset, widthOfUpperOvals, 20);
        graphics.fillOval(x1 - widthOfUpperOvals, y1 - ovalYOffset, widthOfUpperOvals, 20);
    }

//    public void drawShape(int x, int y, int w, int h, Graphics g){
//        g.setColor(Color.BLUE);
//        g.drawRect(x-w, y, w, h);
//        int x1 = (int)Math.round(x-.5*w);
//        int x2 = (int)Math.round(x-(w+h/Math.sqrt(3)));
//        int x3 = (int)Math.round(x+h/Math.sqrt(3));
//        int y1 = (int)Math.round(y-Math.sqrt(3)/2*w);
//        int y2 = (int)Math.round(y+h);
//        int y3 = y2;
//        g.setColor(Color.RED);
//        g.drawPolygon(new int[]{x1,x2,x3}, new int[]{y1,y2,y3}, 3);
//        g.setColor(Color.GRAY);
////        g.drawLine(x2, y1, x2, y2);
////        g.drawLine(x3, y1, x3, y3);
//
//        g.setColor(Color.YELLOW);
//
//
//        int r = (int)Math.round(Math.sqrt(3)/6*w);
//        int xOval = (int)Math.round(x - ((w / 2) + r));
//        int yOval = (int)Math.round(y-2*r);
//        g.drawOval(xOval, yOval, 2*r, 2*r);
//        g.setColor(Color.GREEN);
////        g.drawRect(xOval, yOval, 2*r, 2*r);
//
//        g.setColor(Color.BLACK);
//        int widthOfUpperOvals = (int)Math.round(.5 * w + h / Math.sqrt(3));
//        g.fillOval(x1, y1-10, widthOfUpperOvals, 20);
//        g.fillOval(x1- widthOfUpperOvals, y1-10, widthOfUpperOvals, 20);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(a<10){
//            repaint();
//            l-=20;
//            a++;
//        }
//        else t.stop();
    }
    public static void main(String [] args){
        new ExamTesting();
    }
}
