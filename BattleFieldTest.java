import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class BattleFieldTest {
	
	BattleField BF;
	File tmp;
	private BufferedWriter bw = null;
	@Before
	public void init() throws IOException{
			tmp = File.createTempFile("testfile", ".txt");		
			try {
				bw = new BufferedWriter(new FileWriter(tmp.getName(), true));
				bw.newLine();
				bw.write("3|3|3 $2A1 $3 $"+"\n");
				bw.close();
			} catch (IOException e) {
				System.out.println("IOException in the write method !");
			} 
		try {
			BF = new BattleField(tmp.getName());
		} catch (IllegalElementException e){ 
			e.printStackTrace();
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBattleField() {
		assertEquals(0, BF.getScore());
		assertEquals(3, BF.getLife());
	}
	
	@Test
	public void testSetGetFilename() {
		assertEquals(tmp.getName(), BF.getFilename());
		BF.setFilename("filenametest.txt");
		assertEquals("filenametest.txt", BF.getFilename());
	}

	@Test
	public void testGetRows() {
		assertEquals(3, BF.getRows());
	}

	@Test
	public void testSetRows() {
		assertEquals(3, BF.getRows());
		BF.setRows(4);
		assertEquals(4, BF.getRows());
	}

	@Test
	public void testGetColumns() {
		assertEquals(3, BF.getColumns());
	}

	@Test
	public void testSetColumns() {
		assertEquals(3, BF.getColumns());
		BF.setColumns(4);
		assertEquals(4, BF.getColumns());
		
	}

	@Test
	public void testGetBattleFieldElement() {
		BattleFieldElement BFTest[][] = new BattleFieldElement[BF.getRows()][BF.getColumns()];
		BFTest[0][0] = new Empty(0,0);
		BFTest[0][1] = new Empty(0,1);
		BFTest[0][2] = new Empty(0,2);
		BFTest[1][0] = new OneStepAlien(1,0);
		BFTest[1][1] = new OneStepAlien(1,1);
		BFTest[1][2] = new Empty(1,2);
		BFTest[2][0] = new Empty(2,0);
		BFTest[2][1] = new Empty(2,1);
		BFTest[2][2] = new Empty(2,2);
		
		boolean equals = true;
		for(int r=0; r<BF.getRows(); r++){
			for(int c=0; c<BF.getRows(); c++){
				assertEquals(BFTest[r][c], BF.getBattleFieldElement(r,c));
			}
		}
	}

	@Test
	public void testToString() {
		assertEquals("3|3|3 $2A1 $3 $", BF.toString());
	}

	@Test
	public void testBackup() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBattleField() throws IllegalElementException, IllegalPositionException {
		assertEquals("3|3|3 $2A1 $3 $", BF.toString());
		BF.move();
		assertEquals("3|3|3 $1 2A$3 $",BF.toString());
		
	}

	@Test
	public void testWrite() {
		fail("Not yet implemented");
	}

	@Test
	public void testReload() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		/*BattleFieldElement 
		boolean equals = false;
		if(BFTest.equals(BF))
				equals = true;
		assertTrue(equals);
		*/
	}

	@Test
	public void testSetBattleFieldElement() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBattleField() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoTheyMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoTheyShot() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlienCollide() {
		fail("Not yet implemented");
	}

}
