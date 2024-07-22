package Strings;

public class FirstOccurance {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(m>n){
            return -1;
        }
        for(int i=0; i<=n-m;i++){
            int j=0;
            while(j<m && haystack.charAt(i+j) == needle.charAt(j))
                j++;
            if(j==m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccurance obj = new FirstOccurance();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(obj.strStr(haystack, needle));
    }
}
