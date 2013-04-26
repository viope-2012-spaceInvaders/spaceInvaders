class AlienShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=1;	 //The aliens’ shots move from top to bottom (1 );  

	//CONSTRUCTORs
	public AlienShot(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS

	
	//for collision with elements or borders remember to call the Empty class constructor"
	@Override
	public String toString() {
		return "S";
	}


	public int getXOffset() {
		return 0; //
	}


	public int getYOffset() {
		return (BattleField.rows - (this.y + 1));
	}	
	
}