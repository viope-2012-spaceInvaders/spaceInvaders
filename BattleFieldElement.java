public abstract class BattleFieldElement{

	//FIELD
		private int x;										
		private int y;						//are fields storing the current position of the item on the battlefield.
	
	//CONSTRUCTOR
	public BattleFieldElement(int h, int v){
		x=h;	//horizontal pos
		y=v;	//vertical pos
	}
	
	//METHODS
	public void move(int x, int y){			//	moves the current position of the item
		this.x=x;							//	to the one passed as argument. No check is made to determine if the new position
		this.y=y;							//	is correct or outside of the battlefield margins.
	}

	
	
													
	abstract public int getXOffset();		//	are used to determine of how many
	abstract public int getYOffset();		//	cells this item can be moved horizontally and vertically (respectively) and in
											//	which direction. The direction is encoded in the signum of the returned value:
											//	+ means from left to right or from top to bottom (recall that the topmost
											//	leftmost cell of the battlefield has coordinates (0,0));
											//	- means from right to left or from bottom to top.
	
	public String toString(){				// the usual method inherited from Object; it
		String info= "Position"				// should be overridden in such a way that every single item is correctly repre-sented as
					+"\nx coord: "+this.x	// explained when describing the toString method in the BattleField class.
					+"\ny coord: "+this.y
					+"\n";
		return info;
	}
	
	
		
}