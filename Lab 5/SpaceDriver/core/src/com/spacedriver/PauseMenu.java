package com.spacedriver;

/**
 * Created by NEXUS on 13.05.2016.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import com.badlogic.gdx.math.Rectangle;

public class PauseMenu {
    SpriteBatch batch;
    Texture bg, resume_texture, menu_texture;
    Rectangle resume, menu, touch;

    public PauseMenu(){
        batch = new SpriteBatch();

        bg = new Texture("game_bg.png");

        resume_texture = new Texture("resume_button.png");
        menu_texture = new Texture("menu_button.png");

        resume = new Rectangle();
        resume.x = ((int) Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 2.4f /2 );
        resume.y = ((int) Gdx.graphics.getHeight() / 2 -Gdx.graphics.getHeight() / 3.6f /2 )+100 ;
        resume.width = ((int) Gdx.graphics.getWidth() / 2.4f);
        resume.height = ((int) Gdx.graphics.getHeight() / 3.6f);

        menu = new Rectangle();
        menu.x = ((int) Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 2.4f /2 );
        menu.y = ((int) Gdx.graphics.getHeight() / 2 -Gdx.graphics.getHeight() / 3.6f /2 )-100 ;
        menu.width = ((int) Gdx.graphics.getWidth() / 2.4f);
        menu.height = ((int) Gdx.graphics.getHeight() / 3.6f);

        touch = new Rectangle();
    }

    public int draw(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(resume_texture, resume.x, resume.y, resume.width, resume.height);
        batch.draw(menu_texture, menu.x, menu.y, menu.width, menu.height);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            //do nothing
        }

        if(Gdx.input.isTouched()) {

            touch.x = Gdx.input.getX() - 8;
            touch.y = Gdx.graphics.getHeight() - Gdx.input.getY() - 8;
            touch.width = 16;
            touch.height = 16;

            if (touch.overlaps(resume)){
                return 1;
            }

            if(touch.overlaps(menu)) {
                return 3;
            }
        }
        return 2;
    }

}
