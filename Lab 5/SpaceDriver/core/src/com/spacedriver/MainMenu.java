package com.spacedriver;

import javafx.scene.media.MediaPlayer;

/**
 * Created by NEXUS on 09.05.2016.
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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import com.badlogic.gdx.math.Rectangle;

public class MainMenu {
    SpriteBatch batch;
    Texture bg, title, play_btn_texture;
    Rectangle play_btn,touch;
    Music mus;

    public MainMenu(){
        batch = new SpriteBatch();
        bg = new Texture("main_bg.png");
        title = new Texture("main_title.png");

        play_btn_texture = new Texture("play_button.png");
        play_btn = new Rectangle();
        play_btn.x = ((int) Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 2.4f /2 );
        play_btn.y = ((int) Gdx.graphics.getHeight() / 2 -Gdx.graphics.getHeight() / 3.6f /2 ) ;
        play_btn.width = ((int) Gdx.graphics.getWidth() / 2.4f);
        play_btn.height = ((int) Gdx.graphics.getHeight() / 3.6f);

        touch = new Rectangle();

        mus = Gdx.audio.newMusic(Gdx.files.internal("audio/main.mp3"));
        mus.setVolume(0.8f);

        Gdx.input.setCatchBackKey(true);
    }

    public int draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        mus.play();

        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(title, 0, (int) (Gdx.graphics.getHeight() / 1.3), Gdx.graphics.getWidth(), (int) (Gdx.graphics.getHeight() / 4.6));
        batch.draw(play_btn_texture, play_btn.x, play_btn.y, play_btn.width, play_btn.height);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            //do nothing
        }

        if(Gdx.input.isTouched()) {

            touch.x = Gdx.input.getX() - 8;
            touch.y = Gdx.graphics.getHeight() - Gdx.input.getY() - 8;
            touch.width = 16;
            touch.height = 16;

            if (touch.overlaps(play_btn)) {
                mus.stop();
                return 1;
            }
        }
        return 3;
    }
}
