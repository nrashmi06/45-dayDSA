package Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxProduct = 0 ;
        int n = height.length -1 ;
        int i = 0 , j = n;
        while(i < j){
            maxProduct = Math.max(maxProduct , Math.min(height[i],height[j]) * (j -i));
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
