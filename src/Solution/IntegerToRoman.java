// tricky

package Solution;

public class IntegerToRoman {
	public static String intToRoman(int n) {
		if (n == 0) {
			return "";
		}
		String[] romanPieces = { "", "I", "II", "III", "IV", "V", "VI", "VII",
				"VIII", "IX", "", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
				"LXXX", "XC", "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
				"DCCC", "CM", "", "M", "MM", "MMM", "MMMM" };

		return romanPieces[n / 1000 + 30]
				+ romanPieces[(n / 100) % 10 + 20]
				+ romanPieces[(n / 10) % 10 + 10] + romanPieces[n % 10];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
