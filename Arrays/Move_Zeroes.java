class Solution {
    public void moveZeroesUsingSwapping(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
    }
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while(j < nums.length) {
            nums[j++] = 0;
        }
    }
}

