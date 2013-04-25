
/* OneStepAlien a concrete subclass of Alien representing aliens; all
aliens of this type move like a single entity from right to left or from
left to right (they never go up or down, and at the beginning they move
from right to left). When an alien of this type reaches the border, the
whole army changes its direction of movement. */

public class OneStepAlien extends Alien{ 

  //FIELD
	public static int armyDirection = 1; 
	//CONSTRUCTOR
	public OneStepAlien(int h, int v){
		super(h,v);
	}

	//METHODS
	
	public int getXOffset(){
		if (armyDirection == 1) {
			return (BattleField.columns - this.x);
		}
		else {
			return -this.x;
		}
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public static void changeDirection(){
		armyDirection *= -1;			//every call of this method change the direction	
									// -1= right to left		1= left to right
	}

	public String toString() {
		return "A";
	}

}