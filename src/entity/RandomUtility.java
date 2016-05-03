package entity;

public class RandomUtility {

	public RandomUtility() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static int random(int m,int n) {
		return (int)((n-m)*Math.random())+m;	
	}

}
