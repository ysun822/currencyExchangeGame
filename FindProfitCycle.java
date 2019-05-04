import java.util.ArrayList;
/**
 * This Interface  finds the profit cycle of all combinations within requested range
 * @author Yanpeng Qi
 *
 */
public interface FindProfitCycle {
	/**
	 * this method implements DFS to find potentially profitable exchange cycle 
	 * @param currencyNum the number of currencies to be exchanged as requested by the user
	 * @param info an array of currencies
	 * @param src the currency to start with
	 * @return an arraylist of currencies that may generate profit after exchanging
	 */
	public ArrayList<ArrayList<String>> findCycle(int currencyNum, CurrencyInfo[] info, CurrencyInfo src);
}
