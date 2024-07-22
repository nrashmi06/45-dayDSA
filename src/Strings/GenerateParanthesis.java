package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    List<String> result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(0 , 0 , "" ,n);
        return result;

    }
    private void backtrack(int l , int r ,String s , int n){
        if(s.length() == 2*n){
            result.add(s);
            return;
        }
        if(l < n){
            backtrack(l+1, r , s + "(" , n);
        }
        if(r < l ){
            backtrack(l, r+1 , s +")" , n);
        }
    }
    public static void main(String[] args) {
        GenerateParanthesis obj = new GenerateParanthesis();
        System.out.println(obj.generateParenthesis(3));
    }
}
