class AlienShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=1;	 //The aliens’ shots move from top to bottom (1 );  

	//CONSTRUCTORs
	public AlienShot(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS

	
	//for collision with elements or borders remember to call the Empty class constructor"
	public String toString(){
		String info=""
			+super.toString()
			+"Fired by: Alien";
		return info;							
	}


	public int getXOffset() {
		return 0;
	}


	public int getYOffset() {
		return -(this.x+1); //battlefieldHeight
	}	
	
}