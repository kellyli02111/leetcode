// time: O(n)
// space: O(1)
// same method as LC283

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int j = 0;
        int counter = nums.length;
        for (int i = j; i < nums.length; i++)
        {
            if (nums[i] != val)
            {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            else
                counter--;
        } 
        return counter;
    }
}
