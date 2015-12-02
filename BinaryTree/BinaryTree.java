public class BinaryTree implements Iterable {
	private int size;
	private Node root;
	private Object[] binaryTree;

	public BinaryTree() {
		this.size = 0;

	}

	public BinaryTree(Object obj) {
		throw new UnsupportedOperationException();
	}

	public boolean contains(Object obj) {
		return false;
	}

	public boolean similar(Object obj) {
		return false;
	}

	public boolean equals(Object obj) {
		return false;
	}

	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}

	public int size() {
		return this.size;
	}

	public int hashCode() {
		return -1;
	}
	
	public Iterator iterator()  {
        throw new UnsupportedOperationException();
	}	

	public Iterator inOrder() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		BinaryTreeTestHarness.main(new String[]{"begin testing"});
	}
}

class Iterator implements java.util.Iterator {
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public Node next() {
		throw new UnsupportedOperationException();

	}

	public boolean hasNext() {
		throw new UnsupportedOperationException();

	}
}

class Node {
	private Object data;
	private Node leftSon;
	private Node rightSon;
	private Node rightBrother;
	private Node parent;

	Node(Object data, Node parent) {
		this.data = data;
		this.parent = parent;		
		this.leftSon = null;
		this.rightSon = null;
		this.rightBrother = parent != null ? parent.getRightSon() : null;

	}


	public void setAndCreateLeftSon(Object o) {
		Node n = new Node(o, this);
		setLeftSon(n);
	}
	public void setAndCreateRightSon(Object o) {
		Node n = new Node(o, this);
		setRightSon(n);
	}	

	public void setLeftSon(Node n) {
		this.leftSon = n;
	}	

	public void setRightSon(Node n) {
		this.rightSon = n;

		if (this.getLeftSon() != null) {
			this.getLeftSon().setRightBrother(this.rightSon);
		}
	}
	
	public void setRightBrother(Node n) {
		this.rightBrother = n;
	}

	public Node getLeftSon() {
		return this.leftSon;
	}

	public Node getRightSon() {
		return this.rightSon;
	}

	public Node getRightBrother() {
		return this.rightBrother;
	}

	public Node getParent() {
		return this.parent;
	}

	public Object getData() {
		return this.data;
	}	

	public void setData(Object o) {
		this.data = o;
	}
}

