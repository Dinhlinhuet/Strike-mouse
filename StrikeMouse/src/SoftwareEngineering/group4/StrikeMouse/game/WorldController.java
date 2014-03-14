package SoftwareEngineering.group4.StrikeMouse.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class WorldController {
	private static final String TAG = WorldController.class.getName();
	public Sprite[] testSprites;
	public int selectedSprite;
	
	public WorldController () {
		init();
	}
	
	private void init () {
		initTestObject();
	}
	
	private void initTestObject(){
		testSprites = new Sprite[9];
		Array<TextureRegion> regions = new Array<TextureRegion>();
		regions.add(Assets.instance.hole.hole);
		for (int i = 0; i < testSprites.length; i++) {
			Sprite spr = new Sprite(regions.random());
			spr.setSize(2, 2);
			spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
			testSprites[i] = spr;
		}
		testSprites[0].setPosition(-4, 2);
		testSprites[1].setPosition(-1, 2);
		testSprites[2].setPosition(2, 2);
		testSprites[3].setPosition(-4, -1);
		testSprites[4].setPosition(-1, -1);
		testSprites[5].setPosition(2, -1);
		testSprites[6].setPosition(-4, -4);
		testSprites[7].setPosition(-1, -4);
		testSprites[8].setPosition(2, -4);
		selectedSprite = 0;
		
//		regions.add(Assets.instance.backGround.backGround);
	}
	
	public void update (float deltaTime) {
	}
}
