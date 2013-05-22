class GunShot extends BattleFieldElement  {

	//FIELD
	private static final int vDirection=-1;	 //The aliens' shots move from top to bottom (1 );  

	
	//CONSTRUCTORs
	public GunShot(int v, int h){
		super(v,h);						//call the BattleFieldElemeng giving h & v parameters
	}	
	
	//METHODS
	public int getXOffset() {
		return 0;
	}

	public int getYOffset() {
		return (this.y)*-1;
	}	
	
	public static int getVdirection() {
		return vDirection;
	}

	@Override
	public String toString() {
		return "s";
	}
	
	public void move(int v, int h){
		this.y = v;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof GunShot) return false;
		GunShot as = (GunShot)o;
		return (as.x == x)&&(as.y == y);
	}

}