package util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemoveObject() {
		MyArrayList al = new MyArrayList();
		Integer a1 = new Integer(1);
		Integer a2 = new Integer(2);
		al.add(a1);
		al.add(a2);
		al.remove(0);
		assertEquals(1,al.size());
		assertEquals(2,al.get(0));
	}

	@Test
	public void testGetInt() {
		MyArrayList al = new MyArrayList();
		Integer a1 = new Integer(1);
		Integer a2 = new Integer(2);
		al.add(a1);
		al.add(a2);
		assertEquals(1,al.get(0));
		assertEquals(2,al.get(1));
	}

	@Test
	public void testAddE() {
		MyArrayList al = new MyArrayList();
		Integer a1 = new Integer(1);
		Integer a2 = new Integer(2);
		al.add(a1);
		al.add(a2);
		assertEquals(2,al.size());
	}

}
