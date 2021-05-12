public class PalindromeNumber {

    public static void main(String[] args) {
        int number = 12;
        boolean isNumPalindrome = isPalindrome(number);
        System.out.print(isNumPalindrome);
    }

    static boolean isPalindrome(int number){
        int ogNumber = number;
        int reverseNumber = 0;
        while(number !=0){
            int remainder = number % 10;
            reverseNumber = (reverseNumber * 10) + remainder;
            number = number/10;
        }

        if(reverseNumber == ogNumber){
            return true;
        }
        return false;
    }
}
