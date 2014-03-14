package SoftwareEngineering.group4.StrikeMouse;

import com.badlogic.gdx.ApplicationListener;
import SoftwareEngineering.group4.StrikeMouse.game.WorldController;
import SoftwareEngineering.group4.StrikeMouse.game.WorldRenderer;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.assets.AssetManager;
import SoftwareEngineering.group4.StrikeMouse.game.Assets;

public class StrikeMouseMain implements ApplicationListener {	
	private static final String TAG = StrikeMouseMain.class.getName();
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;
	
	@Override public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		Assets.instance.init(new AssetManager());
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		
		paused = false;
	}
	
	@Override public void render () {
		if (!paused){
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(128/255.0f, 255/255.0f, 255/255.0f, 0xff/255.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		worldRenderer.render();
	}
	
	@Override public void resize (int width, int height) {
		worldRenderer.resize(width, height);
	}
	
	@Override public void dispose () {
		worldRenderer.dispose();
		Assets.instance.dispose();
	}
	
	@Override public void pause () {
		paused = true;
	}
	
	@Override public void resume () {
		Assets.instance.init(new AssetManager());
		paused = false;
	}	
}
