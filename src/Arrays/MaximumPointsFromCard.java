package Arrays;

public class MaximumPointsFromCard {
    public static int maxScore(int[] cp, int k) {
        int totalSum = 0;
        for (int num : cp) {
            totalSum += num;
        }

        if (k == cp.length) {
            return totalSum;
        }

        int windowSize = cp.length - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cp[i];
        }

        int minSum = windowSum;

        for (int i = windowSize; i < cp.length; i++) {
            windowSum += cp[i];
            windowSum -= cp[i - windowSize];
            minSum = Math.min(minSum, windowSum);
        }

        return totalSum - minSum;
    }

    public static void main(String[] args) {
        int[] cp = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cp, k));
    }
}
