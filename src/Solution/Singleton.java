// confused

package Solution;

public class Singleton {
	private static volatile Solution instance = null;

	// private constructor
	private void Solution() {
		
	}

	public static Solution getInstance() {
		if (instance == null) {
			synchronized (Solution.class) {
				// Double check
				if (instance == null) {
					instance = new Solution();
				}
			}
		}
		return instance;
	}
}
