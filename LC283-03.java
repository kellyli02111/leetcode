// time : O(n)
// space: O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        result[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int lastRight = nums[nums.length - 1];
        int right = nums[nums.length - 1];
        nums[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            lastRight = right;
            right = nums[i];
            nums[i] = nums[i + 1] * lastRight;
            result[i] *= nums[i];
        }
        return result;
    }
}
