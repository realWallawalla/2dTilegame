package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 2017-07-18.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int witdh, int height){
        return sheet.getSubimage(x, y, witdh, height); // crops image, (x, y) start position.
    }
}
