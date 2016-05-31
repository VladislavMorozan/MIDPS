package com.spacedriver;

/**
 * Created by NEXUS on 09.05.2016.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Game {
    SpriteBatch batch;
    Texture bg, ship_img,pause_texture;

    Rectangle ship, pause_button, touch;

    Music mus;

    BitmapFont font;

    int score,speed;

    Barrier[] barier;
    int[] pos, height;

    boolean s;

    private int new_height(int prev_height){
        int nh=prev_height;
        Random rn = new Random();
        int i = rn.nextInt(2);
        if(i==0) nh-=5;
        if(i==1) nh+=5;
        if(nh>Gdx.graphics.getHeight()-barier[0].getSpace()-50) nh-=5;
        if(nh<50) nh+=5;
        return nh;
    }

    public int getScore(){
        return score;
    }

    public Game(){
        batch=new SpriteBatch();
        bg = new Texture("game_bg.png");

        ship_img = new Texture("ship.png");
        ship = new Rectangle();
        ship.x = 30;
        ship.y = Gdx.graphics.getHeight()/5*2;
        ship.width = Gdx.graphics.getWidth()/9.5f;
        ship.height = Gdx.graphics.getHeight()/13;

        pause_texture = new Texture("pause_button.png");
        int dim = Gdx.graphics.getHeight()/6;
        pause_button = new Rectangle();
        pause_button.x = Gdx.graphics.getWidth() - dim;
        pause_button.y = Gdx.graphics.getHeight() -dim;
        pause_button.width = dim;
        pause_button.height = dim;

        touch = new Rectangle();

        mus = Gdx.audio.newMusic(Gdx.files.internal("audio/music.mp3"));
        mus.setVolume(0.7f);

        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(Gdx.graphics.getHeight() / 130);

        score = 0;
        speed = 1;

        barier = new Barrier[16];
        for(int i=0;i<16;i++){
            barier[i] = new Barrier();
        }

        pos =  new int[16];
        height =  new int[16];
        for(int i=0;i<16;i++){
            if(i==0) height[i]=Gdx.graphics.getHeight()/2-barier[0].getSpace()/2;
            else height[i]=new_height(height[i-1]);            //aici este inaltimea
            if(i==0) pos[i]=0-barier[i].getWidth();
            else pos[i]=pos[i-1]+barier[i].getWidth();
        }

        s=true;
    }

    public void reset(){
        ship.y = Gdx.graphics.getHeight()/5*2;
        score = 0;
        speed = 0;
        for(int i=0;i<16;i++) barier[i].reset();
    }

    public int start(){

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        mus.play();

        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        for(int i=0;i<16;i++){
            pos[i]-=speed;
            if(pos[i]<-barier[i].getWidth()){
                pos[i]+=(Gdx.graphics.getWidth()+40+2*barier[i].getWidth());
                if(i==0) height[i]=new_height(height[15]);
                else height[i]=new_height(height[i-1]);
            }
            barier[i].setPos(pos[i], height[i]);
            barier[i].draw();
        }



        if(score%1000==0&&speed<50) speed++;
        if(score%3000<10&&score>10&&score<75000&&s){
            for(int i=0;i<16;i++){
                barier[i].setSpace(barier[i].getSpace()-10);
            }
            s=false;
        }
        else{
            s= true;
        }

        batch.begin();
        batch.draw(ship_img, ship.x, ship.y, ship.width, ship.height);
        batch.draw(pause_texture, pause_button.x, pause_button.y, pause_button.width, pause_button.height);
        font.draw(batch, "" + score, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 15 * 14);
        batch.end();

        score+=speed;

        //touch & miscarea navei sus/jos
        if(Gdx.input.isTouched()) {
            touch.x = Gdx.input.getX() - 8;
            touch.y = Gdx.graphics.getHeight() - Gdx.input.getY() - 8;
            touch.width = 16;
            touch.height = 16;
            if (touch.overlaps(pause_button)) {
                mus.stop();
                return 2;
            }
            if(ship.y<=(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/9.5f-4)) {
                ship.y+=3;
            }
        }
        else if(ship.y>=3){
            ship.y-=2;
        }
        //////

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            mus.stop();
            return 2;
        }

        for(int i=0;i<16;i++){
            if(ship.overlaps(barier[i].getRectDown())||ship.overlaps(barier[i].getRectUp())) {
                mus.stop();
                return 4;
            }
        }



        return 1;
    }
}
