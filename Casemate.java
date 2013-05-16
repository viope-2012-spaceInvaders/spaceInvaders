public class Casemate extends BattleFieldElement {

	//FIELD
	
	//CONSTRUCTOR
	public Casemate(int v,int h) {
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