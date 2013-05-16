/**
 * This casemate class extends the BattleFieldElement
 */

	public class Casemate extends BattleFieldElement {

	//FIELD
	
	//CONSTRUCTOR
	
	/**
	 * This creates the casemate class with the parameters (v)(h)
	 * @param v - vertical position of the casemate 
	 * @param h - horizontal position of the casemate
	 */
	public Casemate(int v,int h) {
			super(v,h);			
	}
	
	//METHODS
	
	/**
	 * Gets X-offset, returns the requested parameter
	 *  
	 * @return X - x-offset as an int
	 */
	public int getXOffset(){
		return 0;
	}
	
	/**
	 * Gets Y-offset, returns the requested parameter 
	 * 
	 * @return Y - y-offset as an int 
	 */
	
	public int getYOffset(){
		return 0;
	}
	
	/** 
	 * This moves the casemate with the specified numbers
	 * @param v - the vertical position of the Casemate
	 * @param h - the horizontal position of the Casemate
	 */
	
	public void move(int v, int h){
		System.out.println("S");
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Casemate) return false;
		Casemate as = (Casemate)o;
		return (as.x == x)&&(as.y == y);
	}
}