public class LinkedDequeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();
        test_Node();
        test_insertLeft();
        test_insertRight();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_Constructor() {
        System.out.println("Testing constructors...");
        LinkedDeque d = new LinkedDeque();

        try {
            displaySuccessIfTrue(d.left() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.right() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                       
    }

    private static void test_Node() {
        System.out.println("Testing Nodes...");
        Node n1 = new Node(new Long(5), null, null);

        try {
            displaySuccessIfTrue(n1.getPrevious() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getNext() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getData().equals(new Long(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        Node n2 = new Node(new String("sup"), null, n1);
        n1.setPrevious(n2);

        try {
            displaySuccessIfTrue(n2.getNext() == n1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n2.getData().equals(new String("sup")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getPrevious() == n2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

    }

    private static void test_insertLeft() {
        System.out.println("Testing insertLeft...");
        LinkedDeque d = new LinkedDeque();
        d.insertLeft(new Long(5));
        Node n1 = (Node) d.left();

        try {
            displaySuccessIfTrue(d.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.right() == d.left());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getData().equals(new Long(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        d.insertLeft(new Long(6));
        n1 = (Node) d.left();

        try {
            displaySuccessIfTrue(n1.getData().equals(new Long(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getNext().getData().equals(new Long(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.size() == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(((Node) d.right()).getData().equals(new Long(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                           

    }

    private static void test_insertRight() {
        System.out.println("Testing insertLeft...");
        LinkedDeque d = new LinkedDeque();
        d.insertRight(new Long(2));
        d.insertLeft(new Long(1));
        d.insertRight(new Long(3));
        Node n1 = (Node) d.left();
        Node n3 = (Node) d.right();
        Node n2 = ((Node) (d.left())).getNext();


        try {
            displaySuccessIfTrue(d.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getNext().getData().equals(new Long(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getPrevious() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n1.getData().equals(new Long(1)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getPrevious().getData().equals(new Long(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getData().equals(new Long(3)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((n3.getNext() == null));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n2.getPrevious().getData().equals(new Long(1)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n2.getData().equals(new Long(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((n2.getNext().getData().equals(new Long(3))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                              
    }    

}
