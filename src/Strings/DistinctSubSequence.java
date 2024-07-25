package Strings;
import java.util.Arrays;
public class DistinctSubSequence {
    public int numDistinct(String s, String t) {
        int x = s.length();
        int y = t.length();
        int[][] table = new int[x + 1][y + 1];

        for (int[] row : table) {
            Arrays.fill(row, -1);
        }

        return dfs(s, t, table, 0, 0);
    }

    public int dfs(String w1, String w2, int[][] table, int i1, int i2) {
        if (i2 >= w2.length()) {
            return 1;
        }

        if (i1 >= w1.length()) {
            return 0;
        }

        if (table[i1][i2] != -1) {
            return table[i1][i2];
        }

        if (w1.charAt(i1) == w2.charAt(i2)) {
            table[i1][i2] = dfs(w1, w2, table, i1 + 1, i2 + 1) + dfs(w1, w2, table, i1 + 1, i2);
            return table[i1][i2];
        }

        table[i1][i2] = dfs(w1, w2, table, i1 + 1, i2);

        return table[i1][i2];
    }

    public static void main(String[] args) {
        DistinctSubSequence ds = new DistinctSubSequence();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(ds.numDistinct(s, t));
    }
}
