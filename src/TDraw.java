import javax.swing.*;
import java.awt.*;

public class TDraw extends JComponent {
    public boolean who=true;
    public double rand=Math.random();
    public double rand2=Math.random();
    public int scoreL=0;
    public int scoreR=0;
    public float velocity=6F;
    public int xDir=-1;
    public int yDir=1;
//    public int xMove= (int) Math.round(Math.cos(Math.toRadians(45)));
//    public int yMove= (int) Math.round(Math.sin(Math.toRadians(45)));
    public float xMove=3F;
    public float yMove=2F;
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
    public TDraw(){
        super();
    }

    public void paintComponent(Graphics gr) {
        g2 = (Graphics2D) gr;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.drawRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.fillRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.setColor(new Color(r, g, b));
        g2.drawRect(ballX, ballY, ballWidthHeight, ballWidthHeight);
        g2.fillRect(ballX, ballY, ballWidthHeight, ballWidthHeight);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(getWidth()/2,0,5,980);
        g2.fillRect(getWidth()/2,0,5,980);
        g2.scale(3,3);
        g2.drawString(""+scoreL,140,30);
        g2.drawString(""+scoreR,440,30);
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

        if(!Main.label.isVisible()) {


//            g2.setClip(0,0,getWidth(),getHeight());


            if (ballX + 10 > getWidth() || ballX - 10 < 0 || ballX - 10 > getWidth() || ballX + 10 < 0) {
                xDir *= -1;
                r = (int) (255 * Math.random());
                g = (int) (255 * Math.random());
                b = (int) (255 * Math.random());
            }
            if (ballY + 10 > getHeight() || ballY - 5 < 0 || ballY - 10 > getHeight() || ballY + 10 < 0) {
                yDir *= -1;
                r = (int) (255 * Math.random());
                g = (int) (255 * Math.random());
                b = (int) (255 * Math.random());
            }


//            g2.setClip(lPaddleX,lPaddleY,lPaddleWidth,lPaddleHeight);

            //


            if (ballY > lPaddleY-10 && ballY < lPaddleY + lPaddleHeight && ballX > lPaddleX && ballX < lPaddleX + lPaddleWidth+3) {

                xDir *= -1;


                System.out.println(Math.abs(lPaddleY+50-ballY));

//                System.out.println((ballY-lPaddleY)/10F);
//
//
//                velocity=(ballY-lPaddleY)/10F;

//                System.out.println(velocity);

                r = (int) (255 * Math.random());
                g = (int) (255 * Math.random());
                b = (int) (255 * Math.random());
            }
//            if((ballX<=lPaddleX+lPaddleWidth&&ballX>=lPaddleX)&&(ballY<=lPaddleY+lPaddleHeight&&ballY>=)){
//                yDir*=-1;
//




//            ballX = Math.round(ballX + xMove/yMove*xDir*velocity);
//            ballY = Math.round(ballY + yMove/xMove*yDir*velocity);
            ballX = (int) Math.round(ballX + 1*xDir*velocity);
            ballY = (int) Math.round(ballY + 0.1*yDir*velocity);

//            System.out.println(Math.round(rand*velocity)+" "+Math.round(rand2*velocity));
//            System.out.println(xMove+" "+yMove);
//


        }
    }

    public void up(){

    }
    public void down(){

    }
}