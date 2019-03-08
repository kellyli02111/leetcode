//O(n*k)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k < 0) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        for (int step = 0; step < nums.length - k; step++) {
            for (int i = 0; i < nums.length - 1; i++) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;

            }
        }
    }
    public void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
