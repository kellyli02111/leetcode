//O(n)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int first = 0;
        int last = nums.length - 1;
        while (first < last && nums[first] < target) {
            first++;
        }
        
        if (nums[first] == target) {
            result[0] = first;
        }
        else {
            return result;
        }
        while (last >= 0 && nums[last] > target) {
            last--;
        }
        if (nums[last] == target) {
            result[1] = last;
        }
        return result;
    }
}
