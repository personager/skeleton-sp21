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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int[] nsArray = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = TimeAList.returnNsAList(nsArray);
        AList<Double> times = returnTimesSLList(nsArray);
        AList<Integer> opCount = returnOpCountArray(nsArray);
        printTimingTable(Ns, times, opCount);
    }

    private static AList returnTimesSLList(int[] Ns) {
        AList<Double> times = new AList<>();
        for(int n : Ns) {
            SLList<Integer> testSLList = createSLListOfSizeN(n);
            Stopwatch sw = new Stopwatch();
            for(int i = 0; i < 10000; i += 1) {
                testSLList.getLast();
            }
            times.addLast(sw.elapsedTime());
        }
        return times;
    }

    private static AList returnOpCountArray(int[] nsArray) {
        AList<Integer> opCount = new AList<>();
        for (int i = 0; i < nsArray.length; i += 1) {
            opCount.addLast(10000);
        }
        return opCount;
    }

    private static SLList createSLListOfSizeN(int n) {
        SLList<Integer> nSLList = new SLList<>();
        for(int i = 0; i < n; i += 1) {
            nSLList.addLast(n);
        }
        return nSLList;
    }
}