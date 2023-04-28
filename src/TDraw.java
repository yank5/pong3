import javax.swing.*;
import java.awt.*;

public class TDraw extends JComponent {
    public boolean who=true;
    public int scoreL=0;
    public int scoreR=0;
    public float velocity=6F;
    public int xDir=-1;
    public int yDir=1;
    public double xMove= (Math.cos(Math.toRadians(Math.random()*20+25)));
    public double yMove= (Math.sin(Math.toRadians(Math.random()*20+25)));
//    public double xMove=Math.random()*5;
//    public double yMove=Math.random()*5;
    public int lPaddleX=48;
    public int lPaddleY=490;
    public int lPaddleHeight=100;
    public int lPaddleWidth=15;
    public int rPaddleX=1872;
    public int rPaddleY=490;
    public int rPaddleHeight=100;
    public int rPaddleWidth=15;
    public int ballX=960;
    public int ballY=470;
    public int ballWidthHeight=15;
    public int r=255,g=255,b=255;
    public boolean collided=false;

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

        g2.drawRect(rPaddleX, rPaddleY, rPaddleWidth, rPaddleHeight);
        g2.fillRect(rPaddleX, rPaddleY, rPaddleWidth, rPaddleHeight);
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


    public void _color(){
        r = (int) (255 * Math.random());
        g = (int) (255 * Math.random());
        b = (int) (255 * Math.random());
    }
    public void scored(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ballX=960;
        ballY=490;
        velocity=6F;
        if(who){
            xDir=-1;
        } else{
            xDir=1;
        }
        if(scoreL==10||scoreR==10){
            velocity=0;
            ballY=-100;
            ballX=-100;
            Main.label.setText("Game over!");
            Main.label.setVisible(true);
        }
    }
    public void upd() {


        if(!Main.label.isVisible()) {
            if(active) {
                Point mouse = Main.frame.getMousePosition();
                if (mouse != null) {
                    if(mouse.y-50>0) {
                        if ((mouse.y + 50 < getHeight())) //mouse y less than height of panel //if in bounds do this
                            lPaddleY = mouse.y - 50; //mouse is center of paddle
                    }
                }
            }


            int destY = ballY-50;
            if(ballY-50>0){
                if(ballY+50<getHeight()) {
                    if (destY > rPaddleY) {
                        rPaddleY += Math.round(velocity/yMove/2);
                    } else if (destY < rPaddleY) {
                        rPaddleY -= Math.round(velocity/yMove/2);
                    }
                }
            }

            if(!collided) {
                if (ballY >= lPaddleY - 10 && ballY <= lPaddleY + lPaddleHeight && ballX <= lPaddleX + lPaddleWidth) {
                    xDir *= -1;
                    velocity = Math.abs(lPaddleY + 50 - ballY) / 5F + 8;
//                    _color();
                    collided=true;
                }
                if (ballY >= rPaddleY - 10 && ballY <= rPaddleY + rPaddleHeight && ballX >= rPaddleX - 15) {
                    xDir *= -1;
                    velocity = Math.abs(rPaddleY + 50 - ballY) / 5F + 8;
//                    _color();
                    collided=true;
                }
                if (ballX + 15 >= getWidth()) {
                    scoreL+=1;
                    collided=true;
                    scored();
                    who=false;
                }
                if(ballX - 5 <= 0){
                    scoreR+=1;
                    collided=true;
                    scored();
                    who=true;
                }
                if (ballY + 15 >= getHeight() || ballY - 15 <= 0) {
                    yDir *= -1;
//                    _color();
                    collided=true;
                }
            }

            ballX = (int) Math.round(ballX + xMove/yMove*xDir*velocity);
            ballY = (int) Math.round(ballY + yMove/xMove*yDir*velocity);


//            ballX = (int) Math.round(ballX + 1*xDir*velocity);
//            ballY = (int) Math.round(ballY + 0.5*yDir*velocity);




//            System.out.println(Math.round(rand*velocity)+" "+Math.round(rand2*velocity));
//            System.out.println(xMove+" "+yMove);
//


        }
    }
}