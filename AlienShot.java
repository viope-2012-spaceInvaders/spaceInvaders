class AlienShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=1;	 //from top to bottom;  

	//CONSTRUCTORs
	public AlienShot(int h, int v){
		super(h,v);						
	}	
	
	//METHODS
	public int getXOffset() {
		return 0; 
	}

	public int getYOffset() {
		return (BattleField.rows - (this.y + 1));
	}	
	
	@Override
	public String toString() {
		return "S";
	}
	
}