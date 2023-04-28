import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_P){
            Main.label.setVisible(true);
            Main.label.setText("Paused, click on screen to resume");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
