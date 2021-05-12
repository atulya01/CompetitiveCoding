import java.util.ArrayList;
import java.util.List;

public class BinaryString {

    public static void main(String[] args) {
        int n = 3;
        int i = 0;
        int[] arr =new int[n];
        getAllBinaryStrings(n,i, arr);
    }

    public static void printArray(int[] arr){
        for(Integer val: arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void getAllBinaryStrings(int lengthOfString, int index, int[] arr){
        if(index == lengthOfString){
            printArray(arr);
            return;
        }

        arr[index] = 0;
        getAllBinaryStrings(lengthOfString, index +1, arr);
        arr[index] = 1;
        getAllBinaryStrings(lengthOfString, index+1, arr);

    }
}
