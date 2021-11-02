import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

public class TurkBayragi extends JPanel {
    private int G;

    @Override
    protected void paintComponent(Graphics g) {
        doDrawing(g);
    }


    private void doDrawing(Graphics g) {
        G = this.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        Color zeminRenk = new Color(227, 10, 23);
        g2d.setColor(zeminRenk);
        g2d.fillRect((G * 1 / 30), 0, (int) (this.getWidth()) - G * 1 / 30, this.getHeight());
        g2d.setColor(Color.white);
        g2d.fillOval((int) (G * 1/2)-(int)(G*1/4)+(G*1/30),
                G-(int)(G*3/4),
                G*1/2,
                G*1/2);

        g2d.setColor(zeminRenk);
        g2d.fillOval((int) (G * 1 / 2 + G * 1 / 16 + G * 1 / 30 - G * 1 / 5),
                (int) (G * 1 / 2 - G * 1 / 5),
                (int) (G * 2 / 5),
                (int) (G * 2 / 5));
        Point center = new Point((int) (((G*1/2) + (G*1/30)+(G*1/16))-(G*0.2)+(G*1/3)+(G*1/8)), G*1/2 - G*1/8+G*1/8);
        int counter=0;

        Point[] koseler = new Point[5];

        g2d.setColor(Color.white);
        for(int radius = G*1/8; radius>0; radius--)
        {
            counter=0;
            for(int a=36; a<360; a+=72)
            {
                koseler[counter]=CalcPoint(center, radius, a);
                counter++;
            }

            for(int a = 0; a<5; a++)
            {
                Line2D l1 = new Line2D.Double(koseler[a], koseler[(a+2)%5]){};
                Line2D l2 = new Line2D.Double(koseler[(a+1)%5], koseler[(a+4)%5]){};

                g2d.draw(l1);
                g2d.draw(l2);
            }
        }
    }

    private Point CalcPoint(Point p, int radius, int angle)
    {
        int newX, newY;
        newX = (int) (p.x + radius * Math.cos(Math.toRadians(angle)));
        newY = (int) (p.y + radius * Math.sin(Math.toRadians(angle)));

        return new Point(newX, newY);
    }
}


