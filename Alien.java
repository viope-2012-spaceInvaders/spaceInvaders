/**Alien is an abstract class extending BattleFieldElement, and representing all alien
elements at play in the game. */
public abstract class Alien extends BattleFieldElement{

	/** This field blablablabla and its values mean bla
	 *  blablabla bar babr bar */
	protected final int direction=-1;	
	
	/** This constructor will construct a new alien that blablabla
	 * 
	 * @param v is the vertical position of the new alien. 
	 * @param h is the horizontal position of the new alien.
	 */
	public Alien(int v, int h){
		super(v,h);						
	}
	
	//METHODs	
	
	/** This method is abstract: it must be implemented by all
	 * concrete subclasses. It returns the horizontal offset of the
	 * alien.
	 * 
	 * @return the horizontal offset of the alien. 
	 */
	abstract public int getXOffset();	
	abstract public int getYOffset();
	abstract public String toString();

}