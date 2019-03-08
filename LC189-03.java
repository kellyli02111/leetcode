//time: O(n)
//space: O(1)
// reverse two sections separately, then reverse the entire array

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        reverseArray(nums, 0, nums.length - k - 1);
        reverseArray(nums, nums.length - k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
        
    }

    public void reverseArray(int[] nums, int index1, int index2) {
        for (int i = 0; i < (index2 - index1 + 1) / 2; i++) {
            int temp = nums[i + index1];
            nums[i + index1] = nums[index2 - i];
            nums[index2 - i] = temp;
        }
    }
    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
