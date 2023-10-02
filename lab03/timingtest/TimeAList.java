package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction(nsizes, runtimes);
        printTimingTable(nsizes, runtimes, nsizes);
    }

    public static void timeAListConstruction(AList<Integer> nsizes, AList<Double> runtimes) {
        int[] testrange = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 2000000};

        for (int i = 0; i < testrange.length; i++){
            AList<Integer> a = new AList<Integer>();
            nsizes.addLast(testrange[i]);
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < testrange[i]; j ++){
                a.addLast(j);
            }
            double timeinsecond = sw.elapsedTime();
            runtimes.addLast(timeinsecond);
        }

    }
}
