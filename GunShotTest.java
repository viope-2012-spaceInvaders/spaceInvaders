import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GunShotTest {
	GunShot gs;
	BattleFieldElement element;
	@Before
	public void init(){
		element = new GunShot(3,1);
		gs= new GunShot(2,1);
	}
	@Test
	public void testMove() {
		assertEquals("at the start x must be: 1", 1, element.getX());
		assertEquals("at the start x must be: 3", 3, element.getY());
		element.move(4,5);
		assertEquals("After move x must be: 1", 1, element.getX());
		assertEquals("After move x must be: 4", 4, element.getY());
	}

	@Test
	public void testGetXOffset(){
		assertEquals("X offset can be 0 in Empty", 0, gs.getXOffset());
	}

	@Test
	public void testGetYOffset() {
		assertEquals("I have to return y*-1", gs.getY()*-1, gs.getYOffset());
	}

	@Test
	public void testToString() {
		assertEquals("String returned must be: s", "s", gs.toString());
	}

	@Test
	public void testGunShot() {
		assertEquals("The v must be: 3", 3, element.getY());
		assertEquals("The h must be: 1", 1, element.getX());
	}

}
