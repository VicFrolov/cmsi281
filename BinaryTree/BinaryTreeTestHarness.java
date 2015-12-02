public class BinaryTreeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_NodeConstructor();
        test_Nodes();


        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_NodeConstructor() {
        System.out.println("Testing Node Constructor...");
        Node n = new Node(new Long(10), null);

        try {
            displaySuccessIfTrue(n.getParent() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getData().equals(new Long(10)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null && n.getRightSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                       
    }

    private static void test_Nodes() {
        System.out.println("Testing Nodes...");
        Node n = new Node(new Long(10), null);
        Node n2 = new Node(new Long(2), n);
        n.setRightSon(n2);


        try {
            displaySuccessIfTrue(n2.getParent().equals(n));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getRightSon().equals(n2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n2.getData().equals(new Long(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n.getLeftSon() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

		Node n3 = new Node(new Long(0), n);
        n.setLeftSon(n3);

        try {
            displaySuccessIfTrue(n3.getRightBrother().equals(n2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

		n3.setAndCreateRightSon(new String("right son of n3"));
		n3.setAndCreateLeftSon(new String("left son of n3"));

		Node n4 = n3.getLeftSon();
		Node n5 = n3.getRightSon();

        try {
            displaySuccessIfTrue(n5.getData().equals(new String("right son of n3")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getRightBrother().equals(n5));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getParent().equals(n3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n5.getParent().equals(n3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getRightSon().equals(n5));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n3.getLeftSon().equals(n4));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(n4.getData().equals("left son of n3"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }         
    }    
}