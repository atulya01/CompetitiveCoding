public class ReverseWordsInString {

    public static void main(String[] args) {
        String inputString = "i.like.this.program.very.much";
        String reversedWords = getReverseWords(inputString);
        System.out.println(reversedWords);
    }

    static String getReverseWords(String input){
        StringBuilder reverseWords = new StringBuilder();
        int endIndex = input.length()-1;
        int startIndex;

        for(int i= endIndex; i >= 0; i--){
            if(input.charAt(i) == '.'){
                startIndex = i;
                String currentWord="";
                if(endIndex == input.length() -1){
                    currentWord = input.substring(startIndex+1);
                }
                else{
                    currentWord = input.substring(startIndex+1, endIndex);
                }
                endIndex = startIndex;
                reverseWords.append(currentWord);
                reverseWords.append(".");
            }
            //reverseWords.append(input.substring(0,endIndex));
        }
        return reverseWords.toString();
    }
}
