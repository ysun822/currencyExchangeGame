import static org.junit.Assert.*;

import org.junit.Test;
/**
 * This is a tester for CurrencyInfo class
 * @author sYanpeng Qi, Yilin Sun, Scarlett Yu
 *
 */
public class CurrencyInfoTest {

	@Test
	public void testCurrencyInfo() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		assertTrue(test1.name.equals("CHY"));
	}

	@Test
	public void testAdd() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		CurrencyInfo test2 = new CurrencyInfo("USD");
		test1.add("USD", 7.0);
		assertTrue(Math.abs(test1.children.get("USD") - 7.0) <= 0.0001);
	}

	@Test
	public void testRemoveString() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		CurrencyInfo test2 = new CurrencyInfo("USD");
		test1.add("USD", 7.0);
		assertTrue(test1.children.size() == 1);;
		test1.remove("USD");
		assertTrue(test1.children.size() == 0);
	}

	@Test
	public void testRemoveStringDouble() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		CurrencyInfo test2 = new CurrencyInfo("USD");
		test1.add("USD", 7.0);
		assertTrue(test1.children.size() == 1);
		// remove currency with incorrect, it will not be removed
		test1.remove("USD", 6.9);
		assertTrue(test1.children.size() == 1);
		test1.remove("USD", 7.0);
		assertTrue(test1.children.size() == 0);
	}

	@Test
	public void testGetSize() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		CurrencyInfo test2 = new CurrencyInfo("USD");
		CurrencyInfo test3 = new CurrencyInfo("JPY");
		assertTrue(test1.getSize() == 0);
		test1.add("USD", 7.0);
		assertTrue(test1.getSize() == 1);
		test1.add("USD", 0.1);
		assertTrue(test1.getSize() == 1);
	}

}
