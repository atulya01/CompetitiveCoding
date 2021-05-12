public class TestArray {

    public static void main(String[] args) {
        String[][] array = new String[][]{};

        array[0][0] = "a";
        array[0][1] = "b";
        array[0][2] = "c";

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                System.out.println(array[i][j]);
            }
        }
    }
}
