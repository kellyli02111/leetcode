// time: O(n)
// space: O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length < 2)
            return result;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
