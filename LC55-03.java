// time: O(n)
// DP?

class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(maxIndex < i) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(maxIndex >= n - 1) return true;
        }
        return false;
    }
}
