/*Instances of the Gun class (extending BattleFieldElement) represent a gun. There
cannot be more than one gun at a time in the configuration (an IllegalElementEx-ception should be raised upon attempting to create more than one gun). 
When a gun gets destroyed (either because it is hit by a shot or because it has collided with an alien), 
it gets replaced by another gun, whose initial position is the first entry on the left on the bottom line of the battlefield. At every step, the gun
moves, one cell at a time, in some direction (at the beginning, from the left to right) until reaching the border of the battlefield,
and then it inverts its direction. A gun can only exist on the bottom line, otherwise an IllegalPositionException should be thrown.*/


public class Gun extends BattleFieldElement{

	//FIELD
	
	protected static int direction;
	
	//CONSTRUCTOR
	public Gun(int h,int v) throws IllegalElementException{
		super( h,v );		
	    direction=1;  			//from left to right
	}
	
	//METHODS

	public int getXOffset(){
		if (direction == 1) {
			return (BattleField.columns - (this.x + 1));
		}
		else {
			return -x;
		}
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public static void changeDirection(){
		direction *= -1;			
	}
	
	@Override
	public String toString() {
		return "G";
	}
	
	
}