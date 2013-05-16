/**
 * BattleFieldElement class
 */
public abstract class BattleFieldElement{

	//FIELD
		protected int y;		//current position of the item on the battlefield.
		protected int x;										
	
	//CONSTRUCTOR
	/**
	 * BattleFieldElement constructor.  Contains parameters for the vertical and horizontal positions.
	 * 
	 * @param v - vertical position of the BattleFieldElement
	 * @param h - horizontal position of the BattleFieldElement
	 */
	public BattleFieldElement(int v,int h){
		y=v;	//vertical
		x=h;	//horizontal 
	}
	
	//METHODS
	/**
	 * move method. moves the current position of the item to the one passed as argument. 
	 * 
	 * @param v - new vertical position
	 * @param h - new horizontal position
	 */
	public abstract void move(int v, int h);			//moves the current position of the item
									//to the one passed as argument. No check is made to determine if the new position
								//is correct or outside of the battlefield margins.

	/**
	 * GetY method returns the Y value
	 * 
	 * @return y - Returns the value instantiated
	 */
	 public int getY() {
		return y;
	}

	 /**
	  * SetY Method - Sets the selected parameter
	  * 
	  * @param y - This is the parameter being altered.
	  */
	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * GetX method returns the X value
	 * 
	 * @return X - Retrieves the inputted value of X 
	 */
	public int getX() {
		return x;
	}

	/**
	 * SetX Method - Sets the selected parameter
	 * 
	 * @param X - This is the parameter being altered. 
	 */
	public void setX(int x) {
		this.x = x;
	}

	 public abstract int getXOffset();		
	 public abstract int getYOffset();		
	 public abstract String toString();
	
}