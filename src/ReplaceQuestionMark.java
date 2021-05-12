import java.util.HashSet;

public class ReplaceQuestionMark {

    public static void main(String[] args) {
        String inputStr = "0?1?";
        int i =0;
       // int[] unknownIndexes = getUnknownIndexes(inputStr);
        HashSet<Integer> unknownIndexes = getUnknownIndexes(inputStr);

        generatePossibleBinaryString(inputStr.toCharArray(), i, unknownIndexes);
    }


    public static HashSet getUnknownIndexes(String input){
       HashSet<Integer> hashSet = new HashSet<>();
       for(int i=0; i< input.length(); i++) {
           if(input.charAt(i) == '?') {
              hashSet.add(i);
           }
       }
        return hashSet;
    }

    public static void printArray(char[] arr){
        for(Character val: arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void generatePossibleBinaryString(char[] chArray, int index, HashSet unknownIndexes){
        if(index >= chArray.length){
            printArray(chArray);
            return;
        }
        if(unknownIndexes.contains(index)){
            chArray[index] = '0';
            generatePossibleBinaryString(chArray, index+1, unknownIndexes);
            chArray[index] = '1';
            generatePossibleBinaryString(chArray, index+1, unknownIndexes);
        }else {
            generatePossibleBinaryString(chArray, index + 1, unknownIndexes);
        }
    }
}
