import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencies {

    private static String[] wordFrequencyArray(String s) {
        return s.replaceAll("-", "").replaceAll("[^A-Za-z0-9]", " ").toUpperCase().split(" ");
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
        return "Please either only pipe in a file, or use '-s', '-c' or a mix of them with only one hyphen";
    }

    public static void main(String[] args) {
        String fileInput = "";
        String[] userOptions = new String[]{"-s", "-c", "-sc", "-cs"};
        boolean caseSensitive = false;
        String userConstraint = "";
        String[] cleanStringArray;
        Scanner scanner = new Scanner(System.in);

        if (args.length > 1) {
            System.out.println(invalidInput());
            return;
        } else {
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

        caseSensitive = userConstraint.equals(userOptions[0]) || userConstraint.equals(userOptions[2]) ||
                userConstraint.equals(userOptions[3]);
        

        if (args.length == 0 || !caseSensitive) {
            cleanStringArray = wordFrequencyArray(fileInput);
        } else {
            cleanStringArray = wordFrequencyArrayWithoutUppercase(fileInput);          
        } 

        HashMap mapOfWords = turnIntoHashMapAndSet(cleanStringArray);

        System.out.println(mapOfWords.keySet());

        scanner.close();
    }
}




