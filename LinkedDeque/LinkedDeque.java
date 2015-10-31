public class LinkedDeque {
	private int size;
	private Node left;
	private Node right;

	public LinkedDeque() {
		left = null;
		right = null;
		size = 0;
	}

	public void insertLeft(Object o) {
        throw new UnsupportedOperationException();

	}

	public void insertRight(Object o) {
        throw new UnsupportedOperationException();

	}

	public void deleteLeft() {
        throw new UnsupportedOperationException();

	}

	public void deleteRight() {
        throw new UnsupportedOperationException();

	}

	public Object left() {
		// returns the left element without modifiying the deque
		return this.left;

	}

	public Object right() {
		// returns the right element without modifiying the deque
        return this.right;
	}

	public int size() {
        return this.size;

	}

	public String toString(){
		// returns [obj][obj]...[obj]
        throw new UnsupportedOperationException();

	} 

	public static void main(String[] args) {
        LinkedDequeTestHarness.main(new String[]{"tester"});

	}

}