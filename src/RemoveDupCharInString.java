import java.util.Stack;

public class RemoveDupCharInString {

    public static void main(String[] args) {
        String str = "aaaaabbbbbecc";
        String result = removeDuplicates(str);
        System.out.println(result);

    }

    public static String removeDuplicates(String str){
        int i=0;
        Stack stack = new Stack<Character>();

        while(i < str.length()){
            Character currChar = str.charAt(i);

            if(!stack.empty() && currChar==stack.peek()){
                while((i+1) < str.length() && currChar == str.charAt(i+1)){
                    i++;
                }
                stack.pop();
            }
           else if(!stack.empty() && currChar != stack.peek()){
                stack.push(currChar);
            }
            else {
                stack.push(currChar);
            }
            i++;
        }

        char[] resultArr = new char[stack.size()];
        int j= resultArr.length -1;
        while(!stack.isEmpty()){
          resultArr[j] = (char) stack.pop();
          j--;
        }

        System.out.println(resultArr);
        return String.valueOf(resultArr);
    }
}
