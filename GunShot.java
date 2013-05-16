/**
 * The GunShot class is an extending of the BattleFieldElement Class.
 */
class GunShot extends BattleFieldElement  {
		
	/**
	 * This class includes constructors and methods for the gunshot.
	 * @param v is the vertical integer for the gun.
	 * @param h is the horizontal integer for the gun.
	 * The alien's shout moves from top of the game area to the bottom(1)
	 * private static final int vDirection=-1;	  
	 */
	
	public GunShot(int v, int h){
		super(v,h);						
	}	
	
	public int getXOffset() {
		return 0;
	}

	public int getYOffset() {
		return (this.y)*-1;
	}	
	
	@Override
	public String toString() {
		return "s";
	}
	
	public void move(int v, int h){
		this.y = v;
	}
}