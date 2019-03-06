//O(log(n))

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }    
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // System.out.println("start=" + start + " end=" + end + " mid=" + mid);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            // System.out.println("start=" + start + " end=" + end + " mid=" + mid);
        }
        
        if (end >= 0 && nums[end] >= target) {
            return end;
        }
        else {
            return end + 1;
        }
    }
}
