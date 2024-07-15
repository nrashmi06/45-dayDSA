package Arrays;

public class ReversePair {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int s, int e) {
        int ans = 0;
        if (s < e) {
            int mid = s + (e - s) / 2;
            ans += mergeSort(nums, s, mid);
            ans += mergeSort(nums, mid + 1, e);
            ans += merge(nums, s, mid, e);
        }
        return ans;
    }

    public static int merge(int[] nums, int s, int mid, int e) {
        int i = s, j = mid + 1;
        int[] temp = new int[e - s + 1];
        int ans = 0;

        // Counting the reverse pairs
        // what it does is that it counts the number of pairs that are reverse and then adds it to the answer
        //it doesn't add repetitive pairs because the array is sorted
        for (i = s; i <= mid; i++) {
            while (j <= e && nums[i] > 2L * nums[j]) {
                j++;
            }
            ans += (j - (mid + 1));
        }

        // Resetting pointers to merge the two halves
        i = s;
        j = mid + 1;
        int k = 0;

        // Merging the two halves
        while (i <= mid && j <= e) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= e) {
            temp[k++] = nums[j++];
        }

        // Copy the sorted elements back into the original array
        for (int idx = 0; idx < temp.length; idx++) {
            nums[s + idx] = temp[idx];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        System.out.println("Number of reverse pairs: " + reversePairs(nums));  // Output: 3
    }
}
