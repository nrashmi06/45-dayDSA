package Strings;

public class BasicCalc2 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int result = 0;
        int prev = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    result += prev;
                    prev = num;
                } else if (op == '-') {
                    result += prev;
                    prev = -num;
                } else if (op == '*') {
                    prev = prev * num;
                } else if (op == '/') {
                    prev = prev / num;
                }

                op = c;
                num = 0;
            }
        }

        result += prev;
        return result;
    }
}
