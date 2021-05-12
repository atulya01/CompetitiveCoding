public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {};
        int target = 8;
        int start = 0;
        int end = arr.length - 1;

        System.out.println(binarySearch(arr, start, end, target));
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {

        if(start >= end){
            return -1;
        }

        int mid = (start+end)/2;
        if(target == arr[mid]){
            return mid;
        }

        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target <= arr[mid]){
                return binarySearch(arr, start, mid-1, target);
            }else{
                return binarySearch(arr, mid+1, end, target);
            }
        }else{
            if(target >= arr[mid+1] && target <= arr[end]) {
                return binarySearch(arr, mid + 1, end, target);
            }else{
                return binarySearch(arr, start, mid -1, target);
            }
        }
    }
}
