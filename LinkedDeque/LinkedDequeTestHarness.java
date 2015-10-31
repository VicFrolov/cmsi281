public class LinkedDequeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();

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
}
