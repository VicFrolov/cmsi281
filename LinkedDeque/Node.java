public class Node {
	private Object data;
	private Node next;
	private Node previous;

	public Node(Object data, Node previous, Node next) {
		this.data = data;
		this.next = next;
		this.previous = previous;

	}

	public Node getNext() {
		return this.next;
	}

	public Node getPrevious() {
		return this.previous;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public void setPrevious(Node n) {
		this.previous = n;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object o) {
		this.data = o;
	}


}