package input;

public class InputUtility {
	
	private static boolean keyPressed[] = new boolean[256];
	private static int mouseX;
	
	public InputUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean getKeyPressed(int key) {
		if(key < 0 || key >= 256) return false;
		return keyPressed[key];
	}

	public static void setKeyPressed(int key, boolean keyPressed) {
		InputUtility.keyPressed[key] = keyPressed;
	}
	
	public static int getMouseX() {
		return mouseX;
	}
	public static void setMouseX(int mouseX) {
		InputUtility.mouseX = mouseX;
	}

}
