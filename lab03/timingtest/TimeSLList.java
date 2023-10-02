package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        AList<Integer> nsizes = new AList<Integer>();
        AList<Double> runtimes = new AList<Double>();
        AList<Integer> opcounts = new AList<Integer>();
        timeGetLast(nsizes, runtimes, opcounts);
        printTimingTable(nsizes, runtimes, opcounts);
    }

    public static void timeGetLast(AList<Integer> nsizes, AList<Double> runtimes, AList<Integer> opcounts) {
        int m = 10000;
        int[] sizes = new int[]{1000,2000,4000,8000,16000,32000,64000,128000};
        for (int x : sizes){
            nsizes.addLast(x);
            SLList<Integer> s = new SLList<Integer>();
            for (int i = 0; i < x; i ++){
                s.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < m; j++){
                s.getLast();
            }

            double timeinsecond = sw.elapsedTime();;
            runtimes.addLast(timeinsecond);
            opcounts.addLast(m);
        }

    }

}
