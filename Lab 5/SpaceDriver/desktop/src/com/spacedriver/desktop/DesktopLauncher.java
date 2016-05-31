package com.spacedriver.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.spacedriver.SpaceDriver;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//screen size
		config.width =800; //800
		config.height = 480; //480
		//screen size
		new LwjglApplication(new SpaceDriver(), config);
	}
}
