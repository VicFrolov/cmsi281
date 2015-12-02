public class BinaryTree implements Iterable {
    private int size;
    private Node root;

    public BinaryTree() {
        this.size = 0;
        root = null;
    }

    public BinaryTree(Object obj) {
        this.size = 1;
        root = new Node(obj, null);
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
        if (n.getParent() == null) {
            n.setParent(this);
        }
        if (this.rightSon != null) {
            this.leftSon.setRightBrother(this.rightSon);
        }
    }   

    public void setRightSon(Node n) {
        this.rightSon = n;

        if (n.getParent() == null) {
            n.setParent(this);
        }

        if (this.leftSon != null) {
            this.leftSon.setRightBrother(this.rightSon);
        }
    }

    private void setParent(Node n) {
        this.parent = n;
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

