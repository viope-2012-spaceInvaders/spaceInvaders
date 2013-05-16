import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GunTest {

	Gun G = null;
	
	@Before
	public void init(){ 
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMove() {
		assertEquals("Battlefieldelement must have x set to: 6", 6, G.getX());
		assertEquals("Battlefieldelement must have y set to: 3", 3, G.getY());
	}

	@Test
	public void testGetXOffset() {
		/*Gun G = null; 
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		BattleField bf = new BattleField("es-in.txt");
		bf.setColumns(5);
		assertEquals("At start direction must be 1, so enter in first if",bf.getColumns()-,));*/
		Gun G = null; 
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		G.move(3, 7);
		assertEquals("Battlefieldelement must have x set to: 7", 7, G.getX());
		G.move(3, 6); //back to 6
	}

	@Test
	public void testGetYOffset() {
		assertEquals("Y offset return always 0", 0,G.getYOffset());
	}

	@Test
	public void testToString() {
		assertEquals("toString must return G", "G", G.toString());
	}

	@Test
	public void testGun() {
		BattleFieldElement element = null;
		try {
			element = new Gun(5,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		assertEquals("The v must be: 5", 5, element.getY());
		assertEquals("The h must be: 6", 6, element.getX());
	}

	@Test
	public void testChangeDirection() {
		assertEquals("at start must have direction = 1", 1, G.getDirection());
		G.changeDirection();
		assertEquals("after call method direction become -1", -1, G.getDirection());
		G.changeDirection(); //back to 1
		
		
	}

	@Test
	public void testGetSetDirection() {
		assertEquals("at start must have direction = 1", 1, G.getDirection());
		G.changeDirection();
		assertEquals("at start must have direction = -1", -1, G.getDirection());
	}
	

}
