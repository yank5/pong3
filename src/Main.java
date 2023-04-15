import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Main extends JFrame implements KeyListener {
    private static TDraw draw;
    public static boolean[] keys =new boolean[2400];


    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    public void update() {
        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
            draw.up();
        }
        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
            draw.down();
        }
    }
    public Main() {
        draw = new TDraw();
        addKeyListener(this);
        setResizable(false);
    }

    public static void main(String[] args) throws InterruptedException {
        Arrays.fill(keys,false);
        Main frame = new Main();
//        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        frame.setTitle("Pong2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(frame.draw);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().add(draw);
        frame.setSize(900,900);
        frame.setVisible(true);
        final int[] t = {0};
        Action action=new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t[0]++;
                System.out.println(t[0]);
                frame.update();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        Timer timer=new Timer(0,action);
        timer.start();




    }
}