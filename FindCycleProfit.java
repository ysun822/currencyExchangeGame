import java.util.ArrayList;
import java.util.HashSet;
/**
 * This class finds profit cycle
 * @author Yanpeng Qi, Scarlett Yu, Yilin Sun 
 *
 */
public class FindCycleProfit implements FindProfitCycle{

	public ArrayList<ArrayList<String>> paths;
	public ArrayList<Double> maxRate;
	CurrencyInfo[] infos;
	/**
	 * constructor for FindCycleProfit
	 */
	public FindCycleProfit() {
		paths = new ArrayList<ArrayList<String>>();
		maxRate = new ArrayList<Double>();
	}
	/**
	 * this method implements DFS to find potentially profitable exchange cycle 
	 */
	public ArrayList<ArrayList<String>> findCycle(int currencyNum, CurrencyInfo[] info, CurrencyInfo src) {
		infos = info;
		ArrayList<String> path = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		path.add(src.name);
		double max = 0.0;
		helper(src, src, currencyNum, 0, path, set, 1.0, max);
		return paths;
	}
	
	private void helper(CurrencyInfo src, CurrencyInfo cur, int currencyNum, int i, ArrayList<String> path, HashSet<String> set, double amount, double max) {
		if (i == currencyNum) {
			if (cur.name.equals(src.name)) {
				if (amount > max) {
					max = amount;
					maxRate.add(0, max);
					paths.add(0, new ArrayList<String>(path));
				}
			}
			return;
		}
		
		if (i > currencyNum) {
			return;
		}
		
		CurrencyInfo nextInfo = null;
		
		for (String next: cur.children.keySet()) {
			if (set.contains(next)) {
				continue;
			}
			
			for (CurrencyInfo c: infos) {
				if (c.name.equals(next)) {
					nextInfo = c;
				}
			}
			
			path.add(next);
			set.add(next);
			helper(src, nextInfo, currencyNum, i + 1, path, set, amount * cur.children.get(next), max);
			path.remove(path.size() - 1);
			set.remove(next);
		}
	}
}
