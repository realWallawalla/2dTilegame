package game;

/**
 * Created by Administrator on 2017-07-17.
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Title", 400,400);
        game.start();
    }
}
