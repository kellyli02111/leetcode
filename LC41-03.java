// time: O(n)
// space: O(1)
// use array index as hash index, +/- to indicate the presence of the number

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }
            if (nums[i] >= nums.length + 1 || nums[i] < 1) {
                nums[i] = 1;
            }
        }
        if (!hasOne) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int hashIndex = Math.abs(nums[i]) - 1;
            if (nums[hashIndex] > 0) {
                nums[hashIndex] = - nums[hashIndex];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }                    
        return nums.length + 1;
    }
}
