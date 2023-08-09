/*

Al-Motaz Bellah Adel Azami Ahmed   المعتز بالله عادل عزامي أحمد

20201685

*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Car extends JPanel implements ActionListener{
    Timer t;
    int cx=300, cy=300;
    int minCircle=3;
    int maxCircle=10;
    int diff=maxCircle-minCircle;
    int diff2=maxCircle+minCircle;
    int n11, m11, n31, m31, n12, m12, n32, m32, n13, m13, n33, m33, n14, m14, n34, m34;
    int a1=0, a2=180, a3=90, a4=270;
    int x=0, y=0;
    int count=0;
    boolean flag=true;
    public Car(){
        t = new Timer(30, this);
        t.start();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.drawLine(0, cy, 2*cx, cy);

        g.drawOval(x,cy-2*maxCircle, 2*maxCircle, 2*maxCircle);
        g.drawOval(x+50,cy-2*maxCircle, 2*maxCircle, 2*maxCircle);
        g.drawOval(x+diff,cy-diff2, 2*minCircle, 2*minCircle);
        g.drawOval(x+diff+50,cy-diff2, 2*minCircle, 2*minCircle);

        g.setColor(Color.red);

        n11=(int)Math.round(minCircle*Math.cos((a1)*Math.PI/180));
        m11=(int)Math.round(minCircle*Math.sin((a1)*Math.PI/180));
        n31=(int)Math.round(maxCircle*Math.cos((a1)*Math.PI/180));
        m31=(int)Math.round(maxCircle*Math.sin((a1)*Math.PI/180));

        g.drawLine(x+n11+maxCircle, cy+m11-maxCircle, x+n31+maxCircle, cy+m31-maxCircle);
        g.drawLine(x+50+n11+maxCircle, cy+m11-maxCircle, x+50+n31+maxCircle, cy+m31-maxCircle);


        n12=(int)Math.round(minCircle*Math.cos((a2)*Math.PI/180));
        m12=(int)Math.round(minCircle*Math.sin((a2)*Math.PI/180));
        n32=(int)Math.round(maxCircle*Math.cos((a2)*Math.PI/180));
        m32=(int)Math.round(maxCircle*Math.sin((a2)*Math.PI/180));

        g.drawLine(x+n12+maxCircle, cy+m12-maxCircle, x+n32+maxCircle, cy+m32-maxCircle);
        g.drawLine(x+50+n12+maxCircle, cy+m12-maxCircle, x+50+n32+maxCircle, cy+m32-maxCircle);


        n13=(int)Math.round(minCircle*Math.cos((a3)*Math.PI/180));
        m13=(int)Math.round(minCircle*Math.sin((a3)*Math.PI/180));
        n33=(int)Math.round(maxCircle*Math.cos((a3)*Math.PI/180));
        m33=(int)Math.round(maxCircle*Math.sin((a3)*Math.PI/180));

        g.drawLine(x+n13+maxCircle, cy+m13-maxCircle, x+n33+maxCircle, cy+m33-maxCircle);
        g.drawLine(x+50+n13+maxCircle, cy+m13-maxCircle, x+50+n33+maxCircle, cy+m33-maxCircle);


        n14=(int)Math.round(minCircle*Math.cos((a4)*Math.PI/180));
        m14=(int)Math.round(minCircle*Math.sin((a4)*Math.PI/180));
        n34=(int)Math.round(maxCircle*Math.cos((a4)*Math.PI/180));
        m34=(int)Math.round(maxCircle*Math.sin((a4)*Math.PI/180));

        g.drawLine(x+n14+maxCircle, cy+m14-maxCircle, x+n34+maxCircle, cy+m34-maxCircle);
        g.drawLine(x+50+n14+maxCircle, cy+m14-maxCircle, x+50+n34+maxCircle, cy+m34-maxCircle);

        g.setColor(Color.blue);
        int[] xBody ={x-20, x-20, x+90, x+90};
        int[] yBody ={cy-13-y, cy-33-y, cy-33-y, cy-13-y};
        g.drawPolygon(xBody, yBody, 4);

        int[] xRoof ={x, x+18, x+52, x+70};
        int[] yRoof ={cy-33-y, cy-50-y, cy-50-y, cy-33-y};

        g.fillPolygon(xRoof, yRoof, 4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(count<5 && flag) {
            y=0;
            count++;
        }
        else {
            flag=false;
            y=3;
            count--;
            if(count==0) flag=true;
        }
        if(x <= 2*cx){
            x+=5;
        }
        else{
            x=0;
        }
        a1+=22;
        a2+=22;
        a3+=22;
        a4+=22;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Balls extends JPanel implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label;
    JTextField textField;
    int number=0;

    public Balls() {
        setLayout(new BorderLayout());
        panel.setLayout(null);

        textField = new JTextField(10);
        textField.setBounds(355, 10, 100, 30);

        label = new JLabel("Enter Number Of Balls: ");
        label.setBounds(135, 10, 210, 30);

        panel.setBackground(Color.PINK);
        panel.setPreferredSize(new Dimension(600, 50));

        panel.add(label);
        panel.add(textField);
        add(panel, BorderLayout.NORTH);

        textField.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int randomX, randomY;
        for(int i=0; i<number; i++){
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            randomX = (int)(Math.random()*600);
            randomY = (int)(Math.random()*600);
            g.fillOval(randomX-20, randomY+50, 40, 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (e.getSource() == textField) {
            String text = textField.getText();
            try {
                number = Integer.parseInt(text);
                label.setText("Number entered:         " + number);
            } catch (NumberFormatException ex) {
                label.setText("Invalid input:          " + text);
            }
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class MovingAngle extends JPanel implements ActionListener{
    Timer t;
    int a1=0;

    public MovingAngle(){
        t = new Timer(10, this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x1, x2, x3, y1, y2, y3, xc=290, yc=265;
        int r1=70;
        int r2=225;

        g.setColor(Color.black);
        g.drawOval(xc-r1, yc-r1, 2*r1, 2*r1);
        g.drawOval(xc-r2, yc-r2, 2*r2, 2*r2);

        g.setColor(Color.red);
        x1=(int)Math.round(r1*Math.cos(a1*Math.PI/180));
        y1=(int)Math.round(r1*Math.sin(a1*Math.PI/180));
        x2=(int)Math.round(r1*Math.cos((a1+12)*Math.PI/180));
        y2=(int)Math.round(r1*Math.sin((a1+12)*Math.PI/180));
        x3=(int)Math.round((r2-4)*Math.cos((a1+6)*Math.PI/180));
        y3=(int)Math.round((r2-4)*Math.sin((a1+6)*Math.PI/180));

        int[] x ={xc+x1, xc+x2, xc+x3};
        int[] y = {yc+y1, yc+y2, yc+y3};
        g.fillPolygon(x, y, 3);

        g.setColor(Color.blue);
        g.fillOval(xc+x3-4, yc+y3-4, 8, 8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        a1+=1;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Homework21 extends JFrame {
    int cx = 300, cy = 300;
    JTabbedPane pane;

    public Homework21() {
        super("Homework 2");
        setSize(2 * cx, 2 * cy);
        setVisible(true);
        setLocationRelativeTo(null);
        add(pane = new JTabbedPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.addTab("Car", new Car());
        pane.addTab("Balls", new Balls());
        pane.addTab("Moving Angle", new MovingAngle());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        Homework21 test = new Homework21();
        new Homework2();
    }
}