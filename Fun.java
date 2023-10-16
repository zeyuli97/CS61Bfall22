import java.util.Arrays;
import java.util.Random;
/** This is a collection of fun things I found when run java code
     will keep update this file while learning about java*/


// Static variables is for whole class, on the other hand, non-static is only callable for sepcific instance.

// Staic method is more restricted due to that it cannot call non-static variables which makes sense.

// Non-static method can call both static and non_static variables.

// Class calls a non-static method will yield a error. Instance calls static will run but bad style.

// Please note just like python, if a instance modified a static variable all the other instance will be affected.

// This is like self, refer to current instance of object.


public class Fun{

    public static void main(String[] args){
            // this is a sick test about fun in array
        int[] test1 = new int[]{1,2,3,4,5,6,7};

        for (int x:test1){
            x = x*2;
            System.out.println(x);
        }

        // From the output we see that x only takes a copy of array element. Nothing is affect in the original array.
        System.out.println(Arrays.toString(test1));

        // The purpose of below example is that, java using == to test int as reference type as list, can use touble.
        Random rand = new Random();
        int n1 = rand.nextInt(10000);
        n2 = n1;
        System.out.println(n2 == n1);

            



    }

}


