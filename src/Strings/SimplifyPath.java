package Strings;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        for (String dir : directories) {
            if (dir.equals(".") || dir.isEmpty()) continue;
            else if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(dir);
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        String path = "/a/./b/../../c/";
        System.out.println(obj.simplifyPath(path));
    }
}
