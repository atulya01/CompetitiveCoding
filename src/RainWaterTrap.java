public class RainWaterTrap {

    public static void main(String[] args) {
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(findTrappedWaterUnits(array));
    }

    public static int findTrappedWaterUnits(int[] array){
        int totalWaterUnits = 0;
        int leftMax = array[0];
        int rightMax = array[array.length-1];
        int i = 1;
        int j = array.length - 2;

        while(i <= j){

            if(leftMax<=rightMax){
                int curr = array[i];
                if(curr>=leftMax){
                    leftMax = curr;
                }else{
                    totalWaterUnits = totalWaterUnits + (leftMax - curr);
                }
                i++;
            }else{
                int curr = array[j];
                if(curr>=rightMax){
                    rightMax= curr;
                }else{
                    totalWaterUnits = totalWaterUnits + (rightMax - curr);
                }
                j--;
            }
        }
        return totalWaterUnits;
    }


}
