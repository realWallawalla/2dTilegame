package states;

import entities.creatures.Player;
import game.Game;

import java.awt.*;

/**
 * Created by Administrator on 2017-07-22.
 */
public class GameState extends State {
    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 50,50);

    }

    @Override
    public void tick() {
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        player.render(g);

    }
}
