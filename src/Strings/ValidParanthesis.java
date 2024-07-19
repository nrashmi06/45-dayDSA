package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {

        var map = new HashMap<Character,Character>();

        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(map.get(c));
            }

            else if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("()"));
        System.out.println(validParanthesis.isValid("()[]{}"));
        System.out.println(validParanthesis.isValid("(]"));
        System.out.println(validParanthesis.isValid("([)]"));
        System.out.println(validParanthesis.isValid("{[]}"));
    }
}
