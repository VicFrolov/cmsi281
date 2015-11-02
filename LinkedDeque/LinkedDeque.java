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
        if (this.size == 0) {
            this.left = new Node(o, null, null);
            this.right = this.left;
        } else {
            Node newNodeToAdd = new Node(o, null, this.left);
            this.left.setPrevious(newNodeToAdd);
            this.left = newNodeToAdd;
        }
        size++;
    }


	public void insertRight(Object o) {
		if (this.size == 0) {
			this.right = new Node(o, null, null);
			this.left = this.right;
		} else {
			Node newNodeToAdd = new Node(o,this.right, null);
			this.right.setNext(newNodeToAdd);
			this.right = newNodeToAdd;
		}
		size++;
	}

	public void deleteLeft() {
        throw new UnsupportedOperationException();

	}

	public void deleteRight() {
        throw new UnsupportedOperationException();

	}

	public Object left() {
		return this.left;
	}

	public Object right() {
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