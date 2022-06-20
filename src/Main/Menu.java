package Main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {


    public void mousePressed(MouseEvent e) {

    }

    public void mouseRelease(MouseEvent e) {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(370, 200, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(370, 300, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(370, 400, 200, 64);
    }
}
