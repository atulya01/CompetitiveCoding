import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String input = "dabcabcbb";

        int length = findLengthOfLongestSubStr(input);
        System.out.println(length);
    }

    public static int findLengthOfLongestSubStr(String input){
        int firstPointer = 0;
        int secondPointer = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        while(secondPointer < input.length()){
            if(!set.contains(input.charAt(secondPointer))){
                set.add(input.charAt(secondPointer));
                secondPointer++;
                max = Math.max(max, set.size());
            }else{
                set.remove(input.charAt(firstPointer));
                firstPointer++;
            }
        }
        return max;
    }
}
