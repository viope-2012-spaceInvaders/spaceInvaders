public class Casemate extends BattleFieldElement {

	//FIELD
	
	//CONSTRUCTOR
	  public Casemate(int h,int v) {
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
		return "C";
	}
}