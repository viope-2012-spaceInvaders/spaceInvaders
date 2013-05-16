/**
 * This class is an extending from Exception.
 * This class gives an notification letting the game know an illegal exception has been made.
 */
public class IllegalElementException extends Exception {
	public IllegalElementException(String msg) {
		System.out.println(msg);
	}
}
