/**
 * The Empty class extends BattleFieldElement and represents an empty cell; empty cells don't move.
 *
 */

	public class Empty extends BattleFieldElement{
	
	//CONSTRUCTOR
		/**
		 *  This constructor creates the Empty cells.
		 *  
		 * @param v - Is the vertical position of the Empty Cell
		 * @param h - Is the Horizontal position of the Empty Cell
		 */
		
		public Empty(int v, int h){
			super(v,h);
		}
	//METHODS
		/** 
		 * This method is abstract and must be implemented by all concrete classes.
		 *  
		 * @return - the horizontal offset of the empty cell
		 */
		
		public int getXOffset(){
		return 0;
		}
		/**
		 * This method is abstract and must be implemented by all concrete classes
		 * 
		 * @return - the vertical offset of the empty cell
		 */
	
		public int getYOffset(){
		return 0;
		}
		/**
		 * This method is abstract and must be implemented by all concrete classes
		 * 
		 * @param v - returns the vertical position of the empty cell
		 * @param h - returns the horizontal position of the empty cell
		 */
	
		public void move(int v, int h){
			
	}
	
	@Override
	public String toString() {
		return " ";
	}
	
	@Override
	public boolean equals(Object o){
		if (! ( o instanceof Empty) ) return false;
		Empty e = (Empty)o;
		return e.x == x && e.y == y; 
	}
	
	
	
	
	
}