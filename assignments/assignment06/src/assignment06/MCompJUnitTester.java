package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MCompJUnitTester {
	private MComp tester = MCompTester.makeTest();
	
	@Test
	public void testCheapest() {
		assertEquals("Apple Pie", MCompTester.cheapest(tester).getName());
	}
	
	@Test
	public void testDearest() {
		assertEquals("Burrito", MCompTester.dearest(tester).getName());
	}
	
	@Test
	public void testLongestDescr() {
		assertEquals("Veggie Burger and Air Fries", MCompTester.longestDescr(tester).getName());
	}

}
