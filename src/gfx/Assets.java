package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 2017-07-18.
 */
public class Assets {

    //pixels for croping out from spriteSheet, create sprite sheet with right dimenesions.
    private static final int width = 230, height = 280;
    private static final int width2 = 64, height2 = 64;

    public static BufferedImage player, stone, sand, grass, dirt, sandStone;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheetTest.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/mapTiles.png"));

        player = sheet.crop(50, 50, width, height); // first grid space. PLAYER
        stone = sheet2.crop(0, 0, width2, height2); // second grid space and so on. STONE
        sand = sheet2.crop(0, height2, width2, height2); // second grid space and so on, when changing row, y = height.
        grass = sheet2.crop(0, (height2 * 2), width2, height2);
        dirt = sheet2.crop(0, (height2 * 3), width2, height2);
        sandStone = sheet2.crop(0, (height2 * 4), width2, height2);
        //...

    }
}
