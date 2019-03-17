// backtrack
// time limit exceeded

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        return canJumpDFSHelper(nums, 0, nums[0]);
    }
    public boolean canJumpDFSHelper(int[] nums, int start, int step) {
        boolean canJump = false;
        if (start + step >= nums.length - 1) {
            return true;
        }
        if (step == 0) {
            canJump = false;
        }
        for (int n = step; n > 0; n--) {
            canJump = canJumpDFSHelper(nums, start + n, nums[start + n]);
            if (canJump) {
                return canJump;
            }
        }
        return canJump;
    }
}
