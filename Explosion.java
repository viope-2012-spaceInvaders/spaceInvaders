/**
 * This class generates the shot explosion.  It extends the BattleFieldElement class.
 */
public class Explosion extends BattleFieldElement {

	/**
	 * Explosion method.  Takes parameters v and h from the BattleFieldElement superclass
	 * 
	 * @param v
	 * @param h
	 */
	public Explosion(int v, int h) {
		super(v, h);

	}

    /*
     *The move method take parameters from the BattleFieldElement move method.
     * 
     * (non-Javadoc)
     * @see BattleFieldElement#move(int, int)
     */
	public void move(int v, int h) {
		

	}

	/*
	 * The getXOffset method takes and returns parameters from the BattleFieldElement getXOffset method.
	 * 
	 * (non-Javadoc)
	 * @see BattleFieldElement#getXOffset()
	 */
	public int getXOffset() {
	
		return (BattleField.getColumns() - (this.x - 1));
	}

	/*
	 * The getYOffset method takes and returns parameters from the BattleFieldElement getYOffset method.
	 * (non-Javadoc)
	 * @see BattleFieldElement#getYOffset()
	 */
	public int getYOffset() {
		return (BattleField.getRows() - (this.y - 1));
	}

	/**
	 * The toString method returns "E".
	 * 
	 * @return "E"
	 */
	public String toString() {
		return "E";
	}

}
