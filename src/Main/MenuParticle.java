package Main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject{

    private Handler handler;
    Random r = new Random();

    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 2;
        velY = 9;

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
        handler.addObject(new Trail((int)x, (int)y,  ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
