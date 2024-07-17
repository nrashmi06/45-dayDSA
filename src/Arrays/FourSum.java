package Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        ans.add(quad);

                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;

                        c++;
                        d--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
