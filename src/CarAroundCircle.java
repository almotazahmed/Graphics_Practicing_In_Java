import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarAroundCircle extends JFrame implements ActionListener{

    // The center of the frame…
    int xc=300, yc=300;

    // The radius of the smaller main Circle..
    int r1=75;

    // The radius of the bigger main Circle..
    int r2=200;

    // Radius of the small Circle in the Tires..
    int smallCircleRadiusOfTires=3;

    // Radius of the big Circle in the Tires..
    int bigCircleRadiusOfTires=10;

    // The center points to the tires..
    int tireX1, tireX2, tireY1, tireY2;

    // Points to draw the lines in the tires..
    int n11, m11, n31, m31, n12, m12, n32, m32, n13, m13, n33, m33, n14, m14, n34, m34;

    // The angles of the four lines in the two tires..
    int a1=0, a2=180, a3=90, a4=270;

    // Points to draw the car body..
    int cx11, cy11, cx12, cy12, cx13, cy13, cx14, cy14, cx21, cy21, cx22, cy22, cx23, cy23, cx24, cy24;

    // The main angle two move the car around the bigger Circle..
    int mainAngle=270;

    // Timer for moving the car..
    Timer t;

    // counter to up and down the car body according to this counter..
    int count=0;

    // Flags for Move the car forward and backward..
    boolean flag = true, flag2 = true;

    // To determine how many we want to up and down the car body..
    int upAndDown=0;

    // The starting point of the arrow..
//	int arrowAngle=0;

    // Points for drawing the arrow..
    int arrowX1, arrowY1, arrowX2, arrowY2, arrowX3, arrowY3;

    public CarAroundCircle() {
        super("Car Around Circle");
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);
        t=new Timer(2, this);
        t.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.black);

        //Circle one drawing..
        g.drawOval(xc-r1, yc-r1, 2*r1, 2*r1);

        //Circle two drawing..
        g.drawOval(xc-r2, yc-r2, 2*r2, 2*r2);


        ////////////////////////////////////////////////////////////////////
        ///////////////////////////  Tires  ////////////////////////////////
        ////////////////////////////////////////////////////////////////////

        g.setColor(Color.blue);

        // Determine the X and Y axis to the middle point to the first car tire..
        tireX1=(int)Math.round((r2+bigCircleRadiusOfTires)*Math.cos((mainAngle-10)*Math.PI/180));
        tireY1=(int)Math.round((r2+bigCircleRadiusOfTires)*Math.sin((mainAngle-10)*Math.PI/180));

        // Determine the X and Y axis to the middle point to the second car tire..
        tireX2=(int)Math.round((r2+bigCircleRadiusOfTires)*Math.cos((mainAngle+10)*Math.PI/180));
        tireY2=(int)Math.round((r2+bigCircleRadiusOfTires)*Math.sin((mainAngle+10)*Math.PI/180));

        // Drawing the first tire with two Circles..
        g.drawOval(xc+tireX1-bigCircleRadiusOfTires, yc+tireY1-bigCircleRadiusOfTires, 2*bigCircleRadiusOfTires, 2*bigCircleRadiusOfTires);
        g.drawOval(xc+tireX1-smallCircleRadiusOfTires, yc+tireY1-smallCircleRadiusOfTires, 2*smallCircleRadiusOfTires, 2*smallCircleRadiusOfTires);

        // Drawing the second tire with two Circles..
        g.drawOval(xc+tireX2-bigCircleRadiusOfTires, yc+tireY2-bigCircleRadiusOfTires, 2*bigCircleRadiusOfTires, 2*bigCircleRadiusOfTires);
        g.drawOval(xc+tireX2-smallCircleRadiusOfTires, yc+tireY2-smallCircleRadiusOfTires, 2*smallCircleRadiusOfTires, 2*smallCircleRadiusOfTires);


        ////////////////////////////////////////////////////////////////////
        ///////////////////   Tires Lines In Red Color   ///////////////////
        ////////////////////////////////////////////////////////////////////

        g.setColor(Color.red);

        // Determine the points to draw the first line in the two tires..
        n11=(int)Math.round(smallCircleRadiusOfTires*Math.cos((a1)*Math.PI/180));
        m11=(int)Math.round(smallCircleRadiusOfTires*Math.sin((a1)*Math.PI/180));
        n31=(int)Math.round(bigCircleRadiusOfTires*Math.cos((a1)*Math.PI/180));
        m31=(int)Math.round(bigCircleRadiusOfTires*Math.sin((a1)*Math.PI/180));

        // Draw the first line in tire one..
        g.drawLine(xc+tireX1+n11, yc+tireY1+m11, xc+tireX1+n31, yc+tireY1+m31);

        // Draw the first line in tire two..
        g.drawLine(xc+tireX2+n11, yc+tireY2+m11, xc+tireX2+n31, yc+tireY2+m31);


        // Determine the points to draw the second line in the two tires..
        n12=(int)Math.round(smallCircleRadiusOfTires*Math.cos((a2)*Math.PI/180));
        m12=(int)Math.round(smallCircleRadiusOfTires*Math.sin((a2)*Math.PI/180));
        n32=(int)Math.round(bigCircleRadiusOfTires*Math.cos((a2)*Math.PI/180));
        m32=(int)Math.round(bigCircleRadiusOfTires*Math.sin((a2)*Math.PI/180));

        // Draw the second line in tire one..
        g.drawLine(xc+tireX1+n12, yc+tireY1+m12, xc+tireX1+n32, yc+tireY1+m32);

        // Draw the second line in tire two..
        g.drawLine(xc+tireX2+n12, yc+tireY2+m12, xc+tireX2+n32, yc+tireY2+m32);


        // Determine the points to draw the third line in the two tires..
        n13=(int)Math.round(smallCircleRadiusOfTires*Math.cos((a3)*Math.PI/180));
        m13=(int)Math.round(smallCircleRadiusOfTires*Math.sin((a3)*Math.PI/180));
        n33=(int)Math.round(bigCircleRadiusOfTires*Math.cos((a3)*Math.PI/180));
        m33=(int)Math.round(bigCircleRadiusOfTires*Math.sin((a3)*Math.PI/180));

        // Draw the third line in tire one..
        g.drawLine(xc+tireX1+n13, yc+tireY1+m13, xc+tireX1+n33, yc+tireY1+m33);

        // Draw the third line in tire two..
        g.drawLine(xc+tireX2+n13, yc+tireY2+m13, xc+tireX2+n33, yc+tireY2+m33);


        // Determine the points to draw the fourth line in the two tires..
        n14=(int)Math.round(smallCircleRadiusOfTires*Math.cos((a4)*Math.PI/180));
        m14=(int)Math.round(smallCircleRadiusOfTires*Math.sin((a4)*Math.PI/180));
        n34=(int)Math.round(bigCircleRadiusOfTires*Math.cos((a4)*Math.PI/180));
        m34=(int)Math.round(bigCircleRadiusOfTires*Math.sin((a4)*Math.PI/180));

        // Draw the fourth line in tire one..
        g.drawLine(xc+tireX1+n14, yc+tireY1+m14, xc+tireX1+n34, yc+tireY1+m34);

        // Draw the fourth line in tire two..
        g.drawLine(xc+tireX2+n14, yc+tireY2+m14, xc+tireX2+n34, yc+tireY2+m34);


        ////////////////////////////////////////////////////////////////////
        //////////////////////////   Car Body   ////////////////////////////
        ////////////////////////////////////////////////////////////////////

        g.setColor(Color.blue);

        // Points for rectangle body..
        cx11=(int)Math.round((r2+16+upAndDown)*Math.cos((mainAngle-15)*Math.PI/180));
        cy11=(int)Math.round((r2+16+upAndDown)*Math.sin((mainAngle-15)*Math.PI/180));

        cx12=(int)Math.round((r2+33+upAndDown)*Math.cos((mainAngle-14)*Math.PI/180));
        cy12=(int)Math.round((r2+33+upAndDown)*Math.sin((mainAngle-14)*Math.PI/180));

        cx13=(int)Math.round((r2+33+upAndDown)*Math.cos((mainAngle+14)*Math.PI/180));
        cy13=(int)Math.round((r2+33+upAndDown)*Math.sin((mainAngle+14)*Math.PI/180));

        cx14=(int)Math.round((r2+16+upAndDown)*Math.cos((mainAngle+15)*Math.PI/180));
        cy14=(int)Math.round((r2+16+upAndDown)*Math.sin((mainAngle+15)*Math.PI/180));

        // Drawing the rectangle..
        int[] xxx1 = {xc+cx11, xc+cx12, xc+cx13, xc+cx14};
        int[] yyy1 = {yc+cy11, yc+cy12, yc+cy13, yc+cy14};
        g.drawPolygon(xxx1, yyy1, 4);


        // Points for car roof body..
        cx21=(int)Math.round((r2+29+upAndDown)*Math.cos((mainAngle-9)*Math.PI/180));
        cy21=(int)Math.round((r2+29+upAndDown)*Math.sin((mainAngle-9)*Math.PI/180));

        cx22=(int)Math.round((r2+47+upAndDown)*Math.cos((mainAngle-5)*Math.PI/180));
        cy22=(int)Math.round((r2+47+upAndDown)*Math.sin((mainAngle-5)*Math.PI/180));

        cx23=(int)Math.round((r2+47+upAndDown)*Math.cos((mainAngle+5)*Math.PI/180));
        cy23=(int)Math.round((r2+47+upAndDown)*Math.sin((mainAngle+5)*Math.PI/180));

        cx24=(int)Math.round((r2+29+upAndDown)*Math.cos((mainAngle+9)*Math.PI/180));
        cy24=(int)Math.round((r2+29+upAndDown)*Math.sin((mainAngle+9)*Math.PI/180));

        // Drawing the car roof..
        int[] xxx2 = {xc+cx21, xc+cx22, xc+cx23, xc+cx24};
        int[] yyy2 = {yc+cy21, yc+cy22, yc+cy23, yc+cy24};
        g.fillPolygon(xxx2, yyy2, 4);


        ////////////////////////////////////////////////////////////////////
        ////////////////////////////   Arrow   /////////////////////////////
        ////////////////////////////////////////////////////////////////////

        g.setColor(Color.red);

        //Determine the points of arrow..
        arrowX1=(int)Math.round(r1*Math.cos((mainAngle-5)*Math.PI/180));
        arrowY1=(int)Math.round(r1*Math.sin((mainAngle-5)*Math.PI/180));
        arrowX2=(int)Math.round(r1*Math.cos((mainAngle+5)*Math.PI/180));
        arrowY2=(int)Math.round(r1*Math.sin((mainAngle+5)*Math.PI/180));
        arrowX3=(int)Math.round((r2-2)*Math.cos((mainAngle)*Math.PI/180));
        arrowY3=(int)Math.round((r2-2)*Math.sin((mainAngle)*Math.PI/180));

        //Drawing the two lines of the arrow..

        int[] xxx3 = {xc+arrowX1, xc+arrowX3, xc+arrowX2};
        int[] yyy3 = {yc+arrowY1, yc+arrowY3, yc+arrowY2};
        g.fillPolygon(xxx3, yyy3, 3);

//		g.drawLine(xc+arrowX1, yc+arrowY1, xc+arrowX3, yc+arrowY3);
//		g.drawLine(xc+arrowX2, yc+arrowY2, xc+arrowX3, yc+arrowY3);


        //fill an oval on the head of the arrow..
        g.setColor(Color.blue);
        g.fillOval(xc+arrowX3-4, yc+arrowY3-4, 8, 8);

        g.setColor(Color.red);
        g.drawString("AL-MOTAZ BELLAH A. AHMED *_^", xc-280, yc-250);
        g.drawString("20201685", xc-219, yc-232);

    }
    public void actionPerformed(ActionEvent event) {
        repaint();
//		System.out.println(mainAngle + "    " +Integer.toString(upAndDown));

        if(count<9 && flag2) {
            upAndDown=1;
            count++;
        }
        else {
            flag2=false;
            upAndDown=5;
            count--;
            if(count==0) flag2=true;
        }

        if(mainAngle<=605 && flag) {
            if(mainAngle<=330 || mainAngle>=570) {
                mainAngle+=1;
                a1+=11;
                a2+=11;
                a3+=11;
                a4+=11;
            }
            else if(mainAngle<=360 || mainAngle>=540) {
                mainAngle+=2;
                a1+=13;
                a2+=13;
                a3+=13;
                a4+=13;
            }
            else {
                mainAngle+=3;
                a1+=15;
                a2+=15;
                a3+=15;
                a4+=15;
            }

        }
        else {
            flag = false;
            if(mainAngle<=330 || mainAngle>=570) {
                mainAngle-=1;
                a1-=11;
                a2-=11;
                a3-=11;
                a4-=11;
            }
            else if(mainAngle<=360 || mainAngle>=540) {
                mainAngle-=2;
                a1-=13;
                a2-=13;
                a3-=13;
                a4-=13;
            }
            else {
                mainAngle-=3;
                a1-=15;
                a2-=15;
                a3-=15;
                a4-=15;
            }

            if(mainAngle<=285) {
                flag=true;
            }
        }

/*
		if(mainAngle<=270 && flag) {
			mainAngle+=1;

			a1+=15;
			a2+=15;
			a3+=15;
			a4+=15;
		}
		else {
			flag = false;
			mainAngle-=1;
			a1-=15;
			a2-=15;
			a3-=15;
			a4-=15;
			if(mainAngle==0) {
				flag=true;
			}
		}
*/
    }


    public static void main(String[] args) {
        new CarAroundCircle();
    }

}