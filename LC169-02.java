//O(n)
//Boyer-Moore majority voting algorithm

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                current = nums[i];
                count = 1;
            }
        }
        return current;
    }
}
