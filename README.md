# currencyExchangeGame

We use Fixer API to get current exchange rate information of different currencies. Run multiple Junit tests on the application and use Java Swing to construct user interface for interactions. This currency exchange game finds the possible way to earn profits by exchanging different currencies. The user will choose a currency they want as the start sources, enter the number of the currency they want in the exchange cycle and the amount they have of the start sources. The program will run based on the DFS algorithm. In the end, the most profitable cycle will display with the final amount they got. If there is no profitable cycle, the less lost solution will display.

Make API calls:


API key is already included in the program. Please enter your API key in API class.

Execution:

1, Run DemoFrame.java
2, A Swing rectangle block will show up with “Base Currency:”, “Amounts:”, “Exchanging currency (2-5):” blanks and “Go”, “Reset” buttons.
3, There are 20 currencies to choose from, You may enter any of them to the “Base Currency” blank:
AED,AFN,CAD,BZD,USD,CNY,EUR,GBP,JPY,HRK,TWD,EGP,BRL,IDR,HUF,FKP,NAD,TRY,ZWL,QAR.
4, You may also enter an integer amount in the “Amounts” block, such as 100.
5, Then you can pick from 2 to 5 as the number of currencies you would like to exchange including the base currency as the money must be exchanged back to the base currency. 
6, Then you hit “Go” button. Soon, an exchange path will be generated which gives you the most profitable exchange route. 
7, To restart, you may hit “Reset”.
