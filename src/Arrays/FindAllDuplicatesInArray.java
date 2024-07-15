package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        int len=nums.length+1;
        List<Integer> ans=new ArrayList<>();
        int[] count=new int[len+1];

        for(int n : nums){
            count[n]++;
            if (count[n] > 1)
                ans.add(n);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }


}
