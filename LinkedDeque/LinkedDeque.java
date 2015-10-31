public class LinkedDeque {
	private int size;
	private Object left;
	private Object right;
	
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
		throw new UnsupportedOperationException();

	}

	public Object right() {
		// returns the right element without modifiying the deque
		throw new UnsupportedOperationException();

	}

	public int size() {
        return size;

	}

	public String toString(){
		// returns [obj][obj]...[obj]
        throw new UnsupportedOperationException();

	} 

	public static void main(String[] args) {
		// runs a comprehensive set of unit tests

	}

}