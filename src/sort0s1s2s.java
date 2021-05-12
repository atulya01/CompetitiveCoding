public class sort0s1s2s {

    public static void main(String[] args) {
        int[] array = {1,0,2,2,1,0,0};
        int[] sortedArray = sortArray(array);
        int[] sortedArray2 = sortArrayExtraSpace(array);
    }

    static int[] sortArrayExtraSpace(int[] array){
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for(int element: array){
            if(element == 0){
                zeroCount++;
            }else if(element == 1){
                oneCount++;
            }else{
                twoCount++;
            }
        }

        int i = 0;
        while(i < array.length){
            switch(array[i]) {
                case 0:
                    zeroCount++;
                    break;

                case 1:
                    oneCount++;
                    break;

                    case 2:
                        twoCount++;
                        break;

            }
            while(zeroCount > 0){
                array[i] = 0;
                zeroCount--; i++;
            }
            while(oneCount > 0){
                array[i] = 1;
                oneCount--; i++;
            }
            while(twoCount > 0){
                array[i] = 2;
                twoCount--; i++;
            }
        }
        return array;
    }

    static int[] sortArray(int[] array){
        int low = 0;
        int mid = 0;
        int high = array.length -1;
        int temp;
        while(mid <= high) {
            switch (array[mid]) {
                case (0):
                    temp = array[low];
                    array[low] = array[mid];
                    array[mid] = temp;
                    low++;
                    mid++;
                    break;
                case (1):
                    mid++;
                    break;
                case (2):
                    temp = array[mid];
                    array[mid] = array[high];
                    array[high] = temp;
                    high--;
                    break;
            }
        }

        return array;
    }
}

/*1,0,2,2,1,0,0
0 1 2 2 1 0 0
0 1 0 2 1 0 2
0 1 0 0 1 2 2
0 0 1 0 1 2 2
0 0 0 1 1 2 2*/
