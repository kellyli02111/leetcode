// O(n^3)

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i; j < nums.length; j++)
            {
                int sum = 0;
                for (int k = i; k <= j; k++)
                {
                    sum += nums[k];
                }
                max = sum > max ? sum : max;
            }
        }
        return max;
    }
}
