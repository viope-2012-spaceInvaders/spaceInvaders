/*Alien is an abstract class extending BattleFieldElement, and representing all alien
elements at play in the game*/

public abstract class Alien extends BattleFieldElement{

	//FIELDs
	protected final int direction=-1;	
	
	//CONSTRUCTOR
	public Alien(int h, int v){
		super(h,v);						
	}
	
	//METHODs	
	abstract public int getXOffset();	
	abstract public int getYOffset();
	abstract public String toString();

}