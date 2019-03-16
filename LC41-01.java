// time: O(nlogn)
// space: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int positive = 1;
        if (nums.length == 0) {
            return positive;
        }
        Arrays.sort(nums);
        int start = 0;
        while (start < nums.length && nums[start] <= 0) {
            start++;
        }
        if (start >= nums.length || nums[start] > 1) {
            return positive;
        }
        start++;
        if (start >= nums.length) {
            return nums[start - 1] + 1;
        }
        positive = nums[nums.length - 1] + 1;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                positive = nums[i - 1] + 1;
                break;
            }
        }
        return positive;
    }
}
