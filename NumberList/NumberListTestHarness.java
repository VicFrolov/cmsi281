public class NumberListTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Me();
     

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_Me() {
        System.out.println("Testing Stuff...");
    
        
        // try {
        //     displaySuccessIfTrue();
        // } catch(Exception e) {
        //     displaySuccessIfTrue(false);
        // }
        // try {
        //     displaySuccessIfTrue();
        // } catch(Exception e) {
        //     displaySuccessIfTrue(false);
        // }        

        
    }
}