import java.util.ArrayList;
import java.util.List;

/**
 * This is a simple duplication detector
 * The key point is to see how runtime will be affected as sample size goes up
 */

public class Dup{
    public static boolean dup_naive(int[] target){
        for (int i = 0; i < target.length; i++){
            for (int j = i + 1; j < target.length; j ++){
                if (target[i] == target[j]){return true;}
            }
        }
        return false;
    }



    /** 
     * This method requires that the array is sorted
     * Otherwise will yield wrong answer
    */
    public static boolean dup_smart(int[] target){
        for (int i = 0; i < (target.length - 1); i ++){
            if (target[i] == target[i + 1]){return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}