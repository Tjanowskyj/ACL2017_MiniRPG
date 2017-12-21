package Model;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Robot extends Monstre {

    private static Animation base;

    public Robot(int x, int y, int hp) {
        super(x, y, hp);
    }

    @Override
    public void changeX(int x, TiledMap map) {
        int frontiere = map.getLayerIndex("Frontières");
        int obstacle = map.getLayerIndex("Obstacles");
        if (map.getTileId(this.posX + x, this.posY, frontiere) == 0
                && map.getTileId( this.posX + x, this.posY, obstacle) == 0) {
            this.posX += x;
        }
    }

    @Override
    public void changeY(int y, TiledMap map) {
        int frontiere = map.getLayerIndex("Frontières");
        int obstacle = map.getLayerIndex("Obstacles");
        if (map.getTileId(this.posX, this.posY + y, frontiere) == 0
                && map.getTileId( this.posX , this.posY + y, obstacle) == 0) {
            this.posY += y;
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.image = new Image("res/sprites/robot_sprites.png");
        SpriteSheet s = new SpriteSheet("res/sprites/robot_sprite.png",
                32, 32);
        this.base = new Animation();
        for(int i = 0;i < 3;i++){
            this.base.addFrame(s.getSprite(i, 0), 150);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.base.draw(this.posX * 32, this.posY * 32);

    }
}
