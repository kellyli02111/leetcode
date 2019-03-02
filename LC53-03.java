// O(n)

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            // local代表：以i为结尾的subarray的最大和为：
            // 如果以i-1为结尾的subarray的最大和为负数，那么结果为nums[i]本身
            // 如果为正数，结果为(以i-1为结尾的subarray的最大和 + nums[i])
            local = Math.max(local + nums[i], nums[i]);
            // local = local < 0 : nums[i] : local + nums[i];
            global = Math.max(local, global);
        }
        return global;
    }
}
