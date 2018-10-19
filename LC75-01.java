// time: O(n)
// two pass
// space: O(1)


class Solution {
    public void sortColors(int[] nums) {
        if (nums.length > 0)
        {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0,0);
            map.put(1,0);
            map.put(2,0);
            for (int i = 0; i < nums.length; i++)
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            for (int red = 0; red < map.get(0); red++)
            {
                nums[red] = 0;
            }            
            for (int white = map.get(0); white < map.get(0) + map.get(1); white++)
            {
                nums[white] = 1;
            }
            for (int blue = map.get(0) + map.get(1); blue < map.get(0) + map.get(1) + map.get(2); blue++)
            {
                nums[blue] = 2;
            }
        }
        
    }
}
