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
        Font font = new Font("arial", 1, 50);
        Font font2 = new Font("arial", 1, 50);

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Menu", 400, 150);


        g.setColor(Color.WHITE);
        g.drawRect(370, 200, 200, 64);
        g.setColor(Color.GREEN);
        g.drawString("Play", 420, 247);


        g.setColor(Color.WHITE);
        g.drawRect(370, 300, 200, 64);
        g.setColor(Color.YELLOW);
        g.drawString("Help", 420, 347);

        g.setColor(Color.WHITE);
        g.drawRect(370, 400, 200, 64);
        g.setColor(Color.RED);
        g.drawString("Quit", 420, 447);
    }
}
