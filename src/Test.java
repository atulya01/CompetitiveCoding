import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try{
           int i =8/0;
        }catch(Exception e){
            throw e;
        }
        finally{
            System.out.println("Error occurred ... ");

        }
    }
}

