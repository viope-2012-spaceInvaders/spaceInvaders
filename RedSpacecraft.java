public class RedSpacecraft extends Alien{ 

  //FIELD
	
	//CONSTRUCTOR
	public RedSpacecraft(int v, int h){ 
		super(v,h);	
	}

	//METHODS
	
	public int getXOffset(){
		return (BattleField.columns - (this.x + 1));
	}
	
	public int getYOffset(){
		return 0;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}