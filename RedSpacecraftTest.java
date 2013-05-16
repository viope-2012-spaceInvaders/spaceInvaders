import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RedSpacecraftTest {
	
	RedSpacecraft red;
	BattleFieldElement element;
	@Before
	public void init(){
		red = new RedSpacecraft(1,2);
		element = new RedSpacecraft(1,2);
	}

	@Test
	public void testMove() {
		assertEquals("At the start the x: 2", 2, element.getX());
		assertEquals("At the start the y: 1", 1, element.getY());
		element.move(1, 4);
		assertEquals("After move method calling the x became: 4", 4, element.getX());
		assertEquals("After move method calling the y stay: 1", 1, element.getY());
	}

	@Test
	public void testGetXOffset() {
		BattleField bf = null;
		try {
			bf = new BattleField("es-in.txt");
		} catch (IllegalElementException e) {
			e.printStackTrace();
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		bf.setColumns(5);
		assertEquals("Entry in first if", 5-(2+1), red.getXOffset());
		red.setX(4);
		assertEquals("after this change, direction is", 4, red.getXOffset());
	}

	@Test
	public void testGetYOffset() {
		assertEquals("Y of RedSpacecraft must return 0", 0, red.getYOffset());
	}

	@Test
	public void testToString() {
		
		assertEquals("String returned must be: R", "R", red.toString());
	}

	@Test
	public void testRedSpacecraft() {
		assertEquals("The v must be: 1", 1, element.getY());
		assertEquals("The h must be: 2", 2, element.getX());
	}

}
