package GoogleOA;

/* Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy 
 * one and sell one share of the stock multiple times) with the following restrictions: You may not engage in 
 * multiple transactions at the same time (ie, you must sell the stock before you buy again). After you sell 
 * your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example: prices = [1, 2, 3, 0, 2]   maxProfit = 3   transactions = [buy, sell, cooldown, buy, sell]
 * */

public class BTBSCooldown {
	//buy[i]  = max(rest[i-1]-price, buy[i-1]) ,rest[i] = sell[i-1] ==> buy[i] = max(sell[i-2]-price, buy[i-1])
    //sell[i] = max(buy[i-1]+price, sell[i-1])
    //rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
    public static int maxProfit(int[] prices) {
        int sell = 0;
        int pre_sell = 0;
        int buy = Integer.MIN_VALUE;
        int pre_buy;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
    public static void main(String...args) {
    	int[] p = {1, 2, 3, 0, 2};
    	System.out.println(BTBSCooldown.maxProfit(p));
    }
}
