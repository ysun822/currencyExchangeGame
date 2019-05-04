import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * JUnit Test for FindCycleProfit
 * @author Yanpeng Qi, Yilin Sun
 *
 */
public class FindCycleProfitTest {
	/**
	 * initialize FindCycleProfit object and test if it is successful
	 */
	@Test
	public void testFindCycleProfit() {
		FindCycleProfit test1 = new FindCycleProfit();
		assertTrue(test1.paths.size() == 0);
	}
	/**
	 * test FindCycle found the best case to be starting with USD
	 */
	@Test
	public void testFindCycle() {
		CurrencyInfo test1 = new CurrencyInfo("CHY");
		CurrencyInfo test2 = new CurrencyInfo("USD");
		CurrencyInfo test3 = new CurrencyInfo("JPY");
		CurrencyInfo test4 = new CurrencyInfo("ABC");
		// set each edge to 5 except one
		// we need to find that one
		test1.add("USD", 7.0);
		test1.add("JPY", 5.0);
		test1.add("ABC", 5.0);
		test2.add("CHY", 5.0);
		test2.add("JPY", 5.0);
		test2.add("ABC", 5.0);
		test3.add("USD", 5.0);
		test3.add("CHY", 5.0);
		test3.add("ABC", 5.0);
		test4.add("CHY", 5.0);
		test4.add("USD", 5.0);
		test4.add("JPY", 5.0);
		
		CurrencyInfo[] info = new CurrencyInfo[4];
		info[0] = test1;
		info[1] = test2;
		info[2] = test3;
		info[3] = test4;
		
		FindCycleProfit testCycleProfit = new FindCycleProfit();
		
		ArrayList<ArrayList<String>> res = testCycleProfit.findCycle(3, info, test1);
		assertTrue(res.get(0).size() == 4);
		
		// test the first line
		assertTrue(res.get(0).get(1).equals("USD"));
	}

}
