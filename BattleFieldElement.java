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
	public void move(int h, int v){			//moves the current position of the item
		this.x=h;							//to the one passed as argument. No check is made to determine if the new position
		this.y=v;							//is correct or outside of the battlefield margins.
	}

											
	abstract public int getXOffset();		
	abstract public int getYOffset();		
	abstract public String toString();

	
	
		
}