
public class HiderExplosion extends Explosion {

	private BattleFieldElement hidden;
	private int vDirection;
	
	
	public HiderExplosion(int v, int h,BattleFieldElement b,int dir) {
		super(v, h);
		hidden=b;
		vDirection=dir;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int v, int h) {

	}

	@Override
	public int getXOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYOffset() {
		if(vDirection==1)
			return (BattleField.getRows() - (this.y + 1));
		 else
			 return (this.y)*-1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "I";
	}

	public BattleFieldElement getHidden() {
		// TODO Auto-generated method stub
		return hidden;
	}

}
