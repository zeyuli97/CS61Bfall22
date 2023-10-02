package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class StopwatchDemo {
    /** Computes the nth Fibonacci number using a slow naive recursive strategy.*/
    private static long fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        long fib50 = fib(50);
        double timeInSeconds = sw.elapsedTime();
        System.out.println("The 50th fibonacci number is " + fib50);
        System.out.println("Time taken to compute 50th fibonacci number: " + timeInSeconds + " seconds.");
    }
}
