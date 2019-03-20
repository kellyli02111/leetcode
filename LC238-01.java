// time: O(n^2)
// time limit exceeded

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            
            result[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }
}
