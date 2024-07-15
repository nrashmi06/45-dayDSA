package Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int count = 0 ;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;

            }
            else{
                count++;
            }
        }
        j = nums.length;
        while(count > 0){
            nums[j - 1] = 0;
            count-- ;
            j--;
        }
        return ;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
