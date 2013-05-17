/**
 * This class is an extension from Exception.
 * This class gives an notification letting the game know an illegal element exception has occurred.
 */
public class IllegalElementException extends Exception {
	public IllegalElementException(String msg) {
		System.out.println(msg);
	}
}
