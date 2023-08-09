import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class G2dExampleOne extends JFrame{
    Polygon p;
    public G2dExampleOne(){
        super("G2d Example One!");
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p=new Polygon();
        p.addPoint(100, 100);
        p.addPoint(200, 100);
        p.addPoint(200, 150);
        p.addPoint(100, 150);
        p.addPoint(100, 100);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(p);
//        g2d.translate(100, 100);
//        g2d.drawPolygon(p);
//        g2d.rotate(45*Math.PI/180);
//        g2d.drawPolygon(p);
//        g2d.translate(-100, -100);
//        g2d.drawPolygon(p);
        g2d.scale(0.5,0.5);
        g2d.drawPolygon(p);
    }
    public static void main(String[] args){
        new G2dExampleOne();
    }
}
