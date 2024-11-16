package com.brentaureli.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brentaureli.game.FlappyDemo;
import com.brentaureli.game.sprites.Bird;
import com.brentaureli.game.sprites.Tube;

import java.awt.image.BaseMultiResolutionImage;

public class PlayState extends State{

    private Bird bird;
    private Texture bg;
    private Tube tube;
    public PlayState(GameStateManager gsm){
        super(gsm);
        bird = new Bird(50,100);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);
        bg = new Texture("bg.png");
        tube = new Tube(100);
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.y-(cam.viewportWidth/2),0);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        sb.draw(tube.getTopTube(),tube.getPostopTube().x,tube.getPostopTube().y);
        sb.draw(tube.getBottomTube(),tube.getPosbottomTube().x,tube.getPosbottomTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
