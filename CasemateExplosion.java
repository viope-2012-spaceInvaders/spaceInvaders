
public class CasemateExplosion extends BattleFieldElement {

	public CasemateExplosion(int v, int h) {
		super(v, h);

	}


	public void move(int v, int h) {
		

	}

	public int getXOffset() {
	
		return (BattleField.getColumns() - (this.x - 1));
	}

	public int getYOffset() {
		return (BattleField.getRows() - (this.y - 1));
	}


	public String toString() {
		return "c";
	}

}
