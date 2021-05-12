public class MaxWaterBetweenLogs {

    public static void main(String[] args) {
        int[] array = {0,2,4,1,9};

        //int masWaterUnits = findMaxWaterTrappedBruteForce(array);
        int masWaterUnits = findMaxWaterTrapped(array);
        System.out.println(masWaterUnits);
    }

    public static int findMaxWaterTrappedBruteForce(int[] array){
        int maxUnits = 0;
        for(int i=0; i<array.length; i++) {
            for (int j=array.length -1; j >= i; j--) {
                int indexDiff = j - i;
                int valDiff = Math.min(array[i], array[j]);
                maxUnits = Math.max((valDiff * indexDiff), maxUnits);
            }
        }
        return maxUnits;
    }

    public static int findMaxWaterTrapped(int[] array) {
       int maxArea =0;
       int left =0;
       int right = array.length -1;

       while(left < right){
           maxArea = Math.max(maxArea,
                   (Math.min(array[left], array[right]) * (right - left)));

           if(array[left] > array[right]){
               right --;
           }else{
               left ++;
           }
       }

       return maxArea;
    }
}
