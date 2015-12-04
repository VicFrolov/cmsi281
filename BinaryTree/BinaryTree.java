import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree implements Iterable {
    private int size;
    private Node root;
    private Node cursor;


    public BinaryTree() {
        this.size = 0;
        this.root = null;
        this.cursor = null;
    }


    public BinaryTree(Object obj) {
        this.size = 1;
        this.root = new Node(obj, null);
        this.putCursorAtRoot();
    }


    public Object getCursorData() {
        if (!this.isEmpty()) {
            return this.cursor.getData();
        } else {
            return null;
        }
    }


    public Node getCursorNode() {
        if (!this.isEmpty()) {
            return this.cursor;
        } else {
            return null;
        }
    }


    public boolean contains(Object obj) {
        for(Object o : this) {
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }


    public boolean similar(Object obj) {
        if (!(obj instanceof BinaryTree)) {
            return false;
        }

        BinaryTree tree2 = (BinaryTree) obj;

        if (this.isEmpty() && tree2.isEmpty()) {
            return true;
        } else if (this.size() != tree2.size()) {
            return false;
        }

        this.putCursorAtRoot();
        tree2.putCursorAtRoot();
        Node tree1Node = this.getCursorNode();
        Node tree2Node = tree2.getCursorNode();

        return treeComparison(tree1Node, tree2Node);
    }


    private boolean treeComparison(Node n1, Node n2) {

        boolean differentSons = (n1.getLeftSon() != null && n2.getLeftSon() == null) 
            || (n1.getLeftSon() == null && n2.getLeftSon() != null) 
            || (n1.getRightSon() == null && n2.getRightSon() != null) 
            || (n1.getRightSon() != null && n2.getRightSon() == null);
        
        if (differentSons)  {
            return false;
        }

        if (n1.getRightSon() != null) {
            if (!treeComparison(n1.getRightSon(), n2.getRightSon())) {
                return false;
            }
        }

        if (n1.getLeftSon() != null) {
            if (!treeComparison(n1.getLeftSon(), n2.getLeftSon())) {
                return false;
            }
        }
        return true;
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryTree)) {
            return false;
        }

        BinaryTree tree2 = (BinaryTree) obj;
        
        if (this.size() != tree2.size()) {
            return false;
        } else if (this.isEmpty() && tree2.isEmpty()) {
            return true;
        } else if (!this.similar(tree2)) {
            return false;
        }

        Iterator tree1Iterator = this.iterator();
        Iterator tree2Iterator = tree2.iterator();      

        while (tree1Iterator.hasNext()) {
            Object tree1Object = tree1Iterator.next();
            Object tree2Object = tree2Iterator.next();

            if (!tree1Object.equals(tree2Object)) {
                return false;
            }
        }

        return true;
    }


    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }


    public int size() {

        return this.size;
    }


    public int hashCode() {
        int hash = 5381;
        for (Object n : this) {
            hash = 33 * hash + n.hashCode();
        }

        return hash;
    }


    public boolean putCursorAtRoot() {
        if ( this.isEmpty() ) {
            return false;
        } else {
            this.cursor = this.root;
            return true;
        }
    }


    public boolean putCursorAtLeftSon() {
        if (this.isEmpty()) {
            return false;
        }

        Node leftSon = this.cursor.getLeftSon();

        if (leftSon == null) {
            return false;
        } else {
            this.cursor = leftSon;
            return true;
        }
    }


    public boolean putCursorAtRightSon() {
        if (this.isEmpty()) {
            return false;
        }

        Node rightSon = this.cursor.getRightSon();

        if (rightSon == null) {
            return false;
        } else {
            this.cursor = rightSon;
            return true;
        }
    }


    public boolean putCursorAtFather() {
        if (this.isEmpty()) {
            return false;
        }

        Node parent = this.cursor.getParent();
        
        if (parent == null) {
            return false;
        } else {
            this.cursor = parent;
            return true;
        }
    }


    public boolean attachLeftSonAtCursor(Object obj) {
        if (this.isEmpty()) {
            return false;
        } else if (this.cursor.getLeftSon() != null) {
            return false;
        } else {
            this.cursor.setAndCreateLeftSon(obj);
            this.size++;
            return true;
        }
    }


    public boolean attachRightSonAtCursor(Object obj) {
        if (this.isEmpty()) {
            return false;
        } else if (this.cursor.getRightSon() != null) {
            return false;
        } else {
            this.cursor.setAndCreateRightSon(obj);
            this.size++;
            return true;
        }
    }


    public boolean pruneFromCursor() {
        if (this.isEmpty()) {
            return false;
        }

        Node nodeToPrune = this.getCursorNode();
        Node parentOfPrune = nodeToPrune.getParent();
        int newSize = 0;

        if (nodeToPrune.equals(this.root)) {
            if (nodeToPrune.getLeftSon() != null) {
                nodeToPrune.getLeftSon().setParent(null);                
                nodeToPrune.setLeftSon(null);
            }

            if (nodeToPrune.getRightSon() != null) {
                nodeToPrune.getRightSon().setParent(null);
                nodeToPrune.setRightSon(null);
            }
            this.size = 0;
            return true;
        }

        if (parentOfPrune.getLeftSon() != null && parentOfPrune.getLeftSon().equals(nodeToPrune)) {
            parentOfPrune.setLeftSon(null);
        } else {
            parentOfPrune.setRightSon(null);
        }

        nodeToPrune.setParent(null);
        this.putCursorAtRoot();

        for (Object o : this) {
            newSize++;
        }

        this.size = newSize;

        return true;
    }


    public Iterator iterator()  {
        return new PreOrderIterator(this);
    }   


    public Iterator inOrder() {
        return new InOrderIterator(this);
    }



    private class InOrderIterator implements Iterator {
        private Stack<Node> stack;
        private Node lastNodeIterated;
        private Node parentNodeToSkip;
        private Node nodeContainingNull;

        public InOrderIterator(BinaryTree b) {
            this.stack = new Stack<Node>();
            if (!b.isEmpty()) {
                b.putCursorAtRoot();
                this.stack.add(b.getCursorNode());
                this.nodeContainingNull = new Node(null, null);                
                this.lastNodeIterated = nodeContainingNull;
                this.parentNodeToSkip = nodeContainingNull;
            }
        }

        private boolean returnCurrentNode(Node currentNode) {
            if (currentNode.getLeftSon() == null) {
                return true;
            } else if (currentNode.getLeftSon() != null) {
                Node checkIfNodeHasBeenIterated = currentNode.getLeftSon();
                
                if (checkIfNodeHasBeenIterated == lastNodeIterated) {
                    return true;
                }

                while(checkIfNodeHasBeenIterated != null) {
                    if (checkIfNodeHasBeenIterated.getRightSon() == lastNodeIterated) {
                        return true;
                    }
                    checkIfNodeHasBeenIterated = checkIfNodeHasBeenIterated.getRightSon();
                }
            }
            return false;
        }

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node currentNode = stack.pop();

            if (returnCurrentNode(currentNode)) {
                if (currentNode.getRightSon() != null) {
                    stack.add(currentNode.getRightSon());
                }

                lastNodeIterated = currentNode;
                return currentNode.getData();
            } else {
                while (currentNode.getLeftSon() != null) {
                    stack.add(currentNode);
                    currentNode = currentNode.getLeftSon();
                }

                if (currentNode.getRightSon() != null) {
                    stack.add(currentNode.getRightSon());
                }

                lastNodeIterated = currentNode;
                return currentNode.getData();
            }
        }


        public boolean hasNext() {
            return !this.stack.empty();
        }
        

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class PreOrderIterator implements Iterator {
        protected Stack<Node> stack;


        public PreOrderIterator(BinaryTree b) {
            this.stack = new Stack<Node>();
            
            if (!b.isEmpty()) {
                b.putCursorAtRoot();
                this.stack.add(b.getCursorNode());
            }
        }


        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node poppedNode = this.stack.pop();

            if (poppedNode.getLeftSon() != null) {
                if (poppedNode.getRightSon() != null) {
                    this.stack.add(poppedNode);
                }
                this.stack.add(poppedNode.getLeftSon());
            } else if (poppedNode.getRightSon() != null) {
                this.stack.add(poppedNode.getRightSon());
            } else  {
                if (stack.size() != 0) {

                    Node parent = this.stack.pop();

                    if (parent.getRightSon() != null) {
                        this.stack.add(parent.getRightSon());
                    }   
                }
            }
            return poppedNode.getData();
        }

        public boolean hasNext() {
            return this.stack.empty() ? false : true;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }                
    } 

    public static void main(String[] args) {
        BinaryTreeTestHarness.main(new String[]{"begin testing"});
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

        if (n != null && n.getParent() == null) {
            n.setParent(this);
        }
        if (n != null && this.rightSon != null) {
            this.leftSon.setRightBrother(this.rightSon);
        }
    }   


    public void setRightSon(Node n) {
        this.rightSon = n;

        if (n != null && n.getParent() == null) {
            n.setParent(this);
        }

        if (n != null && this.leftSon != null) {
            this.leftSon.setRightBrother(this.rightSon);
        }
    }


    public void setParent(Node n) {
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


    public boolean hasChildren() {
        if (this.leftSon == null && this.rightSon == null) {
            return false;
        } else {
            return true;
        }
    }
}
