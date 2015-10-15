import java.util.Arrays;

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
        remove_tester();
        size_tester();
        toArray_tester();
        fromArray_tester();
        equals_tester();
        addAll_tester();
        containsAll_tester();
        removeAll_tester();  
        retainAll_tester();      

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
        NumberList nl3 = new NumberList(new Long[] {new Long(100000)});
        NumberList nl4 = new NumberList(new Long[] {new Long(0)});
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
        try {
            displaySuccessIfTrue(nl.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                          
        try {
            displaySuccessIfTrue(nl3.toString().equals("[100000]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.toString().equals("[0]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                
    }

    private static void adder() {
        System.out.println("Testing add method...");
        NumberList nl = new NumberList();
        NumberList nl10 = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1)});

        nl.add(new Long(2));
        nl3.add(new Long(2));
        nl3.add(new Long(3));
        nl3.add(4);
        nl10.add(nl10);
        nl10.add(nl2); 
        nl4.add(nl4);

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
        try {
            displaySuccessIfTrue(nl2.add(null));
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }
        try {
            displaySuccessIfTrue((nl3.toString()).equals("[1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((nl10.toString()).equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((nl10.toString()).equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((nl4.toString()).equals("[1]"));
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
        NumberList nl5 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(1), new Long(2), new Long(3), 
                            new Long(1), new Long(2), new Long(3),new Long(1), new Long(2), new Long(3)});

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
        try {
            displaySuccessIfTrue(nl5.toString().equals("[1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                        
    }


    private static void clear_tester() {
        System.out.println("Testing clear...");
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

    private static void remove_tester() {
        System.out.println("Testing remove...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(4), new Long(5), new Long(6)});
        NumberList nl5 = new NumberList(new Long[] {new Long(1)});
        NumberList nl6 = new NumberList(new Long[] {new Long(1)});
        NumberList nl7 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(4), new Long(5), new Long(6)});
        NumberList nl8 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3),new Long(4), new Long(5), new Long(6)});


        nl.remove(new Long(1));
        nl2.remove(new Long(1));
        nl3.remove(new Long(1)); 
        nl4.remove(new Long(6));
        nl7.remove(new Long(4));
        nl8.remove(new Long(1));

        try {
            displaySuccessIfTrue((nl.toString()).equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
        try {
            displaySuccessIfTrue(nl4.toString().equals("[1, 2, 3, 4, 5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl5.remove(null));
            displaySuccessIfTrue(false);

        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }  
        try {
            displaySuccessIfTrue(nl6.remove(5));
            displaySuccessIfTrue(false);

        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }
        try {
            displaySuccessIfTrue(nl8.toString().equals("[2, 3, 4, 5, 6]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl8.sizeIncludingDuplicates() == 5);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                        
    }  

    private static void size_tester() {
        System.out.println("Testing size (unique)...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(1),new Long(2), new Long(2), new Long(1)});
        NumberList nl5 = new NumberList(new Long[] {new Long(1), new Long(1), new Long(1), new Long(1), new Long(1), new Long(1)});
        NumberList nl6 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3), new Long(4), new Long(1), new Long(2), new Long(3), new Long(4)});

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
            displaySuccessIfTrue(nl3.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.size() == 2);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl5.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl6.size() == 4);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                        
    }                               
    private static void toArray_tester() {
        System.out.println("Testing toArray...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(1),new Long(2), new Long(2), new Long(1)});
        NumberList nl5 = new NumberList(new Long[] {new Long(1), new Long(1), new Long(1), new Long(1), new Long(1), new Long(1)});
        NumberList nl6 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3), new Long(4), new Long(1), new Long(2), new Long(3), new Long(4)});

        Long[] nlTest = nl.toArray();
        Long[] nl2Test = nl2.toArray();


        try {
            displaySuccessIfTrue(Arrays.deepEquals(nlTest, new Long[]{}));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(Arrays.deepEquals(nl2Test, (new Long[]{new Long(1), new Long(2), new Long(3)})));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
                                
    }       
    private static void addAll_tester() {
        System.out.println("Testing addAll...");
        NumberList nl = new NumberList();
        NumberList nl2 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3)});
        NumberList nl3 = new NumberList(new Long[] {new Long(1)});
        NumberList nl4 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(1),new Long(2), new Long(2), new Long(1)});
        NumberList nl5 = new NumberList(new Long[] {new Long(1), new Long(1), new Long(1), new Long(1), new Long(1), new Long(1)});
        NumberList nl6 = new NumberList(new Long[] {new Long(1), new Long(2), new Long(3), new Long(4), new Long(1), new Long(2), new Long(3), new Long(4)});
        nl2.addAll(nl2);
        nl5.addAll(nl);
        nl6.addAll(nl3);
        nl.addAll(nl);

        try {
            displaySuccessIfTrue(nl.addAll(null));
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }        
        try {
            displaySuccessIfTrue( (nl2.toString()).equals("[1, 2, 3, 1, 2, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue((nl5.toString()).equals("[1, 1, 1, 1, 1, 1]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue( (nl6.toString()).equals("[1, 2, 3, 4, 1, 2, 3, 4, 1]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue( (nl.toString()).equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                
      
    }
    private static void fromArray_tester() {
        System.out.println("Testing fromArray...");

        NumberList nl = NumberList.fromArray(new long[]{1,2,3,4,5});
        NumberList nl2 = NumberList.fromArray(new long[]{1});
        NumberList nl3 = NumberList.fromArray(new long[]{});
        NumberList nl4 = NumberList.fromArray(new long[]{});

        try {
            displaySuccessIfTrue(nl.toString().equals("[1, 2, 3, 4, 5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[1]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                          
    }                  
    private static void equals_tester() {
        System.out.println("Testing equals...");

        NumberList nl = NumberList.fromArray(new long[]{1,2,3,4,5});
        NumberList nl2 = NumberList.fromArray(new long[]{1,2,3,4,5});
        NumberList nl3 = NumberList.fromArray(new long[]{});
        NumberList nl4 = NumberList.fromArray(new long[]{});
        NumberList nl5 = new NumberList();
        nl5.add(new Long(1));
        nl5.add(new Long(2));
        nl5.add(new Long(3));
        nl5.add(new Long(4));
        nl5.remove(new Long(4));
        NumberList nl6 = NumberList.fromArray(new long[]{1,2,3});
        String s = "hi";

        try {
            displaySuccessIfTrue(nl.equals(nl2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.equals(nl4));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(nl3.equals(s)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl5.equals(nl6));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(nl.equals(nl6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                                    
    }  

    private static void containsAll_tester() {
        System.out.println("Testing ContainsAll...");

        NumberList nl = NumberList.fromArray(new long[]{1,2,3,4,5});
        NumberList nl2 = NumberList.fromArray(new long[]{1,2,3,4,5});
        NumberList nl3 = NumberList.fromArray(new long[]{1,2,3,4});
        NumberList nl4 = NumberList.fromArray(new long[]{5});
        NumberList nl5 = NumberList.fromArray(new long[]{1});
        NumberList nl6 = NumberList.fromArray(new long[]{});
        NumberList nll = NumberList.fromArray(new long[]{1,2,3,1, 2, 1, 1, 1, 1, 1, 1, 1, 9});
        NumberList nll2 = NumberList.fromArray(new long[]{1,2,3,1, 2, 1, 1, 1, 1, 1, 1, 1, 1});


        try {
            displaySuccessIfTrue(nl.containsAll(nl));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl.containsAll(nl2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl.containsAll(nl3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl.containsAll(nl4));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl.containsAll(nl5));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(nl5.containsAll(nl3)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(nl6.containsAll(nl)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(nl3.containsAll(nl4)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }    
        try {
            displaySuccessIfTrue(!(nll.containsAll(nl)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nll.containsAll(nll2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl6.containsAll(nl6));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                                                                            
    }

    private static void removeAll_tester() {
        System.out.println("Testing removeAll...");

        NumberList nl = NumberList.fromArray(new long[]{1, 1, 2, 2, 3, 3});
        NumberList nl2 = NumberList.fromArray(new long[]{1,2,3});
        NumberList nl3 = NumberList.fromArray(new long[]{1,2,2,2,2,2,2,2,2,2,2,2,5});
        NumberList nl4 = NumberList.fromArray(new long[]{5});
        NumberList nl5 = NumberList.fromArray(new long[]{1});
        NumberList nl6 = NumberList.fromArray(new long[]{});
        NumberList nll = NumberList.fromArray(new long[]{1,2,3,1, 2, 1, 1, 1, 1, 1, 1, 1, 9});
        NumberList nll2 = NumberList.fromArray(new long[]{1,2,3,1, 2, 1, 1, 1, 1, 1, 1, 1, 1});
        NumberList nl33 = NumberList.fromArray(new long[]{1, 1, 1,2, 2, 2, 3, 3, 3});


        nl.removeAll(nl2);
        nl33.removeAll(nl2);
        nl2.removeAll(nl3);
        nl3.removeAll(nl4);
        nl4.removeAll(nl6);
        nll.removeAll(nll2);

        try {
            displaySuccessIfTrue(nl.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl.removeAll(null));
            displaySuccessIfTrue(false);

        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }
        try {
            displaySuccessIfTrue(nl33.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl3.toString().equals("[1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl4.toString().equals("[5]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nll.toString().equals("[9]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                          
                                                                                          
    }
    private static void retainAll_tester() {
        System.out.println("Testing retainAll...");

        NumberList nl = NumberList.fromArray(new long[]{1, 1, 2, 2, 3, 3});
        NumberList nl2 = NumberList.fromArray(new long[]{1,2,3});
        NumberList nl3 = NumberList.fromArray(new long[]{1,1,1,1,9,8,7,6,5,4,3,10});
        NumberList nl4 = NumberList.fromArray(new long[]{5});
        NumberList nl5 = NumberList.fromArray(new long[]{1});
        NumberList nl6 = NumberList.fromArray(new long[]{9});
        NumberList nll = NumberList.fromArray(new long[]{1,2,3,1, 2, 1, 1, 1, 1, 1, 1, 1, 9});
        NumberList nll2 = NumberList.fromArray(new long[]{1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17});
        NumberList nl33 = NumberList.fromArray(new long[]{1, 1, 1,2, 2, 2, 3, 3, 3});
        NumberList nla = NumberList.fromArray(new long[]{});
        NumberList nlld = NumberList.fromArray(new long[]{1,9});


        nl.retainAll(nl2);

        nl33.retainAll(nl2);
        nl2.retainAll(nl3);


        nl3.retainAll(nl4);
        nll2.retainAll(nl6);
        nla.retainAll(nl33);
        nll.retainAll(nlld);

        try {
            displaySuccessIfTrue(nl.toString().equals("[1, 1, 2, 2, 3, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl2.toString().equals("[1, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nl33.toString().equals("[1, 1, 1, 2, 2, 2, 3, 3, 3]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nll2.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nla.toString().equals("[]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nla.sizeIncludingDuplicates() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                                
        try {
            displaySuccessIfTrue(nl33.sizeIncludingDuplicates() == 9);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(nll.toString().equals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 9]"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }          
                                                                                          
    }               

}