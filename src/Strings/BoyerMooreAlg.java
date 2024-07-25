package Strings;

public class BoyerMooreAlg {
    public static void  main(String[] args) {
        String text = "hello";
        String pattern = "ll";
        System.out.println(boyerMoore(text, pattern));
    }

    public static int boyerMoore(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }

        if (pattern.length() == 0) {
            return 0;
        }

        if (text.length() < pattern.length()) {
            return -1;
        }

        int[] last = buildLast(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = m - 1;
        int j = m - 1;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    return i;
                }

                i--;
                j--;
            } else {
                i += m - Math.min(j, 1 + last[text.charAt(i)]);
                j = m - 1;
            }
        }

        return -1;
    }

    private static int[] buildLast(String pattern) {
        int[] last = new int[128];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }

        return last;
    }

}
