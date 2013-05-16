import static org.junit.Assert.*;

import org.junit.Test;


public class GunTest {

	@Test
	public void testMove() {
		Gun G = null; 
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		assertEquals("Battlefieldelement must have x set to: 6", 6, G.getX());
		assertEquals("Battlefieldelement must have y set to: 3", 3, G.getY());
	}

	@Test
	public void testGetXOffset() {
		fail("Not yet implemented");
	}
  
	@Test
	public void testGetYOffset() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		Gun G = null;
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		assertEquals("toString must return G", "G", G.toString());
	}

	@Test
	public void testGun() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeDirection() {
		Gun G = null;
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		assertEquals("at start must have direction = 1", 1, G.getDirection());
		G.changeDirection();
		assertEquals("after call method direction become -1", -1, G.getDirection());
		G.changeDirection(); //back to 1
		
		
	}

	@Test
	public void testGetDirection() {
		Gun G = null;
		try {
			G = new Gun(3,6);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
		assertEquals("at start must have direction = 1", 1, G.getDirection());
		G.changeDirection();
		assertEquals("at start must have direction = -1", -1, G.getDirection());
	}

	@Test
	public void testSetDirection() {
		fail("Not yet implemented");
	}

}
