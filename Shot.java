/**Shot is an abstract class derived from BattleFieldElement and representing every
possible shot, both coming from an alien (i.e., an instance of AlienShot) or from the
gun (i.e., an instance of GunShot). When two shots collide, they both get destroyed;
the same happens when a shot hits any other element (alien, casemate or gun). 
After reaching the border, a shot disappears from the battlefield.*/

abstract class Shot extends BattleFieldElement	{
	//FIELD
						//The aliens’ shots move from top to bottom (1 );  
						//Guns'shots move from bottom to top (-1)
	
	
	//CONSTRUCTORs
	/** Constructor will construct a new shot that call the BattleFieldElement giving h & v parameters
	 * 
	 * @param v is the vertical position of the new shot. 
	 * @param h is the horizontal position of the new shot.
	 */
	public Shot(int v, int h){
		super(v,h);						
	}	
	
	//METHODS
	
	/** This method is abstract: it must be implemented by all
	 * concrete subclasses. It returns the horizontal offset of the
	 * shot.
	 * 
	 * @return the horizontal offset of the shot. 
	 */
	abstract public int getXOffset();
	
	/** This method is abstract: it must be implemented by all
	 * concrete subclasses. It returns the vertical offset of the
	 * shot.
	 * 
	 * @return the vertical offset of the shot. 
	 */
	abstract public int getYOffset();
	
	/** This method is abstract: it must be implemented by all
	 * concrete subclasses. It returns the text representation of the shot.
	 * 
	 * @return the text representation of the shot. 
	 */
	abstract public String toString();
	
}