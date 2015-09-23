public class BaseConverter {
    
    public static boolean validArgs ( String[] args ) {
        boolean isValidArgs = true;
        int count = 0;
        String toTest = args[0];
        int[] toTestNumberValue;
        char c = toTest.charAt(0);


        // checking to see if conversions are occuring from or to base 1, or if bases are not specified
        if (args.length < 2) {
            isValidArgs = false;
        } else if (1 == Integer.parseInt(args[1])) {
            isValidArgs = false;
        } else if (args.length == 3) {
            if (1 == Integer.parseInt(args[2])) {
                isValidArgs = false;
            }
        }

        int stringLength = toTest.length();

        while(stringLength > 0) {
            c = toTest.charAt(0);
            
            if (c == '[' && count == 0 && toTest.length() != 1) {
                if (toTest.charAt(1) == '[') {
                    isValidArgs = false;
                    break;
                }
                toTest = toTest.substring(1);
            } else if (c == ']' && count == 0) {
                isValidArgs = false;
                break;
            } else if ((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') 
                || (c == '5') || (c == '6') || (c == '7') || (c == '8') || (c == '9')) {
                    count++;
                    stringLength--;
                    toTest = toTest.substring(1);
            } else if (c == ']' && count > 0) {
                count = 0;
                if (toTest.length() == 1) {
                    break;
                } else {
                    toTest = toTest.substring(1);
                }
            } else {
                isValidArgs = false;
                break;
            }
        }


        //Checking sure that each input is not larger than the base that is being converted

        if (isValidArgs == true) {
            String replaceBracketsWithSpaces = args[0].replaceAll("\\[", "").replaceAll("\\]"," ");;
            String[] stringArrayOfDigits= replaceBracketsWithSpaces.split(" ");

            for (int i = 0; i < stringArrayOfDigits.length; i++) {
                if (Integer.parseInt(stringArrayOfDigits[i]) >= Integer.parseInt(args[1])) {
                    isValidArgs = false;
                }
            }
        }

        return isValidArgs;
    }
    

    public static long conversionToDecimal(int[] numberToConvert, int base) {
        long decimalValueSoFar = 0;
        
        for (int i = 0; i < numberToConvert.length; i++) {
            decimalValueSoFar += numberToConvert[i] * Math.pow(base, i);
        }

        return decimalValueSoFar;
    }

    public static String conversionFromDecimal(long numberToConvert, int base) {
        String newValue = "";
        long[] arrayOfValues;
        int arrayLength = 0;
        long numCalc = numberToConvert;

        if (numberToConvert == 0) {
            return "[0]";
        } else {

            // this loop determines the length of array needed
            while (numCalc > 0) {
                numCalc = (numCalc / base);
                arrayLength++;
            }

            arrayOfValues = new long[arrayLength];

            // this loop creates an array of digits
            int x = 0;
            while (numberToConvert > 0) {
                arrayOfValues[x] = (numberToConvert % base);
                numberToConvert = (numberToConvert / base);
                x++;
            }

            for (int i = arrayOfValues.length -1; i >=0; i--) {
                newValue += "[" + Long.toString(arrayOfValues[i]) + "]";
            }

            return newValue.trim();
        }
    }    
    
    public static void main ( String[] args ) {
        int[] dataToConvert;
        int baseFrom = 0;
        int baseTo = 10;
        
        if ( !validArgs(args) ) {
            throw new IllegalArgumentException();
        } else {

            if (args.length % 3 == 0) {
                baseFrom = Integer.parseInt(args[args.length -2]);
                baseTo = Integer.parseInt(args[args.length - 1]);
            } else {
                baseFrom = Integer.parseInt(args[args.length - 1]);

            }

            int arrayLength = 0;
            for (int i = 0; i < args[0].length(); i++) {
                if (args[0].charAt(i) == '[') {
                    arrayLength += 1;
                }
            } 

            dataToConvert = new int[arrayLength];

            String replaceBracketsWithSpaces = args[0].replaceAll("\\[", "").replaceAll("\\]"," ");;
            String[] stringArrayOfDigits= replaceBracketsWithSpaces.split(" ");

            int indexPosition = 0;

            for (int i = stringArrayOfDigits.length - 1; i >= 0; i--) {
                dataToConvert[indexPosition] = Integer.parseInt(stringArrayOfDigits[i]);
                indexPosition++;
            }

            System.out.println(conversionFromDecimal( conversionToDecimal(dataToConvert, baseFrom), baseTo));
        }
    }

}