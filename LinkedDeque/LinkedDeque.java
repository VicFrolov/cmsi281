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
		if (this.size == 0) {
			//cannot throw NoSuchElementException without import so throwing this instead
			throw new UnsupportedOperationException("the LinkedDeque is already empty");
		} else if (this.size == 1) {
			this.left = null;
			this.right = this.left;
			size--;
		} else {
			this.left = this.left.getNext();
			this.left.setPrevious(null);
			size--;
		}
	}

	public void deleteRight() {
		if (this.size == 0) {
			//cannot throw NoSuchElementException without import so throwing this instead
			throw new UnsupportedOperationException("the LinkedDeque is already empty");
		} else if (this.size == 1) {
			this.right = null;
			this.left = this.right;
			size--;
		} else {
			this.right = this.right.getPrevious();
			this.right.setNext(null);
			size--;
		}
	}

	public Object left() {
		if (this.size == 0) {
			return null;
		}
        else {
			return this.left.getData();
		}
	}

	public Object right() {
		if (this.size == 0) {
			return null;
		}
        else {
         	return this.right.getData();
        }
	}

	public int size() {
        return this.size;
	}

	public String toString(){
		//return null if LinkedDeque is empty
		if (this.size == 0) {
			return null;
		} else {
			Node temp = this.left;
			String stringifiedLinkedDeque = "";
			while (temp != null) {
				stringifiedLinkedDeque += "[" + temp.getData() + "]";
				temp = temp.getNext();
			}
			return stringifiedLinkedDeque;
		}
	} 

	public static void main(String[] args) {
        LinkedDequeTestHarness.main(new String[]{"tester"});
	}

}