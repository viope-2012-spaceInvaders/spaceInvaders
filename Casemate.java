/*Instances of Casemate (a subclass of BattleFieldElement) represent casemates.
A casemate stays still in its position; casemates can be placed virtually everywhere,
except on the bottom line because that line is reserved to the gun (an attempt to place
a casemate on the bottom line should cause an IllegalPositionException to be
thrown).*/

public class Casemate extends BattleFieldElement {

	//FIELD
	
	//CONSTRUCTOR
	public Casemate(int h,int v) throws IllegalPositionException{
		if(v == 0) // battlefield's bottom line 
			throw new IllegalPositionException("The Casemate can be placed everywhere, except in the bottom line");
		else
			super(h,v);			
	}
	
	//METHODS
	public int getXOffset(){
		return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public String toString(){
		String info=""
					+super.toString()
					+"Type: Casemate\n";		
		return info;
	}
	
}