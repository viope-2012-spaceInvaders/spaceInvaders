/*Alien is an abstract class extending BattleFieldElement, and representing all alien
elements at play in the game*/

public abstract class Alien extends BattleFieldElement{

	//FIELDs
	protected int hDirection;	
	
	//CONSTRUCTORs
	public Alien(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
		hDirection=-1;					//Direction should start from right to left (-1)
	}
	
	//METHODs	
	
	abstract public int getXOffset();
										//this methods have to compare its x position with
										//the battlefield's width
	
	
	abstract public int getYOffset();
	
	public String toString(){
		String info=""
					+super.toString()
					+"Type: Alien\n";		
		return info;
	}
	
}