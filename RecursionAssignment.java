import java.util.Scanner;

public class RecursionAssignment{

/* 
- addDigits that takes an int as an argument and returns the sum of the digits in the argument.
You may assume that the number provided is positive. For example, 12345 result in the
computation 1 + 2 + 3 + 4 + 5 = 15. Do not use the classes Math, String or StringBuilder in your
solution 
*/ 
    public static int addDigits(int digit){
        if (digit >= 0){

        }
        return digit;
    }

/* - sumEvenNumbers that takes one int as an argument. Calculate the sum of the numbers
between 0 and the argument (inclusive) which are even. For example, sumEvenNumbers(16)
should return 0 + 2 + 4 + 6 + 8 + 10 + 12 + 14 + 16. Remember: if a number x is even, then x % 2
is zero. Your computation should explicitly add the required numbers together, do not use
another mathematical formula to compute this number. (And, of course, this should be done
recursively.) 
*/

    public int sumEvenNumbers(int evenNumber){
  
        return evenNumber;
    }

/*
- countVowels that takes a String as arguments and returns, as an int, the number of vowels in
the String. For example, when passing “Mississippi” to countVowels the method should return 4
 */
    public int countVowels(String phrase){
        int noOfVowels = 0;
        return noOfVowels; //must be changed
    }

/*         For simplicity: assume that the letter ‘y’ is never a vowel
- removeVowels that takes on String as an argument and returns the same string but with the
vowels removed. For simplicity: assume that the letter ‘y’ is never a vowel. For example,
removeVowels(“HelloYou”) should return “HllY”.*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a digit 0 or greater: ");
        System.out.println(addDigits(sc.nextInt()));




        sc.close();
    }
        

}