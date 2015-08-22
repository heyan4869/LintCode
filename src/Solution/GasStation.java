// tricky

package Solution;

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int start = -1;
		int sum = 0;
		int total = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + (gas[i] - cost[i]);
			total = total + (gas[i] - cost[i]);
			if (sum < 0) {
				start = i;
				sum = 0;
			}
		}
		return total >= 0 ? start + 1 : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
