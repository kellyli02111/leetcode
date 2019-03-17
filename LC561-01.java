// time: O(nlogn)

class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
