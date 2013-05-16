class AlienShot extends BattleFieldElement	{

	//FIELD
	private static final int vDirection=1;	 //from top to bottom;  
	private int moved;

	//CONSTRUCTORs
	public AlienShot(int v, int h){
		super(v,h);	
		this.moved=0;
	}	
	
	//METHODS
	public int getXOffset() {
		return 0; 
	}

	public int getYOffset() {
		return (BattleField.getRows() - (this.y + 1));
	}	
	
	public int getMoved() {
		return this.moved;
	}
	
	public void setMoved(int x) {
		this.moved = x;
	}
	
	
	public void move(int v, int h){
		this.y = v;
		
	}
	
	
	
	@Override
	public String toString() {
		return "S";
	}
	
}