package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public static  long findMinDiff (ArrayList<Integer> a, int n, int m)
    {

        Collections.sort(a);

        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i <= n - m; i++) {
            long diff = a.get(i + m - 1) - a.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(9);
        a.add(56);
        a.add(7);
        a.add(9);
        a.add(12);
        int n = 8;
        int m = 5;
        System.out.println(findMinDiff(a, n, m));
    }
}
