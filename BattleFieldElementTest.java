import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BattleFieldElementTest {

	BattleFieldElement element;
	@Before
	public void init(){
		element = new OneStepAlien(6,7);
	}

	@Test
	public void testGetY() {
		assertEquals("Y coords must be 6", 6, element.getY());
	}

	@Test
	public void testSetY() {
		element.setY(8);
		assertEquals("Y coords now must be 8", 8, element.getY());
	}

	@Test
	public void testGetX() {
		assertEquals("X coords must be 7", 7, element.getX());
	}

	@Test
	public void testSetX() {
		element.setX(2);
		assertEquals("X coords now must be 2", 2, element.getX());
	}

}
