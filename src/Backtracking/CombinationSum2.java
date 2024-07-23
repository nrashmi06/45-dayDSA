package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tempList, int[] arr, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            tempList.add(arr[i]);
            helper(res, tempList, arr, target, sum + arr[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }
}

