package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Resource {

	public static final Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	public static BufferedImage bombSprite;
	public static BufferedImage barrierSprite;
	public static BufferedImage speedUpSprite;
	public static BufferedImage speedDownSprite;
	public static BufferedImage reducerSprite;
	public static BufferedImage devastatorSprite;
	public static AudioClip coinSound;
	public static AudioClip bombSound;
	static {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			bombSprite = ImageIO.read(loader.getResource("bomb.png"));
			barrierSprite = ImageIO.read(loader.getResource("barr.png"));
			speedUpSprite = ImageIO.read(loader.getResource("up.png"));
			speedDownSprite = ImageIO.read(loader.getResource("down.png"));
			reducerSprite = ImageIO.read(loader.getResource("reduce.png"));
			devastatorSprite = ImageIO.read(loader.getResource("devas.png"));
			coinSound = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
			bombSound = Applet.newAudioClip((loader.getResource("bomb.wav")).toURI().toURL());
			
		} catch (Exception e) {
			bombSprite = null;
			barrierSprite = null;
			speedUpSprite = null;
			speedDownSprite = null;
			reducerSprite = null;
			devastatorSprite = null;
			coinSound = null;
			bombSound = null;
		}
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

}
