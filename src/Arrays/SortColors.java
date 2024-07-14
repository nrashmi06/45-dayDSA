package Arrays;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);
        countMap.put(1, 0);
        countMap.put(2, 0);

        for (int num : nums) {
            countMap.put(num, countMap.get(num) + 1);
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (countMap.get(i) > 0) {
                nums[index++] = i;
                countMap.put(i, countMap.get(i) - 1);
            }
        }
    }
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
