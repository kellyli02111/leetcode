// time: O(n)
// space: O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            rightProduct[j] = rightProduct[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < nums.length; k++) {
            result[k] = leftProduct[k] * rightProduct[k];
        }
        return result;
    }
}
