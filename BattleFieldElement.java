public abstract class BattleFieldElement{

	//FIELD
		protected int x;										
		protected int y;		//current position of the item on the battlefield.
	
	//CONSTRUCTOR
	public BattleFieldElement(int h, int v){
		x=h;	//horizontal 
		y=v;	//vertical
	}
	
	//METHODS
	public void move(int x, int y){			//moves the current position of the item
		this.x=x;							//to the one passed as argument. No check is made to determine if the new position
		this.y=y;							//is correct or outside of the battlefield margins.
	}

											
	abstract public int getXOffset();		
	abstract public int getYOffset();		
	abstract public String toString();

	
	
		
}