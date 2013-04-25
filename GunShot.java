class GunShot extends BattleFieldElement  {

	//FIELD
	private static final int vDirection=-1;	 //The aliens’ shots move from top to bottom (1 );  

	//CONSTRUCTORs
	public GunShot(int h, int v){
		super(h,v);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS
	public int getXOffset() {
		return 0;
	}

	public int getYOffset() {
		return (this.y)*-1;
	}	
	
	//for collision with elements or borders remember to call the Empty class constructor"
	@Override
	public String toString() {
		return "s";
	}
	
}