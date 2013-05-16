/**RedSpacecraft extends Alien and represents a red space craft.
 *
 */

public class RedSpacecraft extends Alien {

	// FIELD

	// CONSTRUCTOR
	/**
	 * Constructor will construct a new red space craft
	 * 
	 * @param v is the vertical position of the new red space craft.
	 * @param h is the horizontal position of the new red space craft.
	 */
	public RedSpacecraft(int v, int h) {
		super(v, h);
	}

	// METHODS
	/**
	 * This method is abstract: it must be implemented by all concrete
	 * subclasses. It returns the horizontal offset of the red space craft.
	 * 
	 * @return the horizontal offset of the red space craft.
	 */
	public int getXOffset() {
		return this.x;
	}

	/**
	 * This method is abstract: it must be implemented by all concrete
	 * subclasses. It returns the vertical offset of the red space craft.
	 * 
	 * @return the vertical offset of the red space craft.
	 */
	public int getYOffset() {
		return 0;
	}

	/**
	 * This method returns the text representation of the red space craft.
	 * 
	 * @return the text representation of the red space craft.
	 */
	@Override
	public String toString() {
		return "R";
	}

	/**This method move the red space craft to the position x (vertical position)
	 * @param x is the vertical position
	 */
	public void move(int v, int h) {
		// System.out.println("R");
		this.x = h;
	}

}