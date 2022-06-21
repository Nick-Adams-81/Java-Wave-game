package Main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject{

    private Handler handler;
    Random r = new Random();

    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color color;

    int dir = 0;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        dir = r.nextInt(2);
        if(dir == 0) {
            velX = 2;
            velY = 9;
        } else if(dir == 1) {
            velX = 9;
            velY = 2;
        }

        color = new Color(red, green, blue);

    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        handler.addObject(new Trail((int)x, (int)y,  ID.Trail, color, 16, 16, 0.02f, handler));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
