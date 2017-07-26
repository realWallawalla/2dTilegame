package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 2017-07-18.
 */
public class Assets {

    //pixels for croping out from spriteSheet, create sprite sheet with right dimenesions.
    private static final int width = 230, height = 280;

    public static BufferedImage player, player2, player3;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheetTest.png"));

        player = sheet.crop(50, 50, width, height); // first grid space
        player2 = sheet.crop(width, 0, width, height); // second grid space and so on
        player3 = sheet.crop(width * 2, 0, width, height); // second grid space and so on, when changing row, y = height.
        //...

    }
}
