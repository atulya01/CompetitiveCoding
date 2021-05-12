public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,3,5,5,6};
        removeDuplicates(array);
    }

    static void removeDuplicates(int[] array){
        for(int i= 0, j= 1; i<array.length && j<array.length;){
            if(array[i] != array[j] && array[i] < array[j]){
                i++;
                j++;

            }else{

            }
        }
        System.out.print(array);
    }
}
