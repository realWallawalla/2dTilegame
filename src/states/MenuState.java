package states;

import game.Game;
import game.Handler;
import gfx.Assets;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(100, 100, 128, 64, Assets.start_button, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setStete(handler.getGame().gameState);

            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();

        //temp go directly to game state, overtide menustate! for development lol.
        handler.getMouseManager().setUiManager(null);
        State.setStete(handler.getGame().gameState);

    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

    }
}
