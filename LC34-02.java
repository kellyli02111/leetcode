//O(log(n))
//binary search

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        // find first
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid ;
            }
        }
        if (nums[start] == target) {
            result[0] = start;
        }
        else {
            return result;
        }
        
        // find last
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start +1) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            result[1] = end;
        }
        
        return result;
    }
}
