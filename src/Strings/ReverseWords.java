package Strings;

import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] arr=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        Stack<String> st=new Stack<String>();
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();
        String s = "  hello world  ";
        System.out.println(obj.reverseWords(s));
    }
}
