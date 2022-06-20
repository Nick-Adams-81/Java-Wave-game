package Main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, 370, 200, 200, 64)) {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
        }


    }

    public void mouseRelease(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
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
