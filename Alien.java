/*Alien is an abstract class extending BattleFieldElement, and representing all alien
elements at play in the game. Paolo was here! Paolo was here again! */

public abstract class Alien extends BattleFieldElement{

	//FIELDs
	protected final int direction=-1;	
	
	//CONSTRUCTOR
	public Alien(int v, int h){
		super(v,h);						
	}
	
	//METHODs	
	abstract public int getXOffset();	
	abstract public int getYOffset();
	abstract public String toString();

}