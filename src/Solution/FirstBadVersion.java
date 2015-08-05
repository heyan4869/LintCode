// tricky

package Solution;

public class FirstBadVersion {
	public static int findFirstBadVersion(int n) {
		if (n == 0) {
			return -1;
		}

		int start = 1, end = n, mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (VersionControl.isBadVersion(mid) == false) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (VersionControl.isBadVersion(start) == true) {
			return start;
		} else if (VersionControl.isBadVersion(end) == true) {
			return end;
		} else {
			// not found
			return -1;
		}
	}

//	private static int assist(int start, int end) {
//		if (start > end) {
//			return 0;
//		}
//		int mid = (start + end) / 2;
//		if (VersionControl.isBadVersion(mid) == true
//				&& VersionControl.isBadVersion(mid - 1) == false) {
//			return mid;
//		}
//		if (VersionControl.isBadVersion(mid) == false) {
//			return assist(mid + 1, end);
//		}
//		if (VersionControl.isBadVersion(mid) == true) {
//			return assist(start, mid - 1);
//		}
//		return 0;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
