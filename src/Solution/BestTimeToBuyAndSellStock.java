package Solution;

public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int curMin = Integer.MAX_VALUE;
		int curMax = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			curMin = Math.min(prices[i], curMin);
			curMax = Math.max(prices[i] - curMin, curMax);
		}
		return curMax;
	}

	public static void main(String[] args) {
		int[] prices = {1, 4, 2, 5, 1};
		System.out.println(maxProfit(prices));
	}

}
