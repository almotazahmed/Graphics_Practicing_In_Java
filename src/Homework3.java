import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
class ReflectionHW extends JPanel{
    Polygon p;
    public ReflectionHW(){
        p=new Polygon();
        p.addPoint(160, 130);
        p.addPoint(220, 130);
        p.addPoint(220, 160);
        p.addPoint(190, 180);
        p.addPoint(160, 160);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        Graphics2D g2d =(Graphics2D)g;
        int x[]={160,220,220,190,160};
        int y[]={130,130,160,180,160};
        g2d.rotate(-45*Math.PI/180,500,0);
        g2d.transform(new AffineTransform(1, 0,0,-1,0,0));
        g2d.rotate(45*Math.PI/180,500,0);
        g2d.drawPolygon(x, y, 5);
        double m[]=new double[6];
        g2d.getTransform().getMatrix(m);
        for(int i=0;i<6;i++){
            System.out.println(m[i]);}
//        g.drawLine(599, -99, -99, 599);
//        g.setColor(Color.BLACK);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawPolygon(p);
//        g2d.transform( new AffineTransform(0, -1, -1, 0, 500, 500));
//        g2d.drawPolygon(p);
    }
}

class FirstShape extends JPanel{
    Graphics2D g2d;
    void moveTo(int x, int y){
        g2d.translate(x, y);
    }
    public void forward(int length){
        g2d.drawLine(0, 0, length, 0);
        g2d.translate(length, 0);
    }
    void left(double a){
        g2d.rotate(-a*Math.PI/180);
    }
    public void forward1(int length){
        g2d.translate(length, 0);
    }
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D) g;
        moveTo(280, 250);
        g2d.setColor(Color.blue);
        for(int i=0; i<6; i++){
            g2d.drawOval(0, -13, 100, 26);
            left(60);
        }
        forward1(100);
        left(120);
        for(int i=0; i<6; i++){
            if(i%2==0){
                g2d.setColor(Color.blue);
                forward(100);
                left(60);
            }
            else{
                g2d.fillOval(0, -13, 100, 26);
                g2d.setColor(Color.red);
                g2d.fillRect(20, 0, 60, 60);
                forward(100);
                left(60);
            }
        }

    }
}
class SecondShape extends JPanel{
    Graphics2D g2d;
    void moveTo(int x, int y){
        g2d.translate(x, y);
    }
    public void forward(int length){
        g2d.drawLine(0, 0, length, 0);
        g2d.translate(length, 0);
    }
    void left(double a){
        g2d.rotate(-a*Math.PI/180);
    }
    void drawTriangle(int length){
        for(int i=1;i<=3;i++){
            forward(length);
            left(120);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D) g;
        moveTo(280, 250);
        for(int i=0; i<8; i++){
            drawTriangle(100);
            left(45);
        }
    }
}

class ThirdShape extends JPanel{
    Graphics2D g2d;
    void moveTo(int x, int y){
        g2d.translate(x, y);
    }
    public void forward(int length){
        g2d.drawLine(0, 0, length, 0);
        g2d.translate(length, 0);
    }
    void left(double a){
        g2d.rotate(-a*Math.PI/180);
    }
    public void forward1(int length){
        g2d.translate(length, 0);
    }
    void drawTriangle(int length){
        for(int i=1;i<=3;i++){
            forward(length);
            left(120);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D) g;
        moveTo(380, 250);
        left(90);
        for(int i=0; i<12; i++){
            drawTriangle(60);
            forward1(60);
            left(30);
        }
    }
}
class ForthShape extends JPanel implements ActionListener{
    Timer t;
    int r=150;
    int cx=250, cy=250;
    int a=0;
    public ForthShape() {
        t = new Timer(15, this);
        t.start();
    }
    public void triangle(int m, int cx, int cy, Graphics g){
        g.drawLine(cx, cy, cx-(int)Math.round(.5*m), cy+(int)Math.round(Math.sqrt(3)/2*m));
        g.drawLine(cx, cy, cx+(int)Math.round(.5*m), cy+(int)Math.round(Math.sqrt(3)/2*m));
        g.drawLine(cx-(int)Math.round(.5*m), cy+(int)Math.round(Math.sqrt(3)/2*m), cx+(int)Math.round(.5*m), cy+(int)Math.round(Math.sqrt(3)/2*m));
    }

    public void paint(Graphics g) {
        int xx[] = {100, 150, 200};
        int yy[] = {100, 150, 100};
        g.fillPolygon(xx, yy, 3);
        int xx1[] = {100, 100, 150};
        int yy1[] = {100, 200, 150};
        g.setColor(Color.red);
        g.fillPolygon(xx1, yy1, 3);
        int xx2[] = {100, 150, 200};
        int yy2[] = {200, 150, 200};
        g.setColor(Color.yellow);
        g.fillPolygon(xx2, yy2, 3);
        int xx3[] = {200, 150, 200};
        int yy3[] = {100, 150, 200};
        g.setColor(Color.green);
        g.fillPolygon(xx3, yy3, 3);

        int x = (int)Math.round(r*Math.cos(a*Math.PI/180));
        int y = (int)Math.round(r*Math.sin(a*Math.PI/180));
        g.drawLine(cx+x, cy-y, cx+x, cy-y);
        g.setColor(Color.blue);
        triangle(200, 300, 300, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(a<45){
//            a++;
//            repaint();
//        }
//        else{
//            t.stop();
//        }
    }
}



class FifthShape extends JPanel{
    Graphics2D g2d;
    void moveTo(int x, int y){
        g2d.translate(x, y);
    }
    public void forward(int length){
        g2d.drawLine(0, 0, length, 0);
        g2d.translate(length, 0);
    }
    void left(double a){
        g2d.rotate(-a*Math.PI/180);
    }
    void right(double a){
        g2d.rotate(a*Math.PI/180);
    }
    public void forward1(int length){
        g2d.translate(length, 0);
    }
    public void drawMer(int l){
        forward(l);
        right(60);
        forward(l);
        right(120);
        forward(l);
        right(60);
        forward(l);
//        right(60);
    }

    void draw1(int n,int length){
        for (int i=1;i<=n;i++){
//            (90);
            draw2(11, 20);
            forward1(length);
            left(360/n);
        }
    }
    void draw2(int n,int length){
        for (int i=1;i<=n;i++){
            forward(length);
            left(360/n);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D) g;
        moveTo(280, 250);
        g2d.setColor(Color.blue);
//        forward(100);
//        left(60);
//        forward(100);
//        left(120);
//        forward(100);
//        left(120);
//        forward(100);
//        left(60);
//        forward(100);
//        left(120);
//        forward(200);
//        left(120);
//        forward(200);
//        left(60);
//        draw1(20, 40);
//        for(int i=0; i<3; i++){
////            right(60);
//            drawMer(150);
//        }
        int len=50;
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                forward(len);
                left(90);
            }
            len+=10;
        }

    }
}




class ReflectionHW22 extends JPanel{
    Polygon p;
    public ReflectionHW22(){
    }
    public void paint(Graphics g){
        super.paint(g);



        Graphics2D g2d = (Graphics2D) g;

        AffineTransform t = new AffineTransform();
        t.translate(500, 0);
//        t.transform(new int[]{(int)(-500/Math.sqrt(500000)), (int)(500 / Math.sqrt(500000)), (int)(500/Math.sqrt(500000)), (int)(500/Math.sqrt(500000)), 0, 0});

//        g2d.drawPolygon(p);
//        g2d.transform( new AffineTransform(0, -1, -1, 0, 500, 500));
        g2d.drawPolygon(p);
    }
}



public class Homework3 extends JFrame {
    JTabbedPane pane;
    public Homework3() {
        super("Homework 3");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        add(pane = new JTabbedPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.addTab("Reflection", new ReflectionHW());
//        pane.addTab("First Shape", new FirstShape());
//        pane.addTab("Second Shape", new SecondShape());
//        pane.addTab("Third Shape", new ThirdShape());
        pane.addTab("Forth Shape", new ForthShape());
        pane.addTab("Forth Shape", new FifthShape());

    }

    public static void main(String[] args) {
        new Homework3();
    }
}