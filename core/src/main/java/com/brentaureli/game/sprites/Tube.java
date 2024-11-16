package com.brentaureli.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 100;

    private Texture topTube,bottomTube;
    private Vector2 postopTube,posbottomTube;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();

        postopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posbottomTube = new Vector2(x,postopTube.y-TUBE_GAP-bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPostopTube() {
        return postopTube;
    }

    public Vector2 getPosbottomTube() {
        return posbottomTube;
    }
}
