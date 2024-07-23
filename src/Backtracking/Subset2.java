package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Subset2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, current, result);
        return result;
    }

    public static void subsetsWithDup(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            subsetsWithDup(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
