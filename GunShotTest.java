import static org.junit.Assert.*;

import org.junit.Test;


public class GunShotTest {

	@Test
	public void testMove() {
		BattleFieldElement element = new GunShot(3,1);
		assertEquals("at the start x must be: 1", 1, element.getX());
		assertEquals("at the start x must be: 3", 3, element.getY());
		element.move(4,5);
		assertEquals("After move x must be: 1", 1, element.getX());
		assertEquals("After move x must be: 4", 4, element.getY());
	}

	@Test
	public void testGetXOffset(){
		GunShot gs = new GunShot(2,1);
		assertEquals("X offset can be 0 in Empty", 0, gs.getXOffset());
	}

	@Test
	public void testGetYOffset() {
		GunShot gs = new GunShot(2,1);
		assertEquals("I have to return y*-1", gs.getY()*-1, gs.getYOffset());
	}

	@Test
	public void testToString() {
		GunShot gs = new GunShot(2,1);
		assertEquals("String returned must be: s", "s", gs.toString());
	}

	@Test
	public void testGunShot() {
		BattleFieldElement element = new GunShot(4,1);
		assertEquals("The v must be: 4", 4, element.getY());
		assertEquals("The h must be: 1", 1, element.getX());
	}

}
