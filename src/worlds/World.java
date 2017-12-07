package worlds;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Tree;
import game.Handler;
import items.ItemManager;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width;
    private int height;
    private int spawnX, spawnY;
    private int[][] tiles;
    //Entities
    private EntityManager entityManager;
    //Item
    private ItemManager itemManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100,100));
        itemManager = new ItemManager(handler);

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        entityManager.addEntity(new Tree(handler, 100, 150));

    }

    public void tick(){
        itemManager.tick();
        entityManager.tick();

    }

    public void render(Graphics g){
        // tiles player can see so instead of render every tile. Render only tiles currently in camera.
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH); // check if offsetcamera is greater than 0. divide by tilewidth to get in tiles instead of pixelss
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0 , handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT + 1);

        for (int y = yStart ; y<yEnd ;y++){
            for (int x = xStart ; x<xEnd; x++){
                getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
                //sunstract x and y offset when screem is rendered. will move camera.
            }
        }


        //Items
        itemManager.render(g);
        //Entities
        entityManager.render(g);

    }

    public Tile getTile(int x, int y){
        if (x < 0 || y <0 || x >=width || y >=height) // prevent error if out of bounds.
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y<height;y++){
            for (int x = 0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x+y * width) + 4]);
            }
        }

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }
}
