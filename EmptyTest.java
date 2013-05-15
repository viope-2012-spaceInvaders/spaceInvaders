import static org.junit.Assert.*;

import org.junit.Test;


public class EmptyTest {

	@Test
	public void testMove() {
		Empty e = new Empty(2,1);
		e.move(3, 7);
	}

	@Test
	public void testGetXOffset() {
		Empty e = new Empty(2,1);
		assertEquals("X offset can be 0 in Empty", 0, e.getXOffset());
	}

	@Test
	public void testGetYOffset() {
		Empty e = new Empty(2,1);
		assertEquals("Y offset can be 0 in Empty", 0, e.getYOffset());
	}

	@Test
	public void testToString() {
		Empty e = new Empty(2,1);
		assertEquals("String returned must be a space", " ", e.toString());
	}

	@Test
	public void testEmpty() {
		BattleFieldElement element = new Empty(5,4);
		assertEquals("The v must be: 5", 5, element.getY());
		assertEquals("The h must be: ", 4, element.getX());
	}

}
