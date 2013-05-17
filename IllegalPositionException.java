
/**
 * is an extension from Exception.
 * This class gives an notification letting the game know an illegal position exception has occurred.
 */
public class IllegalPositionException extends Exception {
	public IllegalPositionException(String msg) {
		System.out.println(msg);
	}
	
	public IllegalPositionException(String msg, int i) {
		System.out.println(msg+" in position "+i);
	}
}
