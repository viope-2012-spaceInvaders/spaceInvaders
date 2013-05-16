/*The Empty class extends BattleFieldElement and represents an empty cell; empty
cells of course don’t move*/

public class Empty extends BattleFieldElement{
	
	//CONSTRUCTOR
		public Empty(int v, int h){
			super(v,h);
		}
	//METHODS
	
	public int getXOffset(){
		return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public void move(int v, int h){
			
	}
	
	@Override
	public String toString() {
		return " ";
	}
	
	
	
}