public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.println("Testing");
        int binaryNum = 1010;
        int decimalNum = binaryToDecimal(binaryNum);
        System.out.print(decimalNum);
    }

    public static int binaryToDecimal(int binaryNum){
        int exponent = 0;
        Double decimalNum = new Double(0);
        while(binaryNum > 0){
            int currentVal = binaryNum % 10;
            decimalNum = decimalNum + (currentVal * (Math.pow(2, exponent)));
            exponent++;
            binaryNum = binaryNum / 10;
        }
        return decimalNum.intValue();
    }
}
