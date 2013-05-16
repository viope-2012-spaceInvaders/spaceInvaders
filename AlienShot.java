/**
 * AlienShot class extends the BattleFieldElement.  
 * It represents all alienShot elements during the game.
 */
class AlienShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=1;	 //from top to bottom;  
	private int moved;

	//CONSTRUCTORS
	/**
	 * AlienShot constructor.  Specifies the position of the alien shot.
	 * 
	 * @param v - vertical position of the alien shot
	 * @param h - horizontal position of the alien shot
	 */
	public AlienShot(int v, int h){
		super(v,h);	
		this.moved=0;
	}	
	
	//METHODS
	/**
	 * getXOffset method.  Returns the X-offset
	 * 
	 * @return 0 - returns the X-offset (0)
	 */
	public int getXOffset() {
		return 0; 
	}

	/**
	 * getYOffset method.  Returns the Y-offset.
	 * 
	 * @return Y-offset
	 */
	public int getYOffset() {
		return (BattleField.getRows() - (this.y + 1));
	}	
	
	/**
	 * getMoved method.  Returns the int moved.
	 * 
	 * @return moved - the int for the amount moved
	 */
	public int getMoved() {
		return this.moved;
	}
	
	/**
	 * setMoved method.  Sets the moved amount of the AlienShot.
	 * 
	 * @param x - int for amount moved
	 */
	public void setMoved(int x) {
		this.moved = x;
	}
	
	/**
	 * move method.  specifies the values of the new position of the AlienShot.
	 * 
	 * @param v - int vertical position
	 * @param h - int horizontal position
	 */
	public void move(int v, int h){
		this.y = v;
		
	}
	
	
	/**
	 * toString method.  overrides the toString method in BattleFieldElement.
	 * 
	 * @return "S" - string.
	 */
	@Override
	public String toString() {
		return "S";
	}
	
}