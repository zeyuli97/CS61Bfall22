package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    public static void simpletest(){
        AListNoResizing<Integer> a = new AListNoResizing<Integer>();
        BuggyAList<Integer> b = new BuggyAList<>();
        for (int i = 1; i < 4; i++){
            a.addLast(i);
            b.addLast(i);
        }
        System.out.println(a.removeLast());
        System.out.println(b.removeLast());
        System.out.println(a.removeLast());
        System.out.println(b.removeLast());
        System.out.println(a.removeLast());
        System.out.println(b.removeLast());
    }

    public static void randomizedTest_buggy(){
        BuggyAList<Integer> L = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
        }
    }
    @Test
    public static void randomizedTest_noresize(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;

        for (int i = 0; i < N; i += 1) {
            if (L.size() == 0) {
                int operationNumber = StdRandom.uniform(0, 2);
                if (operationNumber == 0) {
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    B.addLast(randVal);
                    System.out.println("addLast(" + randVal + ")");
                } else if (operationNumber == 1) {
                    // size
                    int size_L = L.size();
                    int size_B = B.size();
                    assertEquals(size_L,size_B);
                }
            }else{
                int operationNumber = StdRandom.uniform(0,4);
                if (operationNumber == 0) {
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    B.addLast(randVal);
                    System.out.println("addLast(" + randVal + ")");
                } else if (operationNumber == 1) {
                    // size
                    int size_L = L.size();
                    int size_B = B.size();
                    assertEquals(size_L,size_B);
                } else if (operationNumber == 2) {
                    assertEquals(L.getLast(), B.getLast());
                }else {
                    assertEquals(L.removeLast(), B.removeLast());
                }
            }
        }
    }

    public static void main(String[] args) {
        randomizedTest_noresize();
        // randomizedTest_buggy();

    }
}
