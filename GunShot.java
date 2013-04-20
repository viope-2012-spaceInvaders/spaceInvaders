class GunShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=-1;	 //The aliens’ shots move from top to bottom (1 );  

	//CONSTRUCTORs
	public GunShot(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS

	
	//for collision with elements or borders remember to call the Empty class constructor"
	@Override
	public String toString() {
		return "s";
	}

	
	public int getXOffset() {
		return 0;
	}

	public int getYOffset() {
		if(this.x!=0)						//the number of cells it can be moved will always be the opposite of its row, except when it is in the row [0];
			return this.h*-1;
		else
			return 0;
	}	
	
	
}