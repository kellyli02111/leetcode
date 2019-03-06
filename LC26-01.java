//O(n^2)

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int start = 0;
        int next = start + 1;
        int move = next;
        int end = nums[nums.length - 1];
        while (move < nums.length && nums[start] < end) {
            if (nums[next] <= nums[start]) {
                
                while (move < nums.length && nums[move] <= nums[start]) {
                    move++;
                }
                if (move < nums.length) {
                    int temp = nums[next];
                    nums[next] = nums[move];
                    nums[move] = temp;
                }
            }
            start++;
            next = start + 1;
            move = next;
        }
        return next;
    }
}
