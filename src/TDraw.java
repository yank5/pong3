import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class TDraw extends JComponent {
    public int rand= (int) (Math.random()*180);
    public int rand2= (int) (Math.random()*180);
    public int lPaddleX=48;
    public int lPaddleY=490;
    public int lPaddleHeight=100;
    public int lPaddleWidth=15;
    public int ballX=960;
    public int ballY=470;
    public int ballWidthHeight=15;
    public int r=255,g=255,b=255;
    public float velocity=4;
    public Graphics2D g2;
    public static boolean active;

    public void paintComponent(Graphics gr) {
        g2 = (Graphics2D) gr;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.drawRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.fillRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.setColor(new Color(r, g, b));
        g2.drawOval(ballX, ballY, ballWidthHeight, ballWidthHeight);
        g2.fillOval(ballX, ballY, ballWidthHeight, ballWidthHeight);
        super.paintComponent(g2);

//        System.out.println(g2.getClip().getBounds().width);
//        ballX*=1.5;
//        ballY*=1.5;
//        System.out.println(ballY);





    }

    public void upd() {



        if(active) {
            Point mouse = Main.frame.getMousePosition();
            if (mouse != null) {
                if(mouse.y-50>0) {
                    if ((mouse.y + 50 < getHeight())) //mouse y less than height of panel //if in bounds do this
                        lPaddleY = mouse.y - 50; //mouse is center of paddle
                }
            }
        }


        if(!Main.label.isVisible()){
            int xDirection = (int) (Math.sin(Math.toRadians(rand)) * velocity);
            int yDirection = (int) (Math.cos(Math.toRadians(rand2)) * -velocity);

            ballX = ballX + xDirection;
            ballY = ballY + yDirection;

            r = (int) (255 * Math.random());
            g = (int) (255 * Math.random());
            b = (int) (255 * Math.random());
        }
    }

    public void up(){

    }
    public void down(){

    }
}