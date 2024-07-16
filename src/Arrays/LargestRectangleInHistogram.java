package Arrays;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length ,i = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(i=0;i<n;i++){
            int num = heights[i];
            while(st.size()>0 && heights[st.peek()]>= num )
                st.pop();

            if(st.size()==0){
                left[i]=0;
                st.push(i);
            }else{
                left[i]= st.peek()+1;
                st.push(i);
            }
        }
        st.clear();
        for(i=n-1;i>=0;i--){
            int num = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=num )
                st.pop();

            if(st.isEmpty()){
                right[i]=n-1;
                st.push(i);
            }else{
                right[i]= st.peek()-1;
                st.push(i);
            }

        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            long add = (long) (right[j] - left[j] + 1) * heights[j];
            ans = Math.max(ans, add);
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
