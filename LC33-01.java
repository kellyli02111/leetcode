// O(log(n))

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                if (nums[start] < nums[end]) {
                    end = mid;
                }
                else {
                    if (nums[start] > target) {
                        if (nums[mid] > nums[start]) {
                            start = mid;
                        }
                        else {
                            end = mid;
                        }
                    } 
                    else {
                        end = mid;
                    }
                }
            }
            else {
                if (nums[start] < nums[end]) {
                    start = mid;
                }
                else {
                    if (nums[end] < target) {
                        if (nums[mid] < nums[end]) {
                            end = mid;
                        }
                        else {
                            start = mid;
                        }
                    } 
                    else {
                        start = mid;
                    }
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        else if (nums[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}
