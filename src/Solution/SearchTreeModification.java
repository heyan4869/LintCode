package Solution;

public class SearchTreeModification {

	public static void main(String args[]) {
		TernarySearchTreeModification a = new TernarySearchTreeModification();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		//a.insert(4);
		//a.insert(5);
		a.delete(2);
		a.delete(1);
		a.insert(4);
		System.out.println(a.toString());
	}

}
