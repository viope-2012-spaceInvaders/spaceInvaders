import static org.junit.Assert.*;

import org.junit.Test;


public class OneStepAlienTest {

	
	@Test
	public void testMove() {
		BattleFieldElement element = new OneStepAlien(3,2);
		assertEquals("At the start the x: 2", 2, element.getX());
		assertEquals("At the start the y: 3", 3, element.getY());
		element.move(4, 5);
		assertEquals("After move method calling the x became: 5", 5, element.getX());
		assertEquals("After move method calling the y became: 4", 4, element.getY());
	}

	@Test 
	public void testGetXOffset() {
		OneStepAlien osa = new OneStepAlien(3,2);
		BattleField bf = null;
		try {
			bf = new BattleField("es-in.txt");
		} catch (IllegalElementException e) {
			e.printStackTrace();
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		bf.setColumns(5);
		assertEquals("Entry in first if", 5-(2+1), osa.getXOffset());
		osa.changeDirection();
		assertEquals("after changed direction", -2, osa.getXOffset());
		osa.changeDirection(); //reset back because is static
		
	}

	@Test
	public void testGetYOffset() {
		OneStepAlien osa = new OneStepAlien(3,2);
		assertEquals("Y of one step alien must return 0", 0, osa.getYOffset());
	}

	@Test
	public void testToString() {
		OneStepAlien osa = new OneStepAlien(3,2);
		assertEquals("String returned must be: A", "A", osa.toString());
	}

	@Test
	public void testOneStepAlien() {
		BattleFieldElement element = new OneStepAlien(3,2);
		assertEquals("The v must be: 3", 3, element.getY());
		assertEquals("The h must be: 2", 2, element.getX());
	}

	@Test
	public void testChangeDirection() {
		OneStepAlien osa = new OneStepAlien(3,2);
		assertEquals("armyDirection must be 1", 1, osa.getArmyDirection());
		osa.changeDirection();
		assertEquals("armyDirection (after call of change direction method) must be -1", -1, osa.getArmyDirection());
		osa.changeDirection();
		assertEquals("armyDirection return to 1", 1, osa.getArmyDirection());
	}

}
