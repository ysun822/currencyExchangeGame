import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * class that parses API 
 * @author Yanpeng Qi, Yilin Sun, Scarlett Yu
 *
 */
public class API {
		//ArrayList<CurrencyInfo> currenciesList;
		//ArrayList<CurrencyInfo>result=new ArrayList<>();
		
	/**
	 * Parse the JSON response String
	 * @param jsonResponse
	 * @return CurrencyInfo object
	 * @throws JSONException 
	 */ 
	public CurrencyInfo ParseCurrencyJason(String jsonResponse) throws JSONException {
        //create a JSON object with the String response
		String[]array= {"AED","AFN","CAD","BZD","USD","CNY","EUR","GBP","JPY","HRK","TWD","EGP","BRL","IDR","HUF","FKP","NAD","TRY","ZWL","QAR"};
		
        JSONObject jObj = new JSONObject(jsonResponse);
        //Look at the raw String response
        //Look for the results key
        //After the colon there is a square bracket indicating a JSONArray
        String name = jObj.getString("base");
        CurrencyInfo cur = new CurrencyInfo(name);
        HashMap<String,Double>map=cur.children;
        JSONObject jArray1 = jObj.getJSONObject("rates");
        
        for (int i = 0; i < array.length; i++) {
        if (name.equals(array[i])) {
        	continue;
        }
        String finalname=array[i];
        
        
        
        double xrate = jArray1.getDouble(finalname);
      //  System.out.println("This is "+finalname+" "+xrate);
        map.put(finalname, xrate);
        }
 

        return cur;
		
	}
	
	/**
	 * method that forms the URL for currency
	 * @param baseCurrency
	 * @return URL
	 */
	public String createURL(String baseCurrency) {
		String baseURL = "https://data.fixer.io/api/";
        String url2 = "latest?access_key=";
        String key = "Please enter your key";
        String base = "&base=";
        String currencyUrl = baseURL + url2 + key + base + baseCurrency;
        return  currencyUrl;
	}
	/**
	 * Makes the API call and returns the JSON result as a String
	 * @param url
	 * @return JSON result
	 * @throws IOException 
	 */
	public String makeAPICall(URL url) throws IOException {
        URLConnection yc;
        BufferedReader in;
        yc = url.openConnection();
        in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        //Why StringBuffer? - StringBuffer is mutable so we can append to it
        StringBuffer response = new StringBuffer();
        //BufferedReader does not have a "hasNext" type method so this is how to check for
        //more input
        //if it has more input append to the StringBuffer
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
	}
	
//	public static void main(String[] args) throws MalformedURLException {
//		
//		//create the API URL
//		API currency = new API();
//		String s = currency.createURL("USD");
//		URL url = new URL(s);
//		
//		//ArrayList<RecipePuppyRecipe> rpRecipes = new ArrayList<>();
//		
//		try {
//			//make the API call and get a String response
//			String jsonResponse = currency.makeAPICall(url);
//			//parse the response and get an ArrayList of RecipePuppyRecipe objects
//			CurrencyInfo currencyInfo = currency.ParseCurrencyJason(jsonResponse);
//			//view the results in a proper Java object
//			for(CurrencyInfo rpr: currencyInfo.children.keySet()) {
//				System.out.println("currency type is : " + rpr.name + ", rate is: "  + currencyInfo.children.get(rpr));
//				//System.out.println("Ingredients "+rpr.getIngredients());
//				//System.out.println();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} 
}
