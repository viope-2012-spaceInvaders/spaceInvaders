/* RedSpacecraft a concrete subclass of Alien, representing the bonus
spacecraft: it always moves from left to right, one cell at a time, on
the top line of the screen; a IllegalPositionException should be
thrown if the spacecraft is positioned on a different line. When the spacecraft reaches
the left edge, it disappears from the battlefield. */

public class RedSpacecraft extends Alien{ 

	//FIELD
	final int rDirection = -1;
	
	//CONSTRUCTOR
	public RedSpacecraft(int h, int v) throws IllegalPositionException {
		//super(hDirection=1);
		super(h,v);	
	}

	//METHODS
	
	public int getXOffset(){
		if(this.y!=0)						//the number of cells it can be moved will always be the opposite of its column, except when it is in the column[0];
			return this.y*-1;
		else
			return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}