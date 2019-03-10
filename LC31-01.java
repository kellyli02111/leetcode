// time: O(n)
// space: O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int end = nums.length - 1;
        int start = end;
        while (start >= 0) {
            start = end - 1;
            if (nums[start] < nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                break;
            }
            while (start >= 0 && nums[start] >= nums[start + 1]) {
                start--;
            }
            if (start < 0) {
                reverseArray(nums, start + 1, end);
            }
            else {
                int search = start + 1;
                while (search <= end) {
                    if (nums[search] <= nums[start]) {
                        break;
                    }
                    else {
                        search++;
                    }
                }
                int temp = nums[search - 1];
                nums[search - 1] = nums[start];
                nums[start] = temp;
                reverseArray(nums, start + 1, end);
                break;
            }
        }
    }
    public void reverseArray(int[] nums, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}
