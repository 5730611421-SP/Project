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
	public static BufferedImage appleSprite;
	public static AudioClip coinSound;
	public static AudioClip bombSound;

	static {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			appleSprite = ImageIO.read(loader.getResource("Apple.png"));
			coinSound = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
			bombSound = Applet.newAudioClip((loader.getResource("bomb.wav")).toURI().toURL());
		} catch (Exception e) {
			appleSprite = null;
			coinSound = null;
			bombSound = null;
		}
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

}
