/*package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SortToolsTest {
	
	@Test
	public void testFindFoundFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
	}
	
	@Test
	public void testInsertGeneralPartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 35));
	}
	
	@Test
	public void testInsertSort(){
		int[] x = new int[]{4, 9, 2, 1, 0, 78, -3};
		int[] expected = new int[]{-3, 0,1,2,4,9,78};
		SortTools.insertSort(x, 7);
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testFind(){
		int[] x = new int[]{4, 9, 2, 1, 0, 78, -3, 98};
		SortTools.insertSort(x, 7);
		int v = 1;
		assertEquals(2, SortTools.find(x, 8, v));
	}
	
	@Test
	public void testInsertInPlace() {
		int[] x = new int[]{-3, 0,1,2,4,9,78};
		int v = 3;
		assertEquals(8, SortTools.insertInPlace(x, 7, v));
	}
}
*/

package assignment1;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SortToolsTest {

////Tests for isSorted()///////////////////
	@Test(timeout = 2000)
	public void isSorted1(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(true, SortTools.isSorted(x, 6));
	}
	
	@Test(timeout = 2000)
	public void isSorted2(){
		int[] x = new int[]{-2, -1, 0, 4, 2, 3};
		assertEquals(false, SortTools.isSorted(x, 6));
	}
	
	@Test(timeout = 2000)
	public void isSorted3(){
		int[] x = new int[]{-2, -1, 0, 4, 2, 3};
		assertEquals(true, SortTools.isSorted(x, 3));
	}
	
	
////Tests for find()///////////////////	
	@Test(timeout = 2000)
	public void findTest1(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(2, SortTools.find(x, 6, 0));
	}
	
	@Test(timeout = 2000)
	public void findTest2(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 6, 4));
	}
	
	@Test(timeout = 2000)
	public void findTest3(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 3, 1));
	}
	
		
	@Test(timeout = 2000)
	public void testFindFound1(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
	}
	
	@Test(timeout = 2000)
	public void testFindFound2(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 3, 1));
	}
	
	@Test(timeout = 2000)
	public void testFindFound3(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 6, -3));
	}
	
	@Test
	public void testFindFound4(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 0, -3));
	}
	

	
	
////Tests for insertGeneral()///////////////////	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd1(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 35));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd2(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{5, 10, 20, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 5));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd3(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 15, 20, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 15));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd4(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[] {10, 20, 25, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 25));
	}
	
	@Test
	public void testInsertGeneralPartialEnd5(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{20};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 0, 20));
	}
	
	@Test
	public void testInsertGeneralPartialEnd6(){
		int[] x = new int[]{10, 20, 45, 40, 50};
		int[] expected = new int[]{10, 20, 27, 40, 45, 50};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 27));
	}
	
	
////Tests for insertPartial()///////////////////		
	@Test(timeout = 2000)
	public void testInsertInPlace1(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int expected = 4;
		assertEquals(expected, SortTools.insertInPlace(x, 4, 20));
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlace2(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		SortTools.insertInPlace(x, 3, 25);
		int[] expected = new int[]{10, 20, 25, 30, 50};
		assertArrayEquals(expected, x);
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlace3(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int expected = 4;
		assertEquals(expected, SortTools.insertInPlace(x, 3, 25));
	}
	
	@Test(timeout = 2000)
	public void testInsertInPlace4(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int expected = 1;
		assertEquals(expected, SortTools.insertInPlace(x, 0, 25));
	}
}
