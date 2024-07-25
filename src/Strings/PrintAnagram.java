package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
public class PrintAnagram {
    public List<List<String>> Anagrams(String[] words) {
        // Code here\
        HashMap<String , List<String>> map = new HashMap<>();

        for(String word : words){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String w = new String(arr);

            if(!map.containsKey(w)){
                map.put(w,new ArrayList<>());
            }
            map.get(w).add(word);
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> group : map.values()){
            result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {
        PrintAnagram pa = new PrintAnagram();
        String[] words = {"cat", "dog", "tac", "god", "act"};
        System.out.println(pa.Anagrams(words));
    }

}
