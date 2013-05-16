
/** OneStepAlien is a concrete subclass of Alien representing aliens; all
aliens of this type move like a single entity from right to left or from
left to right (they never go up or down, and at the beginning they move
from left to right). When an alien of this type reaches the border, the
whole army changes its direction of movement. */

public class OneStepAlien extends Alien{ 

  //FIELD
	protected static int armyDirection = 1; 
	//CONSTRUCTOR
	/**
	 * OneStepAlien constructor.  Takes the values for vertical and horizontal positioning.
	 * 
	 * @param v - vertical positioning
	 * @param h - horizontal positioning
	 */
	public OneStepAlien(int v, int h){
		super(v,h);
	}

	//METHODS
	/**
	 * getArmyDirection method.
	 * 
	 * @return armydirection returns the army direction as either a positive or negative 1
	 */
	public int getArmyDirection(){
		return armyDirection;
	}
	/**
	 * getXofffset method.
	 * 
	 * @return X-offset
	 */
	public int getXOffset(){
		if (armyDirection == 1) {
			return (BattleField.columns - (this.x+1));
		}
		else {
			return -this.x;
		}
	}
	/**
	 * getYOffset method.  Returns Y-offset (0)
	 * 
	 * @return Y-offset
	 */
	public int getYOffset(){
		return 0;
	}
	
	/**
	 * changeDirection method.  Method that changes the direction at every call.
	 * -1= right to left; +1= left to right.
	 */
	public static void changeDirection(){
		armyDirection *= -1;			//every call of this method change the direction	
									// -1= right to left		1= left to right
	}

	/**
	 * toString method.  Returns the value "A".
	 * 
	 * @return "A"
	 */
	public String toString() {
		return "A";
	}
	

	/**
	 * move method.  takes parameters v and h.
	 */
	public void move(int v, int h){
		this.x=h;
		this.y=v;
		
	}
}