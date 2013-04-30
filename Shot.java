/*Shot is an abstract class derived from BattleFieldElement and representing every
possible shot, both coming from an alien (i.e., an instance of AlienShot) or from the
gun (i.e., an instance of GunShot). When two shots collide, they both get destroyed;
the same happens when a shot hits any other element (alien, casemate or gun). 
After reaching the border, a shot disappears from the battlefield.*/

abstract class Shot extends BattleFieldElement	{
	//FIELD
						//The aliens’ shots move from top to bottom (1 );  
						//Guns'shots move from bottom to top (-1)
	
	
	//CONSTRUCTORs
	public Shot(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS
	abstract public int getXOffset();
	abstract public int getYOffset();
	abstract public String toString();
}