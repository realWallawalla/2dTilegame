package states;

import entities.creatures.Player;

import java.awt.*;

/**
 * Created by Administrator on 2017-07-22.
 */
public class GameState extends State {
    private Player player;

    public GameState(){
        player = new Player(50,50);

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
