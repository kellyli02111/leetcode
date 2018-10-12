// O(n^2)

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1)
        {
            for (int i = 0; i < nums.length-1; i++)
            {
                for (int j = i+1; j < nums.length; j++)
                {
                    if (nums[i] == 0 && nums[i] != nums[j])
                    {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            } 
        }        
    }
}
