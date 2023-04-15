import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class TDraw extends JComponent {
    public int x=25;
    public int y=250;
    public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setRenderingHint(RenderingHints.KEY_DITHERING,RenderingHints.VALUE_DITHER_ENABLE);
        super.paintComponent(g2);
        g2.drawRect(x,y,15,100);
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,15,100);
        g2.drawOval(450,450,);
    }
    public void up(){

        y-=1;
        repaint();
    }
    public void down(){
        y+=1;
        repaint();
    }
}