import static org.junit.Assert.*;

import org.junit.Test;


public class CasemateTest {

	@Test
	public void testCasemate() {
		BattleFieldElement element = new Casemate(5,6);
		assertEquals("The v must be: 5", 5, element.getY());
		assertEquals("The h must be: 6", 6, element.getX());		
	}
	
	@Test
	public void testGetXOffset(){
		Casemate cm = new Casemate(5,6);
		assertEquals("X offset can be 0 in Casemate", 0, cm.getXOffset());
	}
	
	@Test
	public void testGetYOffset(){
		Casemate cm = new Casemate(5,6);
		assertEquals("Y offset can be 0 in Casemate", 0, cm.getYOffset());
	}
	
	@Test
	public void testMove(){
		Casemate cm = new Casemate(2,1);
		cm.move(3, 7);
	}

	@Test
	public void testToString() {
		Casemate cm = new Casemate(5,6);
		assertEquals("String returned must be: C", "C", cm.toString());
	}
}
