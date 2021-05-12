public class StringToInteger {

    public static void main(String[] args) {
       /* int max_val = Integer.MAX_VALUE; //2147483647
        int min_val = Integer.MIN_VALUE; //-2147483648
        System.out.println(max_val + " min value" + min_val);*/
        String inputString = "21474836460";
        //Integer outputNum = convertStringToInteger(inputString);
        Integer outputNum = convertStringToIntegerMod(inputString);
        System.out.println(outputNum);
    }

    public static boolean checkIntOutOfRange(String inputString, boolean isNegativeNum, int startIndex){
        String integerLimitValStr = isNegativeNum ? String.valueOf(Integer.MIN_VALUE) : String.valueOf(Integer.MAX_VALUE);
        int integerLimitValStrLength = integerLimitValStr.length();
        int strLength = inputString.length();

        if(strLength < integerLimitValStrLength){
            return false;
        }
        if(strLength > integerLimitValStrLength){
            return true;
        }
        if(strLength == integerLimitValStrLength){
            for(int i=startIndex; i<inputString.length(); i++){
                if(inputString.charAt(i) > integerLimitValStr.charAt(i)){
                    return true;
                }else if(inputString.charAt(i) == integerLimitValStr.charAt(i)){
                    continue;
                }
            }
        }
        return false;
    }

    public static Integer convertStringToInteger(String inputString){
        Integer resultNum = 0;
        boolean isNegativeNum = false;
        int strLength = inputString.length();
        char firstCh = inputString.charAt(0);
        int startIndex = 0;

        if(firstCh == '-'){
            isNegativeNum = true;
            startIndex = 1;
        }

        boolean isOutOfIntBounds = checkIntOutOfRange(inputString, isNegativeNum, startIndex);

        if(!isOutOfIntBounds) {
            for (int i = startIndex; i < inputString.length(); i++) {
                Character ch = inputString.charAt(i);

                if (ch >= '0' && ch <= '9') {
                    resultNum = (resultNum * 10) + (ch - '0');
                }
            }
            return isNegativeNum ? (resultNum * -1) : resultNum;
        }
        else{
            System.out.println("Out of Integer Range");
            return Integer.MAX_VALUE;
        }
    }

    public static Integer convertStringToIntegerMod(String inputString){
        Integer resultNum = 0;
        boolean isNegativeNum = false;
        int strLength = inputString.length();
        char firstCh = inputString.charAt(0);
        int startIndex = 0;
        boolean isConversionPossible = false;


        if(firstCh == '-'){
            isNegativeNum = true;
            startIndex = 1;
        }

        //boolean isOutOfIntBounds = checkIntOutOfRange(inputString, isNegativeNum, startIndex);

            for (int i = startIndex; i < inputString.length(); i++) {
                Character ch = inputString.charAt(i);

                if (ch >= '0' && ch <= '9') {
                    int currentInt = (ch - '0');
                    if(!isNegativeNum){
                        int checkVauleWith = Integer.MAX_VALUE - currentInt;
                        int firstVal = (resultNum*10);
                        isConversionPossible = firstVal <= checkVauleWith;
                    }
                    if(isConversionPossible)
                        resultNum = (resultNum * 10) + currentInt;
                    else
                        return Integer.MAX_VALUE;
                }
            }
            return isNegativeNum ? (resultNum * -1) : resultNum;

    }



}
