package Main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        // play button
        if(mouseOver(mx, my, 370, 200, 200, 64)) {
//            game.gameState = Game.STATE.Game;
//            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
//            handler.clearEnemys();
//            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
            game.gameState = Game.STATE.Select;
            return;
        }

        // help button
        if(mouseOver(mx, my, 370, 300, 200, 64)) {
            game.gameState = Game.STATE.Help;
        }

        if(game.gameState == Game.STATE.Select) {
            // normal button
            if(mouseOver(mx, my, 370, 250, 200, 64)) {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
            handler.clearEnemys();
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));

            game.diff = 0;
            }

            // hard button
            if(mouseOver(mx, my, 370, 350, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));

                game.diff = 1;
            }
            // back button
            if(mouseOver(mx, my, 370, 450, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        // back button for help
        if(game. gameState == Game.STATE.Help) {
            if(mouseOver(mx, my, 370, 400, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        // quit button
        if(mouseOver(mx, my, 370, 430, 200, 54)) {
            System.exit(1);
        }



        // try again button
        if(Game. gameState == Game.STATE.End) {
            if(mouseOver(mx, my, 300, 600, 320, 64)) {
                Game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);

            }
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
        if (game.gameState == Game.STATE.Menu) {
            Font font = new Font("arial", 2, 50);

            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawString("Wave 10", 365, 150);


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
        } else if(game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 2, 50);
            Font font2 = new Font("arial", 2, 25);


            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Help", 420, 147);

            g.setFont(font2);
            g.drawString("Use the arrow keys to move the hero", 250, 250);
            g.drawString("Use the 'P' button to pause and unpause your game", 180, 280);

            g.setFont(font);
            g.drawRect(370, 400, 200, 64);
            g.drawString("Back", 419, 448);
        } else if(Game.gameState == Game.STATE.End) {
            Font font = new Font("arial", 2, 50);
            Font font2 = new Font("arial", 2, 25);


            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 300, 147);

            g.setFont(font2);
            g.drawString("Your Final score is: " + hud.getScore(), 300, 250);

            g.setFont(font);
            g.drawRect(300, 600, 320, 64);
            g.drawString("Main Menu", 340, 648);
        } else if(Game.gameState == Game.STATE.Select) {

            Font font = new Font("arial", 2, 50);

            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawString("Select Difficulty", 305, 150);


            g.setColor(Color.WHITE);
            g.drawRect(370, 250, 200, 64);
            g.setColor(Color.GREEN);
            g.drawString("Normal", 390, 297);


            g.setColor(Color.WHITE);
            g.drawRect(370, 350, 200, 64);
            g.setColor(Color.YELLOW);
            g.drawString("Hard", 420, 397);

            g.setColor(Color.WHITE);
            g.drawRect(370, 450, 200, 64);
            g.setColor(Color.RED);
            g.drawString("Back", 420, 497);
        }
    }
}
