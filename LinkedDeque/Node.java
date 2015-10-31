public class Node {
	private Object data;
	private Node next;
	private Node previous;

	public Node(Object data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;

	}

	public Node getnext() {
		return this.next;
	}

	public Node getPrevious() {
		return this.previous;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public void setData(Object o) {
		this.data = o;
	}
}