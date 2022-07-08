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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int[] nsArray = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 10000000};
        AList<Integer> Ns = returnNsAList(nsArray);
        AList<Double> times = returnTimesAList(nsArray);
        AList<Integer> opCount = returnOpCountArray(Ns);
        printTimingTable(Ns, times, opCount);
    }

    public static AList returnNsAList(int[] nsArray) {
        AList<Integer> Ns = new AList<>();
        for(int n : nsArray) {
            Ns.addLast(n);
        }
        return Ns;
    }

    private static AList returnTimesAList(int[] Ns) {
        AList<Double> times = new AList();
        for(int n : Ns) {
            AList<Integer> testArray = new AList();
            Stopwatch sw = new Stopwatch();
            for(int i = 0; i < n; i += 1) {
                testArray.addLast(1);
            }
            times.addLast(sw.elapsedTime());
        }
        return times;
    }

    private static AList returnOpCountArray(AList Ns) {
        return Ns;
    }
}
