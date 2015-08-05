package Solution;

public class AddBinary {
	public static String addBinary(String a, String b) {
		String res = "";
		int carry = 0;
		int pa = a.length() - 1;
		int pb = b.length() - 1;
		while (pa >= 0 && pb >= 0) {
			char cura = a.charAt(pa);
			char curb = b.charAt(pb);
			int temp = (cura - 48) + (curb - 48) + carry;
			if (temp == 0) {
				res = "0" + res;
				carry = 0;
			} else if (temp == 1) {
				res = "1" + res;
				carry = 0;
			} else if (temp == 2) {
				res = "0" + res;
				carry = 1;
			} else {
				res = "1" + res;
				carry = 1;
			}
			pa--;
			pb--;
		}
		while (pa >= 0) {
			char cura = a.charAt(pa);
			int temp = (cura - 48) + carry;
			if (temp == 0) {
				res = "0" + res;
				carry = 0;
			} else if (temp == 1) {
				res = "1" + res;
				carry = 0;
			} else if (temp == 2) {
				res = "0" + res;
				carry = 1;
			}
			pa--;
		}
		while (pb >= 0) {
			char curb = b.charAt(pb);
			int temp = (curb - 48) + carry;
			if (temp == 0) {
				res = "0" + res;
				carry = 0;
			} else if (temp == 1) {
				res = "1" + res;
				carry = 0;
			} else if (temp == 2) {
				res = "0" + res;
				carry = 1;
			} else {
				res = "1" + res;
				carry = 1;
			}
			pb--;
		}
		if (carry == 1) {
			res = "1" + res;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1", "11"));
	}

}
