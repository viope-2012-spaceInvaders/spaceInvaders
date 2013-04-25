/*Alien is an abstract class extending BattleFieldElement, and representing all alien
elements at play in the game*/

public abstract class Alien extends BattleFieldElement{

  //FIELDs
	protected final int direction=-1;	
	
	//CONSTRUCTORs
	public Alien(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}
	
	//METHODs	
	abstract public int getXOffset();	//this methods have to compare its x position with the battlefield's width
	abstract public int getYOffset();
	abstract public String toString();

}