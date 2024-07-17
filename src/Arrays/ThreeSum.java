package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3){
            return result ;
        }

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++){
            int l = i+1 , r = nums.length - 1;

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while(l < r){
                int ThreeSum = 0;
                ThreeSum = nums[i] + nums[l] + nums[r];
                if(ThreeSum > 0){
                    r -= 1 ;
                }
                else if(ThreeSum < 0 ){
                    l += 1 ;
                }
                else{
                    result.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    l += 1;
                    while(nums[l] == nums[l -1] && l < r){
                        l += 1 ;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
