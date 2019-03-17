// time: O(n^2)

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int last = nums.length - 1;
        int current = 0;
        while (last > 0) {
            current = 0;
            while (current < last) {
                if (nums[current] >= last) {
                    break;
                }
                else {
                    current++;
                }
            }
            if (current == last && last > 0) {
                return false;
            }
            else {
                last = current;
            }
        }
        return true;
    }
}
