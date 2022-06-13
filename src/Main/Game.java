package Main;

import java.awt.*;
import java.io.Serial;

public class Game extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "Wave game", this);
    }

    public synchronized void start() {

    }

    public void run() {

    }

    public static void main(String[] args) {
        new Game();
    }
}
