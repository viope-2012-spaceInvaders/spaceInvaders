public class RedSpacecraft extends Alien{ 

  //FIELD
	
	//CONSTRUCTOR
	public RedSpacecraft(int v, int h){ 
		super(v,h);	
	}

	//METHODS
	
	public int getXOffset(){
		return this.x;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	public void move(int v, int h){
		//System.out.println("R");
		this.x = h;
	}

}