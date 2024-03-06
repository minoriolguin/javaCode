public class RecursionAssignment{

    // takes int digit as argument, adds the individual digits of digit
    public static int addDigits(int digit){
        if (digit == 0) return 0;
        return digit%10 + addDigits(digit/10);
    }

    // sums all the even numbers including the number entered
    public static int sumEvenNumbers(int number) {
        if (number == 0) return 0;
        else if (number % 2 != 0) return sumEvenNumbers(number-1);
        else {
            return number + sumEvenNumbers(number - 2);
        }
    }

    // counts number of vowels in a string, returns number of vowels, not including 'y'
    public static int countVowels(String inputString){
        String string = inputString.toLowerCase();
        if (string.length() == 0) return 0;
        if (string.charAt(0) == 'a' || string.charAt(0) == 'e' || string.charAt(0) == 'i'
            || string.charAt(0) == 'o' || string.charAt(0) == 'u') {
            return 1 + countVowels(string.substring(1));
            }
        return countVowels(string.substring(1));
    }

    //takes a string as input and returns the string without vowels, with 'y' not being counted as a vowel
    public static String removeVowels(String string) {
        if (string.length() == 0) return "";
        if (string.charAt(0) == 'a' || string.charAt(0) == 'e' || string.charAt(0) == 'i'
            || string.charAt(0) == 'o' || string.charAt(0) == 'u' || string.charAt(0) == 'A' 
            || string.charAt(0) == 'E' || string.charAt(0) == 'I' || string.charAt(0) == 'O' 
            || string.charAt(0) == 'U') {

            return removeVowels(string.substring(1));
            }
        else {
            String newString = "" + string.charAt(0);
            return newString + removeVowels(string.substring(1));
        }
    }

    public static void main(String[] args) {

        int digit = 123456;
        System.out.println("\nAdding digits using recursion " + digit + ": " + addDigits(digit));

        int number = 12;
        System.out.println("\nThe sum of all even numbers up to and including " + number + " is:  " + sumEvenNumbers(number));
        
        String string = "Hello Everyone";
        System.out.println("\nCounting the vowels in the string '" + string + "': " + countVowels(string));

        String string2 = "This string will have no vowels";
        System.out.println("\nRemoving the vowels from the string, '" + string2 + "'\n\nNew string without vowels: " + removeVowels(string2) + "\n");

    }
}