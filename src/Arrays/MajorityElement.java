package Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        return helper(nums, 0, nums[0]);
    }
    public static int helper(int[] nums, int start, int target)
    {
        int count=0;
        for(int i=start; i<nums.length; i++)
        {
            if(nums[i]==target) count++;
            else count--;

            if(count==-1) return helper(nums, i, nums[i]);
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
