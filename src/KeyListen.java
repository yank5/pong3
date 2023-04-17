import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
            Main.draw.down();
        else if(e.getKeyCode()==KeyEvent.VK_UP)
            Main.draw.up();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
