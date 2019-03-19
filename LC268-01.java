// O(n)

class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int expectedSum = nums.length * (nums.length + 1 ) / 2;
        for (int i = 0; i < nums.length; i++) {
            expectedSum -= nums[i];
        }
        return expectedSum;
    }
}
