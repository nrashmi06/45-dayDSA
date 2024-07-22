package Strings;

import java.util.HashMap;

public class SmallestWindow {
    public static String smallestWindow(String s, String p)
    {
        if(s.length() < p.length())return "-1";

        HashMap<Character , Integer> pfreq = new HashMap<>();
        for(char c : p.toCharArray()){
            pfreq.put(c,pfreq.getOrDefault(c,0) + 1);
        }

        int start = 0 , minlen = Integer.MAX_VALUE,matched = 0 ;

        int winst = 0 ;

        HashMap<Character , Integer> sfreq = new HashMap<>();

        for(int end = 0 ; end < s.length() ; end++){
            char c = s.charAt(end);

            sfreq.put(c,sfreq.getOrDefault(c,0)+1);

            if(pfreq.containsKey(c) && sfreq.get(c).intValue() <= pfreq.get(c).intValue() ){
                matched++;
            }

            while(matched == p.length()){
                if(end - start + 1 < minlen){
                    minlen = end - start + 1;
                    winst = start;
                }

                char sc = s.charAt(start);
                start++;

                if(pfreq.containsKey(sc)){
                    if(sfreq.get(sc).intValue() <= pfreq.get(sc).intValue()){
                        matched--;
                    }
                    sfreq.put(sc,sfreq.get(sc) - 1);
                }
            }
        }

        return minlen == Integer.MAX_VALUE ? "-1" : s.substring(winst , winst+minlen );


    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc"));
    }
}
