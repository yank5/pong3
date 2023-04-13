import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class TDraw extends JComponent {
    public int x=25;
    public int y=250;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(x,y,25,150);
        g.setColor(Color.WHITE);
        g.fillRect(x,y,25,150);
    }
    public void up(){
        y+=5;
        repaint();
    }
    public void down(){
        y-=5;
        repaint();
    }
}
