package input;

public class InputUtility {
	
	private static boolean keyPressed[] = new boolean[256];
	private static boolean[] keyTriggered = new boolean[256];
	private static int mouseX;
	private static int mouseY;
	
	public InputUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean getKeyPressed(int key) {
		if(key < 0 || key >= 256) return false;
		return keyPressed[key];
	}
	public static void setKeyPressed(int key,boolean pressed) {
		if(key >= 0 && key < 256){
			InputUtility.keyPressed[key] = pressed;
		}
	}
	
	public static boolean getKeyTriggered(int key) {
		if(key < 0 || key >= 256) return false;
		return keyTriggered[key];
	}
	public static void setKeyTriggered(int key,boolean pressed) {
		if(key >= 0 && key < 256){
			InputUtility.keyTriggered[key] = pressed;
		}
	}
	
	public static int getMouseX() {
		return mouseX;
	}
	public static void setMouseX(int mouseX) {
		InputUtility.mouseX = mouseX;
	}

	public static int getMouseY() {
		return mouseY;
	}

	public static void setMouseY(int mouseY) {
		InputUtility.mouseY = mouseY;
	}

}
