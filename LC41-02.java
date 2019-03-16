// time: O(n)
// space: O(n)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int positive = 1;
        if (nums.length == 0) {
            return positive;
        }
        boolean hasOne = false;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (!hasOne) {
            return positive;
        }
        positive = max;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && !set.contains(nums[i] + 1) && nums[i] < positive) {
                positive = nums[i];
            }
        }
        return positive + 1;
    }
}
