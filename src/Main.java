import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.Arrays;

public class Main {
    public static TDraw draw;
    public static JFrame frame;
    public static JLabel label;

    private static int temp = 0;

    public static void main(String[] args) throws InterruptedException {
        frame=new JFrame("Pong3");
        draw = new TDraw();
        label=new JLabel("click to start");


//        Action down=new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                draw.down();
//            }
//        };
//        Action up=new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                draw.up();
//            }
//        };
//        draw.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
//        draw.getActionMap().put("up",up);
//        draw.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
//        draw.getActionMap().put("down",down);


        frame.add(label);
        label.setForeground(Color.WHITE);
        label.setSize(500,100);
        label.setLocation(900,400);

        frame.setResizable(false);

        frame.addKeyListener(new KeyListen());
        frame.addMouseListener(new mouse());



        frame.setSize(1920,980);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().add(draw);
        frame.setVisible(true);



        

        while (true) {
            draw.upd();
            draw.repaint();
            Thread.sleep(16);
            temp++;
            if (temp == 25) {
                temp = 0;
                draw.collided=false;
            }
        }
    }
}