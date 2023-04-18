import javax.swing.*;
import java.awt.*;

public class TDraw extends JComponent {
    public int lPaddleX=48;
    public int lPaddleY=490;
    public int lPaddleHeight=100;
    public int lPaddleWidth=15;
    public int ballX=960;
    public int ballY=470;
    public int ballWidthHeight=15;
    public int r=1,g=1,b=1;
    public float velocity=1;
    public Graphics2D g2;
    public static boolean active;

    public void paintComponent(Graphics gr) {
        g2 = (Graphics2D) gr;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g2);
        g2.setColor(Color.WHITE);
        g2.drawRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.fillRect(lPaddleX, lPaddleY, lPaddleWidth, lPaddleHeight);
        g2.setColor(new Color(r, g, b));
        g2.drawOval(ballX, ballY, ballWidthHeight, ballWidthHeight);
        g2.fillOval(ballX, ballY, ballWidthHeight, ballWidthHeight);

        r = (int) (255 * Math.random());
        g = (int) (255 * Math.random());
        b = (int) (255 * Math.random());



//        System.out.println(Main.frame.getMousePosition().y);
        //30
        System.out.println(lPaddleY); //when -50
        System.out.println(MouseInfo.getPointerInfo().getLocation().y); //is 60
    }

    public void upd() {
        int y=MouseInfo.getPointerInfo().getLocation().y;
        if(active) {          //

//            lPaddleY=y - 60;

            if(y>0){
                if(y+10>getHeight()){
                    lPaddleY=y-60;
                }
            }

//            if ((MouseInfo.getPointerInfo().getLocation().y-10 < getHeight())) //mouse y less than height of panel //if in bounds do this
//                lPaddleY = MouseInfo.getPointerInfo().getLocation().y-110; //mouse is center of paddle
//
//            if ((MouseInfo.getPointerInfo().getLocation().y > 0)) //mouse y less than height of panel /if in bounds do this
//                lPaddleY = MouseInfo.getPointerInfo().getLocation().y; //mouse is center of paddle

        }
//        if(!Main.label.isVisible()){
//            ballX=(int) Math.sin(Math.random());
//        }
    }

    public void up(){
        System.out.println(MouseInfo.getPointerInfo().getLocation().y);
    }
    public void down(){

    }
}