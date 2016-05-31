package com.spacedriver;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

import javafx.scene.media.MediaPlayer;

public class SpaceDriver extends ApplicationAdapter {
	MainMenu menu;
	PauseMenu pmen;
	Game game;
	ScoreMenu score;
	int game_on;
	@Override
	public void create () {
		menu = new MainMenu();
		pmen = new PauseMenu();
		game = new Game();
		score = new ScoreMenu();
		game_on = 3;
	}

	@Override
	public void render () {
		if(game_on==1) {
			game_on = game.start();
			score.setScore(game.getScore());
		}
		if(game_on==2){
			game_on = pmen.draw();
			//game.reset();
		}
		if(game_on==3){
			game_on = menu.draw();
			game.reset();
		}
		if(game_on==4){
			game_on = score.draw();
			game.reset();
		}
	}
	public void pause() {
		//activarea PauseMeni-ului la iesirea din program
		game_on=2;
		game_on = pmen.draw();
	}
}
