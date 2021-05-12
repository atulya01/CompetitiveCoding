public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {};
        int target = 6;
        int start = 0;
        int end = arr.length - 1; //6
        int targetIndex = binarySearch(arr, start, end, target);
        System.out.println(targetIndex);
    }

    public static int binarySearch(int[] arr, int start, int end, int target){
        int mid = (start + end)/2;
        while(end >= start){
            int midElement = arr[mid];
            if(midElement == target){
                return mid;
            }
            if(midElement < target){
                return binarySearch(arr, mid+1, end, target);
            }
            if(midElement > target){
                return binarySearch(arr, start, mid-1, target);
            }
        }
        return -1;
    }
}
