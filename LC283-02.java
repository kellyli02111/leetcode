// O(n)

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1)
        {
            int j = 0;
            for (int i = ; i < nums.length; i++)
            {
                if (nums[i] != 0)
                {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
            } 
        }        
    }
}
