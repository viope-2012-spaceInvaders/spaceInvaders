/*The Empty class extends BattleFieldElement and represents an empty cell; empty
cells of course don’t move*/

public class Empty extends BattleFieldElement{
	
	//FIELD
	//CONSTRUCTOR
		public Empty(int h, int v){
			super(h,v);
		}
	//METHODS
	
	public int getXOffset(){
		return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	
	@Override
	public String toString() {
		return "-";
	}
	
	
	
}