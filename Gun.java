/**
 * Instances of the Gun class (extending BattleFieldElement) represent a gun. 
 * There cannot be more than one gun at a time in the configuration
 * (an IllegalElementEx-ception should be raised upon attempting to create more than one gun). 
 * When a gun gets destroyed (either because it is hit by a shot or because it has 
 * collided with an alien), it gets replaced by another gun, whose initial position is the 
 * first entry on the left on the bottom line of the battlefield. At every step, the gun
 * moves, one cell at a time, in some direction (at the beginning, from the left to right) 
 * until reaching the border of the battlefield, and then it inverts its direction. A gun can 
 * only exist on the bottom line, otherwise an IllegalPositionException should be thrown.
 * */


public class Gun extends BattleFieldElement{

	//FIELD
	 /**
	  * Gun is derived from the BattleFieldElement and represents the gun
	  */
	protected static int direction=1;//from left to right
	
	//CONSTRUCTOR
	/**
	  * This constructor creates the gun. 
	  * 
	  * @param v - Is the vertical parameter of the gun
	  * @param h - Is the horizontal paramter of the gun
	  * @throws IllegalElementException
	  */
	public Gun(int v,int h) throws IllegalElementException{
		super( v,h ); 			
	}
	
	//METHODS
	 /**
	 *  This method is abstract and must be implemented by all concrete subclasses
	 * 
	 * @return if the horizontal parameter =1 then it = this.x+1
	 *        if not then it = -this. x
	 */
	public int getXOffset(){
		if (direction == 1) {
			return (BattleField.getColumns() - (this.x + 1));
		}
		else {
			return -this.x;
		}
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public static void changeDirection(){
		direction *= -1;			
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int x) {
		this.direction = x;
	}
	
	@Override
	public String toString() {
		return "G";
	}
	
	
	public void move(int v, int h){
		this.x = h;
		
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Gun)) return false;
		Gun g = (Gun)o;
		return (g.x == x)&&(g.y == y)&&(g.direction == direction);
	}
	
	
}