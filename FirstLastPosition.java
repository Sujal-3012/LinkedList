import java.util.Arrays;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int in1 =  linear_search(nums , target);
        int in2 = in1;
        for(int i = in1 + 1 ; i < nums.length ; i++){
            if(nums[i] == target){
                in2++;
            }
        }
        int[] arr = {in1 , in2};
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    
    public int linear_search(int [] arr , int target){
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
