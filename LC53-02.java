// O(n^2)

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                max = sum > max ? sum : max;
            }
        }
        return max;
    }
}
