package states;

import entities.creatures.Player;
import game.Game;
import tiles.Tile;
import worlds.World;

import java.awt.*;

/**
 * Created by Administrator on 2017-07-22.
 */
public class GameState extends State {
    private Player player;
    private World world;

    public GameState(Game game){
        super(game);
        player = new Player(game, 50,50);
        world = new World("");

    }

    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);


    }
}
