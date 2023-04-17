import javax.swing.*;
import java.awt.*;

public class TDraw extends JComponent {
    public int lPaddleX=48;
    public int lPaddleY=390;
    public int lPaddleHeight=100;
    public int lPaddleWidth=15;
    public int ballX=960;
    public int ballY=470;
    public int ballWidthHeight =20;
    public Graphics2D g2;
    public static boolean active;

    public void paintComponent(Graphics g){

        g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g2);
        g2.setColor(Color.WHITE);
        g2.drawRect(lPaddleX, lPaddleY,lPaddleWidth,lPaddleHeight);
        g2.fillRect(lPaddleX, lPaddleY,lPaddleWidth,lPaddleHeight);


        g2.drawOval(ballX,ballY, ballWidthHeight, ballWidthHeight);
        g2.fillOval(ballX,ballY, ballWidthHeight, ballWidthHeight);


//        System.out.println(        g2.getClipBounds().height);
        if(active) {
            if ((lPaddleY < getHeight() - lPaddleHeight))
                lPaddleY = MouseInfo.getPointerInfo().getLocation().y - lPaddleHeight;

        }
    }

    public void upd(){
        repaint();
    }

    public void up(){

    }
    public void down(){

    }
}