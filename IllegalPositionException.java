/**
 * IllegalPositionException extends from Exception.
 * Prints an message with the position that is illegal.
 */
public class IllegalPositionException extends Exception {
	public IllegalPositionException(String msg) {
		System.out.println(msg);
	}
	
	public IllegalPositionException(String msg, int i) {
		System.out.println(msg+" in position "+i);
	}
}
