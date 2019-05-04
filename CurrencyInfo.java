import java.util.HashMap;
/**
 * An object class implementing Currency interface that defines a starter currency
 * @author Yanpeng Qi, Yilin Sun, Scarlett Yu
 *
 */
public class CurrencyInfo implements Currency {

	public String name;
	public double rate;
	public HashMap<String, Double> children;
	
	public CurrencyInfo(String name) {
		this.name = name;
		children = new HashMap<String, Double>();
	}
	/**
	 * constructor for CurrencyInfo class with name and hashmap of its children
	 * @param name the name of currency
	 */
	public CurrencyInfo(String name, double rate) {
		this.name = name;
		this.rate = rate;
		children = new HashMap<String, Double>();
	}
	/**
	 * This method adds a currency type with specific rate to the original currency to list
	 */
	@Override
	public void add(String currency, Double rate) {
		// TODO Auto-generated method stub
		children.put(currency, rate);
	}
	/**
	 * remove a single currency from currency list
	 */
	@Override
	public void remove(String currency) {
		// TODO Auto-generated method stub
		children.remove(currency);
	}
	/**
	 * remove a single currency and its exchange rate from currency list
	 */
	@Override
	public void remove(String currency, Double rate) {
		// TODO Auto-generated method stub
		if (Math.abs(children.get(currency)) - rate <= 0.000001) {
			children.remove(currency);
		}
	}
	/**
	 * getter method for size
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.children.size();
	}

}
