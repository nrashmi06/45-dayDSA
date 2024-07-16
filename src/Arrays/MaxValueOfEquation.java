package Arrays;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxValueOfEquation {

    // Simple Pair class definition
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                return a.getKey().equals(b.getKey()) ? a.getValue() - b.getValue() : b.getKey() - a.getKey();
            }
        });

        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek().getValue() > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res = Math.max(res, pq.peek().getKey() + point[0] + point[1]);
            }
            pq.offer(new Pair<>(point[1] - point[0], point[0]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int k = 1;
        System.out.println(findMaxValueOfEquation(points, k)); // Output the result
    }
}
