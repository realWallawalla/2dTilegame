package states;

import entities.creatures.Player;
import game.Game;
import game.Handler;
import tiles.Tile;
import worlds.World;

import java.awt.*;

/**
 * Created by Administrator on 2017-07-22.
 */
public class GameState extends State {
    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler, 50,50);

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
