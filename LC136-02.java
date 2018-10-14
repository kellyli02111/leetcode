// time: O(n)
// space: O(1)


class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++)
        {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
