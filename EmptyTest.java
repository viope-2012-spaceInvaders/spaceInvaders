import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EmptyTest {

	
	Empty e;
	
	@Before
	public void init(){
		e = new Empty(2,1);
	}
	
	@Test
	public void testMove() {
		 e.move(3, 7);
	}

	@Test
	public void testGetXOffset() {
		assertEquals("X offset can be 0 in Empty", 0, e.getXOffset());
	}

	@Test
	public void testGetYOffset() {
		assertEquals("Y offset can be 0 in Empty", 0, e.getYOffset());
	}

	@Test
	public void testToString() {
		assertEquals("String returned must be a space", " ", e.toString());
	}

	@Test
	public void testEmpty() {
		BattleFieldElement element = new Empty(5,4);
		assertEquals("The v must be: 5", 5, element.getY());
		assertEquals("The h must be: ", 4, element.getX());
	}

}
