package Main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

    Handler handler;
    public Shop(Handler handler) {
        this.handler = handler;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 40));
        g.drawString("Shop", Game.WIDTH / 2 - 50, 50);

    }

    public void mousePressed(MouseEvent e) {

    }
}
