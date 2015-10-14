public class NumberListTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Me();
        adder();
        count();
        toString_tester();
        clear_tester();
        contains_tester();

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
            displaySuccessIfTrue(nl.sizeIncludingDuplicates() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.sizeIncludingDuplicates() == 3);
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
        
    }

    private static void adder() {
        System.out.println("Testing adding objects...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        nl.add(new Long(2));
        nl3.add(new Long(2));
        nl3.add(new Long(3));
        nl3.add(4);

        try {
            displaySuccessIfTrue(nl.sizeIncludingDuplicates() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.sizeIncludingDuplicates() == 3);
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

    private static void count() {
        System.out.println("Testing count method...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        nl.add(new Long(2));
        nl3.add(new Long(1));
        nl3.add(new Long(2));
        nl3.add(new Long(3));


        try {
            displaySuccessIfTrue(nl.count(new Long(1)) == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.count(new Long(4)) == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(nl2.count(new Long(1)) == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.count(new Long(4)) == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.count(new Long(1)) == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(nl3.count(new Long(1)) == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.count(new Long(4)) == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
    } 

    private static void toString_tester() {
        System.out.println("Testing toString...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(1), new Long(2), new Long(3)});

        try {
            displaySuccessIfTrue(nl.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.toString().equals("[1]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
        try {
            displaySuccessIfTrue(nl4.toString().equals("[1, 2, 3, 1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                               
    }


    private static void clear_tester() {
        System.out.println("Testing void...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(1), new Long(2), new Long(3)});

        nl.clear();
        nl2.clear();
        nl3.clear();

        nl3.add(new Long(5));
        nl4.clear();
        nl4.add(new Long(8));
        nl4.add(new Long(10));


        try {
            displaySuccessIfTrue(nl.sizeIncludingDuplicates() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.sizeIncludingDuplicates() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
        try {
            displaySuccessIfTrue(nl3.sizeIncludingDuplicates() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.toString().equals("[5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.sizeIncludingDuplicates() == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.toString().equals("[8, 10]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
    }    

    private static void contains_tester() {
        System.out.println("Testing contain method...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(1), new Long(2), new Long(3)});

        try {
            displaySuccessIfTrue(nl.contains(new Long(1)) == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.contains(new Long(10000)) == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.contains(new Long(3)) == true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.contains(new Long(4)) == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            nl2.contains("hi");
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }        
        try {
            displaySuccessIfTrue(nl4.contains(1) == false);
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }
        try {
            displaySuccessIfTrue(nl4.contains(new Long(1)) == true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.contains(new Long(2)) == true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.contains(new Long(3)) == true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.contains(new Long(4)) == false);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                    
    }                         

}