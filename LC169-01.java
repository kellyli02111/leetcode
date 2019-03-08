//O(n)

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }
}
