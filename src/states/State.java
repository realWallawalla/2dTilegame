package states;

import java.awt.*;

/**
 * Created by Administrator on 2017-07-19.
 */
public abstract class State {
    // abstract clasees exist to be extended. they cannont be instansiated i.e. creating an object.
    // benfit: you can create abstract methods. abstract methods are defined in the class that extend it.

    // state manager, nothing to do with abstrack just methotds for tick and render different gameStates.
    private static State currentState = null;

    public static void setStete (State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }



    // this waht the abstract CLASS does, above is the stateManager
    public abstract void tick();

    public abstract void render(Graphics g);

}
