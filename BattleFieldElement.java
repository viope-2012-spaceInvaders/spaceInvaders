public abstract class BattleFieldElement{

	//FIELD
		protected int y;		//current position of the item on the battlefield.
		protected int x;										
	
	//CONSTRUCTOR
	public BattleFieldElement(int v,int h){
		y=v;	//vertical
		x=h;	//horizontal 
	}
	
	//METHODS
	public abstract void move(int v, int h);			//moves the current position of the item
									//to the one passed as argument. No check is made to determine if the new position
								//is correct or outside of the battlefield margins.
	

											
	 public abstract int getXOffset();		
	 public abstract int getYOffset();		
	 public abstract String toString();
	
	
	
	
	
		
}