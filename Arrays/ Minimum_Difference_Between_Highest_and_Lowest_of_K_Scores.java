import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1 || k > nums.length) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = k-1; i < nums.length; i++) {
            int diff = nums[i] - nums[i-k+1];
            ans = Math.min(ans, diff);
        }
        return ans;
    }
}