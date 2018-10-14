// time: O(n)
// space: O(n)

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int singleNumber = 0;
        for (Integer key : map.keySet()) 
        {
            if (map.get(key) == 1)
            {
                singleNumber = key;  
                break;
            }
        }
        return singleNumber;
    }
}
