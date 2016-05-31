package com.spacedriver;

/**
 * Created by NEXUS on 11.05.2016.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import com.badlogic.gdx.math.Rectangle;

public class Barrier {
    SpriteBatch batch;

    Texture barier_up, barier_down;

    Rectangle rect_up, rect_down;

    int space, coef;

    public Barrier(){
        coef = 1200/Gdx.graphics.getWidth();

        batch = new SpriteBatch();
        barier_up = new Texture("barier.png");
        barier_down = new Texture("barier.png");

        rect_up = new Rectangle();
        rect_up.width = coef*60;
        rect_up.height = coef*286;
        rect_down = new Rectangle();
        rect_down.width = coef*60;
        rect_down.height = coef*286;

        space = Gdx.graphics.getHeight()/6*4;
    }

    public void reset(){
        space = Gdx.graphics.getHeight()/6*4;
    }

    public Rectangle getRectUp(){
        return rect_up;
    }
    public Rectangle getRectDown(){
        return rect_down;
    }

    public void setPos(int x, int height){
        rect_down.x=x;
        rect_down.y=height-coef*286;
        rect_up.x=x;
        rect_up.y=height+space;
    }

    public void draw(){
        batch.begin();
        batch.draw(barier_down, rect_down.x, rect_down.y, rect_down.width, rect_down.height);
        batch.draw(barier_up, rect_up.x, rect_up.y, rect_down.width, rect_up.height);
        batch.end();
    }

    public void setSpace(int new_space){
        space=new_space;
    }
    public int getSpace(){
        return space;
    }
    public int getWidth(){
        return 60*coef;
    }
}
