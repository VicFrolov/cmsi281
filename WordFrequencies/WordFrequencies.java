import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordFrequencies {

    private static String[] wordFrequencyArray(String s) {
        return s.replaceAll("[-!?,.;:]", "").replaceAll("[^A-Za-z0-9]", " ").toUpperCase().split(" ");
    }

    private static String[] wordFrequencyArrayWithoutUppercase(String s) {
        return s.replaceAll("-", "").replaceAll("[^A-Za-z0-9]", " ").split(" ");
    }

    private static HashMap<String, Integer> turnIntoHashMapAndSet(String[] inputArray) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(inputArray.length);

        for (String s : inputArray) {
            if (s.length() > 0) {
                if (map.get(s) == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, (map.get(s) + 1));
                }
            }
        }
        return map;
    }
    public static String invalidInput() {
        return "This program only allows piping inputs. The only valid commands are:\n '-s'\n '-c'\n '-sc'\n '-cs'\n" +
        "s indicates case sensitive, c indicates a clean output of only keys, and mixing the two does both\n" +
        "Please pipe in a file and enter no commands, or select a valid command from the list above.";
    }

    public static void main(String[] args) {
        String fileInput = "";
        String[] userOptions = new String[]{"-s", "-c", "-sc", "-cs"};
        String userConstraint = "";
        String[] cleanStringArray;
        Scanner scanner = new Scanner(System.in);

        if (args.length > 1) {
            System.out.println(invalidInput());
            return;
        } else if (args.length == 1) {
            userConstraint = args[0];
            boolean match = false;

            for (String s : userOptions) {                
                if (userConstraint.equals(s)) {
                    match = true;
                }
            }
            if(!match) {
                System.out.println(invalidInput());
                return;
            }
        }

        while (scanner.hasNext()) {
            fileInput += scanner.nextLine();
        }

        boolean caseSensitive = userConstraint.equals(userOptions[0]) || userConstraint.equals(userOptions[2]) ||
            userConstraint.equals(userOptions[3]);
        boolean outputClean = userConstraint.equals(userOptions[1]) || userConstraint.equals(userOptions[2]) || 
            userConstraint.equals(userOptions[3]);

        if (args.length == 0 || !caseSensitive) {
            cleanStringArray = wordFrequencyArray(fileInput);
        } else {
            cleanStringArray = wordFrequencyArrayWithoutUppercase(fileInput);          
        } 

        HashMap<String, Integer> mapOfWords = turnIntoHashMapAndSet(cleanStringArray);
        SortedSet<String> keySet = new TreeSet<String>(mapOfWords.keySet());

        for (String key : keySet) {
            System.out.print(String.format("%-10s", key));
            if (!outputClean) {
                System.out.print(" " + String.format("%-10s", mapOfWords.get(key)))  ;
            }
            System.out.println();
        }
        scanner.close();
    }
}




