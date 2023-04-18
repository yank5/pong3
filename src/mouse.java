import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class mouse implements MouseListener {
    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    Cursor defcurs=new Cursor(Cursor.DEFAULT_CURSOR);
    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");


    @Override
    public void mouseClicked(MouseEvent e) {
        if(!Main.label.getText().equals(""))
            Main.label.setText("");Main.label.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        TDraw.active=true;
//        Main.frame.setCursor(blankCursor);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        TDraw.active=false;
//        Main.frame.setCursor(defcurs);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
