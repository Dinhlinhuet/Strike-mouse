package SoftwareEngineering.group4.StrikeMouse.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import SoftwareEngineering.group4.StrikeMouse.util.Constants;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class WorldRenderer implements Disposable {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	
	public WorldRenderer (WorldController worldController) {
		this.worldController = worldController;
		init();
	}
	
	private void init () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();		
	}
	
	public void render () {
		renderTestObjects();
	}
	
	private void renderTestObjects(){
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Sprite spr : worldController.testSprites) {
			spr.draw(batch);
		}
		batch.end();
	}
	
	public void resize (int width, int height) {
//		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.viewportHeight = (Constants.VIEWPORT_WIDTH / width) * height;
		camera.update();	
	}
	
	@Override public void dispose () {
		batch.dispose();
	}
}