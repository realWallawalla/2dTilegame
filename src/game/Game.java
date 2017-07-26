package game;

import com.company.Display;
import states.GameState;
import states.MenuState;
import states.State;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Administrator on 2017-07-17.
 */
public class Game implements Runnable { //implements runnable which allows to run on a thread.
    private Display display;
    public int witdh;
    public int height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;


    public Game(String title, int witdh, int height){
        this.witdh = witdh;
        this.height = height;
        this.title = title;

    }



    public synchronized void start(){
        if(running){ // acting as safety if method is reintialized i.e. if already running return prevents reinitializing.
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
        // calls run method. game logic
    }

    private void init(){
        display = new Display(title, witdh, height);
        Assets.init(); // loads all images, music etcetera once.
        gameState = new GameState();
        menuState = new MenuState();
        State.setStete(gameState);
//        State.setStete(menuState);

    }

    public void run(){
        init(); // calls init

        int fps = 60; // frame per seconds. amount if time tick snd render is called.
        double timePerTick = 1000000000/fps; // 1billion nano seconds = 1second. max time to achieve 60 fps.
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while(running){ //game loop tick and render, calls methods
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now; // last time is the time when the code above was ran latest.

            if (delta >= 1) { // if delta greater then one. have to tick and render otherwise we will not have 60 fps.
                tick();
                render();
                ticks++;
                delta--; // ticket delta -1;
            }
            if (timer >= 1000000000) {
                System.out.println("ticks and frames: " + ticks + " " + timer);
                ticks = 0; // reset ticks and timer.
                timer = 0;
            }

        }
        stop();
    }

    public synchronized void stop(){ // closes thread
        if (!running) // acting as safety if method is reintialized
            return;
        running = false;
        try {
            thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }


    private void tick(){ //updates game
        if (State.getState() != null){
            State.getState().tick();
        }

    }

    private void render(){ //renders game (draw things)
        bs = display.getCanvas().getBufferStrategy(); // bufferedstragey is a way to draw things to a screen
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics(); // draw graphics with bufferstrategy
        //Clear the screen
        g.clearRect(0,0, witdh, height);
        //draw here

        if (State.getState() != null){
            State.getState().render(g);
        }

        //end drawing
        bs.show();
        g.dispose();
    }
}
