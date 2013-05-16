import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CasemateTest {
	
	Casemate cm;
	@Before
	public void init(){
		cm = new Casemate(5,6);
	}
	
	@Test
	public void testCasemate() {
		BattleFieldElement element = new Casemate(5,6);
		assertEquals("The v must be: 5", 5, element.getY());
		assertEquals("The h must be: 6", 6, element.getX());		
	}
	
	@Test
	public void testGetXOffset(){
		assertEquals("X offset can be 0 in Casemate", 0, cm.getXOffset());
	}
	
	@Test
	public void testGetYOffset(){
		assertEquals("Y offset can be 0 in Casemate", 0, cm.getYOffset());
	}
	
	@Test
	public void testMove(){
		cm.move(3, 7);
	}

	@Test
	public void testToString() {
		assertEquals("String returned must be: C", "C", cm.toString());
	}
}
