package gfx;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class Animation {
    private int speed,
                index;
    private long lastTime,
                 timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        lastTime = System.currentTimeMillis();
        timer = 0;
        index = 0;
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;//how many milliseconds since start of program - lastTime. gives time since tick method last was called
        lastTime = System.currentTimeMillis();

        if (timer > speed ){
            index++;
            timer = 0;
            if (index >= frames.length){
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
