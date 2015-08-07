// tricky

package Solution;

public class BestTimeToBuyAndSellStockIII {
	public static int maxProfit(int[] prices) {
		int maxProfit1 = 0;
		int maxProfit2 = 0;
		int lowestBuyPrice1 = Integer.MAX_VALUE;
		int lowestBuyPrice2 = Integer.MAX_VALUE;
		// computation order matters
		for (int p : prices) {
			maxProfit2 = Math.max(maxProfit2, p - lowestBuyPrice2);
			lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1);
			maxProfit1 = Math.max(maxProfit1, p - lowestBuyPrice1);
			lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
		}
		return maxProfit2;
	}

	// reference, two traversal
	public static int maxProfits(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int[] maxFromHead = new int[len];
		maxFromHead[0] = 0;
		int minprice = prices[0], maxprofit = 0;
		for (int i = 1; i < len; i++) {
			minprice = Math.min(prices[i - 1], minprice);
			if (maxprofit < prices[i] - minprice)
				maxprofit = prices[i] - minprice;
			maxFromHead[i] = maxprofit;
		}
		
		int maxprice = prices[len - 1];
		int res = maxFromHead[len - 1];
		maxprofit = 0;
		for (int i = len - 2; i >= 0; i--) {
			maxprice = Math.max(maxprice, prices[i + 1]);
			if (maxprofit < maxprice - prices[i])
				maxprofit = maxprice - prices[i];
			if (res < maxFromHead[i] + maxprofit)
				res = maxFromHead[i] + maxprofit;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 4, 4, 6, 1, 1, 4, 2, 5 };
		System.out.println(maxProfits(prices));
	}

}
