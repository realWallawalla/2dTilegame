package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 2017-07-18.
 */
public class Assets {

    //pixels for croping out from spriteSheet, create sprite sheet with right dimenesions.
    //private static final int playerWidth = 280, playerHeight = 385;
    private static final int startButtonWidth = 201, startButtonHeight = 71;
    private static final int playerWidth = 128, playerHeight = 128;
    private static final int tileWidth = 64, tileHeight = 64;
    private static final int treeWidth = 96, treeHeight = 96;
    private static final int itemWidth = 34, itemHeight = 34;

    public static BufferedImage stone,
                                sand,
                                grass,
                                dirt,
                                sandStone,
                                tree,
                                sword;

    public  static BufferedImage[] start_button;

    public static BufferedImage[] player_up,
                                  player_left,
                                  player_down,
                                  player_right;

    public static void init(){
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheetTest.png"));
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/lama_walk.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/mapTiles.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/trees.png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/startButton.png"));
        SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/items.jpg"));

        //testSpritesheet
        /*
        player_up = new BufferedImage[1];
        player_down = new BufferedImage[1];
        player_left = new BufferedImage[1];
        player_right = new BufferedImage[1];

        player_up[0] = sheet.crop(0, 0, playerWidth, playerHeight);
        player_down[0] = sheet.crop(0, 0, playerWidth, playerHeight);
        player_left[0] = sheet.crop(0, 0, playerWidth, playerHeight);
        player_right[0] = sheet.crop(0, 0, playerWidth, playerHeight);

        */

        //Lama spritesheet

        start_button = new BufferedImage[3];

        start_button[0] = sheet4.crop(0, 0, startButtonWidth, startButtonHeight);
        start_button[1] = sheet4.crop(0, startButtonHeight, startButtonWidth, startButtonHeight);
        start_button[2] = sheet4.crop(0, startButtonHeight*2, startButtonWidth, startButtonHeight);

        player_up = new BufferedImage[4];

        player_up[0] = sheet.crop(0, 0, playerWidth, playerHeight);
        player_up[1] = sheet.crop(playerWidth, 0, playerWidth, playerHeight);
        player_up[2] = sheet.crop((playerWidth * 2), 0, playerWidth, playerHeight);
        player_up[3] = sheet.crop((playerWidth * 3), 0, playerWidth, playerHeight);

        player_left = new BufferedImage[4];

        player_left[0] = sheet.crop(0, playerHeight, playerWidth, playerHeight);
        player_left[1] = sheet.crop(playerWidth, playerHeight, playerWidth, playerHeight);
        player_left[2] = sheet.crop((playerWidth * 2), playerHeight, playerWidth, playerHeight);
        player_left[3] = sheet.crop((playerWidth * 3), playerHeight, playerWidth, playerHeight);

        player_down = new BufferedImage[4];

        player_down[0] = sheet.crop(0, (playerHeight * 2), playerWidth, playerHeight);
        player_down[1] = sheet.crop(playerWidth, (playerHeight * 2), playerWidth, playerHeight);
        player_down[2] = sheet.crop((playerWidth *2), (playerHeight * 2), playerWidth, playerHeight);
        player_down[3] = sheet.crop((playerWidth *3), (playerHeight * 2), playerWidth, playerHeight);

        player_right = new BufferedImage[4];

        player_right[0] = sheet.crop(0, (playerHeight *3), playerWidth, playerHeight);
        player_right[1] = sheet.crop(playerWidth, (playerHeight *3), playerWidth, playerHeight);
        player_right[2] = sheet.crop((playerWidth *2), (playerHeight *3), playerWidth, playerHeight);
        player_right[3] = sheet.crop((playerWidth *3), (playerHeight *3), playerWidth, playerHeight);


        stone = sheet2.crop(0, 0, tileWidth, tileHeight); // second grid space and so on. STONE
        sand = sheet2.crop(0, tileHeight, tileWidth, tileHeight); // second grid space and so on, when changing row, y = height.
        grass = sheet2.crop(0, (tileHeight * 2), tileWidth, tileHeight);
        dirt = sheet2.crop(0, (tileHeight * 3), tileWidth, tileHeight);
        sandStone = sheet2.crop(0, (tileHeight * 4), tileWidth, tileHeight);
        tree = sheet3.crop(0, 0, treeWidth, treeHeight);
        sword = items.crop(0, 0, itemWidth, itemHeight);
        //...

    }
}
