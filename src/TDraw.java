import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class TDraw extends JComponent {
    public float rand= (float) (Math.random()*360);
    public float rand2= (float) (Math.random()*360);
    public float velocity=5;
    public int xDirection = (int) (Math.cos(Math.toRadians(rand)) * velocity);
    public int yDirection = (int) (Math.sin(Math.toRadians(rand2)) * velocity);
    public int lPaddleX=48;
    public int lPaddleY=490;
    public int lPaddleHeight=100;
    public int lPaddleWidth=15;
    public int ballX=960;
    public int ballY=470;
    public int ballWidthHeight=15;
    public int r=255,g=255,b=255;

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

//            g2.setClip(0,0,getWidth(),getHeight());

            if(ballX+10>getWidth()||ballX-10<0||ballX-10>getWidth()||ballX+10<0){
                xDirection*=-1;
                r = (int) (255 * Math.random());
                g = (int) (255 * Math.random());
                b = (int) (255 * Math.random());
            }
            if(ballY+10>getHeight()||ballY-5<0||ballY-10>getHeight()||ballY+10<0){
                yDirection*=-1;
                r = (int) (255 * Math.random());
                g = (int) (255 * Math.random());
                b = (int) (255 * Math.random());
            }


            ballX = (ballX + xDirection);
            ballY = (ballY + yDirection);
            System.out.println(ballX+" "+ballY);

            System.out.println(xDirection+" "+yDirection +" "+getWidth()+" "+getHeight());


        }
    }

    public void up(){

    }
    public void down(){

    }
}