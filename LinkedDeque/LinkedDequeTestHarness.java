public class LinkedDequeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();
        test_Node();
        test_left();
        test_toString();
        test_insertLeft();
        test_insertRight();
        test_deleteLeft();
        test_deleteRight();

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

    private static void test_left() {
        System.out.println("testing left() and right() methods...");
        LinkedDeque d = new LinkedDeque();
        LinkedDeque d2 = new LinkedDeque();

        d.insertLeft(new Long(1));
        d.insertRight(new Long(10));
        d.insertRight(new Long(12));
        d.insertLeft(new Long(100));
        d.insertRight(new Long(20));

        try {
            displaySuccessIfTrue(d.left().equals(new Long(100)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.right().equals(new Long(20)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.left() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.right() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                  
    }

    private static void test_toString() {
        System.out.println("testing toString()");
        LinkedDeque d = new LinkedDeque();
        LinkedDeque d2 = new LinkedDeque();
        LinkedDeque d3 = new LinkedDeque();

        d.insertLeft(new Long(1));
        d.insertRight(new Long(10));
        d.insertRight(new Long(12));
        d.insertLeft(new Long(100));
        d.insertRight(new Long(20));

        d2.insertLeft(new String("Hi"));
        d2.insertLeft(new String("Bye"));
        d2.insertRight(new String("No"));

        try {
            displaySuccessIfTrue(d.toString().equals("[100][1][10][12][20]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.toString().equals("[Bye][Hi][No]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d3.toString() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                  
    }    

    private static void test_insertLeft() {
        System.out.println("Testing insertLeft...");
        LinkedDeque d = new LinkedDeque();
        d.insertLeft(new Long(5));
        String d1 = d.toString();

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
            displaySuccessIfTrue(d1.equals("[5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        d.insertLeft(new Long(6));
        String d2 = d.toString();

        try {
            displaySuccessIfTrue(d.left().equals(new Long(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.equals("[6][5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.size() == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                         
    }

    private static void test_insertRight() {
        System.out.println("Testing insertRight...");
        LinkedDeque d = new LinkedDeque();
        d.insertRight(new Long(2));
        d.insertLeft(new Long(1));
        d.insertRight(new Long(3));
        String dString = d.toString();


        try {
            displaySuccessIfTrue(d.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(dString.equals("[1][2][3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                  
    } 

    private static void test_deleteLeft() {
        System.out.println("Testing deleteLeft...");
        LinkedDeque d = new LinkedDeque();
        LinkedDeque d2 = new LinkedDeque();
        LinkedDeque d3 = new LinkedDeque();

        d.insertRight(new Long(2));
        d.insertLeft(new Long(1));
        d.insertRight(new Long(3));
        d.insertRight(new String("sup banana face"));
        d.deleteLeft();

        d2.insertLeft(new Long(10));
        d2.deleteLeft();

        d3.insertRight(new Long(100));
        d3.insertLeft(new Long(99));
        d3.deleteLeft();
        d3.deleteLeft();

        String d3String = d3.toString();
        String dString = d.toString();
        String d2String = d2.toString();
        
        try {
            displaySuccessIfTrue(dString.equals("[2][3][sup banana face]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }     
        try {
            displaySuccessIfTrue(d2String == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d3String == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d3.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                           
    } 

    private static void test_deleteRight() {
        System.out.println("Testing deleteRight...");
        LinkedDeque d = new LinkedDeque();
        LinkedDeque d2 = new LinkedDeque();
        LinkedDeque d3 = new LinkedDeque();

        d.insertRight(new Long(2));
        d.insertLeft(new Long(1));
        d.insertRight(new Long(3));
        d.insertRight(new String("sup banana face"));
        d.deleteRight();

        d2.insertLeft(new Long(10));
        d2.deleteRight();

        d3.insertRight(new Long(100));
        d3.insertLeft(new Long(99));
        d3.deleteRight();
        d3.deleteLeft();

        String d3String = d3.toString();
        String dString = d.toString();
        String d2String = d2.toString();

        try {
            displaySuccessIfTrue(dString.equals("[1][2][3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }     
        try {
            displaySuccessIfTrue(d2String == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d2.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d3String == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(d3.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                           
    }     

}
