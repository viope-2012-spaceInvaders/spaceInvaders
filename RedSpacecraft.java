public class RedSpacecraft extends Alien{ 

  //FIELD
	
	//CONSTRUCTOR
	public RedSpacecraft(int h, int v){ 
		super(h,v);	
	}

	//METHODS
	
	public int getXOffset(){
		if(this.y!=0)						//the number of cells it can be moved will always be the opposite of its column, except when it is in the column[0];
			return this.y*-1;
		else
			return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}