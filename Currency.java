/**
 * This is an Interface for currency 
 * @author Yanpeng Qi, Yilin Sun, Scarlett Yu
 *
 */
public interface Currency {
	/**
	 * This method adds a currency type with specific rate to the original currency to list
	 * @param currency added to list
	 * @param rate the exchange rate between original and added-on currency
	 */
	public void add(String currency, Double rate);
	/**
	 * remove a single currency from currency list
	 * @param currency the currency to be removed
	 */
	public void remove(String currency);
	/**
	 * remove a single currency and its exchange rate from currency list
	 * @param currency type of currency to be removed
	 * @param rate exchange rate between original and the one to be removed
	 */
	public void remove(String currency, Double rate);
	/**
	 * getter method for list of currency
	 * @return size
	 */
	public int getSize();
}
