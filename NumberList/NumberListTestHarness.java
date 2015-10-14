public class NumberListTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Me();
        adder();
     

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_Me() {
        System.out.println("Testing constructors...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});

        try {
            displaySuccessIfTrue(nl.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(nl.isEmpty() == true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.isEmpty() == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        // try {
        //     displaySuccessIfTrue(NumberList nl4 = new NumberList(5) == false);
        // } catch(Exception e) {
        //     displaySuccessIfTrue(false);
        // }         
        
    }

    private static void adder() {
        System.out.println("Testing adding objects...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        nl.add(new Long(2));
        nl3.add(new Long(2));
        nl3.add(new Long(3));

        try {
            displaySuccessIfTrue(nl.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(nl.isEmpty() == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.isEmpty() == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}