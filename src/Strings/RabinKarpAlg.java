package Strings;

public class RabinKarpAlg {
    public static void main(String[] args) {
        String text = "hello";
        String pattern = "ll";
        System.out.println(rabinKarp(text, pattern));
    }

    public static int rabinKarp(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }

        if (pattern.length() == 0) {
            return 0;
        }

        if (text.length() < pattern.length()) {
            return -1;
        }

        int base = 26;
        int textHash = 0;
        int patternHash = 0;
        int power = 1;

        for (int i = 0; i < pattern.length(); i++) {
            power = i > 0 ? power * base : 1;
            textHash = textHash * base + text.charAt(i);
            patternHash = patternHash * base + pattern.charAt(i);
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (textHash == patternHash && text.substring(i - pattern.length(), i).equals(pattern)) {
                return i - pattern.length();
            }

            textHash -= text.charAt(i - pattern.length()) * power;
            textHash = textHash * base + text.charAt(i);
        }

        if (textHash == patternHash && text.substring(text.length() - pattern.length()).equals(pattern)) {
            return text.length() - pattern.length();
        }

        return -1;
    }
}
